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
  //  def toString: String
}

object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new ConstructionList(element, EmptyList)
}

class ConstructionList(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new ConstructionList(element, this)
}

object ListTest extends App {
  //Create list with one element
  val list = new ConstructionList(1, EmptyList)
  println(list.head)
}


