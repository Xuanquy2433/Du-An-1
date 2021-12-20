package com.raven.main;

import MODEL.NhanVien;
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.form.KhuyenMaiPnl;
import com.raven.form.BanHangPanel;
import com.raven.form.DangNhapPnl;
import com.raven.form.HoaDonPnl;
import com.raven.form.KhachHangPanel;
import com.raven.form.LoaiSanPhamPnl;
import com.raven.form.NhaCungCapPnl;
import com.raven.form.NhanVienPnl;
import com.raven.form.PhieuBaoHanhPnl;
import com.raven.form.PhieuNhapPnl;
import com.raven.form.SanPhamPanel;
import com.raven.form.ThongKe;
import com.raven.model.ModelMenu;
import com.raven.swing.MImage;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;

    public Main() throws ParseException {
        initComponents();
//        if (Main.this.getExtendedState() == MAXIMIZED_BOTH) {
//            Main.this.setExtendedState(JFrame.NORMAL);
//        } else {
//            Main.this.setExtendedState(MAXIMIZED_BOTH);
//        }
        init();
        this.setIconImage(MImage.getAppIcon());
    }
    int xx, xy;

    private void init() throws ParseException {
        layout = new MigLayout("fill", "0[]10[]5", "0[fill]0");
        body.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu.addEventLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Logout");
                DangNhapPnl dangNhapPnl = new DangNhapPnl();

                int result = JOptionPane.showConfirmDialog(new Frame(), "Bạn có muốn đăng xuất ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    dangNhapPnl.setVisible(true);
                    dispose();
                }

            }
        });
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        if (DangNhapPnl.level == 1) {
            menu.setEvent(new EventMenuSelected() {
                @Override
                public void selected(int index) {
                    if (index == 0) {
                        showForm(new ThongKe());
                    } else if (index == 1) {
                        showForm(new BanHangPanel());
                    } else if (index == 2) {
                        showForm(new LoaiSanPhamPnl());
                    } else if (index == 3) {
                        showForm(new SanPhamPanel());
                    } else if (index == 4) {
                        showForm(new KhuyenMaiPnl());
                    } else if (index == 5) {
                        showForm(new KhachHangPanel());
                    } else if (index == 6) {
                        showForm(new NhanVienPnl());
                    } else if (index == 7) {
                        showForm(new HoaDonPnl());
                    } else if (index == 8) {
                        showForm(new PhieuBaoHanhPnl());
                    } else if (index == 9) {
                        showForm(new NhaCungCapPnl());
                    } else if (index == 10) {
                        showForm(new PhieuNhapPnl());
                    }
                }
            });
            menu.addMenu(new ModelMenu("Trang Chủ", new ImageIcon(getClass().getResource("/com/raven/icon/homePagee.png"))));
            menu.addMenu(new ModelMenu("Bán Hàng", new ImageIcon(getClass().getResource("/com/raven/icon/sell.png"))));
            menu.addMenu(new ModelMenu("Loại Sản Phẩm", new ImageIcon(getClass().getResource("/com/raven/icon/category.png"))));
            menu.addMenu(new ModelMenu("Sản Phẩm", new ImageIcon(getClass().getResource("/com/raven/icon/report.png"))));
            menu.addMenu(new ModelMenu("Khuyến mãi", new ImageIcon(getClass().getResource("/com/raven/icon/KhuyenMai.png"))));
            menu.addMenu(new ModelMenu("Khách hàng", new ImageIcon(getClass().getResource("/com/raven/icon/Custom.png"))));
            menu.addMenu(new ModelMenu("Nhân Viên", new ImageIcon(getClass().getResource("/com/raven/icon/Staff.png"))));
            menu.addMenu(new ModelMenu("Hóa Đơn", new ImageIcon(getClass().getResource("/com/raven/icon/hoaDon.png"))));
            menu.addMenu(new ModelMenu("Phiếu Bảo Hành", new ImageIcon(getClass().getResource("/com/raven/icon/phieuBaoHanh.png"))));
            menu.addMenu(new ModelMenu("Nhà Cung Cấp", new ImageIcon(getClass().getResource("/com/raven/icon/nhaCungCapp.png"))));
            menu.addMenu(new ModelMenu("Phiếu Nhập", new ImageIcon(getClass().getResource("/com/raven/icon/phieuNhap.png"))));
        } else if(DangNhapPnl.level == 2){
            menu.setEvent(new EventMenuSelected() {
                @Override
                public void selected(int index) {
                    if (index == 0) {
                        showForm(new BanHangPanel());
                    } else if (index == 1) {
                        showForm(new LoaiSanPhamPnl());
                    } else if (index == 2) {
                        showForm(new SanPhamPanel());
                    } else if (index == 3) {
                        showForm(new KhuyenMaiPnl());
                    } else if (index == 4) {
                        showForm(new HoaDonPnl());
                    } else if (index == 5) {
                        showForm(new PhieuBaoHanhPnl());
                    }

                }
            });

            menu.addMenu(new ModelMenu("Bán Hàng", new ImageIcon(getClass().getResource("/com/raven/icon/sell.png"))));
            menu.addMenu(new ModelMenu("Loại Sản Phẩm", new ImageIcon(getClass().getResource("/com/raven/icon/category.png"))));
            menu.addMenu(new ModelMenu("Sản Phẩm", new ImageIcon(getClass().getResource("/com/raven/icon/report.png"))));
            menu.addMenu(new ModelMenu("Khuyến mãi", new ImageIcon(getClass().getResource("/com/raven/icon/KhuyenMai.png"))));
            menu.addMenu(new ModelMenu("Hóa Đơn", new ImageIcon(getClass().getResource("/com/raven/icon/hoaDon.png"))));
            menu.addMenu(new ModelMenu("Phiếu Bảo Hành", new ImageIcon(getClass().getResource("/com/raven/icon/phieuBaoHanh.png"))));

        } else {
        menu.setEvent(new EventMenuSelected() {
                @Override
                public void selected(int index) {                  

                }
            });

           

        }
       
