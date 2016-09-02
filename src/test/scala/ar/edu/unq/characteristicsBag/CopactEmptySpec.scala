package ar.edu.unq.characteristicsBag

import ar.edu.unq.bags.LargeBag
import ar.edu.unq.characteristicsBags.CopactEmpty
import ar.edu.unq.utils.BaseSpec
import ar.edu.unq.items.Plant

class CopactEmptySpec extends BaseSpec {

  val bag = new LargeBag with CopactEmpty
  val item = new Plant(10000,200)
  bag store(item)


  "Prueba" should "Debe bajar el volumen de la mochila " in {

    bag.free_space shouldBe  80000


  }

}


