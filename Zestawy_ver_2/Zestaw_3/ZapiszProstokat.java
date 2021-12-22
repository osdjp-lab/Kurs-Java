import java.awt.Rectangle;
import java.io.*;

/**
 * Klasa dziedziczna klasy Rectangle umożliwijąca zapis reprezentacji obiektu Rectangle do pliku.
 */
class ZapiszProstokat extends Rectangle {
    /**
     * Eksportuje reprezentację obiektu Rectangle do pliku podanego poprzez FilePath.
     * @param FilePath Ścieżka do pliku wyjściowego.
     */
    void save(String FilePath) {
        try {
            PrintWriter plik1 = new PrintWriter(new BufferedWriter(new FileWriter(FilePath, false)));
            plik1.println(this.toString());
            plik1.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
