/**
 * Zawiera parametry opisujące punkt w przestrzeni 2-wymiarowej.
 * @param x współrzędna x.
 * @param y współrzędna y.
 */
public class Punkt {
    double x;
    double y;

    /**
     * Konstruktor domyślny nie przyjmujący argumentów inicjalizacyjnych.
     */
    Punkt()
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Konstruktor przyjmujący współrzędne x i y jako parametry inicjalizacyjne.
     * @param x współrzędna x.
     * @param y współrzędna y.
     */
    Punkt(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy Punkt.
     * @return ciąg znaków zawierający informacje o obiekcie klasy Punkt.
     */
    public String toString()
    {
        return "[x: "+x+", y: "+y+"]";
    }

    /**
     * Translacja punktu na płaszczyźnie na podstawie względnych wartości wektora przesunięcia.
     * @param dx względne przesunięcie wzdłuż osi x.
     * @param dy względne przesunięcie wzdłuż osi y.
     */
    public void przesun(double dx, double dy)
    {
        x += dx;
        y += dy;
    }
}
