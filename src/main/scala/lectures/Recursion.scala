package lectures

import scala.annotation.tailrec

object Recursion extends App {
  def factorialFunction(number: Int): BigInt = {
    if (number <= 0) 1
    else {
      number * factorialFunction(number - 1)
    }
  }

  //  println(factorialFunction(20000))//Output: .StackOverflowError

}
