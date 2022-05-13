import java.io.PrintWriter;

import java.io.*;
import java.net.*;

class Nadawanie extends Thread {
    Socket sock;
    PrintWriter sockWriter;
    BufferedReader klaw;
    Boolean closed;

    public Nadawanie(Socket sock) throws IOException {
        this.sock = sock;
        this.sockWriter = new PrintWriter(sock.getOutputStream());
        this.klaw = new BufferedReader(new InputStreamReader(System.in));
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
                System.out.print("<Wyslano:> ");
                str = klaw.readLine();
                sockWriter.println(str);
                sockWriter.flush();
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