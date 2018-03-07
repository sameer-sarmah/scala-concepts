

object PassByName extends App {
  
 def assertFunct(predicate:()=>Boolean)={
   if(!predicate()){
     throw new AssertionError("predicate failed")
   }
   else
   println ("Succeeded")
 }  
  
 def assertPassByName(predicate: => Boolean)={
   if(!predicate){
     throw new AssertionError("predicate failed")
   }
   else
     println ("Succeeded")
 } 
 
 try{
   assertFunct(()=>5>3)
   assertPassByName(5>3)
   assertPassByName(5>12)
 }
 catch{
   case e:AssertionError=>{
    println ("AssertionError encountered")
   }
 }
 
}