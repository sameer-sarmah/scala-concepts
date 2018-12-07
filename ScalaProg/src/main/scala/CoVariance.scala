trait Fruit {
  def name: String
}

case class Orange() extends Fruit {
  def name: String = "Orange"
}

case class Apple() extends Fruit {
  def name: String = "Apple"
}

class McIntosh() extends Apple {
  override def name: String = "McIntosh"
}

class Gala() extends Apple {
  override def name: String = "Gala"
}


case class Basket[+T]() {
  def name: String = "AppleBasket"
}


object CoVariance extends App {
  val appleBasket = Basket[Apple]()
  val mcIntoshBasket = Basket[McIntosh]()
  val orangeBasket = Basket[Orange]()
  basketDetails(appleBasket)
  basketDetails(mcIntoshBasket)
  //basketDetails(orangeBasket) not allowed

  //accepts Basket[Apple] or its subclasses
  //since McIntosh is a subclass of Apple ,Basket[McIntosh] is a subclass of Basket[Apple]
  def basketDetails(basket: Basket[Apple]) = {
    println(s"this is a ${basket.name}")
  }

}