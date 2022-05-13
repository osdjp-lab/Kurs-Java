class DowodOsobisty extends Dokument {

    DowodOsobisty(Osoba osoba) {
        super(osoba);
    }

    public boolean czyPasuje(String wzorzec) {
        return osoba.nazwisko.equalsIgnoreCase(wzorzec);
    }

    public String toString() {
        return osoba.toString();
    }
}