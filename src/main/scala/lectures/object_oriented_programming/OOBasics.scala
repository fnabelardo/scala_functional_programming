package lectures.object_oriented_programming

object OOBasics extends App {
  private val person = new Person("Noel", 38)
  println(person.age)
  person.greet("Jhon")
  person.greet()
}

//Constructor
class Person(name: String, val age: Int) {
  //Val definition inside the class are fields
  def greet(name: String): Unit = println(s"${this.name}, say: Hi, ${name}")

  //Overloading
  def greet(): Unit = println(s"Hi, I am $name!")

  //Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("Jane Doe")

}
