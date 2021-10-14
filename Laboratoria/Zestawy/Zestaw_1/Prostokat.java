/**
 * Zawiera parametry opisujące prostokąt w przestrzeni 2-wymiarowej.
 * @param dlugosc długość poziomego boku prostokąta.
 * @param szerokosc długość pionowego boku prostokąta.
 * @param srodek obiekt typu Punkt będący środekiem prostokąta.
 */
class Prostokat
{
    double dlugosc;
    double szerokosc;
    Punkt srodek;

    /**
     * Konstruktor domyślny nie przyjmujący argumentów inicjalizacyjnych.
     */
    Prostokat()
    {
        this.dlugosc = 0.0;
        this.szerokosc = 0.0;
        this.srodek = new Punkt();
    }

    /**
     * Konstruktor przyjmujący długość i szerokość prostokąta jako parametry inicjalizacyjne.
     * @param dlugosc długość poziomego boku prostokąta.
     * @param szerokosc długość pionowego boku prostokąta.
     */
    Prostokat(double dlugosc, double szerokosc)
    {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.srodek = new Punkt();
    }

    /**
     * Konstruktor przyjmujący długość, szerokość i położenie środka prostokąta.
     * @param dlugosc długość poziomego boku prostokąta.
     * @param szerokosc długość pionowego boku prostokąta.
     * @param srodek obiekt typu Punkt będący środekiem prostokąta.
     */
    Prostokat(double dlugosc, double szerokosc, Punkt srodek)
    {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.srodek = srodek;
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy Prostokat.
     * @return ciąg znaków zawierający informacje o obiekcie klasy Prostokat.
     */
    public String toString()
    {
        return "[dlugosc: "+dlugosc+", szerokosc: "+szerokosc+", srodek: "+srodek+"]";
    }

    /**
     * Zwraca pole prostokąta.
     * @return pole prostokąta.
     */
    double pole()
    {
        return dlugosc * szerokosc;
    }

    /**
     * Zwraca obwód prostokąta.
     * @return obwód prostokąta.
     */
    double obwod()
    {
        return 2*dlugosc + 2*szerokosc;
    }

    /**
     * Określa czy podany punkt znajduje się wewnątrz prostokąta.
     * @param obj obiekt klasy Punkt.
     * @return true jeżeli Punkt obj znajduje się wewnątrz lub na granicy prostokąta.
     */
    boolean zawiera(Punkt obj)
    {
        return (obj.x <= srodek.x + 0.5*dlugosc && obj.x >= srodek.x - 0.5*dlugosc) && (obj.y <= srodek.y + 0.5*szerokosc && obj.x >= srodek.y - 0.5*szerokosc);
    }

    /**
     * Określa czy kontur podanego okręgu przecina lub nakłada się z konturem prostokąta.
     * @param obj obiekt klasy Okrag.
     * @return true jeżeli zarys obiektu Okrag obj przecina lub nakłada się ze zarysem prostokąta.
     */
    boolean przecina(Okrag obj)
    {
        // Boki Prostokata
        boolean pionowy_lewy;
        pionowy_lewy = (obj.srodek.x + obj.promien >= srodek.x - 0.5*dlugosc &&
                        obj.srodek.x - obj.promien <= srodek.x - 0.5*dlugosc &&
                        obj.srodek.y + obj.promien >= srodek.y - 0.5*szerokosc &&
                        obj.srodek.y - obj.promien <= srodek.y + 0.5*szerokosc);
        boolean pionowy_prawy;
        pionowy_prawy = (obj.srodek.x + obj.promien >= srodek.x + 0.5*dlugosc &&
                         obj.srodek.x - obj.promien <= srodek.x + 0.5*dlugosc &&
                         obj.srodek.y + obj.promien >= srodek.y - 0.5*szerokosc &&
                         obj.srodek.y - obj.promien <= srodek.y + 0.5*szerokosc);
        boolean poziomy_dolny;
        poziomy_dolny = (obj.srodek.y + obj.promien >= srodek.y - 0.5*szerokosc &&
                       obj.srodek.y - obj.promien <= srodek.y - 0.5*szerokosc &&
                       obj.srodek.x + obj.promien >= srodek.x - 0.5*dlugosc &&
                       obj.srodek.x - obj.promien <= srodek.x + 0.5*dlugosc);
        boolean poziomy_gorny;
        poziomy_gorny = (obj.srodek.y + obj.promien >= srodek.y + 0.5*szerokosc &&
                        obj.srodek.y - obj.promien <= srodek.y + 0.5*szerokosc &&
                        obj.srodek.x + obj.promien >= srodek.x - 0.5*dlugosc &&
                        obj.srodek.x - obj.promien <= srodek.x + 0.5*dlugosc);
        return pionowy_lewy || pionowy_prawy || poziomy_dolny || poziomy_gorny;
    }
}
