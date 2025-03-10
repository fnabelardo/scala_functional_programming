package lectures.object_oriented_programming

import playground.PrinceCharming

object PackagingAndImports extends App {
  val writer = new Writer("Noel", "RockScala", 2018)

  //Package Object: The Package object method are visible from the entire package
  sayHello("Package Object")
  println(SPEED_OF_LIGHT)

  //Imports package
  val prince = new PrinceCharming
  
  
}
