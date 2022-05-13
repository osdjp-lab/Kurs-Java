/**
 * Opisuje wektor w przestrzeni 3-wymiarowej.
 * 
 * @author Oscar Szumiak
 */
public class Wektor {
    double x;
    double y;
    double z;

    /**
     * Konstruktor domyslny.
     */
    Wektor() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    /**
     * Konstruktor przyjmujacy wspolrzedne konca wektora w przestrzeni 3-wymiarowej.
     * 
     * @param x wspolrzedna x wektora.
     * @param y wspolrzedna y wektora.
     * @param z wspolrzedna z wektora.
     */
    Wektor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy Wektor.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy Wektor.
     */
    public String toString() {
        return "[x: " + x + ", y: " + y + ", z: " + z + "]";
    }

    /**
     * Zwraca sume wektorow.
     * 
     * @param obj obiekt klasy Wektor.
     * @return obiekt klasy Wektor.
     */
    public Wektor plus(Wektor obj) {
        return new Wektor(x + obj.x, y + obj.y, z + obj.z);
    }

    /**
     * Zwraca roznice wektorow.
     * 
     * @param obj obiekt klasy Wektor.
     * @return obiekt klasy Wektor.
     */
    public Wektor minus(Wektor obj) {
        return new Wektor(x - obj.x, y - obj.y, z - obj.z);
    }

    /**
     * Zwraca iloczyn podanej liczby typu int i wektora.
     * 
     * @param n wartosc typu int przez ktora ma zostac pomnozony Wektor.
     * @return obiekt klasy Wektor.
     */
    public Wektor razy(int n) {
        return new Wektor(n * x, n * y, n * z);
    }

    /**
     * Zwraca iloczyn podanej liczby typu double i wektora.
     * 
     * @param n wartosc typu double przez ktora ma zostac pomnozony Wektor.
     * @return obiekt klasy Wektor.
     */
    public Wektor razy(double n) {
        return new Wektor(n * x, n * y, n * z);
    }

    /**
     * Zwraca iloczyn skalarny wektorow.
     * 
     * @param obj obiekt klasy Wektor.
     * @return obiekt typu double reprezentujacy wartosc liczbowa iloczynu
     *         skalarnego.
     */
    public double IloczynSkalarny(Wektor obj) {
        return x * obj.x + y * obj.y + z * obj.z;
    }

    /**
     * Zwraca iloczyn wektorowy wektorow.
     * 
     * @param obj obiekt klasy Wektor.
     * @return obiekt klasy Wektor.
     */
    public Wektor IloczynWektorowy(Wektor obj) {
        return new Wektor(y * obj.z - z * obj.y, z * obj.x - x * obj.z, x * obj.y - y * obj.x);
    }
}
