package c04

class IrishSetter {
  def tailColor1: String = {
    println("hola def")
    "Red def"
  }
  val tailColor2: String = {
    println("hola val")
    "Red val"
  }
}
object Main {
  def main(arg: Array[String]): Unit = {
    val perro = new IrishSetter()
    println(perro.tailColor1)
    println(perro.tailColor1)

    println(perro.tailColor2)
    println(perro.tailColor2)
  }
}
