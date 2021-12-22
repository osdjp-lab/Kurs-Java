import java.io.*;
class Prostokat
{
   double wysokosc;
   double szerokosc;
   Punkt wierzcholek;
 
   Prostokat()         
   {                      
      this.wysokosc=0.0;   
      this.szerokosc=0.0; 
      this.wierzcholek=new Punkt(0,0);  
   }                      
 
   Prostokat(double wysokosc,double szerokosc, Punkt wierzcholek) 
   {                                          
      this.wysokosc=wysokosc; 
      this.szerokosc=szerokosc;         
      this.wierzcholek=wierzcholek;       
   }                                          

   public String toString()                                                   
   {                                                                          
      return "[dl: "+wysokosc+", sz: "+szerokosc+"]" + wierzcholek.toString(); 
   }   
 
   void przesun(double u, double v)
   {
      wierzcholek.przesun(u,v);
   }

   boolean zawiera(Punkt obj)
   {
      return (obj.x >= wierzcholek.x && obj.x <= wierzcholek.x+szerokosc && obj.y >= wierzcholek.y && obj.y <= wierzcholek.y+wysokosc);
   }


   double pole()           // Klasa Prostokąt ma swoje pole     
   {                            
      return wysokosc*szerokosc; 
   }                            
   
   double obwod()
   {
      return wysokosc*2.0+szerokosc*2.0;
   }

   void save(String plik)
   {
         try
         {
         	PrintWriter plik1=new PrintWriter(new BufferedWriter(new FileWriter(plik,true))); 
         	plik1.println("Współrzędne:" + wierzcholek.toString());
         	plik1.println("Wysokość:" + wysokosc);
         	plik1.println("Szerokość:" + szerokosc);
         	plik1.println("Pole:" + pole());
         	plik1.println("Obwód:" + obwod());                                                                
         	plik1.close();
         }
         catch(Exception e){System.out.println(e);}                                                                            
   }

}

class Punkt
{
   double x;
   double y;
 
   Punkt(double x,double y) 
   {                        
      this.x=x;             
      this.y=y;             
   }                        
 
   public String toString()          
   {                                 
      return "[x: "+x+", y: "+y+"]"; 
   }                                 
   void przesun(double dx, double dy)
   {
      x = x + dx;
      y = y + dy;
   }
}


public class Main
{
   public static void main(String[] args)                                                        
   {                                                                                             
      Prostokat obj1 = new Prostokat(2,2,new Punkt(3,4));
      obj1.save("plik.txt");                                        
   }                                                                                             
}
