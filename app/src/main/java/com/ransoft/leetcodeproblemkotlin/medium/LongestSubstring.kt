package com.ransoft.leetcodeproblemkotlin.medium

fun main() {

    println("Longest Substring")

    val s = "abcabcbb"

    println("Input: s=$s")
    println("Output: ${findLongestSubstring(s)}")
}

fun findLongestSubstring(s: String): Int {
    var left = 0
    var right = 0
    val seen = mutableSetOf<Char>()
    var max = 0

    while (right<s.length) {
        val c = s[right]
        if (seen.add(c)) {
            max = Math.max(max,(right -left) + 1)
            right++
        } else {
            // remove earlier char
            while(s[left]!=c) {
                seen.remove(s[left])
                left++
            }
            // remove actual char
            seen.remove(c)
            left++
        }
    }

    return max
}