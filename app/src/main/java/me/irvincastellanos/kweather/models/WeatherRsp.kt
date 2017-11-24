package me.irvincastellanos.kweather.models

import com.google.gson.annotations.SerializedName

/**
 * Created by positr0nix on 11/23/17.
 */
data class WeatherRsp(@field:SerializedName("main")
                      val weather: Weather?)