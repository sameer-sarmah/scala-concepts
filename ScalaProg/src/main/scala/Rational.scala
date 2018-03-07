
//the program shows the use of implicit
class Num(var value: Int) {
  require(value>0)
  def +(r: Num): Int = {
    this.value + r.value
  }
  def +(num: Int): Int = {
    this.value + num
  }

  def -(r: Num): Int = {
    this.value - r.value
  }

  def -(num: Int): Int = {
    this.value - num
  }
  def *(r: Num): Int = {
    this.value * r.value
  }

  def *(num: Int): Int = {
    this.value * num
  }

  def /(r: Num): Int = {
    this.value / r.value
  }

  def /(num: Int): Int = {
    this.value / num
  }

  override def equals(r: Any): Boolean = {
    if (r.isInstanceOf[Num] && (r.asInstanceOf[Num]).value == this.value)
      true
    else
      false
  }
  
  override def toString():String={
    " the number is ${value}"
  }
}

object Num extends App{
  implicit def intToNum(num:Int):Num= new Num(num)//implicit use case
  var one=new Num(1)
  var two=new Num(2)
  println(one + two)
  println(1 + two)
}