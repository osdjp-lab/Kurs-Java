/**
 * Zawiera parametry opisujace punkt w przestrzeni 2-wymiarowej.
 * 
 * @author Oscar Szumiak
 */
public class Punkt {
    double x;
    double y;

    /**
     * Konstruktor domyslny nie przyjmujacy argumentow inicjalizacyjnych.
     */
    Punkt() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Konstruktor przyjmujacy wspolrzedne x i y jako parametry inicjalizacyjne.
     * 
     * @param x wspolrzedna x.
     * @param y wspolrzedna y.
     */
    Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy Punkt.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy Punkt.
     */
    public String toString() {
        return "[x: " + x + ", y: " + y + "]";
    }

    /**
     * Translacja punktu na plaszczyznie na podstawie wzglednych wartosci wektora
     * przesuniecia.
     * 
     * @param dx wzgledne przesuniecie wzdluz osi x.
     * @param dy wzgledne przesuniecie wzdluz osi y.
     */
    public void przesun(double dx, double dy) {
        x += dx;
        y += dy;
    }
}
