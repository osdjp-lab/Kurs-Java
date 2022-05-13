public class Program {
    public static void main(String[] args) {
        // Inicjalizacja obiektow klasy Prostokat

        Prostokat pr1;
        pr1 = new Prostokat();

        Prostokat pr2;
        pr2 = new Prostokat(3, 4);

        // Test metod pole i obwod klasy Prostokat

        double p1 = pr1.pole();
        System.out.println("Pole Prostokata pr1: " + p1);

        double o1 = pr1.obwod();
        System.out.println("Obwod Prostokata pr1: " + o1);

        double p2 = pr2.pole();
        System.out.println("Pole Prostokata pr2: " + p2);

        double o2 = pr2.obwod();
        System.out.println("Obwod Prostokata pr2: " + o2);

        System.out.println("----------------------------------");

        // Wydruk reprezentacji tekstowej obiektow klasy Prostokat

        System.out.println("Prostokat pr1: " + pr1);

        System.out.println("Prostokat pr2: " + pr2);
    }
}
