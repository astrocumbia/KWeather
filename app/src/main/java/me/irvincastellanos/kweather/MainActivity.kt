package me.irvincastellanos.kweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.irvincastellanos.kweather.models.Weather
import me.irvincastellanos.kweather.network.ApiClient
import okhttp3.internal.Util

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClient.instance.getWeather(onSuccess = {
            Log.i(MainActivity::javaClass.name, "${it?.weather}")
            Log.i(MainActivity::javaClass.name, "temp:: ${it?.weather?.temp}")

            it?.weather?.let {
                layout(it)
            }

        }, onFailure = { message ->
            Log.e(MainActivity::javaClass.name, "Error:: $message")
        })
    }

    fun layout(weather: Weather) {
        val tmp = weather.temp ?: 0.0
        val c = (tmp - 273.15).toInt().toString()

        weatherTxt.text = c+"°"
    }
}
