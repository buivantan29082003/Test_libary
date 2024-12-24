/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author baomt
 */
public class PhieuMuonCT {

    private String MaPM;
    private int SoLuong;
    private String GhiChu;
//    private String MaSach;

    private ArrayList<String> MaSach;

    public ArrayList<String> getMaSach() {
        return MaSach;
    }

    public void setMaSach(ArrayList<String> MaSach) {
        this.MaSach = MaSach;
    }

    public PhieuMuonCT() {
    }

    public PhieuMuonCT(String MaPM, int SoLuong, String GhiChu, ArrayList<String> MaSach) {
        this.MaPM = MaPM;
        this.SoLuong = SoLuong;
        this.GhiChu = GhiChu;
        this.MaSach = MaSach;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}
