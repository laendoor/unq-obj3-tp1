package ar.edu.unq.characteristicsBag

import ar.edu.unq.bags.LargeBag
import ar.edu.unq.characteristicsBags.CopactEmpty
import ar.edu.unq.utils.BaseSpec
import ar.edu.unq.items.Rock
import ar.edu.unq.items.ItemCompact


class CopactEmptySpec extends BaseSpec {

  val bag = new LargeBag with CopactEmpty
  val item = new Rock(10000)
  val item2 = new ItemCompact(50000)
  bag store(item)


  "Mi primer Prueba" should "Debe bajar el volumen de la mochila " in {

    bag.free_space shouldBe  80000
    bag.compacting(this.bag)
    bag store(item2)
    bag.free_space shouldBe  30000

  }

}


