package lectures.object_oriented_programming

import lectures.object_oriented_programming.Exceptions.OverflowException

object Exceptions extends App {
  val x: String = null
  //println(x.length)
  //This ^^ will crash with NullPointException

  // Throwing and catching exceptions
  //1. Throwing exceptions
  //val aWeirdValue: String = throw new NullPointerException

  //Throwable classes extends the Throwable class
  //Exception and Error are the major Throwable subtypes

  //2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFall = try {
    //Code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    //Code that will get executed NO MATTER WHAT
    //Optional
    //Does not influence the return type of the expression
    //Use finally only for side effects
    println("Finally")
  }

  println(potentialFall) //Output: 43

  //3. How to define own exceptions
  class MyException extends Exception

  val exception = new MyException

  /*
    * 1. Crash the program with an OutOfMemoryError
   */
  //val array = Array.ofDim[Int](Int.MaxValue, 4)//Output: Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit

  /*
    2. Crash the program with an StackOverflowError
   */
  def infinite: Int = 1 + infinite
  //val notLimit = infinite //Output: Exception in thread "main" java.lang.StackOverflowError

  /*
  *  3. PocketCalculator
  *   - add(x,y)
  *   - subtract(x,y)
  *   - multiply(x,y)
  *   - divide(x,y)
  *
  *   Throw
  *     - OverflowException if add(x,y) exceeds Int.MAX_VALUE
  *     - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
  *     - MathCalculationException for division by 0
  */
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException()
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException()
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException()
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException()
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException()
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException()
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException()
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException()
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException()
      else x / y
    }
  }

  println(PocketCalculator.divide(10, 0))

}
