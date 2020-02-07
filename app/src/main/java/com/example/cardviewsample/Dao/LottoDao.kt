package com.example.cardviewsample.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.cardviewsample.Model.Lotto

@Dao
interface LottoDao {

    // 동기
    @Query("SELECT * FROM lottoList")
    fun getLottos(): LiveData<List<Lotto>>

    @Insert
    suspend fun insertLotto(lotto: Lotto)

    @Transaction
    open suspend fun setLoggedInLotto(lotto: Lotto) {
        insertLotto(lotto = lotto)
    }
}