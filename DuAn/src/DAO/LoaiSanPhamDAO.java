/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.LoaiSanPham;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class LoaiSanPhamDAO extends AbsDAO<LoaiSanPham>{
     public List<Object[]> layListLoaiSanPham() {
        String selectSql = "select idLoaiSanPham,TenLoaiSanPham from LoaiSanPham";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
     
     public List<Object[]> search(String ten) {
        String selectSql = "select * from LoaiSanPham where TenLoaiSanPham like ? ";
        List<Object[]> data = getRawValues(selectSql, ten);
        return data;
    }
     
     
}
