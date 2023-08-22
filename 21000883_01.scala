object Q0901 extends App{
    class Rational(n: Int, d: Int) {
        require(d != 0, "Denominator cannot be zero")

        private val gcdValue = gcd(n.abs, d.abs)
        val numerator: Int = n / gcdValue
        val denominator: Int = d / gcdValue

        private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

        def neg: Rational = new Rational(-numerator, denominator)

        override def toString: String = if (denominator == 1) s"$numerator" else s"$numerator/$denominator"
    }

    object Rational {
        def apply(n: Int, d: Int): Rational = new Rational(n, d)
    }

    object Main extends App {
        val x = Rational(3, 4)
        val neg_x = x.neg

        println(s"x = $x")
        println(s"-x = $neg_x")
    }
}