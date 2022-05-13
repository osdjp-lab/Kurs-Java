import java.io.*;
import java.net.*;

public class Klient {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // nawiazanie polaczenia z serwerem
        Socket sock_nad, sock_odb;
        sock_nad = new Socket(HOST, PORT);
        System.out.println("Nawiazalem polaczenie: " + sock_nad);
        sock_odb = new Socket(HOST, PORT);
        System.out.println("Nawiazalem polaczenie: " + sock_odb);

        Nadawanie out;
        Odbior in;

        // tworzenie watka nadajacego
        out = new Nadawanie(sock_nad);
        out.start();

        // tworzenie watka odbierajacego
        in = new Odbior(sock_odb);
        in.start();

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
        sock_nad.close();
        sock_odb.close();
    }
}