package chapter4

/**
  * Created by carlos on 21/03/17.
  */
object Questions4 {
  // 1. Set up a map of prices for a number of gizmos that you covet. Then produce
  // a second map with the same keys and the prices at a 10 percent discount.
  val gizmos = Map("iPod" -> 20000, "iPhone" -> 45000, "iPad" -> 30000, "iMac" -> 85000)
  //> gizmos  : scala.collection.immutable.Map[java.lang.String,Int] = Map(iPod ->
  //|  20000, iPhone -> 45000, iPad -> 30000, iMac -> 85000)
  val discountedGizmos = for((k, v) <- gizmos) yield (k, v * 0.9)
  //> discountedGizmos  : scala.collection.immutable.Map[java.lang.String,Double]
  //| = Map(iPod -> 18000.0, iPhone -> 40500.0, iPad -> 27000.0, iMac -> 76500.0)

  // 2. Write a program that reads words from a file. Use a mutable map to count
  // how often each word appears. To read the words, simply use a java.util.Scanner:
  // val in = new java.util.Scanner(java.io.File("myfile.txt"))
  // while (in.hasNext()) process in.next()
  // Or look at Chapter 9 for a Scalaesque way.
  // At the end, print out all words and their counts.
  val fileName = "D:/dev/apache-activemq-5.5.0/LICENSE"
  //> fileName  : java.lang.String = D:/dev/apache-activemq-5.5.0/LICENSE
  var in = new java.util.Scanner(new java.io.File(fileName))
  //> in  : java.util.Scanner = java.util.Scanner[delimiters=\p{javaWhitespace}+][
  //| position=0][match valid=false][need input=false][source closed=false][skippe
  //| d=false][group separator=\,][decimal separator=\.][positive prefix=][negativ
  //| e prefix=\Q-\E][positive suffix=][negative suffix=][NaN string=\Q?\E][infini
  //| ty string=\Q?\E]
  val mMap = new scala.collection.mutable.HashMap[String, Int]()
  //> mMap  : scala.collection.mutable.HashMap[String,Int] = Map()
  def mProcess(s: String) = {
    val c = mMap.getOrElse(s, 0);
    mMap(s) = c + 1
  }                                               //> mProcess: (s: String)Unit

  while(in.hasNext()) mProcess(in.next())
  mMap                                      //> res0: scala.collection.mutable.HashMap[String,Int] = Map(perpetual, -> 2, S
  //| tephenson -> 1, infringed -> 1, litigation -> 2, HOLDERS -> 4, Contribution
  //| (s) -> 3, Definitions. -> 2, OR -> 39, mx4j -> 1, merge, -> 3, recommend ->
  //|  1, including, -> 1, 2005, -> 1, union -> 1, EVENT -> 5, (http://mx4j.sourc
  //| eforge.net)." -> 1, copy, -> 3, generated -> 2, THE -> 26, behaviour.js ->
  //| 1, INTERRUPTION) -> 3, CONNECTION -> 2, preferred -> 1, Legal -> 3, constru
  //| ed -> 1, electronic, -> 1, permitted -> 3, make, -> 1, distribution -> 4, A
  //| UTHORS -> 2, and/or -> 7, written -> 6, tests -> 1, "MX4J", -> 1, 9 -> 1, d
  //| ocument. -> 1, names -> 3, is -> 18, To -> 1, see -> 1, specific -> 3, (BSD
  //|  -> 1, NONINFRINGEMENT. -> 1, consequential -> 1, Entity" -> 1, website</a>
  //| . -> 1, Licensed -> 1, original -> 2, communication -> 3, net -> 1, binary
  //| -> 6, CONDITIONS -> 4, example -> 1, Warranty. -> 1, apply -> 2, a -> 23, "
  //| printed -> 1, informati
  //| Output exceeds cutoff limit.

  // 3. Repeat the preceding exercise with an immutable map.
  var umMap = Map[String, Int]()            //> umMap  : scala.collection.immutable.Map[String,Int] = Map()

