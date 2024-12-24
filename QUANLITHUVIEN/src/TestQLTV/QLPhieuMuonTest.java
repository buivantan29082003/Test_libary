package TestQLTV;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.awt.Component;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dao.NhanVienDao;
import Dao.PhieuMuonCTDao;
import Dao.PhieuMuonDao;
import Entity.PhieuMuonCT;
import form.Phieumuonn;
import main.Quanlithuvien;
import utils.Auth;

public class QLPhieuMuonTest {

	static Quanlithuvien qltv;
	static Phieumuonn qlpm;

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
		qlpm = new Phieumuonn();
		qltv.setVisible(true);
		qlpm.setVisible(true);

		qltv.getMain().removeAll();
		qltv.getMain().add(qlpm);
		qltv.getMain().repaint();
		qltv.getMain().revalidate();
	}

	@After
	public void tearDown() throws Exception {
	}

	public void fuctionAll(String MaPM, Date NGAYTAO, Date NGAYTRA, String MaNV, String MaDG) {
		qlpm.getTxtMaPM().setText(MaPM);
		qlpm.getDCNgTao().setDate(NGAYTAO);
		qlpm.getDCNgayTra().setDate(NGAYTRA);
		qlpm.getRdoDaTra().setSelected(true);
//		qlpm.getRdoChuaTra().setSelected(false);
		qlpm.getTxtMaNV().setText(MaNV);
		qlpm.getTxtMaDocGia().setText(MaDG);

	}

	public void fuctionAll2(String MaPM, Date NGAYTAO, Date NGAYTRA, String MaNV, String MaDG) {
		qlpm.getTxtMaPM().setText(MaPM);
		qlpm.getDCNgTao().setDate(NGAYTAO);
		qlpm.getDCNgayTra().setDate(NGAYTRA);
//		qlpm.getRdoDaTra().setSelected(true);
//		qlpm.getRdoChuaTra().setSelected(false);
		qlpm.getTxtMaNV().setText(MaNV);
		qlpm.getTxtMaDocGia().setText(MaDG);

	}

	public void fuctionAll3(String MaPM, Date NGAYTRA, String MaNV, String MaDG) {
		qlpm.getTxtMaPM().setText(MaPM);
//		qlpm.getDCNgTao().setDate(NGAYTAO);
		qlpm.getDCNgayTra().setDate(NGAYTRA);
		qlpm.getRdoDaTra().setSelected(true);
//		qlpm.getRdoChuaTra().setSelected(false);
		qlpm.getTxtMaNV().setText(MaNV);
		qlpm.getTxtMaDocGia().setText(MaDG);

	}

	public void fuctionAll4(String MaPM, Date NGAYTAO, Date NGAYTRA, Boolean DaTra, Boolean ChuaTra, String MaNV,
			String MaDG) {
		qlpm.getTxtMaPM().setText(MaPM);
		qlpm.getDCNgTao().setDate(NGAYTAO);
		qlpm.getDCNgayTra().setDate(NGAYTRA);
		qlpm.getRdoDaTra().setSelected(false);
		qlpm.getRdoChuaTra().setSelected(false);
		qlpm.getTxtMaNV().setText(MaNV);
		qlpm.getTxtMaDocGia().setText(MaDG);

	}
	public void fuctionAll5(String MaPM, Date NGAYTAO, String MaNV, String MaDG) {
		qlpm.getTxtMaPM().setText(MaPM);
		qlpm.getDCNgTao().setDate(NGAYTAO);
//		qlpm.getDCNgayTra().setDate(NGAYTRA);
		qlpm.getRdoDaTra().setSelected(true);
//		qlpm.getRdoChuaTra().setSelected(false);
		qlpm.getTxtMaNV().setText(MaNV);
		qlpm.getTxtMaDocGia().setText(MaDG);

	}

//	-------------Thêm phiếu mượn------------------

	public class Foo {
		OptionPane optionPane = new DefaultOptionPane();
		String message; // Trường để lưu thông điệp của OptionPane

		public void someMethod() {
			if (optionPane.showConfirmDialog(null, "choose yes or no", "Please confirm",
					JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
				return;

			// User pressed yes
		}

		public void setOptionPane(OptionPane o) {
			this.optionPane = o;
		}
	}

	// Snippet of the interface
	public interface OptionPane {

		int showConfirmDialog(Component parentComponent, Object message, String title, int optionType);
	}

	public class DefaultOptionPane implements OptionPane {
		@Override
		public int showConfirmDialog(Component parentComponent, Object message, String title, int optionType) {

			return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType);
		}
	}

	public class YesMockOptionPane extends DefaultOptionPane {
		private String lastMessageDisplayed;

		@Override
		public int showConfirmDialog(Component parentComponent, Object message, String title, int optionType) {
			this.lastMessageDisplayed = (String) message; // Lưu thông điệp được hiển thị
			return JOptionPane.YES_OPTION;
		}

		public String getLastMessageDisplayed() {
			return lastMessageDisplayed;
		}
	}

	
//
//	// Để trống tất cả các trường --> Pass
	@Test
	public void TS1_ThemPM() {
		fuctionAll2(null, null, null, null, null);
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblpm().getText());
		Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm().getText());

	}

