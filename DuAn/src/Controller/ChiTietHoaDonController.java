/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.DBConnection;
import DAO.HoaDonDAO;
import MODEL.ChiTietHoaDon;
import VIEW.ViewInterface;
import com.raven.form.ChiTietHoaDonDialog;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonController extends AbsController<ChiTietHoaDon> {

    private ChiTietHoaDonDialog chiTietHoaDonDialog;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
     private HoaDonDAO hoaDonDAO;

    public ChiTietHoaDonController(ViewInterface view) {
        super(view);
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        hoaDonDAO = new HoaDonDAO();
        chiTietHoaDonDialog = new ChiTietHoaDonDialog(null, true);
    }
  

    public void ThemCTHD(int idSanPham, int idHoaDon, int SoLuong, Double Gia, Double TongTien) {
        chiTietHoaDonDAO.themHD(idSanPham, idHoaDon,  SoLuong, Gia, TongTien);

    }
    public List<Object[]> layIdCTSP(int id) {

        
        return hoaDonDAO.layIdChiTietSanPham( id);
    }
    

    @Override
    public void loadList() {
        chiTietHoaDonDialog = (ChiTietHoaDonDialog) view;
        chiTietHoaDonDAO = (ChiTietHoaDonDAO) dao;
        List<Object[]> data = chiTietHoaDonDAO.loadLaiDS(chiTietHoaDonDialog.getIdHoaDon());
        chiTietHoaDonDialog.setColumnNames(this.getTableColumnNames());
        chiTietHoaDonDialog.viewList(data);
    }

    @Override
    public AbsDAO<ChiTietHoaDon> getDao() {
        return new ChiTietHoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Chi Tiết", "ID Sản Phẩm", "ID Hóa Đơn", "Số Lượng", "Giá Bán", "Tổng Tiền"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
