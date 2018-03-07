


object TypeAlias extends App {

    type Row = List[Int]
    def Row(xs: Int*) = List(xs: _*)
 
    type Matrix = List[Row]
    def Matrix(xs: Row*) = List(xs: _*)
 
    val m = Matrix(Row(1,2,3),
                   Row(1,2,3),
                   Row(1,2,3))

    println(m)
    println(m.getClass)

}