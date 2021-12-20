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
public class ChiTietPhieuNhap extends TableInterface {

    private Integer idChiTietPhieuNhap;
    private Integer idPhieuNhap;
    private Integer idSanPham;
    private Integer soLuong;
    private double giaTien;
    private double tongTien;

    public Integer getIdChiTietPhieuNhap() {
        return idChiTietPhieuNhap;
    }

    public void setIdChiTietPhieuNhap(Integer idChiTietPhieuNhap) {
        this.idChiTietPhieuNhap = idChiTietPhieuNhap;
    }

    public Integer getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(Integer idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int getId() {
        return idChiTietPhieuNhap;
    }

}
