/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.PhieuNhap;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class PhieuNhapDAO extends AbsDAO<PhieuNhap> {

    public List<Object[]> loadLaiDS() {
        String selectSql = "select idPhieuNhap,TenNhaCungCap,NgayNhap,TongTien,TrangThai,SoLuong from PhieuNhap join NhaCungCap on PhieuNhap.idNhaCungCap = NhaCungCap.idNhaCungCap";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> search(String id) {
        String selectSql = "select idPhieuNhap,TenNhaCungCap,NgayNhap,TongTien,TrangThai,SoLuong from PhieuNhap join NhaCungCap on PhieuNhap.idNhaCungCap = NhaCungCap.idNhaCungCap where idPhieuNhap = ? ";
        List<Object[]> data = getRawValues(selectSql, id);
        return data;
    }
}
