/**
 * Zawiera parametry opisujące macierz 3x3.
 * @param macierz 2-wymiarowa tablica o rozmiarze 3x3 zawierająca elementy macierzy.
 */
public class Macierz_3x3 {
    double[][] macierz;

    /**
     * Konstruktor domyślny nie przyjmujący argumentów inicjalizacyjnych.
     */
    Macierz_3x3() {
        this.macierz = new double[3][3];
    }

    /**
     * Konstruktor przyjmujący 2-wymiarową tablicę inicjalizacjyną typu int.
     * W przypadku błędnego rozmiaru podanej tablicy macierz 3x3 jest inicjalizowana jako pusta.
     * @param macierz 2-wymiarowa tablica inicjalizacyjna typu int.
     */
    Macierz_3x3(int[][] macierz) {
        this.macierz = new double[3][3];
        if (macierz.length == 3 &&
            macierz[0].length == 3 &&
            macierz[1].length == 3 &&
            macierz[2].length == 3) {
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    this.macierz[i][j] = (double) macierz[i][j];
                }
            }
        }
        else {
            System.out.println("Podana macierz nie jest rozmiaru 3x3, zainicjalizowano pustą macierz.");
        }
    }

    /**
     * Konstruktor przyjmujący 2-wymiarową tablicę inicjalizacjyną typu double.
     * W przypadku błędnego rozmiaru podanej tablicy macierz 3x3 jest inicjalizowana jako pusta.
     * @param macierz 2-wymiarowa tablica inicjalizacyjna typu double.
     */
    Macierz_3x3(double[][] macierz) {
        if (macierz.length == 3 &&
            macierz[0].length == 3 &&
            macierz[1].length == 3 &&
            macierz[2].length == 3) {
            this.macierz = macierz;
        }
        else {
            this.macierz = new double[3][3];
            System.out.println("Podana macierz nie jest rozmiaru 3x3, zainicjalizowano pustą macierz.");
        }
    }

    /**
     * Reprezentacja tekstowa obiektu klasy Macierz_3x3.
     * @return ciąg znaków zawierający informacje o obiekcie klasy Macierz_3x3.
     */
    public String toString() {
        return "[["+macierz[0][0]+", "+macierz[0][1]+", "+macierz[0][2]+"], ["+macierz[1][0]+", "+macierz[1][1]+", "+macierz[1][2]+"], ["+macierz[2][0]+", "+macierz[2][1]+", "+macierz[2][2]+"]]";
    }

    /**
     * Macierz transponowana obiektu Macierz_3x3.
     * @return macierz transponowana obiektu Macierz_3x3.
     */
    Macierz_3x3 transponowana() {
        Macierz_3x3 macierz_transponowana = new Macierz_3x3();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                macierz_transponowana.macierz[i][j] = macierz[j][i];
            }
        }
        return macierz_transponowana;
    }

    /**
     * Suma macierzy obiektu Macierz_3x3 wywołującej metodę i obiektu other.
     * @param other macierz sumowana z macierzą wywołującą metodę.
     * @return macierz wyjściowa sumy macierzy.
     */
    Macierz_3x3 plus(Macierz_3x3 other) {
        Macierz_3x3 macierz_wyjsciowa = new Macierz_3x3();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] + other.macierz[i][j];
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Różnica macierzy obiektu Macierz_3x3 wywołującej metodę i obiektu other.
     * @param other macierz odejmowana od macierzy wywołującej metodę.
     * @return macierz wyjściowa różnicy macierzy.
     */
    Macierz_3x3 minus(Macierz_3x3 other) {
        Macierz_3x3 macierz_wyjsciowa = new Macierz_3x3();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] - other.macierz[i][j];
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Iloczyn macierzy i stałej typu int.
     * @param n stała przez którą mnożona jest macierz.
     * @return macierz wyjściowa iloczynu.
     */
    Macierz_3x3 razy(int n) {
        Macierz_3x3 macierz_wyjsciowa = new Macierz_3x3();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] * n;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Iloczyn macierzy i stałej typu double.
     * @param n stała przez którą mnożona jest macierz.
     * @return macierz wyjściowa iloczynu.
     */
    Macierz_3x3 razy(double n) {
        Macierz_3x3 macierz_wyjsciowa = new Macierz_3x3();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] * n;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Iloczyn macierzy.
     * @param other macierz mnożona przez macierz obiektu wywołującego metodę.
     * @return macierz wyjściowa iloczynu macierzy.
     */
    Macierz_3x3 razy(Macierz_3x3 other) {
        Macierz_3x3 macierz_wyjsciowa = new Macierz_3x3();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                double suma = 0;
                for (int k=0; k<3; k++) {
                    suma += macierz[i][k] * other.macierz[k][j];
                }
                macierz_wyjsciowa.macierz[i][j] = suma;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Wyznacznik macierzy.
     * @return wyznacznik macierzy.
     */
    double wyznacznik() {
        double wyznacznik = macierz[0][0]*(macierz[1][1] * macierz[2][2] - macierz[1][2] * macierz[2][1]) + macierz[0][1]*(macierz[1][2] * macierz[2][0] - macierz[1][0] * macierz[2][2]) + macierz[0][2]*(macierz[1][0] * macierz[2][1] - macierz[1][1] * macierz[2][0]);
        return wyznacznik;
    }
}
