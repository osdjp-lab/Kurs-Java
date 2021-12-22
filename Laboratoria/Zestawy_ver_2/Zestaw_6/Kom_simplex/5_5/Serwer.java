import java.io.*;
import java.net.*;

class Odbior extends Thread {
    Socket sock;
    BufferedReader sockReader;

    public Odbior(Socket sock) throws IOException {
        this.sock = sock;
        this.sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run() {

    }
}

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

        // tworzenie watka odbierajacego
        new Odbior(sock).start();

        // zamykanie polaczenia
        serv.close();
        sock.close();
    }
}