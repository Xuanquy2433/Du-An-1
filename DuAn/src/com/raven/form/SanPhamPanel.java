/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import Controller.AbsController;
import Controller.ChiTietSanPhamController;
import Controller.ChuyenDoi;
import Controller.SanPhamController;
import DAO.DBConnection;
import DAO.SanPhamDAO;
import MODEL.LoaiSanPham;
import MODEL.SanPham;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import duan.dialog.HandleSanPhamDal;
import java.awt.Component;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.sf.oval.ConstraintViolation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Admin
 */
public class SanPhamPanel extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form KhachHangPanel
     */
    ChiTietSanPhamDialog chiTietSanPhamDialog = new ChiTietSanPhamDialog(null, true);
    private HandleSanPhamDal sanPhamDal = null;

    public  SanPhamPanel() {
        initComponents();
        SanPhamController sanPhamController = new SanPhamController(this);
        
        
//        showSanPham();
        if (sanPhamDal == null) {
            sanPhamDal = new HandleSanPhamDal(null, true);
            sanPhamDal.addBT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //validate
                    double giaNhap = ChuyenDoi.SoDouble(sanPhamDal.txtGiaNhap.getText());
                    double giaBan = ChuyenDoi.SoDouble(sanPhamDal.txtGiaBan.getText());
                    Integer soLuong = Integer.parseInt(sanPhamDal.spnSoLuong.getValue().toString());

                    if (sanPhamDal.txtTen.getText().trim().equals("")) {
                        sanPhamDal.errorLB.setText("Vui lòng điền tên sản phẩm ! ");
                        return;
                    }

                    if (giaNhap < 10000) {
                        sanPhamDal.errorLB.setText("Giá nhập phải lớn hơn 10.000 ");
                        return;
                    }

                    if (giaBan < 10000) {
                        sanPhamDal.errorLB.setText("Giá bán phải lớn hơn 10.000 ");
                        return;
                    }

                    if (giaBan < giaNhap) {
                        sanPhamDal.errorLB.setText("Giá bán phải lớn hơn giá nhập ! ");
                        return;
                    }

                    if (soLuong < 1) {
                        sanPhamDal.errorLB.setText("Số lượng phải lớn hơn 0 ! ");
                        return;
                    }

                    if (sanPhamDal.txtDVT.getText().trim().equals("")) {
                        sanPhamDal.errorLB.setText("Vui lòng điền đơn vị tính ! ");
                        return;
                    }
                    LoaiSanPham loaiSp = (LoaiSanPham) sanPhamDal.cbbLoaiSP.getSelectedItem();
                    Integer idLoaiSP = loaiSp.getId();
                    System.out.println(idLoaiSP);

                    sanPhamController.them(idLoaiSP, sanPhamDal.txtTen.getText(), giaNhap, giaBan, Integer.valueOf(sanPhamDal.spnSoLuong.getValue().toString()),sanPhamDal.txtDVT.getText());
                    sanPhamController.loadList();
                }
            });
        }

        sanPhamDal.editBT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //validate
                double giaNhap = ChuyenDoi.SoDouble(sanPhamDal.txtGiaNhap.getText());
                double giaBan = ChuyenDoi.SoDouble(sanPhamDal.txtGiaBan.getText());
                Integer soLuong = Integer.parseInt(sanPhamDal.spnSoLuong.getValue().toString());

                if (sanPhamDal.txtTen.getText().trim().equals("")) {
                    sanPhamDal.errorLB.setText("Vui lòng điền tên sản phẩm ! ");
                    return;
                }

                if (giaNhap < 10000) {
                    sanPhamDal.errorLB.setText("Giá nhập phải lớn hơn 10.000 ");
                    return;
                }

                if (giaBan < 10000) {
                    sanPhamDal.errorLB.setText("Giá bán phải lớn hơn 10.000 ");
                    return;
                }

                if (giaBan < giaNhap) {
                    sanPhamDal.errorLB.setText("Giá bán phải lớn hơn giá nhập ! ");
                    return;
                }

                if (soLuong < 1) {
                    sanPhamDal.errorLB.setText("Số lượng phải lớn hơn 0 ! ");
                    return;
                }

                if (sanPhamDal.txtDVT.getText().trim().equals("")) {
                    sanPhamDal.errorLB.setText("Vui lòng điền đơn vị tính ! ");
                    return;
                }
                LoaiSanPham loaiSp = (LoaiSanPham) sanPhamDal.cbbLoaiSP.getSelectedItem();
                Integer idLoaiSP = loaiSp.getId();
                System.out.println(idLoaiSP);

                Object[] values = new Object[7];
                values[0] = editId;
                values[1] = idLoaiSP;
                values[2] = sanPhamDal.txtTen.getText();
                values[3] = ChuyenDoi.SoDouble(sanPhamDal.txtGiaNhap.getText());
                values[4] = ChuyenDoi.SoDouble(sanPhamDal.txtGiaBan.getText());
                values[5] = Integer.valueOf(sanPhamDal.spnSoLuong.getValue().toString());

                values[6] = sanPhamDal.txtDVT.getText();

                sanPhamController.edit(values);

            }

        });
        
        chiTietSanPhamDialog.addWindowListener(new WindowAdapter() 
{
  public void windowClosed(WindowEvent e)
  {
    sanPhamController.loadList();
  }
  });
  
  
        DefaultComboBoxModel<LoaiSanPham> modle = (DefaultComboBoxModel<LoaiSanPham>) sanPhamDal.cbbLoaiSP.getModel();
        modle.removeAllElements();
        List<LoaiSanPham> sanPhams = sanPhamController.layCbbLoaiSP();
        modle.addAll(sanPhams);
        modle.setSelectedItem(sanPhams.get(0));
    }
