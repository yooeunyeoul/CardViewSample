package com.example.cardviewsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cardviewsample.Dao.LottoDao
import com.example.cardviewsample.Model.Lotto
//https://namget.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-ROOM-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4
@Database(entities = arrayOf(Lotto::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun LottoDao(): LottoDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "lotto_db.db"
                    ).build()
                }

            }
            return INSTANCE
        }


    }
}