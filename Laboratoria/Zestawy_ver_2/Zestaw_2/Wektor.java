package Laboratoria.Zestawy.Zestaw_2;

/**
 * Zawiera parametry opisujące wektor w przestrzeni 3-wymiarowej.
 * @param x współrzędna x wektora.
 * @param y współrzędna y wektora.
 * @param z współrzędna z wektora.
 */
public class Wektor {
    double x;
    double y;
    double z;

    Wektor() {
        this.x = 0.0;        
        this.y = 0.0;
        this.z = 0.0;
    }

    Wektor(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy Wektor.
     * @return ciąg znaków zawierający informacje o obiekcie klasy Wektor.
     */
    public String toString() {
        return "[x: "+x+", y: "+y+", z: "+z+"]";
    }

    /**
     * Zwraca sumę podanego wektora i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor plus(Wektor obj) {
        return new Wektor(x + obj.x, y + obj.y, z + obj.z);
    }

    /**
     * Zwraca różnicę podanego wektora i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor minus(Wektor obj) {
        return new Wektor(x - obj.x, y - obj.y, z - obj.z);
    }

    /**
     * Zwraca iloczyn podanej liczby typu int i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor razy(int n) {
        return new Wektor(n*x, n*y, n*z);
    }

    /**
     * Zwraca iloczyn podanej liczby typu double i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor razy(double n) {
        return new Wektor(n*x, n*y, n*z);
    }

    /**
     * Zwraca iloczyn skalarny podanego wektora i wektora którego metoda jest wywoływana.
     * @return obiekt typu double reprezentujący wartość liczbową iloczynu skalarnego.
     */
    double IloczynSkalarny(Wektor obj) {
        return x*obj.x + y*obj.y + z*obj.z;
    }

    /**
     * Zwraca iloczyn wektorowy podanego wektora i wektora którego metoda jest wywoływana.
     * @return obiekt typu Wektor.
     */
    Wektor IloczynWektorowy(Wektor obj) {
        return new Wektor(y*obj.z - z*obj.y, z*obj.x - x*obj.z, x*obj.y - y*obj.x);
    }
}
