public class TrojkatRownoboczny extends Figura {
    double a;

    public TrojkatRownoboczny(double a) {
        this.a = a;
    }

    double pole() {
        return Math.pow(a, 2) * Math.sqrt(3) / 4;
    }

    double obwod() {
        return 3 * a;
    }

    public String toString() {
        return  "Trojkat rownoboczny o boku "+a;
    }
}
