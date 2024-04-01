package c05

class TreeTest extends munit.FunSuite {
  val t = new Node(45, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(4))

  val tChueco = new Node(45, new Leaf(34), new EmptyNode)

  test("suma") {
    assertEquals(t.sum(), 121)
  }
  test("min") {
    assertEquals(t.min(), 4)
  }
  test("max") {
    assertEquals(t.max(), 45)
  }

  test("empty node") {
    assertEquals(tChueco.min(), 34)
    assertEquals(tChueco.max(), 45)
    assertEquals(tChueco.sum(), 34 + 45)
  }
}
