package c02


class Rectangle(private var p: IPoint,
                private var width: Int,
                private var height: Int) extends IRectangle{
  def move(dx: Int, dy: Int) = p.move(dx, dy)
  def area() = width*height
}
