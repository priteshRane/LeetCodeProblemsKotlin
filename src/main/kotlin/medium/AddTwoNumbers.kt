package medium

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {

    println("Two Sum Problem")

    // Create l1 ListNode
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)

    // Create l2 ListNode
    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)

    //Print NodeList
    println("Input 1: ${printNodeList(l1)}")
    println("Input 2: ${printNodeList(l2)}")

    println()

    println("Output: ${printNodeList(addTwoNumbers(l1, l2))}")
}

fun printNodeList(l: ListNode?): String {
    var listNodeString = ""
    var listNode = l
    while (listNode != null) {
        listNodeString = if (listNodeString == "") {
            "[${listNode.`val`}"
        } else {
            "$listNodeString, ${listNode.`val`}"
        }
        listNode = listNode.next
    }
    listNodeString = "$listNodeString]"
    return listNodeString
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var current = dummyHead

    var tmpOne = l1
    var tmpTwo = l2

    var carry = 0

    while (tmpOne != null || tmpTwo != null) {
        val one = if(tmpOne != null) tmpOne.`val` else 0
        val two = if(tmpTwo != null) tmpTwo.`val` else 0
        val sum = one + two + carry
        carry = sum / 10
        current.next = ListNode(sum % 10)
        if (tmpOne != null) tmpOne = tmpOne.next
        if (tmpTwo != null) tmpTwo = tmpTwo.next
        current = current.next!!
    }

    if (carry > 0) current.next = ListNode(carry)

    return dummyHead.next
}