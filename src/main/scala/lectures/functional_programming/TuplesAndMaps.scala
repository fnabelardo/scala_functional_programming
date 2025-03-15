package lectures.functional_programming

object TuplesAndMaps extends App {

  //Tuples = finite ordered "lists"
  val tuple = new Tuple2(2, "hello, scala") //Tuple2[Int, String] = (Int, String)
  val aTuple = (2, "hello, scala")

  //Working with Tuples
  //  Access to tuple element
  println("--Access to tuple element--")
  println(aTuple._1)
  // Copy a tuple
  println("--Copy--")
  println(aTuple.copy(_2 = " goodbye, Rails"))
  // Swap a tuple
  println("--Swap a tuple--")
  println(aTuple.swap)

  //Maps - keys => values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("John", 305), "Jane" -> 786).withDefaultValue(-1)
  // a-> b is a syntactic sugar for (a, b)
  println("--Phone Book--")
  println(phoneBook) //Output: Map(John -> 305, Jane -> 786)


}
