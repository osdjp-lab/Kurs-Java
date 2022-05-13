/**
 * Zawiera parametry opisujace okrag w przestrzeni 2-wymiarowej.
 * 
 * @author Oscar Szumiak
 */
public class Okrag {
    double promien;
    Punkt srodek;

    /**
     * Konstruktor domyslny nie przyjmujacy argumentow inicjalizacyjnych.
     */
    Okrag() {
        this.promien = 0.0;
        this.srodek = new Punkt();
    }

    /**
     * Konstruktor przyjmujacy promien i srodek jako parametry inicjalizacyjne.
     * 
     * @param promien promien okregu.
     * @param srodek  obiekt typu Punkt bedacy srodekiem okregu.
     */
    Okrag(double promien, Punkt srodek) {
        this.promien = promien;
        this.srodek = srodek;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy Okrag.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy Okrag.
     */
    public String toString() {
        return "[promien: " + promien + ", srodek: " + srodek + "]";
    }

    /**
     * Zwraca pole okregu.
     * 
     * @return pole okregu.
     */
    public double pole() {
        return Math.PI * Math.pow(promien, 2);
    }

    /**
     * Zwraca obwod okregu.
     * 
     * @return obwod okregu.
     */
    public double obwod() {
        return 2 * Math.PI * promien;
    }

    /**
     * Okresla czy podany punkt znajduje siw wewnatrz okregu.
     * 
     * @param obj obiekt klasy Punkt.
     * @return true jezeli Punkt obj znajduje sie wewnatrz lub na granicy okregu.
     */
    public boolean zawiera(Punkt obj) {
        return Math.sqrt(Math.pow((obj.x - srodek.x), 2.0) + Math.pow((obj.y - srodek.y), 2)) <= promien;
    }

    /**
     * Okresla czy kontur podanego okregu przecina lub naklada sie z konturem okregu
     * ktorego metoda jest wywolywana.
     * 
     * @param obj obiekt klasy Okrag.
     * @return true jezeli zarys obiektu Okrag obj przecina lub naklada sie ze
     *         zarysem okregu ktorego metoda jest wywolywana.
     */
    public boolean przecina(Okrag obj) {
        double odl_srodkow;
        odl_srodkow = Math.sqrt(Math.pow((obj.srodek.x - srodek.x), 2) + Math.pow((obj.srodek.y - srodek.y), 2));
        return odl_srodkow <= obj.promien + promien && odl_srodkow >= Math.abs(obj.promien - promien);
    }
}
