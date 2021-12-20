/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.LoaiSanPhamDAO;
import MODEL.LoaiSanPham;
import VIEW.ViewInterface;
import com.raven.form.LoaiSanPhamPnl;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiSanPhamController extends AbsController<LoaiSanPham> {

    private LoaiSanPhamPnl loaiSanPhamPnl;
    private LoaiSanPhamDAO loaiSanPhamDAO;

    public LoaiSanPhamController(ViewInterface view) {
        super(view);
        loaiSanPhamDAO = new LoaiSanPhamDAO();

    }

    public void search(String ten) {
        loaiSanPhamPnl.viewList(loaiSanPhamDAO.search(ten));
    }

    @Override
    public void loadList() {
        loaiSanPhamPnl = (LoaiSanPhamPnl) view;
        loaiSanPhamDAO = (LoaiSanPhamDAO) dao;
        List<Object[]> data = loaiSanPhamDAO.layListLoaiSanPham();
        loaiSanPhamPnl.setColumnNames(this.getTableColumnNames());
        loaiSanPhamPnl.viewList(data);
    }

    @Override
    public AbsDAO<LoaiSanPham> getDao() {
        return new LoaiSanPhamDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Loại Sản Phẩm", "Tên Loại Sản Phẩm"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
