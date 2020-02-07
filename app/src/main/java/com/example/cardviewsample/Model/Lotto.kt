package com.example.cardviewsample.Model

import androidx.room.Entity

@Entity(tableName = "lottoList")
data class Lotto(private val num:String) {
}