package lectures.functional_programming

object WhatsAFunction extends App {
  //Use functions as first class elements

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  //Function types = Function[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("5") + 4)//Output: 9

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //Function types Function2[A, B, R] === (A,B) => R
  //All Scala functions are objects
  /*

  * A function that takes 2 strings and concatenate them
  */
  val concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concat("Hello", " World"))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
