package com.example.starnavigation

data class StarSign(
    val name: String,
    val symbol: String,
    val dateRange: String
)

val starSigns = listOf(
    StarSign("Aquarius", "Water Carrier", "January 20 – February 18"),
    StarSign("Pisces", "Fish", "February 19 – March 20"),
    StarSign("Aries", "Ram", "March 21 – April 19"),
    StarSign("Taurus", "Bull", "April 20 – May 20"),
    StarSign("Gemini", "Twins", "May 21 – June 20"),
    StarSign("Cancer", "Crab", "June 21 – July 22"),
    StarSign("Leo", "Lion", "July 23 – August 22"),
    StarSign("Virgo", "Virgin", "August 23 – September 22"),
    StarSign("Libra", "Scales", "September 23 – October 22"),
    StarSign("Scorpio", "Scorpion", "October 23 – November 21"),
    StarSign("Sagittarius", "Archer", "November 22 – December 21"),
    StarSign("Capricorn", "Mountain Goat", "December 22 – January 19")
)
