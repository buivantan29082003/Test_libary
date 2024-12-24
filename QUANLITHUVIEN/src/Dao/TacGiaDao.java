/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.PhieuMuon;
import Entity.TacGiaEn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class TacGiaDao extends QLThuVienDao<TacGiaEn, String> {

    final String INSERT_SQL = "INSERT TacGia(MaTG,TenTG) VALUES (?,?)";
    final String UPDATE_SQL = "UPDATE TacGia SET  TenTG = ? WHERE MaTG = ?";
    final String DELETE_SQL = "DELETE FROM TacGia WHERE MaTG = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM TacGia";
    final String SELECT_BYID_SQL = "SELECT * FROM TacGia WHERE MaTG = ?";

    @Override
    public void insert(TacGiaEn entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaTG(), entity.getTenTG());

    }

    @Override
    public void update(TacGiaEn entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenTG(), entity.getMaTG());

    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<TacGiaEn> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TacGiaEn selectById(String id) {
        List<TacGiaEn> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    protected List<TacGiaEn> selectBySql(String sql, Object... args) {
        List<TacGiaEn> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                TacGiaEn entity = new TacGiaEn();
                entity.setMaTG(rs.getString("MaTG"));
                entity.setTenTG(rs.getString("TenTG"));

                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
