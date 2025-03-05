package lectures.object_oriented_programming

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //Anonymous Class

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahaha")
  }
  /* Equivalent
    * class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahaha")
    }
    * val funnyAnimal: Animal = new AnonymousClasses$$anon1$*/

  println(funnyAnimal.getClass)//Output: class lectures.object_oriented_programming.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, I'm $name")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, I'm Jim")
  }

}
