package lectures.functional_programming

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption) //Output: Some(4)
  println(noOption) //Output: None

}
