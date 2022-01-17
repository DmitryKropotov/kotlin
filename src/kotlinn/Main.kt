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
    println("end sequences")
    println()

    println(higherOrderFunc(122, 88, ::sum))
    println()

    val lambdaFunc = {str: String -> str.toUpperCase()}
    println(lambdaFunc.invoke("hello"))
    println("lambda function")
    println()

    inlineFunc { println("This is inline function") }
    var class2 = Class2();
    class2.inlineFunc();
    var baseClass = BaseClass()
    baseClass.inlineFunc()
    println()

    var outerClass = OuterClass("unnatural name")
    println(outerClass.name)
    var nestedClass/*: kotlin.OuterClass.NestedClass*/ = OuterClass.NestedClass()
    println(nestedClass.name2)
    var innerClass/*: kotlin.OuterClass.InnerClass*/ = outerClass.InnerClass()
    var result: Triple<Int, Int, Unit> = innerClass.printFromInner();
    println("result of triple from inner class " + result)
    println("outer, nested and inner classes")
    println()

    baseClass.printVal()
    println("internal variable")
    println()

    var sealedClass = SealedClass.OP1()
    println(sealedClass.str)
    println("sealed class")
    println()

    var b = BaseImpl(10)
    Derived(b).printMe()
    println("derived class")
    println()

    var user = User()
    user.name = "first"
    user.name = "second"
    println("observable function")
    println()

    val myVar: String by lazy {
        "Hello"
    }
    println(myVar +" My dear friend")
    println("lazy function")
    println()

    val man = returnDestructuringDeclaration()
    println(man)
    println()

    try {
        val myVar:Int = 12;
        val v:String = "Tutorialspoint.com";
        //v.toInt();
    } catch(e:Exception) {
        e.printStackTrace();
    } finally {
        println("Exception Handling in Kotlin");
    }

}

fun sum(a: Int, b: Int): Int {
    return a+b
}

fun higherOrderFunc(a: Int, b: Int, operation:(Int, Int)-> Int): Int {
    println("higher order function")
    return sum(a, b)
}

inline fun inlineFunc(linkFunction:(a: Int)-> Unit) {
    linkFunction(3)
}

fun returnDestructuringDeclaration(): Person {
    val person = Person("John", 18, "student")
    return person
}

data class Person(val name_: String, val age_: Int, val profession_: String) {
    var name = name_
    var age = age_
    var profession = profession_
}

sealed class SealedClass(_num: Int) {
    private var num: Int;
    init {
        this.num = _num
    }
    var str = "sealed class $num"
    class OP1 : SealedClass(1)
    class OP2 : SealedClass(2)
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