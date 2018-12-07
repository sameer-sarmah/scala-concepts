
case class FruitBasket[-T]() {
  def name: String = "FruitBasket"
}

object ContraVariance extends App {
  val appleBasket = FruitBasket[Apple]()
  val mcIntoshBasket = FruitBasket[McIntosh]()
  val orangeBasket = FruitBasket[Orange]()
  basketDetails(appleBasket)
  basketDetails(mcIntoshBasket)
  //basketDetails(orangeBasket) not allowed

  // accepts FruitBasket[McIntosh] or its superclass
  //since Apple is a superclass of McIntosh ,Basket[Apple] is a superclass Basket[McIntosh]
  def basketDetails(basket: FruitBasket[McIntosh]) = {
    println(s"this is a ${basket.name}")
  }

}