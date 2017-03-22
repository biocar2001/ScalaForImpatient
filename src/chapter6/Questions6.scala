package chapter6

/**
  * Created by carlos on 22/03/17.
  */
object Questions6 {
  //1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
  //milesToKilometers.

  object Conversions {
    def inchesToCentimeters(inches: Double) = inches * 2.54

    def gallonsToLiters(gallons: Double) = gallons * 3.78541

    def milesToKilometers(miles: Double) = miles * 1.60934
  }

  //2. The preceding problem wasn't very object-oriented. Provide a general superclass
  //UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and
  //MilesToKilometers that extend it.

  class UnitConversion(val conversionFactor: Double) {
    private def convert(value: Double) = value * conversionFactor

    def apply(value: Double) = convert(value)
  }

  object InchesToCentimeters extends UnitConversion(2.54) {}
  object GallonsToLiters extends UnitConversion(3.78541) {}
  object MilesToKilometers extends UnitConversion(1.60934) {}

  //3. Define an Origin object that extends java.awt.Point. Why is this not actually a
  //good idea? (Have a close look at the methods of the Point class.)
  // Maybe because Point class has a move() etc. methods and origin shouldn't move??

  object Origin extends java.awt.Point {}

  //4. Define a Point class with a companion object so that you can construct Point
  //instances as Point(3, 4), without using new.

  class Point(val x: Int, val y: Int) {
    override def toString = "(" + x + ", " + y + ")"
  }

  object Point {
    def apply(x: Int, y: Int) = new Point(x, y)
  }

  //5. Write a Scala application, using the App trait, that prints the command-line
  //arguments in reverse order, separated by spaces. For example, scala Reverse
  //Hello World should print World Hello.

  object Reverse extends App {
    for(s <- args.reverse) print(s + " ")
    println()
  }

  //6. Write an enumeration describing the four playing card suits so that the toString
  //method returns ♣, ♦, ♥, or ♠.

  object CardSuite extends Enumeration {
    type CardSuite = Value
    val Club = Value("♣")
    val Diamond = Value("♦")
    val Heart = Value("♥")
    val Spade = Value("♠")
  }

  //7. Implement a function that checks whether a card suit value from the preceding exercise is red.
  import CardSuite._
  def isRed(card: CardSuite) = card == Diamond || card == Heart

  //8. Write an enumeration describing the eight corners of the RGB color cube. As
  //IDs, use the color values (for example, 0xff0000 for Red).

  object RGBCube extends Enumeration {
    val Black = Value(0x000000, "Black")
    val Red = Value(0xff0000, "Red")
    val Green = Value(0x00ff00, "Green")
    val Yellow = Value(0xffff00, "Yellow")
    val Blue = Value(0x0000ff, "Blue")
    val Cyan = Value(0x00ffff, "Cyan")
    val Magenta = Value(0xff00ff, "Magenta")
    val White = Value(0xffffff, "White")
  }
}
