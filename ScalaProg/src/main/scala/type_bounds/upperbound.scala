package type_bounds
trait Fruit{
  def name:String
}

case class Apple() extends Fruit{
  def name:String="Apple"
}

 class McIntosh() extends Apple{
   override def name:String="McIntosh"
}

 class Gala() extends Apple{
  override def name:String="Gala"
}


case class AppleBasket[T <: Apple](){
  val xs=List[T]()
  def add(apple:T)={
    xs.::(apple)
    println(s"${apple.name} is added to apple basket")
  }
}



object UpperBound extends App{
  val mcIntoshBasket=AppleBasket[McIntosh]()
  mcIntoshBasket.add(new McIntosh())
}