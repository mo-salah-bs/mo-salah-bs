package com.example.recipesapp.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun RecyclerView.vertical(context: Context) {
    val linearLayoutManager = LinearLayoutManager(context)
    linearLayoutManager.orientation = VERTICAL
    this.layoutManager = linearLayoutManager
}