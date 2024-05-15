package c16

trait MyFunction[-D, +C] {
  def apply(arg: D): C
}
class PlusOne extends MyFunction[Int, Int] {
  def apply(arg: Int): Int = arg + 1
}

class GreaterThanZero extends MyFunction[Int, Boolean] {
  def apply(arg: Int): Boolean = arg > 0
}

class Foo extends MyFunction[Any, Int]{
  def apply(arg: Any): Int = 1
}

@main def main() = {
  def applyWithOne1(f: Int => Any): Unit = {
    f(1)
  }
  def plusOne(x: Int): Int = x + 1
  applyWithOne1(plusOne)

  def applyWithOne(f: MyFunction[Int, Any]): Unit = {
    f(1)
  }

  val f1 = new PlusOne()
  println(f1(1)) // 2

  applyWithOne(f1)
  //f1: MyFunction[Int,Int]
  //applyWithOne: MyFunction[Int,Any] => Unit
  // MyFunction[Int,Int] <: MyFunction[Int,Any]

  val f3 = new Foo()
  applyWithOne(f3)
  //f3: MyFunction[Any, Int]
  //applyWithOne: MyFunction[Int,Any] => Unit
  // MyFunction[Any, Int] <: MyFunction[Int,Any]
  // Int <: Any && Int <: Any == true

  val l = (x: Int) => x + 1

  val f2 = new GreaterThanZero()
  println(f2(10)) // true
  println(f2(0)) // false
}
