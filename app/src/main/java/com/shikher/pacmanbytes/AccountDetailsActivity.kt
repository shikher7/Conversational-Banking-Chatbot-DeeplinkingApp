package com.shikher.pacmanbytes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.airbnb.deeplinkdispatch.DeepLink
import com.google.android.material.tabs.TabLayout
import com.shikher.pacmanbytes.AccountTabs.AccountInfoFragment
import com.shikher.pacmanbytes.AccountTabs.TransactionListFragment
import com.shikher.pacmanbytes.Adapters.TabLayoutAdapter
import kotlinx.android.synthetic.main.activity_balance.*
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_payment.paymentTabLayout
import kotlinx.android.synthetic.main.activity_payment.textView4
import kotlinx.android.synthetic.main.activity_payment.viewPager

class AccountDetailsActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private val tab1Fragment = TransactionListFragment()
    private val tab2Fragment = AccountInfoFragment()
    private var  id:String? =""
    private var  accessCode:String? =""
    private var  amount:String? =""
    private var  type:String? =""
    private var  fromAccount:String? =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        intiView()
    }

    private fun intiView() {
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val parameters = intent.extras
            id = parameters!!.getString("id")
//            accessCode = parameters!!.getString("accessCode")
//            amount = parameters!!.getString("amount")
//            type = parameters!!.getString("type")
//            fromAccount = parameters!!.getString("fromAccount")
        }
        textView4.setText(id)
        val setupViewPager = SetupViewPager(viewPager)
        paymentTabLayout.addOnTabSelectedListener(this)
        paymentTabLayout.setupWithViewPager(setupViewPager)
    }

    private fun SetupViewPager(viewPager: ViewPager): ViewPager {
        val adapter = TabLayoutAdapter(supportFragmentManager)
        adapter.addFragment(tab1Fragment, "Transactions")
        adapter.addFragment(tab2Fragment, "Account Info")
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