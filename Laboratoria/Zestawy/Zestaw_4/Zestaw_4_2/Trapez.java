package Zestaw_4_2;

public class Trapez extends Figura {
    double a;
    double b;
    double h;

    public Trapez(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    double pole() {
        return (a + b) / 2 * h;
    }

    double obwod() {
        return 0.0;
    }

    public String toString() {
        return "[a: "+a+", b:"+b+", h:"+h+"]";
    }
}
