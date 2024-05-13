package c13

trait IMoney {
  def add(m: IMoney): IMoney
  def addMoney(m: Money): IMoney
  def addMoneyBag(mb: MoneyBag): IMoney
}
