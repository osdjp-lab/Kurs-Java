import java.awt.*;
import java.awt.geom.*;

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
        // dy = -dy;
        // }

        // Wersja 2
        // Boki
        // Kulka od góry belki
        if (p.a.y + p.a.height == p.b.y &&
                p.a.x + p.a.width / 2 >= p.b.x &&
                p.a.x + p.a.width / 2 <= p.b.x + p.b.width) {
            dy = -dy;
        }
        // Kulka od dołu belki
        if (p.a.y == p.b.y + p.b.height &&
                p.a.x + p.a.width / 2 >= p.b.x &&
                p.a.x + p.a.width / 2 <= p.b.x + p.b.width) {
            dy = -dy;
        }
        // Kulka po lewej stronie belki
        if (p.a.x + p.a.width == p.b.x &&
                p.a.y + p.a.height / 2 >= p.b.y &&
                p.a.y + p.a.height / 2 <= p.b.y + p.b.height) {
            dx = -dx + (int) p.b.dx;
        }
        // Kulka po prawej stronie belki
        if (p.a.x == p.b.x + p.b.width &&
                p.a.y + p.a.height / 2 >= p.b.y &&
                p.a.y + p.a.height / 2 <= p.b.y + p.b.height) {
            dx = -dx + (int) p.b.dx;
        }
        // Rogi
        // Kulka od lewego górnego rogu
        if (p.a.x + p.a.width > p.b.x && // Lewo
                p.a.x + p.a.width / 2 < p.b.x && // Prawo
                p.a.y + p.a.height > p.b.y && // Góra
                p.a.y + p.a.height / 2 < p.b.y) { // Dół
            dx = -dx;
            dy = -dy;
        }
        // Kulka od prawego górnego rogu
        if (p.a.x + p.a.width / 2 > p.b.x + p.b.width && // Lewo
                p.a.x < p.b.x + p.b.width && // Prawo
                p.a.y + p.a.height > p.b.y && // Góra
                p.a.y + p.a.height / 2 < p.b.y) { // Dół
            dx = -dx;
            dy = -dy;
        }
        // Kulka od lewego dolnego rogu
        if (p.a.x + p.a.width > p.b.x && // Lewo
                p.a.x + p.a.width / 2 < p.b.x && // Prawo
                p.a.y + p.a.height / 2 > p.b.y + p.b.height && // Góra
                p.a.y < p.b.y + p.b.height) { // Dół
            dx = -dx;
            dy = -dy;
        }
        // Kulka od prawego dolnego rogu
        if (p.a.x + p.a.width / 2 > p.b.x + p.b.width && // Lewo
                p.a.x < p.b.x + p.b.width && // Prawo
                p.a.y + p.a.height / 2 > p.b.y + p.b.height && // Góra
                p.a.y < p.b.y + p.b.height) { // Dół
            dx = -dx;
            dy = -dy;
        }

        // Interakcja z klockami
        if (!p.k.isEmpty()) {
            for (int i = 0; i < p.k.size(); i++) {
                if (p.a.intersects(p.k.get(i)) && p.vis.get(i)) {
                    p.vis.set(i, false);
                    p.dodaj_punkt();
                    dy = -dy;
                    dx = -dx;
                }
            }
        }

        p.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
}
