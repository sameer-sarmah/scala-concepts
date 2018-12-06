package typeclasses



trait Animal[T <: Food] {
  def eat(food: T)
}


class Cow extends Animal[Grass] {
  def eat(food: Grass)={
    println( "eating grass")
  }
}


class Cat extends Animal[Fish] {
  override def eat(food: Fish) {
    println( "eating fish")
  }
}

object TypeClassWithBounds extends App{
  var grass=new Grass()
  var cow =new Cow()
  cow.eat(grass)

  var fish=new Fish()
  var cat=new Cat()
  cat.eat(fish)
}