

object AbstractType extends App{
  var grass=new Grass()
  var cow =new Cow()
  cow.eat(grass)
  
 var fish=new Fish()
 var cat=new Cat()
 cat.eat(fish) 
 var animalsThatEatGrass:List[Animal{type SuitableFood=Grass}]=Nil
}

class Food
abstract class Animal {
type SuitableFood <: Food
def eat(food: SuitableFood)
}

class Grass extends Food
class Cow extends Animal {
type SuitableFood = Grass
override def eat(food: Grass) {
  println( "eating grass")
}
}


class Fish extends Food
class Cat extends Animal {
type SuitableFood = Fish
override def eat(food: Fish) {
  println( "eating fish")
}
}

/*alternate usual approach
class Food
abstract class Animal[T <: Food] {
def eat(food: T)
}

class Grass extends Food
class Cow extends Animal[Grass] {
override def eat(food: Grass) {
  println( "eating grass")
}
}


class Fish extends Food
class Cat extends Animal[Fish] {
override def eat(food: Fish) {
   println( "eating fish")
}
}

*/