package lectures.object_oriented_programming

object Objects extends App {
  //Scala does not have class-level functionalities ("static")
  object Person {
    //Static/class - level functionalities
    val N_EYES = 2
    def canFly: Boolean = false

    //Factory method
    def apply(mother: Person, father: Person): Person = new Person("Jonny Jr.")
  }
  class Person(val name: String) {
    //Instance level functionalities
  }
  //Companions: object Person and class Person
  // - Can acces each other's provate members
  // - Scala is OO

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = Singleton instance
  val messi = new Person("Messi")
  val antonela = new Person("Antonela")
  println(messi == antonela) //Output: false

  val person1 = Person
  val person2 = Person
  println(person1 == person2) //Output: true

  //Factory method
  val jonny = Person(messi, antonela)//Equivalent: Person.apply(messi, antonela)

  //Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
