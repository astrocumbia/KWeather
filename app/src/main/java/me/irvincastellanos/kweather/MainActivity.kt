package me.irvincastellanos.kweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import me.irvincastellanos.kweather.models.ApiClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = ApiClient()
        api.getWeather()
    }
}
