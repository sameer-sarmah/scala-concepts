

object TypeMember extends App{
  val med=Medicine()
  val doctor = Doctor()
  doctor.work(med)
  val cs=ComputerScience()
  val eng=SoftwareEngineer()
  eng.work(cs)
}


trait Speciality
case class Medicine() extends Speciality{
  override def toString: String = "Medicine"
}
case class ComputerScience() extends Speciality{
  override def toString: String = "ComputerScience"
}

trait Job{
  type Skills <: Speciality
  def work(skill:Skills)
}
case class Doctor() extends Job{
  type Skills=Medicine

  override def work(skill: Medicine): Unit = {
    println(s"Speciality is ${skill} and they heal people")
  }
}
case class SoftwareEngineer() extends Job{
  type Skills=ComputerScience
  override def work(skill: ComputerScience): Unit = {
    println(s"Speciality is ${skill} and they build software")
  }
}



