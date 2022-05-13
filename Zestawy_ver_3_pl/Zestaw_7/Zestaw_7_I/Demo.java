import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Demo implements ActionListener {
   JTextField t1;
   JButton b1;
   JButton b2;
   JButton dod;
   JButton row;
   double tmp = 0.0;

   public void actionPerformed(ActionEvent e) {
      Object target = e.getSource();

      if (target == b1 || target == t1) {
         try {
            tmp = Integer.parseInt(t1.getText());
         } catch(NumberFormatException error) {}
         try {
            tmp = Double.parseDouble(t1.getText());
         } catch(NumberFormatException error) {
            System.err.println(error);
         }
         t1.setText(Double.toString(tmp * tmp));
         tmp = 0.0;
         t1.requestFocus();
      }
      if (target == b2) {
         t1.setText("");
         t1.requestFocus();
      }
      if (target == dod) {
         try {
            tmp = Integer.parseInt(t1.getText());
         } catch(NumberFormatException error1) {
            try {
               tmp = Double.parseDouble(t1.getText());
            } catch(NumberFormatException error2) {
               System.err.println(error2);
            }
         }
         
         t1.setText("");
         t1.requestFocus();
      }
      if (target == row) {
         try {
            tmp += Integer.parseInt(t1.getText());
            t1.setText(Double.toString(tmp));
         } catch(NumberFormatException error1) {
            try {
               tmp += Double.parseDouble(t1.getText());
               t1.setText(Double.toString(tmp));
            } catch(NumberFormatException error2) {
               System.err.println(error2);
            }
         }
         tmp = 0.0;
         t1.requestFocus();
      }
   }

   void init() {
      t1 = new JTextField(6);
      b1 = new JButton("^2");
      b2 = new JButton("clear");
      dod = new JButton("+");
      row = new JButton("=");

      JPanel p = new JPanel();
      p.add(t1);
      p.add(b1);
      p.add(b2);
      p.add(dod);
      p.add(row);

      t1.addActionListener(this);
      b1.addActionListener(this);
      b2.addActionListener(this);
      dod.addActionListener(this);
      row.addActionListener(this);

      JFrame f = new JFrame();
      Container c = f.getContentPane();
      c.add(p);
      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }

   public static void main(String[] args) {
      // do wersji 1.4
      // new Demo().init();

      // od wersji 1.5
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Demo().init();
         }
      });
   }
}