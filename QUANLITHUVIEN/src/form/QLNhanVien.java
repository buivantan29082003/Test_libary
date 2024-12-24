/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import Dao.NhanVienDao;
import Entity.NhanVien;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;

public class QLNhanVien extends javax.swing.JPanel {

    NhanVienDao nvdao = new NhanVienDao();
    int row = 0;
    public String announce="";
    boolean conf;
    private static final String P_SDT = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$";
    private static final String P_Mail = "^[a-zA-Z0-9._%+-]+@(fpt\\.edu\\.vn|gmail\\.com)$";
    private static final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=])[A-Za-z\\d@#$%^&+=]{5,10}$";
    private static final String Name = "^[\\p{L}\\s]+$";

    public QLNhanVien() {
        initComponents();
        init();
        tblNhanVien.setDefaultEditor(Object.class, null);
    }
    

    
//    public JPanel getMain() {
//    	return main;
//    }

    public NhanVienDao getNvdao() {
		return nvdao;
	}

	public void setNvdao(NhanVienDao nvdao) {
		this.nvdao = nvdao;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public javax.swing.ButtonGroup getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(javax.swing.ButtonGroup gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public javax.swing.JLabel getQLNhanVIen() {
		return QLNhanVIen;
	}

	public void setQLNhanVIen(javax.swing.JLabel qLNhanVIen) {
		QLNhanVIen = qLNhanVIen;
	}

	public javax.swing.ButtonGroup getVaitro() {
		return Vaitro;
	}

	public void setVaitro(javax.swing.ButtonGroup vaitro) {
		Vaitro = vaitro;
	}

	public javax.swing.JLabel getDisable() {
		return disable;
	}

	public void setDisable(javax.swing.JLabel disable) {
		this.disable = disable;
	}

	public component.menu_1 getHeader() {
		return header;
	}

	public void setHeader(component.menu_1 header) {
		this.header = header;
	}

	public javax.swing.JLabel getjLabel10() {
		return jLabel10;
	}

	public void setjLabel10(javax.swing.JLabel jLabel10) {
		this.jLabel10 = jLabel10;
	}

	public javax.swing.JLabel getjLabel11() {
		return jLabel11;
	}

	public void setjLabel11(javax.swing.JLabel jLabel11) {
		this.jLabel11 = jLabel11;
	}

	public javax.swing.JLabel getjLabel12() {
		return jLabel12;
	}

	public void setjLabel12(javax.swing.JLabel jLabel12) {
		this.jLabel12 = jLabel12;
	}

	public javax.swing.JLabel getjLabel13() {
		return jLabel13;
	}

	public void setjLabel13(javax.swing.JLabel jLabel13) {
		this.jLabel13 = jLabel13;
	}

	public javax.swing.JLabel getjLabel14() {
		return jLabel14;
	}

	public void setjLabel14(javax.swing.JLabel jLabel14) {
		this.jLabel14 = jLabel14;
	}

	public javax.swing.JLabel getjLabel18() {
		return jLabel18;
	}

	public void setjLabel18(javax.swing.JLabel jLabel18) {
		this.jLabel18 = jLabel18;
	}

	public javax.swing.JLabel getjLabel7() {
		return jLabel7;
	}

	public void setjLabel7(javax.swing.JLabel jLabel7) {
		this.jLabel7 = jLabel7;
	}

	public javax.swing.JLabel getjLabel8() {
		return jLabel8;
	}

	public void setjLabel8(javax.swing.JLabel jLabel8) {
		this.jLabel8 = jLabel8;
	}

	public javax.swing.JLabel getjLabel9() {
		return jLabel9;
	}

	public void setjLabel9(javax.swing.JLabel jLabel9) {
		this.jLabel9 = jLabel9;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JLabel getLblDongHo() {
		return lblDongHo;
	}

	public void setLblDongHo(javax.swing.JLabel lblDongHo) {
		this.lblDongHo = lblDongHo;
	}

	public javax.swing.JLabel getLblMail1() {
		return lblMail1;
	}

	public void setLblMail1(javax.swing.JLabel lblMail1) {
		this.lblMail1 = lblMail1;
	}

	public javax.swing.JLabel getLblMatKhau() {
		return lblMatKhau;
	}

	public void setLblMatKhau(javax.swing.JLabel lblMatKhau) {
		this.lblMatKhau = lblMatKhau;
	}

	public javax.swing.JLabel getLblNgaySinh() {
		return lblNgaySinh;
	}

	public void setLblNgaySinh(javax.swing.JLabel lblNgaySinh) {
		this.lblNgaySinh = lblNgaySinh;
	}

	public javax.swing.JLabel getLblNhanhVien() {
		return lblNhanhVien;
	}

	public void setLblNhanhVien(javax.swing.JLabel lblNhanhVien) {
		this.lblNhanhVien = lblNhanhVien;
	}

	public javax.swing.JLabel getLblSoDienThoai() {
		return lblSoDienThoai;
	}

	public void setLblSoDienThoai(javax.swing.JLabel lblSoDienThoai) {
		this.lblSoDienThoai = lblSoDienThoai;
	}

	public javax.swing.JLabel getLblTenNhanVien() {
		return lblTenNhanVien;
	}

	public void setLblTenNhanVien(javax.swing.JLabel lblTenNhanVien) {
		this.lblTenNhanVien = lblTenNhanVien;
	}

	public javax.swing.JPanel getMain() {
		return main;
	}

	public void setMain(javax.swing.JPanel main) {
		this.main = main;
	}

	public button.MyButton getMyButton1() {
		return myButton1;
	}

	public void setMyButton1(button.MyButton myButton1) {
		this.myButton1 = myButton1;
	}

	public button.MyButton getMyButton2() {
		return myButton2;
	}

	public void setMyButton2(button.MyButton myButton2) {
		this.myButton2 = myButton2;
	}

	public button.MyButton getMyButton3() {
		return myButton3;
	}

	public void setMyButton3(button.MyButton myButton3) {
		this.myButton3 = myButton3;
	}

	public button.MyButton getMyButton4() {
		return myButton4;
	}

	public void setMyButton4(button.MyButton myButton4) {
		this.myButton4 = myButton4;
	}

	public button.MyButton getMyButton5() {
		return myButton5;
	}

	public void setMyButton5(button.MyButton myButton5) {
		this.myButton5 = myButton5;
	}

	public button.MyButton getMyButton6() {
		return myButton6;
	}

	public void setMyButton6(button.MyButton myButton6) {
		this.myButton6 = myButton6;
	}

	public button.MyButton getMyButton7() {
		return myButton7;
	}

	public void setMyButton7(button.MyButton myButton7) {
		this.myButton7 = myButton7;
	}

	public button.MyButton getMyButton8() {
		return myButton8;
	}

	public void setMyButton8(button.MyButton myButton8) {
		this.myButton8 = myButton8;
	}

	public swing.menu.PanelBorder getPanelBorder1() {
		return panelBorder1;
	}

	public void setPanelBorder1(swing.menu.PanelBorder panelBorder1) {
		this.panelBorder1 = panelBorder1;
	}

	public javax.swing.JRadioButton getRdoNV() {
		return rdoNV;
	}

	public void setRdoNV(javax.swing.JRadioButton rdoNV) {
		this.rdoNV = rdoNV;
	}

	public javax.swing.JRadioButton getRdoNam() {
		return rdoNam;
	}

	public void setRdoNam(javax.swing.JRadioButton rdoNam) {
		this.rdoNam = rdoNam;
	}

	public javax.swing.JRadioButton getRdoNu() {
		return rdoNu;
	}

	public void setRdoNu(javax.swing.JRadioButton rdoNu) {
		this.rdoNu = rdoNu;
	}

	public javax.swing.JRadioButton getRdoTT() {
		return rdoTT;
	}

	public void setRdoTT(javax.swing.JRadioButton rdoTT) {
		this.rdoTT = rdoTT;
	}

	public javax.swing.JLabel getShow() {
		return show;
	}

	public void setShow(javax.swing.JLabel show) {
		this.show = show;
	}

	public javax.swing.JTable getTblNhanVien() {
		return tblNhanVien;
	}

	public void setTblNhanVien(javax.swing.JTable tblNhanVien) {
		this.tblNhanVien = tblNhanVien;
	}

	public button.textfield.TextField getTxtGhiChu() {
		return txtGhiChu;
	}

	public void setTxtGhiChu(button.textfield.TextField txtGhiChu) {
		this.txtGhiChu = txtGhiChu;
	}

	public button.textfield.TextField getTxtMaNV() {
		return txtMaNV;
	}

	public void setTxtMaNV(button.textfield.TextField txtMaNV) {
		this.txtMaNV = txtMaNV;
	}

	public button.textfield.TextField getTxtMail() {
		return txtMail;
	}

	public void setTxtMail(button.textfield.TextField txtMail) {
		this.txtMail = txtMail;
	}

	public button.JPassword.PasswordField getTxtMatKhau() {
		return txtMatKhau;
	}

	public void setTxtMatKhau(button.JPassword.PasswordField txtMatKhau) {
		this.txtMatKhau = txtMatKhau;
	}

	public com.toedter.calendar.JDateChooser getTxtNgaySinh() {
		return txtNgaySinh;
	}

	public void setTxtNgaySinh(com.toedter.calendar.JDateChooser txtNgaySinh) {
		this.txtNgaySinh = txtNgaySinh;
	}

	public button.textfield.TextField getTxtSDT() {
		return txtSDT;
	}

	public void setTxtSDT(button.textfield.TextField txtSDT) {
		this.txtSDT = txtSDT;
	}

	public button.textfield.TextField getTxtTenNV() {
		return txtTenNV;
	}

	public void setTxtTenNV(button.textfield.TextField txtTenNV) {
		this.txtTenNV = txtTenNV;
	}

	public static String getpSdt() {
		return P_SDT;
	}

	public static String getpMail() {
		return P_Mail;
	}

	public static String getPasswordregex() {
		return passwordRegex;
	}
	


//	public static String getName() {
//		return Name;
//	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GioiTinh = new javax.swing.ButtonGroup();
        Vaitro = new javax.swing.ButtonGroup();
        panelBorder1 = new swing.menu.PanelBorder();
        main = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new button.textfield.TextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        txtMail = new button.textfield.TextField();
        jLabel13 = new javax.swing.JLabel();
        txtMatKhau = new button.JPassword.PasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtSDT = new button.textfield.TextField();
        jLabel18 = new javax.swing.JLabel();
        rdoTT = new javax.swing.JRadioButton();
        rdoNV = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtTenNV = new button.textfield.TextField();
        txtGhiChu = new button.textfield.TextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        header = new component.menu_1();
        QLNhanVIen = new javax.swing.JLabel();
        myButton1 = new button.MyButton();
        myButton3 = new button.MyButton();
        myButton4 = new button.MyButton();
        myButton2 = new button.MyButton();
        myButton7 = new button.MyButton();
        myButton8 = new button.MyButton();
        myButton5 = new button.MyButton();
        myButton6 = new button.MyButton();
        lblDongHo = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblNhanhVien = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblMail1 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1081, 633));

        panelBorder1.setBackground(new java.awt.Color(255, 204, 204));

        main.setBackground(new java.awt.Color(255, 204, 204));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel7.setText("Mã nhân viên:");
        main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        txtMaNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaNVFocusLost(evt);
            }
        });
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaNVKeyReleased(evt);
            }
        });
        main.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 230, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel10.setText("Ngày sinh:");
        main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel11.setText("Giới tính:");
        main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        GioiTinh.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });
        main.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 92, 64, 34));

        GioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");
        main.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 92, 64, 34));

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel14.setText("Mail:");
        main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMailFocusLost(evt);
            }
        });
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });
        txtMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMailKeyReleased(evt);
            }
        });
        main.add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 230, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel13.setText("Mật khẩu:");
        main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 70, -1));

        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyReleased(evt);
            }
        });
        main.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 180, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel9.setText("SDT:");
        main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        txtSDT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSDTCaretUpdate(evt);
            }
        });
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });
        main.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 230, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel18.setText("Vai Trò:");
        main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 72, 70, -1));

        Vaitro.add(rdoTT);
        rdoTT.setText("Thủ Thư");
        rdoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTTActionPerformed(evt);
            }
        });
        main.add(rdoTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 92, 90, 34));

        Vaitro.add(rdoNV);
        rdoNV.setText("Nhân Viên");
        main.add(rdoNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 92, 100, 34));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel8.setText("Tên nhân viên:");
        main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        txtTenNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenNVFocusLost(evt);
            }
        });
        txtTenNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenNVKeyReleased(evt);
            }
        });
        main.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 230, -1));

        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });
        main.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 240, 120));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel12.setText("Ghi chú:");
        main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 70, -1));

        tblNhanVien.setBackground(new java.awt.Color(204, 204, 204));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên nhân viên", "Vai trò", "SDT", "Ngày sinh", "GT", "Mật khẩu", "Email", "Ghi chú"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(115);
            tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(85);
            tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(45);
            tblNhanVien.getColumnModel().getColumn(6).setPreferredWidth(60);
            tblNhanVien.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        main.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 660, 380));

        QLNhanVIen.setBackground(new java.awt.Color(102, 102, 102));
        QLNhanVIen.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        QLNhanVIen.setForeground(new java.awt.Color(255, 255, 255));
        QLNhanVIen.setText("Quản lí nhân viên");
        QLNhanVIen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QLNhanVIenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                QLNhanVIenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(QLNhanVIen)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QLNhanVIen)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        main.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-plus.png"))); // NOI18N
        myButton1.setColorClick(new java.awt.Color(255, 204, 153));
        myButton1.setRadius(10);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        main.add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 528, 50, 45));

        myButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-pencil.png"))); // NOI18N
        myButton3.setRadius(10);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        main.add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 528, 50, 45));

        myButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bxs-news.png"))); // NOI18N
        myButton4.setRadius(10);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        main.add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 528, 50, 45));

        myButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-x.png"))); // NOI18N
        myButton2.setRadius(10);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        main.add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 528, 50, 45));

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/first-page-regular-24.png"))); // NOI18N
        myButton7.setRadius(10);
        myButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton7ActionPerformed(evt);
            }
        });
        main.add(myButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 528, 50, 45));

        myButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-chevron-left.png"))); // NOI18N
        myButton8.setRadius(10);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });
        main.add(myButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 528, 50, 45));

        myButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-chevron-right.png"))); // NOI18N
        myButton5.setRadius(10);
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });
        main.add(myButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 528, 50, 45));

        myButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bx-last-page.png"))); // NOI18N
        myButton6.setRadius(10);
        myButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton6ActionPerformed(evt);
            }
        });
        main.add(myButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 528, 50, 45));

        lblDongHo.setText("Đồng hồ");
        main.add(lblDongHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 604, 70, -1));

        lblSoDienThoai.setForeground(new java.awt.Color(255, 255, 255));
        main.add(lblSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 210, 20));

        lblNhanhVien.setForeground(new java.awt.Color(255, 255, 255));
        main.add(lblNhanhVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 210, 20));

        lblTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        main.add(lblTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 210, 20));

        lblMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        main.add(lblMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 210, 20));

        lblNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        main.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 210, 20));

        lblMail1.setForeground(new java.awt.Color(255, 255, 255));
        main.add(lblMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 210, 20));
        main.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 220, 30));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        main.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 40, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        main.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 40, 40));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1081, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void rdoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoTTActionPerformed

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void tblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMousePressed
        if (evt.getClickCount() == 1) {
        	System.out.println("Hello wworlđ");
            this.row = tblNhanVien.getSelectedRow();
            this.edit();
            clearValidate();
        }
    }//GEN-LAST:event_tblNhanVienMousePressed


    
    private void QLNhanVIenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLNhanVIenMouseEntered
        // TODO add your handling code here:
        QLNhanVIen.setForeground(new Color(255, 255, 0));
    }//GEN-LAST:event_QLNhanVIenMouseEntered

    private void QLNhanVIenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLNhanVIenMouseExited
        // TODO add your handling code here:
        QLNhanVIen.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_QLNhanVIenMouseExited

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        insert();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        update();
    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        clearForm();
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        delete();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        first();
    }//GEN-LAST:event_myButton7ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        prev();
    }//GEN-LAST:event_myButton8ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        last();
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        next();
    }//GEN-LAST:event_myButton6ActionPerformed

    private void txtMaNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyReleased
        // TODO add your handling code here:
        validateEditMaNV();
    }//GEN-LAST:event_txtMaNVKeyReleased

    private void txtMailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMailFocusLost
        // TODO add your handling code here:
        if (txtMail.getText().equals("")) {
            lblMail1.setText("Chưa nhập mail");
            txtMail.setBackground(Color.red);
            lblMail1.setForeground(Color.red);
        } else {
            if (checkMail() == true) {
                lblMail1.setText("");
                txtMail.setBackground(Color.white);
                lblMail1.setForeground(Color.white);
            }

        }

    }//GEN-LAST:event_txtMailFocusLost

    private void txtMailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailKeyReleased
        if (txtMail.getText().equals("")) {
            lblMail1.setText("Chưa nhập mail");
            txtMail.setBackground(Color.red);
            lblMail1.setForeground(Color.red);
        } else {
            lblMail1.setText("");
            txtMail.setBackground(Color.white);
            lblMail1.setForeground(Color.white);
        }

    }//GEN-LAST:event_txtMailKeyReleased

    private void txtTenNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenNVKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTenNVKeyReleased

    private void txtTenNVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNVFocusLost
        // TODO add your handling code here:
        if (txtTenNV.getText().equals("")) {
            lblTenNhanVien.setText("Chưa nhập tên nhân viên");
            txtTenNV.setBackground(Color.red);
            lblTenNhanVien.setForeground(Color.red);
        } else {
            if (checkName() == true) {
                lblTenNhanVien.setText("");
                txtTenNV.setBackground(Color.white);
                lblTenNhanVien.setForeground(Color.white);
            }

        }
    }//GEN-LAST:event_txtTenNVFocusLost

    private void txtMaNVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNVFocusLost
        // TODO add your handling code here:
        if (txtMaNV.getText().equals("")) {
            lblNhanhVien.setText("Chưa nhập mã nhân viên");
            txtMaNV.setBackground(Color.red);
            lblNhanhVien.setForeground(Color.red);
        } else {
//            if (checkTrungMaNV(txtMaNV) == false) {
//                lblNhanhVien.setText("Mã nhân đã tồn tại");
//                txtMaNV.setBackground(Color.red);
//                lblNhanhVien.setForeground(Color.red);
//            } else {
                lblNhanhVien.setText("");
                txtMaNV.setBackground(Color.white);
                lblNhanhVien.setForeground(Color.white);
//            }

        }
    }//GEN-LAST:event_txtMaNVFocusLost

    private void txtMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyReleased
        String MK = new String(txtMatKhau.getPassword());
        if (MK.equals("")) {
            lblMatKhau.setText("Chưa nhập mã mật khẩu");
            txtMatKhau.setBackground(Color.red);
            lblMatKhau.setForeground(Color.red);
        } else {
            lblMatKhau.setText("");
            txtMatKhau.setBackground(Color.white);
            lblMatKhau.setForeground(Color.white);
        }
    }//GEN-LAST:event_txtMatKhauKeyReleased

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        // TODO add your handling code here:
        String MK = new String(txtMatKhau.getPassword());
        if (MK.equals("")) {
            lblMatKhau.setText("Chưa nhập mật khẩu");
            txtMatKhau.setBackground(Color.red);
            lblMatKhau.setForeground(Color.red);
        } else {
            if (checkPas() == true) {
                lblMatKhau.setText("");
                txtMatKhau.setBackground(Color.white);
                lblMatKhau.setForeground(Color.white);
            }
        }
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        // TODO add your handling code here:
        if (txtSDT.getText().equals("")) {
            lblSoDienThoai.setText("Chưa nhập SDT");
            txtSDT.setBackground(Color.red);
            lblSoDienThoai.setForeground(Color.red);
        } else {
            if (checkSDT() == true) {
                lblSoDienThoai.setText("");
                txtSDT.setBackground(Color.white);
                lblSoDienThoai.setForeground(Color.white);
            }

        }
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        // TODO add your handling code here:
        if (txtSDT.getText().equals("")) {
            lblSoDienThoai.setText("Chưa nhập SDT");
            txtSDT.setBackground(Color.red);
            lblSoDienThoai.setForeground(Color.red);
        } else {

            lblSoDienThoai.setText("");
            txtSDT.setBackground(Color.white);
            lblSoDienThoai.setForeground(Color.white);

        }

    }//GEN-LAST:event_txtSDTKeyReleased

    private void txtSDTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSDTCaretUpdate
