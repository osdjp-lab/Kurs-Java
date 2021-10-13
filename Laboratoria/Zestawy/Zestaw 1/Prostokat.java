class Prostokat
{
    double dlugosc;
    double szerokosc;
    Punkt srodek;

    Prostokat()
    {
        this.dlugosc = 0.0;
        this.szerokosc = 0.0;
        this.srodek = new Punkt();
    }

    Prostokat(double dlugosc, double szerokosc)
    {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.srodek = new Punkt();
    }

    Prostokat(double dlugosc, double szerokosc, Punkt srodek)
    {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.srodek = srodek;
    }

    public String toString()
    {
        return "[dlugosc: "+dlugosc+", szerokosc: "+szerokosc+", srodek: "+srodek+"]";
    }

    double pole()
    {
        return dlugosc * szerokosc;
    }

    double obwod()
    {
        return 2*dlugosc + 2*szerokosc;
    }

    boolean zawiera(Punkt obj)
    {
        return (obj.x <= srodek.x + 0.5*dlugosc && obj.x >= srodek.x - 0.5*dlugosc) && (obj.y <= srodek.y + 0.5*szerokosc && obj.x >= srodek.y - 0.5*szerokosc);
    }

    boolean przecina(Okrag obj)
    {
        // Strony Prostokata
        // Do przeanalizowania logika
        boolean poziomy_lewy;
        poziomy_lewy = (obj.srodek.x + obj.promien >= srodek.x - 0.5*dlugosc &&
                        obj.srodek.x - obj.promien <= srodek.x - 0.5*dlugosc &&
                        obj.srodek.y + obj.promien >= srodek.y - 0.5*szerokosc &&
                        obj.srodek.y - obj.promien <= srodek.y + 0.5*szerokosc);
        boolean poziomy_prawy;
        poziomy_prawy = (obj.srodek.x + obj.promien >= srodek.x + 0.5*dlugosc &&
                         obj.srodek.x - obj.promien <= srodek.x + 0.5*dlugosc &&
                         obj.srodek.y + obj.promien >= srodek.y - 0.5*szerokosc &&
                         obj.srodek.y - obj.promien <= srodek.y + 0.5*szerokosc);
        boolean pionowy_dol;
        pionowy_dol = (obj.srodek.y + obj.promien >= srodek.y - 0.5*szerokosc &&
                       obj.srodek.y - obj.promien <= srodek.y - 0.5*szerokosc &&
                       obj.srodek.x + obj.promien >= srodek.x - 0.5*dlugosc &&
                       obj.srodek.x - obj.promien <= srodek.x + 0.5*dlugosc);
        boolean pionowy_gora;
        pionowy_gora = (obj.srodek.y + obj.promien >= srodek.y + 0.5*szerokosc &&
                        obj.srodek.y - obj.promien <= srodek.y + 0.5*szerokosc &&
                        obj.srodek.x + obj.promien >= srodek.x - 0.5*dlugosc &&
                        obj.srodek.x - obj.promien <= srodek.x + 0.5*dlugosc);
        return poziomy_lewy || poziomy_prawy || pionowy_dol || pionowy_gora;
    }
}