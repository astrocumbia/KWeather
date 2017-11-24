package me.irvincastellanos.kweather.models

import android.util.Log
import me.irvincastellanos.kweather.network.EndPoints
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by positr0nix on 11/23/17.
 */
class ApiClient {
    var service: EndPoints? = null

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
        builder.interceptors().add(logging)

        val client = builder.build()

        val retrofit: Retrofit = Retrofit
                .Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        service = retrofit.create(EndPoints::class.java)
    }

    fun getWeather() {
        service?.weatherByZipCode("06700,mx")?.enqueue(object : Callback<JSONObject> {
            override fun onResponse(call: Call<JSONObject>?, response: Response<JSONObject>?) {
                Log.i("API", "status code ${response?.code()}")
                Log.i("--> API","success ${response?.body().toString()}")
            }

            override fun onFailure(call: Call<JSONObject>?, t: Throwable?) {
                Log.e("--> API","error")
            }

        })

    }
}