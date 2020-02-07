package com.example.cardviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardviewsample.Dao.LottoDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_select.setOnClickListener {

        }

        tv_insert.setOnClickListener {

        }


    }

    fun insertLotto()= runBlocking {

    }
}
