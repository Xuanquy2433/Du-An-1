/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Controller.AbsController;
import Controller.ChuyenDoi;
import Controller.PhieuNhapController;
import MODEL.KhuyenMai;
import MODEL.NhaCungCap;
import MODEL.SanPham;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import duan.dialog.HandlePhieuNhapDal;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
public class PhieuNhapPnl extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form NhaCungCapPnl
     */
     static int idSanPham = 0;
    private HandlePhieuNhapDal phieuNhapDal = null;
    public static List<Integer> listID = new ArrayList<Integer>();;
    public PhieuNhapPnl() {
        initComponents();
        PhieuNhapController phieuNhapController = new PhieuNhapController(this);

        if (phieuNhapDal == null) {
            phieuNhapDal = new HandlePhieuNhapDal(null, true);
            phieuNhapDal.addBT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    NhaCungCap nhaCC = (NhaCungCap) phieuNhapDal.cbbNhaCungCap.getSelectedItem();
                    Integer idNhaCC = nhaCC.getIdNhaCungCap();
                    System.out.println(idNhaCC);
                    java.sql.Timestamp now = new Timestamp((new java.util.Date()).getTime());
                    //validate

                    double tongTien = ChuyenDoi.SoDouble(phieuNhapDal.txtTongTien.getText());

                    if (String.valueOf(tongTien).trim().equals("")) {
                        phieuNhapDal.errorlb.setText("Vui lòng nhập tổng tiền ! ");
                        return;
                    }
                    if (tongTien < 10000) {
                        phieuNhapDal.errorlb.setText("Tổng tiền phải lớn hơn 10.000 ! ");
                        return;
                    }

                    if (phieuNhapDal.txtTrangThai.getText().trim().equals("")) {
                        phieuNhapDal.errorlb.setText("Vui lòng nhập trạng thái ! ");
                        return;
                    }
                    if (Integer.parseInt(phieuNhapDal.spnSoLuong.getValue().toString()) < 1) {
                        phieuNhapDal.errorlb.setText("Số lượng phải lớn hơn 0 ! ");
                        return;
                    }

                    Object[] values = new Object[6];
                    values[0] = 0;
                    values[1] = idNhaCC;
                    values[2] = now;
                    values[3] = ChuyenDoi.SoDouble(phieuNhapDal.txtTongTien.getText());
                    values[4] = phieuNhapDal.txtTrangThai.getText();
                    values[5] = Integer.parseInt(phieuNhapDal.spnSoLuong.getValue().toString());

                    phieuNhapController.insert(values);
                }
            });
        }

        phieuNhapDal.editBT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                NhaCungCap nhaCC = (NhaCungCap) phieuNhapDal.cbbNhaCungCap.getSelectedItem();
                Integer idNhaCC = nhaCC.getIdNhaCungCap();
                System.out.println(idNhaCC);
                java.sql.Timestamp now = new Timestamp((new java.util.Date()).getTime());
                //validate
                if (phieuNhapDal.txtTongTien.getText().trim().equals("")) {
                    phieuNhapDal.errorlb.setText("Vui lòng nhập tổng tiền ! ");
                    return;
                }
                if (phieuNhapDal.txtTrangThai.getText().trim().equals("")) {
                    phieuNhapDal.errorlb.setText("Vui lòng nhập trạng thái ! ");
                    return;
                }
                if (Integer.parseInt(phieuNhapDal.spnSoLuong.getValue().toString()) < 1) {
                    phieuNhapDal.errorlb.setText("Số lượng phải lớn hơn 0 ! ");
                    return;
                }

                Object[] values = new Object[6];
                values[0] = editID;
                values[1] = idNhaCC;
                values[2] = now;
                values[3] = ChuyenDoi.SoDouble(phieuNhapDal.txtTongTien.getText());
                values[4] = phieuNhapDal.txtTrangThai.getText();
                values[5] = Integer.parseInt(phieuNhapDal.spnSoLuong.getValue().toString());

                phieuNhapController.edit(values);

            }
        });

        DefaultComboBoxModel<NhaCungCap> modle = (DefaultComboBoxModel<NhaCungCap>) phieuNhapDal.cbbNhaCungCap.getModel();
        modle.removeAllElements();
        List<NhaCungCap> sanPhams = phieuNhapController.layCbbNhaCungCap();
        modle.addAll(sanPhams);
        modle.setSelectedItem(sanPhams.get(0));
        
        

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
        tblPhieuNhap = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jPanel2 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnCapNhap = new javax.swing.JLabel();
        txtChiTiet = new javax.swing.JLabel();

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tblPhieuNhap);

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

        txtChiTiet.setBackground(new java.awt.Color(0, 153, 153));
        txtChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        txtChiTiet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/key.png"))); // NOI18N
        txtChiTiet.setText("    Chi Tiết");
        txtChiTiet.setOpaque(true);
        txtChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtChiTietMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhap, jLabel1, txtChiTiet});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        exportExcel(tblPhieuNhap);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        phieuNhapDal.addBT.setVisible(true);
        phieuNhapDal.editBT.setVisible(false);
        String tieuDe = (String) phieuNhapController.getViewBag().get("tieu_de");
        phieuNhapDal.title.setText("Thêm Phiếu Nhập ");

        phieuNhapDal.errorlb.setText("");
        phieuNhapDal.txtTongTien.setText("");
        phieuNhapDal.txtTrangThai.setText("");
        phieuNhapDal.spnSoLuong.setValue(1);

        phieuNhapDal.setVisible(true);

    }//GEN-LAST:event_btnThemMouseClicked

    private Integer editID;
    private void btnCapNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhapMouseClicked

