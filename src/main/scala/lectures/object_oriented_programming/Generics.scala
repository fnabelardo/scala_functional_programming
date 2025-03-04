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

}
