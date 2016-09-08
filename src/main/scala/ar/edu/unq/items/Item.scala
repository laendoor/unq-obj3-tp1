package ar.edu.unq.items

abstract class Item(var volume: Int, val mass: Double = 0.0, var energy: Double) {
  def compact: Item
  def dehydrate: Item
  def receiveHit(damage: Double): Unit = {
    energy = Math.max(0, energy - damage)
  }
}

abstract class InorganicItem(volume: Int, mass: Double, energy: Double)
extends Item(volume, mass, energy) {
  override def dehydrate: Item = this
}

abstract class OrganicItem(vol: Int, mass: Double, energy: Double, waterVolume: Int)
extends Item(vol, mass, energy) {
  var wv = waterVolume
  override def dehydrate: Item = {
    volume -= wv
    this
  }
}
