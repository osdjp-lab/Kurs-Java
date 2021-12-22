import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Kalk implements ActionListener {
   JTextField t1;
   JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
   JButton dot, clr;
   JButton bplus, bminus, bmult, bdiv, brow;
   int sel = 0;

   double x, buf;

   public void actionPerformed(ActionEvent e) {
      Object target = e.getSource();

      if (target == clr) {
         buf = 0.0;
         t1.requestFocus();
      }

      else if (target == b0) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b1) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b2) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b3) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b4) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b5) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b6) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b7) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b8) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == b9) {
         t1.setText(t1.getText() + ((JButton) target).getText());
         t1.requestFocus();
      }

      else if (target == bplus) {
         buf = Double.parseDouble(t1.getText());
         t1.requestFocus();
         sel = 1;
      }

      else if (target == bminus) {
         buf = Double.parseDouble(t1.getText());
         t1.requestFocus();
         sel = 2;
      }

      else if (target == bmult) {
         buf = Double.parseDouble(t1.getText());
         t1.requestFocus();
         sel = 3;
      }

      else if (target == bdiv) {
         buf = Double.parseDouble(t1.getText());
         t1.requestFocus();
         sel = 4;
      }

      else if (target == brow || target == t1) {
         x = Double.parseDouble(t1.getText());
         if (sel == 1) {
            x = buf + x;
         }
         else if (sel == 2) {
            x = buf - x;
         }
         else if (sel == 3) {
            x = buf * x;
         }
         else if (sel == 4) {
            x = buf / x;
         }
         t1.setText(Double.toString(x));
         t1.requestFocus();
         sel = 0;
      }   
   }

   void init() {
      // try
      // {
      // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      // }
      // catch(Exception e){}

      JFrame f = new JFrame();
      Container c = f.getContentPane();

      GridBagLayout gbl = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      c.setLayout(gbl);

      t1 = new JTextField(15);
      t1.addActionListener(this);
      t1.setHorizontalAlignment(JTextField.RIGHT);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 5;
      gbc.ipadx = 0;
      gbc.ipady = 5;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(t1, gbc);
      c.add(t1);

      b0 = new JButton("0");
      b0.addActionListener(this);
      b0.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b0, gbc);
      c.add(b0);

      clr = new JButton("CLR");
      clr.addActionListener(this);
      clr.setFocusable(false);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(clr, gbc);
      c.add(clr);

      b1 = new JButton("1");
      b1.addActionListener(this);
      b1.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b1, gbc);
      c.add(b1);

      b2 = new JButton("2");
      b2.addActionListener(this);
      b2.setFocusable(false);
      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b2, gbc);
      c.add(b2);

      b3 = new JButton("3");
      b3.addActionListener(this);
      b3.setFocusable(false);
      gbc.gridx = 2;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b3, gbc);
      c.add(b3);

      b4 = new JButton("4");
      b4.addActionListener(this);
      b4.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b4, gbc);
      c.add(b4);

      b5 = new JButton("5");
      b5.addActionListener(this);
      b5.setFocusable(false);
      gbc.gridx = 1;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b5, gbc);
      c.add(b5);

      b6 = new JButton("6");
      b6.addActionListener(this);
      b6.setFocusable(false);
      gbc.gridx = 2;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b6, gbc);
      c.add(b6);

      b7 = new JButton("7");
      b7.addActionListener(this);
      b7.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b7, gbc);
      c.add(b7);

      b8 = new JButton("8");
      b8.addActionListener(this);
      b8.setFocusable(false);
      gbc.gridx = 1;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b8, gbc);
      c.add(b8);

      b9 = new JButton("9");
      b9.addActionListener(this);
      b9.setFocusable(false);
      gbc.gridx = 2;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b9, gbc);
      c.add(b9);

      bplus = new JButton("+");
      bplus.addActionListener(this);
      bplus.setFocusable(false);
      bplus.setToolTipText("dodawanie");
      gbc.gridx = 3;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bplus, gbc);
      c.add(bplus);

      bminus = new JButton("-");
      bminus.addActionListener(this);
      bminus.setFocusable(false);
      bminus.setToolTipText("odejmowanie");
      gbc.gridx = 3;
      gbc.gridy = 2;
      gbc.gridwidth = 2;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bminus, gbc);
      c.add(bminus);

      bmult = new JButton("*");
      bmult.addActionListener(this);
      bmult.setFocusable(false);
      bmult.setToolTipText("mnożenie");
      gbc.gridx = 3;
      gbc.gridy = 3;
      gbc.gridwidth = 2;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bmult, gbc);
      c.add(bmult);

      bdiv = new JButton("/");
      bdiv.addActionListener(this);
      bdiv.setFocusable(false);
      bdiv.setToolTipText("dzielenie");
      gbc.gridx = 3;
      gbc.gridy = 4;
      gbc.gridwidth = 2;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bdiv, gbc);
      c.add(bdiv);

      dot = new JButton(".");
      dot.addActionListener(this);
      dot.setFocusable(false);
      dot.setToolTipText("kropka");
      gbc.gridx = 2;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 5, 0);
      gbl.setConstraints(dot, gbc);
      c.add(dot);

      brow = new JButton("=");
      brow.addActionListener(this);
      brow.setFocusable(false);
      brow.setToolTipText("wykonaj działanie");
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 5;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 5, 0);
      gbl.setConstraints(brow, gbc);
      c.add(brow);

      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setTitle("Kalk");
      f.setVisible(true);
   }

   public static void main(String[] args) {
      // do wersji 1.4
      // new Kalk().init();

      // od wersji 1.5
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Kalk().init();
         }
      });
   }
}