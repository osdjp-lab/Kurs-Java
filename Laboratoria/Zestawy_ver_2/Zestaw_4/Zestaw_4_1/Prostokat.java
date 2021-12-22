package Zestaw_4_1;

import java.awt.Point;
import java.awt.Rectangle;

class Prostokat extends Rectangle {

    // Konstruktory nie są dziedziczone

    /**
     * Konstruktor przyjmujący jedynie położenie wierzchołka.
     * 
     * @param a współrzędna x wierzchołka
     * @param b współrzędna y wierzchołka
     */
    Prostokat(int a, int b) {
        // super - odwołanie do obiektu klasy
        // nadrzędnej Rectangle
        super(a, b);
    }

    /**
     * Konstruktor przyjmujący położenie wierzchołka w postaci obiektu klasy Point
     * jak i długość i szerokość Prostokąta
     * 
     * @param wierzcholek wierzchołek Prostokąta - obiekt klasy Point
     * @param dlugosc     długość Prostokąta
     * @param szerokosc   szerokość Prostokąta
     */
    Prostokat(Point wierzcholek, int dlugosc, int szerokosc) {
        super(wierzcholek.x, wierzcholek.y, dlugosc, szerokosc);
    }

    void info() {
        System.out.println(this);
    }

    // przystawanie a przyleganie

    /**
     * Sprawdza czy prostokąt przylega do innego prostokąta.
     * @param other inny obiekt klasy Prostokąt
     * @return
     */
    boolean przylega(Prostokat other) {
        Rectangle rect = this.intersection(other);
        if (rect.width == 0 || rect.height == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
