
//the program shows the use of implicit
 class NumberOpOverloading(var value: Int) {
  require(value>0)
  def +(r: NumberOpOverloading): Int = {
    this.value + r.value
  }
  def +(num: Int): Int = {
    this.value + num
  }

  def -(r: NumberOpOverloading): Int = {
    this.value - r.value
  }

  def -(num: Int): Int = {
    this.value - num
  }
  def *(r: NumberOpOverloading): Int = {
    this.value * r.value
  }

  def *(num: Int): Int = {
    this.value * num
  }

  def /(r: NumberOpOverloading): Int = {
    this.value / r.value
  }

  def /(num: Int): Int = {
    this.value / num
  }

  override def equals(r: Any): Boolean = {
    if (r.isInstanceOf[NumberOpOverloading] && (r.asInstanceOf[NumberOpOverloading]).value == this.value)
      true
    else
      false
  }
  
  override def toString():String={
    " the number is ${value}"
  }
}

object NumberOpOverloading extends App{
  implicit def intToNum(num:Int):NumberOpOverloading= new NumberOpOverloading(num)//implicit use case
  var one=new NumberOpOverloading(1)
  var two=new NumberOpOverloading(2)
  println(one + two)
  println(1 + two)
}