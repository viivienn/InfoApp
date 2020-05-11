package com.example.myapplication.adapters

import android.content.res.Resources
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.databinding.BindingAdapter


//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//import com.google.samples.apps.sunflower.R
//
//@BindingAdapter("imageFromUrl")
//fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
//    if (!imageUrl.isNullOrEmpty()) {
//        Glide.with(view.context)
//            .load(imageUrl)
//            .transition(DrawableTransitionOptions.withCrossFade())
//            .into(view)
//    }
//}

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

//@BindingAdapter("imagefomUrl")
//fun setImageUri(view: ImageView, imageUri: Uri?) {
//    view.setImageURI(imageUri)
//}

//
//@BindingAdapter("isGone")
//fun bindIsGone(view: FloatingActionButton, isGone: Boolean?) {
//    if (isGone == null || isGone) {
//        view.hide()
//    } else {
//        view.show()
//    }
//}

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
//        view.text = HtmlCompat.fromHtml(content, FROM_HTML_MODE_COMPACT)
        val ncontent = "file:///android_asset/" + content
        Log.i("c", ncontent)
        view.loadUrl(ncontent)
//        view.loadDataWithBaseURL(null, content, "text/html", "utf-8", null)
//        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.loadDataWithBaseURL(null, "loading.html", "text/html", "utf-8", null)
    }
}
//@BindingAdapter("wateringText")
//fun bindWateringText(textView: TextView, wateringInterval: Int) {
//    val resources = textView.context.resources
//    val quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix,
//        wateringInterval, wateringInterval)
//
//    textView.text = quantityString
//}