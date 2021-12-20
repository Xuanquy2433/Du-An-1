/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Controller.AbsController;
import Controller.KhachHangController;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import duan.dialog.HandleKhachHangDal;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
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
public class KhachHangPanel extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form KhachHangPanel
     */
    private HandleKhachHangDal khachHangDialog = null;

    public KhachHangPanel() {
        initComponents();

        if (khachHangDialog == null) {
            KhachHangController khachHangController = new KhachHangController(this);
            khachHangDialog = new HandleKhachHangDal(null, true);
            khachHangDialog.addBT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //validate

                    if (khachHangDialog.txtTen.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền tên khách hàng ! ");
                        return;
                    }
                    if (khachHangDialog.txtSdt.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền số điện thoại ! ");
                        return;
                    }
                    if (!khachHangDialog.txtSdt.getText().matches("^\\d{10}$")) {
                        khachHangDialog.errorlb.setText("Số điện thoại không hợp lệ ! ");
                        return;
                    }

                    if (khachHangDialog.txtDiaChi.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền địa chỉ ! ");
                        return;
                    }
                    if (khachHangDialog.txtCMND.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền số CMND ! ");
                        return;
                    }
                    if (khachHangDialog.txtEmail.getText().trim().equals("")) {
                        khachHangDialog.errorlb.setText("Vui lòng điền email ! ");
                        return;
                    }
                    if (!khachHangDialog.txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        khachHangDialog.errorlb.setText("Email không hợp lệ ! ");
                        return;
                    }
                    Object[] values = new Object[8];
                    values[0] = 0;
                    values[1] = khachHangDialog.txtTen.getText();
                    values[2] = khachHangDialog.txtSdt.getText();
                    values[3] = khachHangDialog.txtDiaChi.getText();
                    values[4] = khachHangDialog.txtCMND.getText();
                    values[5] = khachHangDialog.txtGhiChu.getText();
                    if (khachHangDialog.cbNam.isSelected()) {
                        values[6] = "Nam";
                    } else if (!khachHangDialog.cbNu.isSelected() && !khachHangDialog.cbNam.isSelected()) {
                        khachHangDialog.errorlb.setText("Vui lòng chọn giới tính ! ");
                        return;
                    } else {
                        values[6] = "Nữ";
                    }
                    values[7] = khachHangDialog.txtEmail.getText();
                    khachHangController.insert(values);

                }
            });
        }

        khachHangDialog.editBT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //validate

                if (khachHangDialog.txtTen.getText().trim().equals("")) {
                    khachHangDialog.errorlb.setText("Vui lòng điền tên khách hàng ! ");
                    return;
                }
                if (khachHangDialog.txtSdt.getText().trim().equals("")) {
                    khachHangDialog.errorlb.setText("Vui lòng điền số điện thoại ! ");
                    return;
                }
                if (!khachHangDialog.txtSdt.getText().matches("^\\d{10}$")) {
                    khachHangDialog.errorlb.setText("Số điện thoại không hợp lệ ! ");
                    return;
                }

                if (khachHangDialog.txtDiaChi.getText().trim().equals("")) {
                    khachHangDialog.errorlb.setText("Vui lòng điền địa chỉ ! ");
                    return;
                }
                if (khachHangDialog.txtCMND.getText().trim().equals("")) {
                    khachHangDialog.errorlb.setText("Vui lòng điền số CMND ! ");
                    return;
                }
                if (khachHangDialog.txtEmail.getText().trim().equals("")) {
                    khachHangDialog.errorlb.setText("Vui lòng điền email ! ");
                    return;
                }
                if (!khachHangDialog.txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    khachHangDialog.errorlb.setText("Email không hợp lệ ! ");
                    return;
                }
                Object[] values = new Object[8];
                values[0] = editId;
                values[1] = khachHangDialog.txtTen.getText();
                values[2] = khachHangDialog.txtSdt.getText();
                values[3] = khachHangDialog.txtDiaChi.getText();
                values[4] = khachHangDialog.txtCMND.getText();
                values[5] = khachHangDialog.txtGhiChu.getText();
                if (khachHangDialog.cbNam.isSelected()) {
                    values[6] = "Nam";
                } else if (!khachHangDialog.cbNu.isSelected() && !khachHangDialog.cbNam.isSelected()) {
                    khachHangDialog.errorlb.setText("Vui lòng chọn giới tính ! ");
                    return;
                } else {
                    values[6] = "Nữ";
                }
                values[7] = khachHangDialog.txtEmail.getText();
                khachHangController.edit(values);
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
        tblKhachHang = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jPanel2 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnCapNhap = new javax.swing.JLabel();

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(tblKhachHang);

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
           khachHangDialog.addBT.setVisible(true);
        khachHangDialog.editBT.setVisible(false);
        khachHangDialog.errorlb.setText("");
        khachHangDialog.txtTen.setText("");
        khachHangDialog.txtSdt.setText("");
        khachHangDialog.txtDiaChi.setText("");
        khachHangDialog.txtCMND.setText("");
        khachHangDialog.txtGhiChu.setText("");
        khachHangDialog.txtEmail.setText("");
        khachHangDialog.cbNam.setSelected(false);
        khachHangDialog.cbNu.setSelected(false);
        String tieuDe = (String) khachHangController.getViewBag().get("tieu_de");
        khachHangDialog.title.setText("Thêm Khách Hàng " + tieuDe);
        khachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnThemMouseClicked
    private Integer editId;
    private void btnCapNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhapMouseClicked
        // TODO add your handling code here:
khachHangDialog.addBT.setVisible(false);
        khachHangDialog.editBT.setVisible(true);
        if (tblKhachHang.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn dòng cần sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        editId = (Integer) tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0);

        int dong = tblKhachHang.getSelectedRow();
        khachHangDialog.txtTen.setText(tblKhachHang.getValueAt(dong, 1).toString());
        khachHangDialog.txtSdt.setText(tblKhachHang.getValueAt(dong, 2).toString());
        khachHangDialog.txtDiaChi.setText(tblKhachHang.getValueAt(dong, 3).toString());
        khachHangDialog.txtCMND.setText(tblKhachHang.getValueAt(dong, 4).toString());
        khachHangDialog.txtGhiChu.setText(tblKhachHang.getValueAt(dong, 5).toString());
        if (tblKhachHang.getValueAt(dong, 6).toString().equals("Nam")) {
            khachHangDialog.cbNam.setSelected(true);
        } else {
            khachHangDialog.cbNam.setSelected(false);
        }
        if (tblKhachHang.getValueAt(dong, 6).toString().equals("Nữ")) {
            khachHangDialog.cbNu.setSelected(true);
        } else {
            khachHangDialog.cbNu.setSelected(false);
        }
        khachHangDialog.txtEmail.setText(tblKhachHang.getValueAt(dong, 7).toString());
        String tieuDe = (String) khachHangController.getViewBag().get("tieu_de");
        khachHangDialog.title.setText("Cập nhập Khách Hàng " + tieuDe);
        khachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnCapNhapMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        exportExcel(tblKhachHang);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased

        String ten = "%" + searchText1.getText() + "%";
        System.out.println(ten);
        khachHangController.search(ten);
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
    private com.raven.swing.TableColumn tblKhachHang;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, tblKhachHang);
        if (khachHangDialog != null) {
            khachHangDialog.setVisible(false);
        }
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, tblKhachHang);
    }
    private KhachHangController khachHangController;

    @Override
    public void setController(AbsController controller) {
        khachHangController = (KhachHangController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
