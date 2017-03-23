package chapter9

import scala.io.Source
import scala.util.matching.Regex

/**
 * Write a Scala program that reads a text file and prints all tokens in the file that are not floating-point numbers.
 * Use a regular expression.
 */
object Ex07 extends App {

  val r = new Regex("""^\d+?\.\d+$""")

  val result = Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/numbers","UTF-8").mkString.split("""\s+""").filter(r.findFirstIn(_)==None)

  result.foreach(println)

}
