package lectures.object_oriented_programming

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

  println(potentialFall)//Output: 43

}
