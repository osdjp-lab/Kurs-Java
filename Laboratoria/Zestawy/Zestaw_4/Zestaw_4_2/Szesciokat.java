package Zestaw_4_2;

public class Szesciokat extends Figura {
    double a;

    public Szesciokat(double a) {
        this.a = a;
    }

    double pole() {
        return 3 * Math.pow(a, 2) * Math.sqrt(3) / 2;
    }

    double obwod() {
        return 6 * a;
    }

    public String toString() {
        return "Szesciokat o boku "+a;
    }
}
