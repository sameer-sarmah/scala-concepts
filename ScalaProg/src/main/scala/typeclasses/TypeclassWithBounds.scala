package typeclasses


trait Speciality
case class Medicine() extends Speciality{
  override def toString: String = "Medicine"
}
case class ComputerScience() extends Speciality{
  override def toString: String = "ComputerScience"
}

trait Job[T <: Speciality]{
  def work(skill:T)
}
case class Doctor() extends Job[Medicine]{
  override def work(skill: Medicine): Unit = {
    println(s"Speciality is ${skill} and they heal people")
  }
}
case class SoftwareEngineer() extends Job[ComputerScience]{
  override def work(skill: ComputerScience): Unit = {
    println(s"Speciality is ${skill} and they build software")
  }
}

object TypeclassWithBounds extends App{
  val med=Medicine()
  val doctor = Doctor()
  doctor.work(med)
  val cs=ComputerScience()
  val eng=SoftwareEngineer()
  eng.work(cs)
}