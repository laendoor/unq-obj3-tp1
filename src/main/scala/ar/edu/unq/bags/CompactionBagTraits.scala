package ar.edu.unq.bags
import ar.edu.unq.items.Item


trait VacuumCompaction extends Bag {
  override def store(item: Item) = super.store (item compact)
}

trait Dehydration extends Bag {
  override def store(item: Item) = super.store (item dehydrate)
}
