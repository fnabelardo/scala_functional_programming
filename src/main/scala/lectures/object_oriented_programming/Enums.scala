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

  //Constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) //100
    case WRITE extends PermissionsWithBits(2) //010
    case EXECUTE extends PermissionsWithBits(1) //001
    case NONE extends PermissionsWithBits(0) //000
  }

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
  }

}
