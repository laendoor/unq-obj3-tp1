package ar.edu.unq.items

abstract class Item(var volume: Int, val mass: Double = 0.0, var energy: Double) {

  var compacted: Boolean = false

  def compact: Unit = compacted = true
  def dehydrate {}
  def isOrganic: Boolean
  def receiveHit(damage: Double): Unit = {
    energy = if (damage < energy) energy - damage else 0
  }
}

abstract class InorganicItem(volume: Int, mass: Double, energy: Double)
  extends Item(volume, mass, energy) {
    override def isOrganic: Boolean = false
}

abstract class OrganicItem(vol: Int, mass: Double, energy: Double, waterVolume: Int)
  extends Item(vol, mass, energy = energy) {

    var wv = waterVolume
    override def isOrganic: Boolean = true
    override def dehydrate: Unit = {
      volume = volume - wv
      wv = 0
    }
}
