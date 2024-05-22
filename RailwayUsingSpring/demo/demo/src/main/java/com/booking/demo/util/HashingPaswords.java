package com.booking.demo.util;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.JDBCType;

public class HashingPaswords {
    public static String hashPasswords(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static Boolean checkPassword(String password, String hashPassword){
        return BCrypt.checkpw(password, hashPassword);
    }
}
