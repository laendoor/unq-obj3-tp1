package ar.edu.unq.bags

trait NoPropulsionBag {
  var fuel: Double = 0.0
  def propulsionTime: Int = 0
  def consumeFuelFor(time: Int) {}
}

trait PropulsionBag extends Bag {
  override def propulsionTime: Int = (fuel / occupiedWeight).floor.toInt
  override def consumeFuelFor(time: Int) = {
    fuel = Math.max(0, fuel - time * occupiedWeight)
  }
}
