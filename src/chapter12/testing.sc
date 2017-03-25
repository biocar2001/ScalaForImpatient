import scala.math._
val num = 3.14
val fun = ceil _
fun(num)
Array(2.34,2.45,56.23).map(fun)
(x: Double) => 3*x
Array(2.34,2.45,56.23).map((x: Double) => 3*x
)

(1 to 9).map("*" * _).foreach(println _)
(1 to 9).reduceLeft(_ +_)
"Mary had a little lamb".split(" ").sortWith(_.length < _.length)
val a = Array("Hello", "World")
val b = Array("hello", "world")
a.corresponds(b)(_.equalsIgnoreCase(_))
def runInThread(block: => Unit) {
  new Thread {
    override def run() { block }
  }.start()
}
runInThread { println("Hi"); Thread.sleep(10000); println("Bye") }

def until(condition: => Boolean)(block: => Unit) {
  if (!condition) {
    block
    until(condition)(block)
  }
}
var x = 10
until (x == 0){
  x-=1
  println(x)
}



