package com.raven.form;

import Controller.AbsController;
import Controller.BanHangChiTietHoaDonController;
import Controller.BanHangController;
import Controller.ChiTietHoaDonController;
import Controller.ChuyenDoi;
import Controller.HoaDonBanHangController;
import Controller.HoaDonController;
import DAO.DBConnection;
import MODEL.ChiTietSanPham;
import MODEL.KhachHang;
import MODEL.KhuyenMai;
import MODEL.SanPham;
import VIEW.ViewImp;
import VIEW.ViewInterface;
import com.sun.jdi.connect.spi.Connection;
import dao.DBConnection2;
import duan.dialog.HandleKhachHangDal;
import duan.dialog.HandleTangSoLuongDal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.oval.ConstraintViolation;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class BanHangPanel extends javax.swing.JPanel implements ViewInterface {

    private HandleKhachHangDal khachHangDialog = null;
    private int tongSoLuong = 0;
    private HandleTangSoLuongDal tangSoLuongDal = null;
    private ChiTietHoaDonController chiTietHoaDonController;
    private HoaDonController hoaDonController;

    public BanHangPanel() {

        initComponents();
        setOpaque(false);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setWrapStyleWord(true);
        BanHangController banHangController = new BanHangController(this);
        if (khachHangDialog == null) {
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

                    String gioiTinh;
//                    Object[] values = new Object[8];
//                    values[0] = 0;
//                    values[1] = khachHangDialog.txtTen.getText();
//                    values[2] = khachHangDialog.txtSdt.getText();
//                    values[3] = khachHangDialog.txtDiaChi.getText();
//                    values[4] = khachHangDialog.txtCMND.getText();
//                    values[5] = khachHangDialog.txtGhiChu.getText();
                    if (khachHangDialog.cbNam.isSelected()) {
                        gioiTinh = "Nam";
                    } else if (!khachHangDialog.cbNu.isSelected() && !khachHangDialog.cbNam.isSelected()) {
                        khachHangDialog.errorlb.setText("Vui lòng chọn giới tính ! ");
                        return;
                    } else {
                        gioiTinh = "Nữ";
                    }
//                    values[7] = khachHangDialog.txtEmail.getText();
//                    banHangController.insert(values);

                    banHangController.themKH(khachHangDialog.txtTen.getText(), khachHangDialog.txtSdt.getText(), khachHangDialog.txtDiaChi.getText(),
                            khachHangDialog.txtCMND.getText(), khachHangDialog.txtGhiChu.getText(), "nam", khachHangDialog.txtEmail.getText());
                    DefaultComboBoxModel<KhachHang> modle2 = (DefaultComboBoxModel<KhachHang>) cbbKhachHang.getModel();
                    modle2.removeAllElements();
                    List<KhachHang> khachHangs = banHangController.layCbbKhachHang();
                    modle2.addAll(khachHangs);
                    modle2.setSelectedItem(khachHangs.get(0));
                    System.out.println(cbbKhachHang.getItemCount());
                    cbbKhachHang.setSelectedIndex(cbbKhachHang.getItemCount() - 1);
                    AutoCompleteDecorator.decorate(cbbKhachHang);
                    khachHangDialog.setVisible(false);
                }
            });
        }
        init();
        dataTable2.removeColumn(dataTable2.getColumnModel().getColumn(0));
        dataTable1.removeColumn(dataTable1.getColumnModel().getColumn(0));
        
         
        
        DefaultComboBoxModel<KhuyenMai> modle = (DefaultComboBoxModel<KhuyenMai>) cbbKhuyenMai.getModel();
        modle.removeAllElements();
        List<KhuyenMai> khuyenMais = banHangController.layCbbKhuyenMai();
        modle.addAll(khuyenMais);
        modle.setSelectedItem(khuyenMais.get(0));

        DefaultComboBoxModel<KhachHang> modle2 = (DefaultComboBoxModel<KhachHang>) cbbKhachHang.getModel();
        modle2.removeAllElements();
        List<KhachHang> khachHangs = banHangController.layCbbKhachHang();
        modle2.addAll(khachHangs);
        modle2.setSelectedItem(khachHangs.get(0));
        AutoCompleteDecorator.decorate(cbbKhachHang);
        DecimalFormat df = new DecimalFormat("###.#");
