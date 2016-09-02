package ar.edu.unq.normans

import ar.edu.unq.bags._
import ar.edu.unq.bags.compaction.{DehydratationSpec, VacuumCompactionSpec}

class CharacterWithSmallBagSpec extends CharacterWithBagSpec
  with SmallStoring
  with VacuumCompactionSpec
  with DehydratationSpec {

  val miles = new Character
  miles.bag = new SmallBag with VacuumCompaction with Dehydrator

  override def compact: Unit = miles.bag compact
  override def dehydrate: Unit = miles.bag dehydrate
}
