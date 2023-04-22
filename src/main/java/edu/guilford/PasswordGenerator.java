package edu.guilford;

public class PasswordGenerator {
    public static void main(String[] args) {

        // Instantiate the 1st user and get their info

        User user1 = new User();
        user1.getUserInfo();

        // Instantiate the 2nd user and get their info

        User user2 = new User();
        user2.getUserInfo();

        // Create passwords for both users

        user1.createPassword();
        user2.createPassword();

        // Print out the passwords for both users

        System.out.println("User 1's password is: " + user1.getPassword());
        System.out.println("User 2's password is: " + user2.getPassword());

        // Set the final 5 characters of the password to be the secret key for
        // encryption

        String secretKey1 = user1.getPassword().substring(user1.getPassword().length() - 5);
        String secretKey2 = user2.getPassword().substring(user2.getPassword().length() - 5);

        // Print out the secret keys

        System.out.println("\nUser 1's secret key is: " + secretKey1);
        System.out.println("User 2's secret key is: " + secretKey2);

        // Encrypt the passwords using the secret key

        String encryptedPassword1 = AES.encrypt(user1.getPassword(), secretKey1);
        String encryptedPassword2 = AES.encrypt(user2.getPassword(), secretKey2);

        // Print out the encrypted passwords

        System.out.println("\nUser 1's encrypted password is: " + encryptedPassword1);
        System.out.println("User 2's encrypted password is: " + encryptedPassword2);

        // Decrypt the passwords using the secret key

        String decryptedPassword1 = AES.decrypt(encryptedPassword1, secretKey1);
        String decryptedPassword2 = AES.decrypt(encryptedPassword2, secretKey2);

        // Print out the decrypted passwords

        System.out.println("\nUser 1's decrypted password is: " + decryptedPassword1);
        System.out.println("User 2's decrypted password is: " + decryptedPassword2);

    }
}
