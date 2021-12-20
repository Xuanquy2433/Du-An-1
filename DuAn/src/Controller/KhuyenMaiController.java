/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.KhuyenMaiDAO;
import MODEL.KhuyenMai;
import VIEW.ViewInterface;
import java.util.Dictionary;

/**
 *
 * @author Admin
 */
public class KhuyenMaiController extends AbsController<KhuyenMai> {

    public KhuyenMaiController(ViewInterface view) {
        super(view);
    }
   
    @Override
    public AbsDAO<KhuyenMai> getDao() {
        return new KhuyenMaiDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Khuyến Mãi", "Tên Khuyến Mãi", "Phần trăm khuyến mãi %", "Ghi chú"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
