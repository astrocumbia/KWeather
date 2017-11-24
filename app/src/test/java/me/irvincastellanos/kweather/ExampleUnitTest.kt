package me.irvincastellanos.kweather

import me.irvincastellanos.kweather.network.ApiClient
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun getWeatherFromAPI() {
        val api = ApiClient()
        api.getWeather()
        assert(true)
    }
}
