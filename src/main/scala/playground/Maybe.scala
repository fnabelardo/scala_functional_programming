package playground

abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class JustOne[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = JustOne(f(value))
  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
  def filter(p: T => Boolean): Maybe[T] =
    if (p(value)) this
    else MaybeNot
}

object MaybeTest extends App {
  val just3 = JustOne(3)
  println("--just2--")
  println(just3)//Output: Just(3)
  println("--just2.map--")
  println(just3.map(_ * 2))//Output:// Just(6)
  println("--just2.flatMap--")
  println(just3.flatMap(x => JustOne(x % 2 == 0)))
  println("--just2.filter--")
  println(just3.filter(_ % 2 == 0))
}
