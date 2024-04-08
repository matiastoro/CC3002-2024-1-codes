package c07

class Person {
  def eat(): Int = 1
}
class Student extends Person {
  def fail(): String = "ggwp"
}
@main
def main() = {
  def feed(p: Person) = {
    p.eat()
  }
  def id(p: Person): Person = p

  val b: Person = new Student()
  feed(b)
  // id: Person => Person
  // id(new Student()).fail()
  // println(b.fail())

  def buenaPregunta[T](x: T): T = x
  buenaPregunta(b)
  buenaPregunta(new Student())
}
