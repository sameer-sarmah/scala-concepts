//it is also called self referential types or recursive types
trait Entity[T <: Entity[T]]{
  self:T =>
  def create(item:T):T
  def delete( id:String):Unit
  def update(item:T):T
  def read(id: String):T
}

//class Product extends Entity[Order] should not be allowed ,only Product extends Entity[Product] should be allowed
//also class Order extends Entity[Product] should not be allowed,therefore we have introduced self type
class Product(name:String) extends Entity[ Product ]{
  override def create(item: Product): Product = ???

  override def delete(id: String): Unit = ???

  override def update(item: Product): Product = ???

  override def read(id: String): Product = ???
}

class Order(name:String) extends Entity[Order]{
  override def create(item: Order): Order = ???

  override def delete(id: String): Unit = ???

  override def update(item: Order): Order = ???

  override def read(id: String): Order = ???
}

