package com.shikher.pacmanbytes.Model

data class TransactionModel(
    val TRANSACTION_ID: String="",
    val TRANSACTION_TIME: String="",
    val ACCOUNT_NO: String ="",
    val TRANSACTION_DETAIL:String ="",
    val TRANSACTION_AMT:String = "",
    val TRANSACTION_CRY: String="",
    val STANDING_AMT: String="",
    val STANDING_CRY: String ="",
    val TRANSACTION_TYPE:String ="",
    val TRANSACTION_MODE:String = "",
    val MERCHANT_TYPE:String = "",
) {
}