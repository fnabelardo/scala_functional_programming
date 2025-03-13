package lectures.functional_programming

import scala.util.Random

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

  //Lists
  val aList = List(1,2,3)
  val prependedList = 42 :: aList //Prepended
  val prependedList2 = 43 +: aList //Prepended
  val appendedList = aList :+ 15 //Appended
  println("---prependedList---")
  println(prependedList) //Output: List(42, 1, 2, 3)
  println(prependedList2) //Output: List(43, 1, 2, 3)
  println("---appendedList---")
  println(appendedList) //Output: List(1, 2, 3, 15)

  val apples = List.fill(3)("apples")
  println("---apples---")
  println(apples) //Output: List(apples, apples, apples)
  println(aList.mkString("-|-")) //Output: 1-|-2-|-3

  //Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  //Mutation
  numbers(2) = 0 //Special syntax sugar for number.update(2, 0)
  println(numbers.mkString(" "))

  //Arrays and Seq
  val numbersSeq: Seq[Int] = numbers //Implicit conversion
  println("---numbersSeq---")
  println(numbersSeq) //Output: ArraySeq(1, 2, 0, 4)

  //Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println("---vector---")
  println(vector)

  //Vector vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      i <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      //Operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  // List Advantage: Keeps references to tail
  // List Advantage: Updating an element in the middle takes long
  val numbersList = (1 to maxCapacity).toList
  // Vector Advantage: Deep of the tree is small
  // Vector Advantage: Needs to replace an entire 32-element chunk
  val numbersVector = (1 to maxCapacity).toVector

  println("---numbersList---")
  println(getWriteTime(numbersList))
  println("---numbersVector---")
  println(getWriteTime(numbersVector))

}
