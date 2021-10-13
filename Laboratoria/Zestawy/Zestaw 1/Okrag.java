public class Okrag
{
    double promien;
    Punkt srodek;

    Okrag()
    {
        this.promien = 0.0;
        this.srodek = new Punkt();
    }

    Okrag(double promien, Punkt srodek)
    {
        this.promien = promien;
        this.srodek = srodek;
    }

    public String toString()
    {
        return "[promien: "+promien+", srodek: "+srodek+"]";
    }

    boolean zawiera(Punkt obj)
    {
        return Math.sqrt(Math.pow((obj.x - srodek.x), 2.0) + Math.pow((obj.y - srodek.y), 2)) <= promien;
    }

    boolean przecina(Okrag obj)
    {
        double odl_srodkow;
        odl_srodkow = Math.sqrt(Math.pow((obj.srodek.x - srodek.x), 2) + Math.pow((obj.srodek.y - srodek.y), 2));
        return odl_srodkow <= obj.promien + promien && odl_srodkow >= Math.abs(obj.promien - promien);
    }
}
