public class Program {
    public static void main(String[] args) {
        /**************************
         * Testowanie klasy Ulamek
         *************************/

        System.out.println("Testowanie klasy Ulamek");

        // Inicjalizacja obiektow

        Ulamek ul1, ul2;
        ul1 = new Ulamek(6, 8);
        ul2 = new Ulamek(3, 7);

        // Reprezentacja tekstowa obiektu klasy Ulamek

        System.out.println("Ułamek ul1: " + ul1);
        System.out.println("Ułamek ul2: " + ul2);

        // Rozwiniecie dziesietne obiektu klasy Ulamek

        double x = ul1.rozwDziesietne();
        System.out.println("Rozwinięcie dziesiętne ułamka ul1: " + x);

        // Operacje dodawania, odejmowanie i mnozenia

        Ulamek ul3 = ul1.plus(ul2);
        Ulamek ul4 = ul1.minus(ul2);
        Ulamek ul5 = ul1.razy(ul2);

        // ul1 + ul2

        System.out.println("Dodawanie ul1 + ul2: " + ul3);

        // ul1 - ul2

        System.out.println("Odejmowanie ul1 - ul2: " + ul4);

        // ul1 * ul2

        System.out.println("Mnożenie ul1 * ul2: " + ul5);

        // Odwrocenie ulamka

        ul1.odwroc();
        System.out.println("Ułamek ul1 odwrócony: " + ul1);

        // Skrocenie ulamka

        ul1.skroc();
        System.out.println("Ułamek ul1 skrócony: " + ul1);

        System.out.println("-----------------------------------------\n");

        /***********************************
         * Testowanie klasy LiczbaZespolona
         **********************************/

        System.out.println("Testowanie klasy LiczbaZespolona");

        // Inicjalizacja obiektow

        LiczbaZespolona lz1, lz2;
        lz1 = new LiczbaZespolona(3, 4);
        lz2 = new LiczbaZespolona(2, 7);

        // Reprezentacja tekstowa obiektu klasy Ulamek

        System.out.println("Liczba zespolona lz1: " + lz1);
        System.out.println("Liczba zespolona lz2: " + lz2);

        // Operacje dodawania, odejmowanie, mnozenia i dzielenia

        LiczbaZespolona lz3 = lz1.plus(lz2);
        LiczbaZespolona lz4 = lz1.minus(lz2);
        LiczbaZespolona lz5 = lz1.razy(lz2);
        LiczbaZespolona lz6 = lz1.dziel(lz2);

        // lz1 + lz2

        System.out.println("Dodawanie lz1 + lz2: " + lz3);

        // lz1 - lz2

        System.out.println("Odejmowanie lz1 - lz2: " + lz4);

        // lz1 * lz2

        System.out.println("Mnożenie lz1 * lz2: " + lz5);

        // lz1 / lz2

        System.out.println("Dzielenie lz1 / lz2: " + lz6);

        System.out.println("-----------------------------------------\n");

        /**************************
         * Testowanie klasy Wektor
         *************************/

        System.out.println("Testowanie klasy Wektor");

        // Inicjalizacja obiektow

        Wektor w1, w2;
        w1 = new Wektor(3, 4, 2);
        w2 = new Wektor(2, 7, 5);

        // Reprezentacja tekstowa obiektu klasy Wektor

        System.out.println("Wektor w1: " + w1);
        System.out.println("Wektor w2: " + w2);

        // Operacje dodawania, odejmowanie i mnozenia

        Wektor w3 = w1.plus(w2);
        Wektor w4 = w1.minus(w2);
        Wektor w5 = w1.razy(2);

        // w1 + w2

        System.out.println("Dodawanie w1 + w2: " + w3);

        // w1 - w2

        System.out.println("Odejmowanie w1 - w2: " + w4);

        // w1 * w2

        System.out.println("Mnożenie w1 * w2: " + w5);

        // Iloczyn skalarny i wektorowy

        double l = w1.IloczynSkalarny(w2);
        Wektor w6 = w1.IloczynWektorowy(w2);

        // Iloczyn skalarny

        System.out.println("Iloczyn skalarny w1 • w1: " + l);

        // Iloczyn wektorowy

        System.out.println("Iloczyn wektorowy w1 x w2: " + w6);

        System.out.println("-----------------------------------------\n");

        /***************************************
         * Testowanie klasy WielomianKwadratowy
         **************************************/

        System.out.println("Testowanie klasy WielomianKwadratowy");

        // Inicjalizacja obiektow

        WielomianKwadratowy wk1, wk2, wk3;
        wk1 = new WielomianKwadratowy(1, 6, 12);
        wk2 = new WielomianKwadratowy(1, 0, 0);
        wk3 = new WielomianKwadratowy(1, -8, 15);

        // Reprezentacja tekstowa obiektu klasy WielomianKwadratowy

        System.out.println("WielomianKwadratowy wk1: " + wk1);
        System.out.println("WielomianKwadratowy wk2: " + wk2);
        System.out.println("WielomianKwadratowy wk3: " + wk3);

        // Dodawanie i mnozenie

        WielomianKwadratowy wk4 = wk1.plus(wk2);
        Wielomian wk5 = wk1.razy(wk2);

        System.out.println("Dodawanie wk1 + wk2: " + wk4);
        System.out.println("Mnożenie wk1 * wk2: " + wk5);

        // Miejsca zerowe

        System.out.println("Miejsca zerowe wk1: " + wk1.miejscaZerowe());
        System.out.println("Miejsca zerowe wk2: " + wk2.miejscaZerowe());
        System.out.println("Miejsca zerowe wk3: " + wk3.miejscaZerowe());

        System.out.println("-----------------------------------------\n");

        /***************************************
         * Testowanie klasy BigLiczba
         **************************************/

        System.out.println("Testowanie klasy BigLiczba");

        // Inicjalizacja obiektow

        System.out.println("-----------------------------------------\n");

        /***************************************
         * Testowanie klasy Macierz
         **************************************/

        System.out.println("Testowanie klasy Macierz");

        // Inicjalizacja obiektow

        int[][] macierz_m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] macierz_m3 = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}, {7.7, 8.8, 9.9}};

        Macierz m1 = new Macierz();
        Macierz m2 = new Macierz(macierz_m2);
        Macierz m3 = new Macierz(macierz_m3);

        // Test reprezentacji tekstowej obietu Macierz

        System.out.println("Macierz m1: "+m1);
        System.out.println("Macierz m2: "+m2);
        System.out.println("Macierz m3: "+m3);

        // Test metody wyznacznik()

        System.out.println("Wyznacznik macierzy m1: "+m1.wyznacznik());
        System.out.println("Wyznacznik macierzy m2: "+m2.wyznacznik());
        // Błąd spowodowany dokładnością - wynik miał być równy 0
        System.out.println("Wyznacznik macierzy m3: "+m3.wyznacznik());

        // Test metody transponowana()

        System.out.println("Macierz transponowana m1: "+m1.transponowana());
        System.out.println("Macierz transponowana m2: "+m2.transponowana());
        System.out.println("Macierz transponowana m3: "+m3.transponowana());

        // Test metody diagonalna()

        System.out.println("Macierz diagonalna m1: "+m1.diagonalna());
        System.out.println("Macierz diagonalna m2: "+m2.diagonalna());
        System.out.println("Macierz diagonalna m3: "+m3.diagonalna());

        // Test metody odwrotna()

        System.out.println("Macierz odwrotna m1: "+m1.odwrotna());
        System.out.println("Macierz odwrotna m2: "+m2.odwrotna());
        System.out.println("Macierz odwrotna m3: "+m3.odwrotna());

        // Test metod obsługujących podstawowe operacje na macierzach: plus(), minus(), razy(), dziel()

        System.out.println("m2 + m2.T: "+m2.plus(m2.transponowana()));
        System.out.println("m2 - m2.T: "+m2.minus(m2.transponowana()));
        System.out.println("m2 * 2   : "+m2.razy(2));
        System.out.println("m2 * 2.5 : "+m2.razy(2.5));
        System.out.println("m2 * m2.T: "+m2.razy(m2.transponowana()));
        System.out.println("m2 / 2   : "+m2.dziel(3));

        System.out.println("----------------------------------------------");

    }
}
