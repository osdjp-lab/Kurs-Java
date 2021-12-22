import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class DesTest {
   public static void main(String args[]) throws Exception {
      String msg = "pozdrowienia od cioci";

      String passwd = "tajnehaslo";
      byte[] b = passwd.getBytes();

      // -- generowanie klucza --
      System.out.println("tworzy generator kluczy");
      KeyGenerator kgen = KeyGenerator.getInstance("DES");
      kgen.init(new java.security.SecureRandom(b));

      System.out.println("generuje klucz");
      SecretKey key = kgen.generateKey();

      // -- szyfrowanie --
      System.out.println("tworzy obiekt klasy Cipher");
      javax.crypto.Cipher c1 = javax.crypto.Cipher.getInstance("DES");

      System.out.println("inicjuje cipher do szyfrowania");
      c1.init(Cipher.ENCRYPT_MODE, key);

      ObjectOutputStream out;
      out = new ObjectOutputStream(new CipherOutputStream(new FileOutputStream("plik.txt"), c1));
      out.writeObject(msg);
      out.flush();
      out.close();

      // -- deszyfrowanie --
      System.out.println("tworzy obiekt klasy Cipher");
      javax.crypto.Cipher c2 = javax.crypto.Cipher.getInstance("DES");

      System.out.println("inicjuje cipher do deszyfrowania");
      c2.init(Cipher.DECRYPT_MODE, key);

      ObjectInputStream in;
      in = new ObjectInputStream(new CipherInputStream(new FileInputStream("plik.txt"), c2));
      String str = (String) in.readObject();
      in.close();

      System.out.println("\n-- " + str + " --\n");
   }
}