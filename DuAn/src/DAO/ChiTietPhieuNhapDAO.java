/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ChiTietPhieuNhap;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class ChiTietPhieuNhapDAO extends AbsDAO<ChiTietPhieuNhap> {

    public List<Object[]> loadLaiDS(int idPhieuNhap) {
        String selectSql = "select idChiTietPhieuNhap,idPhieuNhap,TenSanPham,ChiTietPhieuNhap.SoLuong,GiaTien,TongTien from ChiTietPhieuNhap join SanPham on ChiTietPhieuNhap.idSanPham = SanPham.idSanPham where idPhieuNhap = ? ";
        List<Object[]> data = getRawValues(selectSql, idPhieuNhap);
        return data;
    }

//    public List<Object[]> search(String id, String idSearch) {
//        String selectSql = "select	idChiTietPhieuNhap,idPhieuNhap,TenSanPham,ChiTietPhieuNhap.SoLuong,GiaTien,TongTien from ChiTietPhieuNhap join SanPham on ChiTietPhieuNhap.idSanPham"
//                + " = SanPham.idSanPham where idPhieuNhap = ?  and idChiTietPhieuNhap = ?";
//        List<Object[]> data = getRawValues(selectSql, id);
//        return data;
//    }

    public void them(int idPhieuNhap, int idSanPham, int soLuong, double giaTien, double tongTien) {
        String cauLenhThemNguoiDung = "insert into ChiTietPhieuNhap  values ( ?, ?, ?, ?,?)";
        DBConnection.executeUpdate(cauLenhThemNguoiDung, idPhieuNhap, idSanPham, soLuong, giaTien, tongTien);

    }

}
