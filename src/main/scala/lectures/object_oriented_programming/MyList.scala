package lectures.object_oriented_programming

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
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
}

object EmptyList extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new ConstructionList(element, EmptyList)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList
}

class ConstructionList[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new ConstructionList(element, this)
  def printElements: String =
    if(t.isEmpty) s"$h"
    else s"$h ${t.printElements}"

  /*
  * [1, 2, 3].map(n * 2)
  *   = new ConstructionList(2, [2, 3].map(n * 2))
  *   = new ConstructionList(2, new ConstructionList(4, [3].map(n * 2)))
  *   = new ConstructionList(2, new ConstructionList(4, new ConstructionList(6, EmptyList.map(n * 2))))
  *   = new ConstructionList(2, new ConstructionList(4, new ConstructionList(6, EmptyList)))
  * */
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new ConstructionList(transformer.transform(h), t.map(transformer))
  }

  /*
    * [1, 2, 3].filter(n % 2 == 0)
    *   = [2, 3].filter(n % 2 == 0)
    *   = new ConstructionList(2, [3].filter(n % 2 == 0))
    *   = new ConstructionList(2, EmptyList.filter(n % 2 == 0))
    *   = new ConstructionList(2, EmptyList)
    * */
  def filter(predicate: MyPredicate[A]): MyList[A] =
    if(predicate.test(h)) new ConstructionList(h, t.filter(predicate))
    else t.filter(predicate)
}

/*
  * Generic trait MyPredicate[T] with a little method test(T) => Bolean
  * Generic trait MyTransformer[A, B]
* */

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new ConstructionList(1, ConstructionList(2, ConstructionList(3, EmptyList)))
  val listOfStrings: MyList[String] = new ConstructionList("Hello", new ConstructionList("Scala", EmptyList))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(new MyTransformer[Int, Int]{
    override def transform(element: Int): Int = element * 2
  }))
  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }))
}