public class CurrencyTableCellRenderer extends DefaultTableCellRenderer {

    private final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        final Component result = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            setHorizontalAlignment(JLabel.RIGHT);
            setText(FORMAT.format(value));
        } else {
            setText("");
        }
        return result;
    }
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
        tblSanPham = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jPanel2 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        btnCapNhap = new javax.swing.JLabel();
        btnChiTiet = new javax.swing.JLabel();

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

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

        btnChiTiet.setBackground(new java.awt.Color(0, 153, 153));
        btnChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTiet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/key.png"))); // NOI18N
        btnChiTiet.setText("   Chi Tiết");
        btnChiTiet.setOpaque(true);
        btnChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChiTietMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
public Integer idSanPham;

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idsanpham) {
        this.idSanPham = idsanpham;

        ChiTietSanPhamController chiTietSanPhamController = new ChiTietSanPhamController(this);

    }
    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        sanPhamDal.addBT.setVisible(true);
        sanPhamDal.editBT.setVisible(false);
        sanPhamDal.errorLB.setText("");
        sanPhamDal.txtTen.setText("");
        sanPhamDal.txtGiaNhap.setText("");
        sanPhamDal.txtGiaBan.setText("");
        sanPhamDal.txtDVT.setText("");
        sanPhamDal.spnSoLuong.setValue(1);

        String tieuDe = (String) sanPhamController.getViewBag().get("tieu_de");
        sanPhamDal.title.setText("Thêm Sản Phẩm " + tieuDe);
        sanPhamDal.setVisible(true);
    }//GEN-LAST:event_btnThemMouseClicked
    private Integer editId;
    private void btnCapNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhapMouseClicked
        // TODO add your handling code here:
             sanPhamDal.addBT.setVisible(false);
        sanPhamDal.editBT.setVisible(true);
        if (tblSanPham.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn dòng cần sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        editId = (Integer) tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0);

        int dong = tblSanPham.getSelectedRow();
        sanPhamDal.txtTen.setText(tblSanPham.getValueAt(dong, 2).toString());
        sanPhamDal.errorLB.setText("");
        sanPhamDal.txtGiaNhap.setText(tblSanPham.getValueAt(dong, 3).toString());
        sanPhamDal.txtGiaBan.setText(tblSanPham.getValueAt(dong, 4).toString());
        sanPhamDal.spnSoLuong.setValue(Integer.parseInt(tblSanPham.getValueAt(dong, 5).toString()));
        sanPhamDal.txtDVT.setText(tblSanPham.getValueAt(dong, 6).toString());
 
        String tieuDe = (String) sanPhamController.getViewBag().get("tieu_de");
        sanPhamDal.title.setText("Cập nhập Sản Phẩm " + tieuDe);
        sanPhamDal.setVisible(true);
        
    }//GEN-LAST:event_btnCapNhapMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        exportExcel(tblSanPham);
    }//GEN-LAST:event_jLabel1MouseClicked


    private void btnChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChiTietMouseClicked
        // TODO add your handling code here:
        if (tblSanPham.getSelectedRow() == -1) {
            System.out.println("Lỗi chưa chọn dòng");
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng chọn phiếu cần xem ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("click");

        
        //        chiTietSanPhamDialog.errorLB.setText("");
        chiTietSanPhamDialog.errorLB.setText("");
        chiTietSanPhamDialog.lbStatus.setText("");
        id = tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString();
        System.out.println(id);
        
        chiTietSanPhamDialog.setIdSanPham((Integer.parseInt(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString())));

        chiTietSanPhamDialog.setVisible(true);

    }//GEN-LAST:event_btnChiTietMouseClicked

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:

        String ten = "%" + searchText1.getText() + "%";
        System.out.println(ten);
        sanPhamController.SearchTen(ten);

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
    private javax.swing.JLabel btnChiTiet;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.TableColumn tblSanPham;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, tblSanPham);
        if (sanPhamDal != null) {
            sanPhamDal.setVisible(false);
            
        }
    }

    @Override
    public void setColumnNames(String[] columnNames) {
        ViewImp.setColumnNames(columnNames, tblSanPham);
    }
    private SanPhamController sanPhamController;

    @Override
    public void setController(AbsController controller) {
        sanPhamController = (SanPhamController) controller;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
