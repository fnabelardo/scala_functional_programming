package lectures.pattern_matching

import scala.util.Random

/* Created by Felix Noel */
object PatternMatching extends App {

  /*
    * Resume
    * - Cases are matched in order
    * - If no cases match return MatchError
    * - Type of the Pattern Matching expression is: Unified type of all the types in all cases
    * - Works really well with case classes
    * */

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

  //1. Decompose values
  case class Person(name: String, age: Int)
  private val noel = Person("noel", 38)

  //Compare against the instance of class
  private val greeting = noel match {
    case Person(n, a) if a < 21  => s"Hi, my name is $n and a can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know what I am"
  }
  println("--greeting--")
  println(greeting)

  //Pattern matching on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

}
