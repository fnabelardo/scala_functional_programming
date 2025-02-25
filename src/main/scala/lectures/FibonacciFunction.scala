package lectures

object FibonacciFunction extends App {
  /*
  *  3. Fibonacci function.
  * Ex: f(1) = 1
  * *** f(2) = 2
  * *** f(n) = f( n - 1 ) +  f( n - 2 )
  * */
  private def fibonacciFunction(number: Int): BigInt =
    if (number <= 2) 1
    else fibonacciFunction(number - 1) + fibonacciFunction(number - 2)

  println(fibonacciFunction(8))//Output: 21

}
