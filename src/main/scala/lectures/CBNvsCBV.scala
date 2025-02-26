package lectures

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)//Output: by value: 25318736746965
    println("by value: " + x)//Output: by value: 25318736746965
  }

  //With the "=>" in parameters, the parameter is evaluated every time that is used
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)//Output: by name: 25318781685058
    println("by name: " + x)//Output: by name: 25318782164173
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  private def infinite(): Int = 1 + infinite()
  private def printFirst(x: Int, y: => Int): Unit = println(x)

//  printFirst(infinite(), 34)//Output: StackOverFlowError
  printFirst(34, infinite())//Output: 34 - The infinite() function never is evaluated because it has no use within function

}
