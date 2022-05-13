/**
 * Opisuje liczbe zespolona.
 * 
 * @author Oscar Szumiak
 */
public class LiczbaZespolona {
    double real;
    double img;

    /**
     * Konstruktor domyslny.
     */
    LiczbaZespolona() {
        this.real = 0.0;
        this.img = 0.0;
    }

    /**
     * Konstruktor przyjmujacy wartosci czesci rzeczywistej i urojonej.
     * 
     * @param real czesc rzeczywista liczby zespolonej.
     * @param img  czesc urojona liczby zespolonej.
     */
    LiczbaZespolona(double real, double img) {
        this.real = real;
        this.img = img;
    }

    /**
     * Zwraca reprezentacje tekstowa obiektu klasy LiczbaZespolona.
     * 
     * @return ciag znakow zawierajacy informacje o obiekcie klasy LiczbaZespolona.
     */
    public String toString() {
        return "[real: " + real + ", img: " + img + "]";
    }

    /**
     * Zwraca sume liczb zespolonych.
     * 
     * @param obj obiekt klasy LiczbaZespolona
     * @return obiekt klasy LiczbaZespolona.
     */
    public LiczbaZespolona plus(LiczbaZespolona obj) {
        return new LiczbaZespolona(real + obj.real, img + obj.img);
    }

    /**
     * Zwraca roznice liczb zespolonych.
     * 
     * @param obj obiekt klasy LiczbaZespolona
     * @return obiekt klasy LiczbaZespolona.
     */
    public LiczbaZespolona minus(LiczbaZespolona obj) {
        return new LiczbaZespolona(real - obj.real, img - obj.img);
    }

    /**
     * Zwraca iloczyn liczb zespolonych.
     * 
     * @param obj obiekt klasy LiczbaZespolona
     * @return obiekt klasy LiczbaZespolona.
     */
    public LiczbaZespolona razy(LiczbaZespolona obj) {
        return new LiczbaZespolona(real * obj.real - img * obj.img, real * obj.img + obj.real * img);
    }

    /**
     * Zwraca iloraz liczb zespolonych.
     * 
     * @param obj obiekt klasy LiczbaZespolona
     * @return obiekt klasy LiczbaZespolona.
     */
    public LiczbaZespolona dziel(LiczbaZespolona obj) {
        return new LiczbaZespolona((real * obj.real + img * obj.img) / (Math.pow(obj.real, 2) + Math.pow(obj.img, 2)),
                (img * obj.real - real * obj.img) / (Math.pow(obj.real, 2) + Math.pow(obj.img, 2)));
    }
}
