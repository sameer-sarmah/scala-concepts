

object FP {
  def main(args: Array[String]) {
    var countryCap = new CountryCapital();
    println(countryCap("India"))
    //countryCap("Thailand")="Bangkok"
    println(countryCap.map)
    println(countryCap.getCapital("India"))
    var cc = countryCap
    println(cc.eq(countryCap)) //reference equality
    var cc2 = new CountryCapital();
    println(cc == cc2)  //content equality
    println(cc eq cc2)
    
      println("scurring using closure example,return a function")
      var scurryExmple=(num:Int)=>{
          var mulFactor=(mul:Int)=>{
           num*mul
         }:Int
         mulFactor
      }
      println(scurryExmple(5)(4))
      
      def saySomething(prefix: String) = (name: String) => {
          prefix + " " + name
      }
      
      var hellFunc=saySomething("Hello");
      println(hellFunc("sameer"))
      
      
      println("function as argument")
      var mulFunction=(num1:Int,num2:Int,mul:(Int,Int)=>Int)=>{
        mul(num1,num2)
      }
      var value=mulFunction(4,5,(num1:Int,num2:Int)=>{num1*num2})
      println(value)
      
      val f = (x: Int) => x * x
      println(f.getClass)//lamda
    
  }
}

class CountryCapital {
  var map = Map[String, String]("India" -> "Delhi")
  def apply(country: String): String = {
    this.map(country)
  }

  def update(country: String, capital: String): Unit = {
    this.map = this.map.+(country -> capital)
  }

  def getCapital(country: String): String = {
    this.map(country)
  }

  override def equals(cc: Any): Boolean = {
    if (cc.isInstanceOf[CountryCapital] && (cc.asInstanceOf[CountryCapital]).map == this.map)
      true
    else
      false
  }
}