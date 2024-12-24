/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.DocGia;
import Entity.NhanVien;
import Entity.Sach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class DocGiaDao extends QLThuVienDao<DocGia, String>{
    final String INSERT_SQL = "INSERT INTO DOCGIA(MaDG,TENDG,SDT,LOP,NGAYSINH,GIOITINH,MANV) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE DOCGIA SET TENDG = ?, SDT = ?, LOP = ?,NGAYSINH = ?,GIOITINH = ?,MANV = ? WHERE MaDG = ?";
    final String DELETE_SQL = "DELETE FROM DOCGIA WHERE MaDG = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM DOCGIA ";
    final String SELECT_BYID_SQL = "SELECT * FROM DOCGIA WHERE MaDG = ?";
        final String SELECT_BY_SDT_SQL = "SELECT * FROM DOCGIA WHERE SDT = ?";
        final String SELECT_SQL_LOP = "SELECT * FROM DOCGIA WHERE LOP = ?";

    
       public DocGia selectBySDT(String id) {
        List<DocGia> list = selectBySql(SELECT_BY_SDT_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

      public List<DocGia> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM DOCGIA WHERE TENDG LIKE ?";
        return this.selectBySql(SQL, "%" + keyword + "%");
    }
    @Override
    public void insert(DocGia entity) {
    JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaDG(), entity.getTenDG(), entity.getSDT(), entity.getLOP(), entity.getNGAYSINH(), entity.isGIOITINH(), entity.getMANV());
    }

    @Override
    public void update(DocGia entity) {
         JdbcHelper.executeUpdate(UPDATE_SQL,  entity.getTenDG(), entity.getSDT(), entity.getLOP(), entity.getNGAYSINH(), entity.isGIOITINH(), entity.getMANV(),entity.getMaDG());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<DocGia> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DocGia selectById(String id) {
        List<DocGia> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<DocGia> selectBySql(String sql, Object... args) {
         List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                DocGia entity = new DocGia();
                entity.setMaDG(rs.getString("MaDG"));
                entity.setTenDG(rs.getString("TenDG"));
                entity.setSDT(rs.getString("SDT"));
                entity.setLOP(rs.getString("LOP"));
                entity.setNGAYSINH(rs.getDate("NGAYSINH"));
                entity.setGIOITINH(rs.getBoolean("GIOITINH"));
                 entity.setMANV(rs.getString("MANV"));

                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
