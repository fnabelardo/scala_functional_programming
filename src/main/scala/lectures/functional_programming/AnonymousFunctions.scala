package lectures.functional_programming

object AnonymousFunctions extends App {

  /*val doubler = new Function[Int, Int] {
    override def apply(x: Int) = x * 2
  } //Equivalent to --- val doubler = (x: Int) => x * 2 */

  //Anonymous function (LAMBDA)
  //val doubler: Int => Int = (x: Int) => x * 2 //Equivalent to ---> val doubler: Int => Int = x => x * 2
  //val doubler: Int => Int = x => x * 2        //Equivalent to ---> val doubler = (x: Int) => x * 2
  val doubler = (x: Int) => x * 2

  //Multiple parameters in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

}
