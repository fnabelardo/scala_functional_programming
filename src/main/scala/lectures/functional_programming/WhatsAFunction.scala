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
  * 1. A function that takes 2 strings and concatenate them
  * 2. Transform the MyPredicate and MyTransformer into function types
  * 3. Define a function which takes an int and returns another
  *     function which takes an int and returns an int
  *     - What's the type of this function
  *     - How to do it
  * */

  /*
  * A function that takes 2 strings and concatenate them
  */
  val concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concat("Hello", " World"))

  // Function1[Int, Function1[Int, Int]]
  //Curried Function: Function that takes multiple arguments one at a time.
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4)) //Output: 7
  println(superAdder(3)(4)) //Output: 7

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
