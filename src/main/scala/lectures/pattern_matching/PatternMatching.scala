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
    case Person(n, a) if a < 21 => s"Hi, my name is $n and a can't drink in the US"
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

  //Match everything
  val esEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  /*
  * Simple function using Pattern Matching
  takes an Expression => Human readable form

  Sum(Number(x), Number(y)) => x + y
  Sum(Sum(Number(x), Number(y)), Number(z)) => x + y + z
  Prod(Sum(Number(x), Number(y)), Number(z)) (x + y) * z
  * */
  trait Expression

  private case class Number(n: Int) extends Expression

  private case class Sum(e1: Expression, e2: Expression) extends Expression

  private case class Prod(e1: Expression, e2: Expression) extends Expression


  private def showReadable(expression: Expression): String = expression match {
    case Number(x) => s"$x"
    case Sum(e1, e2) => showReadable(e1) + " + " + showReadable(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expression) = exp match {
        case Number(_) => showReadable(exp)
        case Prod(_, _) => showReadable(exp)
        case _ => "(" + showReadable(exp) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  println("--Sum(Number(x), Number(y)) => x + y --")
  println(showReadable(Sum(Number(2), Number(1))))

  println("-- Sum(Sum(Number(x), Number(y)), Number(z)) => x + y + z --")
  println(showReadable(Sum(Sum(Number(2), Number(3)), Number(4))))

  println("--Prod(Sum(Number(x), Number(y)), Number(z)) (x + y) * z--")
  println(showReadable(Prod(Sum(Number(2), Number(1)), Number(3))))

  println("--Sum(Prod(Number(x), Number(y)), Number(z)) = x * y + z--")
  println(showReadable(Sum(Prod(Number(2), Number(1)), Number(3))))

  println("-- X => I don't know what Expression is --")
  println(showReadable(Prod(Prod(Number(2), Number(1)), Number(3))))

}
