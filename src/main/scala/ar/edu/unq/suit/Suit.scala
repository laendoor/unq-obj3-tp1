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
      this.setCantidad(10)
    else
      this.setCantidad(distancia * 0.15)

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

    this.setCantidad(distancia * 0.20)
    this.cantidad = cantidad + 10

  }
}