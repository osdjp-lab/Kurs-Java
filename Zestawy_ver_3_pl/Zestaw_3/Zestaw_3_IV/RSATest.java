import java.io.*;
import java.security.*;
import javax.crypto.*;

public class RSATest {
    public static void main(String args[]) throws Exception {
        System.out.println("zaczyna rejestrowac provider");
        Provider prov = new org.bouncycastle.jce.provider.BouncyCastleProvider();
        Security.addProvider(prov);

        System.out.println("zaczyna generowac generator pary kluczy");
        KeyPairGenerator kpgen = KeyPairGenerator.getInstance("RSA", "BC");
        kpgen.initialize(1024, new java.security.SecureRandom());

        System.out.println("zaczyna generowac pare kluczy");
        KeyPair pair = kpgen.genKeyPair();

        System.out.println("zaczyna generowac klucz prywatny");
        PrivateKey priv = pair.getPrivate();

        System.out.println("zaczyna generowac klucz publiczny");
        PublicKey pub = pair.getPublic();

        // -- CipherStream: szyfrowanie --
        System.out.println("zaczyna generowac cipher");
        javax.crypto.Cipher c1 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        c1.init(Cipher.ENCRYPT_MODE, pub);

        System.out.println("zaczyna zestawiac strumien wyjsciowy");
        ObjectOutputStream out = new ObjectOutputStream(new CipherOutputStream(new FileOutputStream("plik.txt"), c1));

        System.out.println("zaczyna zapisywac obiekt do strumienia");
        out.writeObject(new String("pozdrowienia od cioci"));

        out.flush();
        out.close();

        // -- CipherStream: deszyfrowanie --
        System.out.println("zaczyna generowac cipher");
        javax.crypto.Cipher c2 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        c2.init(Cipher.DECRYPT_MODE, priv);

        System.out.println("zaczyna zestawiac strumien wejsciowy");
        ObjectInputStream in = new ObjectInputStream(new CipherInputStream(new FileInputStream("plik.txt"), c2));

        System.out.println("zaczyna czytac obiekt ze strumienia");
        String str = (String) in.readObject();

        System.out.println("\n-- " + str + " --\n");
        in.close();
    }
}