package lectures.functional_programming

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption) //Output: Some(4)
  println(noOption) //Output: None

  //Work with unsafe APIs
  def unsafeMethod(): String = null
  val result = Option(unsafeMethod())
  println(result)//Output: None

  //Chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  //Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  //Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //UNSAFE - Do not use this

  //Use map, flatMap, filter on Options
  println(myFirstOption.map(_ * 2))//Output: Some(8)
  println(myFirstOption.filter(x => x > 10))//Output: None
  println(myFirstOption.flatMap(x => Option(x * 10)))//Some(40)

  /*
  * API
  * */
  val config: Map[String, String] = Map(
    //Fetched from elsewhere
    "host" -> "178.22.42.12",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" //Connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }

  }

  //Try to establish a connection,
  // if so - print the connect method

  /* Solution 1 */
  private val host = config.get("host")
  private val port = config.get("port")
  /*
  * if(host != null)
  *   if(port != null)
  *     return Connection.apply(host, port)
  *
  * return null
  * */
  private val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
  * if(connection != null)
  *   return connection.connect
  * return null
  * */
  private val connectionStatus = connection.map(conn => conn.connect)

  //if(connectionStatus == null) println(None) else println(Some(connectionStatus.get))
  println("---connectionStatus---")
  println(connectionStatus)

  /*
  * if(status != null)
  *   println(connection)
  * */
  println("---connectionStatus.foreach(println)---")
  connectionStatus.foreach(println)

  /* Solution 2 */
  //Chained methods
  println("--- Using comprehension ---")
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(conn => conn.connect))
    .foreach(println)

}
