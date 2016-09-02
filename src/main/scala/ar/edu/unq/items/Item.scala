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

<<<<<<< HEAD
class ItemCompact(volume: Int) extends Item(volume) {
  override def compact: Int = this.volume / 2
=======

class Rock(volume: Int) extends InorganicItem(volume)
  with NonCompacting

class Ball(volume: Int) extends InorganicItem(volume)
  with Compacting

class Paper(volume: Int, compactPoints: Int) extends InorganicItem(volume)
  with SemiCompacting {
    override val cp: Int = compactPoints
>>>>>>> cc8c16055d2da95a88854ae47f378bbe1b855f78
}

class Plant(volume: Int, waterVolume: Int) extends OrganicItem(volume, waterVolume)
