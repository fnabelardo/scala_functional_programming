package lectures.object_oriented_programming

object Inheritance extends App {
  //Single class Inheritance
  // - Permit only one Inheritance
  // - The private methods are not accessible
  // - The protected methods only are accessible inside the child
  class Animal {
    def run = println("run")
    protected def eat = println("mmmmm")
    val creatureType = "wild"
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }
   val cat = new Cat
   cat.run

   //Constructors
   class Person(name: String, age: Int) {
     def this(name: String) = this(name, 0)
   }
   //Extending class with parameters
   class Adult(name: String, age: Int, idCard: String) extends Person(name, age) {}

   //Overriding methods
   class Dog(override val creatureType: String) extends Animal {
     override def eat = println("eat, eat")
//     override val creatureType: String = "domestic"
   }

   val dog = new Dog("K9")
   dog.eat
   println(dog.creatureType)

   //Type substitution (broad: polymorphism)
   val unknownAnimal: Animal = new Dog("K9")
   unknownAnimal.run

   /* Preventing overrides:
   * 1- Use final on member
   *    Ex: final protected def eat
   * 2- Use final entire class
   *    Ex: final class Animal
   *  3- Use Seal class (Allow extension class in the same file, prevent extension class in other files)
   *    Ex:sealed class Animal */
}
