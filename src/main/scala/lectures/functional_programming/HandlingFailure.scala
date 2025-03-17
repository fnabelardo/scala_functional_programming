package lectures.functional_programming

import scala.util.{Failure, Random, Success, Try}

/* Created by Felix Noel */
object HandlingFailure extends App {

  //Creat success and failure
  private val aSuccess = Success(3)
  private val aFailure = Failure(new RuntimeException("Simulator error"))

  println("--aSuccess--")
  println(aSuccess)
  println("--aFailure--")
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("unsafe Method Message")

  //Try object via the apply method
  private val potentialFailure = Try(unsafeMethod())
  println("--potentialFailure--")
  println(potentialFailure)

  //Syntax sugar
  private val anotherPotentialFailure = Try {
    //code that might throw
    potentialFailure
  }
  println("--anotherPotentialFailure--")
  println(anotherPotentialFailure)

  //Utilities
  println("--potentialFailure.isSuccess--")
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A valid result"

  private val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println("--fallbackTry--")
  println(fallbackTry)

  //Create unsafe and backup API method
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  //Map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  /*
  * Create API example with handling failure
  * */
  private val hostName = "localhost"
  private val portNumber = "8888"

  private def renderHtml(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())

      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection Error")
    }

    def getSafe(url: String): Try[String] = Try(get(url))

  }

  private object HttpService {
    private val random = new Random(System.nanoTime())

    private def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Connection Error. Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  /* If I get the html page from the connection, print it to the console i.e call renderHtml */
  private val possibleConnection = HttpService.getSafeConnection(hostName, portNumber)
  private val possibleHtml = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  println("--possibleHtml.foreach(renderHtml)--")
  possibleHtml.foreach(renderHtml)

  //Shorthand version
  HttpService.getSafeConnection(hostName, portNumber)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHtml)

  //For-comprehension
  for {
    connection <- HttpService.getSafeConnection(hostName, portNumber)
    html <- connection.getSafe("/home")
  } renderHtml(html)

}
