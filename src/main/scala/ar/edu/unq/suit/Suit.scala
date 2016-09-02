package ar.edu.unq.suit

class Suit {
  var cantOxygen  : Double =_

  def getCantOxygen : Double  = {
    this.cantOxygen
  }

  def setCantOxygen(algo:Double) {
    this.cantOxygen = algo
  }
}

trait SuitLight extends Suit{
   cantOxygen = 1500 : Double

  def walk(distance:Int)  {

    if ((distance * 0.15) > 10)
      this.cantOxygen -= 10
    else
      this.cantOxygen -= (distance * 0.15)

  }
}

trait SuitHeavy extends  Suit{
  cantOxygen = 4000 : Double


  def walk(distance:Int)  {

    this.cantOxygen = this.getCantOxygen - distance * 0.20
    if (this.getCantOxygen + 10 > 4000)
        this.setCantOxygen(4000)
      else
        this.cantOxygen += 10



  }
}