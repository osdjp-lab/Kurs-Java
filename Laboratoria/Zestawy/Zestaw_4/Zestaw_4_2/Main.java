package Zestaw_4_2;

public class Main {
    public static void main(String[] args) {
        Figura z = new Okrag(2);
        z.info();

        Figura[] a = { new Prostokat(3, 5), new Okrag(8), new Okrag(3) };

        Figura x;
        double suma = 0;

        for (int i = 0; i < a.length; i++) {
            x = a[i];
            x.info();
            suma = suma + x.pole();
        }

        System.out.println("suma pol figur: " + suma);
    }
}
