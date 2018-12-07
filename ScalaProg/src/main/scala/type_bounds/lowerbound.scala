package type_bounds
trait Car{
  def name:String
}

case class SportsCar() extends Car{
  def name:String="SportsCar"
}

case class LuxurySedan() extends Car{
  override def name:String="LuxurySedan"
}

 class Ferrari() extends SportsCar{
  override def name:String="Ferrari"
}
 class Lambo() extends SportsCar{
  override def name:String="Lambo"
}
case class Truck(){
   def name:String="Truck"
}

case class FerrariServicing[ T >: Ferrari <: SportsCar](){
  val xs=List[T]()
  def park(car:T)={
    xs.::(car)
    println(s"${car.name} is added to service center")
  }
}


object LowerBound extends App{
  val serviceCentre = FerrariServicing()
  serviceCentre.park(new Ferrari())
  //serviceCentre.park(Truck()) compilation error as trucks are not allowed
  //serviceCentre.park(Lambo()) compilation error as Lambos are not allowed
}