  def umProcess(s: String) = {
    val c = umMap.getOrElse(s, 0)
    umMap += (s -> (c + 1))
  }                                         //> umProcess: (s: String)Unit

  in = new java.util.Scanner(new java.io.File(fileName))
  while(in.hasNext()) umProcess(in.next())
  umMap                                     //> res1: scala.collection.immutable.Map[String,Int] = Map(submitted -> 2, (an
  //| -> 1, complies -> 1, used -> 3, IN -> 17, writing -> 1, "Not -> 1, TITLE, -
  //| > 1, reproducing -> 1, damages. -> 1, regarding -> 1, warranties -> 1, from
  //| , -> 1, theory, -> 1, (BSD -> 1, stating -> 1, page" -> 1, Legal -> 3, proj
  //| ect. -> 1, please -> 2, copyright -> 18, licenses -> 1, shares, -> 1, CONTR
  //| ACT, -> 5, failure -> 1, represent, -> 1, ANY -> 18, for -> 21, [yyyy] -> 1
  //| , 2. -> 2, Portions -> 1, WITH -> 2, conditions -> 16, recommend -> 1, Bord
  //| et. -> 1, Apache -> 7, ON -> 3, OWNER -> 2, works -> 1, TERMS -> 2, Appendi
  //| x -> 1, HOLDERS -> 4, NOTICE -> 5, litigation -> 2, EXEMPLARY, -> 3, identi
  //| fying -> 1, any -> 32, filed. -> 1, managed -> 1, reproduce, -> 1, against,
  //|  -> 1, form, -> 4, [name -> 1, SHALL -> 5, PROCUREMENT -> 3, indirect, -> 2
  //| , WARRANTIES -> 7, including, -> 1, For -> 12, January -> 1, name -> 4, thi
  //| s -> 33, THIS -> 6, AUT
  //| Output exceeds cutoff limit.

  // 4. Repeat the preceding exercise with a sorted map, so that the words are
  // printed in sorted order.
  var sMap = scala.collection.immutable.SortedMap[String, Int]()
  //> sMap  : scala.collection.immutable.SortedMap[String,Int] = Map()
  def sProcess(s: String) = {
    val c = sMap.getOrElse(s, 0)
    sMap += (s -> (c + 1))
  }                                         //> sProcess: (s: String)Unit

  in = new java.util.Scanner(new java.io.File(fileName))
  while(in.hasNext()) sProcess(in.next())
  sMap                                      //> res2: scala.collection.immutable.SortedMap[String,Int] = Map("AS -> 6, "Con
  //| tribution" -> 1, "Contributor" -> 1, "Derivative -> 1, "Legal -> 1, "Licens
  //| e" -> 1, "License"); -> 1, "Licensor" -> 1, "MX4J" -> 2, "MX4J", -> 1, "NOT
  //| ICE" -> 1, "Not -> 1, "Object" -> 1, "Software"), -> 3, "Source" -> 1, "Thi
  //| s -> 1, "Work" -> 1, "You" -> 1, "Your") -> 1, "[]" -> 1, "control" -> 1, "
  //| printed -> 1, "submitted" -> 1, (50%) -> 1, (BSD -> 1, (CDDL) -> 2, (Don't
  //| -> 1, (INCLUDING -> 3, (INCLUDING, -> 3, (a) -> 1, (an -> 1, (and -> 1, (b)
  //|  -> 1, (c) -> 7, (d) -> 1, (except -> 1, (http://mx4j.sourceforge.net)." ->
  //|  1, (i) -> 1, (ii) -> 1, (iii) -> 1, (including -> 3, (or -> 3, (see -> 1,
  //| (such -> 1, (the -> 4, * -> 4, *except* -> 1, -- -> 1, -------------------
  //| -> 1, 1 -> 1, 1. -> 3, 1.0 -> 2, 1999, -> 1, 2. -> 2, 2.0 -> 4, 2.0, -> 1,
  //| 2001 -> 1, 2001-12-12 -> 1, 2001-2004 -> 1, 2003-2004, -> 1, 2004 -> 2, 200
  //| 5 -> 1, 2005, -> 1, 3.
  //| Output exceeds cutoff limit.

