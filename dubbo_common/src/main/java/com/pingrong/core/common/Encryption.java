package com.pingrong.core.common;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5  十六进制  加密
 */
public class Encryption {
    public String jiaMi(String pwd) throws NoSuchAlgorithmException {
        //MD5
        MessageDigest instance = MessageDigest.getInstance("MD5");
        byte[] digest = instance.digest(pwd.getBytes());
        //String md5 = new String(digest);
        //十六进制
        char[] chars = Hex.encodeHex(digest);
        String shiLiu = new String(chars);
        return shiLiu;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Encryption encryption = new Encryption();
        System.out.println(encryption.jiaMi("wochenggongl"));
    }
}
