import java.io.*;
import java.net.*;

class ObslugaZadania extends Thread {
    Socket sock;
    BufferedReader inp;
    DataOutputStream out;

    ObslugaZadania(Socket klientSocket) {
        this.sock = klientSocket;
        try {
            this.inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            this.out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            System.err.println("Blad Wejscia/Wyjscia: " + e.getMessage());
        }
    }

    public void run() {
        try {
            String request = inp.readLine();
            System.out.println(request);
            if (request.contains("autumn")) {
                send_file("Images/autumn-park.png");
            } else if (request.contains("bonfire")) {
                send_file("Images/bonfire.png");
            } else if (request.contains("foggy")) {
                send_file("Images/foggy-night-in-the-forest.png");
            } else if (request.contains("lighthouse")) {
                send_file("Images/lighthouse.png");
            } else if (request.contains("mountain")) {
                send_file("Images/mountain-landscape.png");
            } else {
                send_file("test.html");
            }
        } catch (IOException e) {
            System.err.println("Blad Wejscia/Wyjscia: " + e.getMessage());
        }
    }

    void send_file(String filePath) {
        File page = new File(filePath);
        byte[] mybytearray = new byte[(int) page.length()];
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(page);
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku: " + e.getMessage());
        }
        BufferedInputStream bis = new BufferedInputStream(fis);

        try {
            bis.read(mybytearray, 0, mybytearray.length);
            out.write(mybytearray, 0, mybytearray.length);
            out.flush();
            out.close();
            sock.close();
        } catch (IOException e) {
            System.err.println("Blad Wejscia/Wyjscia: " + e.getMessage());
        }
    }
}

public class SerwerHTTP {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(80);

        while (true) {
            // przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock = serv.accept();

            // tworzenie watku obslugi tego polaczenia
            new ObslugaZadania(sock).start();
        }
    }
}