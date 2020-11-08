package com.shikher.pacmanbytes.PaymentTabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shikher.pacmanbytes.Adapters.ContactAdapter
import com.shikher.pacmanbytes.Model.ContactModel
import com.shikher.pacmanbytes.R
import kotlinx.android.synthetic.main.fragment_payement_tab1.*


class PaymentTab1Fragment : Fragment() {
    val contact1 = ContactModel("Alice","8462876489","alice@upi.com","22")
    val contact2 = ContactModel("Harry","7804678095","harry@upi.com","22")
    val contact3 = ContactModel("John","9649876120","john@upi.com","22")
    val contact4 = ContactModel("Samantha","8094567837","samantha@upi.com","22")
    val contact5 = ContactModel("Peter","9123409876","peter@upi.com","22")
    val contact6 = ContactModel("Mary","8765381243","mary@upi.com","22")
    val contact7 = ContactModel("Ryan","79654123445","ryan@upi.com","22")
    val contact8 = ContactModel("Bruce","8976538590","bruce@upi.com","22")

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
        contactArray?.add(contact4)
        contactArray?.add(contact5)
        contactArray?.add(contact6)
        contactArray?.add(contact7)
        contactArray?.add(contact8)

        Log.d("1234","{${contactArray!![1].name} ,${contactArray!![2].phone} ,${contactArray!![0].account} ,${contactArray.toString()}}")
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        contactRecyclerView?.layoutManager = llm
        contactRecyclerView?.setHasFixedSize(true)
        val contactListAdapter = ContactAdapter(this.activity!!, contactArray!!)
        contactRecyclerView.apply {
            adapter = contactListAdapter

        }
    }


}


