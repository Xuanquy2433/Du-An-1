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
public class KhuyenMai extends TableInterface{
    private Integer idKhuyenMai;
    private String tenKhuyenMai;
    private int phanTramKhuyenMai;
    private String ghiChu;

    public KhuyenMai() {
    }

    public KhuyenMai(Integer idKhuyenMai, String tenKhuyenMai, int phanTramKhuyenMai, String ghiChu) {
        this.idKhuyenMai = idKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.ghiChu = ghiChu;
    }

    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public int getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(int phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int getId() {
        return idKhuyenMai;
    }

    @Override
    public String toString() {
        return tenKhuyenMai;
    }
    
    
    
}
