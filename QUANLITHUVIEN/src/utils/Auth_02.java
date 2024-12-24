/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entity.NhanVien;
import static utils.Auth.user;

/**
 *
 * @author Admin
 */
public class Auth_02 {

     public static NhanVien Email = null;

    public static void clear() {
        Auth_02.Email = null;
    }

    public static boolean isLogin() {
        return Auth_02.Email != null;
    }

    
}