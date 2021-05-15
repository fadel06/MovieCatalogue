package com.belajar.moviecatalogue.utils

import android.view.View

infix fun View.visibility(status: Boolean) {
    visibility =
        if (status)
            View.VISIBLE
        else
            View.GONE
}