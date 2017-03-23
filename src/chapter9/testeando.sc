import scala.collection.mutable.ArrayBuffer
import scala.io.Source
/*val source = Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/TestingScala","UTF-8")
/*val iterator = source.getLines()
for(l <- iterator) println(l)

val iteratorArray = source.getLines().toArray
*/
val contents = source.mkString

print("Carlos " + contents)

source.close()


//for(l <- source) println(l)


val sourceNumbers = Source.fromFile("/home/carlos/proyectos/ScalaForImpatient/sources/numbers","UTF-8")
val numbers = sourceNumbers.getLines().toArray
val g = numbers.map(_.toDouble)
for(l <- g) println(l)

class Person extends Serializable {
  private val friends = new ArrayBuffer[String] // OK—ArrayBuffer is serializable

}
val fred = new Person()
import java.io._
val out = new ObjectOutputStream(new FileOutputStream("/home/carlos/proyectos/ScalaForImpatient/sources/test.obj"))
out.writeObject(fred)
out.close()
val in = new ObjectInputStream(new FileInputStream("/home/carlos/proyectos/ScalaForImpatient/sources/test.obj"))
val savedFred = in.readObject().asInstanceOf[Person]*/
import sys.process._
"ls -al" !







