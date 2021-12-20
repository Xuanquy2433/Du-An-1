/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import Interface.TableInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gnaht
 */
/**
 *
 * @author vanbi
 */
public class SanPham extends TableInterface {

    private Integer idSanPham;
    private Integer idLoaiSanPham;
    private String TenSanPham;
    private double GiaNhap;
    private double GiaBan;
    private Integer SoLuong;
    private String DVT;


    public SanPham() {
    }



    public SanPham(Integer idSanPham, Integer idLoaiSanPham, String TenSanPham, double GiaNhap, double GiaBan, Integer SoLuong, String DVT) {
        this.idSanPham = idSanPham;
        this.idLoaiSanPham = idLoaiSanPham;
        this.TenSanPham = TenSanPham;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.DVT = DVT;

    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(Integer idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

   
    @Override
    public int getId() {
        return idSanPham;
    }

    @Override
    public String toString() {
        return TenSanPham;
    }
}
