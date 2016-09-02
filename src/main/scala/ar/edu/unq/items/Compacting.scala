package ar.edu.unq.items

trait Compacting extends Item {
  override def compact: Unit = {
    if (!compacted) volume = volume / 2
    super.compact
  }
}

trait NonCompacting extends Item {
  override def compact: Unit = super.compact
}

trait SemiCompacting extends Item {

  val cp: Int

  override def compact: Unit = {
    volume = volume - cp
    super.compact
  }
}