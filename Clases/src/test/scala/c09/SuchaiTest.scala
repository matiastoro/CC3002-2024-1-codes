package c09

import scala.collection.mutable.ListBuffer

class SuchaiTest extends munit.FunSuite {
  var suchai: Suchai = _
  override def beforeEach(context: BeforeEach): Unit = {
    suchai = new Suchai(0, ListBuffer())
  }

  test("rotate") {
    suchai.doCommand(new Rotate(10))
    assertEquals(suchai.getAngle(), 10.0)
  }
  test("take picture") {
    suchai.doCommand(new TakePicture())
    suchai.doCommand(new TakePicture())
    suchai.doCommand(new TakePicture())
    assertEquals(suchai.getNumberOfPhotos(), 3)
  }

  test("invert angle") {
    suchai.doCommand(new Rotate(180))
    suchai.doCommand(new InvertAngle())
    assertEquals(suchai.getAngle(), -180.0)
  }
}
