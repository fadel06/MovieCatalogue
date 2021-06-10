package com.belajar.moviecatalogue.utils

import android.content.Context


fun getIdDrawable(context: Context, name: String?): Int {
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}