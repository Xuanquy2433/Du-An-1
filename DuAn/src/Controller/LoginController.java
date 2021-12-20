/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NhanVienDAO;
import MODEL.NhanVien;
import com.raven.form.DangNhapPnl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoginController {

    DangNhapPnl view;

    public LoginController(DangNhapPnl view) {
        this.view = view;
        view.setController(this);
        nhanVienDAO = new NhanVienDAO();
    }
    private NhanVienDAO nhanVienDAO;

    public boolean kiemTra(String tk, String mk) {
        if (nhanVienDAO.kiemTraTaiKhoan(tk, mk)) {
            System.out.println("Dang nhap thanh cong");
            return true;

        } else {
            System.out.println("Sai ten dang nhap hoac mat khau");
            return false;
        }
    }

    public String showName(String tk, String mk) {
        return nhanVienDAO.layTenNV(tk, mk);
    }

    public int showLevel(String tk, String mk) {
        return nhanVienDAO.layChucVuNV(tk, mk);
    }
    
    public int showID(String tk, String mk) {
        return nhanVienDAO.layIDNV(tk, mk);
    }

}
