package com.shikher.pacmanbytes

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_review_payment_acitivity.*

class ReviewPaymentAcitivity : AppCompatActivity() {

    private var toAccountType: String? = ""
    private var toAccount: String? = ""
    private var toName: String? = ""
    private var ACCOUNT_NO: String? = ""
    private var ACCOUNT_TYPE: String? = ""
    private var TRANSACTION_AMT: String? = ""
    private var TRANSACTION_TYPE: String? = ""
    private var FROM_UPI_CONTACT: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_payment_acitivity)
        initView()

    }

    private fun initView() {
        toAccountType = intent.getStringExtra("toAccountType")
        toAccount = intent.getStringExtra("toAccount")
        toName = intent.getStringExtra("toName")
        ACCOUNT_NO = intent.getStringExtra("fromAccount")
        ACCOUNT_TYPE = intent.getStringExtra("fromAccountType")
        TRANSACTION_AMT = intent.getStringExtra("TRANSACTION_AMT")
        TRANSACTION_TYPE = intent.getStringExtra("TRANSACTION_TYPE")
        FROM_UPI_CONTACT = intent.getStringExtra("FROM_UPI_CONTACT")
        fromAccountType.text = ACCOUNT_TYPE
        fromAccount.text = ACCOUNT_NO
        toAccountTypeTextView.text = toAccountType
        toAccountTextView.text = toAccount
        toNameTextView.text = toName
        amountTextView.text="$TRANSACTION_TYPE $TRANSACTION_AMT"
        fromUPIID.text = FROM_UPI_CONTACT
        buttonPayment.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({

                scrollView.visibility = View.GONE
                successLayout.visibility = View.VISIBLE
                check.check();
                Handler().postDelayed({
                    finishAffinity()
                }, 3000)
            }, 500)
        }
    }
}