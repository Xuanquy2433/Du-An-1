/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ChiTietSanPham;
import MODEL.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnaht
 */
public class ChiTietSanPhamDAO extends AbsDAO<ChiTietSanPham> {

    public List<Object[]> loadLaiDS(int idSanPham) {
        String selectSql = "select idChiTietSanPham,SanPham.idSanPham ,DungLuong,MauSac,HangSanXuat,chitietsanpham.soLuong from ChiTietSanPham join SanPham on ChiTietSanPham.idSanPham = SanPham.idSanPham where SanPham.idSanPham = ? order by chitietSanPham.soLuong DESC ";
        List<Object[]> data = getRawValues(selectSql, idSanPham);
        return data;
    }

    public void them(String dungLuong, int idSanPham, String mauSac, String hangSx, int soLuong) {
        String cauLenhThemNguoiDung = "insert into ChiTietSanPham  values ( ?, ?, ?,?,?)";
        DBConnection.executeUpdate(cauLenhThemNguoiDung, dungLuong, idSanPham, mauSac, hangSx, soLuong);

    }

    public void editSoLuongSanPham(int soLuong, int idSanPham) {
        String cauLenhEdit = "UPDATE SanPham\n"
                + "   SET \n"
                + "SoLuong = ?\n"
                + "      \n"
                + " WHERE idSanPham = ?";
        DBConnection.executeUpdate(cauLenhEdit, soLuong, idSanPham);
    }

    public void editSoLuongChiTietSanPham(int soLuong, int idSanPham) {
        String cauLenhEdit = "UPDATE ChiTietSanPham\n"
                + "   SET \n"
                + "SoLuong = ?\n"
                + "      \n"
                + " WHERE idChiTietSanPham = ?";
        DBConnection.executeUpdate(cauLenhEdit, soLuong, idSanPham);
    }

    public ArrayList<ChiTietSanPham> layListCTSP() {
        ArrayList<ChiTietSanPham> CTSP = new ArrayList<>();
        try {
            String selectSql = "select * from ChiTietSanPham";

            ResultSet rs = DBConnection.executeQuery(selectSql);
            ChiTietSanPham sp;
            while (rs.next()) {
                sp = new ChiTietSanPham(rs.getInt("idChiTietSanPham"),
                        rs.getString("DungLuong"),
                        rs.getInt("idSanPham"),
                        rs.getString("MauSac"),
                        rs.getString("HangSanXuat"),
                        rs.getInt("SoLuong")
                );

                CTSP.add(sp);
                System.out.println(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return CTSP;

    }
}
