package ar.edu.unq.suit

import ar.edu.unq.utils.BaseSpec

class SuitHeavySpec extends BaseSpec {

  var distance = 5

  " " should "run " in {
    var suit1= new Suit with SuitHeavy

    suit1.walk(distance)
    suit1.getCantOxygen shouldBe(4000)

  }
}
