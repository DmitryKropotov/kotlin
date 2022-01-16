package kotlinn

import kotlinn.classStructure.*
import kotlin.properties.Delegates

fun main() {
    println("Hello, world")
    for(num in 1.rangeTo(6) step 2) {
        println(num)
    }
    println()
    for(num in (10 downTo 1).reversed() step 3) {
        println(num)
    }
    println()
    for(num in 1 until 5) {
        println(num)
    }
    println()
    for(ch in ('a' .. 'd').reversed()) {
        println(ch)
    }
    println()
    val range = 1..10
    println(range.step)
    val f = range.filter {T -> T%2 == 0 }
    println(f)
    println()
    println(higherOrderFunc(122, 88, ::sum))
    println()
    val lambdaFunc = {str: String -> str.toUpperCase()}
    println(lambdaFunc.invoke("hello"))
    println()
    inlineFunc { println("This is inline") }
    println()
    var outerClass = OuterClass("unnatural name")
    println(outerClass.name)
    var nestedClass/*: kotlin.OuterClass.NestedClass*/ = OuterClass.NestedClass()
    println(nestedClass.name2)
    var innerClass/*: kotlin.OuterClass.InnerClass*/ = outerClass.InnerClass()
    var result: Triple<Int, Int, Unit> = innerClass.printFromInner();
    println(result)
    println()
    var baseClass = BaseClass()
    baseClass.printVal()
    println()
    var sealedClass = SealedClass.OP1()
    println(sealedClass.str)
    println()
    var b = BaseImpl(10)
    Derived(b).printMe()
    println()
    var user = User()
    user.name = "first"
    user.name = "second"
}

fun sum(a: Int, b: Int): Int {
    return a+b
}

fun higherOrderFunc(a: Int, b: Int, operation:(Int, Int)-> Int): Int {
    return sum(a, b)
}

inline fun inlineFunc(linkFunction:(a: Int)-> Unit) {
    linkFunction(3)
}

sealed class SealedClass {
    var str = "sealed class"
    class OP1 : SealedClass()
    class OP2 : SealedClass()
}

interface Base {
    fun printMe()
}

class BaseImpl(val x: Int): Base {
    override fun printMe() {
        println("value " + x)
    }
}

class Derived(b: Base): Base by b

class User {
    var name: String by Delegates.observable("Welcome to Tutorialspoint.com") {
            prop, old, new ->
        println("$old -> $new")
    }
}