/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class ThongKeDao {

    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String THELOAI_SQL = "{CALL sp_TKTheoTG}";
    public static String THEOLOP_SQL = "{CALL sp_TKTheoLop (?)}";
    public static String THEOSINHVIEN_SQL = "{CALL sp_TKThang (?)}";
    public static String THEONXB_SQL = "{CALL sp_TheoNXB}";
//    public static String DIEMCHUYENDE_SQL = "{CALL sp_DiemChuyenDe}";
//    public static String TKDoanhThu_SQL = "{CALL sp_TKDoanhThu (?)}";
     public static String PIE_LOP = "SELECT LOP , COUNT(MaPM) SOLUONG FROM DOCGIA inner join PHIEUMUON on DOCGIA.MaDG= PHIEUMUON.MaDG GROUP BY LOP";
      public static String PIE_THEOTHANGNAM = "SELECT  MONTH(NGAYTAO) as THANG, COUNT(*) as SOLUONG FROM DOCGIA DG JOIN PHIEUMUON PM ON DG.MaDG = PM.MaDG group by  MONTH(NGAYTAO) ";
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getTacgia() {
        String[] cols = {"TenTG", "SoLuong", "NhieuNhat", "ItNhat"};
        return this.getListOfArray(THELOAI_SQL, cols);
    }

//    public List<Object[]> getTheoNam() {
//        String[] cols = {"Nam", "SoLuong", "NhieuNhat", "ItNhat"};
//        return this.getListOfArray(THEONAM_SQL, cols);
//    }
    public List<Object[]> getTheoLop(String lop) {
        String[] cols = {"TENDG", "MAPM", "NGAYMUON", "NGAYTRA", "TRANGTHAI"};
        return this.getListOfArray(THEOLOP_SQL, cols, lop);
    }

    public List<Object[]> getTheoSinhVien(Integer thang) {
        String[] cols = {"TenDG", "LOP", "TRANGTHAI", "NGAYTAO", "NGAYTRA"};
        return this.getListOfArray(THEOSINHVIEN_SQL, cols, thang);
    }

    public List<Object[]> getTheoNXB() {
        String[] cols = {"TENNXB", "SoLuong", "NhieuNhat", "ItNhat"};
        return this.getListOfArray(THEONXB_SQL, cols);
    }
//
//    public List<Object[]> getDiemChuyenDe() {
//        String[] cols = {"ChuyenDe", "SoHV", "CaoNhat", "ThapNhat", "TrungBinh"};
//        return this.getListOfArray(DIEMCHUYENDE_SQL, cols);
//    }
//
//    public List<Object[]> getTKDoanhThu(int nam) {
//        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "ThapNhat", "CaoNhat", "TrungBinh"};
//        return this.getListOfArray(TKDoanhThu_SQL, cols, nam);
//    }   
    
    public List<Object[]> pietheoLop() {
        String[] cols = {"LOP", "SoLuong"};
        return this.getListOfArray(PIE_LOP, cols);
    }
    

    
    public List<Object[]> pietheoThangNAm() {
        String[] cols = {"Thang", "SoLuong"};
        return this.getListOfArray(PIE_THEOTHANGNAM, cols);
    }
    
    public List<Object[]> Linetheothang() {
        String[] cols = {"Thang", "SoLuong"};
        return this.getListOfArray(PIE_THEOTHANGNAM, cols);
    }
}
