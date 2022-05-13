public class Prostokat extends Figura {
   double dlugosc;
   double szerokosc;

   public Prostokat(double dlugosc, double szerokosc) {
      this.dlugosc = dlugosc;
      this.szerokosc = szerokosc;
   }

   double pole() {
      return dlugosc * szerokosc;
   }

   double obwod() {
      return 2 * dlugosc + 2 * szerokosc;
   }

   public String toString() {
      return "Prostokat o wymiarach " + dlugosc + " x " + szerokosc;
   }
}