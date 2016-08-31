package ar.edu.unq.suit

class Suit {
  var cantOxygen  : Int =_
}

trait SuitLight extends Suit{
 var cant = 1500 : Double
  def getCant : Double  = {
    this.cant
  }

  def setCant(algo:Double) {
    this.cant = algo
  }

  def walk(distance:Int) {

    if ((distance * 0.15) > 10)
      this.cant -= 10
    else
      this.cant -= (distance * 0.15)

  }
}

trait SuitHeavy extends  Suit{
  var cant = 4000 : Double

  def getcant : Double  = {
    this.cant
  }

  def setCant(algo:Double) {
    this.cant = algo
  }

  def walk(distance:Int) {

    this.cant = this.getcant - distance * 0.20
    if (this.getcant + 10 > 4000)
        this.setCant(400) //falta un caso
      else
        this.cant += 10



  }
}