package ar.edu.unq.bags

trait NoPropulsion {
  var fuel: Double = 0.0
  var gravity: Double = 9.8
  def propulsionTime: Int = 0
  def consumeFuelFor(time: Int) {}
}

trait Propulsion extends Bag {
  override def propulsionTime: Int = (fuel / occupiedWeight).floor.toInt
  override def consumeFuelFor(time: Int) = {
    fuel = Math.max(0, fuel - time * occupiedWeight)
  }
}