//        dataTable2.getColumn("button").setCellRenderer(new ButtonRenderer());
//        dataTable2.getColumn("button").setCellEditor(
//            new ButtonEditor(new JCheckBox()));
        tangSoLuongDal = new HandleTangSoLuongDal(null, true);
        dataTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                //set dialog visible
                if (me.getClickCount() == 2) {
                    tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(0));
                    tangSoLuongDal.errorlb2.setText("");
                    tangSoLuongDal.setVisible(true);
                    if (tangSoLuongDal == null) {

                        tangSoLuongDal = new HandleTangSoLuongDal(null, true);

                    }
                };
            }
        });
        dataTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                //set dialog visible

                if (me.getClickCount() == 2) {
                    DefaultTableModel model = (DefaultTableModel) dataTable1.getModel();
                    int getSelectedRowForDeletion = dataTable1.getSelectedRow();
                    //Check if their is a row selected
                    if (getSelectedRowForDeletion >= 0) {
                        model.removeRow(getSelectedRowForDeletion);

                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể Delete");
                    }

                }
            }
        ;
        }
        );
        //double click event
        tangSoLuongDal.btnOk.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //if table 1 is null, add new row
                if (ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText()) == 0) {
                    tangSoLuongDal.errorlb2.setText("Số lượng cần lớn hơn 0");
                    return;
                }
                if (dataTable1.getRowCount() == 0) {
                    TableModel model2 = dataTable2.getModel();
                    int[] indexs = dataTable2.getSelectedRows();
                    Object[] rows = new Object[6];
                    DefaultTableModel model1 = (DefaultTableModel) dataTable1.getModel();
                    for (int i = 0; i < indexs.length; i++) {
                        rows[0] = model2.getValueAt(indexs[i], 0);
                        rows[1] = model2.getValueAt(indexs[i], 1);
                        rows[2] = model2.getValueAt(indexs[i], 2);
                        rows[3] = model2.getValueAt(indexs[i], 3);
                        rows[4] = df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText()));
                        rows[5] = model2.getValueAt(indexs[i], 5);
