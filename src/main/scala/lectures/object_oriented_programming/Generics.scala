package lectures.object_oriented_programming

object Generics extends App {
  //Generic class
  class MyList[A] {
    // Use the type A
  }

  class MyMap[K, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //List[Cat] extends List[Animal] => Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //Contravariance
  class Trainer[-A]
  val trainer: Trainer[Animal] = new Trainer[Animal]

}