//	// Mã phiếu mượn bỏ trống --> Pass
	@Test
	public void TS2_ThemPM() {
		fuctionAll("", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "DUYVN01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblpm().getText());
		Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm().getText());
	}

//	// Để trống trạng thái --> Pass
	@Test
	public void TS3_ThemPM() {
		fuctionAll2("PM99", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "BAOCC");
		qlpm.getMyButton17().doClick();

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		Assert.assertEquals("Chưa chọn trạng thái !", qlpm.getMes());
		
	}
//	// Để trống mã nhân viên --> Pass
	@Test
	public void TS4_ThemPM() {
		fuctionAll("PM25", new Date("2023/03/14"), new Date("2023/03/18"), null, "DUYVN01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmanhanvien().getText());
		Assert.assertEquals("Chưa nhập mã nhân viên", qlpm.getLblmanhanvien().getText());
	}

//	// Để trống mã đọc giả --> Pass
	@Test
	public void TS5_ThemPM() {
		fuctionAll("", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmadocgia().getText());
		Assert.assertEquals("Chưa nhập mã độc giả", qlpm.getLblmadocgia().getText());
	}

//	// Để trống ngày tạo --> Pass
	@Test
	public void TS6_ThemPM() {
		fuctionAll("PM25",null, new Date("2023/03/18"), "BaoTT", "DUYVN01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblngaytao().getText());
		Assert.assertEquals("Chưa chọn ngày tạo", qlpm.getLblngaytao().getText());
	}

//	// Để trống ngày trả --> Pass
	@Test
	public void TS7_ThemPM() {
		fuctionAll5("PM25", new Date("2023/03/14"), "BaoTT", "DUYVN01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblngaytra().getText());
		Assert.assertEquals("Chưa chọn ngày trả", qlpm.getLblngaytra().getText());
	}
//
//	// Mã phiếu mượn đã tồn tại --> Pass
	@Test
	public void TS8_ThemPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "DUYVN01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblpm().getText());
		Assert.assertEquals("Mã phiếu mượn đã tồn tại", qlpm.getLblpm().getText());
	}

//	// Mã đọc giả đã tồn tại trong phiếu mượn--> Pass
	@Test
	public void TS9_ThemPM() {
		fuctionAll("PM25", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "BAO01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmadocgia().getText());
		Assert.assertEquals("Mã đọc giả phải chưa có trong phiếu mượn", qlpm.getLblmadocgia().getText());
	}

//	// Mã đọc giả không tồn tại trong trong csdl--> Pass
	@Test
	public void TS10_ThemPM() {
		fuctionAll("PM27", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "123");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmadocgia().getText());
		Assert.assertEquals("Mã độc giả không tồn tại", qlpm.getLblmadocgia().getText());
	}
//
//	// Mã nhân viên không tồn tại trong trong csdl--> Pass
	@Test
	public void TS11_ThemPM() {
		fuctionAll("PM25", new Date("2023/03/14"), new Date("2023/03/18"), "Bao123", "BAO01");
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmanhanvien().getText());
		Assert.assertEquals("Mã nhân viên chưa có trong dữ liệu", qlpm.getLblmanhanvien().getText());
	}

//	// Thêm thành công --> Pass
	@Test
	public void TS12_ThemPM() {
		fuctionAll("PM25", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "DUYVN02");
		qlpm.getRdoDaTra().setSelected(true);
		qlpm.getMyButton17().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		Assert.assertEquals("PM25", new PhieuMuonDao().selectById("PM25").getMaPM());
	}

////	-------------Sửa phiếu mượn------------------
//

//
//	// Để trống tất cả các trường --> Pass
	@Test
	public void TS13_SuaPM() {
		fuctionAll2(null, null, null, null, null);
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblpm().getText());
		Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm().getText());

	}

//	// Mã phiếu mượn không tồn tại --> Pass
	@Test
	public void TS14_SuaPM() {
		fuctionAll("PM27", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "DUYVN02");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblpm().getText());
		Assert.assertEquals("Mã phiếu mượn không tồn tại", qlpm.getLblpm().getText());
	}
//
//	// Để trống mã nhân viên --> Pass
	@Test
	public void TS15_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "", "DUYVN01");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmanhanvien().getText());
		Assert.assertEquals("Chưa nhập mã nhân viên", qlpm.getLblmanhanvien().getText());
	}
