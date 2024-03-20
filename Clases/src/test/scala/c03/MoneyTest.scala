package c03

class MoneyTest extends munit.FunSuite {
  var f12CLP: Money = _
  var f14CLP: Money = _
  var f10USD: Money = _

  override def beforeEach(context: BeforeEach): Unit = {
    f12CLP = new Money(12, "CLP")
    f14CLP = new Money(14, "CLP")
    f10USD = new Money(10, "USD")
  }

  test("1+1=2") {
    assertEquals(1 + 1, 2)
  }
  test("addMoney") {
    val expected = new Money(26, "CLP")
    assertEquals(f12CLP.add(f14CLP), expected)
  }
  test("equals") {
    assertEquals(f12CLP, f12CLP)
  }
  test("not equals") {
    assertNotEquals(f12CLP, f14CLP)
  }
  test("toString") {
    assertEquals(f12CLP.toString, "Money(12, CLP)")
  }

  test("add different currencies") {
    /*val bag = new MoneyBag()
    bag.add(f12CLP)
    bag.add(f10USD)
    assert(f12CLP.add(f10USD), bag)*/
  }
}
