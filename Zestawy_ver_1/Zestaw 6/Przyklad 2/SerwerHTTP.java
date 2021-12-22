import java.io.*;
import java.net.*;
 
class ObslugaZadania extends Thread
{
   Socket sock;
 
   ObslugaZadania(Socket klientSocket)  
   {                                   
      this.sock=klientSocket;          
   }                                   
 
   public void run()
   {    
       try {        
            //strumienie danych
            InputStream is=sock.getInputStream();                      
            OutputStream os=sock.getOutputStream();                           
            BufferedReader inp=new BufferedReader(new InputStreamReader(is)); 
            DataOutputStream outp=new DataOutputStream(os);   
            
        //przyjecie zadania (request)                                  
        String request=inp.readLine();
    
        //wyslanie odpowiedzi (response)                                  
        if(request.startsWith("GET"))                                     
        {                                                                 
            //response header                                              
            outp.writeBytes("HTTP/1.0 200 OK\r\n");                        
            outp.writeBytes("Content-Type: text/html\r\n");                
            outp.writeBytes("Content-Length: \r\n");                       
            outp.writeBytes("\r\n");

            System.out.println(request);
            
            String[] tab_get = request.split(" ");
            String nazwaPliku = tab_get[1].substring(1);

            // if (request.contains("HTMLImages.html")) {
            //     nazwaPliku = "HTMLImages.html";
            // } else {
            //     nazwaPliku = "index_1.html";
            // }

            //response body                                                
            FileInputStream fis = new FileInputStream(nazwaPliku);

            byte[] bufor;
            bufor=new byte[1024];
            int n=0;
            
            while ((n = fis.read(bufor)) != -1 )
            {
                outp.write(bufor, 0, n);
            }                            
        }                                                                 
        else                                                              
        {                                                                 
            outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");            
        }  
            //zamykanie strumieni                                             
            inp.close();                                                      
            outp.close();                                                     
            sock.close();
        }
        catch(IOException e) {
            System.out.println("Blad");
        }  
    }        
}
 
public class SerwerHTTP
{
   public static void main(String[] args) throws IOException     
   {                                                            
      ServerSocket serv=new ServerSocket(80);                   
 
      while(true)                                               
      {                                                         
        //przyjecie polaczenia                                 
        System.out.println("Oczekiwanie na polaczenie...");    
        Socket sock=serv.accept();                             

        //tworzenie watku obslugi tego polaczenia
        new ObslugaZadania(sock).start();             
      }                                                         
   }                                                            
}