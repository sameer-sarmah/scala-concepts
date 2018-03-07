
case class KiloGram(value:BigDecimal)
case class KiloMeter(value:BigDecimal)
trait Quantity[A] {
  def unit(x:BigDecimal):A
  def value(a:A):BigDecimal
  def zero=()=>{unit(BigDecimal(0)) }:A
  def plus=(a1:A,a2:A)=>{ value(a1)+value(a2)}:BigDecimal
  def minus=(a1:A,a2:A)=>{ value(a1)-value(a2)}:BigDecimal
  def times=(a1:A,a2:A)=>{ value(a1)*value(a2)}:BigDecimal
  def divide=(a1:A,a2:A)=>{ value(a1)/value(a2)}:BigDecimal
}


object Driver {
  def main(arg:Array[String]){
    var kg:Quantity[KiloGram]=new Quantity[KiloGram]{
        override
        def unit(x:BigDecimal):KiloGram={
          KiloGram(x)
        }
        
        override
        def value(kg:KiloGram):BigDecimal={
          kg.value
        }
    }
    
      var km:Quantity[KiloMeter]=new Quantity[KiloMeter]{
        override
        def unit(x:BigDecimal):KiloMeter={
          KiloMeter(x)
        }
        
        override
        def value(km:KiloMeter):BigDecimal={
          km.value
        }
    }
      
      println(km.isInstanceOf[Quantity[KiloMeter]])
      var eightKM= km.plus(KiloMeter(5),KiloMeter(3))
      println(eightKM)
      
      implicit val tooFar=KiloMeter(5)
      implicit val tooHeavy=KiloGram(100)
      
      var method=( kilometer:KiloMeter, kilogram:KiloGram)=>{
        println(kilometer)
        println(kilogram)
        "implicit arguments"
      }
      method
     
  }
}