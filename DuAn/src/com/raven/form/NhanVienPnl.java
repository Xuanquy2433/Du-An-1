/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Controller.AbsController;
import Controller.KhachHangController;
import Controller.NhanVienController;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import duan.dialog.HandleKhachHangDal;
import duan.dialog.HandleNhanVienDal;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.oval.ConstraintViolation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Admin
 */
public class NhanVienPnl extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form KhachHangPanel
     */
    private HandleNhanVienDal nhanVienDal = null;

    public NhanVienPnl() {
        initComponents();
        NhanVienController nhanVienController = new NhanVienController(this);
        if (nhanVienDal == null) {
            nhanVienDal = new HandleNhanVienDal(null, true);
            nhanVienDal.addBT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //validate
                    if (nhanVienDal.txtTen.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền tên ! ");
                        return;
                    }
                    if (nhanVienDal.txtDiaChi.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền địa chỉ ! ");
                        return;
                    }
                    if (nhanVienDal.txtCMND.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền số CMND ! ");
                        return;
                    }
                    if (nhanVienDal.txtEmail.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền Email ! ");
                        return;
                    }
                    if (!nhanVienDal.txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        nhanVienDal.errorlb.setText("Email không hợp lệ ! ");
                        return;
                    }

                    if (nhanVienDal.txtSdt.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền số điện thoại ! ");
                        return;
                    }
                    if (!nhanVienDal.txtSdt.getText().matches("^\\d{10}$")) {
                        nhanVienDal.errorlb.setText("Số điện thoại không hợp lệ ! ");
                        return;
                    }

                    if (nhanVienDal.txtTrangThai.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền trạng thái ! ");
                        return;
                    }
                    if (nhanVienDal.dcNgayVaoLam.getDate() == null) {
                        nhanVienDal.errorlb.setText("Ngày vào làm không được bỏ trống ! ");
                        return;
                    }

                    if (nhanVienDal.dcNgayVaoLam.getDate().after(new Date())) {
                        nhanVienDal.errorlb.setText("Ngày vào làm không được quá ngày hiện tại ! ");
                        return;
                    }

                    if (nhanVienDal.txtChucVu.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền chức vụ ! ");
                        return;
                    }
                    if (nhanVienDal.txtTenDN.getText().trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền tên đăng nhập ! ");
                        return;
                    }
                    if (String.valueOf(nhanVienDal.txtMK.getPassword()).trim().equals("")) {
                        nhanVienDal.errorlb.setText("Vui lòng điền mật khẩu ! ");
                        return;
                    }

                    Object[] values = new Object[12];
                    values[0] = 0;
                    values[1] = nhanVienDal.txtTen.getText();
                    if (nhanVienDal.cbNam.isSelected()) {
                        values[2] = "Nam";
                    } else if (!nhanVienDal.cbNu.isSelected() && !nhanVienDal.cbNam.isSelected()) {
                        JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn giới tính !", "Error", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        values[2] = "Nữ";
                    }
                    values[3] = nhanVienDal.txtDiaChi.getText();
                    values[4] = nhanVienDal.txtCMND.getText();
                    values[5] = nhanVienDal.txtSdt.getText();
                    values[6] = nhanVienDal.txtEmail.getText();

                    values[7] = nhanVienDal.dcNgayVaoLam.getDate();
                    System.out.println(values[7]);

                    values[8] = Integer.parseInt(nhanVienDal.txtChucVu.getText());
                    values[9] = nhanVienDal.txtTenDN.getText();
                    values[10] = String.valueOf(nhanVienDal.txtMK.getPassword());
                    values[11] = nhanVienDal.txtTrangThai.getText();

                    nhanVienController.insert(values);
                }
            });
        }

        nhanVienDal.editBT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //validate
                if (nhanVienDal.txtTen.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền tên ! ");
                    return;
                }
                if (nhanVienDal.txtDiaChi.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền địa chỉ ! ");
                    return;
                }
                if (nhanVienDal.txtCMND.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền số CMND ! ");
                    return;
                }
                if (nhanVienDal.txtEmail.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền Email ! ");
                    return;
                }
                if (!nhanVienDal.txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    nhanVienDal.errorlb.setText("Email không hợp lệ ! ");
                    return;
                }

                if (nhanVienDal.txtSdt.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền số điện thoại ! ");
                    return;
                }
                if (!nhanVienDal.txtSdt.getText().matches("^\\d{10}$")) {
                    nhanVienDal.errorlb.setText("Số điện thoại không hợp lệ ! ");
                    return;
                }

                if (nhanVienDal.txtTrangThai.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền trạng thái ! ");
                    return;
                }
                if (nhanVienDal.dcNgayVaoLam.getDate() == null) {
                    nhanVienDal.errorlb.setText("Ngày vào làm không được bỏ trống ! ");
                    return;
                }

                if (nhanVienDal.dcNgayVaoLam.getDate().after(new Date())) {
                    nhanVienDal.errorlb.setText("Ngày vào làm không được quá ngày hiện tại ! ");
                    return;
                }

                if (nhanVienDal.txtChucVu.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền chức vụ ! ");
                    return;
                }
                if (nhanVienDal.txtTenDN.getText().trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền tên đăng nhập ! ");
                    return;
                }
                if (String.valueOf(nhanVienDal.txtMK.getPassword()).trim().equals("")) {
                    nhanVienDal.errorlb.setText("Vui lòng điền mật khẩu ! ");
                    return;
                }

                Object[] values = new Object[12];
                values[0] = editId;
                values[1] = nhanVienDal.txtTen.getText();
                if (nhanVienDal.cbNam.isSelected()) {
                    values[2] = "Nam";
                } else if (!nhanVienDal.cbNu.isSelected() && !nhanVienDal.cbNam.isSelected()) {
                    JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn giới tính !", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    values[2] = "Nữ";
                }
                values[3] = nhanVienDal.txtDiaChi.getText();
                values[4] = nhanVienDal.txtCMND.getText();
                values[5] = nhanVienDal.txtSdt.getText();
                values[6] = nhanVienDal.txtEmail.getText();
                values[7] = nhanVienDal.dcNgayVaoLam.getDate();
                values[8] = Integer.parseInt(nhanVienDal.txtChucVu.getText());
                values[9] = nhanVienDal.txtTenDN.getText();
                values[10] = String.valueOf(nhanVienDal.txtMK.getPassword());
                values[11] = nhanVienDal.txtTrangThai.getText();
                nhanVienController.edit(values);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jPanel2 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnCapNhap = new javax.swing.JLabel();

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(tblNhanVien);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(scrollBar1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-55-16.png"))); // NOI18N
        jLabel1.setText("     Xuất file");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 153, 153));
        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/plus-16.png"))); // NOI18N
        btnThem.setText("     Thêm mới");
        btnThem.setOpaque(true);
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnCapNhap.setBackground(new java.awt.Color(0, 153, 153));
        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCapNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/available-updates-16.png"))); // NOI18N
        btnCapNhap.setText("     Cập nhập");
        btnCapNhap.setOpaque(true);
        btnCapNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        nhanVienDal.errorlb.setText("");
        nhanVienDal.txtTen.setText("");
        nhanVienDal.txtSdt.setText("");
        nhanVienDal.txtDiaChi.setText("");
        nhanVienDal.txtCMND.setText("");
        nhanVienDal.txtChucVu.setText("");
        nhanVienDal.txtEmail.setText("");
        nhanVienDal.cbNam.setSelected(false);
        nhanVienDal.cbNu.setSelected(false);
        nhanVienDal.txtChucVu.setText("");
        nhanVienDal.txtTrangThai.setText("");
        nhanVienDal.txtTenDN.setText("");
        nhanVienDal.txtMK.setText("");
        String tieuDe = (String) nhanVienController.getViewBag().get("tieu_de");
        nhanVienDal.title.setText("Thêm Nhân Viên ");
        nhanVienDal.setVisible(true);
    }//GEN-LAST:event_btnThemMouseClicked
    private Integer editId;
    private void btnCapNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhapMouseClicked
        // TODO add your handling code here:

        if (tblNhanVien.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn dòng cần sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nhanVienDal.errorlb.setText("");
        editId = (Integer) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 0);

        int dong = tblNhanVien.getSelectedRow();
        nhanVienDal.txtTen.setText(tblNhanVien.getValueAt(dong, 1).toString());
        if (tblNhanVien.getValueAt(dong, 2).toString().equals("Nam")) {
            nhanVienDal.cbNam.setSelected(true);
        } else {
            nhanVienDal.cbNam.setSelected(false);
        }
        if (tblNhanVien.getValueAt(dong, 2).toString().equals("Nữ")) {
            nhanVienDal.cbNu.setSelected(true);
        } else {
            nhanVienDal.cbNu.setSelected(false);
        }
        nhanVienDal.txtDiaChi.setText(tblNhanVien.getValueAt(dong, 3).toString());
        nhanVienDal.txtCMND.setText(tblNhanVien.getValueAt(dong, 4).toString());
        nhanVienDal.txtSdt.setText(tblNhanVien.getValueAt(dong, 5).toString());
        nhanVienDal.txtEmail.setText(tblNhanVien.getValueAt(dong, 6).toString());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            nhanVienDal.dcNgayVaoLam.setDate(df.parse(tblNhanVien.getValueAt(dong, 7).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienPnl.class.getName()).log(Level.SEVERE, null, ex);
        }
        nhanVienDal.txtChucVu.setText(tblNhanVien.getValueAt(dong, 8).toString());
        nhanVienDal.txtTenDN.setText(tblNhanVien.getValueAt(dong, 9).toString());
        nhanVienDal.txtMK.setText(tblNhanVien.getValueAt(dong, 10).toString());
        nhanVienDal.txtTrangThai.setText(tblNhanVien.getValueAt(dong, 11).toString());
        String tieuDe = (String) nhanVienController.getViewBag().get("tieu_de");
        nhanVienDal.title.setText("Cập Nhập Nhân Viên ");
        nhanVienDal.setVisible(true);
    }//GEN-LAST:event_btnCapNhapMouseClicked


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        exportExcel(tblNhanVien);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:
             
        String ten = "%" + searchText1.getText() + "%";
        System.out.println(ten);
        nhanVienController.search(ten);
    }//GEN-LAST:event_searchText1KeyReleased
    public void exportExcel(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        String Link = "";
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Link = String.valueOf(file);
        } else {

            return;
        }
        try {
            //khai báo tên file muốn tạo
            String filename = Link + ".xls";
            //tạo một đối tượng của lớp HSSFWorkbook
            HSSFWorkbook workbook = new HSSFWorkbook();
            //gọi phương thức creatSheet() và truyền tên file muốn tạo
            HSSFSheet sheet = workbook.createSheet("January");
            //tạo hàng thứ 0 sử dụng phương thức createRow()
            HSSFRow rowhead = sheet.createRow((short) 0);

            // ten Cot
            for (int j = 0; j < table.getColumnCount(); j++) {
                rowhead.createCell(j).setCellValue(model.getColumnName(j));
            }

            for (int j = 1; j < table.getRowCount(); j++) {
                String a = String.valueOf(j);
                HSSFRow row = sheet.createRow((short) j);
                for (int k = 0; k < table.getColumnCount(); k++) {
                    row.createCell(k).setCellValue(model.getValueAt(j, k).toString());
                }
            }

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            //đóng stream
            fileOut.close();
            //đóng workbook
            workbook.close();
            //in thông báo tạo thành công
            JOptionPane.showMessageDialog(null, "Lưu file thành công !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lưu file thất bại !");

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCapNhap;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.TableColumn tblNhanVien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, tblNhanVien);
        if (nhanVienDal != null) {
            nhanVienDal.setVisible(false);
        }
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, tblNhanVien);
    }
    private NhanVienController nhanVienController;

    @Override
    public void setController(AbsController controller) {
        nhanVienController = (NhanVienController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
