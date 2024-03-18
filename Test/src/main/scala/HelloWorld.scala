import scala.io.StdIn

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val name = StdIn.readLine()

    println(s"Tu nombre es ${name}")
  }
}