//        menu.addMenu(new ModelMenu("Trang Chủ", new ImageIcon(getClass().getResource("/com/raven/icon/homePagee.png"))));
//        menu.addMenu(new ModelMenu("Bán Bàng", new ImageIcon(getClass().getResource("/com/raven/icon/sell.png"))));
//        menu.addMenu(new ModelMenu("Loại Sản Phẩm", new ImageIcon(getClass().getResource("/com/raven/icon/category.png"))));
//        menu.addMenu(new ModelMenu("Sản Phẩm", new ImageIcon(getClass().getResource("/com/raven/icon/report.png"))));
//        menu.addMenu(new ModelMenu("Khuyến mãi", new ImageIcon(getClass().getResource("/com/raven/icon/KhuyenMai.png"))));
//        menu.addMenu(new ModelMenu("Khách hàng", new ImageIcon(getClass().getResource("/com/raven/icon/Custom.png"))));
//        menu.addMenu(new ModelMenu("Nhân Viên", new ImageIcon(getClass().getResource("/com/raven/icon/Staff.png"))));
//        menu.addMenu(new ModelMenu("Hóa Đơn", new ImageIcon(getClass().getResource("/com/raven/icon/hoaDon.png"))));
//        menu.addMenu(new ModelMenu("Phiếu Bảo Hành", new ImageIcon(getClass().getResource("/com/raven/icon/phieuBaoHanh.png"))));
//        menu.addMenu(new ModelMenu("Nhà Cung Cấp", new ImageIcon(getClass().getResource("/com/raven/icon/nhaCungCapp.png"))));
//        menu.addMenu(new ModelMenu("Phiếu Nhập", new ImageIcon(getClass().getResource("/com/raven/icon/phieuNhap.png"))));

        body.add(menu, "w 50!");
        body.add(main, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 50 + (150 * (1f - fraction));
                    menu.setAlpha(1f - fraction);
                } else {
                    width = 50 + (150 * fraction);
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                body.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        if (DangNhapPnl.level==1){
        showForm(new ThongKe());
    } else  if (DangNhapPnl.level==2) {
         showForm(new BanHangPanel());   
            
        } else {}}

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        pnlActions = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1225, 750));

        body.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1151, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pnlTop.setBackground(new java.awt.Color(51, 153, 255));
        pnlTop.setDoubleBuffered(false);
        pnlTop.setPreferredSize(new java.awt.Dimension(1024, 30));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTopMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlActions.setBackground(new java.awt.Color(51, 153, 255));
        pnlActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_minus_18px_1.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMinimize);

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_multiply_18px_1.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        pnlActions.add(lblClose);

        pnlTop.add(pnlActions, java.awt.BorderLayout.LINE_END);

        pnlTitle.setBackground(new java.awt.Color(51, 153, 255));
        pnlTitle.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlTitle.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));

        lblTitle.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/no-connection-16.png"))); // NOI18N
        lblTitle.setText("Cửa hàng điện thoại Dũng phát");
        pnlTitle.add(lblTitle);

        pnlTop.add(pnlTitle, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void pnlTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseClicked
        //        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        //            if (Home20.this.getExtendedState() == MAXIMIZED_BOTH) {
        //                Home20.this.setExtendedState(JFrame.NORMAL);
        //            } else {
        //                Home20.this.setExtendedState(MAXIMIZED_BOTH);
        //            }
        //        }
    }//GEN-LAST:event_pnlTopMouseClicked

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        Main.this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
