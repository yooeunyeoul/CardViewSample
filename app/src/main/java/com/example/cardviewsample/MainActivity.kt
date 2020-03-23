package com.example.cardviewsample

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.jsoup.nodes.Element


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

    fun insertLotto() = runBlocking {

    }

    fun getLottoInfo() {

        for (i in 897..900) {

            val doc =
                Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin&drwNo={$i}").get()

            val lottoRound = doc.select("div[class=win_result]").select("h4").text()
//            val winningNums = doc.select("div[class=nums]").select("span").eachText()

            val resultOfTable = doc.select("div[class=content_wrap content_winnum_645]")
                .select("table[class=tbl_data tbl_data_col]").select("tr")

//        val numberOne = resultOfTable[1]
//        val firstWinningResult = numberOne.select("td")

            for (i in 0 until resultOfTable.size) {
                if (i == 0) {
                    continue
                }
                saveLottoData(resultOfTable[i])
            }




        }


    }

    private fun saveLottoData(element: Element) {

        //
        val winningResult = element.select("td")

        for (i in 0 until winningResult.size) {
            when (i) {
//                0 or 4 -> {
//                    Logger.e("이거 스킵하세요")
//                }

                // 1등 당첨금액
                1 -> {
                    val totalAmountFirstWinning = winningResult[i].text()
                    Logger.e(totalAmountFirstWinning)
                }

                // 1등 당첨자 수
                2 -> {
                    val totalCountWinningPeople = winningResult[i].text()
                    Logger.e(totalCountWinningPeople)
                }

                // 1등 개인 보상
                3 -> {
                    val individualWinningReward = winningResult[i].text()
                    Logger.e(individualWinningReward)
                }

                // 비고
                5 -> {
                    val beego = winningResult[i].text()
                    Logger.e(beego)
                }

            }


        }


    }

}
