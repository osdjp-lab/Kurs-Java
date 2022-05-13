/**
 * Zawiera parametry opisujące macierz 3x3.
 * 
 * @author Oscar Szumiak
 */
public class Macierz {
    double[][] macierz;

    /**
     * Konstruktor domyślny.
     */
    Macierz() {
        this.macierz = new double[3][3];
    }

    /**
     * Konstruktor przyjmujący 2-wymiarową tablicę inicjalizacjyną typu int.
     * W przypadku błędnego rozmiaru podanej tablicy macierz 3x3 jest inicjalizowana
     * jako pusta.
     * 
     * @param macierz 2-wymiarowa tablica inicjalizacyjna typu int o rozmiarze 3x3
     *                zawierająca elementy macierzy.
     */
    Macierz(int[][] macierz) {
        this.macierz = new double[3][3];
        if (macierz.length == 3 &&
                macierz[0].length == 3 &&
                macierz[1].length == 3 &&
                macierz[2].length == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.macierz[i][j] = (double) macierz[i][j];
                }
            }
        } else {
            System.out.println("Podana macierz nie jest rozmiaru 3x3, zainicjalizowano pustą macierz.");
        }
    }

    /**
     * Konstruktor przyjmujący 2-wymiarową tablicę inicjalizacjyną typu double.
     * W przypadku błędnego rozmiaru podanej tablicy macierz 3x3 jest inicjalizowana
     * jako pusta.
     * 
     * @param macierz 2-wymiarowa tablica inicjalizacyjna typu double o rozmiarze
     *                3x3 zawierająca elementy macierzy.
     */
    Macierz(double[][] macierz) {
        if (macierz.length == 3 &&
                macierz[0].length == 3 &&
                macierz[1].length == 3 &&
                macierz[2].length == 3) {
            this.macierz = macierz;
        } else {
            this.macierz = new double[3][3];
            System.out.println("Podana macierz nie jest rozmiaru 3x3, zainicjalizowano pustą macierz.");
        }
    }

    /**
     * Reprezentacja tekstowa obiektu klasy Macierz.
     * 
     * @return ciąg znaków zawierający informacje o obiekcie klasy Macierz.
     */
    public String toString() {
        return "[[" + macierz[0][0] + ", " + macierz[0][1] + ", " + macierz[0][2] + "], [" + macierz[1][0] + ", "
                + macierz[1][1] + ", " + macierz[1][2] + "], [" + macierz[2][0] + ", " + macierz[2][1] + ", "
                + macierz[2][2] + "]]";
    }

    /**
     * Zwraca wyznacznik macierzy.
     * 
     * @return obiekt typu double.
     */
    public double wyznacznik() {
        double wyznacznik = macierz[0][0] * (macierz[1][1] * macierz[2][2] - macierz[1][2] * macierz[2][1])
                + macierz[0][1] * (macierz[1][2] * macierz[2][0] - macierz[1][0] * macierz[2][2])
                + macierz[0][2] * (macierz[1][0] * macierz[2][1] - macierz[1][1] * macierz[2][0]);
        return wyznacznik;
    }

    /**
     * Zwraca macierz transponowana obiektu Macierz.
     * 
     * @return obiekt klasy Macierz.
     */
    public Macierz transponowana() {
        Macierz macierz_transponowana = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_transponowana.macierz[i][j] = macierz[j][i];
            }
        }
        return macierz_transponowana;
    }

    /**
     * Zwraca macierz diagonalna.
     * https://yutsumura.com/how-to-diagonalize-a-matrix-step-by-step-explanation/
     * 
     * @return obiekt klasy Macierz.
     */
    public Macierz diagonalna() {
        Macierz macierz_diagonalna = new Macierz();
        return macierz_diagonalna;
    }

    /**
     * Zwraca macierz odwrotna.
     * W przypadku wyznacznika rownego zero macierz odwrotna nie istnieje.
     * Zwraca macierz wypełniona zerami.
     * 
     * @return obiekt klasy Macierz.
     */
    public Macierz odwrotna() {
        Macierz macierz_odwrotna;
        double wyznacznik = wyznacznik();
        if (wyznacznik == 0) {
            System.out.println("Dla wyznacznika rownego zero macierz odwrotna nie istnieje.");
            macierz_odwrotna = new Macierz();
        } else {
            double[][] dopełnienia = {{  macierz[2][2] * macierz[3][3] - macierz[2][3] * macierz[3][2],
                                       -(macierz[2][1] * macierz[3][3] - macierz[2][3] * macierz[3][1]),
                                         macierz[2][1] * macierz[3][2] - macierz[2][2] * macierz[3][1], },
                                      {-(macierz[1][2] * macierz[3][3] - macierz[1][3] * macierz[3][2]),
                                         macierz[1][1] * macierz[3][3] - macierz[1][3] * macierz[3][1],
                                       -(macierz[1][1] * macierz[3][3] - macierz[1][2] * macierz[3][1]),},
                                      {  macierz[1][2] * macierz[2][3] - macierz[1][3] * macierz[2][2],
                                       -(macierz[1][1] * macierz[2][3] - macierz[1][3] * macierz[2][1]),
                                         macierz[1][1] * macierz[2][2] - macierz[1][2] * macierz[2][1],}};
            Macierz macierz_dopelnien = new Macierz(dopełnienia);
            macierz_odwrotna = macierz_dopelnien.transponowana().dziel(wyznacznik);
        }
        return macierz_odwrotna;
    }

    /**
     * Zwraca sume macierzy.
     * 
     * @param other obiekt klasy Macierz.
     * @return obiekt klasy Macierz.
     */
    public Macierz plus(Macierz other) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] + other.macierz[i][j];
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Zwraca roznice macierzy.
     * 
     * @param other obiekt klasy Macierz.
     * @return obiekt klasy Macierz.
     */
    public Macierz minus(Macierz other) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] - other.macierz[i][j];
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Zwraca iloczyn macierzy i stałej typu int.
     * 
     * @param n wartosc typu int.
     * @return obiekt klasy Macierz.
     */
    public Macierz razy(int n) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] * n;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Zwraca iloczyn macierzy i stałej typu double.
     * 
     * @param n wartosc typu double
     * @return obiekt klasy Macierz.
     */
    public Macierz razy(double n) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] * n;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Zwraca iloczyn macierzy.
     * 
     * @param other obiekt klasy Macierz.
     * @return obiekt klasy Macierz
     */
    public Macierz razy(Macierz other) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double suma = 0;
                for (int k = 0; k < 3; k++) {
                    suma += macierz[i][k] * other.macierz[k][j];
                }
                macierz_wyjsciowa.macierz[i][j] = suma;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Zwraca iloraz macierzy i stałej typu int.
     * 
     * @param n wartosc typu int.
     * @return obiekt klasy Macierz.
     */
    public Macierz dziel(int n) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] / n;
            }
        }
        return macierz_wyjsciowa;
    }

    /**
     * Zwraca iloraz macierzy i stałej typu double.
     * 
     * @param n wartosc typu double
     * @return obiekt klasy Macierz.
     */
    public Macierz dziel(double n) {
        Macierz macierz_wyjsciowa = new Macierz();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                macierz_wyjsciowa.macierz[i][j] = macierz[i][j] / n;
            }
        }
        return macierz_wyjsciowa;
    }
}
