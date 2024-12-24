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
public class DocGia {
     private String MaDG;
    private String TenDG;
    private String SDT;
    private String LOP;
    private Date NGAYSINH;
    private boolean GIOITINH;
    private String MANV;

    public DocGia() {
    }


    public DocGia(String MaDG, String TenDG, String SDT, String LOP, Date NGAYSINH, boolean GIOITINH, String MANV) {
        this.MaDG = MaDG;
        this.TenDG = TenDG;
        this.SDT = SDT;
        this.LOP = LOP;
        this.NGAYSINH = NGAYSINH;
        this.GIOITINH = GIOITINH;
        this.MANV = MANV;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getTenDG() {
        return TenDG;
    }

    public void setTenDG(String TenDG) {
        this.TenDG = TenDG;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLOP() {
        return LOP;
    }

    public void setLOP(String LOP) {
        this.LOP = LOP;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }
   

}
