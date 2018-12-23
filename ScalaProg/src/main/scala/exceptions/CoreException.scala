package exceptions

 case class CoreException (val message:String,val statusCode:Int) extends Exception() {

}
