package Laboratoria.Zestawy.Zestaw_2;

/**
 * Zawiera parametry opisujące ułamek.
 * @param licznik licznik ułamka.
 * @param mianownik mianownik ułamka.
 */
public class Ulamek
{
    int licznik;
    int mianownik;

    /**
     * Konstruktor domyślny nie przyjmujący argumentów inicjalizacyjnych.
     */
    Ulamek()
    {
        this.licznik = 1;
        this.mianownik = 1;
    }

    /**
     * Konstruktor przyjmujący licznik i mianownik jako parametry inicjalizacyjne.
     * @param licznik licznik ułamka.
     * @param mianownik mianownik ułamka.
     */
    Ulamek(int licznik, int mianownik) {
        this.licznik = licznik;
        if (mianownik != 0) {
            this.mianownik = mianownik;
        }   
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy Ulamek.
     * @return ciąg znaków zawierający informacje o obiekcie klasy Ulamek.
     */
    public String toString() {
        return "[licznik: "+licznik+", mianownik: "+mianownik+"]";
    }

    /**
     * Zwraca rozwinięcie dziesiętne ułamka.
     * @return rozwinięcie dziesiętne ułamka.
     */
    double rozwDziesietne() {
        double i = licznik;
        return i/mianownik;
    }

    /**
     * Realizuje operację dodawania ułamków.
     * @return obiekt typu Ulamek będący sumą ułamku podanego i ułamku którego metoda jest wywoływana.
     */
    Ulamek plus(Ulamek obj) {
        if (mianownik == obj.mianownik) {
            return new Ulamek(licznik + obj.licznik, mianownik);
        } else {
            return new Ulamek(licznik*obj.mianownik+obj.licznik*mianownik, mianownik*obj.mianownik);
        }
    }

    /**
     * Realizuje operację odejmowania ułamków.
     * @return obiekt typu Ulamek będący różnicą ułamku podanego i ułamku którego metoda jest wywoływana.
     */
    Ulamek minus(Ulamek obj) {
        if (mianownik == obj.mianownik) {
            return new Ulamek(licznik - obj.licznik, mianownik);
        } else {
            return new Ulamek(licznik*obj.mianownik-obj.licznik*mianownik, mianownik*obj.mianownik);
        }
    }

    /**
     * Realizuje operację mnożenia ułamków.
     * @return obiekt typu Ulamek będący iloczynem ułamku podanego i ułamku którego metoda jest wywoływana.
     */
    Ulamek razy(Ulamek obj) {
        if (mianownik == obj.mianownik) {
            return new Ulamek(licznik * obj.licznik, mianownik*mianownik);
        } else {
            return new Ulamek(licznik*obj.licznik, mianownik*obj.mianownik);
        }
    }

    /**
     * Zwraca największy wspólny dzielnik podanych liczb całkowitych dodatnich.
     * @version 1.0
     * @return największy wspólny dzielnik podanych liczb.
     */
    int gcd(int a, int b) { 
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    /**
     * Zwraca największy wspólny dzielnik podanych liczb całkowitych dodatnich.
     * @version 2.0
     * @return największy wspólny dzielnik podanych liczb.
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
     * Zwraca największy wspólny dzielnik podanych liczb całkowitych.
     * @return największy wspólny dzielnik podanych liczb.
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
     * Upraszcza ułamek.
     */
    void skroc() {
        int gcd = euclidian_gcd(licznik, mianownik);
        licznik = licznik / gcd;
        mianownik = mianownik / gcd;
    }

    /**
     * Zamienia licznik i mianownik.
     */
    void odwroc() {
        int tmp = licznik;
        licznik = mianownik;
        mianownik = tmp;
    }
}
