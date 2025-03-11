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

  //No parameters in a lambda
  val justDoSomething: () => Int = () => 3
  println(justDoSomething)  //Function itself       //Output: lectures.functional_programming.AnonymousFunctions$$$Lambda$17/0x0000000840067440@6e8dacdf
  println(justDoSomething())//Call of the function  //Output: 3

}
