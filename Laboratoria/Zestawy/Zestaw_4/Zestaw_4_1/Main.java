package Zestaw_4_1;

import java.awt.Point;

public class Main {
    public static void main(String[] args) {

        // Utworzenie obiektów klasy Prostokąt a i b
        // Wypisanie informacji o obiektach klasy Prostokąt
        // poprzez metodę info zaimplementowaną w klasie
        // Prostokąt

        Prostokat a = new Prostokat(3, 4);
        a.info();

        Prostokat b = new Prostokat(2, 2);
        b.info();

        // Test czy przecina się Prostokąt a z Prostokątem b
        // Metoda intersects odziedziczona po klasie Rectangle

        if (a.intersects(b)) {
            System.out.println("-- przecinaja sie --\n");
        } else {
            System.out.println("-- NIE przecinaja sie --\n");
        }

        // Przesunięcie Prostokątu a o wektor (5, 3)
        // Metoda translate odziedziczona po klasie Rectangle

        a.translate(5, 3);
        a.info();

        if (a.intersects(b)) {
            System.out.println("-- przecinaja sie --\n");
        } else {
            System.out.println("-- NIE przecinaja sie --\n");
        }

        // Test konstruktora z punktu 4.2

        Prostokat c = new Prostokat(new Point(2, 5), 2, 5);
        c.info();

        Prostokat d = new Prostokat(new Point(1, 3), 2, 2);
        d.info();

        // Test przylegania Prostokątów

        System.out.println(c.intersection(d));

    }
}
