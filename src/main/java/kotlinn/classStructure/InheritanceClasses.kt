package kotlinn.classStructure

class BaseClass {
    internal val str = "internal str"
    internal fun printVal() {
        println(str);
    }

    inline fun inlineFunc() {
        println("inline function package kolinn.classStructure")
    }
}