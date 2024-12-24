package TestQLTV;

import static org.junit.Assert.*;

import java.awt.Component;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dao.NhanVienDao;

import form.DoiMatKhau;
import form.Login;
import form.QLNhanVien1;
import main.Quanlithuvien;
import utils.Auth;

public class DoiMatKhauTest {

	static Quanlithuvien qltv;
	static DoiMatKhau dmk;
	static QLNhanVien1 qlnv;

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
		dmk = new DoiMatKhau();
		qlnv = new QLNhanVien1();
		qltv.setVisible(true);
		dmk.setVisible(true);

		qltv.getMain().removeAll();
		qltv.getMain().add(qlnv);
		qltv.getMain().repaint();
		qltv.getMain().revalidate();
	}

	@After
	public void tearDown() throws Exception {
	}

	public void fuctionAll(String MaNV, String PassWord1, String PassWord2, String PassWord3) {
		dmk.getTxttendangnhap().setText(MaNV);
		dmk.getTxtMKcu().setText(PassWord1);
		dmk.getTxtMKMoi().setText(PassWord2);
		dmk.getTxtNhapLaiMK().setText(PassWord3);
	}


	// Để trống mật khẩu cũ -->Pass
	@Test
	public void DMK1() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "", "", "");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Không được để trống mật khẩu", dmk.getMes());

	}

	// Để trống mật khẩu mới -->Pass	
	@Test
	public void DMK2() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "123", "", "");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Không được để trống mật khẩu mới", dmk.getMes());

	}

//	// Để trống xác nhận mật khẩu -->Pass
	@Test
	public void DMK3() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "123", "456", "");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Không được để trống xác nhận mật khẩu", dmk.getMes());

	}
	

	// Nhập sai mật khẩu cũ -->Pass
	@Test
	public void DMK4() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "111", "456", "456");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Sai mật khẩu!", dmk.getMes());

	}

	// Mật khẩu mới trùng với mật khẩu cũ -->Pass	
	@Test
	public void DMK5() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "123", "123", "456");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Mật khẩu trùng mật khẩu gốc!", dmk.getMes());

	}

	// Mật khẩu mới không trùng với nhập lại mật khẩu -->Pass	
	@Test
	public void DMK6() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "123", "345", "456");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Mật khẩu mới không trùng!", dmk.getMes());

	}

	// Đổi thành công -->Pass
	@Test
	public void DMK7() {
		// Thực hiện các thao tác cần thiết trước khi kiểm tra
				fuctionAll("BaoTT", "123", "345", "345");
				dmk.getBtnDoimatkhua().doClick();

				// Chờ 4 giây (sử dụng TimeUnit.SECONDS.sleep(4)) cho các thao tác kích hoạt sự
				// kiện được thực hiện
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// Xử lý ngoại lệ nếu cần
				}

				// Kiểm tra xem OptionPane đã được set thành YesMockOptionPane chưa
				Assert.assertEquals("Đổi mật khẩu thành công", dmk.getMes());

	}

	// Bấm vào nút hủy -->Pass
	@Test
	public void DMK_HUY() {
		dmk.getBtnHuy().doClick();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		Assert.assertEquals(qlnv.getClass(), qltv.getMain().getComponent(0).getClass());
	}

}
