package TestQLTV;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dao.DocGiaDao;
import Dao.NhanVienDao;
import Dao.QLThuVienDao;
import Entity.DocGia;
import form.QLSinhVien;
import form.QLSinhVien1;
import main.Quanlithuvien;
import utils.Auth;

public class QLSinhVienTest {

	static Quanlithuvien qltv;
	static QLSinhVien qlsv;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Auth.user = new NhanVienDao().selectById("BaoTT");
		System.out.println(Auth.user.getMaNV());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		qltv = new Quanlithuvien();
		qlsv = new QLSinhVien();
		qltv.setVisible(true);
		qlsv.setVisible(true);

		qltv.getMain().removeAll();
		qltv.getMain().add(qlsv);
		qltv.getMain().repaint();
		qltv.getMain().revalidate();

	}

	@After
	public void tearDown() throws Exception {
		qltv.setVisible(false);
		qlsv.setVisible(false);
	}

	public void fuctionAll(String MaNV, String MaDG, String TenDG, Date DCNgsinh, String SDT, String GhiChu)
			throws InterruptedException {
		Thread.sleep(1200);
		qlsv.getTxtMaNV().setText(MaNV);
		Thread.sleep(1200);
		qlsv.getTxtMaDG().setText(MaDG);
		Thread.sleep(1200);
		qlsv.getTxtTenDG().setText(TenDG);
		Thread.sleep(1200);
		qlsv.getDCNgsinh().setDate(DCNgsinh);
		Thread.sleep(1200);
		qlsv.getRdoNam().setSelected(true);
		Thread.sleep(1200);
//		qlsv.getRdoNu().setSelected(true);
		qlsv.getTxtSDT().setText(SDT);
		Thread.sleep(1200);
		qlsv.getCboLop();
		Thread.sleep(1200);
		qlsv.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll2(String MaNV, String MaDG, String TenDG, String SDT, String GhiChu) {
		qlsv.getTxtMaNV().setText(MaNV);
		qlsv.getTxtMaDG().setText(MaDG);
		qlsv.getTxtTenDG().setText(TenDG);

		qlsv.getRdoNam().setSelected(true);
//		qlsv.getRdoNu().setSelected(true);
		qlsv.getTxtSDT().setText(SDT);
		qlsv.getCboLop();
		qlsv.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll3(String MaNV, String MaDG, String TenDG, Date DCNgsinh, String SDT, String GhiChu) {
		qlsv.getTxtMaNV().setText(MaNV);
		qlsv.getTxtMaDG().setText(MaDG);
		qlsv.getTxtTenDG().setText(TenDG);
		qlsv.getDCNgsinh().setDate(DCNgsinh);
		qlsv.getRdoNam().setSelected(true);
		qlsv.getRdoNu().setSelected(true);
		qlsv.getTxtSDT().setText(SDT);
		qlsv.getCboLop();
		qlsv.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll4(String MaNV, String MaDG, String TenDG, Date DCNgsinh, String SDT, String GhiChu,
			String lop) {
		qlsv.getTxtMaNV().setText(MaNV);
		qlsv.getTxtMaDG().setText(MaDG);
		qlsv.getTxtTenDG().setText(TenDG);
		qlsv.getDCNgsinh().setDate(DCNgsinh);
//		qlsv.getRdoNam().setSelected(true);
//		qlsv.getRdoNu().setSelected(true);
		qlsv.getTxtSDT().setText(SDT);
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll5(String MaNV, String MaDG, String TenDG, Date DCNgsinh, String SDT, String GhiChu) {
		qlsv.getTxtMaNV().setText(MaNV);
		qlsv.getTxtMaDG().setText(MaDG);
		qlsv.getTxtTenDG().setText(TenDG);
		qlsv.getDCNgsinh().setDate(DCNgsinh);
		qlsv.getRdoNam().setSelected(true);
//		qlsv.getRdoNu().setSelected(true);
		qlsv.getTxtSDT().setText(SDT);
		qlsv.getCboLop();
		qlsv.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll6(String MaNV, String MaDG, String TenDG, Date DCNgsinh, String SDT, String GhiChu,
			String lop) {
		qlsv.getTxtMaNV().setText(MaNV);
		qlsv.getTxtMaDG().setText(MaDG);
		qlsv.getTxtTenDG().setText(TenDG);
		qlsv.getDCNgsinh().setDate(DCNgsinh);
		qlsv.getRdoNam().setSelected(true);
//		qlsv.getRdoNu().setSelected(true);
		qlsv.getTxtSDT().setText(SDT);
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getTxtGhiChu().setText(GhiChu);

	}

//	-------------Thêm sinh viên------------------

	// Để trống tất cả các trường PASS
	@Test
	public void T1() {

		qlsv.getTxtMaNV().setText("");

		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Chưa nhập mã độc giả", qlsv.getLblMa().getText());

	}

	// Tên sv sai định dạng PASS
	@Test
	public void T2() throws InterruptedException {
		fuctionAll("baoTT", "hieu11", "###", new Date("2004/02/19"), "0769337262", "hh");
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Sai định dạng", qlsv.getLblTenSinhVien().getText());
	}

	// Chưa nhập mã độc giả PASS
	@Test
	public void T3() throws InterruptedException {
		fuctionAll("baoTT", "", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337262", "hh");

		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Chưa nhập mã độc giả", qlsv.getLblMa().getText());

	}

	// Chưa nhập tên sv PASS
	@Test
	public void T4() throws InterruptedException {
		fuctionAll("baoTT", "hieu11", "", new Date("2004/02/19"), "0769337262", "hh");

		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblTenSinhVien().getText());
		Assert.assertEquals("Chưa nhập tên sinh viên", qlsv.getLblTenSinhVien().getText());

	}

	// Chưa chọn ngày sinh PASS
	@Test
	public void T5() {
		fuctionAll2("baoTT", "hieu11", "Nguyễn Chí Hiếu", "0769337262", "hh");

		qlsv.getDCNgsinh();
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblngaysinh().getText());
		Assert.assertEquals("Chưa chọn ngày sinh", qlsv.getLblngaysinh().getText());

	}

	// Chưa nhập SDT PASS
	@Test
	public void T6() throws InterruptedException {
		fuctionAll("baoTT", "hieu11", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "", "hh");

		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Chưa nhập SDT", qlsv.getLblsodienthoai().getText());

	}

	// Chưa chọn lớp PASS
	@Test
	public void T7() {
		fuctionAll5("baoTT", "hieu04", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337209", "hh");

		qlsv.getLblLop();
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblLop().getText());
		Assert.assertEquals("Chưa chọn lớp", qlsv.getLblLop().getText());

	}

	// Chưa chọn giới tính PASS

	@Test
	public void T8() {
		fuctionAll4("baoTT", "hieuh2", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337888", "hh", "");
		String lop = "12C1";
		qlsv.getCboLop().setSelectedItem(lop);
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.tb);
		Assert.assertEquals("Chưa chọn giới tính!", qlsv.tb);
		System.out.println(qlsv.getRdoNu().getText());
		Assert.assertEquals("Nữ", qlsv.getRdoNu().getText());
	}

	// Mã độc giả đã tồn tại PASS
	@Test
	public void T9() throws InterruptedException {
		fuctionAll("hieu11", "BAO01", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337262", "hh");

		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Mã độc giả đã tồn tại", qlsv.getLblMa().getText());

	}

//	 Thêm thành công PASS
	@Test
	public void T10() {
		fuctionAll6("BaoTT", "hieu05", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337253", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setSelectedItem(lop);
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.tb);
		Assert.assertEquals("Thêm đọc giả mới thành công!", qlsv.tb);
		Assert.assertEquals("hieu05", new DocGiaDao().selectById("hieu05").getMaDG());
		// thêm thành công
	}

	// Sinh viên phải đủ 18 tuổi Fail
	@Test
	public void T11() {
		fuctionAll4("BaoTT", "hieu08", "Nguyễn Chí Hiếu", new Date("2024/05/19"), "0769331333", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getCboLop().setSelectedItem(lop);
		qlsv.getMyButton1().doClick();
//		DocGiaDao d = new DocGiaDao();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblngaysinh().getText());
		Assert.assertNull(new DocGiaDao().selectById("hieu08"));
	}

	// Không được chọn ngày sinh ở tương lai Fail
	@Test
	public void T12() {
		fuctionAll4("BaoTT", "hieu08", "Nguyễn Chí Hiếu", new Date("2024/05/19"), "0769331333", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getCboLop().setSelectedItem(lop);
		qlsv.getMyButton1().doClick();
//		DocGiaDao d = new DocGiaDao();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblngaysinh().getText());
		Assert.assertNull(new DocGiaDao().selectById("hieu08"));
	}

	// SDT hơn 10 số PASS
	@Test
	public void T13() throws InterruptedException {
		fuctionAll("baoTT", "hieu11","Nguyễn Chí Hiếu", new Date("2004/02/19"), "07047441622", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// SDT dưới 10 số PASS
	@Test
	public void T14() throws InterruptedException {
		fuctionAll("baoTT", "hieu11","Nguyễn Chí Hiếu", new Date("2004/02/19"), "070474416", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

//	//SDT là chữ PASS 
	@Test
	public void T15() throws InterruptedException {
		fuctionAll("baoTT", "hieu11","Nguyễn Chí Hiếu", new Date("2004/02/19"), "số0909", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// SDT chứa khoảng trắng PASS
	@Test
	public void T16() throws InterruptedException {
		fuctionAll("baoTT", "hieu11","Nguyễn Chí Hiếu", new Date("2004/02/19"), "070 474 416", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// SDT có kí tự đặc biệt PASS
	@Test
	public void T17() throws InterruptedException {
		fuctionAll("baoTT", "hieu11","Nguyễn Chí Hiếu", new Date("2004/02/19"), "0704744@0", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// TênSV nhập số PASS
	@Test
	public void T18() throws InterruptedException {
		fuctionAll("baoTT", "hieu11","90909", new Date("2004/02/19"), "070474416", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblTenSinhVien().getText());
		Assert.assertEquals("Sai định dạng", qlsv.getLblTenSinhVien().getText());

	}

	// Mã nhân viên không tồn tại PASS
	@Test
	public void T19() throws InterruptedException {
		fuctionAll("baoAAA", "hieu11","Nguyễn Chí Hiếu", new Date("2004/02/19"), "070474416", "hh");
	
		qlsv.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblTenSinhVien().getText());
		Assert.assertEquals("Mã nhân viên không tồn tại", qlsv.getLblTenSinhVien().getText());

	}

//	-------------Sửa sinh viên------------------

	// Để trống tất cả các trường PASS
	@Test
	public void T20() {
		qlsv.getTxtMaNV().setText("");
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Chưa nhập mã độc giả", qlsv.getLblMa().getText());

	}

	// Ten Sai định dạng Fail
	@Test
	public void T21() throws InterruptedException {
		fuctionAll("baoTT", "hieu04","***", new Date("2004/02/19"), "0769337262", "hh");
			
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Sai định dạng", qlsv.getLblTenSinhVien().getText());

	}

	// Chưa nhập mã độc giả PASS
	@Test
	public void T22() throws InterruptedException {
		fuctionAll("baoTT", "","Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337262", "hh");
		
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Chưa nhập mã độc giả", qlsv.getLblMa().getText());

	}

	// Chưa nhập tên sinh viên PASS
	@Test
	public void T23() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","", new Date("2004/02/19"), "0769337262", "hh");
		
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblTenSinhVien().getText());
		Assert.assertEquals("Chưa nhập tên sinh viên", qlsv.getLblTenSinhVien().getText());

	}

	// Chưa chọn ngày sinh bug Fail
	@Test
	public void T24() {
		fuctionAll4("BaoTT", "hieu08", "Nguyễn Chí Hiếu", new Date("2024/05/19"), "0769331333", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getCboLop().setSelectedItem(lop);
		qlsv.getMyButton3().doClick();
//		DocGiaDao d = new DocGiaDao();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.getLblngaysinh().getText());
		Assert.assertNull(new DocGiaDao().selectById("hieu08"));
	}

	// Chưa nhập SDT PASS
	@Test
	public void T25() throws InterruptedException {
		fuctionAll("baoTT", "hieu03","Nguyễn Chí Hiếu", new Date("2004/02/19"), "", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Chưa nhập SDT", qlsv.getLblsodienthoai().getText());

	}

	// Chưa chọn lớp but van bao thanh cong Fail
	@Test
	public void T26() {
		fuctionAll5("baoTT", "hieu08","Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337272","hh");

		qlsv.getLblLop();
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblLop().getText());
		Assert.assertEquals("Cập nhật đọc giả thành công", qlsv.getLblLop().getText());

	}

	// Chưa chọn giới tính Fail
	@Test
	public void T27() {
		fuctionAll3("baoTT", "hieu07","Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337262", "hh");
	
//		qlsv.getCboLop();
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getRdoNam().getText());
		Assert.assertEquals("Nam", qlsv.getRdoNam().getText());

	}

	// Sinh viên phải đủ 18 tuổi Fail
	@Test
	public void T28() {
		fuctionAll4("BaoTT", "hieu01","Nguyễn Chí Hiếu", new Date("2024/02/19"), "0769337262", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Sinh viên phải đủ 18 tuổi", qlsv.getLblMa().getText());

	}

	// Không được chọn ngày sinh ở tương lai Fail
	@Test
	public void T29() {
		fuctionAll4("BaoTT", "hieu01","Nguyễn Chí Hiếu", new Date("2024/05/19"), "0769337262", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setLabeText(lop);
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblMa().getText());
		Assert.assertEquals("Không được chọn ngày sinh ở tương lai", qlsv.getLblMa().getText());

	}

	// Cập nhật thành công PASS
	@Test
	public void T30() {
		fuctionAll6("BaoTT", "hieu06","Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337299", "hh", "12C1");
		String lop = "12C1";
		qlsv.getCboLop().setSelectedItem(lop);
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.tb);
		Assert.assertEquals("Cập nhật đọc giả thành công!", qlsv.tb);
		Assert.assertEquals("hieu06", new DocGiaDao().selectById("hieu06").getMaDG());
		//Cập nhật thành công
	}

	// SDT hơn 10 số PASS
	@Test
	public void T31() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","Nguyễn Chí Hiếu", new Date("2004/02/19"), "07047441622", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// SDT dưới 10 số PASS
	@Test
	public void T32() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","Nguyễn Chí Hiếu", new Date("2004/02/19"), "070474416", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	//SDT là chữ  PASS
	@Test
	public void T33() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","Nguyễn Chí Hiếu", new Date("2004/02/19"), "số0909", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// SDT chứa khoảng trắng PASS
	@Test 
	public void T34() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","Nguyễn Chí Hiếu", new Date("2004/02/19"), "070 474 416", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// SDT có kí tự đặc biệt PASS
	@Test
	public void T35() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","Nguyễn Chí Hiếu", new Date("2004/02/19"), "0704744@0", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblsodienthoai().getText());
		Assert.assertEquals("Sai định dạng SDT", qlsv.getLblsodienthoai().getText());

	}

	// TênSV nhập số PASS
	@Test
	public void T36() throws InterruptedException {
		fuctionAll("baoTT", "hieu05","90909", new Date("2004/02/19"), "070474416", "hh");
	
		qlsv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsv.getLblTenSinhVien().getText());
		Assert.assertEquals("Sai định dạng", qlsv.getLblTenSinhVien().getText());

	}


//	-------------Xóa sinh viên------------------

//	Xóa sinh viên chưa có Phiếu mượn PASS
	@Test 
	public void T37() throws InterruptedException {
		fuctionAll("BaoTT", "hieu05", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337253", "hh");
		qlsv.getCboLop();

		qlsv.getMyButton2().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.tb);
		Assert.assertEquals("Xóa đọc giả thành công!", qlsv.tb);
		DocGia dg = new DocGiaDao().selectById("hieu05");
		Assert.assertNull(dg);

	}

//	Xóa sinh viên đã có phiếu mượn PASS
	@Test
	public void T38() throws InterruptedException {
		fuctionAll("BaoTT", "DUYVN02", "Nguyễn Chí Hiếu", new Date("2004/02/19"), "0769337253", "hh");
		qlsv.getCboLop();
		qlsv.getMyButton2().doClick();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsv.tb);
		Assert.assertEquals("Xóa đọc giả thành công!", qlsv.tb);
		DocGia dg = new DocGiaDao().selectById("DUYVN02");
		Assert.assertNotNull(dg);
	}
}