package c14

trait Option[T] {
  def get: T
  def isEmpty: Boolean
  def getOrElse[S >: T](default: S): S
}
class Some[T](v: T) extends Option[T] {
  def get: T = v
  def isEmpty: Boolean = false
  def getOrElse[S >: T](default: S): S = v
}

class None extends Option[Nothing] {
  def get: Nothing = throw new Exception("ouch")
  def isEmpty: Boolean = true
  def getOrElse[S>:Nothing](default: S): S = default
}
class A
class B extends A
@main
def main() = {
  val x: Some[B] = new Some[B](new B())
  val z = x.getOrElse(new A())
  z
}
