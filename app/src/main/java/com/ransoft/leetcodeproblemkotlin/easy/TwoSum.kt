package com.ransoft.leetcodeproblemkotlin.easy

fun main() {
    println("Two Sum Problem")

    val nums = intArrayOf(3, 2, 4)
    val target = 6

    println("Input: ${nums.contentToString()}")
    println("Target: $target")

    // Brute force approach
    println()
    println("=== Brute force approach O(N^2)===")
    println("Output: ${method1(nums, target).contentToString()}")

    // Using Map
    println()
    println("=== Map approach O(N) ===")
    println("Output: ${method2(nums, target).contentToString()}")
}

fun method1(nums: IntArray, target: Int) : IntArray{
    val solution = mutableListOf<Int>()
    for (i in nums.indices) {

        // i in 1 until nums.size, excluding nums.size
        for (j in i+1 until nums.size) {
            if (target==(nums[i]+nums[j])) {
                if (!solution.contains(i)) {
                    solution.add(i)
                }
                if (!solution.contains(j)) {
                    solution.add(j)
                }
            }
        }
    }
    return solution.toIntArray()
}

fun method2(nums: IntArray, target: Int): IntArray {
    val solution = mutableListOf<Int>()

    // Fill Map with nums
    val mapOfNums = mutableMapOf<Int, Int>()
    for (i in nums.indices){
        mapOfNums[i] = nums[i]
    }

    for (i in nums.indices) {
        val num = nums[i]
        val remain = (target - num)
        if (mapOfNums.containsValue(remain)) {
            val index = mapOfNums.entries.find { it.value == remain }?.key
            if (i==index) continue
            if (!solution.contains(i)) {
                solution.add(i)
            }
            if (!solution.contains(index)) {
                if (index != null) {
                    solution.add(index)
                }
            }
        }
    }

    return solution.toIntArray()
}