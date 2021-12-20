/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.KhachHangDAO;
import MODEL.KhachHang;
import VIEW.ViewInterface;
import com.raven.form.BanHangPanel;
import com.raven.form.KhachHangPanel;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangControllerForBanHang extends AbsController<KhachHang> {

    private BanHangPanel banHangPanel;
    private KhachHangDAO khachHangDAO;

    public KhachHangControllerForBanHang(ViewInterface view) {
        super(view);
        khachHangDAO = new KhachHangDAO();

    }

    public void search(String ten) {
        banHangPanel.viewList(khachHangDAO.search(ten));
    }

    @Override
    public void loadList() {
        banHangPanel = (BanHangPanel) view;
        khachHangDAO = (KhachHangDAO) dao;
        List<Object[]> data = khachHangDAO.layDS();
        banHangPanel.setColumnNames(this.getTableColumnNames());
        banHangPanel.viewList(data);
    }

    @Override
    public AbsDAO<KhachHang> getDao() {
        return new KhachHangDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Khách Hàng", "Tên Khách Hàng", "Số điện thoại", "Địa Chỉ", "Số CMND", "Ghi chú", "GiớiTính", "Email"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {
        viewBag.put("tieu_de", "");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
