//package org.example;
//
//
//import org.mindrot.jbcrypt.BCrypt;
//
///**
// * Password encoder for the application
// */
//public class PasswordEncoder {
//
//    /**
//     * Encodes a password using BCrypt
//     * @param password Password to be encoded
//     * @return Encoded password
//     */
//    public static String encode(String password) {
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }
//
//    /**
//     * Checks if a password matches a hashed password
//     * @param password Password to be checked
//     * @param hashedPassword Hashed password to be checked against
//     * @return True if the password matches the hashed password, false otherwise
//     */
//    public static boolean matches(String password, String hashedPassword) {
//        return BCrypt.checkpw(password, hashedPassword);
//    }
//}
//
