import java.io.*;
import java.net.*;

public class Klient {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // 1 - nawiazanie polaczenia z serwerem
        Socket sock;
        sock = new Socket(HOST, PORT);
        System.out.println("Nawiazalem polaczenie: " + sock);

        // 2 - strumienie danych
        // strumień wyjścia socketu
        PrintWriter outp;
        outp = new PrintWriter(sock.getOutputStream());
        BufferedReader inp, klaw;
        // strumień wejścia socketu
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        // strumień wyjścia klawiatury
        klaw = new BufferedReader(new InputStreamReader(System.in));

        String str;

        // 3 - odbiór i wysyłanie komunikatów tekstowych
        // Nie działa prawidłowo
        while (true) {
            // odbiór
            // sprawdzenie czy są dane do pobrania
            if ((str = inp.readLine()) != null) {
                System.out.println("<Odebrano:> " + str);
                // 4 - zakończenie komunikacji
                if (str.equalsIgnoreCase("koniec")) {
                    break;
                }
                outp.println("ECHO: "+str);
                outp.flush();
            }

            // wysyłanie
            if ((str = klaw.readLine()) != null) {
                System.out.print("<Wysylamy:> " + str);
                // nadawanie
                outp.println(str);
                outp.flush();
                // 4 - zakończenie komunikacji
                if (str.equalsIgnoreCase("koniec")) {
                    break;
                }
            }
        }
        System.out.println("Koniec polaczenia");

        // 5 - zamykanie polaczenia
        klaw.close();
        outp.close();
        sock.close();
    }
}