package Dao;

import utils.JdbcHelper;
import Entity.Sach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author baomt
 */
public class SachDao extends QLThuVienDao<Sach, String> {

    final String INSERT_SQL = "INSERT INTO SACH(MaSACH,TenSACH,MATG,MANXB,TheLoai,MOTA) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE SACH SET TenSACH = ?, MATG = ?, MANXB = ?,TheLoai = ?,MOTA = ? WHERE MaSACH = ?";
    final String DELETE_SQL = "DELETE FROM SACH WHERE MaSACH = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SACH";
    final String SELECT_BYID_SQL = "SELECT * FROM SACH WHERE MaSACH = ?";
    final String SELECT_BY_TG_SQL = "Select s.MaTG,TenTG from SACH s Join TACGIA tg ON s.MaTG = tg.MaTG Where s.MaTG = ?";
    final String SELECT_BY_NXB_SQL = "Select s.MaNXB,TenNXB from Sach s Join NXB nxb ON s.MaNXB = nxb.MaNXB Where s.MaNXB = ?";
    final String SELECT_BY_Name_SQL = "SELECT * FROM SACH WHERE TenSACH like ?";

    public List<Sach> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM SACH WHERE TenSACH LIKE ?";
        return this.selectBySql(SQL, "%" + keyword + "%");
    }

    @Override
    public void insert(Sach entity) {
        String theLoaiString = String.join(",", entity.getTheLoai());
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaSACH(), entity.getTenSACH(), entity.getTacGIA(), entity.getNXB(), theLoaiString, entity.getMOTA());
    }

    @Override
    public void update(Sach entity) {
        String theLoaiString = String.join(",", entity.getTheLoai());
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenSACH(), entity.getTacGIA(), entity.getNXB(), theLoaiString, entity.getMOTA(), entity.getMaSACH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<Sach> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Sach selectById(String id) {
        List<Sach> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    //  @Override

   
    //@Override

    public Sach selectByname(String id) {
        List<Sach> list = selectBySql(SELECT_BY_Name_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSACH(rs.getString("MaSACH"));
                entity.setTenSACH(rs.getString("TenSACH"));
                entity.setTacGIA(rs.getString("MATG"));
                entity.setNXB(rs.getString("MANXB"));
                String theLoaiString = rs.getString("TheLoai");
                ArrayList<String> theLoaiList = new ArrayList<>(Arrays.asList(theLoaiString.split(",")));
                entity.setTheLoai(theLoaiList);
//                entity.setTheLoai(rs.getString("MaTL"));
                entity.setMOTA(rs.getString("MOTA"));
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

    public List<Object[]> selectByTacGia(String ma) {
        String[] cols = {"MaTG", "TenTG"};
        return this.getListOfArray(SELECT_BY_TG_SQL, cols, ma);
    }

    public List<Object[]> selectByNXB(String manxb) {
        String[] cols = {"MaNXB", "TenNXB"};
        return this.getListOfArray(SELECT_BY_NXB_SQL, cols, manxb);
    }
}
