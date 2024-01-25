package com.example.e_ramo_task.navigation

import java.net.URLEncoder

sealed class Screens(val route: String) {
    object FirstScreen : Screens("first")
    object SecondScreen : Screens("second/{imageUrl}") {
        fun passImageUrl(imageUrl: String): String {
            return "second/${URLEncoder.encode(imageUrl, "UTF-8")}"
        }
    }
}



