package c07

package c07

object EjercicioConstructores {

  abstract class A(name: String, age: Int) {
    println(s"A, name:${name}, age:${age}")
  }

  class B(name: String) extends A(name, 0) {
    println("B")

    def this(name: String, age: Int) = {
      this(s"${name}-${age * 10}")
      println("B2")
    }

    def this(name: String, age: String) = {
      this(s"${name}-${age}")
      println("B3")
    }
  }
  class C() extends B("Foo", 18) {
    println("C")
  }

  class D() extends B("Foo", "18") {
    println("D")

    def this(age: Int) = {
      this()
      println("D2")
    }
  }

  def main(args: Array[String]): Unit = {
    val c1 = new C() // que imprime esto?
    // val b: B = new C() // que imprime esto?
    // val d: D = new D() // que imprime esto?
    // val a: A = new A() // que imprime esto?
    // val d2: D = new D("John", 18) // que imprime esto?
  }

}
