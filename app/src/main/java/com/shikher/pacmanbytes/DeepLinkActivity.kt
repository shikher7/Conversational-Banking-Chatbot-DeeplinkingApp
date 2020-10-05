package com.shikher.pacmanbytes

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.airbnb.deeplinkdispatch.DeepLinkModule
import com.shikher.pacmanbytes.DeepLinkModules.AccountDetailsDeepLinkModule
import com.shikher.pacmanbytes.DeepLinkModules.AccountDetailsDeepLinkModuleRegistry
import com.shikher.pacmanbytes.DeepLinkModules.PaymentDeepLinkModule
import com.shikher.pacmanbytes.DeepLinkModules.PaymentDeepLinkModuleRegistry


@DeepLinkHandler(PaymentDeepLinkModule::class,AccountDetailsDeepLinkModule::class)
class DeepLinkActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // DeepLinkDelegate, LibraryDeepLinkModuleLoader and AppDeepLinkModuleLoader
        // are generated at compile-time.
        val deepLinkDelegate = DeepLinkDelegate(PaymentDeepLinkModuleRegistry(),AccountDetailsDeepLinkModuleRegistry())
        // Delegate the deep link handling to DeepLinkDispatch.
        // It will start the correct Activity based on the incoming Intent URI
        deepLinkDelegate.dispatchFrom(this)
        // Finish this Activity since the correct one has been just started
        finish()
    }


}


