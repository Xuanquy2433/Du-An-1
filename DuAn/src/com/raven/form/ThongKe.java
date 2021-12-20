package com.raven.form;

import Controller.AbsController;
import Controller.ChuyenDoi;
import Controller.HoaDonController;
import Controller.ThongKeController;
import MODEL.HoaDon;
import MODEL.SanPham;
import VIEW.ViewImp;

import VIEW.ViewInterface;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JPanel;
import net.sf.oval.ConstraintViolation;

public final class ThongKe extends javax.swing.JPanel implements ViewInterface {
    
    ThongKeController thongKeController = new ThongKeController(this);
    List<Object[]> dataThang = thongKeController.loadMonth();
    List<Object[]> dataNgay = thongKeController.loadNgay();
    List<Object[]> dataKhachHang = thongKeController.loadKhachHang();

    public ThongKe() {
        System.out.println("ok");
        initComponents();
        setOpaque(false);
        init();
        showSanPhamBanChay();
        

    }

    public void showSanPhamBanChay() {
        thongKeController.DSSanPhamBanChay(tableData);
    }
    public void showSanPhamTonKho() {
        thongKeController.DSSanPhamTonKho(tableData);
    }

    private void init() {
        
        for (Object[] obj : dataNgay) {
            String ngay = String.valueOf(obj[0]);
            double tongTien = Double.parseDouble(obj[1].toString());
            chart.addData(new ModelChart(ngay, new double[]{0, tongTien, 0, 0}));
        }
        chart.start();
        chart.addLegend("", new Color(255,255,255));
        chart.addLegend("Tổng Doanh Thu", new Color(135, 189, 245));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new com.raven.swing.PanelRound();
        chart = new com.raven.chart.Chart();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new com.raven.swing.TableColumn();
        jLabel2 = new javax.swing.JLabel();
        scrollBar1 = new com.raven.swing.ScrollBar();
        cbbThongKeDoanhThu = new javax.swing.JComboBox<>();
        cbbThongKe = new javax.swing.JComboBox<>();
        dc1st = new com.toedter.calendar.JDateChooser();
        dc2nd = new com.toedter.calendar.JDateChooser();
        btnTimKiem = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setText("Biểu đồ doanh thu");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Sản Phẩm", "Tên Loại Phẩm", "Tên Sản Phẩm", "Số Lượng Đã Bán", "Giá Bán", "Đơn Vị Tính", "Số Lượng Trong Kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableData);
        if (tableData.getColumnModel().getColumnCount() > 0) {
            tableData.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 79, 79));
        jLabel2.setText("Thống kê sản phẩm");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        cbbThongKeDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống Tháng Hiện tại", "Thống Kê Năm", "Khách Hàng Tiêu Biểu" }));
        cbbThongKeDoanhThu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThongKeDoanhThuItemStateChanged(evt);
            }
        });

        cbbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm bán chạy", "Sản phẩm ít được quan tâm" }));
        cbbThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThongKeItemStateChanged(evt);
            }
        });

        btnTimKiem.setText("jButton1");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dc1st, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc2nd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbThongKeDoanhThu)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addComponent(dc2nd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dc1st, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
  public void showSanPham() {
        DefaultTableModel tableModel = (DefaultTableModel) tableData.getModel();
        for (int rowIndex = tableModel.getRowCount() - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }
        ArrayList<SanPham> list = thongKeController.DSSanPham();
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getIdLoaiSanPham();
            row[2] = list.get(i).getTenSanPham();
            row[3] = list.get(i).getGiaNhap();
            row[4] = list.get(i).getGiaBan();
            row[5] = list.get(i).getSoLuong();
            row[6] = list.get(i).getDVT();

            model.addRow(row);

        }
    }

    public void showHoaDon() {
        DefaultTableModel tableModel = (DefaultTableModel) tableData.getModel();
        for (int rowIndex = tableModel.getRowCount() - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }
        ArrayList<HoaDon> list = thongKeController.DSHoaDOn();
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getIdKhachHang();
            row[2] = list.get(i).getIdKhuyenMai();
            row[3] = list.get(i).getIdNhanVien();
            row[4] = list.get(i).getNgayLap();
            row[5] = list.get(i).getSoLuong();
            row[6] = list.get(i).getTongTien();

            model.addRow(row);

        }
    }
    private void cbbThongKeDoanhThuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThongKeDoanhThuItemStateChanged
        if (cbbThongKeDoanhThu.getSelectedIndex() == 0) {
            
            chart.clear();
            revalidate();
            repaint();
            for (Object[] obj : dataNgay) {
                String ngay = String.valueOf(obj[0]);
                double tongTien = Double.parseDouble(obj[1].toString());
                chart.addData(new ModelChart(ngay, new double[]{0, tongTien, 0, 0}));
            }
            chart.start();

        } else if ((cbbThongKeDoanhThu.getSelectedIndex() == 1)) {
            chart.clear();
            
            for (Object[] obj : dataThang) {
                String thang = String.valueOf(obj[0]);
                double tongTien = Double.parseDouble(obj[1].toString());
                chart.addData(new ModelChart(thang, new double[]{0, tongTien, 0, 0}));
            }
            chart.start();
        } else if ((cbbThongKeDoanhThu.getSelectedIndex() == 2)) {
            chart.clear();
            for (Object[] obj : dataKhachHang) {
                String KH = String.valueOf(obj[0]);
                double tongTien = Double.parseDouble(obj[1].toString());
                chart.addData(new ModelChart(KH, new double[]{0, tongTien, 0, 0}));
            }
            chart.start();
        }
    }//GEN-LAST:event_cbbThongKeDoanhThuItemStateChanged

    private void cbbThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThongKeItemStateChanged
        // TODO add your handling code here:
        if (cbbThongKe.getSelectedIndex() == 0) {
            showSanPhamBanChay();
        } else if (cbbThongKe.getSelectedIndex() == 1) {
            showSanPhamTonKho();
        }
    }//GEN-LAST:event_cbbThongKeItemStateChanged

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        
        chart.clear();
        List<Object[]> dataTimKiem = thongKeController.SearchDate(dc1st.getDate(), dc2nd.getDate());
        for (Object[] obj : dataTimKiem) {
            String thang = String.valueOf(obj[0]);
            Double doanhThu = ChuyenDoi.SoDouble(obj[1].toString());
            chart.addData(new ModelChart(thang, new double[]{0, doanhThu, 0, 0}));
        }
        chart.start();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbThongKe;
    private javax.swing.JComboBox<String> cbbThongKeDoanhThu;
    private com.raven.chart.Chart chart;
    private com.toedter.calendar.JDateChooser dc1st;
    private com.toedter.calendar.JDateChooser dc2nd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.ScrollBar scrollBar1;
    public static com.raven.swing.TableColumn tableData;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
//        ViewImp.viewList(rows, tableData);

    }

    @Override
    public void setColumnNames(String[] columnNames) {
//        ViewImp.setColumnNames(columnNames, tableData);
    }
    private ThongKeController thongKeController1;

    @Override
    public void setController(AbsController controller) {
        thongKeController1 = (ThongKeController) thongKeController1;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
