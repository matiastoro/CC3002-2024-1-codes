package c09
import scala.collection.mutable.ListBuffer

class Suchai(
    private var angle: Double,
    private val photos: ListBuffer[Photo]
) extends Satelite {
  def setAngle(delta: Double) = {
    angle += delta
  }
  def takePhoto() = {
    val p = new Photo()
    photos += p
  }
  def getAngle(): Double = angle
  def getNumberOfPhotos(): Int = photos.size

  def doCommand(c: Command): Unit = {
    c.execute(this)
  }
}
