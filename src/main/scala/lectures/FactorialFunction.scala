package lectures

object FactorialFunction extends App {
  /*
  *  2. Factorial function. Ex: 1 * 2 * 3 * ... * n
  * */

  def factorialFunction(number: Int): BigInt = {
    if (number == 1) {
      1
    } else {
      number * factorialFunction(number - 1)
    }
  }

  println(factorialFunction(5)) //Output: 120
}
