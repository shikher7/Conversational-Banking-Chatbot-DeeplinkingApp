package com.shikher.pacmanbytes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_review_payment_acitivity.*

class ReviewPaymentAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_payment_acitivity)
        buttonPayment.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({

            relativeLayout.visibility= View.GONE
                successLayout.visibility=View.VISIBLE
                check.check();
                Handler().postDelayed({
                    finishAffinity()
                },3000)
            }, 500)
        }
    }
}