package lectures.object_oriented_programming

object Enums {
  //Define enum (Data type)
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    //Fields/methods
    def openDocument(): Unit = {
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
    }
  }

  val somePermissions: Permissions = Permissions.READ

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
  }

}
