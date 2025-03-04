package lectures.object_oriented_programming

abstract class MyList {
  /* Singled link integer list
  * head = first element of the list
  * tail = remainder of the list
  * isEmpty = is this list empty
  * add(int) = new list with this element added
  * toString = a string representation of the list * */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new ConstructionList(element, EmptyList)
  def printElements: String = ""
}

class ConstructionList(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new ConstructionList(element, this)
  def printElements: String =
    if(t.isEmpty) s"$h"
    else s"$h ${t.printElements}"
}

object ListTest extends App {
  //Create list with one element
  val list = new ConstructionList(1, EmptyList)
  println(list.head)

  //Create list with 3 element
  val list2 = new ConstructionList(1, ConstructionList(2, ConstructionList(3, EmptyList)))
  println(s"List 2 head: ${list2.head}")
  println(s"List 2 tail head: ${list2.tail.head}")
  println(s"List 2 tail head: ${list2.tail.head}")

  //Polymorphic call
  println(list2.toString)

}


