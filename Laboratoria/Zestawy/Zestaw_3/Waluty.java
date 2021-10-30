// package Laboratoria.Zestawy.Zestaw_3;

import java.io.*;
import java.util.Hashtable;

public class Waluty {
    static double KURS_PLN = 1.00;
    static double KURS_USD = 3.97;
    static double KURS_GBP = 5.47;
    static double KURS_EUR = 4.61;
    static Hashtable<Integer, Double> KURSY = new Hashtable<Integer, Double>();
    static Hashtable<Integer, String> NAZWY = new Hashtable<Integer, String>();

    public static void main(String[] args) {
        try {
            KURSY.put(0, KURS_PLN);
            KURSY.put(1, KURS_USD);
            KURSY.put(2, KURS_GBP);
            KURSY.put(3, KURS_EUR);

            NAZWY.put(0, "PLN");
            NAZWY.put(1, "USD");
            NAZWY.put(2, "GBP");
            NAZWY.put(3, "EUR");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Podaj walutę (0 - PLN, 1 - USD, 2 - GBP, 3 - EUR): ");
            String wal1 = br.readLine();

            System.out.print("Podaj kwotę: ");
            String kwt = br.readLine();

            System.out.print("Podaj walutę wyjściową (0 - PLN, 1 - USD, 2 - GBP, 3 - EUR): ");
            String wal2 = br.readLine();

            int x = Integer.parseInt(wal1);
            double y = Double.parseDouble(kwt);
            int z = Integer.parseInt(wal2);

            System.out.println(y);

            System.out.println("Kwota w "+NAZWY.get(z)+": "+y * KURSY.get(x) / KURSY.get(z));
        }

        catch (IOException e1) {
            System.out.println("wyjatek operacji wejscia/wyjscia");
        }

        catch (NumberFormatException e2) {
            System.out.println("nieprawidlowy format liczby");
        }
    }
}