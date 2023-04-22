package edu.guilford;

/**
 *
 * @author bousabacw
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey) { // This is the method to set your key for encryption and decryption
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8"); // This takes the string and converts it to a byte array
            sha = MessageDigest.getInstance("SHA-1"); // This converts the bytes into a SHA-1 hash for readability
            key = sha.digest(key); // The hash code is digested and stored in the key variable
            key = Arrays.copyOf(key, 16); // This grabs the first 16 characters of the hash code
            secretKey = new SecretKeySpec(key, "AES"); // This creates a new secret key using the 16 characters
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret); // This sets the key to the secret key
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // These lines create a cipher and set the mode
                                                                        // to encrypt
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) { // The above line encrypts the key and returns it as a string
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret); // This sets the key to the secret key
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); // These lines create a cipher and set the mode
                                                                        // to decrypt
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) { // The above line decrypts the key and returns it as a string
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
