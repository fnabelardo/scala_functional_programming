package lectures.object_oriented_programming

object CaseClasses extends App {
  case class Person(name: String, age: Int)
  //Class parameters are fields
  val john = new Person("John", 35)
  println(john.name) //Case classes promote all parameters to fields

  //Sensible to toStrings
  //println(instance) = println(instance.toString) //syntactic sugar
  println(john.toString)

  //Equals and hasCode implemented Out Of The Box (OOTB)
  val john2 = new Person("John", 35)
  println(john == john2)

  // Case classes have handy copy method
  val john3 = john.copy(age = 45)
  println(john3)

  //Case classes have companion objects
  //Using case class the compiler create automatically
  // complementary objects for this class
  val thePerson = Person
  val mary = Person("Mary", 23)

  //Case classes are serializable: Is used in Akka

  //Case classes have extractor patterns = Case classes can be used in Patter matching

  case object UnitedKingdom {
    def name: String = "The United Kingdom"
  }

}
