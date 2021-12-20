/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.KhuyenMaiDAO;
import DAO.SanPhamDAO;
import MODEL.KhachHang;
import MODEL.KhuyenMai;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.component.Menu;
import com.raven.form.BanHangPanel;
import com.raven.form.SanPhamPanel;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanHangController extends AbsController<SanPham> {
    
    private Menu menu;
    private KhuyenMaiDAO khuyenMaiDAO;
    private KhachHangDAO khachHangDAO;
    private SanPhamPanel sanPhamPanel;
    private BanHangPanel banHangPanel;
    private SanPhamDAO sanPhamDAO;
    private HoaDonDAO hoaDonDAO;
    
    public BanHangController(ViewInterface view) {
        super(view);
        khuyenMaiDAO = new KhuyenMaiDAO();
        hoaDonDAO = new HoaDonDAO();
        khachHangDAO = new KhachHangDAO();
    }
    
    public Integer idHoaDon() {
        return hoaDonDAO.layHDVuaTao();
    }
    
    public void themKH(String tenKh, String sdt, String diaChi, String cmnd, String ghiChu, String gioiTinh, String email) {
        khachHangDAO.themKH(tenKh, sdt, diaChi, cmnd, ghiChu, gioiTinh, email);
    }
    
    public void search(String ten) {
        
        banHangPanel.viewList(sanPhamDAO.search(ten));
    }
    
    public void searchDungLuongTheoTen(String ten, String dungLuong) {
        
        banHangPanel.viewList(sanPhamDAO.searchDungLuongTheoTen(ten, dungLuong));
    }
    
    public void searchDungLuong(String dl) {
        
        banHangPanel.viewList(sanPhamDAO.searchDungLuong(dl));
    }
    
    @Override
    public void loadList() {
        banHangPanel = (BanHangPanel) view;
        sanPhamDAO = (SanPhamDAO) dao;
        List<Object[]> data = sanPhamDAO.layDSSanPham();
        banHangPanel.setColumnNames(this.getTableColumnNames());
        banHangPanel.viewList(data);
    }
    
    public List<KhuyenMai> layCbbKhuyenMai() {
        return khuyenMaiDAO.getAll();
    }
    
    public List<KhachHang> layCbbKhachHang() {
        return khachHangDAO.getAll();
    }
    
    public List<SanPham> layCbbDungLuong() {
        return sanPhamDAO.getAll();
    }
    
    @Override
    public AbsDAO<SanPham> getDao() {
        return new SanPhamDAO();
    }
    
    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm", "Giá", "Số Lương", "Đơn Vị Tính"};
    }
    
    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {
        
    }
    
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
