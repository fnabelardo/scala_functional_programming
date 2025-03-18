package lectures.pattern_matching

import scala.util.Random

/* Created by Felix Noel */
object PatternMatching extends App {

  //Switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  //Patter matching
  private val description = x match {
    case 1 => "the First"
    case 2 => "double or nothing"
    case 3 => "the third time is the charm forth"
    case _ => "something else" // _ = WILDCARD
  }

  println("Random number")
  println(x)
  println("--description--")
  println(description)

}
