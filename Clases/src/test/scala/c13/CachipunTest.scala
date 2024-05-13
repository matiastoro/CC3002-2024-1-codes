package c13

class CachipunTest extends munit.FunSuite {
  val stone = new Stone()
  val scissor = new Scissor()
  val paper = new Paper()

  test("piedra juega izq") {
    assertEquals(1, stone.play(scissor))
    assertEquals(0, stone.play(stone))
    assertEquals(-1, stone.play(paper))
  }
  test("tijera juega izq") {
    assertEquals(-1, scissor.play(stone))
    assertEquals(0, scissor.play(scissor))
    assertEquals(1, scissor.play(paper))
  }
  test("papel juega izq") {
    assertEquals(-1, paper.play(scissor))
    assertEquals(0, paper.play(paper))
    assertEquals(1, paper.play(stone))
  }

}