//        checkDiem();
    }//GEN-LAST:event_txtSDTCaretUpdate

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtMatKhau.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtMatKhau.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GioiTinh;
    private javax.swing.JLabel QLNhanVIen;
    private javax.swing.ButtonGroup Vaitro;
    private javax.swing.JLabel disable;
    private component.menu_1 header;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblMail1;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblNhanhVien;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JPanel main;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    private button.MyButton myButton3;
    private button.MyButton myButton4;
    private button.MyButton myButton5;
    private button.MyButton myButton6;
    private button.MyButton myButton7;
    private button.MyButton myButton8;
    private swing.menu.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rdoNV;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTT;
    private javax.swing.JLabel show;
    private javax.swing.JTable tblNhanVien;
    private button.textfield.TextField txtGhiChu;
    private button.textfield.TextField txtMaNV;
    private button.textfield.TextField txtMail;
    private button.JPassword.PasswordField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private button.textfield.TextField txtSDT;
    private button.textfield.TextField txtTenNV;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = nvdao.selectAll();
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.isVAITRO() ? "Thủ thư" : "Nhân viên",
                    nv.getSDT(),
                    nv.getNGAYSINH(),
                    nv.isGIOITINH() ? "Nam" : "Nữ",
                    nv.getMatKhau(),
                    nv.getEMAIL(),
                    nv.getGHICHU(),};
                model.addRow(row);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu nhân viên!");
            e.printStackTrace();
        }
    }

    public JOptionPane p;
    public void seth(JOptionPane k) {
    	p=k;
    }
    private void insert() {
        if (validateInsert() == true) {
            NhanVien nv = this.getForm();

            try {
                nvdao.insert(nv); // thêm mới
                this.fillTable(); // đỗ lại bảng
                this.clear1(); // xóa trắng form
                announce="Thêm nhân viên mới thành công!";
                p.showMessageDialog(this, announce);
            } catch (Exception e) {
            	announce="Thêm nhân viên mới thất bại!";
            	JOptionPane.showMessageDialog(this, announce);
                e.printStackTrace();

            }
        }
    }
    

    private void update() {
        if (validateEdit()) {

            NhanVien nv = this.getForm();

            try {
                nvdao.update(nv); // cập nhật
                this.fillTable(); // đổ lại bảng
                announce= "Cập nhật nhân viên thành công!";
                JOptionPane.showMessageDialog(this,announce);
            } catch (Exception e) {
            	announce="Cập nhật nhân viên thất bại!";
            	JOptionPane.showMessageDialog(this, announce);
                e.printStackTrace();
            }
        }

    }

    private void delete() {

        String manv = txtMaNV.getText();
        conf=MsgBox.confirm(this, "Bạn có thực sự muốn xóa nhân viên này không?");
        if (conf) {
            try {
                nvdao.delete(manv);
                this.fillTable();
                this.clear1();
                announce="Xóa nhân viên thành công!";
                MsgBox.alert(this, announce);
            } catch (Exception e) {
            	announce="Nhân viên còn hoạt động!";
                MsgBox.alert(this, announce);
                e.printStackTrace();
            }
        }

    }

    private void clearForm() {
        NhanVien nv = new NhanVien();
        this.setForm(nv);
        this.row = -1;
        this.updateStatus();
    }

    private void clear1() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtNgaySinh.setCalendar(null);
        txtSDT.setText("");
        txtMatKhau.setText("");
        GioiTinh.clearSelection();
        GioiTinh.clearSelection();
        txtMail.setText("");
        txtGhiChu.setText("");
    }

    private void edit() {
        try {
            String manv = (String) tblNhanVien.getValueAt(this.row, 0);
            NhanVien nv = nvdao.selectById(manv);
            if (nv != null) {
                this.setForm(nv);
//                jTabbedPane1.setSelectedIndex(0);
                this.updateStatus();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void setForm(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtTenNV.setText(nv.getTenNV());

        rdoNam.setSelected(nv.isGIOITINH());
        rdoNu.setSelected(!nv.isGIOITINH());
        txtSDT.setText(nv.getSDT());
        txtNgaySinh.setDate(nv.getNGAYSINH());

        rdoTT.setSelected(nv.isVAITRO());
        rdoNV.setSelected(!nv.isVAITRO());
        txtMatKhau.setText(nv.getMatKhau());
        txtMail.setText(nv.getEMAIL());
        txtGhiChu.setText(nv.getGHICHU());

    }

    private NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setTenNV(txtTenNV.getText());
        nv.setVAITRO(rdoTT.isSelected());
        nv.setSDT(txtSDT.getText());
        nv.setNGAYSINH(txtNgaySinh.getDate());
        nv.setGIOITINH(rdoNam.isSelected());
        nv.setMatKhau(txtMatKhau.getText());
        nv.setEMAIL(txtMail.getText());
        nv.setGHICHU(txtGhiChu.getText());

        return nv;
    }

    public void init() {
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss a");
                String text = formater.format(now);

                lblDongHo.setText(text);
            }
        }).start();
        this.fillTable();
        this.updateStatus();
    }

    public static boolean checkTrungMaNV(JTextField txt) {
        NhanVienDao nv = new NhanVienDao();
        if (nv.selectById(txt.getText()) == null) {
            return true;
        }
        return false;
    }

    public static boolean checkTrungMail(JTextField txt) {
        NhanVienDao nv = new NhanVienDao();
        if (nv.selectByEmail(txt.getText()) == null) {
            return true;
        }
        return false;
    }

    public static boolean checkTrungSDT(JTextField txt) {
        NhanVienDao nv = new NhanVienDao();
        if (nv.selectBySDT(txt.getText()) == null) {
            return true;
        }
        return false;
    }

    public boolean checkMail() {
        Matcher Mail = Pattern.compile(P_Mail).matcher(txtMail.getText());
        if (!Mail.matches()) {
            lblMail1.setText("Sai định dạng mail");
            txtMail.setBackground(Color.red);
            lblMail1.setForeground(Color.red);
            return false;
        }
        return true;
    }

    public boolean checkName() {

        Matcher name = Pattern.compile(Name).matcher(txtTenNV.getText());
        if (!name.matches()) {
            lblTenNhanVien.setText("Sai định dạng");
            txtTenNV.setBackground(Color.red);
            lblTenNhanVien.setForeground(Color.red);
            return false;
        }
        return true;
    }

    public boolean checkPas() {
        String mk = new String(txtMatKhau.getPassword());
        Matcher pas = Pattern.compile(passwordRegex).matcher(mk);
        if (!pas.matches()) {
            lblMatKhau.setText("Sai định dạng");
            txtMatKhau.setBackground(Color.red);
            lblMatKhau.setForeground(Color.red);
            return false;
        }
        return true;
    }

    public boolean checkSDT() {
        Matcher SDT = Pattern.compile(P_SDT).matcher(txtSDT.getText());
        if (!SDT.matches()) {
            lblSoDienThoai.setText("Sai định dạng SDT");
            txtSDT.setBackground(Color.red);
            lblSoDienThoai.setForeground(Color.red);
            return false;
        }
        return true;
    }

    public boolean checkNgaySinh() {
        Date selectedDate = txtNgaySinh.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2006, Calendar.JANUARY, 1);
        Date comparisonDate = calendar.getTime();

        if (selectedDate.after(comparisonDate)) {
        	announce="Nhân viên phải đủ 18 tuổi!";
        	JOptionPane.showMessageDialog(this, announce);
          //  txtNgaySinh.setBackground(Color.red);
            lblNgaySinh.setForeground(Color.red);
            return false;
        }

        return true;
    }

    public boolean validateEditMaNV() {
        checkTrungMaNV(txtMaNV);
        lblNhanhVien.setText("");
        txtMaNV.setBackground(Color.white);
        lblNhanhVien.setForeground(Color.white);
        return false;
    }

    public void clearValidate() {
        lblTenNhanVien.setText("");
        lblNhanhVien.setText("");
        lblSoDienThoai.setText("");
        lblNgaySinh.setText("");
        lblMatKhau.setText("");
        lblMail1.setText("");
        txtMaNV.setBackground(Color.white);
        txtTenNV.setBackground(Color.white);
        txtMatKhau.setBackground(Color.white);
        txtMail.setBackground(Color.white);
        txtNgaySinh.setBackground(Color.white);
        txtSDT.setBackground(Color.white);

    }

    public boolean validateInsert() {

        //Mã nhân viên
        if (txtMaNV.getText().equals("")) {
            lblNhanhVien.setText("Chưa nhập mã nhân viên");
            txtMaNV.setBackground(Color.red);
            lblNhanhVien.setForeground(Color.RED);
            return false;
        }
        if (checkTrungMaNV(txtMaNV) == false) {
            lblNhanhVien.setText("Mã nhân viên đã có trong dữ liệu");
            txtMaNV.setBackground(Color.red);
            lblNhanhVien.setForeground(Color.RED);
            return false;
        }
//Tên nhân viên
        if (txtTenNV.getText().equals("")) {
            lblTenNhanVien.setText("Chưa nhập tên nhân viên");
            txtTenNV.setBackground(Color.red);
            lblTenNhanVien.setForeground(Color.RED);
            return false;
        }
        if (checkName() == false) {
            return false;
        }
        // Mật khẩu
        if (txtMatKhau.getText().equals("")) {
            lblMatKhau.setText("Chưa nhập mật khẩu");
            txtMatKhau.setBackground(Color.red);
            lblMatKhau.setForeground(Color.RED);
            return false;
        }
        if (checkPas() == false) {
            return false;
        }
//Số điện thoại 
        if (txtSDT.getText().equals("")) {
            lblSoDienThoai.setText("Chưa nhập SDT");
            txtSDT.setBackground(Color.red);
            lblSoDienThoai.setForeground(Color.RED);
            return false;
        }
        if (checkSDT() == false) {
            return false;
        }
        if (checkTrungSDT(txtSDT) == false) {
            lblSoDienThoai.setText("SDT đã có nhân viên sở hữu");
            txtSDT.setBackground(Color.red);
            lblSoDienThoai.setForeground(Color.RED);
            return false;
        }

        //Ngày sinh
        if (txtNgaySinh.getDate() == null || txtNgaySinh.getDate().equals("")) {
            lblNgaySinh.setText("Chưa nhập ngày sinh");
            //txtNgaySinh.setBackground(Color.red);
           //// lblNgaySinh.setForeground(Color.red);
            
            return false;
        }  
        if (checkNgaySinh() == false) {
            return false;
        }
        //Mail
        if (txtMail.getText().equals("")) {
            lblMail1.setText("Chưa nhập mail");
            txtMail.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày sinh");
            return false;
        }

        if (checkMail() == false) {
            return false;
        }
        System.out.println(txtMail.getText());
        if (checkTrungMail(txtMail) == false) {
            lblMail1.setText("Mail này đã có nhân viên sở hữu");
            txtMail.setBackground(Color.red);
            lblMail1.setForeground(Color.RED);
            return false;
        }

//        //vai trò
        if (Vaitro.isSelected(null)) {
        	announce="Chưa chọn vai trò !";
        	JOptionPane.showMessageDialog(this, announce);
            return false;
        }
        if (GioiTinh.isSelected(null)) {
        	announce="Chưa chọn giới tính!";
        	JOptionPane.showMessageDialog(this, announce);
            return false;
        }

        return true;
    }

    public boolean validateEdit() {

        //Mã nhân viên
        if (txtMaNV.getText().equals("")) {
            lblNhanhVien.setText("Chưa nhập mã nhân viên");
            txtMaNV.setBackground(Color.red);
            lblNhanhVien.setForeground(Color.RED);
            return false;
        }
        if (checkTrungMaNV(txtMaNV) == true) {
            lblNhanhVien.setText("Mã nhân viên không có trong dữ liệu");
            txtMaNV.setBackground(Color.red);
            lblNhanhVien.setForeground(Color.RED);
            return false;
        }
//Tên nhân viên
        if (txtTenNV.getText().equals("")) {
            lblTenNhanVien.setText("Chưa nhập tên nhân viên");
            txtTenNV.setBackground(Color.red);
            lblTenNhanVien.setForeground(Color.RED);
            return false;
        }
        if (checkName() == false) {
            return false;
        }
        // Mật khẩu
        if (txtMatKhau.getText().equals("")) {
            lblMatKhau.setText("Chưa nhập mật khẩu");
            txtMatKhau.setBackground(Color.red);
            lblMatKhau.setForeground(Color.RED);
            return false;
        }
        if (checkPas() == false) {
            return false;
        }
//Số điện thoại 
        if (txtSDT.getText().equals("")) {
            lblSoDienThoai.setText("Chưa nhập SDT");
            txtSDT.setBackground(Color.red);
            lblSoDienThoai.setForeground(Color.RED);
            return false;
        }
        if (checkSDT() == false) {
            return false;
        }
//        if (checkTrungSDT(txtSDT) == true) {
//            lblSoDienThoai.setText("SDT phải có nhân viên sở hữu");
//            txtSDT.setBackground(Color.red);
//            lblSoDienThoai.setForeground(Color.RED);
//            return false;
//        }

        //Ngày sinh
        if (txtNgaySinh.getDate().equals(null)) {
            lblNgaySinh.setText("Chưa nhập ngày sinh");
            txtNgaySinh.setBackground(Color.red);
            lblNgaySinh.setForeground(Color.red);
            return false;
        }
        if (checkNgaySinh() == false) {
            return false;
        }

        //Mail
        if (txtMail.getText().equals("")) {
            lblMail1.setText("Chưa nhập mail");
            txtMail.setBackground(Color.red);
            lblMail1.setForeground(Color.RED);
            return false;
        }

        if (checkMail() == false) {
            return false;
        }
        System.out.println(txtMail.getText());
//        if (checkTrungMail(txtMail) == true) {
//            lblMail1.setText("Mail này phải có nhân viên sở hữu");
//            txtMail.setBackground(Color.red);
//            lblMail1.setForeground(Color.RED);
//            return false;
//        }

//        //vai trò
        if (Vaitro.isSelected(null)) {
        	JOptionPane.showMessageDialog(this, "Chưa chọn vai trò !");
            return false;
        }
        if (GioiTinh.isSelected(null)) {
            JOptionPane.showMessageDialog(this, "Chưa chọn giới tính!");
            return false;
        }

        return true;
    }

    private void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNhanVien.getRowCount() - 1);
        // Trạng thái form
