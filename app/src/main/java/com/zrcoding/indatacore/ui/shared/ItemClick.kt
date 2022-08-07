package com.zrcoding.indatacore.ui.shared

interface ItemClick<in T> {
    fun onItemClick(item: T)
}