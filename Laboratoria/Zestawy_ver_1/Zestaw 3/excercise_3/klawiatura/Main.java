import java.io.*;
public class Main
{
   static double kurs_usd=4.2;
   static double kurs_gbp=5;
   static double kurs_eur=4.5;
 
   public static void main(String[] args)                                        
   {                                                                             
      try                                                                        
      {                                                                          
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
         BufferedReader cr=new BufferedReader(new InputStreamReader(System.in)); 

         System.out.print("Proszę wprowadzić walutę:");
         String str1=cr.readLine();                                                                 
         System.out.print("Proszę wprowadzić kwotę $: ");                                                
         String str2=br.readLine();                                               

         double x=Double.parseDouble(str2);                                        
         double KURS=0;

         if (str1.equals("USD"))
         {
            KURS = x*kurs_usd;
         }

         if (str1.equals("GBP"))
         {
            KURS = x*kurs_gbp;
         }

         if (str1.equals("EUR"))
         {
            KURS = x*kurs_eur;
         }


         System.out.println(KURS);                                     
      }                                                                          
 
      catch(IOException e1)                                                      
      {                                                                          
         System.out.println("wyjatek operacji wejscia/wyjscia");                 
      }                                                                          
 
      catch(NumberFormatException e2)                                            
      {                                                                          
         System.out.println("nieprawidlowy format liczby");                      
      }                                                                          
   }                                                                             
}
