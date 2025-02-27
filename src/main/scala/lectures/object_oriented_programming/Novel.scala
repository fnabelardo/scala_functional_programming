package lectures.object_oriented_programming

import java.time.LocalDateTime

object Novel extends App {
  val author = new Writer("Antoine", "de Saint-Exupéry", 1900)
  val novel = new Novel("The Little Prince", 1917, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
}

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = LocalDateTime.now().getYear - author.yearOfBirth
  def isWrittenBy(author: Writer) = this.author == author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}
