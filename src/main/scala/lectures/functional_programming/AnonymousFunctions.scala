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
  println(justDoSomething) //Function itself       //Output: lectures.functional_programming.AnonymousFunctions$$$Lambda$17/0x0000000840067440@6e8dacdf
  println(justDoSomething()) //Call of the function  //Output: 3

  //Curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MOAR syntactic sugar
  //val niceIncrementer: Int => Int = (x: Int) => x + 1 //Equivalent to ---> val niceIncrementer: Int => Int = _ + 1
  val niceIncrementer: Int => Int = _ + 1

  //val niceAdder: (Int, Int) => Int = (a, b) => a + b //Equivalent to ---> val niceAdder: (Int, Int) => Int = _ + _
  val niceAdder: (Int, Int) => Int = _ + _

  /* Write the special adder as an anonymous function */
  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))   //Output: 7

}
