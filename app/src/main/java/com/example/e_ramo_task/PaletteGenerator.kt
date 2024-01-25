package com.example.e_ramo_task

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


object PaletteGenerator {

    // First we need to convert the image url to Bitmap to can extract the colors
    suspend fun convertImageUrlToBitmap(
        imageUrl: String,
        context: Context
    ): Bitmap? {
        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
            .data(imageUrl)
            .allowHardware(false)
            .build()
        val imageResult = loader.execute(request = request)
        return if (imageResult is SuccessResult) {
            (imageResult.drawable as BitmapDrawable).bitmap
        } else {
            null
        }
    }

    // Extract the colors form the Bitmap
    fun extractColorsFromBitmap(bitmap: Bitmap): Map<String, String> {
        return mapOf(
            "vibrant" to parseColorSwatch(
                color = Palette.from(bitmap).generate().vibrantSwatch
            ),
            "darkVibrant" to parseColorSwatch(
                color = Palette.from(bitmap).generate().darkVibrantSwatch
            ),
            "onDarkVibrant" to parseBodyColor(
                color = Palette.from(bitmap).generate().darkVibrantSwatch?.bodyTextColor
            ),
            "lightVibrant" to parseColorSwatch(
                color = Palette.from(bitmap).generate().lightVibrantSwatch
            ),
            "domainSwatch" to parseColorSwatch(
                color = Palette.from(bitmap).generate().dominantSwatch
            ),
            "mutedSwatch" to parseColorSwatch(
                color = Palette.from(bitmap).generate().mutedSwatch
            ),
            "lightMuted" to parseColorSwatch(
                color = Palette.from(bitmap).generate().lightMutedSwatch
            ),
            "darkMuted" to parseColorSwatch(
                color = Palette.from(bitmap).generate().darkMutedSwatch
            ),
        )
    }

    // This function to can convert the Swatch color to Hex color string
    private fun parseColorSwatch(color: Palette.Swatch?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color.rgb)
            return "#$parsedColor"
        } else {
            "#000000"
        }
    }

    private fun parseBodyColor(color: Int?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color)
            "#$parsedColor"
        } else {
            "#FFFFFF"
        }
    }


}