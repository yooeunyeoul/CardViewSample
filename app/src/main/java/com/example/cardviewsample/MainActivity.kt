package com.example.cardviewsample

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)

        tv_select.setOnClickListener {

        }

        tv_insert.setOnClickListener {

        }

        btn_get_crowling.setOnClickListener {
            getLottoInfo()
        }


    }

    fun insertLotto()= runBlocking {

    }

    fun getLottoInfo() {
        val doc = Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin&drwNo=897").get()

        val lottoRound = doc.select("div[class=win_result]").select("h4").text()
        val winningNums = doc.select("div[class=nums]").select("span").eachText()


    }
}
