public class Program {
    public static void main(String[] args) {
        // Inicjalizacja obiektu klasy Prostokat bez Punktu srodek

        Prostokat pr1;
        pr1 = new Prostokat(3, 4);

        // Inicjalizacja obiektu klasy Punkt

        Punkt pkt1;
        pkt1 = new Punkt(-1, 1);

        // Wydruk reprezentacji tekstowej obiektu Punkt

        System.out.println("Punkt pkt1: " + pkt1);

        // Inicjalizacja obiektu klasy Prostokat z Punktem srodek

        Prostokat pr2;
        pr2 = new Prostokat(3, 4, pkt1);

        // Wydruk reprezentacji tekstowej obiektow klasy Prostokat

        System.out.println("Prostokat pr1: " + pr1);

        System.out.println("Prostokat pr2: " + pr2);

        // Test metody przesun klasy Punkt

        pr2.srodek.przesun(1, 1); // pr2.srodek == pkt1
        System.out.println("Punkt pkt1 po przesunieciu: " + pkt1);

        System.out.println("----------------------------------");

        // Inicjalizacja obiektu klasy Okrag

        Okrag okr1;
        okr1 = new Okrag(1, new Punkt());

        // Wydruk reprezentacji tekstowej obiektu Okrag

        System.out.println("Okrag okr1: " + okr1);

        // Test metod pole i obwod klasy Okrag

        double m = okr1.pole();
        System.out.println("Pole Okregu okr1: " + m);

        double n = okr1.obwod();
        System.out.println("Obwod Okregu okr1: " + n);

        // Test metody zawiera klasy Okrag

        System.out.println("Okrag okr1 zawiera punkt (0, 1): " + okr1.zawiera(new Punkt(0, 1))); // true
        System.out.println("Okrag okr1 zawiera punkt (0, 2): " + okr1.zawiera(new Punkt(0, 2))); // false

        System.out.println("----------------------------------");

        Prostokat pr3;
        pr3 = new Prostokat(2, 2, new Punkt());

        // Test metody zawiera klasy Prostokat

        System.out.println("Prostokat pr3 zawiera punkt (0, 1): " + pr3.zawiera(new Punkt(0, 1))); // true
        System.out.println("Prostokat pr3 zawiera punkt (0, 3): " + pr3.zawiera(new Punkt(0, 3))); // false

        System.out.println("----------------------------------");

        Okrag okr2;
        okr2 = new Okrag(2, new Punkt());
        Okrag okr3;
        okr3 = new Okrag(1, new Punkt(3, 0));
        Okrag okr4;
        okr4 = new Okrag(1.5, new Punkt(2, 0));

        // Test metody przecina klasy Okrag

        System.out.println("Prostokat okr1: " + okr1);
        System.out.println("Okrag okr2: " + okr2);
        System.out.println("Okrag okr3: " + okr3);
        System.out.println("Okrag okr4: " + okr4);
        System.out.println("Okrag okr1 przecina Okrag okr2: " + okr1.przecina(okr2)); // false
        System.out.println("Okrag okr1 przecina Okrag okr3: " + okr1.przecina(okr3)); // false
        System.out.println("Okrag okr1 przecina Okrag okr4: " + okr1.przecina(okr4)); // true

        System.out.println("----------------------------------");

        // Test metody przecina klasy Prostokat

        System.out.println("Prostokat pr1: " + pr1);
        System.out.println("Okrag okr2: " + okr2);
        System.out.println("Okrag okr3: " + okr3);
        System.out.println("Okrag okr4: " + okr4);
        System.out.println("Prostokat pr1 przecina Okrag okr2: " + pr1.przecina(okr2)); // true
        System.out.println("Prostokat pr1 przecina Okrag okr3: " + pr1.przecina(okr3)); // false
        System.out.println("Prostokat pr1 przecina Okrag okr4: " + pr1.przecina(okr4)); // true
    }
}
