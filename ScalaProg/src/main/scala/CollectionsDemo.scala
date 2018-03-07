import scala.math._

object MapDemo {
  def main(args:Array[String]){
 
    
    var collection=1 to 10
    var evenNumberCalFunc=(num:Int)=> {
      if(num%2==0) 
         true
      else
         false
   
    }:Boolean
    var (even,odd)=collection.partition(evenNumberCalFunc)
    println(even)
    println(odd)
    
    var squareNumbers=(num:Int)=>{
     num*num
    }:Int

   var squaredNum:List[Int]=List.tabulate(5)(squareNumbers)
   println(squaredNum)
   
   var numbers=1 to 10
   var evenNumbers=numbers.filter(evenNumberCalFunc)
   println(evenNumbers)
   
   var transformedList=numbers.map(squareNumbers)
   println(transformedList)
    
  
   println(numbers.find(num=>num==5))
   
   var l=List(1,2,3)
   var l2=List(11,12,13)
   var v=Vector(4,5)
   var lv=l++v//merge the two collection take the type of left collection
   var vl=l++:v//merge the two collection take the type of right collection
   println(lv.getClass())
   println(vl.getClass())
   //alternate syntax to merge
   lv=l:::l2
   println(lv)

   println("prepends")
   l=l.+:(40)
   println(l)
//   println("appends")
//   l=l.:+(50)
//   println(l) 
   
   
   var tuple=(1,2,3)
   println(tuple)
   val (one,two,three)=tuple
   println(one)
   println( tuple._1)

   var mutableSet=scala.collection.mutable.HashSet[String]("val")
   mutableSet.add("abc")
   println("mutable set "+mutableSet)
   
    
   var immutableSet=scala.collection.immutable.HashSet[String]("val")
   immutableSet.+("acb")
   println("immutableSet set "+immutableSet)
   
    var map=Map("India"->"Delhi")
    map+=("Thailand"->"Bangkok")
    println(map)
   
    var sumFunc=(num1:Int,num2:Int)=>{
      println("numbers are "+num1+" & "+num2)
      num1+num2
    }:Int

    //limitation of reduce is that both the argument of the function passed should be same as well as the return type of the function
    println("reduce left ")
    numbers.reduceLeft(sumFunc)//reads numbers from the left,i.e index 0
    println("reduce right ")
    numbers.reduceRight(sumFunc)//reads numbers from the right,i.e index size-1
    println("reduce ")
    numbers.reduce(sumFunc)//order could be random 
    
      var concatFunc=(str1:String,str2:Int)=>{
      println("strings are "+str1+" & "+str2)
      str1+str2
    }:String
    println("fold left ")
    numbers.foldLeft("")((str1:String,str2:Int)=>{ println("strings are "+str1+" & "+str2) 
      str1+str2 })//reads numbers from the left,i.e index 0
    println("fold right ")
     numbers.foldRight("")((str1:Int,str2:String)=>{ println("strings are "+str1+" & "+str2) 
      str1+str2 })//reads numbers from the right,i.e index size-1



 
    
  }
}