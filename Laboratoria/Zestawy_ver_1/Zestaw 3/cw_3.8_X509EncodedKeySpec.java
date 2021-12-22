// Rozwiazanie cw. 3.8 - Szymon Krolik i Daniel Lezniak

package com.company.klasyBiblioteczne;
import java.io.*;
import java.security.*;
import javax.crypto.*;

import java.security.Provider;
import java.security.Security;
import java.util.Scanner;

public class X509EncodedKeySpec {
    private PrivateKey priv;
    private  KeyPair pair;
    private  PublicKey pub;

    /*
        UWAGA:
        Działa jedynie gdy utworzymy obiekt, szyfrujmey i odczytujemy w jednym odpaleniu programu.
        Nie bedzie działac przy drugim odpaleniu poniewaz klucz, który jest wygenerowany nie jest nigdzie przechowywany
        PLik jest zaszyfrowany starym kluczem
     */

    public X509EncodedKeySpec() throws NoSuchProviderException, NoSuchAlgorithmException {
        System.out.println("zaczyna rejestrowac provider");
        Provider prov = new org.bouncycastle.jce.provider.BouncyCastleProvider();
        Security.addProvider(prov);

        System.out.println("zaczyna generowac generator pary kluczy");
        KeyPairGenerator kpgen = KeyPairGenerator.getInstance("RSA","BC");
        kpgen.initialize(1024, new java.security.SecureRandom());

        System.out.println("zaczyna generowac pare kluczy");
        this.pair = kpgen.genKeyPair();

        System.out.println("zaczyna generowac klucz prywatny");
        this.priv = pair.getPrivate();

        System.out.println("zaczyna generowac klucz publiczny");
        this.pub = pair.getPublic();
    }

    public void szyfruj(String nazwaPliku) throws NoSuchProviderException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, ClassNotFoundException {

        //-- CipherStream: szyfrowanie --
        System.out.println("zaczyna generowac cipher");
        javax.crypto.Cipher c1 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");
        c1.init(Cipher.ENCRYPT_MODE,pub);

        System.out.println("zaczyna zestawiac strumien wyjsciowy");
        ObjectOutputStream out=new ObjectOutputStream(new CipherOutputStream(new FileOutputStream(nazwaPliku),c1));

        System.out.println("zaczyna zapisywac obiekt do strumienia");
        Scanner in = new Scanner(System.in);
        out.writeObject(new String(in.nextLine()));

        out.flush();
        out.close();
    }

    public void deszyfrator(String nazwaPliku) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException, ClassNotFoundException {
        System.out.println("zaczyna generowac cipher");
        javax.crypto.Cipher c2 = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");
        c2.init(Cipher.DECRYPT_MODE,this.priv);

        System.out.println("zaczyna zestawiac strumien wejsciowy");
        ObjectInputStream in=new ObjectInputStream(new CipherInputStream(new FileInputStream(nazwaPliku),c2));

        System.out.println("zaczyna czytac obiekt ze strumienia");
        String str=(String)in.readObject();

        System.out.println("\n-- "+str+" --\n");
        in.close();
    }
}
