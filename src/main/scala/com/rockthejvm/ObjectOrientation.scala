package com.rockthejvm


object ObjectOrientation extends App{

  // class and instance
  class Animal{
    // define fields
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition
  val aDog = new Dog("Lessie")

  aDog.name
  // constructor arguments are NOT fields: you need to put a val before the constructor argument
  class Dog2(name: String) extends Animal
  val aDog2 = new Dog2(name = "Harry")
  // aDog2.name - it won't work

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal{
    val hasLegs = true // by default public, can restrict by private or protected
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher{
    override def eat(animal: Animal): Unit = println("Im eating you animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  trait Philosopher {
    def ?!(thought: String):Unit // valid method name
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog  // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasic = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur, i can eat anything")
  }

  /*
  What you tell the compiler:
   class Carnivore_anonymous_35343 extends Carvicore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur, i can eat anything")
   }
   val dinosaur = Carnivore_anonymous_35343
  */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 4
    def mySpecialMethod(): Int = 4 + 1000
    def apply(x: Int): Int = x + 1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65) - only for apply

  object Animal { // companions - companion object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
  case classes = lightweight data structures with some boilerplate
  - sensible equals and hash code
  - serialization
  - companion with apply
  - pattern matching
   */
  case class Person(name:String, age: Int)
  // may be constructed without new
  val bob = Person("Bob", 55) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally{
    // execute some code, no matter what
  }


  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }
  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail

  val aStringList = List("hello", "scala")
  val firstString = aStringList.head // string


  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
  Benefits:
  1) work miracles in multithreaded/distrubuted environment
  2) helps making sense of the code("reasoning about")
   */
  val reverseList = aList.reverse //returns a NEW list

  // Point #2: Scala is closest to the object-oriented ideal




}
