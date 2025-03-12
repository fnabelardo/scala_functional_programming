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

  //Iterations
  /* print all combination between two list */
  val numbers = List(1, 2, 3, 4)
  val chars = List("a", "b", "c", "d")
  // List ("a1","a2", ... ,"a4")
  val combined = numbers.flatMap(x => chars.map(x + "" + _) )
  println("--Combined--")
  println(combined)

  val colors = List("red", "green", "blue")
  println("--Vocals-Numbers-Colors-Combined--")
  val combined2 = numbers.flatMap(x=> chars.flatMap(c => colors.map(c + "" + x + "" + _)))
  println("--Combined2--")
  println(combined2)

  //For-comprehension
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield (c + "" + n + "-" + color)
  println("--forCombination--")
  println(forCombinations)


  //Foreach
  list.foreach(println)


}
