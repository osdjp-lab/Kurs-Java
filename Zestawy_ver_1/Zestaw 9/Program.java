import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

class Kulka extends Ellipse2D.Float {
    Plansza p;
    int dx, dy;
    int cdx, cdy;

    Kulka(Plansza p, int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;

        this.p = p;
        this.cdx = dx;
        this.cdy = dy;
        this.dx = dx;
        this.dy = dy;
    }

    void nextKrok() {
        x += dx;
        y += dy;

        if (getMinX() < 0 || getMaxX() > p.getWidth())
            dx = -dx;
        if (getMinY() < 0 || getMaxY() > p.getHeight())
            dy = -dy;

        // Interakcja z belką
        // p.a - kulka
        // p.b - belka

        // Wersja 1
        // if (p.a.intersects(p.b)) {
        //     dy = -dy;
        // }

        // Wersja 2
        // Boki
        // Kulka od góry belki
        if (p.a.y + p.a.height == p.b.y &&
            p.a.x + p.a.width/2 >= p.b.x &&
            p.a.x + p.a.width/2 <= p.b.x + p.b.width) {
            dy = -dy;
        }
        // Kulka od dołu belki
        if (p.a.y == p.b.y + p.b.height &&
            p.a.x + p.a.width/2 >= p.b.x &&
            p.a.x + p.a.width/2 <= p.b.x + p.b.width) {
            dy = -dy;
        }
        // Kulka po lewej stronie belki
        if (p.a.x + p.a.width == p.b.x &&
            p.a.y + p.a.height/2 >= p.b.y &&
            p.a.y + p.a.height/2 <= p.b.y + p.b.height) {
            dx = -dx + (int) p.b.dx;
        }
        // Kulka po prawej stronie belki
        if (p.a.x == p.b.x + p.b.width &&
            p.a.y + p.a.height/2 >= p.b.y &&
            p.a.y + p.a.height/2 <= p.b.y + p.b.height) {
            dx = -dx + (int) p.b.dx;
        }
        // Rogi
        // Kulka od lewego górnego rogu
        if (p.a.x + p.a.width > p.b.x &&  // Lewo
            p.a.x + p.a.width/2 < p.b.x &&  // Prawo
            p.a.y + p.a.height > p.b.y &&  // Góra
            p.a.y + p.a.height/2 < p.b.y) {  // Dół
            dx = -dx;
            dy = -dy;
        }
        // Kulka od prawego górnego rogu
        if (p.a.x + p.a.width/2 > p.b.x + p.b.width &&  // Lewo
            p.a.x < p.b.x + p.b.width &&  // Prawo
            p.a.y + p.a.height > p.b.y &&  // Góra
            p.a.y + p.a.height/2 < p.b.y) {  // Dół
            dx = -dx;
            dy = -dy;
        }
        // Kulka od lewego dolnego rogu
        if (p.a.x + p.a.width > p.b.x &&  // Lewo
            p.a.x + p.a.width/2 < p.b.x &&  // Prawo
            p.a.y + p.a.height/2 > p.b.y + p.b.height &&  // Góra
            p.a.y < p.b.y + p.b.height) {  // Dół
            dx = -dx;
            dy = -dy;
        }
        // Kulka od prawego dolnego rogu
        if (p.a.x + p.a.width/2 > p.b.x + p.b.width &&  // Lewo
            p.a.x < p.b.x + p.b.width &&  // Prawo
            p.a.y + p.a.height/2 > p.b.y + p.b.height &&  // Góra
            p.a.y < p.b.y + p.b.height) {  // Dół
            dx = -dx;
            dy = -dy;
        }

        // Interakcja z klockami
        if (!p.k.isEmpty()) {
            for (int i=0; i < p.k.size(); i++) {
                if (p.a.intersects(p.k.get(i)) && p.vis.get(i)) {
                    p.vis.set(i, false);
                    dy = -dy;
                    dx = -dx;
                }
            }
        } 

        p.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
}

class Klocek extends Rectangle2D.Float {

    Klocek(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}

class SilnikKulki extends Thread {
    Kulka a;

    SilnikKulki(Kulka a) {
        this.a = a;
        start();
    }

    public void run() {
        try {
            while (true) {
                a.nextKrok();
                sleep(15);
            }
        } catch (InterruptedException e) {
        }
    }
}

class Belka extends Rectangle2D.Float {
    float dx;

    Belka(int x) {
        this.x = x;
        this.dx = 0;
        this.y = 250;  // 170
        this.width = 60;
        this.height = 10;
    }

    void setX(int x) {
        this.dx = x - this.x;
        this.x = x;
    }
}

class Plansza extends JPanel implements MouseMotionListener {
    Belka b;
    Kulka a;
    SilnikKulki s;
    Vector<Klocek> k = new Vector<Klocek>();
    Vector<Boolean> vis = new Vector<Boolean>();
    // Klocek[] k;
    int x_limit;
    int y_limit;

    Plansza(int x_limit, int y_limit) {
        super();
        addMouseMotionListener(this);

        b = new Belka(100);
        a = new Kulka(this, 100, 170, 1, 1);  // 100, 100
        s = new SilnikKulki(a);
        this.x_limit = x_limit;
        this.y_limit = y_limit;
        // k = new Klocek[x_limit * y_limit];
        Klocki();
    }

    private void Klocki() {
        // int count = 0;
        int k_width = 400 / x_limit;
        int k_height = 160 / y_limit;  // 100
        int start_x = k_width*7/10;
        int start_y = k_height*7/10;
        for (int i=start_x; i<400-2*x_limit; i+=k_width) {
            for (int j=start_y; j<160-2*y_limit-1; j+=k_height) {  // 100
                k.add(new Klocek(i, j, k_width*8/10, k_height*8/10));
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
            for (int i=0; i < k.size(); i++) {
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
}

public class Program {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Plansza p;
                p = new Plansza(20, 12);  // 20, 10

                JFrame jf = new JFrame();
                jf.add(p);
                jf.setTitle("Test grafiki");
                jf.setSize(400, 370);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
        });
    }
}