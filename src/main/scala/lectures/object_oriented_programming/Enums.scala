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

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = //whatever
    PermissionsWithBits.NONE
  }

  //Standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values //Array of the all possible values of the enum
  val readPermissions: Permissions = Permissions.valueOf("READ")//Permissions.READ

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)//Output: 0. Because de enum start on 0

  }

}
