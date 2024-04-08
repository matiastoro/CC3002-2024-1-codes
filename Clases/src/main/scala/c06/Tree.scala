package c06

import java.util.Collections

trait Tree extends Comparable[Tree] {
  def sum(): Int
  def min(): Int
  def max(): Int
}
abstract class AbstractTree extends Tree {
  def compareTo(o: Tree) = sum().compareTo(o.sum())
}
class Node(val value: Int, val left: Tree, val right: Tree)
    extends AbstractTree {
  def sum(): Int = value + left.sum() + right.sum()
  def min(): Int = Math.min(value, Math.min(left.min(), right.min()))
  def max(): Int = Math.max(value, Math.max(left.max(), right.max()))
}

class Leaf(val value: Int) extends AbstractTree {
  def sum(): Int = value
  def max(): Int = value
  def min(): Int = value
}

class EmptyNode extends AbstractTree {
  def sum(): Int = 0
  def max(): Int = Integer.MIN_VALUE
  def min(): Int = Integer.MAX_VALUE
}

object Main {

  def main(args: Array[String]): Unit = {
    val t1 = new Leaf(10)
    val t2 = new Leaf(30)
    println(t1.compareTo(t2))
    
  }
}
