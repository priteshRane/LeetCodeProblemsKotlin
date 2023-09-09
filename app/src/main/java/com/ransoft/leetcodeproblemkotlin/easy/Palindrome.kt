package com.ransoft.leetcodeproblemkotlin.easy

fun main() {

    println("Palindrome Number")

    val x = 121

    println("Input: $x")

    println()
    println("Output: ${isPalindrome(x)}")
}

fun isPalindrome(x: Int) : Boolean{
    val xReverse = x.toString().reversed()
    return x.toString() == xReverse
}