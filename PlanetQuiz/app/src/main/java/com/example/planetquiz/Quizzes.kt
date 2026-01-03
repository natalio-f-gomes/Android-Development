package com.example.planetquiz

data class Quizzes (
    val question: String,
    val answer: String

)

val quizList = listOf(
    Quizzes("What is the largest planet", "JUPITER"),
    Quizzes("What is the 3RD planet", "EARTH"),
    Quizzes("What is the  planet that orbits around itself","NEPTUNE"),
)

val choices = listOf("MERCURY", "VENUS", "EARTH", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE")