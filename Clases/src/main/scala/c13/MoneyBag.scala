package c13

import scala.collection.mutable.{HashMap, Map}

class MoneyBag extends IMoney {
  // {"CLP": Money(25, "CLP"), ...}
  private val bolsita: Map[String, Money] = HashMap[String, Money]()
None
  bolsita.equals(bolsita)
  def this(bag: List[Money]) = {
    this()
    for (m <- bag) {
      appendMoney(m)
    }
    // bag.foreach(m => appendMoney(m))
  }

  def this(m1: Money, m2: Money) = {
    this(List(m1, m2))
  }

  // if(false) 1 else 2
  // 1 if True else 2
  def appendMoney(money: Money): Unit = {
    val newMoney: Money = if (bolsita.isDefinedAt(money.getCurrency())) {
      // extender money con lo que está mas lo que recibimos
      val actual: Money = bolsita.get(money.getCurrency()).get
      actual.añadirMismaMoneda(money)
    } else {
      // extender map con el nuevo money
      money
    }
    // val newMoney2 =
    //  bolsita.get(money.getCurrency()).map(m => m.add(money)).getOrElse(money)
    // extendemos la bolsita
    bolsita += (money.getCurrency() -> newMoney)

  }

  def isEmpty(): Boolean = bolsita.isEmpty
  def get(currency: String): Option[Money] = bolsita.get(currency)

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[MoneyBag]) {
      val that = obj.asInstanceOf[MoneyBag]
      bolsita == that.bolsita
    } else
      false
  }

  def add(other: IMoney): IMoney = {
    other.addMoneyBag(this)
  }

  def addMoney(m: Money): IMoney = {
    appendMoney(m)
    this
  }

  def addMoneyBag(mb: MoneyBag): IMoney = {
    for ((_, money) <- mb.bolsita) {
      appendMoney(money)
    }
    this
  }
}
