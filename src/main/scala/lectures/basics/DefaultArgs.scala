package lectures.basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  private def trFact(n: Int, acc: Int = 1): Int ={
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  private val trFact3 = trFact(3, 1 )
  private val trFact4 = trFact(4)
  println(trFact3)
  println(trFact4)
}