//                            ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm","Giá" ,"Số Lương", "Đơn Vị Tính"};
                        model1.addRow(rows);
                        System.out.println("added new row if null, quanity: " + df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText())));
                    }

                } else {
                    double soLuong;
                    double t2RowID = ChuyenDoi.SoDouble(dataTable2.getModel().getValueAt(dataTable2.getSelectedRow(), 1).toString());
                    for (int i = 0; i < dataTable1.getRowCount(); i++) {
                        //else check if the id  exists. true: add quantity   
                        if (t2RowID == Integer.parseInt(dataTable1.getModel().getValueAt(i, 1).toString())) {
                            System.out.println(Integer.parseInt(dataTable2.getModel().getValueAt(i, 1).toString()));
                            soLuong = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString()) + ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText());
                            dataTable1.getModel().setValueAt(df.format(soLuong), i, 4);
                            System.out.println("increased quantity");
                            return;
                            //false: add new row    
                        } else {
                            if (i == dataTable1.getRowCount() - 1) {
                                TableModel model2 = dataTable2.getModel();
                                int[] indexs = dataTable2.getSelectedRows();
                                Object[] rows = new Object[6];
                                DefaultTableModel model1 = (DefaultTableModel) dataTable1.getModel();
                                for (int j = 0; j < indexs.length; j++) {
                                    rows[0] = model2.getValueAt(indexs[j], 0);
                                    rows[1] = model2.getValueAt(indexs[j], 1);
                                    rows[2] = model2.getValueAt(indexs[j], 2);
                                    rows[3] = model2.getValueAt(indexs[j], 3);
                                    rows[4] = df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText()));
                                    System.out.println("added new row if exist, quanlity: " + df.format(ChuyenDoi.SoDouble(tangSoLuongDal.txtSoLuong.getText())));
                                    rows[5] = model2.getValueAt(indexs[j], 5);
//                            ID Sản Phẩm", "ID Chi Tiết", "Tên Sản Phẩm","Giá" ,"Số Lương", "Đơn Vị Tính"};
                                    model1.addRow(rows);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        );

        dataTable1.getModel().addTableModelListener(
                new TableModelListener() {
            public void tableChanged(TableModelEvent evt) {
                System.out.print("aa");
                hoaDonTable();
            }
        });
        AutoCompleteDecorator.decorate(cbbHinhThucThanhToan);
        AutoCompleteDecorator.decorate(cbbKhuyenMai);

        tangSoLuongDal.txtSoLuong.addKeyListener(new KeyListener() {
            /**
             * Handle the key released event from the text field.
             */

            @Override
            public void keyTyped(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                double soLuongMuonThem = ChuyenDoi.SoDouble((tangSoLuongDal.txtSoLuong.getText()));

                int soLuongData = Integer.parseInt(dataTable2.getValueAt(dataTable2.getSelectedRow(), 3).toString());
                if (soLuongMuonThem > soLuongData) {
                    tangSoLuongDal.errorlb2.setText("Số lượng hàng lại là : " + dataTable2.getValueAt(dataTable2.getSelectedRow(), 3).toString());
                    tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(soLuongData));
                }
            }
        });
        tangSoLuongDal.btnTang1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double soLuongMuonThem = ChuyenDoi.SoDouble((tangSoLuongDal.txtSoLuong.getText()));
                tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(soLuongMuonThem));
                int soLuongData = Integer.parseInt(dataTable2.getValueAt(dataTable2.getSelectedRow(), 3).toString());
                if (soLuongMuonThem > soLuongData) {
                    tangSoLuongDal.errorlb2.setText("Số lượng hàng lại là : " + dataTable2.getValueAt(dataTable2.getSelectedRow(), 3).toString());
                    tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(soLuongData));
                }
            }
        });
        tangSoLuongDal.btnGiam.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double soLuongMuonThem = ChuyenDoi.SoDouble((tangSoLuongDal.txtSoLuong.getText()));
                tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(soLuongMuonThem));
                int soLuongData = Integer.parseInt(dataTable2.getValueAt(dataTable2.getSelectedRow(), 3).toString());
                if (soLuongMuonThem > soLuongData) {
                    tangSoLuongDal.errorlb2.setText("Số lượng hàng lại là : " + dataTable2.getValueAt(dataTable2.getSelectedRow(), 3).toString());
                    tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(soLuongData));
                }
                if (soLuongMuonThem < 0) {
                    tangSoLuongDal.txtSoLuong.setText(ChuyenDoi.SoString(0));
                }
            }
        });
    }

    private void init() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchText1 = new com.raven.swing.SearchText();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThemkh = new com.raven.swing.KButton();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        txtTongTien = new javax.swing.JButton();
        btnHienThi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        errorlb2 = new javax.swing.JLabel();
        txtCanTra = new javax.swing.JButton();
        txtKhachDua = new javax.swing.JTextField();
        txtTienThua1 = new javax.swing.JButton();
        txtThanhToan1 = new com.raven.swing.KButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dataTable2 = new com.raven.swing.TableColumn();
        scrollBar2 = new com.raven.swing.ScrollBar();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable1 = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1043, 680));

        searchText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText1ActionPerformed(evt);
            }
        });
        searchText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchText1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel5.setText("Tổng tiền hàng");

        jLabel4.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel4.setText("Giảm giá");

        jLabel6.setFont(new java.awt.Font("UTM Avo", 1, 13)); // NOI18N
        jLabel6.setText("Khách cần trả");

        jLabel3.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel3.setText("Khách thanh toán");

        jLabel1.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel1.setText("Tiền thừa trả khách");

        btnThemkh.setText("+");
        btnThemkh.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        btnThemkh.setkEndColor(new java.awt.Color(0, 153, 153));
        btnThemkh.setkHoverEndColor(new java.awt.Color(0, 102, 102));
        btnThemkh.setkHoverForeGround(new java.awt.Color(153, 153, 153));
        btnThemkh.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        btnThemkh.setkSelectedColor(new java.awt.Color(0, 153, 153));
        btnThemkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemkhActionPerformed(evt);
            }
        });

        cbbKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhuyenMaiItemStateChanged(evt);
            }
        });
        cbbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbKhuyenMaiMouseReleased(evt);
            }
        });

        txtTongTien.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(0, 51, 51));
        txtTongTien.setEnabled(false);
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        btnHienThi.setForeground(new java.awt.Color(0, 51, 51));
        btnHienThi.setText("0%");
        btnHienThi.setEnabled(false);
        btnHienThi.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel2.setText("Hình thức thanh toán");

        cbbHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển khoản" }));
        cbbHinhThucThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbHinhThucThanhToanItemStateChanged(evt);
            }
        });
        cbbHinhThucThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbHinhThucThanhToanMouseReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel7.setText("Khách hàng");

        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });
        cbbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbKhachHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("UTM Avo", 0, 13)); // NOI18N
        jLabel8.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        errorlb2.setFont(new java.awt.Font("UTM Avo", 2, 12)); // NOI18N
        errorlb2.setForeground(new java.awt.Color(255, 0, 0));
        errorlb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtCanTra.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtCanTra.setForeground(new java.awt.Color(0, 51, 51));
        txtCanTra.setEnabled(false);
        txtCanTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCanTraActionPerformed(evt);
            }
        });

        txtKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachDuaActionPerformed(evt);
            }
        });
        txtKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachDuaKeyReleased(evt);
            }
        });

        txtTienThua1.setFont(new java.awt.Font("UTM Avo", 2, 14)); // NOI18N
        txtTienThua1.setForeground(new java.awt.Color(0, 51, 51));
        txtTienThua1.setEnabled(false);
        txtTienThua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThua1ActionPerformed(evt);
            }
        });

        txtThanhToan1.setText("Thanh toán");
        txtThanhToan1.setFont(new java.awt.Font("UTM Avo", 0, 18)); // NOI18N
        txtThanhToan1.setkEndColor(new java.awt.Color(0, 153, 153));
        txtThanhToan1.setkHoverEndColor(new java.awt.Color(0, 102, 102));
        txtThanhToan1.setkHoverForeGround(new java.awt.Color(153, 153, 153));
        txtThanhToan1.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        txtThanhToan1.setkSelectedColor(new java.awt.Color(0, 153, 153));
        txtThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(errorlb2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235)
                        .addComponent(jSeparator1)
                        .addGap(760, 760, 760))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemkh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienThua1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKhachDua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCanTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(txtThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(769, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTienThua1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemkh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorlb2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(520, Short.MAX_VALUE)
                    .addComponent(txtThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46)))
        );

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane4.setBorder(null);
        jScrollPane4.setVerticalScrollBar(scrollBar2);

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sản Phẩm", "Id Chi Tiết", "Tên Sản Phẩm", "Giá", "Số Lượng", "ĐVT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable2.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 250));
        jScrollPane4.setViewportView(dataTable2);

        jPanel6.add(jScrollPane4);
        jPanel6.add(scrollBar2);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setBorder(null);
        jScrollPane3.setVerticalScrollBar(scrollBar1);

        dataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sản Phẩm", "Id Chi Tiết", "Tên Sản Phẩm", "Giá", "Số Lượng", "ĐVT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable1.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 250));
        jScrollPane3.setViewportView(dataTable1);

        jPanel7.add(jScrollPane3);
        jPanel7.add(scrollBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemkhActionPerformed
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
        khachHangDialog.title.setText("Thêm Khách Hàng ");
        khachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnThemkhActionPerformed
    public void XuatHoaDon(int idhd,double tienKhachDua, double tienThua) {
        try {

            Hashtable<String, Object> map = new Hashtable<String, Object>();
            JasperReport report = JasperCompileManager.compileReport("src/reports/newReport2.jrxml");

            map.put("IDHD", idhd);
            map.put("tienThua", tienThua);
            map.put("tienKhachDua", tienKhachDua);
            
            //DBConnection2.conn cái này của em ko khởi tạo nó băng null nên ko lấy đc 

            DBConnection2 a = new DBConnection2(); //Khởi tạo nè
            JasperPrint p = JasperFillManager.fillReport(report, map, DBConnection2.conn);
            JasperViewer.viewReport(p, false);
            JasperExportManager.exportReportToPdfFile(p, "d:/test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void cbbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cbbKhuyenMaiMouseClicked

    private void cbbKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbKhuyenMaiMousePressed

    private void cbbKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhuyenMaiMouseExited

    private void cbbKhuyenMaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiMouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_cbbKhuyenMaiMouseReleased

    private void cbbKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiItemStateChanged
        // TODO add your handling code here:

        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();
        btnHienThi.setText(String.valueOf(khuyenMai.getPhanTramKhuyenMai() + " %"));
        hoaDonTable();


    }//GEN-LAST:event_cbbKhuyenMaiItemStateChanged

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void searchText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText1ActionPerformed

    private void cbbHinhThucThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanItemStateChanged

    }//GEN-LAST:event_cbbHinhThucThanhToanItemStateChanged

    private void cbbHinhThucThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMouseClicked

    private void cbbHinhThucThanhToanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMouseExited

    private void cbbHinhThucThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMousePressed

    private void cbbHinhThucThanhToanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHinhThucThanhToanMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucThanhToanMouseReleased

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangItemStateChanged

    private void cbbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMouseClicked

    private void cbbKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMouseExited

    private void cbbKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMousePressed

    private void cbbKhachHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangMouseReleased

    private void searchText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchText1KeyReleased
        // TODO add your handling code here:

        BanHangController banHangController = new BanHangController(this);

        String ten = "%" + searchText1.getText() + "%";
        System.out.println(ten);
        banHangController.search(ten);
        

    }//GEN-LAST:event_searchText1KeyReleased

    private void txtCanTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCanTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCanTraActionPerformed

    private void txtTienThua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThua1ActionPerformed

    private void txtKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachDuaActionPerformed

    private void txtKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachDuaKeyReleased

        String dau = txtKhachDua.getText();
        double chuyen = ChuyenDoi.SoDouble(dau);
        txtKhachDua.setText(ChuyenDoi.SoString(chuyen));

        double tienKhachDua, tienCanTra, tienThua;
        tienCanTra = ChuyenDoi.SoDouble(txtCanTra.getText());
        tienKhachDua = ChuyenDoi.SoDouble(txtKhachDua.getText());
        tienThua = tienKhachDua - tienCanTra;
        txtTienThua1.setText(ChuyenDoi.SoString(tienThua));
        errorlb2.setText("");
        if (dataTable1.getRowCount() == 0) {
            errorlb2.setText("Giỏ hàng trống");
            txtKhachDua.setText(ChuyenDoi.SoString(0));
            txtTienThua1.setText(ChuyenDoi.SoString(0));
            return;
        }

    }//GEN-LAST:event_txtKhachDuaKeyReleased

    private void txtThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToan1ActionPerformed
       
        
        if (dataTable1.getRowCount() == 0) {
            errorlb2.setText("Giỏ hàng trống");
            return;
        }

        if (txtKhachDua.getText().trim().equals("")) {
            errorlb2.setText("Khách hàng chưa thanh toán");
            return;
        }

        if (ChuyenDoi.SoDouble(txtKhachDua.getText()) < ChuyenDoi.SoDouble(txtCanTra.getText())) {
            errorlb2.setText("Số tiền khách đưa phải lớn hơn tiền hàng");
            return;
        }
        
         final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        int dialogResult = JOptionPane.showConfirmDialog(dialog,
                "Bạn có muốn lập hóa đơn không?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (dialogResult == JOptionPane.YES_OPTION) {
            
        
        BanHangController banHangController = new BanHangController(this);
        HoaDonBanHangController hoaDonBanHangController = new HoaDonBanHangController(this);
        BanHangChiTietHoaDonController banHangChiTietHoaDonController = new BanHangChiTietHoaDonController(this);
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        for (int i = 0; i < dataTable1.getRowCount(); i++) {
            tongSoLuong = tongSoLuong + Integer.parseInt(dataTable1.getValueAt(i, 3).toString());
        }
        Integer idKM = khuyenMai.getId();
        System.out.println(idKM);
        Integer idNV = DangNhapPnl.ID;
        java.sql.Timestamp now = new Timestamp((new java.util.Date()).getTime());
        double tongTien = ChuyenDoi.SoDouble(txtCanTra.getText());
        KhachHang khachHang = (KhachHang) cbbKhachHang.getSelectedItem();
        Integer idKH = khachHang.getId();
        hoaDonBanHangController.ThemHD(idKH, idNV, idKM, tongSoLuong, tongTien, now, cbbHinhThucThanhToan.getSelectedItem().toString(), txtGhiChu.getText());
        hoaDonBanHangController.loadList();

        System.out.println(banHangController.idHoaDon());
        int row = dataTable2.getModel().getRowCount();
        int column = dataTable2.getModel().getColumnCount();
        System.out.println(row);
        System.out.println(column);

        int idSanPham = 0, SoLuong = 0, idHoaDon;
        String tenSanPham = "";
        double Gia = 0;
        for (int i = 0; i < dataTable1.getRowCount(); i++) {
            idHoaDon = banHangController.idHoaDon();
            idSanPham = Integer.valueOf(dataTable1.getModel().getValueAt(i, 0).toString());
            int idCTSP = Integer.valueOf(dataTable1.getModel().getValueAt(i, 1).toString());

            tenSanPham = dataTable1.getValueAt(i, 1).toString();
            Gia = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 2).toString());
            SoLuong = Integer.valueOf(dataTable1.getValueAt(i, 3).toString());

