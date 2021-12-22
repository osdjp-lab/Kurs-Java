package pkt_1;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Point;

class Prostokat extends Rectangle
{
   Prostokat(int a,int b) 
   {                      
      super(a, b);         
   }

   Prostokat(Point wierzcholek, int dlugosc, int szerokosc) {
      super(wierzcholek.x, wierzcholek.y, dlugosc, szerokosc);
   }
 
   void info()                  
   {                            
      System.out.println(this); 
   }

   boolean adheres(Prostokat other) {
      if (x == other.x) {
         return true;
      }
      if (x == other.x + other.width) {
         return true;
      }
      if (x + width == other.x) {
         return true;
      }
      if (x + width == other.x + other.width) {
         return true;
      }
      if (y == other.y) {
         return true;
      }
      if (y == other.y + other.height) {
         return true;
      }
      if (y + height == other.x) {
         return true;
      }
      if (y + height == other.y + other.height) {
         return true;
      }
      return false;
   }

   boolean adheres_2(Prostokat other) {
      Rectangle2D rect = createIntersection(other);
      return rect.getHeight() == 0 || rect.getWidth() == 0 || x == other.x || x + width == other.x + other.width || y == other.y || y + height == other.y + other.height;
   }
}

public class Program
{
   public static void main(String[] args)                   
   {                                                       
 
      Prostokat a=new Prostokat(3,4);                      
      a.info();                                            
 
      Prostokat b=new Prostokat(2,2);                      
      b.info();                                            
 
 
 
      if(a.intersects(b))                                  
      {                                                    
         System.out.println("-- przecinaja sie --\n");     
      }                                                    
      else                                                 
      {                                                    
         System.out.println("-- NIE przecinaja sie --\n"); 
      }                                                    
 
 
 
      a.translate(5,3);                                    
      a.info();                                            
 
      if(a.intersects(b))                                  
      {                                                    
         System.out.println("-- przecinaja sie --\n");     
      }                                                    
      else                                                 
      {                                                    
         System.out.println("-- NIE przecinaja sie --\n"); 
      }
      
      Prostokat c=new Prostokat(new Point(5, 5), 5, 5);
      c.info();

      Prostokat d=new Prostokat(new Point(5, 10), 5, 5);
      d.info();

      System.out.println(c.adheres(d));

      System.out.println(c.adheres_2(d));
 
   }                                                       
}