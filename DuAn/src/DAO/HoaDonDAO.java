/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.DBConnection;
import java.util.ArrayList;

/**
 *
 * @author gnaht
 */
public class HoaDonDAO extends AbsDAO<HoaDon> {

    public int layId(int ten) {

        String cauLenh = "select * from  NhanVien where idNhanVien = ?";
        ResultSet rs = DBConnection.executeQuery(cauLenh, ten);

        try {
            if (rs.next()) {
                return rs.getInt("idNhanVien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Object[]> LoadDSSanPham() {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac),GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham\n"
                + "inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham where chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> layDSSanPham() {
        String selectSql = "select SanPham.idsanPham, ChiTietSanPham.idChiTietSanPham, ConCat(TenSanPham,' ', DungLuong,' ' ,Mausac),GiaBan,ChiTietSanPham.SoLuong,DVT from SanPham\n"
                + "inner join ChiTietSanPham on SanPham.idSanPham = ChiTietSanPham.idSanPham where chitietsanpham.soluong>0 order by chitietsanpham.soluong desc";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> Load() {
        String selectSql = "select * from HoaDon  ";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
//    public List<Object[]> layDataSearch(Object[] values) { // cho nay em dung cach nao cung duoc nhung co the dung cach nhuw thay cho tuong minh
//        String selectSql = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
//        List<Object[]> data = getRawValues(selectSql);
//        return data;
//    }

    public List<Object[]> loadThang() {
        String selectSql = "SELECT concat('Tháng ',MONTH(NgayLap)) as ngaylap,SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> searchDate(Date first, Date last) {
        String selectSql = "SELECT concat('Tháng ',MONTH(NgayLap)) as ngaylap,SUM(TongTien) AS totalIncome FROM HoaDon "
                + "WHERE NgayLap >= ? and NgayLap <= ?  group by Month(NgayLap)";
        List<Object[]> data = getRawValues(selectSql, first, last);
        return data;
    }

    public List<Object[]> loadNgay() {
        String selectSql = "SELECT concat('Ngày ',day(NgayLap)) as ngaylap,SUM(TongTien) AS totalIncome \n"
                + "FROM HoaDon \n"
                + "WHERE NgayLap >=dateadd(day,datediff(day,0,getdate())-30,0) \n"
                + "group by day(NgayLap)";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public List<Object[]> loadKhachHang() {
        String selectSql = "select top 10 TenKhachHang,sum(TongTien)as tongtien from KhachHang,HoaDon\n"
                + "group by TenKhachHang order by TongTien desc";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

//    public List<Integer> layT() throws SQLException {
//
//        String cauLenh = "SELECT SUM(TongTien) AS totalIncome FROM HoaDon WHERE NgayLap >=dateadd(month,datediff(month,0,getdate())-12,0) group by Month(NgayLap)";
//        ResultSet rs = DBConnection.executeQuery(cauLenh);
//
//        while(rs.next()){
//               
//                    
//
//
//        }
//                 }
    public void themHD(int idSanPham, int idNhanVien, int idKhuyenMai, int soLuong, double tongTien, Date ngayLap, String hinhThucThanhToan, String ghiChu) {
        String cauLenhThem = "insert into HoaDon values (?,?,?,?,?,?,?,?)";
        DBConnection.executeUpdate(cauLenhThem, idSanPham, idNhanVien, idKhuyenMai, soLuong, tongTien, ngayLap, hinhThucThanhToan, ghiChu);
    }

    public Integer layHDVuaTao() {
        String selectSql = "SELECT TOP 1 * FROM [HoaDon] ORDER BY idHoaDon DESC";
        ResultSet rs = DBConnection.executeQuery(selectSql);

        try {
            if (rs.next()) {
                return rs.getInt("idHoaDon");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Object[]> search(String id) {
        String selectSql = "select idHoaDon,TenNhanVien,TenKhachHang,TenKhuyenMai,TongTien,NgayLap,HinhThucThanhToan,HoaDon.GhiChu\n"
                + "from HoaDon join KhachHang on HoaDon.idKhachHang = KhachHang.idKhachHang join \n"
                + "NhanVien on HoaDon.idNhanVien = NhanVien.idNhanVien join KhuyenMai on HoaDon.idKhuyenMai = KhuyenMai.idKhuyenMai where idHoaDon = ? ";
        List<Object[]> data = getRawValues(selectSql, id);
        return data;
    }

    public List<Object[]> layDS() {
        String selectSql = "select idHoaDon,TenNhanVien,TenKhachHang,TenKhuyenMai,HoaDon.SoLuong,TongTien,NgayLap,HinhThucThanhToan,HoaDon.GhiChu\n"
                + "from HoaDon join KhachHang on HoaDon.idKhachHang = KhachHang.idKhachHang join \n"
                + "NhanVien on HoaDon.idNhanVien = NhanVien.idNhanVien join KhuyenMai on HoaDon.idKhuyenMai = KhuyenMai.idKhuyenMai";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }

    public ArrayList<HoaDon> layListHoaDon() {
        ArrayList<HoaDon> HoaDon = new ArrayList<>();
        try {
            String selectSql = "select * from HoaDon, sanpham";

            ResultSet rs = DBConnection.executeQuery(selectSql);
            HoaDon hd;
            while (rs.next()) {
                hd = new HoaDon(rs.getInt("idHoaDOn"),
                        rs.getInt("idKhachHang"),
                        rs.getInt("idNhanVien"),
                        rs.getInt("idKhuyenMai"),
                        rs.getInt("soluong"),
                        rs.getDouble("TongTien"),
                        rs.getTimestamp("NgayLap"),
                        rs.getString("HinhThucThanhToan"),
                        rs.getString("GhiChu")
                );

                HoaDon.add(hd);
                System.out.println(hd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return HoaDon;

    }
    public List<Object[]> layIdChiTietSanPham(int idSanPham) {
        String selectSql = "select ChiTietSanPham.idChiTietSanPham from SanPham inner join ChiTietSanPham on ChiTietSanPham.idSanPham = SanPham.idSanPham where chitietsanpham.idSanPham = ?";
        List<Object[]> data = getRawValues(selectSql,idSanPham);
        return data;
    }
}
