package ar.edu.unq.items

abstract class Item(val volume: Int) {
   def compact: Int
   def Dehydration: Int = 0
}


class Rock(volume: Int) extends Item(volume) {
  override def compact: Int = 0}

class OrganicItem(volume: Int) extends Item(volume) {
    var agua = 5
  override def compact: Int = 0
  override def Dehydration: Int = this.volume - this.agua
}

class ItemCompact(volume: Int) extends Item(volume) {
  override def compact: Int = this.volume -2 // hace la division
}

class ItemSemiCompact(volume: Int) extends Item(volume) {
  override def compact: Int = this.volume - 10
}