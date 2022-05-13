import java.io.*;
import java.net.*;

class Odbior extends Thread {
    Socket sock;
    BufferedReader sockReader;
    Boolean closed;

    public Odbior(Socket sock) throws IOException {
        this.sock = sock;
        this.sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        this.closed = false;
    }

    public boolean get_state() {
        return closed;
    }

    public void set_state() {
        closed = true;
    }

    public void run() {
        try {
            String str;
            while (true) {
                if (closed) {
                    break;
                }
                str = sockReader.readLine();
                System.out.println("<Odebrano:> " + str);
                if (str.equalsIgnoreCase("koniec")) {
                    break;
                }
            }
        } catch(IOException e) {
            System.err.println("Blad Wejscia/Wyjscia: " + e.getMessage());
        }
        System.out.println("Koniec polaczenia");
        closed = true;
    }
}