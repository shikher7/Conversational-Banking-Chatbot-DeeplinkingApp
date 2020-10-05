package com.shikher.pacmanbytes.DeepLinkModules

import android.content.Context
import android.content.Intent
import com.airbnb.deeplinkdispatch.DeepLink
import com.airbnb.deeplinkdispatch.DeepLinkModule
import com.shikher.pacmanbytes.AccountDetailsActivity
import com.shikher.pacmanbytes.LoginActivity
import com.shikher.pacmanbytes.PaymentActivity

@DeepLinkModule
class AccountDetailsDeepLinkModule

@DeepLink("https://www.pacmanbytes.com/account_details")
fun startActivity2(context: Context): Intent {
    return Intent(context, AccountDetailsActivity::class.java)
}