package lectures

object PrimeNumberFunction extends App {
  /* Prime number */

  def isPrimeFunction(number: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else number % t != 0 && isPrimeUntil(t - 1)
    }

    if (number <= 1) false
    else if (number == 2) true
    else isPrimeUntil(number / 2)
  }

  println(isPrimeFunction(-1))
  println(isPrimeFunction(0))
  println(isPrimeFunction(1))
  println(isPrimeFunction(2))
  println(isPrimeFunction(7))
  println(isPrimeFunction(9))
  println(isPrimeFunction(37))
  println(isPrimeFunction(9 * 37))
}
