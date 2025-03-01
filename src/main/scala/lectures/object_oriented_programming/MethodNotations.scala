package lectures.object_oriented_programming

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    //Infix notation
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with $person"
    def +(person: Person): String = s"${this.name} is adding with $person"
    def +(pseudonym: String): Person = new Person(this.name + " (" + pseudonym + ")", this.favoriteMovie)
    //Prefix notation
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    //Postfix notation
    def isAlive: Boolean = true //This function do not receive any parameter
    def learns(subject: String) = s"$name learns $subject"
    def learnsScala = this learns("Scala")
    //Apply
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(watchedTime: Int) = s"$name watched the $favoriteMovie $watchedTime times"
  }

  val jane = new Person("Jane", "Inception")
  println(jane.likes("Inception"))
  println(jane likes "Inception")

  //Operator notation (Method with 1 parameter)
  //"Operators" in Scala
  val tommy = Person("Tommy", "Run Club")

  //Infix notation
  println(jane hangOutWith tommy)
  println(jane.name + tommy.name)
  println(jane.name + tommy)

  //Prefix notation (Syntactic sugar)
  val x = -1 //Equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_prefix only works with - + ~ !

  println(jane.unary_!)//Output: Jane, what the heck?!
  println(!jane)//Output: Jane, what the heck?! //Equivalent with println(jane.unary_!)

  //Postfix notation
  println(jane isAlive)//Equivalent with println(jane.isAlive)
  println(jane.isAlive)

  //Apply (Special property)
  println(jane())//Equivalent with println(jane.apply())
  println(jane.apply())

  /* 1.
  * Overload the "+" method to return new Person
  * Ex: messi + "the goat" => new person (name: Messi (the goat), favoriteMovie: the same of messi.favoriteMovie)
  * */
  println("1.")
  val messi = new Person("Messi", "Take the ball and pass it")
  println((messi + "The goat").apply())

  /* 2.
  * Add "age" parameter to the Person class, default 0 value and
  * Add a unary + operator => new Person with the age + 1
  * Ex: +messi => messi with the age incremented
  * */
  println("2.")
  println(+messi)

  /* 3.
  * Add a "learns" method to the Person class => "Mary learns Scala"
  * Add a learnsScala method, calls learns method with "Scala"
  * Use it in postfix notation */
  println("3.")
  println(messi learnsScala)

  /* 4.
  * Overload the apply method to receive a Number and return a String
  * Return Person "name" watched the Person "favoriteMovie" n times
  * */
  println("4.")
  println(messi(5))

}
