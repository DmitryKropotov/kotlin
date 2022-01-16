package kotlinn

class OuterClass  {
    var name: String
    init {
        println("init")
        /*this.name = _name
        _name = "constructor parameter in init"*/
    }
    constructor(_name: String) {
        println("secondary constructor")
        this.name = _name
    }
    class NestedClass {
       var name2: String = "zx"
    }
    inner class InnerClass {
        var nameInner: String = "inner"
        fun printFromInner(): Triple<Int, Int, Unit> {
            println("String from inner class is " + name)
            return Triple(1, 1, Unit)
        }
    }
}