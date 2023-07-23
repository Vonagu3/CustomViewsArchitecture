package com.example.customviewsarchitecture.content.presentation

import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

interface NewsUi {
    fun show(textView: TextView, imageView: ImageView)

    class Error(private val message: String): NewsUi {
        override fun show(textView: TextView, imageView: ImageView) {
            textView.text = message
            imageView.setImageResource(android.R.drawable.ic_dialog_alert)
        }
    }

    data class Base(
        private val text: String,
        private val imageUrl: String,
        private val loadImmediately: Boolean
    ): NewsUi {
        override fun show(textView: TextView, imageView: ImageView) {
            textView.text = text
            if (loadImmediately)
                Picasso.get().load(imageUrl).into(imageView)
            else
                imageView.setOnClickListener {
                    Picasso.get().load(imageUrl).into(imageView)
                }
        }
    }
}