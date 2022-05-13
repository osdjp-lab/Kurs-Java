import java.io.*;
import java.net.*;

public class Klient {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try {
        // 5.2(1) - nawiazanie polaczenia z serwerem
            Socket sock;
            sock = new Socket(HOST, PORT);
        
            System.out.println("Nawiazalem polaczenie: " + sock);

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
                // wysylanie
                System.out.print("<Wyslano:> ");
                str = klaw.readLine();
                // nadanie
                outp.println(str);
                outp.flush();
                // 4 - zakonczenie komunikacji
                if (str.equalsIgnoreCase("koniec")) {
                    break;
                }
                
                // odbior
                str = inp.readLine();
                System.out.println("<Odebrano:> " + str);
                // 5.2(4) - zakonczenie komunikacji
                if (str.equalsIgnoreCase("koniec")) {
                    break;
                }
            }
            System.out.println("Koniec polaczenia");

            // 5.2(5) - zamykanie polaczenia
            outp.close();
            inp.close();
            klaw.close();
            sock.close();
        } catch (java.net.ConnectException e) {  // 5.3
            System.err.println("Polaczenie zostalo przerwane: " + e.getMessage());
        } catch(java.net.SocketException e) {  // 5.4
            System.err.println("Wystapil blad protokolu TCP: " + e.getMessage());
        }
    }
}