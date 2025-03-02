package lectures.object_oriented_programming

object InheritanceAndTraits extends App {
  //Single class Inheritance
  // - Permit only one Inheritance
  // - The private methods are not accessible
  // - The protected methods only are accessible inside the child
  class Animal {
    def run = println("run")
    protected def eat = println("mmmmm")
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
   class Person(name: String, age: Int) {}
   //Extending class with parameters
   class Adult(name: String, age: Int, idCard: String) extends Person(name, age) {}
}
