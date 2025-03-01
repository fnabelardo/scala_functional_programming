package lectures.object_oriented_programming

object MethodNotations extends App {
  case class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with $person"
    def +(person: Person): String = s"${this.name} is adding with $person"
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
}
