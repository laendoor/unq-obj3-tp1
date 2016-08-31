package ar.edu.unq.items

abstract class Item(var volume: Int, var tipo: String) {
  abstract def compact: Int
   def desidratacion: Int = 0
}


class Rock(volume: Int) extends Item(volume,"Rock") {
  override def compact: Int = 0}

class OrganicItem(volume: Int) extends Item(volume,"organic") {
    var agua = 5
  override def compact: Int = 0
  override def desidratacion: Int = this.volume - this.agua
}

class ItemCompact(volume: Int) extends Item(volume,"compact") {
  override def compact: Int = this.volume/2
}

class ItemSemiCompact(volume: Int) extends Item(volume,"Semi") {
  override def compact: Int = this.volume - 10
}