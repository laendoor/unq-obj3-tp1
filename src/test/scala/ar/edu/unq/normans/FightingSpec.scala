package ar.edu.unq.normans

import ar.edu.unq.bags.SmallBag
import ar.edu.unq.suits.Suit
import ar.edu.unq.utils.BaseSpec

trait FightingSpec extends BaseSpec {

  "A character with 200 of energy and a regular space suit that receives damage by 100" should "have 100 of energy" in {
    val miles  = new Character
    miles.bag  = new SmallBag
    miles.suit = new Suit {
      override def walkConsume(kms: Int): Double = ???

      override var oxygen: Double = _
    }
    miles.energy = 200

    miles receiveHit 100
    miles.energy shouldBe 100
  }


  //  Traje regular: transmite el daño directo.
  //  Traje rígido: absorbe un porcentaje “x” del daño.
  //  Traje semi-rígido: resiste hasta X puntos de daño transmiento el excedente.
}
