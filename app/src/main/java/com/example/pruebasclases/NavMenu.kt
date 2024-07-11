package com.example.pruebasclases

sealed class NavMenu(val option: String) {
    object p1 : NavMenu("p1")
    object p2 : NavMenu("p2")
    object p3 : NavMenu("p3")
    object p4 : NavMenu("p4")
}