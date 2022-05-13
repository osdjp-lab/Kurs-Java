/**
 * Opisuje ulamek.
 * 
 * @author Oscar Szumiak
 */
public class Ulamek {
    int licznik;
    int mianownik;

    /**
     * Konstruktor domyslny.
     */
    Ulamek() {
        this.licznik = 1;
        this.mianownik = 1;
    }

    /**
     * Konstruktor przyjmujacy licznik i mianownik jako parametry inicjalizacyjne.
     * 
     * @param licznik   licznik ulamka.
     * @param mianownik mianownik ulamka.
     */
    Ulamek(int licznik, int mianownik) {
        this.licznik = licznik;
        if (mianownik != 0) {
            this.mianownik = mianownik;
        }
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy Ulamek.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy Ulamek.
     */
    public String toString() {
        return "[licznik: " + licznik + ", mianownik: " + mianownik + "]";
    }

    /**
     * Zwraca rozwiniecie dziesietne ulamka.
     * 
     * @param obj obiekt klasy Ulamek.
     * @return rozwiniecie dziesietne ulamka.
     */
    public double rozwDziesietne() {
        double i = licznik;
        return i / mianownik;
    }

    /**
     * Zwraca sume ulamkow.
     * 
     * @param obj obiekt klasy Ulamek.
     * @return obiekt typu Ulamek bedacy suma ulamka podanego i ulamka ktorego
     *         metoda jest wywolywana.
     */
    public Ulamek plus(Ulamek obj) {
        if (mianownik == obj.mianownik) {
            return new Ulamek(licznik + obj.licznik, mianownik);
        } else {
            return new Ulamek(licznik * obj.mianownik + obj.licznik * mianownik, mianownik * obj.mianownik);
        }
    }

    /**
     * Zwraca roznice ulamkow.
     * 
     * @param obj obiekt klasy Ulamek.
     * @return obiekt typu Ulamek bedacy roznica ulamka podanego i ulamka ktorego
     *         metoda jest wywolywana.
     */
    public Ulamek minus(Ulamek obj) {
        if (mianownik == obj.mianownik) {
            return new Ulamek(licznik - obj.licznik, mianownik);
        } else {
            return new Ulamek(licznik * obj.mianownik - obj.licznik * mianownik, mianownik * obj.mianownik);
        }
    }

    /**
     * Zwraca iloczyn ulamkow.
     * 
     * @param obj obiekt klasy Ulamek.
     * @return obiekt typu Ulamek bedacy iloczynem ulamka podanego i ulamka ktorego
     *         metoda jest wywolywana.
     */
    public Ulamek razy(Ulamek obj) {
        if (mianownik == obj.mianownik) {
            return new Ulamek(licznik * obj.licznik, mianownik * mianownik);
        } else {
            return new Ulamek(licznik * obj.licznik, mianownik * obj.mianownik);
        }
    }

    /**
     * Zwraca iloraz ulamkow.
     * 
     * @param obj obiekt klasy Ulamek.
     * @return obiekt typu Ulamek bedacy iloczynem ulamka podanego i ulamka ktorego
     *         metoda jest wywolywana.
     */
    public Ulamek dziel(Ulamek obj) {
        Ulamek obj2 = new Ulamek(obj.mianownik, obj.licznik);
        return razy(obj2);
    }

    /**
     * Zwraca najwiekszy wspolny dzielnik podanych liczb calkowitych dodatnich.
     * 
     * @version 1.0
     * @param a wieksza liczba
     * @param b mniejsza liczba
     * @return najwiekszy wspolny dzielnik podanych liczb.
     */
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * Zwraca najwiekszy wspolny dzielnik podanych liczb calkowitych dodatnich.
     * 
     * @version 2.0
     * @param a wieksza liczba
     * @param b mniejsza liczba
     * @return najwiekszy wspolny dzielnik podanych liczb.
     */
    int gcd_alt(int a, int b) {
        while (b != 0) {
            int tmp;
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    /**
     * Zwraca najwiekszy wspolny dzielnik podanych liczb calkowitych.
     * 
     * @param a pierwsza liczba
     * @param b druga liczba
     * @return najwiekszy wspolny dzielnik podanych liczb.
     */
    int euclidian_gcd(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        if (x > y) {
            return gcd(x, y);
        } else {
            return gcd(y, x);
        }
    }

    /**
     * Zamienia licznik i mianownik.
     */
    public void odwroc() {
        int tmp = licznik;
        licznik = mianownik;
        mianownik = tmp;
    }

    /**
     * Upraszcza ulamek.
     */
    public void skroc() {
        int gcd = euclidian_gcd(licznik, mianownik);
        licznik = licznik / gcd;
        mianownik = mianownik / gcd;
    }
}
