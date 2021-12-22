import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class Plansza extends JPanel {
   Shape rect;
   Shape ellipse;

   Plansza(Shape rect, Shape ellipse) {
      this.rect = rect;
      this.ellipse = ellipse;
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      if (ellipse.intersects((Rectangle2D) rect)) {
         g2d.drawString("The objects intersect.", 100, 100);
      }

      g2d.draw(rect);
      g2d.draw(ellipse);
   }
}

public class Program {
   public static void main(String[] args) {
      Shape obj1;
      obj1 = new Rectangle2D.Float(100, 100, 140, 100);
      Shape obj2;
      obj2 = new Ellipse2D.Float(100, 100, 20, 60);

      Plansza p;
      p = new Plansza(obj1, obj2);

      JFrame jf = new JFrame();
      jf.add(p);

      jf.setTitle("Test grafiki");
      jf.setSize(400, 400);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf.setVisible(true);
   }
}