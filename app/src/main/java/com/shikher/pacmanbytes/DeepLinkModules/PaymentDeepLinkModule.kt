package com.shikher.pacmanbytes.DeepLinkModules

import android.content.Context
import android.content.Intent
import com.airbnb.deeplinkdispatch.DeepLink
import com.airbnb.deeplinkdispatch.DeepLinkModule
import com.shikher.pacmanbytes.LoginActivity
import com.shikher.pacmanbytes.PaymentActivity

@DeepLinkModule
class PaymentDeepLinkModule

fun startActivity1(context: Context): Intent {
    return Intent(context, PaymentActivity::class.java)
}