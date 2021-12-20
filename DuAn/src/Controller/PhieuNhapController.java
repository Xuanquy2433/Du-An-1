/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.NhaCungCapDAO;
import DAO.PhieuNhapDAO;
import DAO.SanPhamDAO;
import MODEL.NhaCungCap;
import MODEL.PhieuNhap;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.form.PhieuNhapPnl;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuNhapController extends AbsController<PhieuNhap> {

    private NhaCungCapDAO nhaCungCapDAO;
    private PhieuNhapPnl phieuNhapPnl;
    private PhieuNhapDAO phieuNhapDAO;
 private SanPhamDAO sanPhamDAO;
    public PhieuNhapController(ViewInterface view) {
        super(view);
        nhaCungCapDAO = new NhaCungCapDAO();
        sanPhamDAO = new SanPhamDAO();
        
        
    }
   

//    public List<SanPham> layCbbSanPham() {
//        return sanPhamDAO.getAll();
//    }
    
      public ArrayList<SanPham> DSSanPham() {

        return sanPhamDAO.layListSanPham();

    }

    public List<NhaCungCap> layCbbNhaCungCap() {
        return nhaCungCapDAO.getAll();
    }

    public void search(String id) {
        phieuNhapPnl.viewList(phieuNhapDAO.search(id));
    }

    @Override
    public void loadList() {
        phieuNhapPnl = (PhieuNhapPnl) view;
        phieuNhapDAO = (PhieuNhapDAO) dao;
        List<Object[]> data = phieuNhapDAO.loadLaiDS();
        phieuNhapPnl.setColumnNames(this.getTableColumnNames());
        phieuNhapPnl.viewList(data);
    }

    @Override
    public AbsDAO<PhieuNhap> getDao() {
        return new PhieuNhapDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Phiếu Nhập", "Tên Nhà Cung Cấp", "Ngày Nhập", "Tổng Tiền", "Trạng Thái", "Số Lượng"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
