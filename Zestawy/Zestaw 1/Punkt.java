public class Punkt {
    double x;
    double y;

    Punkt()
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    Punkt(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "[x: "+x+", y: "+y+"]";
    }

    public void przesun(double dx, double dy)
    {
        x += dx;
        y += dy;
    }
}
