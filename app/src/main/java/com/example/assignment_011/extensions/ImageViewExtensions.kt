package com.example.assignment_011.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.assignment_011.R


fun ImageView.glideExtension(img: String?) {
    if (!img.isNullOrEmpty()) {
        Glide.with(context).load(img).error(R.drawable.ic_launcher_foreground)
            .into(this)

    } else setImageResource(R.drawable.ic_launcher_foreground)


}