package c09

trait Command {
  def execute(s: Satelite): Unit
}

class Rotate(delta: Double) extends Command {
  def execute(s: Satelite) = s.setAngle(delta)
}

class TakePicture extends Command {
  def execute(s: Satelite) = {
    s.takePhoto()
  }
}
class InvertAngle extends Command {
  def execute(s: Satelite) = s.setAngle(-2 * s.getAngle())
}
