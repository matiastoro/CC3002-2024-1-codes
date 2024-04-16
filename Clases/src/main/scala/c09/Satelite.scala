package c09

trait Satelite {
  def getAngle(): Double
  def setAngle(d: Double): Unit
  def takePhoto(): Unit
  def getNumberOfPhotos(): Int
  def doCommand(c: Command): Unit
}
