import java.io.*;
import java.net.*;

public class Klient {
   public static final int PORT = 50007;
   public static final String HOST = "127.0.0.1";

   public static void main(String[] args) throws IOException {
      // nawiazanie polaczenia z serwerem
      try {
         Socket sock;
         sock = new Socket(HOST, PORT);
         System.out.println("Nawiazalem polaczenie: " + sock);

         // tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do
         // socketu
         BufferedReader klaw;
         klaw = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter outp;
         outp = new PrintWriter(sock.getOutputStream());

         // komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
         while (true) {
            System.out.print("<Wysylamy:> ");
            String str = klaw.readLine();
            outp.println(str);
            outp.flush();
            if (str.equalsIgnoreCase("KONIEC")) {
               break;
            }
         }

         // zamykanie polaczenia
         klaw.close();
         outp.close();
         sock.close();

         System.out.println("Koniec polaczenia");
      } catch (ConnectException e) {
         System.out.println("Polaczenie zostalo przerwane");
      }

   }
}