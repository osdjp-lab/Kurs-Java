package Laboratoria.Zestawy.Zestaw_2;

/**
 * Zawiera parametry opisujące wielomian kwadratowy.
 * @param a współczynnik kwadratowy.
 * @param b współczynnik liniowy.
 * @param c współczynnik stały.
 */
public class WielomianKwadratowy {
    double a;    
    double b;
    double c;

    WielomianKwadratowy() {
        a = 0.0;
        b = 0.0;
        c = 0.0;
    }

    WielomianKwadratowy(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy WielomianKwadratowy.
     * @return ciąg znaków zawierający informacje o obiekcie klasy WielomianKwadratowy.
     */
    public String toString() {
        return "["+c+", "+b+", "+a+"]";
    }

    /**
     * Zwraca sumę wielomianów.
     * @param obj obiekt typu WielomianKwadratowy który ma zostać dodany.
     * @return obiekt typu WielomianKwadratowy będący sumą wielomianów.
     */
    WielomianKwadratowy plus(WielomianKwadratowy obj) {
        return new WielomianKwadratowy(a + obj.a, b + obj.b, c + obj.c);
    }

    /**
     * Zwraca iloczyn wielomianów kwadratowych.
     * @param obj drugi wielomian w iloczynie wielomianów.
     * @return obiekt typu Wielomian będący iloczynem wielomianów kwadratowych.
     */
    Wielomian razy(WielomianKwadratowy obj) {
        return new Wielomian(c*obj.c, (b*obj.c + c*obj.b), (a*obj.c + b*obj.b + c*obj.a), (a*obj.b + b*obj.a), a*obj.a);
    }
    
    MiejscaZerowe miejsce_zerowe() {
        double delta = Math.pow(b, 2) - 4*a*c;
        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / 2*a;
            double x2 = (-b + Math.sqrt(delta)) / 2*a;
            return new MiejscaZerowe(x1, x2);
        } else if (delta == 0) {
            double x = -b / 2*a;
            return new MiejscaZerowe(x);
        } else {
            return new MiejscaZerowe();
        }
    }
}

/**
 * Zawiera parametry opisujące możliwe wyniki obliczeń miejsc
 * zerowych wielomianu kwadratowego.
 * @param x1 miejsce zerowe pierwsze.
 * @param x2 miejsce zerowe drugie.
 * @param f flaga określająca czy występują miejsca zerowe.
 */
class MiejscaZerowe {
    double x1;
    double x2;
    boolean f;

    MiejscaZerowe() {
        this.f = false;
    }

    MiejscaZerowe(double x) {
        this.x1 = x;
        this.x2 = x;
        this.f = true;
    }

    MiejscaZerowe(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.f = true;
    }

    public String toString() {
        if (!f) {  // jeżeli brak miejsc zerowych
            return "None";
        } else if (x1 == x2) { // jeżeli jedno miejsce zerowe
            return "[x : "+x1+"]";
        } else {  // jeżeli dwa miejsca zerowe
            return "[x1 : "+x1+ ", x2 : "+x2+"]";
        }
    }
}

/**
 * Zawiera parametry opisujące wielomian.
 * @param params tabela współczynników wielomianu.
 */
class Wielomian {
    double[] params;

    Wielomian() {
        this.params = new double[10];
    }

    Wielomian(double... params) {  //równoważne z "double[] params"
        this.params = params;
    }

    public String toString() {
        String output = "[";
        for (int i=0; i<params.length - 1; i++) {
            output+=params[i]+", ";
        }
        output+=params[params.length - 1]+"]";
        return output;
    }
}
