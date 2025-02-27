package lectures.basics

import scala.annotation.tailrec

object ConcatenateString extends App {
  private def concatenateTailRecursion(aRepeatNumber: Int, aString: String): String = {
    @tailrec
    def helpConcatenateString(n: Int, a: String, accumulator: String): String = {
      if (n <= 0) accumulator
      else helpConcatenateString(n - 1, a, a + accumulator)
    }

    helpConcatenateString(aRepeatNumber, aString, "")
  }

  println(concatenateTailRecursion(3, "Noel "))
}
