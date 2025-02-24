package lectures

object Expressions extends App {
  //Expressions
  // + - * / & | ^ << >> >>> (Right shift with zero extension)
  // == != > >= < <=
  // ! && ||
  // += -= *= /=
  val x = 1 + 2
  println(x)

  // + - * / & | ^ << >> >>> (Right shift with zero extension)
  //Example:
  println(2 + 3 * 4)

  // == != > >= < <=
  //Example:
  println(1 == x)

  // ! && ||
  //Example:
  println(true && false)
  println(true || false)

  // += -= *= /=
  //Example:
  var y = 5
   y += 5
  println(y)

  //While loop
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

}
