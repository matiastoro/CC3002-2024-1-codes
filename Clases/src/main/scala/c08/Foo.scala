package c08

abstract class A {
  def foo(x: A): A
}
class B extends A {
  def bar = 10
  def foo(x: A): A = new B()
}

@main def foo() = {}