//        txtMaNhanVien.setEditable(!edit);
//        btnThem.setEnabled(!edit);
//        btnSua.setEnabled(edit);
//        btnXoa.setEnabled(edit);
//
//        // Trạng thái điều hướng
//        btnFirst.setEnabled(edit && !first);
//        btnPrev.setEnabled(edit && !first);
//        btnNext.setEnabled(edit && !last);
//        btnLast.setEnabled(edit && !last);
    }

    public void showsgreenline(int index) {

        //Hien dong xanh trong table moi khi nhan next,prev,first,last;
        tblNhanVien.setRowSelectionInterval(index, index);
    }

    private void first() {
        this.row = 0;
        showsgreenline(row);
        this.edit();
    }

    private void prev() {
        if (this.row > 0) {
            this.row--;
            showsgreenline(row);
            this.edit();
        }
    }

    private void next() {
        if (this.row < tblNhanVien.getRowCount() - 1) {
            this.row++;
            showsgreenline(row);
            this.edit();
        }
    }

    private void last() {
        this.row = tblNhanVien.getRowCount() - 1;
        showsgreenline(row);
        this.edit();
    }





//    String pantent3="^[a-zA-Z,0,-]";
//    public void checkDiem() {
//         try {
////            double diem = Double.parseDouble(TXTGIA.getText());
//            txtSDT.setBackground(Color.white);
//            if (txtSDT.getText().matches(pantent3)) {
//                txtSDT.setBackground(Color.red);
//                lblSoDienThoai.setText("Sai định dạng");
//           
//                return;
//            } else {
//                txtSDT.setBackground(Color.white);
//                lblSoDienThoai.setText("");
//            }
//        } catch (Exception e) {
//            txtSDT.setBackground(Color.red);
//
//            return;
//        }
    // }
}
