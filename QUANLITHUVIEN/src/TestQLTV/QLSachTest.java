package TestQLTV;

import static org.junit.Assert.fail;

import java.awt.Component;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dao.NhanVienDao;
import Dao.QLThuVienDao;
import Dao.SachDao;
import Entity.Sach;
import form.QLSach;
import form.QLSinhVien1;
import main.Quanlithuvien;
import utils.Auth;

public class QLSachTest {
	static Quanlithuvien qltv;
	static QLSach qlsach;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Auth.user = new NhanVienDao().selectById("BaoTT");
		System.out.println(Auth.user.getMaNV());
	}

	@Before
	public void setUp() throws Exception {
		qltv = new Quanlithuvien();
		qlsach = new QLSach();
		qltv.setVisible(true);
		qlsach.setVisible(true);

		qltv.getMain().removeAll();
		qltv.getMain().add(qlsach);
		qltv.getMain().repaint();
		qltv.getMain().revalidate();

	}

	public void fuctionAll(String MaSach, String TenSach, String TheLoai, String TenTG, String TenNXB, String GhiChu) {
		qlsach.getTxtMaSach().setText(MaSach);
		qlsach.getTxtTenSach().setText(TenSach);
		qlsach.getChkDL().setSelected(true);
		qlsach.getCboTacGia().setSelectedItem("");
		;
		qlsach.getCboNXB().setSelectedItem("NXB01");
		;
		qlsach.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll2(String MaSach, String TenSach, String TheLoai, String TenTG, String TenNXB, String GhiChu) {
		qlsach.getTxtMaSach().setText(MaSach);
		qlsach.getTxtTenSach().setText(TenSach);
		qlsach.getChkDL().setSelected(true);
		qlsach.getCboTacGia().setSelectedItem("TG01");
		;
		qlsach.getCboNXB().setSelectedItem("");
		;
		qlsach.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll1(String MaSach, String TenSach, String TheLoai, String TenDG, String TenNXB, String GhiChu) {
		qlsach.getTxtMaSach().setText(MaSach);
		qlsach.getTxtTenSach().setText(TenSach);
		qlsach.getChkDL().setSelected(false);
		;
		qlsach.getCboTacGia().setSelectedItem("TG01");
		;
		qlsach.getCboNXB().setSelectedItem("NXB01");
		;
		qlsach.getTxtGhiChu().setText(GhiChu);

	}

	public void fuctionAll3(String MaSach, String TenSach, String TheLoai, String TenTG, String TenNXB, String GhiChu) {
		qlsach.getTxtMaSach().setText(MaSach);
		qlsach.getTxtTenSach().setText(TenSach);
		qlsach.getChkDL().setSelected(true);
		qlsach.getCboTacGia().setSelectedItem("TG01");
		;
		qlsach.getCboNXB().setSelectedItem("NXB01");
		;
		qlsach.getTxtGhiChu().setText(GhiChu);

	}

	// THÊM SÁCH
	// Bỏ trống tất cả trường hợp PASS
	@Test
	public void TS1() {
		qlsach.getTxtMaSach().setText("");
		qlsach.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsach.getLblMaSach().getText());
		Assert.assertEquals("Chưa nhập mã sách", qlsach.getLblMaSach().getText());
	}

//	
//	
//	//Bỏ trống tên sách PASS
	@Test
	public void TS2() {
		fuctionAll("NUMBERX", "", "VH01", "TG01", "NXB01", "note");

		qlsach.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsach.getLblTenSach().getText());
		Assert.assertEquals("Chưa nhập tên sách", qlsach.getLblTenSach().getText());

	}

//	
//	
//	//Mã sách đã tồn tại PASS
	@Test
	public void TS3() {
		fuctionAll("DMPLK", "Dế mèn phiêu lưu kí", "VH01", "TG01", "NXB01", "note");

		qlsach.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		Assert.assertEquals("Mã sách đã có trong dữ liệu", qlsach.getLblMaSach().getText());

	}

//	
//	
//	//Thêm thành công PASS
	@Test
	public void TS4() {
		fuctionAll3("TTC", "Sách Thêm Thành Công", "VH01", "TG01", "NXB01", "note");

		qlsach.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsach.getLblMaSach().getText());
		Assert.assertEquals("TTC", new SachDao().selectById("TTC").getMaSACH());

	}

//	
//	
//	//Bỏ trống mã sách PASS
	@Test
	public void TS5() {
		fuctionAll("", "Dế mèn phiêu lưu kí", "VH01", "TG01", "NXB01", "note");
		qlsach.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsach.getLblMaSach().getText());
		Assert.assertEquals("Chưa nhập mã sách", qlsach.getLblMaSach().getText());

	}

	// Sai định dạng tên sách PASS
	@Test
	public void TS7() {
		fuctionAll("OPPO", "@#", "VH01", "TG01", "NXB01", "note");
		qlsach.getMyButton1().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println(qlsach.getLblTenSach().getText());
		Assert.assertEquals("Sai định dạng", qlsach.getLblTenSach().getText());

	}

