package com.shikher.pacmanbytes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.airbnb.deeplinkdispatch.DeepLink
import com.google.android.material.tabs.TabLayout
import com.shikher.pacmanbytes.Adapters.TabLayoutAdapter
import com.shikher.pacmanbytes.PaymentTabs.PaymentTab1Fragment
import com.shikher.pacmanbytes.PaymentTabs.PaymentTab2Fragment
import kotlinx.android.synthetic.main.activity_payment.*


@DeepLink("https://www.pacmanbytes.com/payment")
class PaymentActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private val tab1Fragment = PaymentTab1Fragment()
    private val tab2Fragment = PaymentTab2Fragment()
    private var  ACCESS_TOKEN:String? =""
    private var  CIN:String? =""
    private var  ACCOUNT_NO:String? =""
    private var  ACCOUNT_TYPE:String? =""
    private var  TRANSACTION_AMT:String? =""
    private var  TRANSACTION_CRY:String? =""
    private var  TRANSACTION_TYPE:String? =""
    private var  FROM_UPI_CONTACT:String? =""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        intiView()
    }

    private fun intiView() {
        val intent = intent
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val parameters = intent.extras
            ACCESS_TOKEN = parameters!!.getString("ACCESS_TOKEN")
            CIN = parameters!!.getString("CIN")
            ACCOUNT_NO = parameters!!.getString("ACCOUNT_NO")
            ACCOUNT_TYPE = parameters!!.getString("ACCOUNT_TYPE")
            TRANSACTION_AMT = parameters!!.getString("TRANSACTION_AMT")
            TRANSACTION_CRY = parameters!!.getString("TRANSACTION_CRY")
            TRANSACTION_TYPE = parameters!!.getString("TRANSACTION_TYPE")
            FROM_UPI_CONTACT = parameters!!.getString("FROM_UPI_CONTACT")
        }
        sendAmountEditText.setText(TRANSACTION_AMT)
        if(TRANSACTION_CRY=="INR")
        sendAmountEditText.prefix="₹"
        val setupViewPager = SetupViewPager(viewPager)
        paymentTabLayout.addOnTabSelectedListener(this)
        paymentTabLayout.setupWithViewPager(setupViewPager)
    }

    fun onClickCalled(toAccountType:String, toAccount:String, toName: String ) {
        val intent = Intent(this, ReviewPaymentAcitivity::class.java)
        intent.putExtra("toAccountType",toAccountType)
        intent.putExtra("toAccount",toAccount)
        intent.putExtra("toName",toName)
        intent.putExtra("fromAccountType",ACCOUNT_NO)
        intent.putExtra("fromAccount",ACCOUNT_TYPE)
        intent.putExtra("TRANSACTION_AMT",TRANSACTION_AMT)
        intent.putExtra("TRANSACTION_TYPE",sendAmountEditText.prefix)
        intent.putExtra("FROM_UPI_CONTACT",FROM_UPI_CONTACT)
        startActivity(intent)    }

    private fun SetupViewPager(viewPager: ViewPager): ViewPager {
        val adapter = TabLayoutAdapter(supportFragmentManager)
        adapter.addFragment(tab1Fragment, "UPI Transfer")
//        adapter.addFragment(tab2Fragment, "Bank Transfer")
        viewPager.adapter = adapter
        return viewPager
    }


    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}


