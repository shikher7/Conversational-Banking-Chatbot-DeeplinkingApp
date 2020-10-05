package com.shikher.pacmanbytes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shikher.pacmanbytes.Adapters.AccountListRecyclerViewAdapter
import com.shikher.pacmanbytes.Model.AccountModel
import kotlinx.android.synthetic.main.activity_account_list.*
import kotlinx.android.synthetic.main.fragment_payement_tab1.*

class AccountListActivity : AppCompatActivity() {
    private val account1 = AccountModel("123","1000","Savings")
    private val account2 = AccountModel("123","12000","Credit")
    private val account3 = AccountModel("123","1000","Savings")
    private val account4 = AccountModel("123","1000","Savings")
    private val account5 = AccountModel("123","1000","Savings")
    private val account6 = AccountModel("123","1000","Savings")

    private var accountArray: ArrayList<AccountModel>? =ArrayList<AccountModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_list)
        intiView()
    }

    private fun intiView() {
        accountArray?.add(account1)
        accountArray?.add(account2)
        accountArray?.add(account3)
        accountArray?.add(account4)
        accountArray?.add(account5)
        accountArray?.add(account6)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        accountListRecyclerView?.layoutManager = llm
        accountListRecyclerView?.setHasFixedSize(true)
        val accountListAdapter = AccountListRecyclerViewAdapter(this!!, accountArray!!)
        accountListRecyclerView.apply {
            adapter = accountListAdapter

        }
    }
    }


