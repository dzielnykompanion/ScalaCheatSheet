package com.rockthejvm

object Basics {

  // defining a value
  val meaningOfLife: Int = 42  // const int meaningOfLife = 42;

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false         // type is optional

  val aString = "I love scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $aString"

  // expressions - structures that can be reduced to a value
  val anExpression: Int = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 100) 0 else 999
  val chainedIfExpression =
         if (meaningOfLife == 0) 0
    else if (meaningOfLife == 1) 1
    else if (meaningOfLife == 3) 3
    else 0

  // code blocks
  val aCodeBlock: Int = {
    //definitions
    val aLocalValue = 67
    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String):String = y + " " + x

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)
  // In Scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value == "void" in other languages
  // type of SIDE EFFECTS
  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()




}
