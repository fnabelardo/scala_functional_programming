package lectures.pattern_matching

import lectures.object_oriented_programming.{MyList, ConstructionList, EmptyList}

/* Created by Felix Noel */
object AllThePatterns extends App {

  //Constants
  val x: Any = "Hello Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The truth"
    case _ => "A singleton object"
  }

  //Match anything

  // Wildcard
  val matchAnything: Unit = x match {
    case _ =>
  }

  // Variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"The $something"
  }
  //   Pattern Matching can be nested with Tuples
  val nestedTuple = (1, (2, 3))
  val matchANestedTuple: Unit = nestedTuple match {
    case (_ , (2, v)) =>
  }

  // Case classes - Constructor pattern
  // Pattern Matching can be nested with Cases Classes as well
  val aList: MyList[Int] = ConstructionList(1 , ConstructionList(2, EmptyList))
  val matchAList: Unit = aList match {
    case EmptyList =>
    case ConstructionList(head, ConstructionList(subhead, subtail)) =>
  }

  // List patterns
  val aStandardList = List(1, 2, 3, 25)
  val standardListMatching: Unit = aStandardList match {
    case List(1, _, _, _) =>  //Extractor
    case List(1, _*) =>       //List of arbitrary length
    case 1 :: List(_) =>      //Infix pattern
    case List(1, 2, 3) :+ 38 => //Infix pattern
  }

  // Type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //Explicit type specifier
    case _ =>
  }

  // Name binding (Something else)
  val nameBindingMatch = aList match {
    case nonEmptyList @ ConstructionList(_, _) => //Name binding => We can use the name later (here)
    case ConstructionList(1, rest @ ConstructionList(2, _)) => //Name binding inside nested patterns => We can use the name later (here)
  }

  // Multi patterns
  val multiPattern: Unit = aList match {
    case EmptyList | ConstructionList(1, _) => // Compound pattern (multi-pattern)
  }

  // If guards
  val secondElementSpecial = aList match {
    case ConstructionList(_, ConstructionList(specialElement, _)) if specialElement % 2 == 0 =>
  }

  // All
  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "A list of strings"
    case listOfNumbers: List[Int] => "A list of numbers"
    case _ => ""
  }

  println(numbersMatch)

}
