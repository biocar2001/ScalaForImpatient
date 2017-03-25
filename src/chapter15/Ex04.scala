package chapter15

import scala.annotation.varargs

class Ex04 {
 @varargs def sum(x: Int*): Int = x.sum
}
