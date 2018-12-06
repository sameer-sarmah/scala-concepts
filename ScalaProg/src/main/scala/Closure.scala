
object ClosureDemo extends App{
  
  var outerFunc=(errorCode:Int,exception:String)=>{
    
    val desp="Error encountered while processing request"
    var innerFunct=()=>{
      (errorCode,exception,desp)
    }
    innerFunct
  }
  var funcRef=outerFunc.apply(404, "UnauthorisedException")
  var tuple=funcRef.apply()
  println(tuple)
  val (errorCode,exception,desp)=tuple
  val ten=10
  def add10(num:Int)={
    num+ten
  }
  println(add10(4))
}