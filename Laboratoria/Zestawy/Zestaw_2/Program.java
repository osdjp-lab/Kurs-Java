package Laboratoria.Zestawy.Zestaw_2;

public class Program {
    public static void main(String[] args) {
        // Testowanie klasy Ulamek

        // Inicjalizacja obiektów

        Ulamek ul1, ul2;
        ul1 = new Ulamek(6,8);
        ul2 = new Ulamek(3,7);

        // Reprezentacja tekstowa obiektu klasy Ulamek
        
        System.out.println("Ułamek ul1: "+ul1);
        System.out.println("Ułamek ul2: "+ul2);

        // Rozwinięcie dziesiętne obiektu klasy Ulamek
        
        double x = ul1.rozwDziesietne();
        System.out.println("Rozwinięcie dziesiętne ułamka ul1: "+x);

        // Operacje dodawania, odejmowanie i mnożenia
        
        Ulamek ul3 = ul1.plus(ul2);
        Ulamek ul4 = ul1.minus(ul2);
        Ulamek ul5 = ul1.razy(ul2);

        // ul1 + ul2

        System.out.println("Dodawanie ul1 + ul2: "+ul3);

        // ul1 - ul2

        System.out.println("Odejmowanie ul1 - ul2: "+ul4);
        
        // ul1 * ul2
        
        System.out.println("Mnożenie ul1 * ul2: "+ul5);
        
        // Odwrócenie ułamka

        ul1.odwroc();
        System.out.println("Ułamek ul1 odwrócony: "+ul1);

        // Skrócenie ułamka

        ul1.skroc();
        System.out.println("Ułamek ul1 skrócony: "+ul1);


        System.out.println("-----------------------------------------");


        // Testowanie klasy LiczbaZespolona

        // Inicjalizacja obiektów

        LiczbaZespolona lz1, lz2;
        lz1 = new LiczbaZespolona(3, 4);
        lz2 = new LiczbaZespolona(2, 7);

        // Reprezentacja tekstowa obiektu klasy Ulamek

        System.out.println("Liczba zespolona lz1: "+lz1);
        System.out.println("Liczba zespolona lz2: "+lz2);

        // Operacje dodawania, odejmowanie, mnożenia i dzielenia

        LiczbaZespolona lz3 = lz1.plus(lz2);
        LiczbaZespolona lz4 = lz1.minus(lz2);
        LiczbaZespolona lz5 = lz1.razy(lz2);
        LiczbaZespolona lz6 = lz1.dziel(lz2);

        // lz1 + lz2

        System.out.println("Dodawanie lz1 + lz2: "+lz3);

        // lz1 - lz2

        System.out.println("Odejmowanie lz1 - lz2: "+lz4);
        
        // lz1 * lz2
        
        System.out.println("Mnożenie lz1 * lz2: "+lz5);

        // lz1 / lz2
        
        System.out.println("Dzielenie lz1 / lz2: "+lz6);

        System.out.println("-----------------------------------------");


        // Testowanie klasy Wektor

        // Inicjalizacja obiektów

        Wektor w1, w2;
        w1 = new Wektor(3, 4, 2);
        w2 = new Wektor(2, 7, 5);

        // Reprezentacja tekstowa obiektu klasy Wektor

        System.out.println("Wektor w1: "+w1);
        System.out.println("Wektor w2: "+w2);

        // Operacje dodawania, odejmowanie i mnożenia

        Wektor w3 = w1.plus(w2);
        Wektor w4 = w1.minus(w2);
        Wektor w5 = w1.razy(2);

        // w1 + w2

        System.out.println("Dodawanie w1 + w2: "+w3);

        // w1 - w2

        System.out.println("Odejmowanie w1 - w2: "+w4);
        
        // w1 * w2
        
        System.out.println("Mnożenie w1 * w2: "+w5);

        // Iloczyn skalarny i wektorowy

        double l = w1.IloczynSkalarny(w2);
        Wektor w6 = w1.IloczynWektorowy(w2);

        // Iloczyn skalarny

        System.out.println("Iloczyn skalarny w1 • w1: "+l);

        // Iloczyn wektorowy

        System.out.println("Iloczyn wektorowy w1 x w2: "+w6);

        System.out.println("-----------------------------------------");


        // Testowanie klasy WielomianKwadratowy

        // Inicjalizacja obiektów

        WielomianKwadratowy wk1, wk2, wk3;
        wk1 = new WielomianKwadratowy(1, 6, 12);
        wk2 = new WielomianKwadratowy(1, 0, 0);
        wk3 = new WielomianKwadratowy(1, -8, 15);

        // Reprezentacja tekstowa obiektu klasy WielomianKwadratowy

        System.out.println("WielomianKwadratowy wk1: "+wk1);
        System.out.println("WielomianKwadratowy wk2: "+wk2);
        System.out.println("WielomianKwadratowy wk3: "+wk3);

        // Dodawanie i mnożenie

        WielomianKwadratowy wk4 = wk1.plus(wk2);
        Wielomian wk5 = wk1.razy(wk2);

        System.out.println("Dodawanie wk1 + wk2: "+wk4);
        System.out.println("Mnożenie wk1 * wk2: "+wk5);

        // Miejsca zerowe

        System.out.println("Miejsca zerowe wk1: "+wk1.miejsce_zerowe());
        System.out.println("Miejsca zerowe wk2: "+wk2.miejsce_zerowe());
        System.out.println("Miejsca zerowe wk3: "+wk3.miejsce_zerowe());
    }
}
