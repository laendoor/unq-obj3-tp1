package ar.edu.unq.bags

import ar.edu.unq.utils.BaseSpec

abstract class BagSpec extends BaseSpec {

  val bag: Bag

  after {
    bag clear
  }

}
