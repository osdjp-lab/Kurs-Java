public class TrapezRownoramienny extends Figura {
    double a;
    double b;
    double h;

    public TrapezRownoramienny(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    double pole() {
        return (a + b) / 2 * h;
    }

    double obwod() {
        return a + b + 2 * Math.sqrt(Math.pow(Math.abs(a - b) / 2, 2) + Math.pow(h, 2));
    }

    public String toString() {
        return "Trapez rownoramienny z nastepujacymi parametrami [a: "+a+", b: "+b+", h: "+h+"]";
    }
}
