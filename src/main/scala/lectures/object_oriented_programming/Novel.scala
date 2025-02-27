package lectures.object_oriented_programming

import java.time.LocalDateTime

object Novel extends App {
  val author = new Writer("Antoine", "de Saint-Exupéry", 1900)
  val novel = new Novel("The Little Prince", 1917, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
//  println(counter.increment.print())
  println(counter.increment(3).print())

//  println(counter.decrement.print())
//  println(counter.decrement(3).print())
}

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = LocalDateTime.now().getYear - author.yearOfBirth

  def isWrittenBy(author: Writer) = this.author == author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

class Counter(val count: Int = 0) {
  def increment = {
    println("incrementing")
    new Counter(count + 1)
  }

  def decrement = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(value: Int): Counter = {
    if (value <= 0) this
    else increment.increment(value - 1)
  }

  def decrement(value: Int): Counter = {
    if (value <= 0) this
    else increment.decrement(value - 1)
  }

  def print() = println(count)
}
