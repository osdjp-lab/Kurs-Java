package pkt_4;

import java.io.*;

class Osoba implements Serializable
{
   String imie;
   String nazwisko;
   int rokUrodzenia;
 
   Osoba(String imie,String nazwisko,int rokUrodzenia) 
   {                                                   
      this.imie=imie;                                  
      this.nazwisko=nazwisko;                          
      this.rokUrodzenia=rokUrodzenia;                  
   }                                                   
 
   Osoba(BufferedReader br)                                 
   {                                                        
      try                                                   
      {                                                     
         System.out.print("imie: ");                        
         this.imie=br.readLine();                           
 
         System.out.print("nazwisko: ");                    
         this.nazwisko=br.readLine();                       
 
         System.out.print("rok urodzenia: ");               
         this.rokUrodzenia=Integer.parseInt(br.readLine()); 
      }                                                     
      catch(IOException e){}                                
   }                                                        
 
   public String toString()                                     
   {                                                            
      return this.imie+" "+this.nazwisko+" "+this.rokUrodzenia; 
   }                                                            
}

class DowodOsobisty implements Serializable
{
   Osoba posiadacz;
   String numer;
 
   DowodOsobisty(BufferedReader br)      
   {                                     
      try                                
      {                                  
         this.posiadacz=new Osoba(br);   
 
         System.out.print("numer do: "); 
         this.numer=br.readLine();       
      }                                  
      catch(IOException e){}             
   }                                     
 
   public String toString()                                
   {                                                       
      return "<do:> "+posiadacz.toString()+" "+this.numer; 
   }                                                       
 
   void info()                  
   {                            
      System.out.println(this); 
   }                            
}

public class Program
{
   public static void main(String[] args)                                                  
   {                                                                                       
      System.out.println("-- do zapisu --");                                               
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));              
 
      DowodOsobisty z=new DowodOsobisty(br);                                               
      z.info();                                                                            
 
      try                                                                                  
      {                                                                                    
         ObjectOutputStream outp=new ObjectOutputStream(new FileOutputStream("plik.dat")); 
         outp.writeObject(z);                                                              
         outp.close();                                                                     
      }                                                                                    
      catch(Exception e){System.out.println(e);}                                           
 
 
 
      System.out.println("\n-- z pliku --");                                               
      ObjectInputStream inp;                                                               
 
      try                                                                                  
      {                                                                                    
         inp=new ObjectInputStream(new FileInputStream("plik.dat"));                       
         Object o=inp.readObject();                                                        
         DowodOsobisty x=(DowodOsobisty)o;                                                 
         inp.close();                                                                      
         x.info();                                                                         
      }
      catch(FileNotFoundException NieZnaleziono){System.out.println(NieZnaleziono);}                                                                                    
      catch(Exception e){System.out.println(e);}                                           
   }                                                                                       
}
