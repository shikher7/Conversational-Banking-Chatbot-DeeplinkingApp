package com.shikher.pacmanbytes

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.andrognito.pinlockview.IndicatorDots
import com.andrognito.pinlockview.PinLockListener
import com.andrognito.pinlockview.PinLockView
import com.github.pwittchen.rxbiometric.library.RxBiometric
import com.github.pwittchen.rxbiometric.library.throwable.AuthenticationError
import com.github.pwittchen.rxbiometric.library.throwable.AuthenticationFail
import com.github.pwittchen.rxbiometric.library.throwable.BiometricNotSupported
import com.github.pwittchen.rxbiometric.library.validation.RxPreconditions
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy


class LoginActivity: AppCompatActivity() {

    val TAG = "PinLockView"

    private var disposable: Disposable? = null
    private lateinit var mPinLockView: PinLockView
    private lateinit var mIndicatorDots: IndicatorDots

    private val mPinLockListener: PinLockListener = object : PinLockListener {
        override fun onComplete(pin: String) {
            Log.d(TAG, "Pin complete: $pin")
            if (pin == "1234") {
                gotoHomePage("authenticated!")
            }
        }

        override fun onEmpty() {
            Log.d(TAG, "Pin empty")
        }

        override fun onPinChange(pinLength: Int, intermediatePin: String) {
            Log.d(TAG, "Pin changed, new length $pinLength with intermediate pin $intermediatePin")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_login)
        intiView()
    }

    private fun intiView() {


        mPinLockView = findViewById(R.id.pin_lock_view)
        mIndicatorDots = findViewById(R.id.indicator_dots)

        mPinLockView.attachIndicatorDots(mIndicatorDots);
        mPinLockView.setPinLockListener(mPinLockListener);
        //mPinLockView.setCustomKeySet(new int[]{2, 3, 1, 5, 9, 6, 7, 0, 8, 4});
        //mPinLockView.enableLayoutShuffling();

        mPinLockView.setPinLength(4);
        mPinLockView.setTextColor(ContextCompat.getColor(this, R.color.black))

        mIndicatorDots.setIndicatorType(IndicatorDots.IndicatorType.FILL_WITH_ANIMATION)

    }

    private fun showMessage(message: String) {
        Toast
            .makeText(
                this,
                message,
                Toast.LENGTH_SHORT
            )
            .show()
    }

    private fun gotoHomePage(message: String) {
        val intent = Intent(this, BalanceActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()
        disposable =
            RxPreconditions
                .hasBiometricSupport(this)
                .flatMapCompletable {
                    if (!it) Completable.error(BiometricNotSupported())
                    else
                        RxBiometric
                            .title("Login using the Fingerprint")
                            .description("")
                            .negativeButtonText("Cancel")
                            .negativeButtonListener(DialogInterface.OnClickListener { _, _ ->
                                showMessage("Cancel")
                            })
                            .executor(ActivityCompat.getMainExecutor(this))
                            .build()
                            .authenticate(this)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onComplete = {
                        gotoHomePage("authenticated!")
                    },
                    onError = {
                        when (it) {
                            is AuthenticationError -> showMessage("error: ${it.errorCode} ${it.errorMessage}")
                            is AuthenticationFail -> showMessage("fail")
                            else -> {
                                showMessage("other error")
                            }
                        }
                    }
                )

    }
}
