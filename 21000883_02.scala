object Q0902 extends App{
    class Rational(n: Int, d: Int) {
        require(d != 0, "Denominator cannot be zero")

        private val gcdValue = gcd(n.abs, d.abs)
        val numerator: Int = n / gcdValue
        val denominator: Int = d / gcdValue

        private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

        def neg: Rational = new Rational(-numerator, denominator)

        def sub(other: Rational): Rational = new Rational(numerator * other.denominator - other.numerator * denominator, denominator * other.denominator)

        override def toString: String = if (denominator == 1) s"$numerator" else s"$numerator/$denominator"
    }

    object Rational {
        def apply(n: Int, d: Int): Rational = new Rational(n, d)
    }

    object Main extends App {
        val x = Rational(3, 4)
        val y = Rational(5, 8)
        val z = Rational(2, 7)

        val result = x.sub(y).sub(z)

        println(s"x = $x")
        println(s"y = $y")
        println(s"z = $z")
        println(s"x - y - z = $result")
    }

}