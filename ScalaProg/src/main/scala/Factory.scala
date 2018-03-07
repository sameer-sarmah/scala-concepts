

object Factory extends App {
  var m=MyClass(1,"one")
  println(m)
}

class MyClass(val p1:Int, val p2:String){
  override def toString():String={
   this.p1 +" "+this.p2
  }
}

object MyClass{
def apply(p1:Int, p2:String)=new MyClass(p1,p2)//factory method
}