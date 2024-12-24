/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author baomt
 */
public class PhieuMuon {
   private String MaPM;
    private Date NGAYTAO;
    private Date NGAYTRA;
    private boolean TRANGTHAI;
    private String MaNV;
    private String MaDG;

    public PhieuMuon() {
    }

    public PhieuMuon(String MaPM, Date NGAYTAO, Date NGAYTRA, boolean TRANGTHAI, String MaNV, String MaDG) {
        this.MaPM = MaPM;
        this.NGAYTAO = NGAYTAO;
        this.NGAYTRA = NGAYTRA;
        this.TRANGTHAI = TRANGTHAI;
        this.MaNV = MaNV;
        this.MaDG = MaDG;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }

    public Date getNGAYTAO() {
        return NGAYTAO;
    }

    public void setNGAYTAO(Date NGAYTAO) {
        this.NGAYTAO = NGAYTAO;
    }

    public Date getNGAYTRA() {
        return NGAYTRA;
    }

    public void setNGAYTRA(Date NGAYTRA) {
        this.NGAYTRA = NGAYTRA;
    }

    public boolean isTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    
}