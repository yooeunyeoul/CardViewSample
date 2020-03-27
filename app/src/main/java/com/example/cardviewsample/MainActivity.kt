package com.example.cardviewsample

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity(), CoroutineScope {
    /**
     * https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4%EC%9D%98-%EA%B8%B0%EC%B4%88-cac60d4d621b
     */
    private var job:Job = Job()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val policy =
//            StrictMode.ThreadPolicy.Builder().permitAll().build()
//
//        StrictMode.setThreadPolicy(policy)

        tv_select.setOnClickListener {

        }

        tv_insert.setOnClickListener {

        }

        btn_get_crowling.setOnClickListener {
            cancellingCoroutine()
            // 아에 새로운 제어범위가 생김
//            CoroutineScope(Dispatchers.IO).launch {
//
//            }

            // 전역으로 선언된 scope 는 유지되면서 작업이 처리되는 스레드만 변겅된다.
//            val job = launch(Dispatchers.IO) {
//                getLottoInfo()
//            }

//            launch {
//                val job1 : Job = launch {
//                    //                job.join()
//                    var i = 0
//                    while (i < 10) {
//                        delay(500)
//                        i++
//                        Logger.e("잡 원 "+i)
//                    }
//
//                }
//                job1.join()
//
//                val job2 = launch {
//
//                    var i = 0
//                    while (i < 10) {
//                        delay(1000)
//                        i++
//                        Logger.e("잡 투 "+i)
//                    }
//                }
//
//                val deferred = async {
//                    var i = 0
//                    while (i < 10) {
//                        delay(500)
//                        i++
//                    }
//
//                    "result"
//                }
//
//                val result1 = deferred.await()
//                Logger.e("결과1$result1")
//
//                val deferred2 = async {
//                    var i =0
//                    while (i < 10) {
//                        delay(200)
//                        i++
//                    }
//
//                    "result2"
//                }
//
//                val result2 = deferred2.await()
//
//                Logger.e("결과2$result2")
//
//                val job = async(start = CoroutineStart.LAZY) {  }
//                job.await()
//
//
//            }






//            getLottoInfo()
        }


    }

    fun cancellingCoroutine()= runBlocking {
        val job = launch {
            repeat(1000){
                println(" i'sleeping $it")
                delay(500L)
            }
        }

        delay((1300L))
        println("기다리기 지루해")
        job.cancel()
        job.join()
        println("main:now i can quit")
    }

    fun makingComputationCodeCancellableUsingYield()= runBlocking {

        val starttime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = starttime
            var i = 0
            while (i < 20) {
                yield()

                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("난 자고있다 $i++")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300L)


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

    override val coroutineContext: CoroutineContext
        get() =  Dispatchers.Main + job// 이 CoroutineScope 는 메인 스레드를 기본으로 동작합니다
    // Dispatchers.IO 나 Dispatchers.Default 등의 다른 Dispatcher 를 사용해도 됩니다

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}

