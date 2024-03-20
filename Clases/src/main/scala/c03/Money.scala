package c03

class Money(fAmount: Int, fCurrency: String) {
  def getAmount(): Int = fAmount
  def getCurrency(): String = fCurrency

  def add(other: Money): Money = {
    new Money(fAmount + other.getAmount(), fCurrency)
  }
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val otherCast = other.asInstanceOf[Money]
      getAmount() == otherCast.getAmount() &&
      getCurrency() == otherCast.getCurrency()
    } else false
  }
  override def toString: String = s"Money(${fAmount}, ${fCurrency})"
}
