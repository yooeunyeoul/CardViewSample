package com.example.cardviewsample.Model

import androidx.room.Entity

@Entity(tableName = "lottoList")
data class Lotto(
    var firstTotalReward: String="",
    var firstTotalPeople: String="",
    var firstIndividualReward: String?="",
    var beego: String="",

    var secondTotalReward: String="",
    var secondTotalPeople: String="",
    var secondIndividualReward: String="",

    var thirdTotalReward: String="",
    var thirdTotalPeople: String="",
    var thirdIndividualReward: String="",

    var fourthTotalReward: String="",
    var fourthTotalPeople: String="",
    var fourthIndividualReward: String="",

    var fifthTotalReward: String="",
    var fifthTotalPeople: String="",
    var fifthIndividualReward: String="",

    var numberOne:Int=0,
    var numberTwo :Int=0,
    var numberThree : Int=0,
    var numberFour : Int=0,
    var numberFive : Int=0,
    var numberSix:Int=0

) {
}