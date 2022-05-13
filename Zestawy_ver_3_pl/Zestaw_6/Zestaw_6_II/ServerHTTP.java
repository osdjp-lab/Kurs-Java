import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.net.ssl.SSLServerSocketFactory;

class ObslugaZadania extends Thread {
    Socket sock;
    final static String htmlFileName = "index.html";
    DateTimeFormatter dateFormatter;
    LocalDateTime dateTime;
    String dateStr;
    File logFile;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    String userAgent = "";

    ObslugaZadania(Socket klientSocket) {
        this.sock = klientSocket;

        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss - ");
        dateTime = LocalDateTime.now();
        dateStr = dateTime.format(dateFormatter);
        logFile = new File("server.log");

        try {
            logFile.createNewFile();
            System.out.println("zapisywanie log do: " + logFile.getName());
        } catch (IOException e) {
            System.out.println("plik logów już istnieje");
            e.printStackTrace();
        }

    }

    public void run() {

        // strumienie danych
        InputStream is;
        OutputStream os;
        try {
            is = sock.getInputStream();
            os = sock.getOutputStream();
            BufferedReader inp = new BufferedReader(new InputStreamReader(is));
            DataOutputStream outp = new DataOutputStream(os);
            // przyjecie zadania (request)
            String request = inp.readLine();
            System.out.println(request);
            do {
                String readLine = inp.readLine();
                System.out.println(readLine);
                if (readLine.startsWith("User-Agent")) {
                    userAgent = readLine.replace("User-Agent", "");
                }
            } while (inp.ready());

            System.out.println("odp:");

            // wyslanie odpowiedzi (response)
            if (request.startsWith("GET")) {
                try {

                    FileInputStream fis = new FileInputStream(htmlFileName);

                    // response header
                    outp.writeBytes("HTTP/1.0 200 OK\r\n");

                    String contentType = (htmlFileName.endsWith(".html") || htmlFileName.endsWith(".htm")) ? "text/html"
                            : "";
                    outp.writeBytes("Content-Type: " + contentType + "\r\n");
                    outp.writeBytes("Content-Length: " + fis.available() + "\r\n");
                    outp.writeBytes("\r\n");

                    // response
                    byte[] bufor;
                    bufor = new byte[1024];
                    int n = 0;

                    while ((n = fis.read(bufor)) != -1) {
                        outp.write(bufor, 0, n);
                    }

                    fis.close();
                } catch (Exception e) {
                    outp.writeBytes("HTTP/1.0 404 Not Found\r\n");
                }

            } else {
                outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
            }

            System.out.println("przegladarka zada: " + request.split(" ")[1]);
            log();

            // zamykanie strumieni
            inp.close();
            outp.close();
            sock.close();
        } catch (IOException e1) {
            System.out.println("blad w watku obslugi klienta");
        }

    }

    void log() {

        try {
            fileWriter = new FileWriter(logFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            dateTime = LocalDateTime.now();
            dateStr = dateTime.format(dateFormatter);

            String ip = (((InetSocketAddress) sock.getRemoteSocketAddress()).getAddress()).toString().replace("/", "");

            bufferedWriter.write(dateStr + "client connected from" + userAgent + "; IP: " + ip + "\n");
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("blad w zapisie logow do pliku");
        }
    }
}

public class ServerHTTP {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String portStr;
        int port = 8080;
        ServerSocket serv;

        SSLServerSocketFactory fact;
        fact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        do {
            System.out.print("podaj port: ");
            portStr = scanner.nextLine();
            try {
                port = Integer.parseInt(portStr);
            } catch (Exception e) {
                System.out.println("podaj prawidlowa liczbe");
                continue;
            }
            try {
                serv = fact.createServerSocket(port);
                break;
            } catch (java.net.BindException e) {
                System.out.println("port zajety");
            }

        } while (true);

        serv.close();
        serv = new ServerSocket(port);

        while (true) {
            // przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock = serv.accept();

            new ObslugaZadania(sock).start();

        }
    }
}