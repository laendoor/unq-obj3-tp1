package ar.edu.unq.suit

import ar.edu.unq.utils.BaseSpec


class SuitLightSpec extends BaseSpec {

  var distance = 100

  " " should "run " in {
    var suit1= new Suit with SuitLight

    suit1.walk(distance)
    suit1.getCantOxygen shouldBe(1490)

  }
}
