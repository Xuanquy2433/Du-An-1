/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.HoaDonDAO;
import DAO.KhuyenMaiDAO;
import DAO.SanPhamDAO;
import MODEL.HoaDon;
import VIEW.ViewInterface;
import com.raven.form.BanHangPanel;
import com.raven.form.HoaDonPnl;
import com.raven.form.SanPhamPanel;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonBanHangController extends AbsController<HoaDon> {
    private BanHangPanel banHangPanel;


    public HoaDonBanHangController(ViewInterface view) {
        super(view);
        hoaDonDAO = new HoaDonDAO();
    }

    public List<Object[]> loadMonth() {
        return hoaDonDAO.loadThang();

    }

//    public String layT() {
//        return hoaDonDAO.layT();
//
//    }
    private HoaDonDAO hoaDonDAO;

    public void ThemHD(int idSanPham, int idNhanVien, int idKhuyenMai,int soLuong, double tongTien, Date ngayLap, String hinhThucThanhToan, String ghiChu) {
        hoaDonDAO.themHD(idSanPham, idNhanVien, idKhuyenMai,soLuong, tongTien, ngayLap, hinhThucThanhToan, ghiChu);
    }
   @Override
    public void loadList() {
        banHangPanel = (BanHangPanel) view;
        hoaDonDAO = (HoaDonDAO) dao;
        List<Object[]> data = hoaDonDAO.LoadDSSanPham();
        banHangPanel.setColumnNames(this.getTableColumnNames());
        banHangPanel.viewList(data);
    }
   @Override
    public AbsDAO<HoaDon> getDao() {
        return new HoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm", "Giá" ,"Số Lương", "Đơn Vị Tính"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


