package ar.edu.unq.bags


trait VacuumCompaction extends Bag {

  def compact: Unit = items.foreach { item => item.compact }

}

trait Dehydrator extends Bag {

  def dehydrate: Unit = items.foreach { item => item.dehydrate }

}
