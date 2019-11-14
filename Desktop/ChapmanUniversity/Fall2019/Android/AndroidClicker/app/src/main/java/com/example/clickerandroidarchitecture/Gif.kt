package com.example.clickerandroidarchitecture

import com.google.gson.annotations.SerializedName

class GifResponse(@SerializedName("data") val data: Gif)

class Gif(@SerializedName("image_url") val url: String)