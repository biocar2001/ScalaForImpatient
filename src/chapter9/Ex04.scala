package chapter9

import scala.io.Source

/**
 * Write a Scala program that reads a text file containing average, maximum, and minimum of the numbers in the file.
 */
object Ex04 extends App {

  val floats = """[0-9\.]+""".r.findAllIn(Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/numbers","UTF-8").mkString).map(_.toDouble).toArray

  List(
  "Max: " + floats.max,
  "Min: " + floats.min,
  "Average: " + floats.sum/floats.length
  ).foreach(println)


}
