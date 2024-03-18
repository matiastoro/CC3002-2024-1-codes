package c02

class Point(private var x: Int, private var y: Int) extends IPoint {

  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
  }
}
