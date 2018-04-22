package com.example.bruno.yourweighton

enum class Planets(val planetName: Int, private val gravity: Float) {
    MARS(R.string.mars, 0.38f),
    VENUS(R.string.venus, 0.91f),
    JUPTER(R.string.jupter, 2.34f);

    fun calculateWeight(userWeigh: Double): Double {
        return userWeigh * gravity
    }
}