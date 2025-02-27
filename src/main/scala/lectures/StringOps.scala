package lectures

object StringOps extends App {
  val str: String = "Hello, I am a software engineer"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  val aNumberString = "86"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') //Prepending string (:+), Appending string (+:)
  println(str.reverse)
  println(str.take(4)) //Output: Hell

  //Scala-specific: String interpolators

  //S-interpolator
  val name = "Noel"
  val age = 38
  //String interpolators
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

}
