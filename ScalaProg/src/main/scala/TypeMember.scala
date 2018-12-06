import typeclasses.{Fish, Food, Grass}

object TypeMember extends App{
  var grass=new Grass()
  var cow =new Cow()
  cow.eat(grass)

 var fish=new Fish()
 var cat=new Cat()
 cat.eat(fish)
 var animalsThatEatGrass:List[Animal{type SuitableFood=Grass}]=Nil
}


abstract class Animal {
type SuitableFood <: Food
def eat(food: SuitableFood)
}

class Cow extends Animal {
type SuitableFood = Grass
override def eat(food: Grass) {
  println( "eating grass")
}
}

class Cat extends Animal {
type SuitableFood = Fish
override def eat(food: Fish) {
  println( "eating fish")
}
}

