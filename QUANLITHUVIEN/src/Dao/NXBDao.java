/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.DocGia;
import Entity.NhanVien;
import Entity.Sach;
import Entity.NXB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class NXBDao extends QLThuVienDao<NXB, String>{
    final String INSERT_SQL = "INSERT INTO NXB(MaNXB,TENNXB) VALUES (?,?)";
    final String UPDATE_SQL = "UPDATE NXB SET TENNXB = ? WHERE MaNXB = ?";
    final String DELETE_SQL = "DELETE FROM NXB WHERE MaNXB = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NXB";
    final String SELECT_BYID_SQL = "SELECT * FROM NXB WHERE MaNXB = ?";
//        final String SELECT_BY_SDT_SQL = "SELECT * FROM DOCGIA WHERE SDT = ?";

    
//       public DocGia selectBySDT(String id) {
//        List<DocGia> list = selectBySql(SELECT_BY_SDT_SQL, id);
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.get(0);
//    }

//      public List<DocGia> selectByKeyword(String keyword) {
//        String SQL = "SELECT * FROM DOCGIA WHERE TENDG LIKE ?";
//        return this.selectBySql(SQL, "%" + keyword + "%");
//    }

    @Override
    public void insert(NXB entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNXB(),entity.getTenNXB());
    }

    @Override
    public void update(NXB entity) {
       JdbcHelper.executeUpdate(UPDATE_SQL,entity.getTenNXB(), entity.getMaNXB());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NXB> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NXB selectById(String id) {
         List<NXB> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NXB> selectBySql(String sql, Object... args) {
         List<NXB> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NXB entity = new NXB();
                entity.setMaNXB(rs.getString("MaNXB"));
                entity.setTenNXB(rs.getString("TenNXB"));


                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    
}
