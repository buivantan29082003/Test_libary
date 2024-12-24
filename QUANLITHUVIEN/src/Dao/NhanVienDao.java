/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import utils.JdbcHelper;
import Entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baomt
 */
public class NhanVienDao extends QLThuVienDao<NhanVien, String> {

    final String INSERT_SQL = "INSERT INTO NHANVIEN(MaNV,TenNV,NGAYSINH,SDT,GIOITINH,MatKhau,EMAIL,GHICHU,VAITRO) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NHANVIEN SET TenNV = ?, NGAYSINH = ?, SDT = ?, GIOITINH = ?, MatKhau = ?,EMAIL = ?, GHICHU = ?, VAITRO = ? WHERE MaNV = ?";
    final String UPDATE_LayLaiMatKhau = "UPDATE NHANVIEN SET MatKhau = ? WHERE EMAIL = ?";

    final String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MaNV = ?";
    final String SELECT_BY_Pas_SQL = "select * from NHANVIEN where MatKhau = ?";
    final String SELECT_BY_ID_EMAIL = "SELECT * FROM NHANVIEN WHERE EMAIL = ?";
    final String SELECT_BY_ID_SDT = "SELECT * FROM NHANVIEN WHERE SDT = ?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getTenNV(),
                entity.getNGAYSINH(),
                entity.getSDT(),
                entity.isGIOITINH(),
                entity.getMatKhau(),
                entity.getEMAIL(),
                entity.getGHICHU(),
                entity.isVAITRO());

    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getTenNV(),
                entity.getNGAYSINH(),
                entity.getSDT(),
                entity.isGIOITINH(),
                entity.getMatKhau(),
                entity.getEMAIL(),
                entity.getGHICHU(),
                entity.isVAITRO(),
                entity.getMaNV());
    }

    public void updateMatKhau(NhanVien entity) {
        JdbcHelper.executeUpdate(UPDATE_LayLaiMatKhau,
                entity.getMatKhau(),
                entity.getEMAIL());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    // @Override
    public NhanVien selectByMail(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_EMAIL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public NhanVien selectByPassword(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_Pas_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public NhanVien selectByEmail(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_EMAIL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public NhanVien selectBySDT(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SDT, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setNGAYSINH(rs.getDate("NGAYSINH"));
                entity.setMatKhau(rs.getString("MATKHAU"));
                entity.setSDT(rs.getString("SDT"));
                entity.setGIOITINH(rs.getBoolean("GIOITINH"));
                entity.setEMAIL(rs.getString("EMAIL"));
                entity.setGHICHU(rs.getString("GHICHU"));
                entity.setVAITRO(rs.getBoolean("VAITRO"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
