/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;
import MODEL.HoaDon;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.form.HoaDonPnl;
import com.raven.form.SanPhamPanel;
import com.raven.form.ThongKe;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class ThongKeController extends AbsController<HoaDon> {

    private HoaDonPnl hoaDonPnl;
    private ThongKe thongKe;
    private HoaDonDAO hoaDonDAO;
    private SanPhamDAO sanPhamDAO;

    public ThongKeController(ViewInterface view) {
        super(view);
        hoaDonDAO = new HoaDonDAO();
        sanPhamDAO = new SanPhamDAO();
    }

    public List<Object[]> loadMonth() {
        return hoaDonDAO.loadThang();

    }

    public List<Object[]> SearchDate(Date first, Date last) {
        return hoaDonDAO.searchDate(first, last);
    }

    public List<Object[]> loadNgay() {
        return hoaDonDAO.loadNgay();

    }

    public List<Object[]> loadKhachHang() {
        return hoaDonDAO.loadKhachHang();

    }

    public Object DSSanPhamBanChay(JTable tbl) {
        return sanPhamDAO.layListSanPhamBanChay(tbl);

    }
    
             public Object DSSanPhamTonKho(JTable tbl) {
        return sanPhamDAO.LayListSanPhamTonKho(tbl);

    }

    public ArrayList<SanPham> DSSanPham() {
        return sanPhamDAO.layListSanPham();

    }

    public ArrayList<HoaDon> DSHoaDOn() {
        return hoaDonDAO.layListHoaDon();

    }

    public int showName(int id) {
        return hoaDonDAO.layId(id);
    }

    public void ThemHD(int idSanPham, int idNhanVien, int idKhuyenMai, int soLuong, double tongTien, Date ngayLap, String hinhThucThanhToan, String ghiChu) {
        hoaDonDAO.themHD(idSanPham, idNhanVien, idKhuyenMai, soLuong, tongTien, ngayLap, hinhThucThanhToan, ghiChu);

    }

    public Integer idHoaDon() {
        return hoaDonDAO.layHDVuaTao();
    }

    @Override
    public void loadList() {
        thongKe = (ThongKe) view;
        hoaDonDAO = (HoaDonDAO) dao;
        List<Object[]> data = hoaDonDAO.layDSSanPham();
        thongKe.setColumnNames(this.getTableColumnNames());
        thongKe.viewList(data);
    }

    @Override
    public AbsDAO<HoaDon> getDao() {
        return new HoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Hóa đơn", "Khách hàng", "Nhân viên", "Khuyến mãi", "Tổng tiền", "Ngày lập", "Hình thức thanh toán", "Trạng Thái", "Ghi chú"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
