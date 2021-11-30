import java.io.*;
import java.net.*;

public class Klient {
    public static final int PORT = 50007;
    public static final String HOST = "155.158.131.154";

    public static void main(String[] args) throws IOException {
        //nawiazanie polaczenia z serwerem
        try {
            Socket sock;
            sock = new Socket(HOST, PORT);
            System.out.println("Nawiazalem polaczenie: " + sock);

            //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
            BufferedReader klaw, inp;
            klaw = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outp;
            outp = new PrintWriter(sock.getOutputStream());
            inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));


            String str;

            while (true) {
                System.out.print("<Wysylamy:> ");
                str = klaw.readLine();
                outp.println(str);
                outp.flush();
                if (str.equals("koniec") || str.equals("KONIEC")) {
                    break;
                }
                str = inp.readLine();
                System.out.println("Nadeszlo:> " + str);
            }

            //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia


            //zamykanie polaczenia
            klaw.close();
            outp.close();
            sock.close();
    }
    // gora do try
    catch(ConnectException e)

    {
        // blad polaczenie z serwerem
        System.out.println("blad polaczenia z serwerem");
    }

    catch(SocketException e)

    {
        // polaczenie zerwane z serwerem
        System.out.println("polaczenie zerwane z serwerem");
    }
    finally

    {
        System.out.println("klient sie wysypal");
        //klient sie wysypal
    }
}
}