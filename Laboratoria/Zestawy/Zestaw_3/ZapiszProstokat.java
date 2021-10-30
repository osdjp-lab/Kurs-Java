// package Laboratoria.Zestawy.Zestaw_3;

import java.awt.Rectangle;
import java.io.*;

class ZapiszProstokat extends Rectangle {
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
