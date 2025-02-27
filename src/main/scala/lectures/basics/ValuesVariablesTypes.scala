package lectures.basics

object ValuesVariablesTypes extends App {
  //Values (Immutable: Can't be reassigned)
  val x: Int = 42
  println(x)

  val aString: String = "Noel"
  val aBoolean: Boolean =  false
  val aChar: Char = 'n'
  val aShort: Short = 4158
  val aLong: Long = 5478965412457869L
  val aFloat: Float = 5.0f
  val aDouble: Double = 6.15

  //Variables (Mutable: Can be reassigned)
  var aVariable = 5
}
