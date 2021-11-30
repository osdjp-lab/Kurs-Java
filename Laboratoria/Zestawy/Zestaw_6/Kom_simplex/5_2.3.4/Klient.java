import java.io.*;
import java.net.*;

public class Klient {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // nawiazanie polaczenia z serwerem
        Socket sock;
        sock = new Socket(HOST, PORT);
        System.out.println("Nawiazalem polaczenie: " + sock);

        // tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do
        // socketu
        BufferedReader klaw, inp;
        klaw = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp = new PrintWriter(sock.getOutputStream());
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        boolean terminate=false;

        while (!terminate) {
            // komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
            System.out.print("<Wysylamy:> ");
            String str = klaw.readLine();
            outp.println(str);
            outp.flush();
            if (str.equalsIgnoreCase("exit")) {
                terminate=true;
            }
            str = inp.readLine();
            System.out.println("Nadeszlo:> " + str);
        }

        // zamykanie polaczenia
        klaw.close();
        outp.close();
        sock.close();
    }
}