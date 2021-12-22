package Laboratoria.Zestawy.Zestaw_1;

/**
 * Zawiera parametry opisujące okrąg w przestrzeni 2-wymiarowej.
 * @param promien promień okręgu.
 * @param srodek obiekt typu Punkt będący środekiem okręgu.
 */
public class Okrag
{
    double promien;
    Punkt srodek;

    /**
     * Konstruktor domyślny nie przyjmujący argumentów inicjalizacyjnych.
     */
    Okrag()
    {
        this.promien = 0.0;
        this.srodek = new Punkt();
    }

    /**
     * Konstruktor przyjmujący promień i środek jako parametry inicjalizacyjne.
     * @param promien promień okręgu.
     * @param srodek obiekt typu Punkt będący środekiem okręgu.
     */
    Okrag(double promien, Punkt srodek)
    {
        this.promien = promien;
        this.srodek = srodek;
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy Okrag.
     * @return ciąg znaków zawierający informacje o obiekcie klasy Okrag.
     */
    public String toString()
    {
        return "[promien: "+promien+", srodek: "+srodek+"]";
    }

    /**
     * Zwraca pole okręgu.
     * @return pole okręgu.
     */
    double pole()
    {
        return Math.PI*Math.pow(promien, 2);
    }

    /**
     * Zwraca obwód okręgu.
     * @return obwód okręgu.
     */
    double obwod()
    {
        return 2*Math.PI*promien;
    }

    /**
     * Określa czy podany punkt znajduje się wewnątrz okręgu.
     * @param obj obiekt klasy Punkt.
     * @return true jeżeli Punkt obj znajduje się wewnątrz lub na granicy okręgu.
     */
    boolean zawiera(Punkt obj)
    {
        return Math.sqrt(Math.pow((obj.x - srodek.x), 2.0) + Math.pow((obj.y - srodek.y), 2)) <= promien;
    }

    /**
     * Określa czy kontur podanego okręgu przecina lub nakłada się z konturem okręgu którego metoda jest wywoływana.
     * @param obj obiekt klasy Okrag.
     * @return true jeżeli zarys obiektu Okrag obj przecina lub nakłada się ze zarysem okręgu którego metoda jest wywoływana.
     */
    boolean przecina(Okrag obj)
    {
        double odl_srodkow;
        odl_srodkow = Math.sqrt(Math.pow((obj.srodek.x - srodek.x), 2) + Math.pow((obj.srodek.y - srodek.y), 2));
        return odl_srodkow <= obj.promien + promien && odl_srodkow >= Math.abs(obj.promien - promien);
    }
}