  // 5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
  // Scala API.
  import scala.collection.JavaConversions.mapAsScalaMap
  val tMap: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
  //> tMap  : scala.collection.mutable.Map[String,Int] = Map()
  def tProcess(s: String) = {
    val c = tMap.getOrElse(s, 0);
    tMap(s) = c + 1
  }                                               //> tProcess: (s: String)Unit

  in = new java.util.Scanner(new java.io.File(fileName))
  while(in.hasNext()) tProcess(in.next())
  tMap                                      //> res3: scala.collection.mutable.Map[String,Int] = Map("AS -> 6, "Contributio
  //| n" -> 1, "Contributor" -> 1, "Derivative -> 1, "Legal -> 1, "License" -> 1,
  //|  "License"); -> 1, "Licensor" -> 1, "MX4J" -> 2, "MX4J", -> 1, "NOTICE" ->
  //| 1, "Not -> 1, "Object" -> 1, "Software"), -> 3, "Source" -> 1, "This -> 1,
  //| "Work" -> 1, "You" -> 1, "Your") -> 1, "[]" -> 1, "control" -> 1, "printed
  //| -> 1, "submitted" -> 1, (50%) -> 1, (BSD -> 1, (CDDL) -> 2, (Don't -> 1, (I
  //| NCLUDING -> 3, (INCLUDING, -> 3, (a) -> 1, (an -> 1, (and -> 1, (b) -> 1, (
  //| c) -> 7, (d) -> 1, (except -> 1, (http://mx4j.sourceforge.net)." -> 1, (i)
  //| -> 1, (ii) -> 1, (iii) -> 1, (including -> 3, (or -> 3, (see -> 1, (such ->
  //|  1, (the -> 4, * -> 4, *except* -> 1, -- -> 1, ------------------- -> 1, 1
  //| -> 1, 1. -> 3, 1.0 -> 2, 1999, -> 1, 2. -> 2, 2.0 -> 4, 2.0, -> 1, 2001 ->
  //| 1, 2001-12-12 -> 1, 2001-2004 -> 1, 2003-2004, -> 1, 2004 -> 2, 2005 -> 1,
  //| 2005, -> 1, 3. -> 2, 4.
  //| Output exceeds cutoff limit.

  // 6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
  // similarly for the other weekdays. Demonstrate that the elements are visited
  // in insertion order.
  val days = scala.collection.mutable.LinkedHashMap("Monday" -> java.util.Calendar.MONDAY,
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Saturday" -> java.util.Calendar.SATURDAY,
    "Sunday" -> java.util.Calendar.SUNDAY)
  //> days  : scala.collection.mutable.LinkedHashMap[java.lang.String,Int] = Map(
  //| Monday -> 2, Tuesday -> 3, Wednesday -> 4, Thursday -> 5, Friday -> 6, Satu
  //| rday -> 7, Sunday -> 1)
  for((k,v) <- days) println(k + ": " + v)       //> Monday: 2
  //| Tuesday: 3
  //| Wednesday: 4
  //| Thursday: 5
  //| Friday: 6
  //| Saturday: 7
  //| Sunday: 1

