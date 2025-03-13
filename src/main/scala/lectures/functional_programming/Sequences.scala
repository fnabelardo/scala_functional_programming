package lectures.functional_programming

object Sequences extends App {

  //Sequences
  val aSequence = Seq(1,3,2,4)
  println("---aSequence---")
  println(aSequence) //Output: List(1, 2, 3, 4)
  println(aSequence.reverse)
  println(aSequence(2)) //Equivalent println(aSequence.apply(2)) //Output: 3
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  println("---aRange---")
  aRange.foreach(println)
  val aRange2: Seq[Int] = 1 until 10
  println("---aRange2---")
  aRange2.foreach(println)

}
