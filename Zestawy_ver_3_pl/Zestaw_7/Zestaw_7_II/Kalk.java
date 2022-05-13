import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Kalk implements ActionListener {
   JTextField t1;
   JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
   JButton bplus, bminus, bmult, bdiv;
   JButton bpow, bsqrt, bperc, binv;
   JButton bpm, bdot, bc, bce, bcl, brow;
   JButton bmc, bms, bmr;
   int sel = 0;
   double val_1 = 0.0;
   double val_2 = 0.0;
   double mem_buf = 0.0;
   boolean prev_brow = false;

   double parseValue() {
      double tmp = val_1;
      if (t1.getText().equals("")) {
         return tmp;
      } else {
         try {
            tmp = Integer.parseInt(t1.getText());
         } catch(NumberFormatException error1) {
            try {
               tmp = Double.parseDouble(t1.getText());
            } catch(NumberFormatException error2) {
               System.err.println(error2);
            }
         }
      }
      return tmp;
   }

   void setValue(Object target) {
      if (prev_brow) {
         t1.setText(((JButton) target).getText());
         prev_brow = false;
         sel = 0;
      } else {
         t1.setText(t1.getText() + ((JButton) target).getText());
      }
      t1.requestFocus();
   }

   public void actionPerformed(ActionEvent e) {
      Object target = e.getSource();

      // liczby

      if (target == b0) {
         setValue(target);
      }

      else if (target == b1) {
         setValue(target);
      }

      else if (target == b2) {
         setValue(target);
      }

      else if (target == b3) {
         setValue(target);
      }

      else if (target == b4) {
         setValue(target);
      }

      else if (target == b5) {
         setValue(target);
      }

      else if (target == b6) {
         setValue(target);
      }

      else if (target == b7) {
         setValue(target);
      }

      else if (target == b8) {
         setValue(target);
      }

      else if (target == b9) {
         setValue(target);
      }

      // operacje podstawowe

      else if (target == bplus) {
         val_1 = parseValue();
         t1.setText("");
         t1.requestFocus();
         prev_brow = false;
         sel = 1;
      }

      else if (target == bminus) {
         val_1 = parseValue();
         t1.setText("");
         t1.requestFocus();
         prev_brow = false;
         sel = 2;
      }

      else if (target == bmult) {
         val_1 = parseValue();
         t1.setText("");
         t1.requestFocus();
         prev_brow = false;
         sel = 3;
      }

      else if (target == bdiv) {
         val_1 = parseValue();
         t1.setText("");
         t1.requestFocus();
         prev_brow = false;
         sel = 4;
      }

      // inne operacje

      else if (target == bpow) {
         val_1 = parseValue();
         t1.setText(Double.toString(val_1 * val_1));
         t1.requestFocus();
      }

      else if (target == bsqrt) {
         val_1 = parseValue();
         if (val_1 >= 0) {
            t1.setText(Double.toString(Math.sqrt(val_1)));
         } else {
            t1.setText("NegativeSqrtError");
         }
         t1.requestFocus();
      }

      else if (target == bperc) {
         val_1 = parseValue();
         t1.setText(Double.toString(val_1 / 100));
         t1.requestFocus();
      }

      else if (target == binv) {
         val_1 = parseValue();
         t1.setText(Double.toString(1 / val_1));
         t1.requestFocus();
      }

      // bufor pamięci

      else if (target == bmc) {
         mem_buf = 0.0;
      }

      else if (target == bms) {
         val_1 = parseValue();
         mem_buf = val_1;
         t1.setText("");
         t1.requestFocus();
      }

      else if (target == bmr) {
         t1.setText(Double.toString(mem_buf));
         t1.requestFocus();
      }

      // działania

      else if (target == bpm) {
         val_1 = - parseValue();
         t1.setText(Double.toString(val_1));
         t1.requestFocus();
      }

      else if (target == bdot) {
         if (!t1.getText().contains(".")) {
            t1.setText(t1.getText() + ((JButton) target).getText());
         }
         t1.requestFocus();
      }

      else if (target == bce) {
         if (prev_brow) {
            val_1 = 0.0;
            val_2 = 0.0;
            prev_brow = false;
         }
         t1.setText("");
         t1.requestFocus();
      }

      else if (target == bc) {
         val_1 = 0.0;
         val_2 = 0.0;
         t1.setText("");
         t1.requestFocus();
      }

      else if (target == bcl) {
         String tmp = t1.getText();
         if (tmp != null && tmp.length() != 0) {
            t1.setText(tmp.substring(0, tmp.length() - 1));
         }
         t1.requestFocus();
      }

      else if (target == brow || target == t1) {
         String tmp;
         if (!prev_brow) {
            val_2 = parseValue();
         }
         if (sel == 1) {
            val_1 += val_2;
            tmp = Double.toString(val_1);
         } else if (sel == 2) {
            val_1 -= val_2;
            tmp = Double.toString(val_1);
         } else if (sel == 3) {
            val_1 *= val_2;
            tmp = Double.toString(val_1);
         } else if (sel == 4) {
            if (val_2 != 0) {
               val_1 /= val_2;
               tmp = Double.toString(val_1);
            } else {
               tmp = "ZeroDivisionError";
            }
         } else {
            tmp = Double.toString(val_1);
         }
         t1.setText(tmp);
         t1.requestFocus();
         prev_brow = true;
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

      // row 0

      t1 = new JTextField(15);
      t1.setEditable(false);
      t1.addActionListener(this);
      t1.setHorizontalAlignment(JTextField.RIGHT);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 5;
      gbc.ipadx = 0;
      gbc.ipady = 5;
      gbc.insets = new Insets(5, 5, 0, 5);
      gbl.setConstraints(t1, gbc);
      c.add(t1);

      // row 1

      JFrame m = new JFrame();
      Container mc = m.getContentPane();
      // mc.setLayout(new FlowLayout());
      GridBagLayout mgbl = new GridBagLayout();
      GridBagConstraints mgbc = new GridBagConstraints();
      mgbc.fill = GridBagConstraints.HORIZONTAL;
      mc.setLayout(mgbl);

      bmc = new JButton("MC");
      bmc.addActionListener(this);
      bmc.setFocusable(false);
      bmc.setToolTipText("Oproznij pamiec");
      mgbc.gridx = 0;
      mgbc.gridy = 0;
      mgbc.ipadx = 0;
      mgbc.ipady = 0;
      mgbc.weightx = 1;
      mgbc.fill = GridBagConstraints.HORIZONTAL;
      mgbc.insets = new Insets(5, 5, 0, 0);
      mgbl.setConstraints(bmc, mgbc);
      mc.add(bmc);

      bmr = new JButton("MR");
      bmr.addActionListener(this);
      bmr.setFocusable(false);
      bmr.setToolTipText("Przywolaj pamiec");
      mgbc.gridx = 1;
      mgbc.gridy = 0;
      mgbc.ipadx = 0;
      mgbc.ipady = 0;
      mgbc.fill = GridBagConstraints.HORIZONTAL;
      mgbc.insets = new Insets(5, 5, 0, 0);
      mgbl.setConstraints(bmr, mgbc);
      mc.add(bmr);

      bms = new JButton("MS");
      bms.addActionListener(this);
      bms.setFocusable(false);
      bms.setToolTipText("Zapisz do pamieci");
      mgbc.gridx = 2;
      mgbc.gridy = 0;
      mgbc.ipadx = 0;
      mgbc.ipady = 0;
      mgbc.fill = GridBagConstraints.HORIZONTAL;
      mgbc.insets = new Insets(5, 5, 0, 5);
      mgbl.setConstraints(bms, mgbc);
      mc.add(bms);

      // m.pack();

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.gridwidth = 4;
      gbc.insets = new Insets(5, 0, 0, 0);
      gbl.setConstraints(mc, gbc);
      c.add(mc);

      // row 2

      bperc = new JButton("%");
      bperc.addActionListener(this);
      bperc.setFocusable(false);
      bperc.setToolTipText("Procent");
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bperc, gbc);
      c.add(bperc);

      bce = new JButton("CE");
      bce.addActionListener(this);
      bce.setFocusable(false);
      bce.setToolTipText("Usun ostatnia zmienna");
      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bce, gbc);
      c.add(bce);

      bc = new JButton("C");
      bc.addActionListener(this);
      bc.setFocusable(false);
      bc.setToolTipText("Usun wszystko");
      gbc.gridx = 2;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bc, gbc);
      c.add(bc);

      bcl = new JButton("⌫");
      bcl.addActionListener(this);
      bcl.setFocusable(false);
      bcl.setToolTipText("Usun ostatni znak");
      gbc.gridx = 3;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 5);
      gbl.setConstraints(bcl, gbc);
      c.add(bcl);

      // row 3

      binv = new JButton("1/x");
      binv.addActionListener(this);
      binv.setFocusable(false);
      binv.setToolTipText("Odwrotnosc");
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(binv, gbc);
      c.add(binv);

      bpow = new JButton("x^2");
      bpow.addActionListener(this);
      bpow.setFocusable(false);
      bpow.setToolTipText("Potęga");
      gbc.gridx = 1;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bpow, gbc);
      c.add(bpow);

      bsqrt = new JButton("√x");
      bsqrt.addActionListener(this);
      bsqrt.setFocusable(false);
      bsqrt.setToolTipText("Pierwiastek");
      gbc.gridx = 2;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(bsqrt, gbc);
      c.add(bsqrt);

      bdiv = new JButton("÷");
      bdiv.addActionListener(this);
      bdiv.setFocusable(false);
      bdiv.setToolTipText("Dzielenie");
      gbc.gridx = 3;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 5);
      gbl.setConstraints(bdiv, gbc);
      c.add(bdiv);

      // row 4

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

      bmult = new JButton("×");
      bmult.addActionListener(this);
      bmult.setFocusable(false);
      bmult.setToolTipText("Mnożenie");
      gbc.gridx = 3;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 5);
      gbl.setConstraints(bmult, gbc);
      c.add(bmult);

      // row 5

      b4 = new JButton("4");
      b4.addActionListener(this);
      b4.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 5;
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
      gbc.gridy = 5;
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
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b6, gbc);
      c.add(b6);

      bminus = new JButton("-");
      bminus.addActionListener(this);
      bminus.setFocusable(false);
      bminus.setToolTipText("Odejmowanie");
      gbc.gridx = 3;
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 5);
      gbl.setConstraints(bminus, gbc);
      c.add(bminus);

      // row 6

      b1 = new JButton("1");
      b1.addActionListener(this);
      b1.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 6;
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
      gbc.gridy = 6;
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
      gbc.gridy = 6;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 0);
      gbl.setConstraints(b3, gbc);
      c.add(b3);

      bplus = new JButton("+");
      bplus.addActionListener(this);
      bplus.setFocusable(false);
      bplus.setToolTipText("Dodawanie");
      gbc.gridx = 3;
      gbc.gridy = 6;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 0, 5);
      gbl.setConstraints(bplus, gbc);
      c.add(bplus);

      // row 7

      bpm = new JButton("±");
      bpm.addActionListener(this);
      bpm.setFocusable(false);
      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 5, 0);
      gbl.setConstraints(bpm, gbc);
      c.add(bpm);

      b0 = new JButton("0");
      b0.addActionListener(this);
      b0.setFocusable(false);
      gbc.gridx = 1;
      gbc.gridy = 7;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 5, 0);
      gbl.setConstraints(b0, gbc);
      c.add(b0);

      bdot = new JButton(".");
      bdot.addActionListener(this);
      bdot.setFocusable(false);
      bdot.setToolTipText("Kropka");
      gbc.gridx = 2;
      gbc.gridy = 7;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 5, 0);
      gbl.setConstraints(bdot, gbc);
      c.add(bdot);

      brow = new JButton("=");
      brow.addActionListener(this);
      brow.setFocusable(false);
      brow.setToolTipText("Wykonaj dzialanie");
      gbc.gridx = 3;
      gbc.gridy = 7;
      gbc.gridwidth = 1;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.insets = new Insets(5, 5, 5, 5);
      gbl.setConstraints(brow, gbc);
      c.add(brow);

      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setTitle("Kalkulator");
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