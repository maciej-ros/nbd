object cw01 {
  import scala.annotation.tailrec

  val days = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

  def cw1a(myList: List[String]): String = {
    var text = ""
    for (i <- 0 to 6) {
      text += myList(i) ++ ","
    }
    text
  }

  def cw1b(myList: List[String]): String = {
    var text = ""
    for (i <- 0 to 6) {
      if (myList(i).startsWith("P")) text += myList(i) ++ ","
    }
    text
  }

  def cw1c(myList: List[String]): String = {
    var text = ""
    var i = 0
    while (i < myList.length) {
      text += myList(i) ++ ","
      i += 1
    }
    text
  }

  def cw2a(myList: List[String]): String = {
    var text2a = ""
    def function(myList: List[String]): String = {
      if (myList.nonEmpty) {
        text2a += myList.head ++ ","
        function(myList.tail)
      }
      text2a
    }
    function(myList)
  }

  def cw2b(myList: List[String]): String = {
    var text2b = ""
    val rev = myList.reverse
    def function(myListRev: List[String]): String = {
      if (myListRev.nonEmpty) {
        text2b += myListRev.head ++ ","
        function(myListRev.tail)
      }
      text2b
    }
    function(rev)
  }

  def cw3(myList: List[String]): String = {
    @tailrec
    def function(words: List[String], result: String): String = {
      if (words.nonEmpty) {
        function(words.tail, result ++ words.head ++ ",")
      } else result
    }
    function(myList, result = "")
  }

  def cw4a(myList: List[String]): String = {
    myList.foldLeft("")((a, b) => a + b + ",")
  }

  def cw4b(myList: List[String]): String = {
    myList.foldRight("")((a, b) => a + "," + b)
  }

  def cw4c(myList: List[String]): String = {
    myList.foldLeft("")((str, word) => if (word.startsWith("P")) str + word + "," else str)
  }

  val mapa = Map("Apple" -> 1.00, "Orange" -> 1.70, "Banana" -> 1.30)
  def cw5(products: Map[String, Double]): Map[String, Double] = {
    products.map { case (product, price) => (product, (math floor 0.9*price * 100) / 100) }
  }

  val krotka = ("ABC", 3.14, true)
  def cw6(t: Tuple3[Any, Any, Any]): Any = {
    val a = t._1
    val b = t._2
    val c = t._3
    (a, b, c)
  }

  def cw7(n: Int): Option[String] = {
    val x = Map(1 -> "a", 2 -> "b", 3 -> "c")
    x.get(n)
  }

  val num = List(1, 0, 3, 0, 0, 5, 0, 0, 0)
  def cw8(myList: List[Int]): List[Int] = {
    var res = List[Int]()
    def rec(myList2: List[Int]): List[Int] = {
      if (myList2.nonEmpty && myList2.head != 0) {
        val x: Int = myList2.head
        res = res :+ x
        rec(myList2.tail)
      } else if (myList2.nonEmpty) {
        rec(myList2.tail)
      }
      res
    }
    rec(myList)
    res
  }

  def cw9(myList: List[Int]): List[Int] = {
    myList.map(x => x + 1)
  }

  val num2: List[Double] = List(-5.5, -8.9, -5, 3.2, 15.6)
  def cw10(myList: List[Double]): List[Double] = {
    val x = myList.filter(x => x >= -5 && x <= 12)
    x.map(x => x.abs)
  }

  def main(args: Array[String]): Unit = {
    println("Maciej Roś (s22776), ćwiczenia 01")
    println("cw1a: " + cw1a(days))
    println("cw1b: " + cw1b(days))
    println("cw1c: " + cw1c(days))
    println("cw2a: " + cw2a(days))
    println("cw2b: " + cw2b(days))
    println("cw3: " + cw3(days))
    println("cw4a: " + cw4a(days))
    println("cw4b: " + cw4b(days))
    println("cw4c: " + cw4c(days))
    println("cw5: " + cw5(mapa))
    println("cw6: " + cw6(krotka))
    println("cw7: cw7(2) - " + cw7(2) + ", cw7(4) - "+ cw7(4))
    println("cw8: " + cw8(num))
    println("cw9: " + cw9(num))
    println("cw10: " + cw10(num2))
}}
