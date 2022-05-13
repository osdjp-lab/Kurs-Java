/**
 * Zawiera parametry opisujace prostokat w przestrzeni 2-wymiarowej.
 * 
 * @author Oscar Szumiak
 */
public class Prostokat {
    double dlugosc;
    double szerokosc;
    Punkt srodek;

    /**
     * Konstruktor domyslny nie przyjmujacy argumentow inicjalizacyjnych.
     */
    Prostokat() {
        this.dlugosc = 0.0;
        this.szerokosc = 0.0;
        this.srodek = new Punkt();
    }

    /**
     * Konstruktor przyjmujacy dlugosc i szerokosc prostokata jako parametry
     * inicjalizacyjne.
     * 
     * @param dlugosc   dlugosc poziomego boku prostokata.
     * @param szerokosc dlugosc pionowego boku prostokata.
     */
    Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.srodek = new Punkt();
    }

    /**
     * Konstruktor przyjmujacy długosc, szerokosc i polozenie srodka prostokata.
     * 
     * @param dlugosc   długosc poziomego boku prostokata.
     * @param szerokosc długosc pionowego boku prostokata.
     * @param srodek    obiekt typu Punkt bedacy srodekiem prostokata.
     */
    Prostokat(double dlugosc, double szerokosc, Punkt srodek) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.srodek = srodek;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy Prostokat.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy Prostokat.
     */
    public String toString() {
        return "[dlugosc: " + dlugosc + ", szerokosc: " + szerokosc + ", srodek: " + srodek + "]";
    }

    /**
     * Zwraca pole prostokata.
     * 
     * @return pole prostokata.
     */
    public double pole() {
        return dlugosc * szerokosc;
    }

    /**
     * Zwraca obwod prostokata.
     * 
     * @return obwod prostokata.
     */
    public double obwod() {
        return 2 * dlugosc + 2 * szerokosc;
    }

    /**
     * Translacja polozenia prostokata na plaszczyznie na podstawie wzglednych
     * wartosci wektora przesuniecia.
     * 
     * @param u wzgledne przesuniecie wzdluz osi x.
     * @param v wzgledne przesuniecie wzdluz osi y.
     */
    public void przesun(double u, double v) {
        srodek.przesun(u, v);
    }

    /**
     * Okresla czy podany punkt znajduje sie wewnatrz prostokata.
     * 
     * @param obj obiekt klasy Punkt.
     * @return true jezeli Punkt obj znajduje sie wewnatrz lub na granicy
     *         prostokata.
     */
    public boolean zawiera(Punkt obj) {
        return (obj.x <= srodek.x + 0.5 * dlugosc && obj.x >= srodek.x - 0.5 * dlugosc)
                && (obj.y <= srodek.y + 0.5 * szerokosc && obj.x >= srodek.y - 0.5 * szerokosc);
    }

    /**
     * Okresla czy kontur podanego okregu przecina lub naklada sie z konturem
     * prostokata.
     * 
     * @param obj obiekt klasy Okrag.
     * @return true jezeli zarys obiektu Okrag obj przecina lub naklada sie ze
     *         zarysem prostokata.
     */
    public boolean przecina(Okrag obj) {
        // Boki Prostokata
        boolean pionowy_lewy;
        pionowy_lewy = (obj.srodek.x + obj.promien >= srodek.x - 0.5 * dlugosc &&
                        obj.srodek.x - obj.promien <= srodek.x - 0.5 * dlugosc &&
                        obj.srodek.y + obj.promien >= srodek.y - 0.5 * szerokosc &&
                        obj.srodek.y - obj.promien <= srodek.y + 0.5 * szerokosc);
        boolean pionowy_prawy;
        pionowy_prawy = (obj.srodek.x + obj.promien >= srodek.x + 0.5 * dlugosc &&
                         obj.srodek.x - obj.promien <= srodek.x + 0.5 * dlugosc &&
                         obj.srodek.y + obj.promien >= srodek.y - 0.5 * szerokosc &&
                         obj.srodek.y - obj.promien <= srodek.y + 0.5 * szerokosc);
        boolean poziomy_dolny;
        poziomy_dolny = (obj.srodek.y + obj.promien >= srodek.y - 0.5 * szerokosc &&
                         obj.srodek.y - obj.promien <= srodek.y - 0.5 * szerokosc &&
                         obj.srodek.x + obj.promien >= srodek.x - 0.5 * dlugosc &&
                         obj.srodek.x - obj.promien <= srodek.x + 0.5 * dlugosc);
        boolean poziomy_gorny;
        poziomy_gorny = (obj.srodek.y + obj.promien >= srodek.y + 0.5 * szerokosc &&
                         obj.srodek.y - obj.promien <= srodek.y + 0.5 * szerokosc &&
                         obj.srodek.x + obj.promien >= srodek.x - 0.5 * dlugosc &&
                         obj.srodek.x - obj.promien <= srodek.x + 0.5 * dlugosc);
        return pionowy_lewy || pionowy_prawy || poziomy_dolny || poziomy_gorny;
    }
}
