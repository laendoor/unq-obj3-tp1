package ar.edu.unq.normans

import ar.edu.unq.bags.{MediumBag, MediumStoring}

class CharacterWithMediumBagSpec extends CharacterWithBagSpec with MediumStoring {

  val miles = new Character
  miles.bag = new MediumBag

}
