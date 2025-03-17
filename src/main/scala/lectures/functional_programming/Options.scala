package lectures.functional_programming

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption) //Output: Some(4)
  println(noOption) //Output: None

  //Work with unsafe APIs
  def unsafeMethod(): String = null
  val result = Option(unsafeMethod())
  println(result)//Output: None

  //Chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  //Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  //Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //UNSAFE - Do not use this

  }
