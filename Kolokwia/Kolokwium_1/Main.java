public class Main {
    public static void main(String[] args) {

        // Test 3 metod inicjalizacji obiektu typu Macierz_3x3

        int[][] macierz_m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] macierz_m3 = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}, {7.7, 8.8, 9.9}};

        Macierz_3x3 m1 = new Macierz_3x3();
        Macierz_3x3 m2 = new Macierz_3x3(macierz_m2);
        Macierz_3x3 m3 = new Macierz_3x3(macierz_m3);

        System.out.println("----------------------------------------------");

        // Test reprezentacji tekstowej obietu Macierz_3x3

        System.out.println("Macierz m1: "+m1);
        System.out.println("Macierz m2: "+m2);
        System.out.println("Macierz m3: "+m3);

        System.out.println("----------------------------------------------");

        // Test metody transponowana()

        System.out.println("Macierz transponowana m1: "+m1.transponowana());
        System.out.println("Macierz transponowana m2: "+m2.transponowana());
        System.out.println("Macierz transponowana m3: "+m3.transponowana());

        System.out.println("----------------------------------------------");

        // Test metod obsługujących podstawowe operacje na macierzach: plus(), minus(), razy()

        System.out.println("m2 + m2.T: "+m2.plus(m2.transponowana()));
        System.out.println("m2 - m2.T: "+m2.minus(m2.transponowana()));
        System.out.println("m2 * 2   : "+m2.razy(2));
        System.out.println("m2 * 2.5 : "+m2.razy(2.5));
        System.out.println("m2 * m2.T: "+m2.razy(m2.transponowana()));

        System.out.println("----------------------------------------------");

        // Test metody wyznacznik()

        System.out.println("Wyznacznik macierzy m1: "+m1.wyznacznik());
        System.out.println("Wyznacznik macierzy m2: "+m2.wyznacznik());
        // Błąd spowodowany dokładnością - wynik miał być równy 0
        System.out.println("Wyznacznik macierzy m3: "+m3.wyznacznik());

    }
}