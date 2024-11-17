
fun main() {
    val choice = 3 

    when (choice) {
        1 -> printDiamondPattern(5)
        2 -> checkArmstrongNumber(153)
        3 -> calculateGCD(20, 15)
        5 -> checkDuckNumber("1203")
        else -> println("invalid choice")
    }
}

fun printDiamondPattern(n: Int) {
    var space = n - 1
    for (i in 1..n) {
        for (j in 1..space) {
            print(" ")
        }
        for (k in 1..i) {
            print("* ")
        }
        println()
        space--
    }
    space = 1
    for (i in n - 1 downTo 1) {
        for (j in 1..space) {
            print(" ")
        }
        for (k in 1..i) {
            print("* ")
        }
        println()
        space++
    }
}

fun checkArmstrongNumber(no: Int) {
    var temp = no
    var sum = 0

    var numDigits = 0
    var countTemp = no
    while (countTemp != 0) {
        countTemp /= 10
        numDigits++
    }

    temp = no
    while (temp != 0) {
        val digit = temp % 10
        var digitPower = 1
        for (i in 1..numDigits) {
            digitPower *= digit
        }
        sum += digitPower
        temp /= 10
    }
    
    if (sum == no) {
        println("$no is an Armstrong number")
    } else {
        println("$no is not an Armstrong number")
    }
}

fun calculateGCD(a: Int, b: Int) {
    var num1 = a
    var num2 = b
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    println("gcd  is $num1")
}

fun checkDuckNumber(number: String) {
    var isDuck = false
    for (char in number) {
        if (char == '0') {
            isDuck = true
            break
        }
    }
    if (isDuck) {
        println("$number is a Duck number.")
    } else {
        println("$number is not a Duck number.")
    }
}