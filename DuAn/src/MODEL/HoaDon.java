/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

;

import java.sql.Timestamp;
import Interface.TableInterface;
import java.sql.Date;

/**
 *
 * @author gnaht
 */


public class HoaDon extends TableInterface {
    
    private Integer idHoaDon;
    private Integer idKhachHang;
    private Integer idNhanVien;
    private Integer idKhuyenMai;
    private Integer soLuong;
    private double tongTien;
    private java.sql.Timestamp ngayLap;
    private String hinhThucThanhToan;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Integer idKhachHang, Integer idNhanVien, Integer idKhuyenMai, Integer soLuong, double tongTien, Timestamp ngayLap, String hinhThucThanhToan, String ghiChu) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idKhuyenMai = idKhuyenMai;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

   

 
    
    public Timestamp getNgayLap() {
        return ngayLap;
    }
    
    public void setNgayLap(Timestamp ngayLap) {
        this.ngayLap = ngayLap;
    }
    
    public Integer getIdHoaDon() {
        return idHoaDon;
    }
    
    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    
    public Integer getIdKhachHang() {
        return idKhachHang;
    }
    
    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
    
    public Integer getIdNhanVien() {
        return idNhanVien;
    }
    
    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }
    
    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }
    
    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }
    
    public double getTongTien() {
        return tongTien;
    }
    
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }
    
    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;    }
    
    
    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    @Override
    public int getId() {
        return idHoaDon;
    }
    
    @Override
    public String toString() {
        return String.valueOf(idHoaDon);
    }
    
}
