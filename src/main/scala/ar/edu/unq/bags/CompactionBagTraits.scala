package ar.edu.unq.bags


trait VacuumCompaction extends Bag {

  override def compact(): Unit = items.foreach { item => item.compact }

}

trait Dehydrator extends Bag {

  override def dehydrate(): Unit = items.foreach { item => item.dehydrate }

}
