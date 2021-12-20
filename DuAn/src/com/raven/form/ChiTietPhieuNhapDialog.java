/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Controller.AbsController;
import Controller.ChiTietPhieuNhapController;
import Controller.ChuyenDoi;
import Controller.PhieuNhapController;
import MODEL.LoaiSanPham;
import MODEL.SanPham;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import com.raven.swing.MImage;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
public class ChiTietPhieuNhapDialog extends javax.swing.JDialog implements ViewInterface {

    public ChiTietPhieuNhapDialog() {
    }
    
    int idSanPham =  PhieuNhapPnl.idSanPham;

    public ChiTietPhieuNhapDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(MImage.getAppIcon());
        this.setTitle("Detail");
//     idSanPham =  PhieuNhapPnl.listID.get(0).intValue();
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietPhieuNhap = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        btnThem2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbSanPham = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txtGiatien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        errorLB = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/arrow-55-16.png"))); // NOI18N
        jLabel3.setText("     Xuất file");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblChiTietPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblChiTietPhieuNhap);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.add(scrollBar1, java.awt.BorderLayout.LINE_END);

        btnThem2.setBackground(new java.awt.Color(0, 153, 153));
        btnThem2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnThem2.setForeground(new java.awt.Color(255, 255, 255));
        btnThem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/plus-16.png"))); // NOI18N
        btnThem2.setText("     Thêm mới");
        btnThem2.setOpaque(true);
        btnThem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThem2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel2.setText("Sản phẩm");

        cbbSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSanPhamItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel4.setText("Số lượng");

        jLabel6.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel6.setText("Giá tiền");

        txtGiatien.setBackground(new Color(0,0,0,0));
        txtGiatien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGiatien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiatienActionPerformed(evt);
            }
        });
        txtGiatien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiatienKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel9.setText("Tổng tiền");

        txtTongTien.setBackground(new Color(0,0,0,0));
        txtTongTien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTongTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienKeyReleased(evt);
            }
        });

        errorLB.setFont(new java.awt.Font("UTM Avo", 2, 12)); // NOI18N
        errorLB.setForeground(new java.awt.Color(255, 0, 0));
        errorLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        errorLB.setText("jLabel1");

        lbStatus.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(0, 0, 204));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText("*Thêm thành công");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(errorLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtTongTien)
                                                    .addComponent(txtGiatien)
                                                    .addComponent(spnSoLuong)
                                                    .addComponent(cbbSanPham, 0, 184, Short.MAX_VALUE))))
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtGiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        exportExcel(tblChiTietPhieuNhap);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnThem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem2MouseClicked
        // TODO add your handling code here:
        
        System.out.println("id chi tiet" + Integer.parseInt(PhieuNhapPnl.id));
        double giaTien = ChuyenDoi.SoDouble(txtGiatien.getText());
        double tongTien = ChuyenDoi.SoDouble(txtTongTien.getText());

        Integer soLuong = Integer.parseInt(spnSoLuong.getValue().toString());
        if (soLuong < 1) {
            errorLB.setText("Số lượng phải lớn hơn 0 ! ");
            return;
        }

        if (String.valueOf(giaTien).trim().equals("")) {
            errorLB.setText("Vui lòng nhập giá tiền ");
            return;
        }

        if (giaTien < 10000) {
            errorLB.setText("Giá tiền phải lớn hơn 10000 ");
            return;
        }

        if (String.valueOf(tongTien).trim().equals("")) {
            errorLB.setText("Vui lòng nhập tổng tiền ");
            return;
        }
        if (tongTien < 20000) {
            errorLB.setText("Tổng tiền phải lớn hơn 20000 ");
            return;
        }

        chiTietPhieuNhapController.them(Integer.parseInt(PhieuNhapPnl.id), idSanPham, soLuong, giaTien, tongTien);
        lbStatus.setText("*Thêm thành công");

    }//GEN-LAST:event_btnThem2MouseClicked

    private void txtGiatienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiatienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiatienActionPerformed

    private void txtGiatienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiatienKeyReleased
        // TODO add your handling code here:
        String dau = txtGiatien.getText();
        double chuyen = ChuyenDoi.SoDouble(dau);
        txtGiatien.setText(ChuyenDoi.SoString(chuyen));
    }//GEN-LAST:event_txtGiatienKeyReleased

    private void txtTongTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienKeyReleased
        // TODO add your handling code here:
        String dau = txtTongTien.getText();
        double chuyen = ChuyenDoi.SoDouble(dau);
        txtTongTien.setText(ChuyenDoi.SoString(chuyen));
    }//GEN-LAST:event_txtTongTienKeyReleased

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:
//        String id = searchText1.getText();
//
//        if (!id.matches(".*\\d.*")) {
//            chiTietPhieuNhapController.loadList();
//            System.out.println("Lỗi nhập string");
//            return;
//        } else if (id.equals("")) {
//            chiTietPhieuNhapController.loadList();
//            return;
//        }
//
//        System.out.println(id);
//        chiTietPhieuNhapController.search(String.valueOf(PhieuNhapPnl.id), id);
    }//GEN-LAST:event_searchText1KeyReleased

    private void cbbSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSanPhamItemStateChanged
        int indexCBB = cbbSanPham.getSelectedIndex();
        for (int i = 0; i < PhieuNhapPnl.listID.size(); i++) {
            if (indexCBB == i) {
                idSanPham = PhieuNhapPnl.listID.get(i);
                System.out.println(idSanPham);
            }
        }
    }//GEN-LAST:event_cbbSanPhamItemStateChanged
    public Integer idPhieuNhap;

    public Integer getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(Integer idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;

        ChiTietPhieuNhapController chiTietPhieuNhapController = new ChiTietPhieuNhapController(this);

    }

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietPhieuNhapDialog dialog = new ChiTietPhieuNhapDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnThem2;
    public javax.swing.JComboBox<SanPham> cbbSanPham;
    public javax.swing.JLabel errorLB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbStatus;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.SearchText searchText1;
    public javax.swing.JSpinner spnSoLuong;
    private com.raven.swing.TableColumn tblChiTietPhieuNhap;
    public javax.swing.JTextField txtGiatien;
    public javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> data) {
        ViewImp.viewList(data, tblChiTietPhieuNhap);
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, tblChiTietPhieuNhap);
    }

    private ChiTietPhieuNhapController chiTietPhieuNhapController;

    @Override
    public void setController(AbsController controller) {
        chiTietPhieuNhapController = (ChiTietPhieuNhapController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}