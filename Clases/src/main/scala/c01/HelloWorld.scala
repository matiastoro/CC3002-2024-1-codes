package c01

import scala.io.StdIn.readLine

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hola. Escribe tu nombre:")
    val name: String = readLine()
    println(s"Hola ${name}") //println("Hola "+name)

  }
}
