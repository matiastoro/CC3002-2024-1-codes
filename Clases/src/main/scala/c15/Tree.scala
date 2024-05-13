trait Tree[T <: Comparable[T]] {
  def exists(x: T): Boolean
  def max(): T
}
class Node[T <: Comparable[T]](value: T, left: Tree[T], right: Tree[T])
    extends Tree[T] {
  def exists(x: T): Boolean = {
    x.compareTo(value) == 0 || left.exists(x) || right.exists(x)
  }
  def max(): T = {
    val maxLeft = left.max()
    val maxRight = right.max()
    if (value.compareTo(maxLeft) >= 0 && value.compareTo(maxRight) >= 0) value
    else if (maxLeft.compareTo(maxRight) >= 0) maxLeft
    else maxRight
  }
}
class Leaf[T <: Comparable[T]](value: T) extends Tree[T] {
  def exists(x: T): Boolean = x.compareTo(value) == 0

  def max(): T = value
}

class Person(val name: String, val edad: Int) extends Comparable[Person] {
  def compareTo(other: Person) = edad - other.edad
}
class Foo extends Comparable[Foo] {
  def compareTo(other: Foo) = 1
}
object Main {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("Pepe", 20)
    val p2 = new Person("Jose Alberto", 15)
    val p3 = new Person("Juan", 18)
    val t: Tree[Person] =
      new Node[Person](p3, new Leaf[Person](p1), new Leaf[Person](p2))
    if (t.max() == p1) println("Tariamos")
    else println("wtf")

    // new Leaf[Int](10)
    new Leaf[Person](p1)
    new Leaf[Foo](new Foo())
  }
}
