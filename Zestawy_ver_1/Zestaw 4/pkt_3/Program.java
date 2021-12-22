package pkt_3;

class Osoba
{
    String nazwisko;
    
    Osoba(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return nazwisko;
    }
}

interface Przeszukiwalne
{
   boolean czyPasuje(String wzorzec);
}

abstract class Dokument implements Przeszukiwalne
{
    Osoba osoba;

    Dokument(Osoba osoba) {
        this.osoba = osoba;
    }
}

class Paszport extends Dokument
{
    Paszport(Osoba osoba) {
        super(osoba);
    }

    public boolean czyPasuje(String wzorzec) {
        return osoba.nazwisko.equalsIgnoreCase(wzorzec);
    }                                 
 
    public String toString() 
    {                        
       return osoba.toString();            
    }                        
}

class DowodOsobisty extends Dokument
{
    DowodOsobisty(Osoba osoba) {
        super(osoba);
    }

    public boolean czyPasuje(String wzorzec) {
        return osoba.nazwisko.equalsIgnoreCase(wzorzec);
    }                                        
 
   public String toString() 
   {                        
      return osoba.toString();            
   }                        
}

public class Program
{
   public static void main(String[] args)                                        
   {                         
      Osoba osoba1 = new Osoba("Gorniak");                                                    
      Dokument[] bazaDanych={new Paszport(osoba1), new DowodOsobisty(osoba1) ,new Paszport(osoba1)}; 
 
      Dokument z;                                                                
      String wzorzec="Gorniak";                                                  
 
      for(int i=0;i<bazaDanych.length;i++)                                       
      {                                                                          
         z=bazaDanych[i];                                                        
         if(z.czyPasuje(wzorzec))System.out.println("znaleziono: "+z);           
      }                                                                          
   }                                                                             
}