import java.awt.Rectangle;

public class Prostokaty {
    public static void main(String[] args) {
        // 3.2

        Rectangle obj1 = new Rectangle(0, 0, 4, 3);
        Rectangle obj2 = new Rectangle(1, 1, 4, 3);

        Rectangle obj3 = obj1.intersection(obj2);

        System.out.println("Czesc wspolna prostokatow obj1 i obj2: "+obj3);

        System.out.println("----------------------------------------");

        // 3.3

        obj1 = new Rectangle(1, 1, 4, 5);
        obj2 = new Rectangle(2, 0, 2, 3);

        boolean zawiera = obj2.contains(obj1);

        System.out.println("Czy obj2 zawiera obj1: "+zawiera);

        System.out.println("----------------------------------------");

        // 3.4

        obj1 = new Rectangle(-3, 0, 6, 3);

        zawiera = obj1.contains(2, -1);

        System.out.println("Czy obj1 zawiera punkt (2, -1): "+zawiera);

        System.out.println("----------------------------------------");

        // 3.5

        obj1 = new Rectangle(1, 1, 4, 5);
        obj2 = new Rectangle(2, 0, 2, 3);

        boolean przecina = obj1.intersects(obj2);

        System.out.println("Czy obj1 przecina obj2: "+przecina);
    }
}