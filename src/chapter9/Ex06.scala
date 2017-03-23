package chapter9

import java.io.PrintWriter

/**
 * Make a regular expression searching for quoted strings "like this, maybe with \" or \\" in a Java or C++ program.
 * Write a Scala program that prints out all such strings in a source file.
 */
object Ex06 extends App {

  val out = new PrintWriter("/home/carlos/proyectos/ScalaForImpatient/sources/ch09-ex06")

  """\\\"""".r.findAllIn("""Hello \"Basile\" how are you ?""").foreach(out.println(_))

  out.close
}
