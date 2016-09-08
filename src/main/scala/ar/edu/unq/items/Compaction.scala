package ar.edu.unq.items

trait NonCompaction extends Item {
  override def compact: Item = this
}

trait Compaction extends Item {
  override def compact: Item = {
    volume /= 2
    this
  }
}

trait SemiCompaction extends Item {
  var cp: Int = 0
  override def compact: Item = {
    volume -= cp
    this
  }
}