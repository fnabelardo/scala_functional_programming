package lectures.pattern_matching

/* Created by Felix Noel */
object PatternsEverywhere extends App {

  //1. Try and catch is based on Patterns Matching
  try {
    //Code
  } catch {
    case e: RuntimeException => "runtime exception"
    case npe: NullPointerException => "NPE"
    case _ => "Something else"
  }

  //2. For comprehension is based on Patterns Matching
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield x * 2

  // Generator are also based on Pattern Matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (x, y) <- tuples
  } yield x * y

  //3. Multiple value definition are based on Pattern Matching
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b) //Output: 2

  val head :: tail = list
  println(head)
  println(tail)

  //4. Partial function are based on Pattern Matching
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "The first element is 1"
    case _ => "something else"
  } // Partial function literal

  val mappedList2 = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "The first element is 1"
      case _ => "something else"
    }
  }

  //Application of partial function literal
  println(mappedList)

}
