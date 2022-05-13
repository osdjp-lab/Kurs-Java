import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class ServerHTTPS {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory fact;
        fact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ServerSocket servsock = fact.createServerSocket(8080);

        while (true) {
            try {
                Socket sock = servsock.accept();

                OutputStream out;
                out = sock.getOutputStream();

                BufferedReader in;
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                in.close();
                out.close();
                sock.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}