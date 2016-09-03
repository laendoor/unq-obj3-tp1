package ar.edu.unq.bags

// weight -> Newton = m*g
// volume -> cc3

class SmallBag extends Bag {
  override val weight = 40
  override val volume = 40000 // cc3
}

class MediumBag extends Bag {
  override val weight = 60
  override val volume = 60000 // cc3
}

class LargeBag extends Bag {
  override val weight = 90
  override val volume = 90000 // cc3
}