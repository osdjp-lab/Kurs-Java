package Laboratoria.Zestawy.Zestaw_2;

public class Program {
    public static void main(String[] args)
    {
        // Testowanie klasy Ulamek

        // Inicjalizacja obiektów

        Ulamek ul1, ul2;
        ul1 = new Ulamek(6,8);
        ul2 = new Ulamek(3,7);

        // Reprezentacja tekstowa obiektu klasy Ulamek
        
        System.out.println("Ułamek 1: "+ul1);
        System.out.println("Ułamek 2: "+ul2);

        // Rozwinięcie dziesiętne obiektu klasy Ulamek
        
        double x = ul1.rozwDziesietne();
        System.out.println("Rozwinięcie dziesiętne ułamka 1: "+x);

        // Operacje dodawania, odejmowanie i mnożenia
        
        Ulamek ul3 = ul1.plus(ul2);
        Ulamek ul4 = ul1.minus(ul2);
        Ulamek ul5 = ul1.razy(ul2);

        // ul1 + ul2

        System.out.println("Dodawanie: "+ul3);

        // ul1 - ul2

        System.out.println("Odejmowanie:"+ul4);
        
        // ul1 * ul2
        
        System.out.println("Mnożenie: "+ul5);
        
        // Odwrócenie ułamka

        ul1.odwroc();
        System.out.println("Ułamek 1 odwrócony: "+ul1);

        // Skrócenie ułamka

        ul1.skroc();
        System.out.println("Ułamek 1 skrócony: "+ul5);


        System.out.println("-----------------------------------------");


        // Testowanie klasy LiczbaZespolona

        // Inicjalizacja obiektów

        LiczbaZespolona lz1, lz2;
        lz1 = new LiczbaZespolona(3, 4);
        lz2 = new LiczbaZespolona(2, 7);

        // Reprezentacja tekstowa obiektu klasy Ulamek

        System.out.println("Liczba zespolona 1: "+lz1);
        System.out.println("Liczba zespolona 2: "+lz2);

        // Operacje dodawania, odejmowanie i mnożenia

        LiczbaZespolona lz3 = lz1.plus(lz2);
        LiczbaZespolona lz4 = lz1.minus(lz2);
        LiczbaZespolona lz5 = lz1.razy(lz2);

        // lz1 + lz2

        System.out.println("Dodawanie: "+lz3);

        // lz1 - lz2

        System.out.println("Odejmowanie:"+lz4);
        
        // lz1 * lz2
        
        System.out.println("Mnożenie: "+lz5);

    }
}
