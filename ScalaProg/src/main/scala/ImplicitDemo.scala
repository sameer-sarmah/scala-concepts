

object ImplicitDemo extends App {
  var d = Dollar(50)
  var e = Euro(30)
  ForeignExchange.printDollar(e)
  ForeignExchange.printEuro(d)


  var one = new Num(1)
  var two = new Num(2)
  println(one + two)
  println(1 + two)
}

package IntConversion {

  object IntConv {
    implicit def intToNum(num: Int): Num = new Num(num) //implicit use case
  }

}

case class Dollar(var value: Double)

object Dollar {
  implicit def dollarToEuro(d: Dollar): Euro = {
    Euro(d.value / 1.4)
  }
}

case class Euro(var value: Double)

object Euro {
  implicit def euroToDollar(e: Euro): Dollar = {
    Dollar(e.value * 1.4)
  }
}

object ForeignExchange {
  def printDollar(d: Dollar): Unit = {
    println(d.value)
  }

  def printEuro(e: Euro): Unit = {
    println(e.value)
  }
}
