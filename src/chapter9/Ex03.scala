package chapter9


/**
 * Write a Scala code snippet that reads a file and prints all words with more than 12 characters to the console.
 * Extra credit if you can do this in a single line.
 */
object Ex03 extends App {

  val longWords = for(a <- io.Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/TestingScala","UTF-8").mkString.split(' ') if a.length >= 12) yield a
  for(l <- longWords) println(l)
}
