import java.awt.Rectangle;


public class Main
{
   public static void main(String[] args)    
   {                                        
      Rectangle obj1=new Rectangle(1,1,4,5); 

      Rectangle obj2=new Rectangle(4,-3,4,3); 
 
      boolean obj3= obj1.intersects(obj2);

      System.out.println(obj3);              
   }                                        
}
