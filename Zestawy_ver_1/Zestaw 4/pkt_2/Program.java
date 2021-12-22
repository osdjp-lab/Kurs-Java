package pkt_2;

abstract class Figura //nie mozna tworzyc instancji tej klasy 
{
   abstract double pole(); //metoda abstrakcyjna 
   abstract double obwod();
 
   void info()                  
   {                            
      System.out.println(this); 
   }                            
}

class Okrag extends Figura
{
   double promien;
 
   Okrag(double promien)    
   {                        
      this.promien=promien; 
   }                        
 
   double pole()                   
   {                               
      return 3.14*promien*promien; 
   }                               
 
   double obwod()            
   {                         
      return 2*3.14*promien; 
   }                         
 
   public String toString()          
   {                                 
      return "okrag o pr. "+promien; 
   }                                 
}

class Prostokat extends Figura
{
   double dlugosc;
   double szerokosc;
 
   Prostokat(double dlugosc,double szerokosc) 
   {                                          
      this.dlugosc=dlugosc;                   
      this.szerokosc=szerokosc;               
   }                                          
 
   double pole()                
   {                            
      return dlugosc*szerokosc; 
   }                            
 
   double obwod()                   
   {                                
      return 2*dlugosc+2*szerokosc; 
   }                                
 
   public String toString()                                
   {                                                       
      return "prostokat o wym. "+dlugosc+" na "+szerokosc; 
   }                                                       
}

class Kwadrat extends Figura
{
   double bok;
 
   Kwadrat(double bok) 
   {                                          
      this.bok = bok;               
   }                                          
 
   double pole()                
   {                            
      return Math.pow(bok, 2); 
   }                            
 
   double obwod()                   
   {                                
      return 4 * bok;
   }                                
 
   public String toString()                                
   {                                                       
      return "kwadrat o boku: "+bok;
   }                                                       
}

class Szesciokat extends Figura {
   double bok;

   Szesciokat(double bok) {
      this.bok = bok;
   }

   double pole()                
   {                            
      return 6 * Math.pow(bok, 2) * Math.sqrt(3) / 4; 
   }                            
 
   double obwod()                   
   {                                
      return 6 * bok; 
   }                                
 
   public String toString()                                
   {                                                       
      return "szesciokat o boku: "+bok; 
   }
}

public class Program
{
   public static void main(String[] args)                        
   {                                                             
      Figura z=new Okrag(2);                                     
      z.info();                                                  
 
      Figura[] a={new Prostokat(3,5), new Okrag(8), new Okrag(3), new Szesciokat(4), new Kwadrat(3)}; 
 
      Figura x;                                                  
      double suma=0;                                             
 
      for(int i=0;i<a.length;i++)                                
      {                                                          
         x=a[i];                                                 
         x.info();                                               
         suma=suma+x.pole();                                     
      }                                                          
 
      System.out.println("suma pol figur: "+suma);
   }                                                             
}