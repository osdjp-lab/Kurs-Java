import java.io.*;
import java.net.*;

public class SerwerHTTP {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(80);

        while (true) {
            // przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock = serv.accept();

            // strumienie danych
            InputStream is = sock.getInputStream();
            OutputStream os = sock.getOutputStream();
            BufferedReader inp = new BufferedReader(new InputStreamReader(is));
            DataOutputStream outp = new DataOutputStream(os);

            // przyjecie zadania (request)
            String request = inp.readLine();

            // wyslanie odpowiedzi (response)
            if (request.startsWith("GET")) {
                // response header
                outp.writeBytes("HTTP/1.0 200 OK\r\n");
                outp.writeBytes("Content-Type: text/html\r\n");
                outp.writeBytes("Content-Length: \r\n");
                outp.writeBytes("\r\n");

                // response body
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>Strona testowa</H1>\r\n");
                outp.writeBytes("</html>\r\n");
            } else {
                outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
            }

            // zamykanie strumieni
            inp.close();
            outp.close();
            sock.close();
        }
    }
}