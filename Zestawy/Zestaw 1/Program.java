public class Program
{
    public static void main(String[] args)
    {
        Prostokat obj;
        obj = new Prostokat(3, 4);
        double x = obj.pole();
        System.out.println("Pole prostokata 1: "+x);

        double y = obj.obwod();
        System.out.println("Obwod prostokata 1: "+y);

        System.out.println("----------------------------------");

        Punkt obj1;
        obj1 = new Punkt(-1, 1);
        System.out.println("Punkt: "+obj1);

        Prostokat obj2;
        obj2 = new Prostokat(3, 4, obj1);
        System.out.println("Prostokat 2: "+obj2);

        double p = obj2.pole();
        System.out.println("Pole prostokata 2: "+p);

        obj2.srodek.przesun(1, 1);  // obj2.srodek == obj1
        System.out.println("Punkt po przesunieciu: "+obj1);

        System.out.println("----------------------------------");

        Okrag obj3;
        obj3 = new Okrag(1, new Punkt());
        System.out.println("Okrag testowy: "+obj3);

        System.out.println("Okrag obj3 zawiera punkt (0, 1): "+obj3.zawiera(new Punkt(0, 1)));  // true
        System.out.println("Okrag obj3 zawiera punkt (0, 2): "+obj3.zawiera(new Punkt(0, 2)));  // false

        System.out.println("----------------------------------");

        Prostokat obj4;
        obj4 = new Prostokat(2, 2, new Punkt());

        System.out.println("Prostokat obj4 zawiera punkt (0, 1): "+obj4.zawiera(new Punkt(0, 1)));  // true
        System.out.println("Prostokat obj4 zawiera punkt (0, 3): "+obj4.zawiera(new Punkt(0, 3)));  // false

        System.out.println("----------------------------------");

        Okrag obj5;
        obj5 = new Okrag(2, new Punkt());
        Okrag obj6;
        obj6 = new Okrag(1, new Punkt(3, 0));
        Okrag obj7;
        obj7 = new Okrag(1.5, new Punkt(2, 0));

        System.out.println("Prostokat obj3: "+obj3);
        System.out.println("Okrag obj5: "+obj5);
        System.out.println("Okrag obj6: "+obj6);
        System.out.println("Okrag obj7: "+obj7);
        System.out.println("Okrag obj3 przecina Okrag obj5: "+obj3.przecina(obj5));  // false
        System.out.println("Okrag obj3 przecina Okrag obj6: "+obj3.przecina(obj6));  // false
        System.out.println("Okrag obj3 przecina Okrag obj7: "+obj3.przecina(obj7));  // true

        System.out.println("----------------------------------");

        System.out.println("Prostokat obj: "+obj);
        System.out.println("Okrag obj5: "+obj5);
        System.out.println("Okrag obj6: "+obj6);
        System.out.println("Okrag obj7: "+obj7);
        System.out.println("Prostokat obj przecina Okrag obj5: "+obj.przecina(obj5));  // true
        System.out.println("Prostokat obj przecina Okrag obj6: "+obj.przecina(obj6));  // false
        System.out.println("Prostokat obj przecina Okrag obj7: "+obj.przecina(obj7));  // true

    }
}
