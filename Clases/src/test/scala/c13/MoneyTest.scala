package c13

class MoneyTest extends munit.FunSuite {
  var f12CLP: Money = _
  var f14CLP: Money = _
  var f7USD: Money = _
  var f21USD: Money = _
  var fMB1: MoneyBag = _
  var fMB2: MoneyBag = _
  var fMBempty: MoneyBag = _

  override def beforeEach(context: BeforeEach): Unit = {
    f12CLP = new Money(12, "CLP")
    f14CLP = new Money(14, "CLP")
    f7USD = new Money(7, "USD")
    f21USD = new Money(21, "USD")
    fMBempty = new MoneyBag()
    new MoneyBag(List(f12CLP, f7USD, f14CLP, f21USD))
    fMB1 = new MoneyBag(f12CLP, f7USD)
    fMB2 = new MoneyBag(f14CLP, f21USD)
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

  test("equals moneybag") {
    assertEquals(fMB1, fMB1)
    assert(!fMB1.equals(f12CLP))
    assert(!f12CLP.equals(fMB1))
    assert(!fMB2.equals(fMB1))
  }
  test("moneybag appendMoney") {
    assert(fMBempty.isEmpty())
    fMBempty.appendMoney(f12CLP)
    assertEquals(fMBempty.get("CLP"), Some(f12CLP))

    fMBempty.appendMoney(f14CLP)
    assertEquals(fMBempty.get("CLP"), Some(new Money(26, "CLP")))
  }

  test("equals entre moneybags") {
    fMBempty.appendMoney(f12CLP)
    fMBempty.appendMoney(f7USD)
    assertEquals(fMB1, fMBempty)
  }

  test("add different currencies") {
    val bag = new MoneyBag()
    bag.appendMoney(f12CLP)
    bag.appendMoney(f7USD)
    assertEquals(f12CLP.add(f7USD), bag)
  }
}
