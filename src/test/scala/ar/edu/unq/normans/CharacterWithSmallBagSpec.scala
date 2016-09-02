package ar.edu.unq.normans

import ar.edu.unq.bags.{SmallBag, SmallStoring}

class CharacterWithSmallBagSpec extends CharacterWithBagSpec with SmallStoring {

  val miles = new Character
  miles.bag = new SmallBag

}
