package c09

object Visibility {
  class A {
    private def foo() = {}
    def bar(o: A) = {
      o.foo()
    }
  }
  class B extends A

  val a = new A()
  val b = new B()

  a.bar(b)
}
