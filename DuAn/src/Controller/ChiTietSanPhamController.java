/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.ChiTietSanPhamDAO;
import MODEL.ChiTietSanPham;
import VIEW.ViewInterface;
import com.raven.form.ChiTietSanPhamDialog;
import com.raven.form.ChiTietSanPhamDialogForBanHang;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamController extends AbsController<ChiTietSanPham> {

    private ChiTietSanPhamDialog chiTietSanPhamDialog;
    private ChiTietSanPhamDAO chiTietSanPhamDAO;

    public ChiTietSanPhamController(ViewInterface view) {
        super(view);
        chiTietSanPhamDialog = new ChiTietSanPhamDialog(null, true);
        chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    }

    public void them(String dungLuong, int idSanPham, String mauSac, String hangSx,int soLuong) {
        chiTietSanPhamDAO.them(dungLuong, idSanPham, mauSac, hangSx, soLuong);
        loadList();
    }
        public void editSoLuongChiTiet(int SoLuong,int idChiTietSanPham) {
        chiTietSanPhamDAO.editSoLuongChiTietSanPham(SoLuong, idChiTietSanPham);

    }
        public void editSoLuongSanPham(int SoLuong,int idSanPham) {
        chiTietSanPhamDAO.editSoLuongSanPham(SoLuong, idSanPham);

    }

    @Override
    public void loadList() {
        chiTietSanPhamDialog = (ChiTietSanPhamDialog) view;
        chiTietSanPhamDAO = (ChiTietSanPhamDAO) dao;
        List<Object[]> data = chiTietSanPhamDAO.loadLaiDS(chiTietSanPhamDialog.getIdSanPham());
        chiTietSanPhamDialog.setColumnNames(this.getTableColumnNames());
        chiTietSanPhamDialog.viewList(data);
    }

    @Override
    public AbsDAO<ChiTietSanPham> getDao() {
        return new ChiTietSanPhamDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Chi Tiết", "ID Sản Phẩm", "Dung Lượng", "Màu săc", "Hãng sản xuất","Số Lượng"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
