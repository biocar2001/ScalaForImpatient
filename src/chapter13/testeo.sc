import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader

def digits(n: Int): Set[Int] =
  if (n < 0) digits(-n)
  else if (n < 10) Set(n)
  else digits(n / 10) + (n % 10)

digits(43)

val res1 = 9 :: 4 :: 2 :: Nil
def sum(lst: List[Int]): Int =
  if (lst == Nil) 0 else lst.head + sum(lst.tail)
def sum2(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum(t) // h is lst.head, t is lst.tail
}

List(2,3,4).sum


