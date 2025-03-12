package lectures.functional_programming

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3, 4)
  println(list) //Output: List(1, 2, 3, 4)
  println(list.head) //Output: 1
  println(list.tail) //Output: 4

  //map
  println("--Map--")
  println(list.map(_ + 1)) //Output: List(2, 3, 4, 5)
  println(list.map(_ + " is a number")) //Output: List(1 is a number, 2 is a number, 3 is a number, 4 is a number)

  //filter
  println("--Filter--")
  println(list.filter(_ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println("--flatMap--")
  println(list.flatMap(toPair)) //Output: List(1, 2, 2, 3, 3, 4, 4, 5)

}
