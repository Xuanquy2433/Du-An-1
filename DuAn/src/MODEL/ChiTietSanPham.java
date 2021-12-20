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
public class ChiTietSanPham extends TableInterface {

    private Integer idChiTietSanPham;
    private String DungLuong;
    private Integer idSanPham;
    private String MauSac;
    private String HangSanXuat;
    private int soLuong;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer idChiTietSanPham, String DungLuong, Integer idSanPham, String MauSac, String HangSanXuat, int soLuong) {
        this.idChiTietSanPham = idChiTietSanPham;
        this.DungLuong = DungLuong;
        this.idSanPham = idSanPham;
        this.MauSac = MauSac;
        this.HangSanXuat = HangSanXuat;
        this.soLuong = soLuong;
    }

   

    public Integer getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(Integer idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }

    public String getDungLuong() {
        return DungLuong;
    }

    public void setDungLuong(String DungLuong) {
        this.DungLuong = DungLuong;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getHangSanXuat() {
        return HangSanXuat;
    }

    public void setHangSanXuat(String HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public int getId() {
        return idChiTietSanPham;
    }

    @Override
    public String toString() {
        return String.valueOf(idChiTietSanPham); //To change body of generated methods, choose Tools | Templates.
    }

}
