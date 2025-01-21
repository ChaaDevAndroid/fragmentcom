package com.example.fragmentCom.utils

import android.view.View
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <T> observer(
    initialValue: T,
    crossinline onChange: (newValue: T) -> Unit
):
        ReadWriteProperty<Any?, T> =
    object : ObservableProperty<T>(initialValue) {
        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) =
            onChange(newValue)
    }
fun View.onClick(listener: (View) -> Unit) {
    setOnClickListener(SingleClickListener(listener))
}

class SingleClickListener(val listener: (View) -> Unit) : View.OnClickListener {

    override fun onClick(view: View) {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis >= previousClickTimeMillis + DELAY_MILLIS) {
            previousClickTimeMillis = currentTimeMillis
            listener.invoke(view)
        }
    }

    companion object {
        private const val DELAY_MILLIS = 200L
        private var previousClickTimeMillis = 0L
    }
}

const val TAG = "TAGS"