package com.shikher.pacmanbytes.AccountTabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shikher.pacmanbytes.Adapters.ContactAdapter
import com.shikher.pacmanbytes.Adapters.TransactionRecyclerViewAdapter
import com.shikher.pacmanbytes.Model.Contact
import com.shikher.pacmanbytes.Model.TransactionModel
import com.shikher.pacmanbytes.R
import kotlinx.android.synthetic.main.fragment_payement_tab1.*

class SentTransactionFragment: Fragment() {
    val transaction1 = TransactionModel("Send","1000","UPI","KFC")
    val transaction2 = TransactionModel("Send","1000","UPI","KFC")
    val transaction3 = TransactionModel("Send","1000","UPI","KFC")
    val transaction4 = TransactionModel("Send","1000","UPI","KFC")
    val transaction5 = TransactionModel("Send","1000","UPI","KFC")
    val transaction6 = TransactionModel("Send","1000","UPI","KFC")

    private var transactionArray: ArrayList<TransactionModel>? =ArrayList<TransactionModel>()

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
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        contactRecyclerView?.layoutManager = llm
        contactRecyclerView?.setHasFixedSize(true)
        val contactListAdapter = TransactionRecyclerViewAdapter(this.activity!!, transactionArray!!)
        contactRecyclerView.apply {
            adapter = contactListAdapter

        }
    }


}
