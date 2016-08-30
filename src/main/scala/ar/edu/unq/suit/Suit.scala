package ar.edu.unq.suit

class Suit {
  var cantOxigeno  : Int =_
}

trait SuitLight extends Suit{
 var cantidad = 1500 : Double
  def getcantidad : Double  = {
    this.cantidad
  }

  def setCantidad(algo:Double) {
    this.cantidad = algo
  }

  def walk(distancia:Int) {

    if ((distancia * 0.15) > 10)
      this.cantidad -= 10
    else
      this.cantidad-=(distancia * 0.15)

  }
}

trait SuitHeavy extends  Suit{
  var cantidad = 4000 : Double

  def getcantidad : Double  = {
    this.cantidad
  }

  def setCantidad(algo:Double) {
    this.cantidad = algo
  }

  def walk(distancia:Int) {

    this.cantidad = this.getcantidad - distancia * 0.20
    if (this.getcantidad + 10 > 4000)
        this.setCantidad(400) //falta un caso
      else
        this.cantidad += 10



  }
}