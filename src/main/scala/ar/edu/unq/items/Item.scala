package ar.edu.unq.items

abstract class Item(var volume: Int, var compacted: Boolean = false) {
  def compact: Unit = compacted = true
  def dehydrate: Unit
  def isOrganic: Boolean
}

abstract class InorganicItem(volume: Int) extends Item(volume) {
  override def dehydrate {}
  override def isOrganic: Boolean = false
}

abstract class OrganicItem(vol: Int, waterVolume: Int) extends Item(vol) {
  var wv = waterVolume

  override def isOrganic: Boolean = true

  override def dehydrate: Unit = {
    volume = volume - wv
    wv = 0
  }
}
