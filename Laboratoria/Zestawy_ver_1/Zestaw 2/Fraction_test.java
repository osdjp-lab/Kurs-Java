class Fraction {
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    double decimal_rep() {
        return (double) numerator / denominator;
    }

    Fraction add(Fraction obj) {
        int new_numerator;
        new_numerator = numerator * obj.denominator + obj.numerator * denominator;
        int new_denominator;
        new_denominator = denominator * obj.denominator;
        return new Fraction(new_numerator, new_denominator);
    }

    Fraction sub(Fraction obj) {
        int new_numerator;
        new_numerator = numerator * obj.denominator - obj.numerator * denominator;
        int new_denominator;
        new_denominator = denominator * obj.denominator;
        return new Fraction(new_numerator, new_denominator);
    }

    Fraction mult(Fraction obj) {
        return new Fraction(numerator * obj.numerator, denominator * obj.denominator);
    }

    Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    Fraction simplify() {
        int gcd = gcdByEuclidsAlgorithm(denominator, numerator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    public String toString() {                                                                          
      return "[numerator: " + numerator + ", denominator: " + denominator + "]"; 
    }
}


public class Fraction_test {
    public static void main(String[] args) {
        Fraction obj, obj2;
        obj = new Fraction(6,8);
        obj2 = new Fraction(3,7);
        
        System.out.println("obj: " + obj);
        System.out.println("obj2: " + obj2);
        
        double x = obj.decimal_rep();

        System.out.println("Decimal representation: " + x);
        
        Fraction obj3=obj.add(obj2);
        Fraction obj4=obj.sub(obj2);
        Fraction obj5=obj.mult(obj2);

        System.out.println("obj3: " + obj3);
        System.out.println("obj4: " + obj4);
        System.out.println("obj5: " + obj5);
        
        System.out.println("Inverted: " + obj.invert());
        System.out.println("Simplified: " + obj.simplify());
    }
}