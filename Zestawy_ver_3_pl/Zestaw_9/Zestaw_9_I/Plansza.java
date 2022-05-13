import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;

class Plansza extends JPanel implements MouseMotionListener {
    Kulka a;
    Belka b;
    SilnikKulki s;
    Vector<Klocek> k = new Vector<Klocek>();
    Vector<Boolean> vis = new Vector<Boolean>();
    int punkty;
    // Klocek[] k;
    int x_limit;
    int y_limit;

    Plansza(int x_limit, int y_limit) {
        super();
        addMouseMotionListener(this);

        b = new Belka(100);
        a = new Kulka(this, 100, 170, 1, 1); // 100, 100
        s = new SilnikKulki(a);
        this.x_limit = x_limit;
        this.y_limit = y_limit;
        punkty = 0;
        // k = new Klocek[x_limit * y_limit];
        Klocki();
    }

    private void Klocki() {
        // int count = 0;
        int k_width = 400 / x_limit;
        int k_height = 160 / y_limit; // 100
        int start_x = k_width * 7 / 10;
        int start_y = k_height * 7 / 10;
        for (int i = start_x; i < 400 - 2 * x_limit; i += k_width) {
            for (int j = start_y; j < 160 - 2 * y_limit - 1; j += k_height) { // 100
                k.add(new Klocek(i, j, k_width * 8 / 10, k_height * 8 / 10));
                vis.add(true);
                // count += 1;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.fill(a);
        g2d.fill(b);
        if (!k.isEmpty()) {
            for (int i = 0; i < k.size(); i++) {
                if (vis.get(i)) {
                    g2d.fill(k.get(i));
                }
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        b.setX(e.getX() - 50);
        repaint();
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void dodaj_punkt() {
        punkty += 1;
    }

    public int getpunkty() {
        return punkty;
    }
}