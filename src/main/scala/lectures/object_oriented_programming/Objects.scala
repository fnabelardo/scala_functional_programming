package lectures.object_oriented_programming

object Objects extends App {
  //Scala does not have class-level functionalities ("static")
  object Person {
    //Static/class - level functionalities
    val N_EYES = 2
    def canFly: Boolean = false
  }
  class Person {
    //Instance level functionalities
  }
  //Companions: object Person and class Person

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = Singleton instance
  val messi = new Person("Messi")
  val john = new Person("John")
  println(messi == john) //Output: false

  val person1 = Person
  val person2 = Person
  println(person1 == person2) //Output: true

  println()
}
