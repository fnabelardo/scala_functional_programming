package lectures.functional_programming

object TuplesAndMaps extends App {

  //Tuples = finite ordered "lists"
  val tuple = new Tuple2(2, "hello, scala") //Tuple2[Int, String] = (Int, String)
  val aTuple = (2, "hello, scala")

  //Working with Tuples
  //  Access to tuple element
  println("--Access to tuple element--")
  println(aTuple._1)
  // Copy a tuple
  println("--Copy--")
  println(aTuple.copy(_2 = " goodbye, Rails"))
  // Swap a tuple
  println("--Swap a tuple--")
  println(aTuple.swap)

  //Maps - keys => values
  //Immutable
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("John", 305), "Jane" -> 786).withDefaultValue(-1)
  // a-> b is a syntactic sugar for (a, b)
  println("--Phone Book--")
  println(phoneBook) //Output: Map(John -> 305, Jane -> 786)

  //Work with Map
  // Contain of key
  println("--Phone Book contain--")
  println(phoneBook.contains("Jane")) //Output: true
  // Value of key
  println("--Phone Book value--")
  println(phoneBook("Jane")) //Output: 786
  println(phoneBook("Doe")) //Output: -1 Due to .withDefaultValue(-1)
  //Add a pairing
  println("--Add a pairing--")
  val newPairing = "Alfred" -> 201
  val newPhoneBook = phoneBook + newPairing
  println("--- newPhoneBook ---")
  println(newPhoneBook)

  //Functional on Maps
  // map, flatMap, filter
  println("Phone Book - Map")
  println("Convert keys to lowercase")
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //Filter keys
  println("---Filter key---")
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap) //Output: Map(John -> 305, Jane -> 786)
  //Map values
  println("---Map values---")
  println(phoneBook.mapValues(number => number * 10).toMap) //Output: Map(John -> 3050, Jane -> 7860)
  println("---Map value with prefix---")
  println(phoneBook.mapValues(number => "+1 " + number).toMap) //Output: Map(John -> 3050, Jane -> 7860)
}
