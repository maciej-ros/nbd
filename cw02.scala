object cw02 {
  val days = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def cw1(day: String): String = day match {
    case "Poniedzialek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  class KontoBankowe(private var _stanKonta: Double) {
    def this() {
      this(0)
    }
    def stanKonta: Double = _stanKonta
    def wplata(kwota: Double): Unit = _stanKonta = _stanKonta + kwota
    def wyplata(kwota: Double): Unit = _stanKonta = _stanKonta - kwota

  }

  case class Osoba(val imie: String, val nazwisko: String)

  val a = Osoba("Marek", "Kowalski")
  val b = Osoba("Andrzej", "Mlot")
  val c = Osoba("Cezary", "Willson")

  def cw3(person: Osoba): String = person match {
    case Osoba("Marek", _) => "Czesc Marku!"
    case Osoba(_,"Willson") => "Czolem Czarku :)"
    case Osoba(name,_) => s"Nie poznalem Cie jeszcze $name"
  }

  def squared(n: Int): Int = n*n

  def cw4(n: Int, f: Int => Int): Int = {
    f(f(f(n)))
  }

  class Osoba2(val imie: String,
               val nazwisko: String) {
    private val _podatek: Double = 66
    def podatek: Double = _podatek
  }

  trait Pracownik extends Osoba2 {
    private var _pensja = 500
    override def podatek: Double = 0.2*_pensja
    def pensja: Int = _pensja
    def pensja_= (value: Int): Unit = _pensja = value
  }

  trait Student extends Osoba2 {
    override def podatek: Double = 0
  }

  trait Nauczyciel extends Pracownik {
    override def podatek: Double = 0.1*pensja
  }

  def main(args: Array[String]): Unit = {
    println("Maciej Roś (s22776), ćwiczenia 02")
    println("cw1: " + cw1(days(1)))
    println("cw3: " + cw3(a))
    println(cw3(b))
    println(cw3(c))
    println("cw5:" + cw4(2, squared))
    println("cw6:")

    val pracownik_marian = new Osoba2("Marian", "Zieba") with Pracownik
    pracownik_marian.pensja = 400
    println("Podatek pracownika Mariana:" + pracownik_marian.podatek)

    val student_tomasz = new Osoba2("Tomasz", "Aleksy") with Student
    println("Podatek studenta Tomasza:" + student_tomasz.podatek)

    val nauczyciel_waldek = new Osoba2("Waldemar", "Bober") with Nauczyciel
    nauczyciel_waldek.pensja = 400
    println("Podatek nauczyciela Waldka:" + nauczyciel_waldek.podatek)

    val test1 = new Osoba2("x", "y") with Pracownik with Student
    println(test1.podatek)

    val test2 = new Osoba2("x", "y") with Student with Pracownik
    println(test2.podatek)


  }
}