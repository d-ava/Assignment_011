package com.example.assignment_011.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.makeSnackbar(txt: String){
    Snackbar.make(this, txt, Snackbar.LENGTH_SHORT).show()
}