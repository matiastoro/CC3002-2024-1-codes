package c13

trait Hand {
  def play(h: Hand): Int
  def playWithStone(s: Stone): Int
  def playWithScissor(s: Scissor): Int
  def playWithPaper(s: Paper): Int
}
case class Stone() extends Hand {
  def play(h: Hand): Int = h.playWithStone(this)
  def playWithStone(s: Stone): Int = 0
  // scissor.play(stone) =por double dispatch=> stone.playWithScissor(scissor)
  def playWithScissor(s: Scissor): Int = -1
  def playWithPaper(s: Paper): Int = 1
}

case class Scissor() extends Hand {
  def play(h: Hand): Int = h.playWithScissor(this)
  def playWithStone(s: Stone): Int = 1
  def playWithScissor(s: Scissor): Int = 0
  def playWithPaper(s: Paper): Int = -1
}
case class Paper() extends Hand {
  def play(h: Hand): Int = h.playWithPaper(this)
  def playWithStone(s: Stone): Int = -1
  def playWithScissor(s: Scissor): Int = 1
  def playWithPaper(s: Paper): Int = 0
}

object FunctionalProgrammingApproachSneakPeak {
  def play(h1: Hand, h2: Hand): Int = {
    (h1, h2) match {
      case (a, b) if a == b     => 0
      case (Stone(), Paper())   => -1
      case (Paper(), Scissor()) => -1
      case (Scissor(), Stone()) => -1
      case (a, b)               => -1 * play(b, a)
    }
  }
}
