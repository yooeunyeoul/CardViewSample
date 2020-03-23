package com.example.cardviewsample

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
    fun LamDaCheck() {
        val strings = listOf<String>("adb,", "def")
        println(strings.flatMap { it.toList() })

//        val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")), Book("Mort", listOf("Terry Pratchett")), Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))

        val naturanNumbers = generateSequence(0){
            it+1
        }



        val numbersTo100 = naturanNumbers.takeWhile { it<=100 }

        println(numbersTo100.sum())



    }


}
