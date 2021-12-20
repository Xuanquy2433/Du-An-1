/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.PhieuBaoHanh;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class PhieuBaoHanhDAO extends AbsDAO<PhieuBaoHanh> {

    public List<Object[]> loadLaiDS() {
        String selectSql = "select idPhieuBaoHanh,HoaDon.idHoaDon,TenKhachHang,TenNhanVien,HoaDon.NgayLap,LyDo,ThoiGianBaoTri,ChiPhiBaoHanh,PhieuBaoHanh.GhiChu,PhieuBaoHanh.TrangThai  from PhieuBaoHanh join KhachHang on PhieuBaoHanh.idKhachHang = KhachHang.idKhachHang join HoaDon on PhieuBaoHanh.idHoaDon = HoaDon.idHoaDon join\n"
                + "NhanVien on PhieuBaoHanh.idNhanVien = NhanVien.idNhanVien";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> search(String id) {
        String selectSql = "select idPhieuBaoHanh,HoaDon.idHoaDon,TenKhachHang,TenNhanVien,HoaDon.NgayLap,LyDo,ThoiGianBaoTri,ChiPhiBaoHanh,PhieuBaoHanh.GhiChu,PhieuBaoHanh.TrangThai  from PhieuBaoHanh join KhachHang on PhieuBaoHanh.idKhachHang = KhachHang.idKhachHang join HoaDon on PhieuBaoHanh.idHoaDon = HoaDon.idHoaDon join\n"
                + "NhanVien on PhieuBaoHanh.idNhanVien = NhanVien.idNhanVien where idPhieuBaoHanh = ? ";
        List<Object[]> data = getRawValues(selectSql, id);
        return data;
    }
}
