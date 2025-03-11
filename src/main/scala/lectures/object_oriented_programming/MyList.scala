package lectures.object_oriented_programming

import scala.collection.immutable.Stream.Cons

abstract class MyList[+A] {
  /* Singled link integer list
  * head = first element of the list
  * tail = remainder of the list
  * isEmpty = is this list empty
  * add(int) = new list with this element added
  * toString = a string representation of the list * */
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  /*
    map(transformer) => MyList
    flatMap(transformer from A to MyList[B]) => MyList[B]
    filter(predicate) => MyList
  * */
  //Higher-order functions: Receive functions as parameters and return other function
  def map[B](transformer: A => B): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  //Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

case object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new ConstructionList(element, EmptyList)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = EmptyList

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class ConstructionList[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new ConstructionList(element, this)

  def printElements: String =
    if (t.isEmpty) s"$h"
    else s"$h ${t.printElements}"

  /*
  * [1, 2, 3].map(n * 2)
  *   = new ConstructionList(2, [2, 3].map(n * 2))
  *   = new ConstructionList(2, new ConstructionList(4, [3].map(n * 2)))
  *   = new ConstructionList(2, new ConstructionList(4, new ConstructionList(6, EmptyList.map(n * 2))))
  *   = new ConstructionList(2, new ConstructionList(4, new ConstructionList(6, EmptyList)))
  * */
  def map[B](transformer: A => B): MyList[B] = {
    new ConstructionList(transformer.apply(h), t.map(transformer))
  }

  /*
    * [1, 2, 3].filter(n % 2 == 0)
    *   = [2, 3].filter(n % 2 == 0)
    *   = new ConstructionList(2, [3].filter(n % 2 == 0))
    *   = new ConstructionList(2, EmptyList.filter(n % 2 == 0))
    *   = new ConstructionList(2, EmptyList)
    * */
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate.apply(h)) new ConstructionList(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  * [1, 2] ++ [3, 4, 5]
  * new ConstructionList(1, [2] ++ [3, 4, 5]) 
  * new ConstructionList(1, ConstructionList(2, Empty ++ [3, 4, 5])) 
  * new ConstructionList(1, ConstructionList(2, new ConstructionList(3, new ConstructionList (4, new ConstructionList(5)))))
  * */
  def ++[B >: A](list: MyList[B]): MyList[B] = new ConstructionList(h, t ++ list)

  /*
  * [1, 2].flatMap(n => [n, n+1])
  * = [1,2] ++ [2].flatMap(n => [n, n+1])
  * = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  * = [1,2] ++ [2,3] ++ Empty
  * = [1,2,2,3]
  * */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer.apply(h) ++ t.flatMap(transformer)
}

/*
  * Generic trait MyPredicate[T] with a little method test(T) => Bolean
  * Generic trait MyTransformer[A, B]
* */

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new ConstructionList(1, ConstructionList(2, ConstructionList(3, EmptyList)))
  val anotherListOfIntegers: MyList[Int] = new ConstructionList(4, ConstructionList(5, ConstructionList(6, EmptyList)))
  val listOfStrings: MyList[String] = new ConstructionList("Hello", new ConstructionList("Scala", EmptyList))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(x => x * 2))
  println(listOfIntegers.filter(x => x % 2 == 0))

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(x => new ConstructionList(x, new ConstructionList(x + 1, EmptyList))))

  val cloneListOfIntegers: MyList[Int] = new ConstructionList(1, ConstructionList(2, ConstructionList(3, EmptyList)))
  println(cloneListOfIntegers == listOfIntegers) //Output: true
}


