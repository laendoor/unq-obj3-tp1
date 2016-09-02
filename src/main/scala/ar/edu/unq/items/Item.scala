package ar.edu.unq.items

abstract class Item(var volume: Int, var compacted: Boolean = false) {
  def compact: Unit = compacted = true
  def Dehydration: Int = 0
}


class Rock(volume: Int) extends Item(volume)
  with NonCompacting

class Ball(volume: Int) extends Item(volume)
  with Compacting

class Paper(volume: Int, compactPoints: Int) extends Item(volume)
  with SemiCompacting {
    override val cp: Int = compactPoints
}

class OrganicItem(volume: Int) extends Item(volume) {
    var agua = 5
  override def Dehydration: Int = this.volume - this.agua
}
