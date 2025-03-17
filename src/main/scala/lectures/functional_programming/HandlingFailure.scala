package lectures.functional_programming

import scala.util.{Failure, Success, Try}

/* Created by Felix Noel */
object HandlingFailure extends App {

  //Creat success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Simulator error"))

  println("--aSuccess--")
  println(aSuccess)
  println("--aFailure--")
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("unsafe Method Message")

  //Try object via the apply method
  val potentialFailure = Try(unsafeMethod())
  println("--potentialFailure-")
  println(potentialFailure)
}
