package Zestaw_4_2;

public class Trojkat extends Figura {
    double a;
    double h;

    public Trojkat(double a, double h) {
        this.a = a;
        this.h = h;
    }

    double pole() {
        return a * h / 2;
    }

    double obwod() {
        return 0.0;
    }

    public String toString() {
        return "[a: "+a+", h:"+h+"]";
    }
}
