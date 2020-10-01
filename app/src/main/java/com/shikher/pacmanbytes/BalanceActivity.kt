package com.shikher.pacmanbytes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.shikher.pacmanbytes.AccountTabs.ReceivedTransactionFragment
import com.shikher.pacmanbytes.AccountTabs.SentTransactionFragment
import com.shikher.pacmanbytes.Adapters.TabLayoutAdapter
import kotlinx.android.synthetic.main.activity_payment.*

class BalanceActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private val tab1Fragment = SentTransactionFragment()
    private val tab2Fragment = ReceivedTransactionFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        intiView()
    }

    private fun intiView() {
        val setupViewPager = SetupViewPager(viewPager)
        paymentTabLayout.addOnTabSelectedListener(this)
        paymentTabLayout.setupWithViewPager(setupViewPager)
    }

    private fun SetupViewPager(viewPager: ViewPager): ViewPager {
        val adapter = TabLayoutAdapter(supportFragmentManager)
        adapter.addFragment(tab1Fragment, "Sent")
        adapter.addFragment(tab2Fragment, "Received")
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