package me.irvincastellanos.kweather.models

import com.google.gson.annotations.SerializedName

/**
 * Created by positr0nix on 11/23/17.
 */
//@field:SerializedName("boarding_stop")
data class Weather(val temp: Double?,
                   val pressure: Double?,
                   val humidity: Double?,
                   @field:SerializedName("temp_min")
                   val tempMin: Double?,
                   @field:SerializedName("temp_max")
                   val tempMax: Double?,
                   @field:SerializedName("sea_level")
                   val seaLevel: Double?,
                   @field:SerializedName("grnd_level")
                   val grndLevel: Double?)