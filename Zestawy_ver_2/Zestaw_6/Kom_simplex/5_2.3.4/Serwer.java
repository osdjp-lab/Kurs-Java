import java.io.*;
import java.net.*;

public class Serwer {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {
        // tworzenie gniazda serwerowego
        ServerSocket serv;
        serv = new ServerSocket(PORT);
        
        // 1 - nawiązywanie połączenia z klientem
        System.out.println("Nasluchuje: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Jest polaczenie: " + sock);

        // 2 - strumienie danych
        // strumień wyjścia socketu
        PrintWriter outp;
        outp = new PrintWriter(sock.getOutputStream());
        // strumień wejścia socketu
        BufferedReader inp, klaw;
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
        inp.close();
        sock.close();
        serv.close();
    }
}