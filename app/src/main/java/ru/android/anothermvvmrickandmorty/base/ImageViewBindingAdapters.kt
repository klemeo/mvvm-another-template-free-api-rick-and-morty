package ru.android.anothermvvmrickandmorty.base

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

@BindingAdapter(
    value = ["imageUrl"],
    requireAll = false
)

fun ImageView.setImageFitPlaceholderWithGlide(
    imageUrl: String?
) {
    scaleType = ImageView.ScaleType.MATRIX
    Glide
        .with(this)
        .load(imageUrl)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.MATRIX
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                scaleType = ImageView.ScaleType.CENTER_CROP
                return false
            }
        })
        .into(this)
}