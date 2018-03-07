
//traits with mixin
object TraitsDemo extends App{
  val _12 = new AnyRef with SubTrait1 with SubTrait2 with AnotherTrait
  val _21 = new AnyRef with SubTrait2 with SubTrait1
  _12.a
  _21.a
  _12.b
  
  println("vanilla Queue")
  val vanillaQueue=new ConcreteQueue[Int]
  vanillaQueue.enqueue(1)
  vanillaQueue.enqueue(2)
  println(vanillaQueue.dequeue())
  println(vanillaQueue.dequeue())
  
  println("incrementing Queue")
  val incQueue=new IncrementingQueue
  incQueue.enqueue(1)
  incQueue.enqueue(2)
  println(incQueue.dequeue())
  println(incQueue.dequeue())
  
  println("doubling Queue")
  val doublingQueue=new DoublingQueue
  doublingQueue.enqueue(1)
  doublingQueue.enqueue(2)
  println(doublingQueue.dequeue())
  println(doublingQueue.dequeue())
}

trait SuperTrait{
    def a = 1
}

trait SubTrait1 extends SuperTrait{
    override def a = {
        println("SubTrait1")
        super.a
    }
}  


trait SubTrait2 extends SuperTrait{
    override def a = {
        println("SubTrait2")
        super.a
    }
}


trait AnotherTrait {
     def b = {
        println("AnotherTrait")
    }
}

abstract class Queue[A]{
  def enqueue(a:A):Unit
  def dequeue():A
}

class ConcreteQueue[Int] extends Queue[Int]{
  import scala.collection.mutable.ListBuffer
  private var arr:ListBuffer[Int]=new ListBuffer[Int]()
  override def enqueue(num:Int):Unit={
  arr.+=(num)
  }
  override def dequeue():Int={
    arr.remove(0)
  }
}

trait Increment extends Queue[Int]{
   abstract override def enqueue(num:Int):Unit={
    super.enqueue(num+1)
  }
}

trait Doubling extends Queue[Int]{
   abstract override def enqueue(num:Int):Unit={
    super.enqueue(num*2)
  }
}

class IncrementingQueue extends ConcreteQueue[Int] with Increment
class DoublingQueue extends ConcreteQueue[Int] with Doubling