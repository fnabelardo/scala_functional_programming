package lectures.object_oriented_programming

object MethodNotations extends App {
  case class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with $person"
    def +(person: Person): String = s"${this.name} is adding with $person"
    def unary_! : String = s"$name, what the heck?!"
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
}
