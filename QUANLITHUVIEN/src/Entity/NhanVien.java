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
public class NhanVien {

    private String MaNV;
    private String TenNV;
    private Date NGAYSINH;
    private String matKhau;
    private String SDT;
    private boolean GIOITINH;
    private String EMAIL;
    private String GHICHU;
    private boolean VAITRO;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, Date NGAYSINH, String matKhau, String SDT, boolean GIOITINH, String EMAIL, String GHICHU, boolean VAITRO) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NGAYSINH = NGAYSINH;
        this.matKhau = matKhau;
        this.SDT = SDT;
        this.GIOITINH = GIOITINH;
        this.EMAIL = EMAIL;
        this.GHICHU = GHICHU;
        this.VAITRO = VAITRO;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }

    public boolean isVAITRO() {
        return VAITRO;
    }

    public void setVAITRO(boolean VAITRO) {
        this.VAITRO = VAITRO;
    }

   

  

    
    
}
