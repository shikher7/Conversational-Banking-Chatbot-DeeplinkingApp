package com.shikher.pacmanbytes.Adapters;

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shikher.pacmanbytes.Model.ContactModel
import com.shikher.pacmanbytes.PaymentActivity
import com.shikher.pacmanbytes.R
import com.shikher.pacmanbytes.ReviewPaymentAcitivity
import kotlinx.android.synthetic.main.layout_item_contact.view.*


class ContactAdapter(private val context: Context, private val items: ArrayList<ContactModel>):RecyclerView.Adapter<ContactAdapter.ContactListViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactListViewHolder(
        LayoutInflater.from(context).inflate(R.layout.layout_item_contact, parent, false)
    )

    override fun getItemCount(): Int {
        return items.size
    }

    class ContactListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.contact_name!!
        val phone = itemView.contact_phone!!
        val account = itemView.contact_account!!
        val layout = itemView.itemContactLayout!!
    }


    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int)
    {
        if(items[position].name.isNotEmpty())
            holder.name.text = items[position].name
        if(items[position].phone.isNotEmpty())
            holder.phone.text = items[position].phone
        if(items[position].account.isNotEmpty())
            holder.account.text = items[position].account
        holder.layout.setOnClickListener {
            (context as PaymentActivity).onClickCalled("UPI Payment",items[position].account,items[position].name)

        }
    }

}

