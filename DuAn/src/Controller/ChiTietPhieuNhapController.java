/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.ChiTietPhieuNhapDAO;
import DAO.SanPhamDAO;
import MODEL.ChiTietPhieuNhap;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.form.ChiTietPhieuNhapDialog;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhapController extends AbsController<ChiTietPhieuNhap> {

    private ChiTietPhieuNhapDialog chiTietPhieuNhapDialog;
    private ChiTietPhieuNhapDAO chiTietPhieuNhapDAO;

    public ChiTietPhieuNhapController(ViewInterface view) {
        super(view);
        chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
        chiTietPhieuNhapDialog = new ChiTietPhieuNhapDialog(null, true);
    }

    public void them(int idPhieuNhap, int idSanPham, int soLuong, double giaTien, double tongTien) {
        chiTietPhieuNhapDAO.them(idPhieuNhap, idSanPham, soLuong, giaTien, tongTien);
        loadList();
    }

//    public void search(String id, String idSearch) {
//        chiTietPhieuNhapDialog.viewList(chiTietPhieuNhapDAO.search(id, idSearch));
//    }
    @Override
    public void loadList() {
        chiTietPhieuNhapDialog = (ChiTietPhieuNhapDialog) view;
        chiTietPhieuNhapDAO = (ChiTietPhieuNhapDAO) dao;
        List<Object[]> data = chiTietPhieuNhapDAO.loadLaiDS(chiTietPhieuNhapDialog.getIdPhieuNhap());
        chiTietPhieuNhapDialog.setColumnNames(this.getTableColumnNames());
        chiTietPhieuNhapDialog.viewList(data);
    }

    @Override
    public AbsDAO<ChiTietPhieuNhap> getDao() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Chi Tiết", "ID Phiếu Nhập", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền", "Tổng Tiền"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
