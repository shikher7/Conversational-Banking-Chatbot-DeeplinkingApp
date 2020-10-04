package com.shikher.pacmanbytes.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shikher.pacmanbytes.Model.TransactionModel
import com.shikher.pacmanbytes.R
import kotlinx.android.synthetic.main.layout_item_transaction.view.*

class TransactionRecyclerViewAdapter(private val context: Context, private  val items: ArrayList<TransactionModel>):
    RecyclerView.Adapter<TransactionRecyclerViewAdapter.TransactionListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TransactionListViewHolder(
        LayoutInflater.from(context).inflate(R.layout.layout_item_transaction, parent, false)
    )

    override fun getItemCount(): Int {
        return items.size
    }

    class TransactionListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val merchantName = itemView.merchant_name!!
        val transactionType = itemView.transaction_type!!
        val transactionTimestamp = itemView.transaction_timestamp!!
        val transactionTypeImg = itemView.transaction_type_img!!
        val transactionAmount = itemView.transaction_amount!!
        val layout = itemView.itemTransactionLayout!!
    }


    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        if (items[position].merchantName.isNotEmpty())
            holder.merchantName.text = items[position].merchantName
        if (items[position].type.isNotEmpty())
            holder.transactionType.text = items[position].type
        if (items[position].amount.isNotEmpty())
            holder.transactionAmount.text = items[position].amount
        if (items[position].sendOrReceive.isNotEmpty()) {
            when (items[position].sendOrReceive) {
                "Send" -> holder.transactionTypeImg.setImageResource(R.drawable.red_left_arrow)
                "Receive" -> holder.transactionTypeImg.setImageResource(R.drawable.green_right_arrow)
            }
            if (items[position].timestamp.isNotEmpty())
                holder.transactionTimestamp.text = items[position].timestamp
        }

    }


}
