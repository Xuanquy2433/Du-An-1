package com.raven.form;

import Controller.AbsController;
import Controller.KhuyenMaiController;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import java.awt.Color;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.oval.ConstraintViolation;

public class KhuyenMaiPnl extends javax.swing.JPanel implements ViewInterface {

    KhuyenMaiController khuyenMaiControllerl;

    public KhuyenMaiPnl() {
        initComponents();
        setOpaque(false);
        khuyenMaiController = new KhuyenMaiController(this);
//        System.out.println(DangNhapPnl.tenDangNhap);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.raven.swing.TableColumn();
        jLabel2 = new javax.swing.JLabel();
        scrollBar1 = new com.raven.swing.ScrollBar();
        kGradientPanel2 = new com.raven.swing.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPhanTramKm = new javax.swing.JTextField();
        txtghiChu = new javax.swing.JTextField();
        errorLB = new javax.swing.JLabel();
        bthThem = new com.raven.swing.KButton();
        btnXoa = new com.raven.swing.KButton();
        btnSua = new com.raven.swing.KButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setText("Khuyến Mãi");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Gender", "Age", "Email", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 79, 79));
        jLabel2.setText("Table Data");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel1.setOpaque(false);

        txtTen.setBackground(new Color(0,0,0,0));
        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel3.setText("Tên khuyến mãi");

        jLabel4.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel4.setText("Ghi chú");

        jLabel5.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel5.setText("Phần trăm khuyến mãi (%)");

        txtPhanTramKm.setBackground(new Color(0,0,0,0));
        txtPhanTramKm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtPhanTramKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhanTramKmActionPerformed(evt);
            }
        });

        txtghiChu.setBackground(new Color(0,0,0,0));
        txtghiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtghiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtghiChuActionPerformed(evt);
            }
        });

        errorLB.setFont(new java.awt.Font("UTM Avo", 2, 12)); // NOI18N
        errorLB.setForeground(new java.awt.Color(255, 0, 0));
        errorLB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLB, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPhanTramKm, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(221, 221, 221))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhanTramKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtghiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        bthThem.setText("Thêm");
        bthThem.setkEndColor(new java.awt.Color(0, 153, 102));
        bthThem.setkHoverColor(new java.awt.Color(0, 153, 102));
        bthThem.setkHoverEndColor(new java.awt.Color(0, 153, 102));
        bthThem.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        bthThem.setkHoverStartColor(new java.awt.Color(0, 153, 102));
        bthThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setkEndColor(new java.awt.Color(0, 153, 102));
        btnXoa.setkHoverColor(new java.awt.Color(0, 153, 102));
        btnXoa.setkHoverEndColor(new java.awt.Color(0, 153, 102));
        btnXoa.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        btnXoa.setkHoverStartColor(new java.awt.Color(0, 153, 102));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Cập nhập");
        btnSua.setkEndColor(new java.awt.Color(0, 153, 102));
        btnSua.setkHoverColor(new java.awt.Color(0, 153, 102));
        btnSua.setkHoverEndColor(new java.awt.Color(0, 153, 102));
        btnSua.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        btnSua.setkHoverStartColor(new java.awt.Color(0, 153, 102));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bthThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bthThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void txtPhanTramKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhanTramKmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhanTramKmActionPerformed

    private void txtghiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtghiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtghiChuActionPerformed

    private void bthThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthThemActionPerformed
        // TODO add your handling code here:.
        if (txtTen.getText().trim().equals("")) {
            errorLB.setText("Tên khuyến mãi không được bỏ trống");
            return;
        }
        if (txtPhanTramKm.getText().trim().equals("")) {
            errorLB.setText("Phần trăm khuyến mãi không được bỏ trống");
            return;
        }

        Object[] values = new Object[4];
        values[0] = 0;
        values[1] = txtTen.getText();
        values[2] = Integer.valueOf(txtPhanTramKm.getText());
        values[3] = txtghiChu.getText();
        khuyenMaiController.insert(values);

    }//GEN-LAST:event_bthThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (table.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn dòng cần sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtTen.getText().trim().equals("")) {
            errorLB.setText("Tên khuyến mãi không được bỏ trống");
            return;
        }
        if (txtPhanTramKm.getText().trim().equals("")) {
            errorLB.setText("Phần trăm khuyến mãi không được bỏ trống");
            return;
        }

        int dong = table.getSelectedRow();
        Integer editId = (Integer) table.getValueAt(dong, 0);
        System.out.println(editId);

        Object[] values = new Object[4];
        values[0] = editId;
        values[1] = txtTen.getText();
        values[2] = Integer.valueOf(txtPhanTramKm.getText());
        values[3] = txtghiChu.getText();
        khuyenMaiController.edit(values);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:

        if (table.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn dòng cần xóa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Integer deleteId = (Integer) table.getValueAt(table.getSelectedRow(), 0);
            System.out.println(deleteId);
            // viết khối lệnh confirm và xóa
            int option = JOptionPane.showConfirmDialog(new Frame(), "Bạn có chắc chắn muốn xóa ?", "Xác nhận thông báo ! ", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {

                khuyenMaiController.delete(deleteId);

            } else {
                return;
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int dong = table.getSelectedRow();
        Integer editId = (Integer) table.getValueAt(dong, 0);
        System.out.println(editId);
        errorLB.setText("");
        txtPhanTramKm.setText(table.getValueAt(dong, 2).toString());
        txtTen.setText(table.getValueAt(dong, 1).toString());
        txtghiChu.setText(table.getValueAt(dong, 3).toString());
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton bthThem;
    private com.raven.swing.KButton btnSua;
    private com.raven.swing.KButton btnXoa;
    public javax.swing.JLabel errorLB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.KGradientPanel kGradientPanel2;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.TableColumn table;
    public javax.swing.JTextField txtPhanTramKm;
    public javax.swing.JTextField txtTen;
    public javax.swing.JTextField txtghiChu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, table);
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, table);
    }
    private KhuyenMaiController khuyenMaiController;

    @Override
    public void setController(AbsController controller) {
        khuyenMaiController = (KhuyenMaiController) khuyenMaiController;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
