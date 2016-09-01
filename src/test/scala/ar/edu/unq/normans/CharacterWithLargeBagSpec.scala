package ar.edu.unq.normans

import ar.edu.unq.bags.{LargeStoring, LargeBag}

class CharacterWithLargeBagSpec extends CharacterWithBagSpec with LargeStoring {

  val miles = new Character
  miles.bag = new LargeBag

}
