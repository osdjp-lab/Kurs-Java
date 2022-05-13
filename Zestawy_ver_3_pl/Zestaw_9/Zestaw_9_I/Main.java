import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Plansza p;
                p = new Plansza(20, 12); // 20, 10

                JFrame jf = new JFrame();
                jf.add(p);
                jf.setTitle("Test grafiki");
                jf.setSize(400, 370);
                jf.setResizable(false);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
        });
    }
}