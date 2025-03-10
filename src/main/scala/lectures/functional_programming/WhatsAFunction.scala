package lectures.functional_programming

object WhatsAFunction extends App {
  //Use functions as first class elements

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
