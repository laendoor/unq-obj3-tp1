package ar.edu.unq.bags

trait NoPropulsion {
  var fuel: Double = 0.0
  var gravity: Double = 9.8
  var altitude: Double = 0.0
  def propulsionTime: Int = 0
  def ascend(time: Int): Unit = {}
  def consumeFuelFor(time: Int) = {}
}

trait Propulsion extends Bag {
  override def propulsionTime: Int = (fuel / weight).floor.toInt
  override def consumeFuelFor(time: Int) = {
    fuel = Math.max(0, fuel - time * weight)
  }
  override def ascend(time: Int): Unit = {
    val ascendingTime = Math.min(time, propulsionTime)
    this consumeFuelFor ascendingTime
    altitude += ascendingTime / 2
  }
}
