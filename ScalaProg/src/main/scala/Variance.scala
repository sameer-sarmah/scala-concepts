

object Variance extends App{
val c1 = new Cell[String]("initial")
val c2: Cell[String] = c1
c2.set("updated")
val s: String = c1.get
println(s)
}

class Cell[T](init: T) {
private[this] var current = init
def get = current
def set(x: T) ={ current = x }
}