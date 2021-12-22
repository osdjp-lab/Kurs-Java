public class Main {
    public static void main(String[] args) {

        Osoba osoba1 = new Osoba("Gorniak");
        Osoba osoba2 = new Osoba("Hantaj");
        Osoba osoba3 = new Osoba("Ważniak");

        Dokument[] bazaDanych = { new Paszport(osoba1),
                                  new DowodOsobisty(osoba2),
                                  new Paszport(osoba3) };

        Dokument z;
        String wzorzec = "Gorniak";

        for (int i = 0; i < bazaDanych.length; i++) {
            z = bazaDanych[i];
            if (z.czyPasuje(wzorzec))
                System.out.println("znaleziono: " + z);
        }
    }
}