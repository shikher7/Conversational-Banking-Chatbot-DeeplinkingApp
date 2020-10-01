package com.shikher.pacmanbytes.Model

data class TransactionModel( val sendOrReceive: String="", val amount: String="", val type: String ="", val merchantName:String ="", val timestamp:String = "", val id: String="") {
}