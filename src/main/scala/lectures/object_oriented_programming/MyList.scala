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

  /*
  * foreach method with side effect: A => Unit
  */
  def foreach(f: A => Unit): Unit

  /*
  * Sort function*: ((A, A) => Int) => MyList
  */
  def sort(compare: (A, A) => Int): MyList[A]

  /*
  * - zipWith: (list, (A, A) => B) => MyList[B]
      Ex: [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4, 10, 18]
  */
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  /*  - fold(start)(function) => a value
  *      Ex: [1,2,3].fold(0)(x + y) => Sum of the values with 0
  *          0 + 1 + 2 + 3 = 6
  */
  def fold[B](start: B)(operator: (B, A) => B): B

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

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = EmptyList

  /*
  - zipWith: (list, (A, A) => B) => MyList[B]
  */
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else EmptyList
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start

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

  /*
  * foreach method with side effect: A => Unit
  * Ex: [1, 2, 3].foreach(x => println(x))
  */
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  /*
  * Sort function*: ((A, A) => Int) => MyList
  * Ex: [1,2,3].sort((x,y) => y - x) => [3,2,1]
  */
  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new ConstructionList(x, EmptyList)
      else if (compare(x, sortedList.head) <= 0) new ConstructionList(x, sortedList)
      else new ConstructionList(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  /*
    - zipWith: (list, (A, A) => B) => MyList[B]
      Ex: [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4, 10, 18]
    */
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if(list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new ConstructionList(zip(h, list.head), tail.zipWith(list.tail, zip))
  }

  /*
  *   - fold(start)(function) => a value
  *     Ex: [1,2,3].fold(0)(x + y) => Sum of the values with 0
  *         0 + 1 + 2 + 3 = 6
        [1,2,3].fold(0)(x + y)
        = [2, 3].fold(1)(x + y)
        = [3].fold(3)(x + y)
        = [].fold(6)(x + y)
        = 6
   */
  def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }

}

/*
  * Generic trait MyPredicate[T] with a little method test(T) => Bolean
  * Generic trait MyTransformer[A, B]
* */

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new ConstructionList(1, ConstructionList(2, ConstructionList(3, EmptyList)))
  val anotherListOfIntegers: MyList[Int] = new ConstructionList(4, ConstructionList(5, ConstructionList(6, EmptyList)))
  val anotherListOfIntegers2: MyList[Int] = new ConstructionList(4, ConstructionList(5, EmptyList))
  val listOfStrings: MyList[String] = new ConstructionList("Hello", new ConstructionList("Scala", EmptyList))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(x => x * 2))
  println(listOfIntegers.filter(x => x % 2 == 0))

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(x => new ConstructionList(x, new ConstructionList(x + 1, EmptyList))))

  val cloneListOfIntegers: MyList[Int] = new ConstructionList(1, ConstructionList(2, ConstructionList(3, EmptyList)))
  println(cloneListOfIntegers == listOfIntegers) //Output: true

  println("--Foreach method with side effect--")
  listOfIntegers.foreach((element) => println(element))

  println("--Sort function--")
  // sort((x, y) => y - x) ===> From smallest to largest
  println(listOfIntegers.sort((x, y) => y - x)) //Output: [1 2 3]

  println("--Zip with--")
  println(anotherListOfIntegers2.zipWith(listOfStrings, _ + "-" + _)) //Output: [1 2 3]

  println("--Fold--")
  println(listOfIntegers.fold(0)(_ + _))

  //Test for comprehensions
  val combinationsIntsStrings = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield (n + "-" + string)
  println("--combinationsIntsStrings--")
  println(combinationsIntsStrings)


}


