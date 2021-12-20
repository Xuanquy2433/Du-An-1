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
public class KhachHang extends TableInterface{
    private Integer idKhachHang;
    private String tenKhachHang;
    private String SoDienThoai;
    private String diaChi;
    private String CMND;
    private String ghiChu;
    private String gioiTinh;
    private String email;

    public KhachHang() {
    }

    public KhachHang(Integer idKhachHang, String tenKhachHang, String SoDienThoai, String diaChi, String CMND, String ghiChu, String gioiTinh, String email) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.SoDienThoai = SoDienThoai;
        this.diaChi = diaChi;
        this.CMND = CMND;
        this.ghiChu = ghiChu;
        this.gioiTinh = gioiTinh;
        this.email = email;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getId() {
        return idKhachHang;
    }

    @Override
    public String toString() {
        return tenKhachHang;
    }
    
    
    
}
