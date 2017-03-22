package chapter2

/**
  * Created by carlos on 20/03/17.
  * Questions about chapter 2 - Control structures and functions
  */
object Questions2 {
  // 1. The signum of a number is 1 if the number is positive, -1 if it is negative, and
  // 0 if it is zero. Write a function that computes this value.

  def signum(n: Int) = {
    if (n > 0) 1
    else if (n < 0) -1
    else 0
  }                                               //> signum: (n: Int)Int

  signum(4)                                       //> res0: Int = 1
  signum(0)                                       //> res1: Int = 0
  signum(-20)                                     //> res2: Int = -1

  // 2. What is the value of an empty block expression {}? What is its type?
  val blank = {}                                  //> blank  : Unit = ()
  // Value is () and type is Unit

  // 3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
  // (Hint: Pick a suitable type for x.)
  var y: Int = 0                            //> y  : Int = 0
  val x: Unit = y = 1                       //> x  : Unit = ()
  // x should be of type Unit

  // 4. Write a Scala equivalent for the Java loop
  // for (int i = 10; i >= 0; i--) System.out.println(i);
  for(i <- 10 to (0, -1)) println(i)        //> 10
  //| 9
  //| 8
  //| 7
  //| 6
  //| 5
  //| 4
  //| 3
  //| 2
  //| 1
  //| 0
  // 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
  def countdown(n: Int): Unit = {
    for(i <- n to (0, -1)) println(i)
  }                                         //> countdown: (n: Int)Unit
  countdown(5)                              //> 5
  //| 4
  //| 3
  //| 2
  //| 1
  //| 0
  // 6. Write a for loop for computing the product of the Unicode codes of all letters
  // in a string. For example, the product of the characters in "Hello" is 9415087488.
  var prod: BigInt = 1                              //> prod: BigInt = 1
  for(c <- "Hello") prod *= c
  prod                                      //> res3: Int = 9415087488

  // 7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
  // Scaladoc.)
  "Hello".foldLeft(1: BigInt)((a, b) => a * b)      //> res4: BigInt = 9415087488

  // 8. Write a function product(s : String) that computes the product, as described
  // in the preceding exercises.
  def product(s: String) = s.foldLeft(1: BigInt)((a, b) => a * b)
  //> product: (s: String)BigInt
  product("Hello")                                //> res5: BigInt = 9415087488

  // 9. Make the function of the preceding exercise a recursive function.
  def productRec(s: String): BigInt = {
    if (s.length == 0) 1
    else s.head * productRec(s.tail)
  }                                        //> productRec: (s: String)BigInt
  productRec("Hello")                       //> res6: BigInt = 9415087488

  // 10. Write a function that computes x^n, where n is an integer. Use the following
  // recursive definition
  // xn = y2 if n is even and positive, where y = x ^ n / 2.
  // xn = x * x ^ n - 1 if n is odd and positive.
  // x0 = 1
  // xn = 1 / x ^ -n if n is negative.
  // Don't use a return statement.
  def xpown(x: BigDecimal, n: Int): BigDecimal = {
    if (n == 0) 1
    else if (n < 0) 1 / xpown(x, -n)
    else if (n % 2 == 0) {
      val i = xpown(x, n / 2)
      i * i
    }
    else x * xpown(x, n - 1)
  }                               //> xpown: (x: BigDecimal, n: Int)BigDecimal
  xpown(2, 1024)                  //> res7: BigDecimal = 1.797693134862315907729305190789023E+308
  xpown(-2, -10)			//> res8: BigDecimal = 0.0009765625
  xpown(-2, 10)			//> res9: BigDecimal = 1024
}
