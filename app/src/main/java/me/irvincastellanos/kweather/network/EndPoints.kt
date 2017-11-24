package me.irvincastellanos.kweather.network

import me.irvincastellanos.kweather.models.Weather
import retrofit2.Call
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Query



/**
 * Created by positr0nix on 11/23/17.
 */
val KEY = "90620e6558432301d7f3e82e02efbd0f"
interface EndPoints {
    @GET("weather")
    fun weatherByZipCode(@Query("zip") zipcode: String,
                         @Query("appid") key: String = KEY)
            :Call<JSONObject>
}