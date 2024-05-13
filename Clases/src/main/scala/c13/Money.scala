package c13

class Money(fAmount: Int, fCurrency: String) extends IMoney {
  def getAmount(): Int = fAmount
  def getCurrency(): String = fCurrency

  def añadirMismaMoneda(other: Money): Money = {
    if (other.getCurrency() == fCurrency)
      new Money(fAmount + other.getAmount(), fCurrency)
    else throw new Exception("WTF!")
  }
  def add(other: IMoney): IMoney = {
    other.addMoney(this)
  }
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val otherCast = other.asInstanceOf[Money]
      getAmount() == otherCast.getAmount() &&
      getCurrency() == otherCast.getCurrency()
    } else false
  }
  override def toString: String = s"Money(${fAmount}, ${fCurrency})"

  def addMoney(m: Money): IMoney = {
    if (this.getCurrency() == m.getCurrency())
      añadirMismaMoneda(m)
    else
      new MoneyBag(this, m)
  }

  def addMoneyBag(mb: MoneyBag): IMoney = {
    mb.addMoney(this)
  }
}
