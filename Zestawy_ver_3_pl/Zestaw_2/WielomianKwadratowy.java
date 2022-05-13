/**
 * Opisuje wielomian kwadratowy.
 * 
 * @author Oscar Szumiak
 */
public class WielomianKwadratowy {
    double a;
    double b;
    double c;

    /**
     * Konstruktor domyslny.
     */
    WielomianKwadratowy() {
        a = 0.0;
        b = 0.0;
        c = 0.0;
    }

    /**
     * Konstruktor przyjmujacy wartosci wspolczynnikow wielomianu kwadratowego.
     * 
     * @param a wspolczynnik kwadratowy.
     * @param b wspolczynnik liniowy.
     * @param c wspolczynnik staly.
     */
    WielomianKwadratowy(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy WielomianKwadratowy.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy
     *         WielomianKwadratowy.
     */
    public String toString() {
        return "[" + c + ", " + b + ", " + a + "]";
    }

    /**
     * Zwraca sume wielomianow.
     * 
     * @param obj obiekt klasy WielomianKwadratowy.
     * @return obiekt klasy WielomianKwadratowy.
     */
    public WielomianKwadratowy plus(WielomianKwadratowy obj) {
        return new WielomianKwadratowy(a + obj.a, b + obj.b, c + obj.c);
    }

    /**
     * Zwraca iloczyn wielomianow kwadratowych.
     * 
     * @param obj obiekt klasy WielomianKwadratowy.
     * @return obiekt klasy Wielomian.
     */
    public Wielomian razy(WielomianKwadratowy obj) {
        return new Wielomian(c * obj.c, (b * obj.c + c * obj.b), (a * obj.c + b * obj.b + c * obj.a),
                (a * obj.b + b * obj.a), a * obj.a);
    }

    /**
     * Zwraca miejsca zerowe wielomianu kwadratowego.
     * 
     * @return obiekt klasy MiejscaZerowe.
     */
    public MiejscaZerowe miejscaZerowe() {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / 2 * a;
            double x2 = (-b + Math.sqrt(delta)) / 2 * a;
            return new MiejscaZerowe(x1, x2);
        } else if (delta == 0) {
            double x = -b / 2 * a;
            return new MiejscaZerowe(x);
        } else {
            return new MiejscaZerowe();
        }
    }
}

/**
 * Opisuje miejsca zerowe wielomianu kwadratowego.
 */
class MiejscaZerowe {
    double x1;
    double x2;
    boolean f;

    /**
     * Konstruktor domyslny.
     */
    MiejscaZerowe() {
        this.f = false;
    }

    /**
     * Konstruktor przyjmujacy wartosci wspolczynnikow wielomianu kwadratowego.
     * 
     * @param x pojedyncze miejsce zerowe wielomianu kwadratowego.
     */
    MiejscaZerowe(double x) {
        this.x1 = x;
        this.x2 = x;
        this.f = true;
    }

    /**
     * Konstruktor przyjmujacy wartosci wspolczynnikow wielomianu kwadratowego.
     * 
     * @param x1 pierwsze miejsce zerowe wielomianu kwadratowego.
     * @param x2 drugie miejsce zerowe wielomianu kwadratowego.
     */
    MiejscaZerowe(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.f = true;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy WielomianKwadratowy.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy
     *         WielomianKwadratowy.
     */
    public String toString() {
        if (!f) { // jezeli brak miejsc zerowych
            return "None";
        } else if (x1 == x2) { // jezeli jedno miejsce zerowe
            return "[x : " + x1 + "]";
        } else { // jezeli dwa miejsca zerowe
            return "[x1 : " + x1 + ", x2 : " + x2 + "]";
        }
    }
}

/**
 * Opisuje wielomian.
 */
class Wielomian {
    double[] params;

    /**
     * Konstruktor domyslny.
     */
    Wielomian() {
        this.params = new double[10];
    }

    /**
     * Konstruktor przyjmujacy tabele wspolczynnikow wielomianu od najnizszej potegi
     * do najwyzszej
     * 
     * @param params tabela wspolczynnikow wielomianu.
     */
    Wielomian(double... params) { // rownowazne z "double[] params"
        this.params = params;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy WielomianKwadratowy.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy
     *         WielomianKwadratowy.
     */
    public String toString() {
        String output = "[";
        for (int i = 0; i < params.length - 1; i++) {
            output += params[i] + ", ";
        }
        output += params[params.length - 1] + "]";
        return output;
    }
}
