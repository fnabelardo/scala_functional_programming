package lectures.functional_programming

import scala.util.{Failure, Success, Try}

/* Created by Felix Noel */
object HandlingFailure extends App {

  //Creat success and failure
  private val aSuccess = Success(3)
  private val aFailure = Failure(new RuntimeException("Simulator error"))

  println("--aSuccess--")
  println(aSuccess)
  println("--aFailure--")
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("unsafe Method Message")

  //Try object via the apply method
  private val potentialFailure = Try(unsafeMethod())
  println("--potentialFailure--")
  println(potentialFailure)

  //Syntax sugar
  private val anotherPotentialFailure = Try {
    //code that might throw
    potentialFailure
  }
  println("--anotherPotentialFailure--")
  println(anotherPotentialFailure)

  //Utilities
  println("--potentialFailure.isSuccess--")
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A valid result"
  private val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println("--fallbackTry")
  println(fallbackTry)

}
