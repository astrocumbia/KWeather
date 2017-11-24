package me.irvincastellanos.kweather.network

import android.util.Log
import me.irvincastellanos.kweather.models.Weather
import me.irvincastellanos.kweather.models.WeatherRsp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by positr0nix on 11/23/17.
 */
class ApiClient {

    private val loggerInterceptor = HttpLoggingInterceptor()
    private val builder = OkHttpClient.Builder()

    private val okHttpClient by lazy {
        loggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.interceptors().add(loggerInterceptor)

        builder.build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(EndPoints::class.java)
    }

    companion object {
        val instance: ApiClient = ApiClient()
    }

    fun getWeather(onSuccess: (WeatherRsp?) -> Unit, onFailure: (String) -> Unit ) {
        retrofit?.weatherByZipCode("06700,mx")?.enqueue(object : Callback<WeatherRsp> {
            override fun onResponse(call: Call<WeatherRsp>?, response: Response<WeatherRsp>?) {
                when (response?.code()) {
                    200 -> {
                        onSuccess(response.body() as WeatherRsp)
                    }
                    else -> {
                        Log.e("--> API","error")
                        onFailure("Error code ${response?.code()}")
                    }
                }
            }

            override fun onFailure(call: Call<WeatherRsp>?, t: Throwable?) {
                Log.e("--> API","error")
                onFailure("${t?.message}")
            }

        })

    }
}