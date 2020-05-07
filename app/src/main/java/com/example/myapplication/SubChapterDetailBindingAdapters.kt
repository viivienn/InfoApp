package com.example.myapplication

import android.text.method.LinkMovementMethod
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
fun bindRenderHtml(view: TextView, content: String?) {
    if (content != null) {
        view.text = HtmlCompat.fromHtml(content, FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = "hey baby"
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