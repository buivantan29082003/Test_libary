/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import main.Quanlithuvien;
import Entity.Sach;
import static utils.Auth.user;

/**
 *
 * @author Admin
 */
public class Auth_Sach {

     public static Sach ten = null;

    public static void clear() {
        Auth_Sach.ten = null;
    }

    public static boolean isLuu() {
        return Auth_Sach.ten != null;
    }

    
}