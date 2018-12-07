
case class FruitBasket[-T]() {
  def name: String = "FruitBasket"
}

object ContraVariance extends App {
  val objectBasket = FruitBasket[Any]()
  val appleBasket = FruitBasket[Apple]()
  val mcIntoshBasket = FruitBasket[McIntosh]()
  val orangeBasket = FruitBasket[Orange]()
  basketDetails(appleBasket)
  basketDetails(mcIntoshBasket)
  basketDetails(objectBasket)

  //basketDetails(orangeBasket) not allowed

  // accepts FruitBasket[McIntosh] or its subclass
  //since Apple is a superclass of McIntosh ,due to contravariance Basket[Apple] is a subclass Basket[McIntosh]
  def basketDetails(basket: FruitBasket[McIntosh]) = {
    println(s"this is a ${basket.name}")
  }

}