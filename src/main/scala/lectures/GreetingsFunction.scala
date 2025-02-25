package lectures

object GreetingsFunction extends App {
  /*
    *  1. A greeting function(name, age) => "Hi, my name is $name and I am $age years old."
    * */
  def greetingsFunction(name: String, age: Int) = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(greetingsFunction("Noel", 38)) //Output: Hi, my name is Noel and I am 38 years old.
}