phieuNhapDal.addBT.setVisible(false);
        phieuNhapDal.editBT.setVisible(true);        // TODO add your handling code here:
        if (tblPhieuNhap.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn dòng cần sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        editID = (Integer) tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(), 0);
        String tieuDe = (String) phieuNhapController.getViewBag().get("tieu_de");
        phieuNhapDal.title.setText("Cập Nhập Phiếu Nhập ");

        int dong = tblPhieuNhap.getSelectedRow();
        phieuNhapDal.errorlb.setText("");
        phieuNhapDal.txtTrangThai.setText(tblPhieuNhap.getValueAt(dong, 4).toString());
        phieuNhapDal.txtTongTien.setText(tblPhieuNhap.getValueAt(dong, 3).toString());
        phieuNhapDal.spnSoLuong.setValue(tblPhieuNhap.getValueAt(dong, 5));

        phieuNhapDal.setVisible(true);


    }//GEN-LAST:event_btnCapNhapMouseClicked

    private void txtChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtChiTietMouseClicked
        // TODO add your handling code here:
             for (int i = 0; i < PhieuNhapPnl.listID.size(); i++) {
            idSanPham= PhieuNhapPnl.listID.get(0);
            
            
        }
        System.out.println("idsanpham:" +idSanPham);
        if (tblPhieuNhap.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn phiếu cần xem ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("click");

        ChiTietPhieuNhapDialog chiTietPhieuNhapDialog = new ChiTietPhieuNhapDialog(null, true);
        chiTietPhieuNhapDialog.errorLB.setText("");
        chiTietPhieuNhapDialog.lbStatus.setText("");

        id = tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(), 0).toString();

        chiTietPhieuNhapDialog.setIdPhieuNhap((Integer) tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(), 0));

 

//        List<SanPham> sanPhams = phieuNhapController.layCbbSanPham();

//        modle.setSelectedItem(sanPhams.get(0));



        ArrayList<SanPham> list = phieuNhapController.DSSanPham();

       DefaultComboBoxModel<SanPham> modle = (DefaultComboBoxModel<SanPham>) chiTietPhieuNhapDialog.cbbSanPham.getModel();
       modle.removeAllElements();
DefaultComboBoxModel dml= new DefaultComboBoxModel();
for (int i = 0; i < list.size(); i++) {
  dml.addElement(list.get(i).getTenSanPham());
  listID.add(list.get(i).getIdSanPham());
    System.out.println(listID);
  
}


chiTietPhieuNhapDialog.cbbSanPham.setModel(dml);
chiTietPhieuNhapDialog.setVisible(true);
  
    }//GEN-LAST:event_txtChiTietMouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:
        String id = searchText1.getText();

        if (!id.matches(".*\\d.*")) {
            phieuNhapController.loadList();
            System.out.println("Lỗi nhập string");
            return;
        } else if (id.equals("")) {
            phieuNhapController.loadList();
            return;
        }

        System.out.println(id);
        phieuNhapController.search(id);
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
    public static String id;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCapNhap;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.TableColumn tblPhieuNhap;
    private javax.swing.JLabel txtChiTiet;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, tblPhieuNhap);
        if (phieuNhapDal != null) {
            phieuNhapDal.setVisible(false);
        }
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, tblPhieuNhap);
    }
    private PhieuNhapController phieuNhapController;

    @Override
    public void setController(AbsController controller) {
        phieuNhapController = (PhieuNhapController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {

    }
}
