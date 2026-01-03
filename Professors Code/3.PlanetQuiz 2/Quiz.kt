package com.example.planetquiz

data class QandA(
    val question: String,
    val answer: String
)

val quiz = listOf(
    QandA("What is the largest planet?", "JUPITER"),
    QandA("Which planet has the most moons?", "SATURN"),
    QandA("Which planet spins on its side?", "URANUS")
)

val choice = listOf("MERCURY","VENUS","EARTH","MARS","JUPITER","SATURN","URANUS","NEPTUNE")
