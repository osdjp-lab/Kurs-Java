import java.awt.geom.*;

class Belka extends Rectangle2D.Float {
    float dx;

    Belka(int x) {
        this.x = x;
        this.dx = 0;
        this.y = 250; // 170
        this.width = 60;
        this.height = 10;
    }

    void setX(int x) {
        this.dx = x - this.x;
        this.x = x;
    }
}