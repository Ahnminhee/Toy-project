package com.example.json_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    /*val url: String = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101"
    val key: String = "05911b4de04700f0fe0df48ee699340e"*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun getJsonString(): String? {
        var json: String? = null

        try{
            val iss = assets.open("Movies.json")
            val fileSize = iss.available()
            val buffer = ByteArray(fileSize)
            iss.read(buffer)
            iss.close()

            json= String(buffer, "UTF-8")

        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return json
    }

}
