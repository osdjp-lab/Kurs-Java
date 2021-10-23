package Laboratoria.Zestawy.Zestaw_2;

/**
 * Zawiera parametry opisujące liczbę zespoloną.
 * @param real część rzeczywista liczby zespolonej.
 * @param img część urojona liczby zespolonej.
 */
public class LiczbaZespolona
{
    double real;
    double img;

    LiczbaZespolona()
    {
        this.real = 0.0;
        this.img = 0.0;
    }

    LiczbaZespolona(double real, double img)
    {
        this.real = real;
        this.img = img;
    }

    /**
     * Zwraca reprezentację tekstową obiektu klasy LiczbaZespolona.
     * @return ciąg znaków zawierający informacje o obiekcie klasy LiczbaZespolona.
     */
    public String toString() {
        return "[real: "+real+", img: "+img+"]";
    }

    /**
     * Realizuje operację dodawania liczb zespolonych.
     * @return obiekt typu LiczbaZespolona.
     */
    LiczbaZespolona plus(LiczbaZespolona obj) {
        return new LiczbaZespolona(real+obj.real, img+obj.img);
    }

    /**
     * Realizuje operację odejmowania liczb zespolonych.
     * @return obiekt typu LiczbaZespolona.
     */
    LiczbaZespolona minus(LiczbaZespolona obj) {
        return new LiczbaZespolona(real-obj.real, img-obj.img);
    }

    /**
     * Realizuje operację mnożenia liczb zespolonych.
     * @return obiekt typu LiczbaZespolona.
     */
    LiczbaZespolona razy(LiczbaZespolona obj) {
        return new LiczbaZespolona(real*obj.real - img*obj.img, real*obj.img + obj.real*img);
    }

    /**
     * Realizuje operację dzielenia liczb zespolonych.
     * @return obiekt typu LiczbaZespolona.
     */
    LiczbaZespolona dziel(LiczbaZespolona obj) {
        return new LiczbaZespolona(real*obj.real - img*obj.img, real*obj.img + obj.real*img);
    }

}
