package Laboratoria.Zestawy.Zestaw_2;

/**
 * Zawiera parametry opisujące wektor w przestrzeni 3-wymiarowej.
 * @param x współrzędna x wektora.
 * @param y współrzędna y wektora.
 * @param z współrzędna z wektora.
 */
public class Wektor
{
    double x;
    double y;
    double z;

    Wektor()
    {
    this.x = 0.0;        
    this.y = 0.0;
    this.z = 0.0;
    }

    Wektor(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Zwraca iloczyn skalarny podanego wektora i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor IloczynSkalarny(Wektor obj) {
        return new Wektor();
    }

    /**
     * Zwraca iloczyn wektorowy podanego wektora i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor IloczynWektorowy(Wektor obj) {
        return new Wektor();
    }
}
