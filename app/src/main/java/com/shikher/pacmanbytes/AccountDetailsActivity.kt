package com.shikher.pacmanbytes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.airbnb.deeplinkdispatch.DeepLink
import com.google.android.material.tabs.TabLayout
import com.shikher.pacmanbytes.AccountTabs.AccountInfoFragment
import com.shikher.pacmanbytes.AccountTabs.TransactionListFragment
import com.shikher.pacmanbytes.Adapters.TabLayoutAdapter
import kotlinx.android.synthetic.main.activity_balance.*
import kotlinx.android.synthetic.main.activity_payment.paymentTabLayout
import kotlinx.android.synthetic.main.activity_payment.viewPager

@DeepLink("https://www.pacmanbytes.com/account_details")
class AccountDetailsActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private val tab1Fragment = TransactionListFragment()
    private val tab2Fragment = AccountInfoFragment()
    private var ACCESS_TOKEN:String?=""
    private var ACCOUNT_TYPE:String?=""
    private var CIN:String?=""
    private var ACCOUNT_NO_DEEPLINK:String?=""
    private var BALANCE:String?=""
    private var CURRENCY:String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        intiView()
    }

    private fun intiView() {
        Log.d("Deeplink",intent.extras.toString())
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val parameters = intent.extras
            ACCESS_TOKEN = parameters!!.getString("ACCESS_TOKEN")
            CIN = parameters!!.getString("CIN")
            ACCOUNT_NO_DEEPLINK = parameters!!.getString("ACCOUNT_NO")
            ACCOUNT_TYPE = parameters!!.getString("ACCOUNT_TYPE")
            BALANCE = parameters!!.getString("BALANCE")
            BALANCE = parameters!!.getString("BALANCE")
            balanceTextViewDetails.setText("₹ $BALANCE")
            fromAccountCIN.text = "CIN: $CIN"
            fromAccountDetails.text = "$ACCOUNT_TYPE: $ACCOUNT_NO_DEEPLINK"

        }

        val setupViewPager = SetupViewPager(viewPager)
        paymentTabLayout.addOnTabSelectedListener(this)
        paymentTabLayout.setupWithViewPager(setupViewPager)
    }

    private fun SetupViewPager(viewPager: ViewPager): ViewPager {
        val adapter = TabLayoutAdapter(supportFragmentManager)
        adapter.addFragment(tab1Fragment, "Transactions")
//        adapter.addFragment(tab2Fragment, "Account Info")
        viewPager.adapter = adapter
        return viewPager
    }

    fun getAccountNo():String?
    {
        if(ACCOUNT_NO_DEEPLINK.isNullOrBlank()||ACCOUNT_NO_DEEPLINK.isNullOrEmpty())
            return "118483"
        return ACCOUNT_NO_DEEPLINK
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}