//
//	// Để trống mã đọc giả --> Pass
	@Test
	public void TS16_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmadocgia().getText());
		Assert.assertEquals("Chưa nhập mã độc giả", qlpm.getLblmadocgia().getText());
	}

//	 Để trống ngày tạo --> Failures
	@Test
	public void TS17_SuaPM() {
		fuctionAll3("PM24" ,new Date("2023/03/18"), "BaoTT", "DUYVN02");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblngaytao().getText());
		Assert.assertEquals("Chưa chọn ngày tạo", qlpm.getLblngaytao().getText());
	}
//
//	// Để trống ngày trả --> pass
	@Test
	public void TS18_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), null, "BaoTT", "DUYVN02");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblngaytra().getText());
		Assert.assertEquals("Chưa chọn ngày trả", qlpm.getLblngaytra().getText());
	}
//
//	// Mã nhân viên không tồn tại trong trong csdl--> Pass
	@Test
	public void TS19_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "Bao123", "BAO01");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmanhanvien().getText());
		Assert.assertEquals("Mã nhân viên chưa có trong dữ liệu", qlpm.getLblmanhanvien().getText());
	}
//
//	// Mã đọc giả không tồn tại trong trong csdl--> Pass
	@Test
	public void TS20_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "123");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmadocgia().getText());
		Assert.assertEquals("Mã đọc giả phải có trong dữ liệu", qlpm.getLblmadocgia().getText());
	}

//	// Mã đọc giả đã tồn tại trong phiếu mượn--> Failures
	@Test
	public void TS21_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "BAO01");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblmadocgia().getText());
		Assert.assertEquals("Mã đọc giả đã tồn tại", qlpm.getLblmadocgia().getText());
	}
//
//	// Cập nhật thành công --> Pass
	@Test
	public void TS22_SuaPM() {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "DUYVN01");
		qlpm.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlpm.getLblpm().getText());
		Assert.assertEquals("PM24", new PhieuMuonDao().selectById("PM24").getMaPM());
	}

	
	// Để trống trạng thái -> Pass
		@Test
		public void TS23_SuaPM() {

			fuctionAll4("PM24", new Date("2023/03/14"), new Date("2023/03/18"), false, false, "BaoTT", "DUYVN01");
			qlpm.getMyButton3().doClick();

			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// Xử lý ngoại lệ nếu cần
			}
			Assert.assertEquals("Chưa chọn trạng thái!", qlpm.getMes());
		}
	
//	// Tìm kiếm
	@Test
	public void TS_Tim() throws InterruptedException {
		qlpm.getTxtTimKiem().setText("d");
		Thread.sleep(10);
		qlpm.getTxtTimKiem().setText("dd");
		Thread.sleep(1000);
		qlpm.getTxtTimKiem().setText("ddd");
		int tbl = qlpm.getTblPhieuMuon().getRowCount();
		System.out.println(tbl);
		if (tbl < 1) {
			Assert.assertEquals(1, tbl);

		}
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}

	}

//	// Nút đầu
	@Test
	public void TS_NutDau() throws InterruptedException {
		qlpm.getMyButton7().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		int row = qlpm.getTblPhieuMuon().getRowCount();
		Assert.assertEquals("PM01", qlpm.getTxtMaPM().getText());
		System.out.println(qlpm.getTxtMaPM().getText());

	}
//
//	// Nút cuối
	@Test
	public void TS_NutCuoi() throws InterruptedException {
		qlpm.getMyButton6().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("PM24", qlpm.getTxtMaPM().getText());
		System.out.println(qlpm.getTxtMaPM().getText());

	}
//
//	// Nút lùi
	@Test
	public void TS_NutLui() throws InterruptedException {
		qlpm.getMyButton8().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("", qlpm.getTxtMaPM().getText());
		System.out.println(qlpm.getTxtMaPM().getText());

	}

////	// Nút tiến
	@Test
	public void TS_NutTien() throws InterruptedException {
		qlpm.getMyButton5().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("PM02", qlpm.getTxtMaPM().getText());
		System.out.println(qlpm.getTxtMaPM().getText());

	}
//
//	// Nút clear
	@Test
	public void TS_NutClear() throws InterruptedException {
		fuctionAll("PM24", new Date("2023/03/14"), new Date("2023/03/18"), "BaoTT", "DUYVN01");
		Thread.sleep(500);
		qlpm.getMyButton4().doClick();

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("", qlpm.getTxtMaPM().getText());
		System.out.println(qlpm.getTxtMaPM().getText());

	}

	public void fuctionAllPMCT(String MaPM1, String MaSach, String GhiChu) {
		qlpm.getTxtMaPM1().setText(MaPM1);
		qlpm.getTxtMaSach().setText(MaSach);
		qlpm.getTxtGhiChu().setText(GhiChu);

	}

