package com.example.myapplication.adapters

import android.content.res.Resources
import android.graphics.Color
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("imageFromString")
fun setImageUri(view: ImageView, imageUri: String?) {
    if (imageUri == null || imageUri=="") {
        val resources: Resources = view.resources
        val resourceId = resources.getIdentifier("bg4", "drawable",  "com.example.myapplication")
        view.setImageResource(resourceId)
    }
    else {
        var imageName = imageUri.replace(".png", "")
        val resources: Resources = view.resources
        val resourceId = resources.getIdentifier(imageName, "drawable",  "com.example.myapplication")
        view.setImageResource(resourceId)
    }
}

@BindingAdapter("colorFromString")
fun setBackground(background: ConstraintLayout, backgroundColor: String) {

    val color: Int = try {
        Color.parseColor(backgroundColor)
    } catch (e: Exception) {
        Color.parseColor("#$backgroundColor")
    }

    background.setBackgroundColor(color)
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: WebView, content: String?) {
    if (content != null) {
//        view.text = HtmlCompat.fromHtml(content, FROM_HTML_MODE_COMPACT)
        view.loadDataWithBaseURL(null, content, "text/html", "utf-8", null)
//        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.loadDataWithBaseURL(null, "loading.html", "text/html", "utf-8", null)
    }
}
@BindingAdapter("renderWeb")
fun bindRenderHtmlWeb(view: WebView, content: String?) {
    if (content != null) {
        val ncontent = "file:///android_asset/" + content
        Log.i("c", ncontent)
        view.loadUrl(ncontent)

    } else {
        view.loadDataWithBaseURL(null, "loading.html", "text/html", "utf-8", null)
    }
}
