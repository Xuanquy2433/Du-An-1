/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AbsDAO;
import DAO.NhanVienDAO;
import MODEL.NhanVien;
import VIEW.ViewInterface;
import com.raven.form.NhanVienPnl;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienController extends AbsController<NhanVien> {

    private NhanVienPnl nhanVienPnl;
    private NhanVienDAO nhanVienDAO;

    public NhanVienController(ViewInterface view) {
        super(view);
        nhanVienDAO = new NhanVienDAO();
    }

    public void search(String ten) {
        nhanVienPnl.viewList(nhanVienDAO.search(ten));
    }

    @Override
    public void loadList() {
        nhanVienPnl = (NhanVienPnl) view;
        nhanVienDAO = (NhanVienDAO) dao;
        List<Object[]> data = nhanVienDAO.layDS();
        nhanVienPnl.setColumnNames(this.getTableColumnNames());
        nhanVienPnl.viewList(data);
    }

    @Override
    public AbsDAO<NhanVien> getDao() {
        return new NhanVienDAO();
    }

    @Override
    public String[] getTableColumnNames() {
        return new String[]{"ID Nhân viên", "Tên Nhân Viên", "Giới tính", "Địa Chỉ", "CMND", "Số Điện Thoại", "Email", "Ngày Vào Làm", "Level", "Tên đăng nhập", "Mật khẩu", "Trạng thái"};
    }

    @Override
    protected void setViewBagInfo(Dictionary<String, Object> viewBag) {

    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
