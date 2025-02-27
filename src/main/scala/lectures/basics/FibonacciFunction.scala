package lectures.basics

import scala.annotation.tailrec

object FibonacciFunction extends App {
  /*
  *  3. Fibonacci function.
  * Ex: f(1) = 1
  * *** f(2) = 1
  * *** f(n) = f( n - 1 ) +  f( n - 2 )
  * */
  private def fibonacciFunction(number: Int): BigInt =
    if (number <= 2) 1
    else fibonacciFunction(number - 1) + fibonacciFunction(number - 2)

  println(fibonacciFunction(3)) //Output: 21

  /* fibonacciTailRecursive
  * Use two accumulator because the recursive function need to be called two times.
  *  last: Last number
  *  previousToLas: Previous number to last (last - 1)
  * Fibonacci: 0 + 1 = (1), 0 + 1 = (1), 1 + 1 = (2), 1 + 2 = (3), 2 + 3 = (5), 3 + 5 = (8), 5 + 8 = (13), 8 + 13 = (21)
  * 1 1 3 5 8 13 21 */
  private def fibonacciTailRecursive(number: Int): BigInt = {
    @tailrec
    def fibonacciHelper(n: Int, last: BigInt, previousToLast: BigInt): BigInt = {
      if (n >= number) last
      else fibonacciHelper(n + 1, last + previousToLast, last)
    }

    if (number <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

  println(fibonacciTailRecursive(8)) //Output: 21

}
