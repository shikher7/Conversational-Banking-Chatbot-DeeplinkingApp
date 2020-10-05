package com.shikher.pacmanbytes.PaymentTabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shikher.pacmanbytes.Adapters.ContactAdapter
import com.shikher.pacmanbytes.Model.ContactModel
import com.shikher.pacmanbytes.R
import kotlinx.android.synthetic.main.fragment_payement_tab1.*


class PaymentTab2Fragment: Fragment() {
    val contact1 = ContactModel("ava","1","22","1")
    val contact2 = ContactModel("ava","1","22","2")
    val contact3 = ContactModel("ava","1","22","3")
    private var contactArray: ArrayList<ContactModel>? =ArrayList<ContactModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payement_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        contactArray?.add(contact1)
        contactArray?.add(contact2)
        contactArray?.add(contact3)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        contactRecyclerView.layoutManager = llm
        val contactListAdapter = ContactAdapter(this.activity!!, contactArray!!)
        contactRecyclerView.apply {
            adapter = contactListAdapter
        }
    }

}


