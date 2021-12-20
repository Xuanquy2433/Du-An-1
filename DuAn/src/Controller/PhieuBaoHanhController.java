/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.PhieuBaoHanhDAO;
import MODEL.HoaDon;
import MODEL.KhachHang;
import MODEL.PhieuBaoHanh;
import VIEW.ViewInterface;
import com.raven.form.PhieuBaoHanhPnl;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuBaoHanhController extends AbsController<PhieuBaoHanh> {

    private HoaDonDAO hoaDonDAO;
    private KhachHangDAO khachHangDAO;
    private PhieuBaoHanhDAO phieuBaoHanhDAO;
    private PhieuBaoHanhPnl phieuBaoHanhPnl;

    public PhieuBaoHanhController(ViewInterface view) {
        super(view);
        hoaDonDAO = new HoaDonDAO();
        khachHangDAO = new KhachHangDAO();
    }

    public List<HoaDon> layCbbHoaDon() {
        return hoaDonDAO.getAll();
    }

    public void search(String id) {
        phieuBaoHanhPnl.viewList(phieuBaoHanhDAO.search(id));
    }

    @Override
    public void loadList() {
        phieuBaoHanhPnl = (PhieuBaoHanhPnl) view;
        phieuBaoHanhDAO = (PhieuBaoHanhDAO) dao;
        List<Object[]> data = phieuBaoHanhDAO.loadLaiDS();
        phieuBaoHanhPnl.setColumnNames(this.getTableColumnNames());
        phieuBaoHanhPnl.viewList(data);
    }

    public List<KhachHang> layCbbKhachHang() {
        return khachHangDAO.getAll();
    }

    @Override
    public AbsDAO<PhieuBaoHanh> getDao() {
        return new PhieuBaoHanhDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Phiếu", "ID Hoá Đơn", "Khách Hàng", "Nhân Viên", "Ngày Lập", "Lý Do", "Thời gian bảo trì", "Chi Phí","Ghi Chú" , "Trạng Thái"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
