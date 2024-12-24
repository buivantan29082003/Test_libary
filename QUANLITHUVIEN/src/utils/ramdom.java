/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.security.SecureRandom;

/**
 *
 * @author Admin
 */
public class ramdom {
    static final String az = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rd = new SecureRandom();
    
    public  String soNgauNHIEN (int n){
        StringBuilder str = new StringBuilder(n);
        for(int i = 0; i < n;i++){
            str.append(az.charAt(rd.nextInt(az.length())));
        }
        return str.toString();
    }
}