//idSanPham, idHoaDon, TenSanPham, SoLuong, Gia, TongTien
            double TongTien = ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 2).toString()) * ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString());
            System.out.println("cthd");
            System.out.println(idSanPham);
            System.out.println(idHoaDon);
            System.out.println(tenSanPham);
            System.out.println(SoLuong);
            System.out.println(Gia);
            System.out.println(tongTien);
            DecimalFormat df = new DecimalFormat("###.#");
            Object[] data = new Object[7];
            data[0] = 0;
            data[1] = idSanPham;
            data[2] = idCTSP;
            System.out.println(idCTSP + "ctsp");
            data[3] = idHoaDon;
            data[4] = SoLuong;
            data[5] = Gia;
            data[6] = tongTien;

            banHangChiTietHoaDonController.insertNoLoadList(data);

        }
        //update soLuong data for SanPham 

        ArrayList<SanPham> list = banHangChiTietHoaDonController.DSSanPham();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < dataTable1.getRowCount(); j++) {
                int idSP = Integer.valueOf(dataTable1.getModel().getValueAt(j, 0).toString());
                if (list.get(i).getId() == idSP) {
                    int SoLuongSPDaMua = 0;
                    SoLuongSPDaMua = SoLuongSPDaMua + Integer.parseInt(dataTable1.getValueAt(j, 3).toString());
                    int soLuongConLai = list.get(i).getSoLuong() - SoLuongSPDaMua;
                    System.out.println(soLuongConLai);
                    banHangChiTietHoaDonController.editSoLuongSanPham(soLuongConLai, idSP);
                }
            }
        }

        ArrayList<ChiTietSanPham> listCTSP = banHangChiTietHoaDonController.DSCTSP();
        for (int i = 0; i < listCTSP.size(); i++) {
            for (int j = 0; j < dataTable1.getRowCount(); j++) {
                int idCTSP = Integer.valueOf(dataTable1.getModel().getValueAt(j, 1).toString());
                if (listCTSP.get(i).getId() == idCTSP) {
                    int SoLuongCTSPDaMua = 0;
                    SoLuongCTSPDaMua = SoLuongCTSPDaMua + Integer.parseInt(dataTable1.getValueAt(j, 3).toString());
                    int soLuongConLai = listCTSP.get(i).getSoLuong() - SoLuongCTSPDaMua;
                    System.out.println(soLuongConLai);
                    banHangChiTietHoaDonController.editSoLuongChiTiet(soLuongConLai, idCTSP);
                }
            }
        }
        double tienThua = ChuyenDoi.SoDouble(txtTienThua1.getText());
        double tienKhachDua = ChuyenDoi.SoDouble(txtKhachDua.getText());
        idHoaDon = banHangController.idHoaDon();
        XuatHoaDon(idHoaDon,tienKhachDua,tienThua); //Mở database thầy xem
        hoaDonBanHangController.loadList();
        DefaultTableModel dm = (DefaultTableModel) dataTable1.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        txtTongTien.setText("");
        txtTienThua1.setText("");
        txtKhachDua.setText("");
        } else {
        return;
        }    
    }//GEN-LAST:event_txtThanhToan1ActionPerformed

    public static String id;

    public void hoaDonTable() {
        double giamGia, khachCanTra, tienKhachDua, tienThua;

        double total = 0;
        double tienTungMon = 0;
        for (int i = 0; i < dataTable1.getRowCount(); i++) {
            total = total + (ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 2).toString()) * ChuyenDoi.SoDouble(dataTable1.getValueAt(i, 3).toString()));
            txtTongTien.setText(ChuyenDoi.SoString(total));

        }
        // lấy phần trăm khuyến mãi theo đúng tên khuyến mãi
        KhuyenMai khuyenMai = (KhuyenMai) cbbKhuyenMai.getSelectedItem();
        Integer phanTramKM = khuyenMai.getPhanTramKhuyenMai();

        giamGia = ChuyenDoi.SoDouble(phanTramKM.toString());
        khachCanTra = total - total * giamGia / 100;

        txtCanTra.setText(ChuyenDoi.SoString(khachCanTra));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThi;
    private com.raven.swing.KButton btnThemkh;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<KhachHang> cbbKhachHang;
    private javax.swing.JComboBox<KhuyenMai> cbbKhuyenMai;
    private com.raven.swing.TableColumn dataTable1;
    private com.raven.swing.TableColumn dataTable2;
    public javax.swing.JLabel errorlb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.ScrollBar scrollBar2;
    private com.raven.swing.SearchText searchText1;
    private javax.swing.JButton txtCanTra;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtKhachDua;
    private com.raven.swing.KButton txtThanhToan1;
    private javax.swing.JButton txtTienThua1;
    private javax.swing.JButton txtTongTien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void viewList(List<Object[]> rows) {
        ViewImp.viewList(rows, dataTable2);
        if (khachHangDialog != null) {
            khachHangDialog.setVisible(false);
        }
    }

    @Override
    public void setColumnNames(String[] columnNames) {

    }

    private BanHangController banHangController;

    @Override
    public void setController(AbsController controller) {
        banHangController = (BanHangController) banHangController;
    }

    @Override
    public void showErrors(List<ConstraintViolation> errorList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
