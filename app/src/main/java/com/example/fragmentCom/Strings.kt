package com.example.fragmentCom

import android.content.Context
import com.example.fragmentcom.R

object Strings {
    private lateinit var appContext: Context
    val shareDataToAct: String by lazy { appContext.getString(R.string.shareDataToAct) }
    val shareDataToFragment: String by lazy { appContext.getString(R.string.shareDataToFragment) }
    val shareDataToParentFragment: String by lazy { appContext.getString(R.string.shareDataToParentFragment) }
    val resulFragmentApi: String by lazy { appContext.getString(R.string.resulFragmentApi) }

    fun init(context: Context) {
        appContext = context.applicationContext
    }
}