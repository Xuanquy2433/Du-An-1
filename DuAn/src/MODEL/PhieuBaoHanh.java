/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import Interface.TableInterface;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author gnaht
 */
public class PhieuBaoHanh extends TableInterface {

    private Integer idPhieuBaoHanh;
    private Integer idHoaDon;
    private Integer idKhachHang;
    private Integer idNhanVien;
    private java.sql.Timestamp ngayLap;
    private String lyDo;
    private String thoiGianBaoTri;
    private String trangThai;
    private double chiPhiBaoHanh;
    private String ghiChu;

    public Integer getIdPhieuBaoHanh() {
        return idPhieuBaoHanh;
    }

    public void setIdPhieuBaoHanh(Integer idPhieuBaoHanh) {
        this.idPhieuBaoHanh = idPhieuBaoHanh;
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

    public Timestamp getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Timestamp ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getThoiGianBaoTri() {
        return thoiGianBaoTri;
    }

    public void setThoiGianBaoTri(String thoiGianBaoTri) {
        this.thoiGianBaoTri = thoiGianBaoTri;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getChiPhiBaoHanh() {
        return chiPhiBaoHanh;
    }

    public void setChiPhiBaoHanh(double chiPhiBaoHanh) {
        this.chiPhiBaoHanh = chiPhiBaoHanh;
    }

  

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int getId() {
        return idPhieuBaoHanh;
    }

}
