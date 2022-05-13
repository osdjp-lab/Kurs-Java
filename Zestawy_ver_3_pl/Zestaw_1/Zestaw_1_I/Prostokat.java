/**
 * Zawiera parametry opisujace prostokat w przestrzeni 2-wymiarowej.
 * 
 * @author Oscar Szumiak
 */
class Prostokat {
    double dlugosc;
    double szerokosc;

    /**
     * Konstruktor domyslny nie przyjmujacy argumentow inicjalizacyjnych.
     */
    Prostokat() {
        this.dlugosc = 0.0;
        this.szerokosc = 0.0;
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
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy Prostokat.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy Prostokat.
     */
    public String toString() {
        return "[dlugosc: " + dlugosc + ", szerokosc: " + szerokosc + "]";
    }

    /**
     * Zwraca pole prostokata.
     * 
     * @return pole prostokata.
     */
    double pole() {
        return dlugosc * szerokosc;
    }

    /**
     * Zwraca obwod prostokata.
     * 
     * @return obwod prostokata.
     */
    double obwod() {
        return 2 * dlugosc + 2 * szerokosc;
    }
}
