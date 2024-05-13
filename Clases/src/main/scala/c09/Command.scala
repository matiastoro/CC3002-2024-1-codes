package c09

trait Command {
  def execute(s: Satelite): Unit
}

class Rotate(delta: Double) extends Command {
  def execute(s: Satelite) = s.setAngle(delta)
}

class TakePicture extends Command {
  def execute(s: Satelite) = {
    s.takePhoto()
  }
}
class InvertAngle extends Command {
  def execute(s: Satelite) = s.setAngle(-2 * s.getAngle())
}

object M {

  class A(private var a: Int) {
    def foo() = {
      a += 1
    }
  }

  class B(var a: Int) extends A(a) {
    override def foo() = {
      a += 2
      super.foo()
    }
  }
  def main(args: Array[String]) = {
    val b: B = new B(10)
    b.foo()
    println(b.a)
  }

}
