/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.PhieuMuonCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class PhieuMuonCTDao extends QLThuVienDao<PhieuMuonCT, String> {

    final String INSERT_SQL = "INSERT CTPHIEUMUON(MaPM,MaSACH,SLSach,GHICHU) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CTPHIEUMUON SET MaSACH = ?, SLSach = ?,GHICHU = ? WHERE MaPM = ?";
    final String DELETE_SQL = "DELETE FROM CTPHIEUMUON WHERE MaPM = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM CTPHIEUMUON";
    final String SELECT_BYID_SQL = "SELECT * FROM CTPHIEUMUON WHERE MaPM = ?";
    final String SELECT_BYMASACH_SQL = "SELECT Sach.MaSach, Sach.TenSach FROM Sach JOIN CTPHIEUMUON ON CTPHIEUMUON.MaSACH LIKE CONCAT('%', Sach.MaSach, '%') WHERE CTPHIEUMUON.MaPM = ? GROUP BY Sach.MaSach, Sach.TenSach;";

    @Override
    public void insert(PhieuMuonCT entity) {
        String maSachString = String.join(",", entity.getMaSach());
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaPM(), maSachString, entity.getSoLuong(), entity.getGhiChu());
    }

    @Override
    public void update(PhieuMuonCT entity) {
        String maSachString = String.join(",", entity.getMaSach());
        JdbcHelper.executeUpdate(UPDATE_SQL, maSachString, entity.getSoLuong(), entity.getGhiChu(), entity.getMaPM());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<PhieuMuonCT> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuMuonCT selectById(String id) {
        List<PhieuMuonCT> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

//    public PhieuMuonCT selectByIdMaSach(String id) {
//        List<PhieuMuonCT> list = selectBySql(SELECT_BYMASACH_SQL, id);
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.get(0);
//    }
    @Override
    protected List<PhieuMuonCT> selectBySql(String sql, Object... args) {
        List<PhieuMuonCT> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                PhieuMuonCT entity = new PhieuMuonCT();
                entity.setMaPM(rs.getString("MaPM"));
                String maSachString = rs.getString("MaSach");
                ArrayList<String> maSachList = new ArrayList<>(Arrays.asList(maSachString.split(",")));
                entity.setMaSach(maSachList);
                entity.setSoLuong(rs.getInt("SLSach"));
                entity.setGhiChu(rs.getString("GhiChu"));

                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static ResultSet rs = null; // Trả về kết quả truy vấn

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

    public List<Object[]> selectBySach(String ma) {
        String[] cols = {"MaSach", "TenSach"};
        return this.getListOfArray(SELECT_BYMASACH_SQL, cols,ma);
    }

}
