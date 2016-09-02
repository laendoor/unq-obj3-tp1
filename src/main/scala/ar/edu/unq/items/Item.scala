package ar.edu.unq.items

abstract class Item(var volume: Int, var energy: Double) {

  var compacted: Boolean = false

  def compact: Unit = compacted = true
  def dehydrate {}
  def isOrganic: Boolean
  def receiveHit(damage: Double): Unit = {
    energy = if (damage < energy) energy - damage else 0
  }
}

abstract class InorganicItem(volume: Int, energy: Double) extends Item(volume, energy) {
  override def isOrganic: Boolean = false
}

abstract class OrganicItem(vol: Int, energy: Double, waterVolume: Int)
  extends Item(vol, energy: Double) {

    var wv = waterVolume
    override def isOrganic: Boolean = true
    override def dehydrate: Unit = {
      volume = volume - wv
      wv = 0
    }
}
