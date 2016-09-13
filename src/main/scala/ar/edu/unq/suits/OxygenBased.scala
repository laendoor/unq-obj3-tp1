package ar.edu.unq.suits

trait LightSuit {
  private var _oxygen: Double = 1500.0
  def oxygen = _oxygen
  def oxygen_= (o2: Double) = _oxygen = o2

  def walkConsume(kms: Int) = Math.min(10, kms * 0.15)
}

trait HeavySuit extends Suit {
  oxygen = 4000.0
  override def walkConsume(kms: Int) = kms * 0.20 - 10.0
}