import java.io.*;
import java.net.*;

public class Serwer {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {
        // tworzenie gniazda serwerowego
        ServerSocket serv;
        serv = new ServerSocket(PORT);
        
        // 5.2(1) - nawiazywanie polaczenia z klientem
        System.out.println("Nasluchuje: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Jest polaczenie: " + sock);

        // 5.2(2) - strumienie danych
        PrintWriter outp;
        BufferedReader inp, klaw;

        // strumien wyjscia socketu
        outp = new PrintWriter(sock.getOutputStream());
        
        // strumien wejscia socketu
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        // strumien wyjscia klawiatury
        klaw = new BufferedReader(new InputStreamReader(System.in));

        String str;

        // 5.2(3) - odbior i wysylanie komunikatow tekstowych
        while (true) {
            // odbior
            str = inp.readLine();
            System.out.println("<Odebrano:> " + str);
            // 4 - zakonczenie komunikacji
            if (str.equalsIgnoreCase("koniec")) {
                break;
            }

            // wysylanie
            System.out.print("<Wyslano:> ");
            str = klaw.readLine();
            // nadanie
            outp.println(str);
            outp.flush();
            // 5.2(4) - zakonczenie komunikacji
            if (str.equalsIgnoreCase("koniec")) {
                break;
            }
        }
        System.out.println("Koniec polaczenia");

        // 5.2(5) - zamykanie polaczenia
        inp.close();
        outp.close();
        klaw.close();
        sock.close();
        serv.close();
    }
}