//	-----Thêm phiếu mượn chi tiết--------

	// Bỏ trống tất cả các trường --> Pass
//	@Test
//	public void TS1_ThemPMCT() {
//		fuctionAllPMCT("", "", "");
//		qlpm.getMyButton9().doClick();
//		try {
//			TimeUnit.SECONDS.sleep(4);
//		} catch (InterruptedException e) {
//
//		}
//		System.out.println(qlpm.getLblpm1().getText());
//		Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm1().getText());
//	}

	// Chưa nhập mã phiếu mượn --> Pass
//		@Test
//		public void TS2_ThemPMCT() {
//			fuctionAllPMCT("", "DNT", "Không");
//			qlpm.getMyButton9().doClick();
//			try {
//				TimeUnit.SECONDS.sleep(4);
//			} catch (InterruptedException e) {
//
//			}
//			System.out.println(qlpm.getLblpm1().getText());
//			Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm1().getText());
//		}

	// Chưa chọn số lượng sách --> Pass
//		@Test
//		public void TS3_ThemPMCT() {
//			fuctionAllPMCT("PM24", "", "Không");
//			qlpm.getMyButton9().doClick();
//			try {
//				TimeUnit.SECONDS.sleep(4);
//			} catch (InterruptedException e) {
//
//			}
//			System.out.println(qlpm.getLblSoLuong().getText());
//			Assert.assertEquals("Chưa nhập số lượng", qlpm.getLblSoLuong().getText());
//		}

	// Thêm thành công --> Pass
//		@Test
//		public void TS4_ThemPMCT() {
//			fuctionAllPMCT("PM24", "DNT", "không");
//			qlpm.getMyButton9().doClick();
//			try {
//				TimeUnit.SECONDS.sleep(4);
//			} catch (InterruptedException e) {
//	
//			}
//			System.out.println(qlpm.getLblpm1().getText());
//			Assert.assertEquals("PM24", new PhieuMuonCTDao().selectById("PM24").getMaPM());
//		}

//	-----Sửa pmct------

	// Bỏ trống tất cả các trường --> Pass
//	@Test
//	public void TS5_SuaPMCT() {
//		fuctionAllPMCT("", "", "");
//		qlpm.getMyButton10().doClick();
//		try {
//			TimeUnit.SECONDS.sleep(4);
//		} catch (InterruptedException e) {
//
//		}
//		System.out.println(qlpm.getLblpm1().getText());
//		Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm1().getText());
//	}

	// Chưa nhập mã phiếu mượn --> Pass
//		@Test
//		public void TS6_SuaPMCT() {
//			fuctionAllPMCT("", "THN", "Có");
//			qlpm.getMyButton10().doClick();
//			try {
//				TimeUnit.SECONDS.sleep(4);
//			} catch (InterruptedException e) {
//
//			}
//			System.out.println(qlpm.getLblpm1().getText());
//			Assert.assertEquals("Chưa nhập mã phiếu mượn", qlpm.getLblpm1().getText());
//		}

	// Chưa chọn số lượng sách --> Pass
//		@Test
//		public void TS7_SuaPMCT() {
//			fuctionAllPMCT("PM24", "", "Có");
//			qlpm.getMyButton10().doClick();
//			try {
//				TimeUnit.SECONDS.sleep(4);
//			} catch (InterruptedException e) {
//
//			}
//			System.out.println(qlpm.getLblSoLuong().getText());
//			Assert.assertEquals("Chưa nhập số lượng", qlpm.getLblSoLuong().getText());
//		}

	// Sửa thành công --> Pass
//		@Test
//		public void TS8_SuaPMCT() {
//			fuctionAllPMCT("PM24", "THN", "Có");
//			qlpm.getMyButton10().doClick();
//			try {
//				TimeUnit.SECONDS.sleep(4);
//			} catch (InterruptedException e) {
//	
//			}
//			System.out.println(qlpm.getLblpm1().getText());
//			Assert.assertEquals("PM24", new PhieuMuonCTDao().selectById("PM24").getMaPM());
//		}

//	----------------Xóa PMCT---------------
//	@Test
//	public void TS9_XoaPMCT() {
//		fuctionAllPMCT("PM24", "THN", "Có");
//		qlpm.getBtnXoaPMCT().doClick();
//		try {
//			TimeUnit.SECONDS.sleep(4);
//		} catch (InterruptedException e) {
//			
//		}
//		PhieuMuonCT pmct = new PhieuMuonCTDao().selectById("PM24");
//		Assert.assertNull(pmct);
//
//	}
}