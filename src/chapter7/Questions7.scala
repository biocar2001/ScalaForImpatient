package chapter7

/**
  * Created by carlos on 22/03/17.
  */
class Questions7 {
  /**
  1) Write an example program to demonstrate that
package con.horstmann.impatient
is not the same as
package com
package horstmann
package impatient
NOTE:
    See Source file at ./src/main/scala/Ch7Q1.scala where the packages are nested
    the examples below show how just changing the RIGHT import the nested objects
    or classes can be brought in scope.
    */
  object Ch7Q1 {
    println("Ch 7 Question 1 " + "-" * 60)

    /*
    VISIBLE Objects are
    1) object InsideAbsolutePackage from Ch7Q1Absolute.scala
    2) object Ch7Q1JustComAndHorstMannImpatient from Ch7Q1_Com_Horstmann_Impatient.scala
    IN-VISIBLE Objects are, since the package declared
    is "com@horstmann@impatient" since the package at "@" are shorted
    1) Ch7Q1JustCom from Ch7Q1_Com.scala
    2) Ch7Q1JustComHorstmann from Ch7Q1_Com_Horstmann.scala
    */
    val testAbsolute = {
      println("==== Testing Absolute package =====")
      import com.horstmann.impatient._
      InsideAbsolutePackage
      Ch7Q1JustComAndHorstMannImpatient
    }

    val testNested = {
      println("==== Testing Nested package =====")
      import com._
      Ch7Q1JustCom

      import com.horstmann._
      Ch7Q1JustComAndHorstMann
    }
  }

  /**
  2) Write a puzzler that baffles your Scala friends. using a package com that isn't at
the top level.
    */
  import some._
  object Ch7Q2 {
    println("Ch 7 Question 2 " + "-" * 60)
    println( """
  See src=Ch7Q2.scala, the package declaration is "some.com"
  Here we do import 'com._' which looks like importing from 'com.something'
  This is possible, because scala imports are RELATIVE
  Notice import of 'some' is done above of "object Ch7Q2" line
           """)

    import com._
    SomeMiddleCom
  }

  /**
  3) Write a package random with functions nextInt(): Int, nextDoub1e(): Double.
and setSeed(seed: Int) : Unit. To generate random numbers. use the linear
congruential generator
next = previous X a + b mod 2",
where a = 1664525, b = 1013904223, and n = 32.
    */
  object Ch7Q3 {
    println("Ch 7 Question 3 " + "-" * 60)
    println("Notice the class 'TestRandom' being inside package 'random' is able to see global objects inside package-object 'random' ")

    import random.TestRandom
    val testRandom1 = new TestRandom(0)
    printf("randomDouble=%f \n", testRandom1.randomDouble())
    printf("randomInt=%d    \n", testRandom1.randomInt()   )
    printf("randomDouble=%f \n", testRandom1.randomDouble())
    printf("randomInt=%d    \n", testRandom1.randomInt()   )
  }

  /**
  4) Why do you think the Scala language designers provided the package object
syntax instead of simply letting you add functions and variables to a package?
    */
  object Ch7Q4 {
    println("Ch 7 Question 4 " + "-" * 60)
    println(
      """
    To provide an umbrella object to the package,
    as an single instance, instead of spreading common utilities and global variables at different sub packages
    and prevent accidently overriding, each other
    """)
  }

  /**
  5) What is the meaning of private[com] def giveRaise(rate: Double)? Is it
useful?
    */
  object Ch7Q5 {
    println("Ch 7 Question 4 " + "-" * 60)
    println(
      """
      The [com] in square brackets is basically increasing
      the scope of function "giveRaise" to "com" package.
      It is NOT useful since, to use this function "giveRise" one
      has to import the class/object holding this function.
      Since the same functionality can be provided without expanding to "[com]"
    """)

  }

  /**
  6) Write a program that copies all elements from a Java hash map into a Scala hash
map. Use imports to rename both classes.
    */
  object Ch7Q6 {
    println("Ch 7 Question 6" + "-" * 60)

    import java.util.{HashMap => JHashmap}
    import collection.immutable.{HashMap => SHashMap}

    val javaMap = new JHashmap[String, String]
    javaMap.put("one", "1-1")
    javaMap.put("two", "2-2")
    javaMap.put("three", "3-3")

    var scalaMap = SHashMap[String, String]()
    val javaItr = javaMap.entrySet.iterator
    while (javaItr.hasNext) {
      val javaEntrySet = javaItr.next
      scalaMap += (javaEntrySet.getKey -> javaEntrySet.getValue)
    }
    printf("Scala Map=%s \n", scalaMap)
  }

  /**
  7) In the preceding exercise, move all imports into the innermost scope possible.
What is the effect of
    */
  object Ch7Q7 {
    println("Ch 7 Question 7" + "-" * 60)
    println("The best inner most I could move is creating local block, if you guys have better answer, please let me know")

    val javaMap = {
      import java.util.{HashMap => JHashmap}
      new JHashmap[String, String]
    }
    var scalaMap = {
      import collection.immutable.{HashMap => SHashMap}
      SHashMap[String, String]()
    }
    //fill test java map values
    javaMap.put("one", "1-1")
    javaMap.put("two", "2-2")
    javaMap.put("three", "3-3")

    val javaItr = javaMap.entrySet.iterator
    while (javaItr.hasNext) {
      val javaEntrySet = javaItr.next
      scalaMap += (javaEntrySet.getKey -> javaEntrySet.getValue)
    }
    printf("Scala Map=%s \n", scalaMap)
  }

  /**
  8)
import java ._
inport javax ._
Is this a good idea?
    */
  object Ch7Q8{
    println("Ch 7 Question 8 " + "-" *60)
    println(
      """
    It not good idea for following reasons:
    a) Difficult to identify Class/Objects being used from which package,
    meaning do not make wild-char import.
    b) When we do wild-char import at similar level packages, Objects from
    the first line of import "java._" may be masked by second line "javax._"
    c) Since Scala imports are relative, there will be more ambiguity
    when the user writes his own packages,
    say for example "package util.Random own-class"
    """)
  }
  /**
  9)
Write a program that imports the java.lang.System class, reads the user name
from the user.name system property, reads a password from the Console object,
and print a message to the standard error stream if the password is not ‘secret’.
Otherwise print a greeting to the standard output stream. Do not use any other
imports, and do not use any qualiﬁed names (with dots).
    */
  object Ch7Q9 {
    println("Ch 7 Question 9 " + "-" * 60)
    val userName = System getProperty("user.name")
    print("Please input password: ")
    val password = readLine
    password match {
      case "secret" => println ("Welcome to Scala Mr. " + userName)
      case _        => System.err.println("key'ed in Password is not \"secret\" ")
    }
  }

  /**
  10)
Apart from StringBuilder, which other members of java.1ang does the scala
package override?
    */
  object Ch7Q10 {
    println("Ch 7 Question 10 " + "-" * 60)
    println(
      """
    The primitive wrappers are overriden,
    Boolean, Byte, Double, Float, Long and Short
    """)
  }
}
