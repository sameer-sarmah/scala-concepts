

object ExtractorDemo extends App {
  var instance=Extractor(1,"one")
  println(instance)
  val (intValue,strValue)= instance match {
    case Extractor(intValue,strValue) => {
      (intValue,strValue)
    }
  }
  println(s"${intValue}  ${strValue}")
}

class Extractor(val intValue:Int, val strValue:String){
  override def toString():String={
   s"${this.intValue}  ${this.strValue}"
  }
}

object Extractor{
def apply(intValue:Int, strValue:String)=new Extractor(intValue,strValue)//factory method
   def unapply(instance: Extractor): Option[(Int, String)] = {
     return Some(instance.intValue, instance.strValue)
   }
}