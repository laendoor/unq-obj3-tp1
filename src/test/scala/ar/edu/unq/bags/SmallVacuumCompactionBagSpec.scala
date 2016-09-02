package ar.edu.unq.bags

class SmallVacuumCompactionBagSpec extends BagSpec with VacuumCompactionSpec {

  val bag = new SmallBag with VacuumCompaction

  override def compact: Unit = bag compact

}

trait VacuumCompactionSpec extends Storeable with Compactable {
/*
  "A small bag with vacuum compaction" should "store a non-compactable rock and apply compaction and keep same free space" in {
    this store_rock_of 10000
    free_space shouldBe 30000
    compact
    free_space shouldBe 30000
  }

  it should "store a compactable ball and apply compaction and free space increases by 50% of ball volume" in {
    this store_ball_of 10000
    free_space shouldBe 30000
    compact
    free_space shouldBe 35000
  }

  it should "store a semi-compactable paper and apply compaction and free space increases by compaction-points of ball volume" in {
    this store_paper_of (10000, 2000)
    free_space shouldBe 30000
    compact
    free_space shouldBe 32000
  }
*/
}
