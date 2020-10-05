package com.shikher.pacmanbytes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.airbnb.deeplinkdispatch.DeepLink
import com.google.android.material.tabs.TabLayout
import com.shikher.pacmanbytes.Adapters.TabLayoutAdapter
import com.shikher.pacmanbytes.PaymentTabs.PaymentTab1Fragment
import com.shikher.pacmanbytes.PaymentTabs.PaymentTab2Fragment
import kotlinx.android.synthetic.main.activity_payment.*

//@DeepLink("https://pacmanbytes.com?id=skjdbgfksd&accessToken")

class PaymentActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private val tab1Fragment = PaymentTab1Fragment()
    private val tab2Fragment = PaymentTab2Fragment()
    private var  id:String? =""
    private var  accessCode:String? =""
    private var  amount:String? =""
    private var  type:String? =""
    private var  fromAccount:String? =""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        intiView()
    }

    private fun intiView() {
        val intent = intent
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


