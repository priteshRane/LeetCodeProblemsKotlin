package easy

fun main() {

    println("Roman To Integer")

    val s = "LVIII"

    println()
    println("Input: $s")
    println("Output: ${romanToInt(s)}")
}

fun romanToInt(s: String): Int {
    var integerIs = 0
    val roman = mapOf<String, Int>("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)

    for (char in 0 until s.length) {
        println("${s[char]} ${roman[s[char].toString()]}")
        if (char+1 < s.length && roman[s[char].toString()]!! < roman[s[char+1].toString()]!!)
            integerIs -= roman[s[char].toString()]!!
        else
            integerIs += roman[s[char].toString()]!!
    }

    return integerIs
}