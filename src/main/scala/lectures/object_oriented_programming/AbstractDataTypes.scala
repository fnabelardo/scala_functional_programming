package lectures.object_oriented_programming

object AbstractDataTypes extends App {
  //Abstract class: Can not be instanced
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat(): Unit = println("crunch crunch")
  }

  //Traits: We can mixe many traits as we want
  /*    Ex:   trait ColdBlooded
  *           class Crocodile extends Animal with Carnivore with ColdBlooded*/
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "crocodile"
    def eat(): Unit = {}
    def eat(animal: Animal): Unit = println(s"I'm a crocodile! and I'm eating ${animal.creatureType}!")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  /* Abstract classes and Traits
  *   - Both can have abstract and not abstract members
  *   - Traits do not have constructor parameters
  *   - We can only extend 1 class
  *   - We can extend multiple Trait by the same class (class Crocodile extends Animal with Carnivore with ColdBlooded)
  *   - Abstract class is a type of things behavior
  *   - Traits is a behavior
  *   */

}
