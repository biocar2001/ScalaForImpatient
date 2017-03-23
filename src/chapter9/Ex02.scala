package chapter9

/**
 * Write a Scala program that reads a file with tabs, replaces each tab with spaces so that tab stops are
 * at n -column boundaries, and writes the result to the same file.
 */
import io.Source
import java.io.PrintWriter
object Ex02 extends App {
  val source = Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/tbas.txt")
  val lines = source.mkString
  var i = 0
  source.close
  println(lines)

  //input: a string, an int representing the n-column bounds for tab-stops
  //output: a string with tabs replaced with spaces such that tabs end at
  //        nColumn indexes
  def tabReplace(line: String, nColumn: Int) = {
    var output = line
    while(i < output.length) {
      if(output(i) == '\t') {
        println("Found a tab!")
        val toAdd = i % nColumn
        output = output.take(i-1) + (" " + " " * toAdd) + output.drop(i)
      }
      i += 1
    }
    output
  }
  val replaced = tabReplace(lines, 4)

  val out = new PrintWriter("/home/carlos/proyectos/ScalaForImpatient/src/chapter9/tabs.txt")
  for(char <- replaced) { out.print(char) }
  out.close
}
