import java.io.*;
import java.net.*;

public class Serwer {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {
        // tworzenie gniazda serwerowego
        ServerSocket serv;
        serv = new ServerSocket(PORT);

        // oczekiwanie na polaczenie i tworzenie gniazda sieciowego
        System.out.println("Nasluchuje: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Jest polaczenie: " + sock);
        PrintWriter outp;
        outp = new PrintWriter(sock.getOutputStream());

        // tworzenie strumienia danych pobieranych z gniazda sieciowego
        BufferedReader inp;
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        // komunikacja - czytanie danych ze strumienia
        String str;
        while (true) {
            str = inp.readLine();
            System.out.println("<Nadeszlo:> " + str);
            if (str.equals("koniec") || str.equals("KONIEC")) {
                break;
            }
            outp.println("ECHO: " + str);
            outp.flush();

        }
        // zamykanie polaczenia
        inp.close();
        sock.close();
        serv.close();
    }
}
