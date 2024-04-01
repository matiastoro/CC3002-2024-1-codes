package c05

trait Tree {
  def sum(): Int
  def min(): Int
  def max(): Int
}
class Node(val value: Int, val left: Tree, val right: Tree) extends Tree {
  def sum(): Int = value + left.sum() + right.sum()
  def min(): Int = Math.min(value, Math.min(left.min(), right.min()))
  def max(): Int = Math.max(value, Math.max(left.max(), right.max()))

  def combine(doOp: Tree => Int, combine: (Int, Int) => Int): Int = {
    combine(value, combine(doOp(left), doOp(right)))
  }
  def sumEz() = combine((t) => t.sum(), (x, y) => x + y)
  def minEz() = combine((t) => t.min(), (x, y) => Math.min(x, y))
  def maxEz() = combine((t) => t.max(), (x, y) => Math.max(x, y))
}

class Leaf(val value: Int) extends Tree {
  def sum(): Int = value
  def max(): Int = value
  def min(): Int = value
}

class EmptyNode extends Tree {
  def sum(): Int = 0
  def max(): Int = Integer.MIN_VALUE
  def min(): Int = Integer.MAX_VALUE
}
