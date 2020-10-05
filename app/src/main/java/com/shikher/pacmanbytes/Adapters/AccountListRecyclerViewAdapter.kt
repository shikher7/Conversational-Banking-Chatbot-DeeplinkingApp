package com.shikher.pacmanbytes.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.shikher.pacmanbytes.AccountDetailsActivity
import com.shikher.pacmanbytes.AccountListActivity
import com.shikher.pacmanbytes.Model.AccountModel
import com.shikher.pacmanbytes.Model.ContactModel
import com.shikher.pacmanbytes.R
import kotlinx.android.synthetic.main.layout_item_account_card.view.*
import kotlinx.android.synthetic.main.layout_item_contact.view.*
import kotlinx.android.synthetic.main.layout_item_contact.view.itemContactLayout

class AccountListRecyclerViewAdapter(private val context: Context, private  val items: ArrayList<AccountModel>):
    RecyclerView.Adapter<AccountListRecyclerViewAdapter.AccountListViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AccountListViewHolder (
        LayoutInflater.from(context).inflate(R.layout.layout_item_account_card, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    class AccountListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val accountNum = itemView.accountNum!!
        val accountType = itemView.accountType!!
        val amount = itemView.amount!!
        val layout = itemView.itemAccountLayout!!
    }


    override fun onBindViewHolder(holder: AccountListViewHolder, position: Int)
    {
        if(items[position].accountNo.isNotEmpty())
            holder.accountNum.text = items[position].accountNo
        if(items[position].type.isNotEmpty())
            holder.accountType.text = items[position].type
        if(items[position].amount.isNotEmpty())
            holder.amount.text = items[position].amount
        holder.layout.setOnClickListener{
            val intent = Intent(it.context, AccountDetailsActivity::class.java)
            context.startActivity(intent)
        }

    }

}

