package com.shikher.pacmanbytes.AccountTabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shikher.pacmanbytes.AccountDetailsActivity
import com.shikher.pacmanbytes.AccountListActivity
import com.shikher.pacmanbytes.Adapters.TransactionRecyclerViewAdapter
import com.shikher.pacmanbytes.Model.TransactionModel
import com.shikher.pacmanbytes.PaymentActivity
import com.shikher.pacmanbytes.R
import kotlinx.android.synthetic.main.fragment_payement_tab1.*

class TransactionListFragment: Fragment(){
    private var transactionArray: ArrayList<TransactionModel>? =ArrayList<TransactionModel>()
    private var transactionArray2: ArrayList<TransactionModel>? =ArrayList<TransactionModel>()

    val transaction1 = TransactionModel("10938205","2020-07-16 00:00:01","490581","Lorem ipsum dolor","100","INR","38650","INR","1","Lorem ipsum dolor","FOOD")
    val transaction2 = TransactionModel("11507749","2020-05-26 00:00:01","555255","Lorem ipsum dolor","1500","INR","47000","INR","0","Lorem ipsum dolor","")
    val transaction3 = TransactionModel("12379863","2020-08-16 00:00:01","490581","Lorem ipsum dolor","2100","INR","27650","INR","1","Lorem ipsum dolor","SHOPPING")
    val transaction4 = TransactionModel("13200004","2020-06-08 00:00:01","118483","Lorem ipsum dolor","1000","INR","102400","INR","1","Lorem ipsum dolor","UTILITIES")
    val transaction5 = TransactionModel("15388567","2020-06-14 00:00:01","269719","Lorem ipsum dolor","250","INR","8400","INR","1","Lorem ipsum dolor","FOOD")
    val transaction6 = TransactionModel("20757223","2020-05-22 00:00:01","269719","Lorem ipsum dolor","300","INR","11150","INR","1","Lorem ipsum dolor","FOOD")
    val transaction7 = TransactionModel("21483543","2020-08-05 00:00:01","490581","Lorem ipsum dolor","13000","INR","25650","INR","0","Lorem ipsum dolor","")
    val transaction8 = TransactionModel("21551290","2020-07-12 00:00:01","490581","Lorem ipsum dolor","2500","INR","38950","INR","0","Lorem ipsum dolor","")
    val transaction9 = TransactionModel("23054689","2020-07-16 00:00:01","490581","Lorem ipsum dolor","1567","INR","31117","INR","1","Lorem ipsum dolor","FOOD")
    val transaction10 = TransactionModel("27015965","2020-06-26 00:00:01","555255","Lorem ipsum dolor","1500","INR","48500","INR","0","Lorem ipsum dolor","")
    val transaction11 = TransactionModel("29034231","2020-05-28 00:00:01","118483","Lorem ipsum dolor","100","INR","103400","INR","1","Lorem ipsum dolor","FOOD")
    val transaction12 = TransactionModel("30156479","2020-06-02 00:00:01","538409","Lorem ipsum dolor","1500","INR","10550","INR","1","Lorem ipsum dolor","ENTEMT")
    val transaction13 = TransactionModel("43403436","2020-05-26 00:00:01","538409","Lorem ipsum dolor","1000","INR","12050","INR","1","Lorem ipsum dolor","UTILITIES")
    val transaction14 = TransactionModel("43740654","2020-05-13 00:00:01","538409","Lorem ipsum dolor","400","INR","13350","INR","1","Lorem ipsum dolor","FOOD")
    val transaction15 = TransactionModel("52230909","2020-07-12 00:00:01","118483","Lorem ipsum dolor","2500","INR","8400","INR","1","Lorem ipsum dolor","CREDIT BILL")
    val transaction16 = TransactionModel("57419762","2020-07-16 00:00:01","490581","Lorem ipsum dolor","200","INR","38750","INR","1","Lorem ipsum dolor","ENTEMT")
    val transaction17 = TransactionModel("61251110","2020-06-02 00:00:01","269719","Lorem ipsum dolor","1500","INR","8650","INR","1","Lorem ipsum dolor","UTILITIES")
    val transaction18 = TransactionModel("61301278","2020-06-18 00:00:01","118483","Lorem ipsum dolor","1500","INR","100900","INR","1","Lorem ipsum dolor","ENTEMT")
    val transaction19 = TransactionModel("71308795","2020-05-22 00:00:01","538409","Lorem ipsum dolor","300","INR","13050","INR","1","Lorem ipsum dolor","FOOD")
    val transaction20 = TransactionModel("72397440","2020-07-26 00:00:01","555255","Lorem ipsum dolor","1500","INR","50000","INR","0","Lorem ipsum dolor","")
    val transaction21 = TransactionModel("72690872","2020-05-13 00:00:01","269719","Lorem ipsum dolor","400","INR","11450","INR","1","Lorem ipsum dolor","UTILITIES")
    val transaction22 = TransactionModel("75234883","2020-07-16 00:00:01","490581","Lorem ipsum dolor","1500","INR","29550","INR","1","Lorem ipsum dolor","UTILITIES")
    val transaction23 = TransactionModel("77844018","2020-07-16 00:00:01","490581","Lorem ipsum dolor","400","INR","28050","INR","1","Lorem ipsum dolor","ENTEMT")
    val transaction24 = TransactionModel("85917595","2020-05-19 00:00:01","118483","Lorem ipsum dolor","500","INR","103500","INR","1","Lorem ipsum dolor","SHOPPING")
    val transaction25 = TransactionModel("88196862","2020-05-26 00:00:01","269719","Lorem ipsum dolor","1000","INR","10150","INR","1","Lorem ipsum dolor","SHOPPING")
    val transaction26 = TransactionModel("95673690","2020-07-16 00:00:01","118483","Lorem ipsum dolor","1600","INR","100000","INR","0","Lorem ipsum dolor","")
    val transaction27 = TransactionModel("98979320","2020-06-14 00:00:01","538409","Lorem ipsum dolor","550","INR","10000","INR","1","Lorem ipsum dolor","SHOPPING")





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payement_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        transactionArray?.add(transaction1)
        transactionArray?.add(transaction2)
        transactionArray?.add(transaction3)
        transactionArray?.add(transaction4)
        transactionArray?.add(transaction5)
        transactionArray?.add(transaction6)
        transactionArray?.add(transaction7)
        transactionArray?.add(transaction8)
        transactionArray?.add(transaction9)
        transactionArray?.add(transaction10)
        transactionArray?.add(transaction11)
        transactionArray?.add(transaction12)
        transactionArray?.add(transaction13)
        transactionArray?.add(transaction14)
        transactionArray?.add(transaction15)
        transactionArray?.add(transaction16)
        transactionArray?.add(transaction17)
        transactionArray?.add(transaction18)
        transactionArray?.add(transaction19)
        transactionArray?.add(transaction20)
        transactionArray?.add(transaction21)
        transactionArray?.add(transaction22)
        transactionArray?.add(transaction23)
        transactionArray?.add(transaction24)
        transactionArray?.add(transaction25)
        transactionArray?.add(transaction26)
        transactionArray?.add(transaction27)
        val accno= (context as AccountDetailsActivity).getAccountNo()
        for( transaction in transactionArray!!)
            if(transaction.ACCOUNT_NO==accno)
                transactionArray2?.add(transaction)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        contactRecyclerView?.layoutManager = llm
        contactRecyclerView?.setHasFixedSize(true)
        val contactListAdapter = TransactionRecyclerViewAdapter(this.activity!!, transactionArray2!!)
        contactRecyclerView.apply {
            adapter = contactListAdapter

        }
    }

}
