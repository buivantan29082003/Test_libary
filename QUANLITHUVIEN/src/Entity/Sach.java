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
public class Sach {

  private String MaSACH;
    private String TenSACH;
    private String TacGIA;
    private String NXB;
    private String MOTA;
    private String Data;
//    private String TheLoai;
    
    private ArrayList<String> theLoai;

    public ArrayList<String> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(ArrayList<String> theLoai) {
        this.theLoai = theLoai;
    }

    public Sach() {
    }

    public Sach(String MaSACH, String TenSACH, String TacGIA, String NXB, String MOTA, ArrayList<String> theLoai,String Data) {
        this.MaSACH = MaSACH;
        this.TenSACH = TenSACH;
        this.TacGIA = TacGIA;
        this.NXB = NXB;
        this.MOTA = MOTA;
        this.theLoai = theLoai;
        this.Data=Data;
    }

    public String getMaSACH() {
        return MaSACH;
    }

    public void setMaSACH(String MaSACH) {
        this.MaSACH = MaSACH;
    }

    public String getTenSACH() {
        return TenSACH;
    }

    public void setTenSACH(String TenSACH) {
        this.TenSACH = TenSACH;
    }

    public String getTacGIA() {
        return TacGIA;
    }

    public void setTacGIA(String TacGIA) {
        this.TacGIA = TacGIA;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
     
 


}
