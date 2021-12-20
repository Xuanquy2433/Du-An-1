/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.ChiTietSanPhamDAO;
import DAO.DBConnection;
import DAO.SanPhamDAO;
import MODEL.ChiTietHoaDon;
import MODEL.ChiTietSanPham;
import MODEL.SanPham;
import VIEW.ViewInterface;
import com.raven.form.ChiTietHoaDonDialog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanHangChiTietHoaDonController extends AbsController<ChiTietHoaDon> {

    private ChiTietHoaDonDialog chiTietHoaDonDialog;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    private ChiTietSanPhamDAO chiTietSanPhamDAO;
    private SanPhamDAO sanPhamDAO;

    public BanHangChiTietHoaDonController(ViewInterface view) {
        super(view);
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        sanPhamDAO = new SanPhamDAO();
        chiTietSanPhamDAO = new ChiTietSanPhamDAO();
        chiTietHoaDonDialog = new ChiTietHoaDonDialog(null, true);
    }
    private ChiTietHoaDonDAO chiTiethoaDonDAO;

    public void ThemCTHD(int idSanPham, int idHoaDon, int SoLuong, Double Gia, Double TongTien) {
        chiTiethoaDonDAO.themHD(idSanPham, idHoaDon,  SoLuong, Gia, TongTien);

    }
    
    public void editSoLuongChiTiet(int SoLuong,int idChiTietSanPham) {
        chiTietSanPhamDAO.editSoLuongChiTietSanPham(SoLuong, idChiTietSanPham);

    }
        public void editSoLuongSanPham(int SoLuong,int idSanPham) {
        chiTietSanPhamDAO.editSoLuongSanPham(SoLuong, idSanPham);

    }
        
        public Integer laySoLuongTheoIdSP(int idSanPham) {
        return sanPhamDAO.soLuongSPTheoId(idSanPham);
    }
            public Integer laySoLuongTheoIdCTSP(int idCTSP) {
        return sanPhamDAO.soLuongSPTheoId(idCTSP);
    }
     public ArrayList<SanPham> DSSanPham() {

        return sanPhamDAO.layListSanPham();

    }
     
      public ArrayList<ChiTietSanPham> DSCTSP() {

        return chiTietSanPhamDAO.layListCTSP();

    }
    @Override
    public AbsDAO<ChiTietHoaDon> getDao() {
        return new ChiTietHoaDonDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Giá Nhập", "Giá Bán", "Số Lượng", "Đơn Vị Tính"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
