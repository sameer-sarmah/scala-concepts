trait Serializable[T] {
  def serialize(instance: T): String
}

case class Person(name: String, age: Int)


case class Company(name: String, location: String)


object SerializerInventory {

  implicit object PersonSerializer extends Serializable[Person] {
    def serialize(person: Person): String = {
      return s"The name is ${person.name} and age is ${person.age}"
    }
  }

  implicit object CompanySerializer extends Serializable[Company] {
    def serialize(company: Company): String = {
      return s"The name is ${company.name} and location is ${company.location}"
    }
  }

}



object SerializableDemo extends App{

  def serialize[T](instance:T)(implicit serializer:Serializable[T]):String={
    return serializer.serialize(instance)
  }

  import SerializerInventory.CompanySerializer
  import SerializerInventory.PersonSerializer
  val sameer=Person("sameer",28)
  val sap=Company("SAP Labs","Bangalore")
  println(serialize(sameer))
  println(serialize(sap))
}
