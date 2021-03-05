package com.hellu.mvvmretrofit.util

import android.app.Activity
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.show(imageUrl: String?) {
    Glide.with(context)
        .load(imageUrl)
        .into(this)
}

fun Activity.showToast(message: String) {
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}