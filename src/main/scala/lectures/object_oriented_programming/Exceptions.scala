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

  try {
      //Code that might throw
      getInt(true)
    } catch {
      case e: RuntimeException => println("caught a Runtime exception")
    } finally {
    //Code that will get executed NO MATTER WHAT
      print("Finally")
    }

}
