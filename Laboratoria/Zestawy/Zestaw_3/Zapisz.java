// package Laboratoria.Zestawy.Zestaw_3;

import java.io.*;

// import Laboratoria.Zestawy.Zestaw_3.ZapiszProstokat;

public class Zapisz {
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        try {
            ZapiszProstokat test = new ZapiszProstokat();

            System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
            String FilePath = bi.readLine();
            
            test.save(FilePath);

            System.out.println("\n-- z pliku --\n");

            BufferedReader bo = new BufferedReader(new FileReader(FilePath));
            String str;

            while (bo.ready()) {
                str = bo.readLine();
                System.out.println(str);
            }

            bo.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
