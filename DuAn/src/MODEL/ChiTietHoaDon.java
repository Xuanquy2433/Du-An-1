/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import Interface.TableInterface;



/**
 *
 * @author gnaht
 */
public class ChiTietHoaDon extends TableInterface {
    private Integer idChiTietHoaDon;
    private Integer idChiTietSanPham;
     private Integer idSanPham;
    private Integer idHoaDon;
    private Integer soLuong;
    private double gia;
    private double tongTien;
 

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(Integer idChiTietHoaDon, Integer idChiTietSanPham, Integer idSanPham, Integer idHoaDon, Integer soLuong, double gia, double tongTien) {
        this.idChiTietHoaDon = idChiTietHoaDon;
        this.idChiTietSanPham = idChiTietSanPham;
        this.idSanPham = idSanPham;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tongTien = tongTien;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

   

    public Integer getIdChiTietHoaDon() {
        return idChiTietHoaDon;
    }

    public void setIdChiTietHoaDon(Integer idChiTietHoaDon) {
        this.idChiTietHoaDon = idChiTietHoaDon;
    }

    public Integer getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(Integer idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    } 

    @Override
    public int getId() {
        return idChiTietHoaDon;
    }
    
}
