package chapter3

import scala.collection.mutable.ArrayBuffer

/**
  * Created by carlos on 21/03/17.
  */
object Questions3 {
  // 1. Write a code snippet that sets a to an array of n random integers between 0
  // (inclusive) and n (exclusive).
  val a1 = new Array[Int](10)                //> a  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  for(i <- 0 until a1.length) a1(i) = scala.util.Random.nextInt(10)
  a                                         //> res0: Array[Int] = Array(9, 0, 5, 8, 6, 6, 3, 9, 0, 3)

  // 2. Write a loop that swaps adjacent elements of an array of integers. For example,
  // Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
  val a2 = Array[Int](1,2,3,4,5)
  a2                                        //> res1: Array[Int] = Array(1, 2, 3, 4, 5)
  for(i <- 0 until (if(a.length % 2 == 0) a2.length else a2.length - 1) if(i % 2 == 1) ) {
    val temp = a2(i)
    a2(i) = a2(i-1)
    a2(i-1) = temp
  }
  a2                                         //> res2: Array[Int] = Array(2, 1, 4, 3, 5)

  // 3. Repeat the preceding assignment, but produce a new array with the swapped
  // values. Use for/yield.
  val a3 = Array[Int](1,2,3,4,5)                    //> res3: Array[Int] = Array(1, 2, 3, 4, 5)
  for(i <- 0 until a3.length) yield if(i % 2 == 1) a3(i - 1) else {if(i == a3.length - 1) a3(i) else a3( i + 1)}
  //> res4: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 1, 4, 3, 5)

  // 4. Given an array of integers, produce a new array that contains all positive
  // values of the original array, in their original order, followed by all values that
  // are zero or negative, in their original order.
  var a = Array[Int](2,6,-1,9,0,-4,-6)
  val pos, oth = new ArrayBuffer[Int]  //> pos  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  //| oth  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()

  // collect indices of positive and others in the array
  for(i <- 0 until a.length) {
    if (a(i) > 0) pos += i
    else oth += i
  }

  // Use the indices to create the new array
  var ab = new ArrayBuffer[Int]             //> ab  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  ab ++= (for(i <- pos) yield a(i))         //> res5: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(2, 6, 9)
  ab ++= (for(i <- oth) yield a(i))         //> res6: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(2, 6, 9, -1, 0, -4, -6)
  ab.toArray                                //> res8: Array[Int] = Array(2, 6, 9, -1, 0, -4, -6)

  // 5. How do you compute the average of an Array[Double]?
  val d = Array[Double](1.0, 2.0, 3.0, 4.0, 5.0)
  //> d  : Array[Double] = Array(1.0, 2.0, 3.0, 4.0, 5.0)
  d.sum / d.length                          //> res9: Double = 3.0

  // 6. How do you rearrange the elements of an Array[Int] so that they appear in
  // reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
  a.sortWith(_ > _)                         //> res10: Array[Int] = Array(9, 6, 2, 0, -1, -4, -6)
  ab.sortWith(_ > _)                        //> res11: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(9, 6, 2, 0,
  //| -1, -4, -6)

  // 7. Write a code snippet that produces all values from an array with duplicates
  // removed. (Hint: Look at Scaladoc.)
  a = Array[Int](2, 6, -1, 9, 0, -4, 6, -1, 8)
  a.distinct                                //> res12: Array[Int] = Array(2, 6, -1, 9, 0, -4, 8)

  // 8. Rewrite the example at the end of Section 3.4, "Transforming Arrays," on
  // page 34 using the drop method for dropping the index of the first match. Look
  // the method up in Scaladoc.
  ab = ArrayBuffer[Int](2, 6, -1, 9, 0, -4, 6, -1, 8)
  var indexes = (for (i <- 0 until a.length if a(i) < 0) yield i)
  //> indexes  : scala.collection.immutable.IndexedSeq[Int] = Vector(2, 5, 7)
  indexes = indexes.drop(1)
  for (j <- indexes.reverse) ab.remove(j)
  ab                                        //> res14: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(2, 6, -1, 9,
  //|  0, 6, 8)

  // 9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
  // that are in America. Strip off the "America/" prefix and sort the result.
  val tz = java.util.TimeZone.getAvailableIDs().filter(_.startsWith("America/")).map( (s) => s.stripPrefix("America/"))
  //> tz  : Array[String] = Array(Adak, Atka, Anchorage, Juneau, Nome, Sitka, Yak
  //| utat, Dawson, Ensenada, Los_Angeles, Metlakatla, Santa_Isabel, Tijuana, Van
  //| couver, Whitehorse, Boise, Cambridge_Bay, Chihuahua, Creston, Dawson_Creek,
  //|  Denver, Edmonton, Hermosillo, Inuvik, Mazatlan, Ojinaga, Phoenix, Shiprock
  //| , Yellowknife, Bahia_Banderas, Belize, Cancun, Chicago, Costa_Rica, El_Salv
  //| ador, Guatemala, Indiana/Knox, Indiana/Tell_City, Knox_IN, Managua, Matamor
  //| os, Menominee, Merida, Mexico_City, Monterrey, North_Dakota/Beulah, North_D
  //| akota/Center, North_Dakota/New_Salem, Rainy_River, Rankin_Inlet, Regina, Re
  //| solute, Swift_Current, Tegucigalpa, Winnipeg, Atikokan, Bogota, Cayman, Cor
  //| al_Harbour, Detroit, Fort_Wayne, Grand_Turk, Guayaquil, Havana, Indiana/Ind
  //| ianapolis, Indiana/Marengo, Indiana/Petersburg, Indiana/Vevay, Indiana/Vinc
  //| ennes, Indiana/Winamac, Indianapolis, Iqaluit, Jamaica, Kentucky/Louisville
  //| , Kentucky/Monticello, ...

  // 10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with
  // the call
  // val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  // Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor
  // and get the return value as a Scala buffer. (Why this obscure class? It's hard
  // to find uses of java.util.List in the standard Java library.)
  import java.awt.datatransfer._
  import scala.collection.JavaConverters._
  import scala.collection.mutable.Buffer
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  //> flavors  : java.awt.datatransfer.SystemFlavorMap = java.awt.datatransfer.Sy
  //| stemFlavorMap@54b24c03
  val nativesForFlavors = flavors.getNativesForFlavors(Array(DataFlavor.imageFlavor))
  //> nativesForFlavors  : java.util.Map[java.awt.datatransfer.DataFlavor,String]
  //|  = {java.awt.datatransfer.DataFlavor[mimetype=image/x-java-image;representa
  //| tionclass=java.awt.Image]=PNG}
  val vals = collection.JavaConversions.asScalaBuffer(new java.util.LinkedList(nativesForFlavors.values()))
  //> vals  : scala.collection.mutable.Buffer[String] = Buffer(PNG)-
}
