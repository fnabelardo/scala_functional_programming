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

  //Conversions to other collections
  println(phoneBook.toList)
  println(List(("Noel", 786)).toMap)
  val names = List("Jane", "Alfred", "John", "Jim")
  /*
  .groupBy(name => name.charAt(0)): This groups the elements in names based on their first character:
    - name.charAt(0) extracts the first character of each name.
    - groupBy organizes the names into a Map, where:
        * The keys are the first characters of names.
        * The values are lists of names that start with that character.
  */
  println(names.groupBy(name => name.charAt(0))) //Output: HashMap(J -> List(Jane, John, Jim), A -> List(Alfred))

  /* 1. Map with lowercase to two keys with the same name */
  val addressBook = Map(("Jim", "Hearth"), "JIM" -> "Marte").withDefaultValue(-1)
  println(addressBook.map(pair => pair._1.toLowerCase -> pair._2)) //Output: Map(jim -> Marte)

  /* Simplified social network based on maps */
  def addToNetwork(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + ((person -> Set()))
  }

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)

    network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)

    network + (personA -> (friendsA - personB)) + (personB -> (friendsB - personA))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

      val unfriended = removeAux(network(person), network)
      unfriended - person
  }

  def nFriends(network: Map[String, Set[String]], personA: String): Int = {
    if (!network.contains(personA)) 0
    else network(personA).size
  }

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }
}

