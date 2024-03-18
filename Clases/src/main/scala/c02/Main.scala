package c02

object Main{
  def foo(m: Movable) = {
    m.move(1,1)
    println("Success!")
  }
  def main(args: Array[String]): Unit = {
    val p = new Point(0,0)
    foo(p)
    val r = new Rectangle(p, 100, 200)
    foo(r)
  }
}