//		Chưa chọn Tác Giả >> Pass				
	@Test
	public void TS8() {

		// Thực hiện các thao tác cần thiết trước khi kiểm tra
		fuctionAll("OP1", "OnePiece", "VH01", "", "NXB01", "note");
		qlsach.getMyButton1().doClick();

		// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
		// kiện được thực hiện
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// Xử lý ngoại lệ nếu cần
		}

		// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
		Assert.assertEquals("Chưa chọn mã tác giả", qlsach.getMs());
	}

	// Chưa chọn NXB >> Pass
	@Test
	public void TS9() {

		// Thực hiện các thao tác cần thiết trước khi kiểm tra
		fuctionAll2("OP1", "OnePiece", "VH01", "TG01", "", "note");
		qlsach.getMyButton1().doClick();

		// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
		// kiện được thực hiện
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// Xử lý ngoại lệ nếu cần
		}

		// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
		Assert.assertEquals("Chưa chọn mã nhà xuất bản", qlsach.getMs());
	}

	// Chưa chọn thể loại ->> Pass
	@Test
	public void TS10() {

		// Thực hiện các thao tác cần thiết trước khi kiểm tra
		fuctionAll1("OP1", "OnePiece", "", "TG01", "NXB01", "note");
		qlsach.getMyButton1().doClick();

		// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
		// kiện được thực hiện
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// Xử lý ngoại lệ nếu cần
		}

		// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
		Assert.assertEquals("Chưa chọn thể loại", qlsach.getMs());
	}
	
	
	//<---Sửa Sách--->>


	

	// Bỏ trống tất cả trường hợp PASS
	@Test
	public void SS1() {
//		qlsach.getTxtMaNV().setText("");
		qlsach.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsach.getLblMaSach().getText());
		Assert.assertEquals("Chưa nhập mã sách", qlsach.getLblMaSach().getText());

	}
//	
//	
//	//Bỏ trống mã sách PASS
		@Test
		public void SS2() {
			fuctionAll("","Dế mèn phiêu lưu kí","VH01","TG01","NXB01","note");
			qlsach.getMyButton3().doClick();
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				
			}
			System.out.println(qlsach.getLblMaSach().getText());
			Assert.assertEquals("Chưa nhập mã sách", qlsach.getLblMaSach().getText());

		}
//		
//		
//		//Bỏ trống tên sách PASS
		@Test
		public void SS3() {
			fuctionAll("DMPLK","","VH01","TG01","NXB01","note");
			qlsach.getCboTacGia().setSelectedItem("TG01");;
			qlsach.getMyButton3().doClick();
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				
			}
			System.out.println(qlsach.getLblTenSach().getText());
			Assert.assertEquals("Chưa nhập tên sách", qlsach.getLblTenSach().getText());

		}
//		
//		
//		//Sửa thành công PASS
		@Test
		public void SS4() {
			fuctionAll("DMPLK","Dế mèn phiêu lưu kí tập hai","VH01","TG01","NXB01","note");
			qlsach.getMyButton3().doClick();
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				
			}
			System.out.println(qlsach.getLblMaSach().getText());
			Assert.assertEquals("DMPLK", new SachDao().selectById("DMPLK").getMaSACH());

		}
//		
//		
//		//Mã sách không tồn tại PASS
		@Test
		public void SS5() {
			fuctionAll("DMPLKXXL","Dế mèn phiêu lưu kí","VH01","TG01","NXB01","note");
			qlsach.getMyButton3().doClick();
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				
			}
			System.out.println(qlsach.getLblMaSach().getText());
			Assert.assertEquals("Mã sách phải có trong dữ liệu",qlsach.getLblMaSach().getText());

		}
//Sai định dạng tên sách PASS
	@Test	
	public void SS6() {
		fuctionAll("DMPLK2","@#","VH01","TG01","NXB01","note");
		qlsach.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			
		}
		System.out.println(qlsach.getLblTenSach().getText());
		Assert.assertEquals("Sai định dạng",qlsach.getLblTenSach().getText());

	}
	
//Chưa chọn mã TG >>FAIL	
	@Test
	public void SS8() {

		// Thực hiện các thao tác cần thiết trước khi kiểm tra
		fuctionAll("DMPLK", "Dế mèn phiêu lưu kí tập ba", "VH01", "", "NXB01", "note");
		qlsach.getMyButton3().doClick();

		// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
		// kiện được thực hiện
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// Xử lý ngoại lệ nếu cần
		}

		// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
		Assert.assertEquals("Chưa chọn mã tác giả", qlsach.getMs());
	}

//		//Chưa chọn NXB >> Fail
	@Test
	public void SS9() {

		// Thực hiện các thao tác cần thiết trước khi kiểm tra
		fuctionAll2("DMPLK", "Dế mèn phiêu lưu kí tập ba", "VH01", "TG01", "", "note");
		qlsach.getMyButton3().doClick();

		// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
		// kiện được thực hiện
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// Xử lý ngoại lệ nếu cần
		}

		// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
		Assert.assertEquals("Chưa chọn mã nhà xuất bản", qlsach.getMs());
	}
	
	//Chưa chọn thể loại >> PASS
	@Test
	public void SS10() {

		// Thực hiện các thao tác cần thiết trước khi kiểm tra
		fuctionAll1("DMPLK", "Dế mèn phiêu lưu kí tập ba", "", "TG01", "NXB01", "note");
		qlsach.getMyButton3().doClick();

		// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
		// kiện được thực hiện
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// Xử lý ngoại lệ nếu cần
		}

		// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
		Assert.assertEquals("Chưa chọn thể loại", qlsach.getMs());
	}
	
	
	//<-----XÓA SÁCH--->>//
//
//	// Xóa sách chưa hoạt động PASS
		@Test
		public void X1() {
			fuctionAll("DMPLK","Dế mèn phiêu lưu kí tập hai","VH01","TG01","NXB01","note");
			qlsach.getMyButton2().doClick();
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				
			}
			Sach sach = new SachDao().selectById("DMPLK");
			Assert.assertNull(sach);
	
		}
////		Xóa sách đã hoạt động FAIL
		@Test
		public void X2() {
			fuctionAll("KGD","Không Gia Đình","GT01,VH01","TG01","NXB02","");
			qlsach.getMyButton2().doClick();
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				
			}
			Sach sach = new SachDao().selectById("KGD");
			Assert.assertNotNull(sach);
	
		}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

}
