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
         int k = Integer.parseInt(t1.getText());
         t1.setText(Integer.toString(k * k));
         t1.requestFocus();
      }
      if (target == b2) {
         t1.setText("");
         t1.requestFocus();
      }
      if (target == dod) {
         tmp = Double.parseDouble(t1.getText());
         t1.setText("");
         t1.requestFocus();
      }
      if (target == row) {
         t1.setText(Double.toString(tmp + Double.parseDouble(t1.getText())));
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