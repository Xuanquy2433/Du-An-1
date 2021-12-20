/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NhaCungCap;
import java.util.List;

/**
 *
 * @author gnaht
 */
public class NhaCungCapDAO extends AbsDAO<NhaCungCap> {

    public List<Object[]> search(String ten) {
        String selectSql = "select * from NhaCungCap where TenNhaCungCap like ? ";
        List<Object[]> data = getRawValues(selectSql, ten);
        return data;
    }

    public List<Object[]> layDS() {
        String selectSql = "select * from NhaCungCap";
        List<Object[]> data = getRawValues(selectSql);
        return data;
    }
}
