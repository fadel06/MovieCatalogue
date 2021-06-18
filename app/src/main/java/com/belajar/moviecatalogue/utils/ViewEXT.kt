package com.belajar.moviecatalogue.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.belajar.moviecatalogue.R

infix fun View.visibility(status: Boolean) {
    visibility =
        if (status)
            View.VISIBLE
        else
            View.GONE
}

fun errorMessage(context: Context){
    Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_LONG).show()
}