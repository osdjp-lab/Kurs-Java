/**
 * Program containing a simple set of classes.
 * 
 * @author  Oscar Szumiak
 */

 /**
  * Class Punkt describing a single point in 2-dimensional space.
  */
class Punkt
{
   double x;
   double y;
   
   /**
    * Punkt initialization function.
    * @param x the x coordinate of the point.
    * @param y the y coordinate of the point.
    */
   Punkt(double x,double y) 
   {                        
      this.x=x;             
      this.y=y;             
   }
   
   /**
    * Punkt move function shifts the x and y coordinates by the given values.
    * @param dx the x axis shift.
    * @param dy the y axis shift.
    */
   void przesun(double dx,double dy)
   {
       this.x += dx;
       this.y += dy;
   }
   
   public String toString()          
   {                                 
      return "[x: "+x+", y: "+y+"]"; 
   }                                 
}

/**
 * Class Prostokat describing a rectangle.
 */
class Prostokat
{
   double dlugosc;
   double szerokosc;
   Punkt wierzcholek;
   
   /**
    * First initialization function, the lower left corner point is set to default (0,0).
    * @param dlugosc length of rectangle
    * @param szerokosc breadth of rectangle
    */
   Prostokat(double dlugosc,double szerokosc) 
   {                                          
      this.dlugosc=dlugosc;                   
      this.szerokosc=szerokosc;               
      this.wierzcholek=new Punkt(0,0);        
   }                                          
   
   /**
    * Second initialization function.
    * @param dlugosc length of rectangle
    * @param szerokosc breadth of rectangle
    * @param wierzcholek lower left corner point of rectangle.
    */
   Prostokat(double dlugosc,double szerokosc, Punkt wierzcholek) 
   {                                                             
      this.dlugosc=dlugosc;                                      
      this.szerokosc=szerokosc;                                  
      this.wierzcholek=wierzcholek;                              
   }                                                             
 
   public String toString()                                                   
   {                                                                          
      return "[dl: "+dlugosc+", sz: "+szerokosc+"]" + wierzcholek.toString(); 
   }                                                                          
 
   /**
    * Calculates the area of the rectangle.
    * @return the surface area of the rectangle.
    */
   double pole()                
   {                            
      return dlugosc*szerokosc; 
   }         
   
   /**
    * Calculates the circumference of the rectangle.
    * @return the circumference of the rectangle.
    */
   double obwod()                
   {                            
      return 2*(dlugosc+szerokosc); 
   }
   
   /**
    * Prostokat move function shifts the x and y coordinates by the given values.
    * @param u the x axis shift.
    * @param v the y axis shift.
    */
   void przesun(double u,double v)
   {
      this.wierzcholek.przesun(u, v);
   }

   /**
    * Prostokat contains point.
    * @param obj point to be checked.
    * @return if point is within the rectangle.
    */
   boolean zawiera(Punkt obj)
   {
      return obj.x >= wierzcholek.x && obj.y >= wierzcholek.y && obj.x <= wierzcholek.x + dlugosc && obj.y <= wierzcholek.y + szerokosc;
   }

   /**
    * Prostokat intersects Okrag.
    * @param obj Okrag to be checked.
    * @return if Okrag intersects the Prostokat
    */
   boolean przecina(Okrag obj)
   {
      return wierzcholek.x <= obj.srodek.x + obj.promien && wierzcholek.y <= obj.srodek.y + obj.promien && wierzcholek.x + dlugosc >= obj.srodek.x - obj.promien && wierzcholek.y + szerokosc >= obj.srodek.y - obj.promien;
   }
}

/**
 * Class Okrag describing a circle.
 */
class Okrag
{
   double promien;
   Punkt srodek;

   /**
    * First initialization function.
    * @param promien radius of the circle.
    * @param x the x coordinate of srodek.
    * @param y the y coordinate of srodek.
    */
   Okrag(double promien, double x, double y) 
   {                                                             
      this.promien=promien;                                      
      this.srodek=new Punkt(x,y);                                                               
   }

   /**
    * Second initialization function.
    * @param promien radius of the circle.
    * @param srodek the x and y coordinate of the circle as a point of type Punkt.
    */
   Okrag(double promien, Punkt srodek) 
   {                                                             
      this.promien=promien;                                      
      this.srodek=srodek;                                                               
   }  

   public String toString()                                                   
   {                                                                          
      return "[r: "+promien+"]" + srodek.toString(); 
   }  

   /**
    * Calculates the area of the circle.
    * @return the area of the circle.
    */
   double pole()                
   {                            
      return Math.PI * promien * promien; 
   }         
   
   /**
    * Calculates the circumference of the circle.
    * @return the circumference of the circle.
    */
   double obwod()                
   {                            
      return 2 * Math.PI * promien; 
   }
   
   /**
    * Okrag move function shifts the x and y coordinates by the given values.
    * @param u the x axis shift.
    * @param v the y axis shift.
    */
   void przesun(double u,double v)
   {
      this.srodek.przesun(u, v);
   }

   /**
    * Okrag contains point.
    * @param obj point to be checked.
    * @return if point is within the circle.
    */
   boolean zawiera(Punkt obj)
   {
      return Math.sqrt(Math.pow((srodek.x - obj.x), 2) + Math.pow((srodek.y - obj.y), 2)) <= promien;
   }

   /**
    * Okrag intersects Okrag.
    * @param obj Okrag to be checked.
    * @return if the Okrag intersects the other Okrag.
    */
   boolean przecina(Okrag obj)
   {
      return Math.sqrt(Math.pow((srodek.x - obj.srodek.x), 2) + Math.pow((srodek.y - obj.srodek.y), 2)) <= promien + obj.promien;
   }
}

/**
 * Main public class.
 */
public class Program
{
   public static void main(String[] args)     
   {  
      // Wierzcholek

      Punkt obj1;                             
      obj1=new Punkt(-1,1);                   
      System.out.println("punkt: "+obj1);     
 
      Prostokat obj2;                         
      obj2=new Prostokat(3,4,obj1);           
      System.out.println("prostokat: "+obj2);

      // Metody pole i obwod
 
      double p=obj2.pole();                   
      System.out.println("pole: "+p);

      double o=obj2.obwod();                   
      System.out.println("pole: "+o);

      // Wierzcholek
      
      Punkt obj;
      obj = new Punkt(0,0);
      System.out.println(obj);

      // Prostokat

      Prostokat obj3;                         
      obj3=new Prostokat(3,4,obj);           
      System.out.println("prostokat: "+obj3);
      
      // obj3.przesun(-1,3);

      System.out.println("prostokat: "+obj3);

      // Okrag

      Okrag obj4;                         
      obj4=new Okrag(3,obj);           
      System.out.println("okrag: "+obj4);

      // obj4.przesun(-1,3);
      
      System.out.println("okrag: "+obj4);

      // Okrag 1

      Okrag okr1;
      okr1 = new Okrag(3, new Punkt(0, 0));

      // Okrag 2

      Okrag okr2;
      okr2 = new Okrag(3, new Punkt(7, 0));

      System.out.println("przecina: " + okr1.przecina(okr2));

      // Prostokat

      Prostokat prk1;                         
      prk1=new Prostokat(3,4,obj);           
      System.out.println("prostokat: "+prk1);

      System.out.println("okr1 przecina prk1: " + prk1.przecina(okr1));

      System.out.println("okr2 przecina prk1: " + prk1.przecina(okr2));

   }                                          
}