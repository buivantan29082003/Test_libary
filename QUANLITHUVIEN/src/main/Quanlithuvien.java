package main;

import Dao.SachDao;
import Entity.NXB;
import Entity.NhanVien;
import Entity.Sach;
import chart.Chart;
import chart.ModelChart;
import form.DoiMatKhau;
import form.Login;
import form.NhaXuatBan;

import form.Phieumuon1;
import form.QLSinhVien1;
import form.QLNhanVien1;
import form.QLSach;
import form.TacGia;
import form.ThongKe;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.chart.ModelPieChart;
import javaswingdev.chart.PieChart;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import menu.EventMenu;
import net.miginfocom.swing.MigLayout;
import slideshow.nhanvien;
import slideshow.phieumuon;
import slideshow.sach;
import slideshow.sinhvien;
import slideshow.thongke;
import utils.Auth;
import utils.Auth_Sach;
import utils.MsgBox;

public class Quanlithuvien extends javax.swing.JFrame {

    SachDao sdao = new SachDao();

    public Quanlithuvien() throws SQLException {

        initComponents();
        init();

        layer.setLayout(new MigLayout("fill, inset 0", "[fill]", "[fill]"));
        layer.setLayer(menu, JLayeredPane.POPUP_LAYER);
        layer.add(menu, "pos 0 0.5al 60 n", 0);
        menu.addEvent(new EventMenu() {
            @Override
            public void menuSelected(int index) {
                if (index == 0) {
                    Quanlithuvien s = null;
                    try {
                        s = new Quanlithuvien();
                    } catch (SQLException ex) {
                        Logger.getLogger(Quanlithuvien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    s.setVisible(true);
                } else if (index == 1) {
                    if (!Auth.isManager()) {
                        JOptionPane.showMessageDialog(main, "Bạn không đủ quyền để xem nhân viên");
                        return;
                    }
                    showForm(new QLNhanVien1());

                } else if (index == 2) {
                    showForm(new QLSach());

                } else if (index == 3) {
                    showForm(new QLSinhVien1());

                } else if (index == 4) {
                    showForm(new Phieumuon1());

                } else if (index == 5) {
                    if (!Auth.isManager()) {
                        JOptionPane.showMessageDialog(main, "Bạn không đủ quyền để xem thống kê");
                        return;
                    }
                    showForm(new ThongKe());

                } else if (index == 6) {
                    TacGia tg = new TacGia();
                    tg.setVisible(true);
                } else if (index == 7) {
                    NhaXuatBan nxb = new NhaXuatBan();
                    nxb.setVisible(true);

                } else if (index == 8) {
                    if (MsgBox.confirm(main, "Bạn có muốn thoát không ?")) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new menu.Menu();
        layer = new javax.swing.JLayeredPane();
        main = new javax.swing.JPanel();
        main1 = new javax.swing.JPanel();
        header = new component.menu_1();
        QLNhanVIen = new javax.swing.JLabel();
        lblquenMK2 = new javax.swing.JLabel();
        lbldangnhap = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vaitro = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        loginName = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        slideshow1 = new slideshow.Slideshow();
        myButton8 = new button.MyButton();
        myButton5 = new button.MyButton();
        jTextField2 = new javax.swing.JTextField();
        lblabc = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panelShadow5 = new swing.PanelShadow();
        lblHoiChungE = new javax.swing.JLabel();
        pictureBox6 = new swing.PictureBox();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        panelShadow4 = new swing.PanelShadow();
        jLabel8 = new javax.swing.JLabel();
        pictureBox5 = new swing.PictureBox();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        panelShadow7 = new swing.PanelShadow();
        jLabel14 = new javax.swing.JLabel();
        pictureBox8 = new swing.PictureBox();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelShadow6 = new swing.PanelShadow();
        lblMaQuy = new javax.swing.JLabel();
        pictureBox7 = new swing.PictureBox();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        lblNhanGianKi = new javax.swing.JLabel();
        panelShadow8 = new swing.PanelShadow();
        seneca = new javax.swing.JLabel();
        pictureBox9 = new swing.PictureBox();
        jTextArea8 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        nhungbuc = new javax.swing.JLabel();
        thudaoduc = new javax.swing.JLabel();
        panelShadow11 = new swing.PanelShadow();
        lblmuonkiep = new javax.swing.JLabel();
        pictureBox12 = new swing.PictureBox();
        jTextArea12 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        lblnhansinh = new javax.swing.JLabel();
        panelShadow10 = new swing.PanelShadow();
        caycamngot = new javax.swing.JLabel();
        pictureBox11 = new swing.PictureBox();
        jTextArea10 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cuatoi = new javax.swing.JLabel();
        panelShadow9 = new swing.PanelShadow();
        lblkhoidau = new javax.swing.JLabel();
        pictureBox10 = new swing.PictureBox();
        jTextArea9 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        lblcaichet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        main.setBackground(new java.awt.Color(30, 30, 30));
        main.setPreferredSize(new java.awt.Dimension(1463, 690));
        main.setLayout(new java.awt.BorderLayout());

        main1.setBackground(new java.awt.Color(255, 204, 204));
        main1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        QLNhanVIen.setBackground(new java.awt.Color(102, 102, 102));
        QLNhanVIen.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        QLNhanVIen.setForeground(new java.awt.Color(255, 255, 255));
        QLNhanVIen.setText("Trang chính");
        QLNhanVIen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QLNhanVIenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                QLNhanVIenMouseExited(evt);
            }
        });

        lblquenMK2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblquenMK2.setForeground(new java.awt.Color(255, 255, 255));
        lblquenMK2.setText("Đổi Mật Khẩu ");
        lblquenMK2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblquenMK2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblquenMK2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblquenMK2MouseExited(evt);
            }
        });

        lbldangnhap.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbldangnhap.setForeground(new java.awt.Color(255, 255, 255));
        lbldangnhap.setText("Đăng xuất");
        lbldangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldangnhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbldangnhapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbldangnhapMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setText("|");

        vaitro.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        vaitro.setForeground(new java.awt.Color(255, 255, 255));

        role.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        role.setText("Role :");

        lb.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lb.setText("User :");

        loginName.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        loginName.setForeground(new java.awt.Color(255, 255, 255));
        loginName.setPreferredSize(new java.awt.Dimension(30, 14));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginName, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(QLNhanVIen)
                .addGap(189, 189, 189)
                .addComponent(lblquenMK2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldangnhap)
                .addGap(16, 16, 16))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbldangnhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblquenMK2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(QLNhanVIen)))
                .addContainerGap())
        );

        main1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 10, -1, -1));

        lblDongHo.setText("Đồng hồ");
        main1.add(lblDongHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 70, -1));
        main1.add(slideshow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 73, 812, 172));

        myButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-chevron-left.png"))); // NOI18N
        myButton8.setRadius(10);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });
        main1.add(myButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        myButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-chevron-right.png"))); // NOI18N
        myButton5.setRadius(10);
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });
        main1.add(myButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, -1, -1));

        jTextField2.setBackground(new java.awt.Color(255, 204, 204));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Sách được yêu thích");
        jTextField2.setBorder(null);
        main1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 263, -1));

        lblabc.setText("Hoa");
        lblabc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblabcMouseClicked(evt);
            }
        });
        main1.add(lblabc, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 143, -1, -1));

        jTextField1.setBackground(new java.awt.Color(255, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("_____________________________________________");
        jTextField1.setBorder(null);
        main1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 263, 20));

        panelShadow5.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow5.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow5.setShadowOpacity(0.3F);

        lblHoiChungE.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblHoiChungE.setText("Hội chứng E");
        lblHoiChungE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoiChungEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHoiChungEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHoiChungEMouseExited(evt);
            }
        });

        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/Hoi_chung_E.png"))); // NOI18N
        pictureBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox6MouseClicked(evt);
            }
        });

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea5.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea5.setRows(5);
        jTextArea5.setText("Một bộ phim ngắn\nbí ẩn và độc hại\nkhiến người xem \nđột ngột bị mù... ");
        jTextArea5.setBorder(null);
        jTextArea5.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Franck Thiliez");

        javax.swing.GroupLayout panelShadow5Layout = new javax.swing.GroupLayout(panelShadow5);
        panelShadow5.setLayout(panelShadow5Layout);
        panelShadow5Layout.setHorizontalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHoiChungE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextArea5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow5Layout.setVerticalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow5Layout.createSequentialGroup()
                        .addComponent(lblHoiChungE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea5))
                    .addGroup(panelShadow5Layout.createSequentialGroup()
                        .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        main1.add(panelShadow5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 240, 170));

        panelShadow4.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow4.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow4.setShadowOpacity(0.3F);

        jLabel8.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        jLabel8.setText("Trà hoa nữ");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/tra_hoa_nu.png"))); // NOI18N
        pictureBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox5MouseClicked(evt);
            }
        });

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea4.setRows(5);
        jTextArea4.setText("Là một câu chuyện\nđau thương về cuộc\nđời nàng kỹ nữ yêu \nhoa trà có tên là \nMarguerite Gautier.");
        jTextArea4.setBorder(null);
        jTextArea4.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Alexandre Dumas");

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea4))
                    .addGroup(panelShadow4Layout.createSequentialGroup()
                        .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        main1.add(panelShadow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 240, 170));

        panelShadow7.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow7.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow7.setShadowOpacity(0.3F);

        jLabel14.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        jLabel14.setText("Đẹp và buồn");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        pictureBox8.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/dep_va_buon.jpg"))); // NOI18N
        pictureBox8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox8MouseClicked(evt);
            }
        });

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea7.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea7.setRows(5);
        jTextArea7.setText("Ngôn ngữ sắc sảo,\nthâm thúy và tinh tế,\ntạo nên những hình\nảnh đẹp và sâu sắc.");
        jTextArea7.setBorder(null);
        jTextArea7.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Kawabata ");

        jLabel23.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Yasunari");

        javax.swing.GroupLayout panelShadow7Layout = new javax.swing.GroupLayout(panelShadow7);
        panelShadow7.setLayout(panelShadow7Layout);
        panelShadow7Layout.setHorizontalGroup(
            panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow7Layout.createSequentialGroup()
                .addComponent(pictureBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow7Layout.setVerticalGroup(
            panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow7Layout.createSequentialGroup()
                .addGroup(panelShadow7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pictureBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main1.add(panelShadow7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 240, 170));

        panelShadow6.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow6.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow6.setShadowOpacity(0.3F);

        lblMaQuy.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblMaQuy.setText("Ma quỷ ");
        lblMaQuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMaQuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMaQuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMaQuyMouseExited(evt);
            }
        });

        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/Ma_quy_nhan_gian_kijpg.jpg"))); // NOI18N
        pictureBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox7MouseClicked(evt);
            }
        });

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea6.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea6.setRows(5);
        jTextArea6.setText("\"Ma quỷ nhân gian kí\"\nKhi ma quỷ Việt Nam \nchính thức được đưa \nvào trang sách.\n");
        jTextArea6.setBorder(null);
        jTextArea6.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Hội Nhà Văn");

        lblNhanGianKi.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblNhanGianKi.setText("nhân gian kí");
        lblNhanGianKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanGianKiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanGianKiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanGianKiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelShadow6Layout = new javax.swing.GroupLayout(panelShadow6);
        panelShadow6.setLayout(panelShadow6Layout);
        panelShadow6Layout.setHorizontalGroup(
            panelShadow6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow6Layout.createSequentialGroup()
                .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaQuy, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNhanGianKi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow6Layout.setVerticalGroup(
            panelShadow6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow6Layout.createSequentialGroup()
                .addGroup(panelShadow6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow6Layout.createSequentialGroup()
                        .addComponent(lblMaQuy)
                        .addGap(0, 0, 0)
                        .addComponent(lblNhanGianKi)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main1.add(panelShadow6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 240, 170));

        panelShadow8.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow8.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow8.setShadowOpacity(0.3F);

        seneca.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        seneca.setText("Seneca ");
        seneca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                senecaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                senecaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                senecaMouseExited(evt);
            }
        });

        pictureBox9.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/seneca-nhung-buc-thu-dao-duc_1.jpg"))); // NOI18N
        pictureBox9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox9MouseClicked(evt);
            }
        });

        jTextArea8.setEditable(false);
        jTextArea8.setColumns(20);
        jTextArea8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea8.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea8.setRows(5);
        jTextArea8.setText("Tìm sự bình thản \ntrong tâm trí và đối\nmặt với khó khăn \ntrong cuộc sống.");
        jTextArea8.setBorder(null);
        jTextArea8.setFocusable(false);

        jLabel17.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Seneca");

        nhungbuc.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        nhungbuc.setText("những bức");
        nhungbuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhungbucMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nhungbucMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nhungbucMouseExited(evt);
            }
        });

        thudaoduc.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        thudaoduc.setText("thư đạo đức");
        thudaoduc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thudaoducMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                thudaoducMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                thudaoducMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelShadow8Layout = new javax.swing.GroupLayout(panelShadow8);
        panelShadow8.setLayout(panelShadow8Layout);
        panelShadow8Layout.setHorizontalGroup(
            panelShadow8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow8Layout.createSequentialGroup()
                .addComponent(pictureBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow8Layout.createSequentialGroup()
                        .addGroup(panelShadow8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nhungbuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(thudaoduc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(seneca))
                        .addContainerGap())
                    .addComponent(jTextArea8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        panelShadow8Layout.setVerticalGroup(
            panelShadow8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow8Layout.createSequentialGroup()
                .addGroup(panelShadow8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow8Layout.createSequentialGroup()
                        .addComponent(seneca)
                        .addGap(0, 0, 0)
                        .addComponent(nhungbuc)
                        .addGap(0, 0, 0)
                        .addComponent(thudaoduc)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(pictureBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main1.add(panelShadow8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 240, 170));

        panelShadow11.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow11.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow11.setShadowOpacity(0.3F);

        lblmuonkiep.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblmuonkiep.setText("Muôn kiếp");
        lblmuonkiep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmuonkiepMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblmuonkiepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblmuonkiepMouseExited(evt);
            }
        });

        pictureBox12.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/mduonkiepnhansinh.jpg"))); // NOI18N
        pictureBox12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox12MouseClicked(evt);
            }
        });

        jTextArea12.setEditable(false);
        jTextArea12.setColumns(20);
        jTextArea12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea12.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea12.setRows(5);
        jTextArea12.setText("“Muôn kiếp nhân \nsinh” là một bức \ntranh lớn với vô \nvàn mảnh ghép \ncuộc đời.");
        jTextArea12.setBorder(null);
        jTextArea12.setFocusable(false);

        jLabel26.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Nguyễn Phong");

        lblnhansinh.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblnhansinh.setText("nhân sinh");
        lblnhansinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnhansinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblnhansinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblnhansinhMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelShadow11Layout = new javax.swing.GroupLayout(panelShadow11);
        panelShadow11.setLayout(panelShadow11Layout);
        panelShadow11Layout.setHorizontalGroup(
            panelShadow11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow11Layout.createSequentialGroup()
                .addComponent(pictureBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelShadow11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextArea12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow11Layout.createSequentialGroup()
                        .addGroup(panelShadow11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblmuonkiep)
                            .addComponent(lblnhansinh))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelShadow11Layout.setVerticalGroup(
            panelShadow11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow11Layout.createSequentialGroup()
                .addGroup(panelShadow11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow11Layout.createSequentialGroup()
                        .addComponent(lblmuonkiep)
                        .addGap(0, 0, 0)
                        .addComponent(lblnhansinh)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pictureBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main1.add(panelShadow11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, 240, 170));

        panelShadow10.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow10.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow10.setShadowOpacity(0.3F);

        caycamngot.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        caycamngot.setText("Cây cam ngọt");
        caycamngot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caycamngotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                caycamngotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                caycamngotMouseExited(evt);
            }
        });

        pictureBox11.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/Cay_cam_ngot_cua_toi.png"))); // NOI18N
        pictureBox11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox11MouseClicked(evt);
            }
        });

        jTextArea10.setEditable(false);
        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea10.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea10.setRows(5);
        jTextArea10.setText("Câu chuyện cảm \nđộng về tình yêu \nvà sự sống.");
        jTextArea10.setBorder(null);
        jTextArea10.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("José Mauro ");

        jLabel30.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("de Vasconcelos");

        cuatoi.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        cuatoi.setText("của tôi");
        cuatoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cuatoiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cuatoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cuatoiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelShadow10Layout = new javax.swing.GroupLayout(panelShadow10);
        panelShadow10.setLayout(panelShadow10Layout);
        panelShadow10Layout.setHorizontalGroup(
            panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow10Layout.createSequentialGroup()
                .addComponent(pictureBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caycamngot)
                    .addComponent(cuatoi)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextArea10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow10Layout.setVerticalGroup(
            panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow10Layout.createSequentialGroup()
                .addGroup(panelShadow10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow10Layout.createSequentialGroup()
                        .addComponent(caycamngot)
                        .addGap(0, 0, 0)
                        .addComponent(cuatoi)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel21)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pictureBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main1.add(panelShadow10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 240, 170));

        panelShadow9.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow9.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelShadow9.setShadowOpacity(0.3F);

        lblkhoidau.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblkhoidau.setText("Khởi đầu từ");
        lblkhoidau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkhoidauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblkhoidauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblkhoidauMouseExited(evt);
            }
        });

        pictureBox10.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/khoi_dau_tu_cai_chet_1.jpg"))); // NOI18N
        pictureBox10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox10MouseClicked(evt);
            }
        });

        jTextArea9.setEditable(false);
        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea9.setForeground(new java.awt.Color(90, 90, 90));
        jTextArea9.setRows(5);
        jTextArea9.setText("Xoay quanh câu \nchuyện về Angel \nCrawford  là một\nnhân vật cá biệt\nvà nổi loạn.");
        jTextArea9.setBorder(null);
        jTextArea9.setFocusable(false);

        jLabel19.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Diana Rowland");

        lblcaichet.setFont(new java.awt.Font("sansserif", 3, 15)); // NOI18N
        lblcaichet.setText("cái chết");
        lblcaichet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcaichetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcaichetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcaichetMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelShadow9Layout = new javax.swing.GroupLayout(panelShadow9);
        panelShadow9.setLayout(panelShadow9Layout);
        panelShadow9Layout.setHorizontalGroup(
            panelShadow9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow9Layout.createSequentialGroup()
                .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow9Layout.createSequentialGroup()
                        .addGroup(panelShadow9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(lblcaichet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextArea9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(lblkhoidau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelShadow9Layout.setVerticalGroup(
            panelShadow9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow9Layout.createSequentialGroup()
                .addGroup(panelShadow9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow9Layout.createSequentialGroup()
                        .addComponent(lblkhoidau)
                        .addGap(0, 0, 0)
                        .addComponent(lblcaichet)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main1.add(panelShadow9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 240, 170));

        main.add(main1, java.awt.BorderLayout.CENTER);

        layer.setLayer(main, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerLayout = new javax.swing.GroupLayout(layer);
        layer.setLayout(layerLayout);
        layerLayout.setHorizontalGroup(
            layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layerLayout.setVerticalGroup(
            layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblabcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblabcMouseClicked
        // TODO add your handling code here:
        //String s = lblabc.getText();
        Sach sach = new Sach();
        sach.setData(lblabc.getText());
        showForm(new QLSach());
    }//GEN-LAST:event_lblabcMouseClicked

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        slideshow1.next();
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        slideshow1.back();
    }//GEN-LAST:event_myButton8ActionPerformed

    private void lbldangnhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangnhapMouseExited
        // TODO add your handling code here:
        lbldangnhap.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_lbldangnhapMouseExited

    private void lbldangnhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangnhapMouseEntered
        // TODO add your handling code here:
        lbldangnhap.setForeground(new Color(255, 255, 0));
    }//GEN-LAST:event_lbldangnhapMouseEntered

    private void lbldangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangnhapMouseClicked
        Login lg = new Login();
        lg.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_lbldangnhapMouseClicked

    private void lblquenMK2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquenMK2MouseExited
        // TODO add your handling code here:
        lblquenMK2.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_lblquenMK2MouseExited

    private void lblquenMK2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquenMK2MouseEntered
        // TODO add your handling code here:
        lblquenMK2.setForeground(new Color(255, 255, 0));
    }//GEN-LAST:event_lblquenMK2MouseEntered

    private void lblquenMK2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquenMK2MouseClicked
        // TODO add your handling code here:
        DoiMatKhau dmk = new DoiMatKhau();
        dmk.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_lblquenMK2MouseClicked

    private void QLNhanVIenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLNhanVIenMouseExited
        // TODO add your handling code here:
        QLNhanVIen.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_QLNhanVIenMouseExited

    private void QLNhanVIenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLNhanVIenMouseEntered
        // TODO add your handling code here:
        QLNhanVIen.setForeground(new Color(255, 255, 0));
    }//GEN-LAST:event_QLNhanVIenMouseEntered

    private void lblHoiChungEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoiChungEMouseClicked
        Sach tensach = (Sach) sdao.selectByname("Hội chứng E");
        Auth_Sach.ten = tensach;
        showForm(new QLSach());
    }//GEN-LAST:event_lblHoiChungEMouseClicked

    private void lblHoiChungEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoiChungEMouseEntered
        // TODO add your handling code here:     
        lblHoiChungE.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_lblHoiChungEMouseEntered

    private void lblHoiChungEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoiChungEMouseExited
        // TODO add your handling code here:
        lblHoiChungE.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_lblHoiChungEMouseExited

    private void lblMaQuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaQuyMouseEntered
        // TODO add your handling code here:
        lblMaQuy.setForeground(new Color(0, 153, 51));
        lblNhanGianKi.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_lblMaQuyMouseEntered

    private void lblMaQuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaQuyMouseExited
        // TODO add your handling code here:
        lblMaQuy.setForeground(new Color(0, 0, 0));
        lblNhanGianKi.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_lblMaQuyMouseExited

    private void lblNhanGianKiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanGianKiMouseEntered
        // TODO add your handling code here:
        lblNhanGianKi.setForeground(new Color(0, 153, 51));
        lblMaQuy.setForeground(new Color(0, 153, 51));


    }//GEN-LAST:event_lblNhanGianKiMouseEntered

    private void lblNhanGianKiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanGianKiMouseExited
        // TODO add your handling code here:
        lblNhanGianKi.setForeground(new Color(0, 0, 0));
        lblMaQuy.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_lblNhanGianKiMouseExited

    private void lblMaQuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaQuyMouseClicked
        Sach tensach = sdao.selectByname("Ma Qủy Nhân Gian Kí");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_lblMaQuyMouseClicked

    private void lblNhanGianKiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanGianKiMouseClicked
        Sach tensach = sdao.selectByname("Ma Qủy Nhân Gian Kí");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_lblNhanGianKiMouseClicked

    private void lblkhoidauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkhoidauMouseEntered
        // TODO add your handling code here:
        lblkhoidau.setForeground(new Color(0, 153, 51));
        lblcaichet.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_lblkhoidauMouseEntered

    private void lblkhoidauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkhoidauMouseExited
        // TODO add your handling code here:
        lblkhoidau.setForeground(new Color(0, 0, 0));
        lblcaichet.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_lblkhoidauMouseExited

    private void lblcaichetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcaichetMouseEntered
        // TODO add your handling code here:
        lblcaichet.setForeground(new Color(0, 153, 51));
        lblkhoidau.setForeground(new Color(0, 153, 51));


    }//GEN-LAST:event_lblcaichetMouseEntered

    private void lblcaichetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcaichetMouseExited
        // TODO add your handling code here:
        lblcaichet.setForeground(new Color(0, 0, 0));
        lblkhoidau.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_lblcaichetMouseExited

    private void lblcaichetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcaichetMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Khởi đầu từ cái chết");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_lblcaichetMouseClicked

    private void lblkhoidauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkhoidauMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Khởi đầu từ cái chết");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_lblkhoidauMouseClicked

    private void lblmuonkiepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmuonkiepMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Muôn kiếp nhân sinh");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_lblmuonkiepMouseClicked

    private void lblmuonkiepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmuonkiepMouseEntered
        // TODO add your handling code here:
        lblmuonkiep.setForeground(new Color(0, 153, 51));
        lblnhansinh.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_lblmuonkiepMouseEntered

    private void lblmuonkiepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmuonkiepMouseExited
        // TODO add your handling code here:
        lblmuonkiep.setForeground(new Color(0, 0, 0));
        lblnhansinh.setForeground(new Color(0, 0, 0));


    }//GEN-LAST:event_lblmuonkiepMouseExited

    private void lblnhansinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnhansinhMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Muôn kiếp nhân sinh");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());

    }//GEN-LAST:event_lblnhansinhMouseClicked

    private void lblnhansinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnhansinhMouseEntered
        // TODO add your handling code here:
        lblnhansinh.setForeground(new Color(0, 153, 51));
        lblmuonkiep.setForeground(new Color(0, 153, 51));


    }//GEN-LAST:event_lblnhansinhMouseEntered

    private void lblnhansinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnhansinhMouseExited
        // TODO add your handling code here:
        lblnhansinh.setForeground(new Color(0, 0, 0));
        lblmuonkiep.setForeground(new Color(0, 0, 0));


    }//GEN-LAST:event_lblnhansinhMouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Trà hoa nữ");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Đẹp và buồn");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jLabel8.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        jLabel8.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        jLabel14.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        jLabel14.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_jLabel14MouseExited

    private void senecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senecaMouseEntered
        // TODO add your handling code here:
        seneca.setForeground(new Color(0, 153, 51));
        nhungbuc.setForeground(new Color(0, 153, 51));
        thudaoduc.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_senecaMouseEntered

    private void senecaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senecaMouseExited
        // TODO add your handling code here:
        seneca.setForeground(new Color(0, 0, 0));
        nhungbuc.setForeground(new Color(0, 0, 0));
        thudaoduc.setForeground(new Color(0, 0, 0));


    }//GEN-LAST:event_senecaMouseExited

    private void nhungbucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhungbucMouseEntered
        // TODO add your handling code here:            
        seneca.setForeground(new Color(0, 153, 51));
        nhungbuc.setForeground(new Color(0, 153, 51));
        thudaoduc.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_nhungbucMouseEntered

    private void nhungbucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhungbucMouseExited
        // TODO add your handling code here:
        seneca.setForeground(new Color(0, 0, 0));
        nhungbuc.setForeground(new Color(0, 0, 0));
        thudaoduc.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_nhungbucMouseExited

    private void thudaoducMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thudaoducMouseEntered
        // TODO add your handling code here:
        seneca.setForeground(new Color(0, 153, 51));
        nhungbuc.setForeground(new Color(0, 153, 51));
        thudaoduc.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_thudaoducMouseEntered

    private void thudaoducMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thudaoducMouseExited
        seneca.setForeground(new Color(0, 0, 0));
        nhungbuc.setForeground(new Color(0, 0, 0));
        thudaoduc.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_thudaoducMouseExited

    private void caycamngotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caycamngotMouseEntered
        // TODO add your handling code here:
        caycamngot.setForeground(new Color(0, 153, 51));
        cuatoi.setForeground(new Color(0, 153, 51));

    }//GEN-LAST:event_caycamngotMouseEntered

    private void caycamngotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caycamngotMouseExited
        // TODO add your handling code here:
        caycamngot.setForeground(new Color(0, 0, 0));
        cuatoi.setForeground(new Color(0, 0, 0));


    }//GEN-LAST:event_caycamngotMouseExited

    private void cuatoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatoiMouseEntered
        // TODO add your handling code here:
        caycamngot.setForeground(new Color(0, 153, 51));
        cuatoi.setForeground(new Color(0, 153, 51));
    }//GEN-LAST:event_cuatoiMouseEntered

    private void cuatoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatoiMouseExited
        // TODO add your handling code here:
        caycamngot.setForeground(new Color(0, 0, 0));
        cuatoi.setForeground(new Color(0, 0, 0));


    }//GEN-LAST:event_cuatoiMouseExited

    private void senecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senecaMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Seneca những bức thư đạo đức");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_senecaMouseClicked

    private void nhungbucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhungbucMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Seneca những bức thư đạo đức");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_nhungbucMouseClicked

    private void thudaoducMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thudaoducMouseClicked
        // TODO add your handling code here:    
        Sach tensach = sdao.selectByname("Seneca những bức thư đạo đức");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_thudaoducMouseClicked

    private void caycamngotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caycamngotMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Cây cam ngọt của tôi");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_caycamngotMouseClicked

    private void cuatoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatoiMouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Cây cam ngọt của tôi");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_cuatoiMouseClicked

    private void pictureBox10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox10MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Muôn kiếp nhân sinh");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());

    }//GEN-LAST:event_pictureBox10MouseClicked

    private void pictureBox7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox7MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Ma Qủy Nhân Gian Kí");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox7MouseClicked

    private void pictureBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox6MouseClicked
        // TODO add your handling code here:
        Sach tensach = (Sach) sdao.selectByname("Hội chứng E");
        Auth_Sach.ten = tensach;
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox6MouseClicked

    private void pictureBox12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox12MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Muôn kiếp nhân sinh");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox12MouseClicked

    private void pictureBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Trà hoa nữ");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox5MouseClicked

    private void pictureBox8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox8MouseClicked

        Sach tensach = sdao.selectByname("Đẹp và buồn");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox8MouseClicked

    private void pictureBox9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox9MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Seneca những bức thư đạo đức");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox9MouseClicked

    private void pictureBox11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox11MouseClicked
        // TODO add your handling code here:
        Sach tensach = sdao.selectByname("Cây cam ngọt của tôi");
        Auth_Sach.ten = tensach;
        System.out.println(tensach);
        showForm(new QLSach());
    }//GEN-LAST:event_pictureBox11MouseClicked

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
            java.util.logging.Logger.getLogger(Quanlithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quanlithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quanlithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quanlithuvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Quanlithuvien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Quanlithuvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void init() {
        processLoginSuccessful();
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss a");
                String text = formater.format(now);

                lblDongHo.setText(text);
            }
        }).start();

        getContentPane().setBackground(new Color(255, 255, 255));
        slideshow1.initSlideshow(new sach(), new sinhvien(), new nhanvien(), new phieumuon(), new thongke());
        //setBackground(new Color(0, 0, 0, 0));  //  Remove background

    }

    private void processLoginSuccessful() {
        try {
            loginName.setText(Auth.user.getMaNV());

            if (Auth.user.isVAITRO() == true) {
                vaitro.setText("Thủ thư");
            } else {
                vaitro.setText("Nhân viên");
            }
        } catch (Exception e) {
            MsgBox.showMessageDialog(this, "Vui lòng đăng nhập để sử dụng hệ thống !");
            System.exit(0);
        }
    }
    
    public JPanel getMain() {
    	return main;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel QLNhanVIen;
    private javax.swing.JLabel caycamngot;
    private javax.swing.JLabel cuatoi;
    private component.menu_1 header;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblHoiChungE;
    private javax.swing.JLabel lblMaQuy;
    private javax.swing.JLabel lblNhanGianKi;
    private javax.swing.JLabel lblabc;
    private javax.swing.JLabel lblcaichet;
    private javax.swing.JLabel lbldangnhap;
    private javax.swing.JLabel lblkhoidau;
    private javax.swing.JLabel lblmuonkiep;
    private javax.swing.JLabel lblnhansinh;
    private javax.swing.JLabel lblquenMK2;
    private javax.swing.JLabel loginName;
    private javax.swing.JPanel main;
    private javax.swing.JPanel main1;
    private menu.Menu menu;
    private button.MyButton myButton5;
    private button.MyButton myButton8;
    private javax.swing.JLabel nhungbuc;
    private swing.PanelShadow panelShadow10;
    private swing.PanelShadow panelShadow11;
    private swing.PanelShadow panelShadow4;
    private swing.PanelShadow panelShadow5;
    private swing.PanelShadow panelShadow6;
    private swing.PanelShadow panelShadow7;
    private swing.PanelShadow panelShadow8;
    private swing.PanelShadow panelShadow9;
    private swing.PictureBox pictureBox10;
    private swing.PictureBox pictureBox11;
    private swing.PictureBox pictureBox12;
    private swing.PictureBox pictureBox5;
    private swing.PictureBox pictureBox6;
    private swing.PictureBox pictureBox7;
    private swing.PictureBox pictureBox8;
    private swing.PictureBox pictureBox9;
    private javax.swing.JLabel role;
    private javax.swing.JLabel seneca;
    private slideshow.Slideshow slideshow1;
    private javax.swing.JLabel thudaoduc;
    private javax.swing.JLabel vaitro;
    // End of variables declaration//GEN-END:variables

}
