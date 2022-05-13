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
        Socket sock_odb, sock_nad;
        sock_odb = serv.accept();
        System.out.println("Jest polaczenie: " + sock_odb);
        sock_nad = serv.accept();
        System.out.println("Jest polaczenie: " + sock_nad);

        Odbior in;
        Nadawanie out;

        // tworzenie watka odbierajacego
        in = new Odbior(sock_odb);
        in.start();

        // tworzenie watka nadajacego
        out = new Nadawanie(sock_nad);
        out.start();

        while (true) {
            if (in.get_state()) {
                out.set_state();
                break;
            }
            if (out.get_state()) {
                in.set_state();
                break;
            }
        }

        // zamykanie polaczenia
        serv.close();
        sock_odb.close();
        sock_nad.close();
    }
}