  // 7. Print a table of all Java properties, like this:
  // java.runtime.name | Java(TM) SE Runtime Environment
  // sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
  // java.vm.version | 17.0-b16
  // java.vm.vendor | Sun Microsystems Inc.
  // java.vendor.url | http://java.sun.com/
  // path.separator | :
  // java.vm.name | Java HotSpot(TM) Server VM
  // You need to find the length of the longest key before you can print the table.
  import scala.collection.JavaConversions.propertiesAsScalaMap
  val jprops: scala.collection.Map[String, String] = System.getProperties()
  //> jprops  : scala.collection.Map[String,String] = Map(java.runtime.name -> Ja
  //| va(TM) SE Runtime Environment, sun.boot.library.path -> C:\Java\jre7\bin, j
  //| ava.vm.version -> 23.6-b04, java.vm.vendor -> Oracle Corporation, java.vend
  //| or.url -> http://java.oracle.com/, path.separator -> ;, java.vm.name -> Jav
  //| a HotSpot(TM) 64-Bit Server VM, file.encoding.pkg -> sun.io, user.country -
  //| > IN, user.script -> "", sun.java.launcher -> SUN_STANDARD, sun.os.patch.le
  //| vel -> Service Pack 1, java.vm.specification.name -> Java Virtual Machine S
  //| pecification, user.dir -> D:\dev\scala-SDK-2.1-M2-2.9-win32.win32.x86_64\ec
  //| lipse, java.runtime.version -> 1.7.0_10-b18, java.awt.graphicsenv -> sun.aw
  //| t.Win32GraphicsEnvironment, java.endorsed.dirs -> C:\Java\jre7\lib\endorsed
  //| , os.arch -> amd64, java.io.tmpdir -> C:\Users\psingh\AppData\Local\Temp\,
  //| line.separator -> "
  //| ", java.vm.specification.vendor -> Oracle Corporation, user.variant -> "",
  var maxKey = 0                                  //> maxKey  : Int = 0
  jprops.keys.foreach(k => maxKey = maxKey max k.length)
  maxKey                                    //> res4: Int = 29
  for((k, v) <- jprops) println(k.padTo(maxKey, ' ') + " | " + v)
  //> java.runtime.name             | Java(TM) SE Runtime Environment
  //| sun.boot.library.path         | C:\Java\jre7\bin
  //| java.vm.version               | 23.6-b04
  //| java.vm.vendor                | Oracle Corporation
  //| java.vendor.url               | http://java.oracle.com/
  //| path.separator                | ;
  //| java.vm.name                  | Java HotSpot(TM) 64-Bit Server VM
  //| file.encoding.pkg             | sun.io
  //| user.script                   |
  //| user.country                  | IN
  //| sun.java.launcher             | SUN_STANDARD
  //| sun.os.patch.level            | Service Pack 1
  //| java.vm.specification.name    | Java Virtual Machine Specification
  //| user.dir                      | D:\dev\scala-SDK-2.1-M2-2.9-win32.win32.x86
  //| _64\eclipse
  //| java.runtime.version          | 1.7.0_10-b18
  //| java.awt.graphicsenv          | sun.awt.Win32GraphicsEnvironment
  //| java.endorsed.dirs            | C:\Java\jre7\lib\endorsed
  //| os.ar
  //| Output exceeds cutoff limit.

  // 8. Write a function minmax(values: Array[Int]) that returns a pair containing the
  // smallest and largest values in the array.
  def minmax(values: Array[Int]) = (values.min, values.max)
  //> minmax: (values: Array[Int])(Int, Int)
  minmax(Array(1,2,3,4,5,6,7,8,9))          //> res5: (Int, Int) = (1,9)

  // 9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
  // the counts of values less than v, equal to v, and greater than v.
  def lteqgt(values: Array[Int], v: Int) = { 	// Scans the array 3 times..., so not very efficient
    ((for(n <- values if n < v) yield n).length,
      (for(n <- values if n == v) yield n).length,
      (for(n <- values if n > v) yield n).length)
  }                                         //> lteqgt: (values: Array[Int], v: Int)(Int, Int, Int)

  lteqgt(Array(1,2,3,4,5,6,7,8,9), 5)       //> res6: (Int, Int, Int) = (4,1,4)

  // 10. What happens when you zip together two strings, such as "Hello".zip("World")?
  // Come up with a plausible use case.
  "Hello".zip("World")                      //> res7: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((H,W), (
  //| e,o), (l,r), (l,l), (o,d))
  // Can be used for ordering (sorting) of strings
}
