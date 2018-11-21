package com.forcetower.apple.feature.shared

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun <T> MutableLiveData<T>.setValueIfNew(newValue: T) {
    if (this.value != newValue) value = newValue
}

fun View.inflater() : LayoutInflater = LayoutInflater.from(context)

inline fun <reified T: ViewDataBinding> ViewGroup.inflate(@LayoutRes res: Int, attachToParent: Boolean = false): T {
    val inflater = inflater()
    return DataBindingUtil.inflate(inflater, res, this, attachToParent)
}

inline fun <reified T: ViewDataBinding> LayoutInflater.inflate(@LayoutRes res: Int): T {
    return DataBindingUtil.inflate(this, res, null, false)
}