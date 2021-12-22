import java.io.*;
import java.net.*;
 
class Odbior extends Thread
{
   Socket sock;
   BufferedReader sockReader;
 
   public Odbior(Socket sock) throws IOException                                         
   {                                                                                    
      this.sock=sock;                                                                   
      this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream())); 
   }                                                                                    
 
   public void run() 
   {                 
       while (true)
       {
           String str;
           str = sockReader.readLine();
           System.out.println(sock);
           if (str.equalsIgnoreCase("KONIEC"))
           {
            System.out.println("Koniec polaczenia");
            break;
           }

       }
   }                 
}
 
public class Klient
{
   public static final int PORT=50007;
   public static final String HOST = "127.0.0.1";
 
   public static void main(String[] args) throws IOException  
   {                                                         
      //nawiazanie polaczenia z serwerem                     
      Socket sock;                                           
      sock=new Socket(HOST,PORT);                            
      System.out.println("Nawiazalem polaczenie: "+sock);    
 
      //tworzenie watka odbierajacego                        
      new Odbior(sock).start();                              
 
 
 
      //zamykanie polaczenia                                 
      sock.close();                                          
   }                                                         
}