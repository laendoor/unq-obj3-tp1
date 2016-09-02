package ar.edu.unq.bags

class SmallBag extends Bag {
  override val weight = 40    // Newton = m*g
  override val volume = 40000 // cc3
}

class MediumBag extends Bag {
  override val weight = 60    // Newton
  override val volume = 60000 // cc3
}

class LargeBag extends Bag {
  override val weight = 90    // Newton
  override val volume = 90000 // cc3
}