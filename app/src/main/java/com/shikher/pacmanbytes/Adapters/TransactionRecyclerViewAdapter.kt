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
        val TRANSACTION_TIME = itemView.TRANSACTION_TIME_VIEW!!
        val TRANSACTION_DETAIL = itemView.TRANSACTION_DETAIL_VIEW!!
        val TRANSACTION_TYPE = itemView.transaction_type_img!!
        val TRANSACTION_AMT = itemView.TRANSACTION_AMT_VIEW!!
        val MERCHANT_TYPE = itemView.MERCHANT_TYPE_VIEW!!
        val layout = itemView.itemTransactionLayout!!
    }


    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        if (items[position].MERCHANT_TYPE.isNotEmpty())
            holder.MERCHANT_TYPE.text = items[position].MERCHANT_TYPE
        if (items[position].TRANSACTION_AMT.isNotEmpty())
            holder.TRANSACTION_AMT.text = "₹ ${items[position].TRANSACTION_AMT}"
        if (items[position].TRANSACTION_DETAIL.isNotEmpty())
            holder.TRANSACTION_DETAIL.text = items[position].TRANSACTION_DETAIL
        if (items[position].TRANSACTION_TIME.isNotEmpty())
            holder.TRANSACTION_TIME.text = items[position].TRANSACTION_TIME
        if (items[position].TRANSACTION_TYPE.isNotEmpty()) {
            when (items[position].TRANSACTION_TYPE) {
                "1" -> holder.TRANSACTION_TYPE.setImageResource(R.drawable.red_left_arrow)
                "0" -> {
                    holder.TRANSACTION_TYPE.setImageResource(R.drawable.green_right_arrow)
                    holder.MERCHANT_TYPE.text = "Received"
                }
            }

        }
    }
}



