/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.ChiTietSanPhamDAO;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;
import MODEL.ChiTietSanPham;
import MODEL.HoaDon;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.form.HoaDonPnl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonController extends AbsController<HoaDon> {

    private HoaDonPnl hoaDonPnl;
    private SanPhamDAO sanPhamDAO;
    private ChiTietSanPhamDAO chiTietSanPhamDAO;

    public HoaDonController(ViewInterface view) {
        super(view);
        hoaDonDAO = new HoaDonDAO();
        sanPhamDAO = new SanPhamDAO();
        chiTietSanPhamDAO = new ChiTietSanPhamDAO();
    }

    public List<ChiTietSanPham> layCbbCTSP() {
        return chiTietSanPhamDAO.getAll();
    }
    public List<SanPham> layCbbSanPham() {
        return sanPhamDAO.getAll();
    }
    public List<Object[]> loadMonth() {
        return hoaDonDAO.loadThang();

    }

    public ArrayList<HoaDon> DSHoaDOn() {

        return hoaDonDAO.layListHoaDon();

    }

    public ArrayList<SanPham> DSSanPham() {

        return sanPhamDAO.layListSanPham();

    }

//    public String layT() {
//        return hoaDonDAO.layT();
//
//    }
    private HoaDonDAO hoaDonDAO;

    public int showName(int id) {
        return hoaDonDAO.layId(id);
    }

    public void ThemHD(int idSanPham, int idNhanVien, int idKhuyenMai,int soLuong, double tongTien, Date ngayLap, String hinhThucThanhToan, String ghiChu) {
        hoaDonDAO.themHD(idSanPham, idNhanVien, idKhuyenMai,soLuong, tongTien, ngayLap, hinhThucThanhToan, ghiChu);
    }

    public Integer idHoaDon() {
        return hoaDonDAO.layHDVuaTao();
    }

    public void search(String id) {

        hoaDonPnl.viewList(hoaDonDAO.search(id));
    }
    
    public List<Object[]> layIdCTSP(int id) {

        
        return hoaDonDAO.layIdChiTietSanPham( id);
    }

    @Override
    public void loadList() {
        hoaDonPnl = (HoaDonPnl) view;
        hoaDonDAO = (HoaDonDAO) dao;
        List<Object[]> data = hoaDonDAO.layDS();
        hoaDonPnl.setColumnNames(this.getTableColumnNames());
        hoaDonPnl.viewList(data);
    }

    @Override
    public AbsDAO<HoaDon> getDao() {
        return new HoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Hóa đơn",  "Nhân viên", "Khách hàng","Khuyến mãi","Số Lượng", "Tổng tiền", "Ngày lập", "Hình thức thanh toán", "Ghi chú"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
