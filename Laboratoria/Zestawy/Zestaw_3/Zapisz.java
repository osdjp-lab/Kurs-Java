import java.io.*;

/**
 * Zapis reprezentacji obiektu typu Rectangle do podanego na wejście pliku.
 */
public class Zapisz {
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        try {
            ZapiszProstokat test = new ZapiszProstokat();

            System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
            String FilePath = bi.readLine();

            // Zapis do pliku

            System.out.println("Zapis do pliku: "+test);
            
            test.save(FilePath);

            // Odczyt z pliku

            System.out.print("Odczyt z pliku: ");

            BufferedReader bo = new BufferedReader(new FileReader(FilePath));
            String str;

            while (bo.ready()) {
                str = bo.readLine();
                System.out.print(str);
            }

            bo.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
