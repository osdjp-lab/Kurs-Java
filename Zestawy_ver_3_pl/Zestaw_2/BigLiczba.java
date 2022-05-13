/**
 * Opisuje duza liczbe.
 * 
 * @author Oscar Szumiak
 */
public class BigLiczba {
    int[] cyfry;

    BigLiczba(){
        this.cyfry = new int[8];
    }

    BigLiczba(String cyfry) {
        this.cyfry = new int[cyfry.length()];
        for(int i=0; i<cyfry.length(); i++) {
            this.cyfry[i] = Character.getNumericValue(cyfry.charAt(i));
        }
    }

    public boolean czyPodzielna() {

    }

    public boolean czyPierwsza() {

    }
    
}
