package chapter9

import scala.io.Source

/**
 * Write a Scala code snippet that reverses the lines in a file (making the last line the first one, and so on).
 */
object Ex01 extends App {

  val in = Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/TestingScala","UTF-8")

  println( in.getLines.toArray.reverse.mkString("\n") )

}
