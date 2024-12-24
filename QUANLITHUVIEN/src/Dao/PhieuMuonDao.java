/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.PhieuMuon;
import Entity.Sach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import slideshow.phieumuon;
import utils.JdbcHelper;

/**
 *
 * @author baomt
 */
public class PhieuMuonDao extends QLThuVienDao<PhieuMuon, String> {

    final String INSERT_SQL = "INSERT PHIEUMUON(MaPM,TRANGTHAI,MaNV,MaDG,NGAYTAO,NGAYTRA) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE PHIEUMUON SET  TRANGTHAI = ?,MaNV = ?,MaDG = ?, NGAYTAO = ?, NGAYTRA = ? WHERE MaPM = ?";
    final String DELETE_SQL = "DELETE FROM PHIEUMUON WHERE MaPM = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM PHIEUMUON";
    final String SELECT_ALL_DESC_SQL = "select * from PHIEUMUON order by NGAYTAO desc";
    final String SELECT_ALL_ASC_SQL = "select * from PHIEUMUON order by NGAYTAO asc";
    final String SELECT_BYID_SQL = "SELECT * FROM PHIEUMUON WHERE MaPM = ?";
    final String SELECT_MONTHS_SQL = "	SELECT DISTINCT MONTH(NGAYTAO) Year FROM PHIEUMUON ORDER BY Year DESC";
    final String SELECT_ALL_ChuaTra_SQL = "select * from PHIEUMUON where TRANGTHAI = '0'";
    final String SELECT_ALL_DaTra_SQL = "select * from PHIEUMUON where TRANGTHAI = '1'";
    final String SELECT_BY_MaDG_SQL = "SELECT * FROM PHIEUMUON WHERE MaDG = ?";

    @Override
    public void insert(PhieuMuon entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaPM(), entity.isTRANGTHAI(), entity.getMaNV(), entity.getMaDG(), entity.getNGAYTAO(), entity.getNGAYTRA());
    }

    @Override
    public void update(PhieuMuon entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.isTRANGTHAI(), entity.getMaNV(), entity.getMaDG(), entity.getNGAYTAO(), entity.getNGAYTRA(), entity.getMaPM());

    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<PhieuMuon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    public List<PhieuMuon> selectAllDESC() {
        return selectBySql(SELECT_ALL_DESC_SQL);
    }

    public List<PhieuMuon> selectAllASC() {
        return selectBySql(SELECT_ALL_ASC_SQL);
    }

     public PhieuMuon selectByMa(String id) {
        List<PhieuMuon> list = selectBySql(SELECT_BY_MaDG_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<PhieuMuon> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM PHIEUMUON WHERE MaDG like ?";
        return this.selectBySql(SQL, "%" + keyword + "%");
    }

    @Override
    public PhieuMuon selectById(String id) {
        List<PhieuMuon> list = selectBySql(SELECT_BYID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                PhieuMuon entity = new PhieuMuon();
                entity.setMaPM(rs.getString("MaPM"));
                entity.setTRANGTHAI(rs.getBoolean("TRANGTHAI"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaDG(rs.getString("MaDG"));
                entity.setNGAYTAO(rs.getDate("NGAYTAO"));
                entity.setNGAYTRA(rs.getDate("NGAYTRA"));

                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Integer> selectByThang() {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(SELECT_MONTHS_SQL);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<PhieuMuon> selectAllChuaTra() {
        return selectBySql(SELECT_ALL_ChuaTra_SQL);
    }

    public List<PhieuMuon> selectAllDaTra() {
        return selectBySql(SELECT_ALL_DaTra_SQL);
    }

    public List<Integer> selectYears() {
        String Sql = "SELECT DISTINCT MONTH(NGAYTAO) MONTH FROM PHIEUMUON ORDER BY MONTH DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(Sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }

    public List<String> selectLop() {
        String Sql = "SELECT DISTINCT LOP  FROM DOCGIA ORDER BY LOP DESC";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(Sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }

}
