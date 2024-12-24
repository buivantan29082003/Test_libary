package TestQLTV;
import javax.swing.JOptionPane;

import static org.junit.Assert.*;

//import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import Dao.NhanVienDao;
import Entity.NhanVien;
import form.QLNhanVien;
import main.Quanlithuvien;
import utils.Auth;



public class TestNhanVien {
	Quanlithuvien qltv;
	QLNhanVien qlnv;
	String dl;
	int timer=2;
	
	
	public void setTextFile(String manv,String tennv,String matkhau,String sdt,Date ngaysinh,String email,String ghichu) {
		qlnv.getTxtMaNV().setText(manv);
		qlnv.getTxtTenNV().setText(tennv);
		qlnv.getTxtMatKhau().setText(matkhau);
		qlnv.getTxtSDT().setText(sdt);
		qlnv.getTxtNgaySinh().setDate(ngaysinh);
		qlnv.getTxtMail().setText(email);
		qlnv.getTxtGhiChu().setText(ghichu);
	}	

	public void setTextFileNgaySinh(String manv,String tennv,String matkhau,String sdt,String email,String ghichu) {
		qlnv.getTxtMaNV().setText(manv);
		qlnv.getTxtTenNV().setText(tennv);
		qlnv.getTxtMatKhau().setText(matkhau);
		qlnv.getTxtSDT().setText(sdt);
		qlnv.getTxtMail().setText(email);
		qlnv.getTxtGhiChu().setText(ghichu);
	}
	
	@Before
	public void setUp() throws Exception {
		Auth.user=new NhanVienDao().selectById("baoTT");
		qltv=new Quanlithuvien();
		qlnv=new QLNhanVien();
	
		qlnv.setVisible(true);
	    qltv.setVisible(true);
	    JPanel main=qltv.getMain();
	    main.removeAll();
	    main.add(qlnv);
	    main.repaint();
	    main.revalidate();
	}

	@After
	public void tearDown() throws Exception {
		qltv.dispose();
	}
	
	 //        ******* Thên nhân viên  *******
	
	 // -- thêm nhân viên thất bại với các trường bỏ trống -- PASS
	@Test
	public void testCase1() {
		setTextFile("","","", "", new Date(),"", "");
		qlnv.getMyButton1().doClick();
        dl=qlnv.getLblNhanhVien().getText();
        try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Chưa nhập mã nhân viên",dl);
        Assert.assertNull(new NhanVienDao().selectById(""));
	}
//	
//	 // -- thêm nhân viên thất bại với mật khẩu sai định dạng-- PASS
	@Test
	public void testCase2() {
		setTextFile("tanbvpc05190","Ngoc anh","222", "0769336227", new Date("2002/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getMyButton1().doClick();
       try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
       Assert.assertEquals("Sai định dạng",qlnv.getLblMatKhau().getText());
       Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//
//	// -- thêm nhân viên thất bại với tên nhân viên sai định dạng -- PASS
	@Test 
	public void testCase3() {
		setTextFile("tanbvpc05190","6466474646","1234@Spdf", "0769336227", new Date("2002/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getMyButton1().doClick();
        dl=qlnv.getLblTenNhanVien().getText();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Sai định dạng",dl);
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//
//	// -- thêm nhân viên thất bại với số diện thoại sai định dạng -- PASS
	@Test 
	public void testCase4() {
		setTextFile("tanbvpc05190","Nguyễn thành nam","1234@Spdf", "47rhfhr74h44u", new Date("2002/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getMyButton1().doClick();
        dl=qlnv.getLblSoDienThoai().getText();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Sai định dạng SDT",dl);
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//	
//	
	@Test // -- thêm nhân viên thất bại với ngày sinh ở tương lai -- FAIL
	public void testCase5() {
		setTextFile("tanbvpc05190","Nguyễn thành nam","1234@Spdf", "0769336226", new Date("2029/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getMyButton1().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Ngày sinh không hợp lệ",dl);
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//
//	// -- thêm nhân viên thất bại với tuổi không ddur 18 tuổi -- PASS
	@Test 
	public void testCase6() {
		setTextFile("tanbvpc05190","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2009/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getMyButton1().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Nhân viên phải đủ 18 tuổi!",dl);
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//
//	// -- thêm nhân viên thất bại khi chưa chọn vai trò --PASS
	@Test 
	public void testCase7() {
		setTextFile("tanbvpc05190","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getMyButton1().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Chưa chọn vai trò !",dl);
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//
//	// -- thêm nhân viên thất bại với giới tính trống --PASS
	@Test 
	public void testCase8() {
		setTextFile("tanbvpc05190","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getMyButton1().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals("Chưa chọn giới tính!",dl);
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc05190"));
	}
//
//	// -- thêm nhân viên thất bại với mã nhaan viên đã có trong cơ sở dữ liệu --PASS
	@Test
	public void testCase9() {
		setTextFile("baoTT","Thanh Dương hữu","1234@Spdf", "0769336228", new Date(),"tanbvpc05190@gmail.com", "Hello bạn");
		qlnv.getMyButton1().doClick();
        dl=qlnv.getLblNhanhVien().getText();
        int le=new NhanVienDao().selectAll().size();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (Exception e) {
			fail();
		}
        int le2=new NhanVienDao().selectAll().size();
        Assert.assertEquals("Mã nhân viên đã có trong dữ liệu",dl);
        Assert.assertTrue(le==le2);
	}
//	
//	// -- thêm nhân viên thất bại với mail đã được đăng kí --FAIL
	@Test  
	public void testCase10() {
		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf","0768223342", new Date("2003/02/02"),new NhanVienDao().selectById("BaoTT").getEMAIL(), "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		qlnv.getMyButton1().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        System.out.println(qlnv.getLblMail1().getText());
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc051903"));
        Assert.assertEquals("MAIL này đã có nhân viên sở hữu",qlnv.getLblMail1().getText());
        
	}
//	// -- thêm nhân viên thất bại với mail sai định dạng --PASS
	@Test 
	public void testCase11() {
		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf","0768223342", new Date("2003/02/02"),"hello world", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		qlnv.getMyButton1().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        System.out.println(qlnv.getLblSoDienThoai().getText());
        Assert.assertNull(new NhanVienDao().selectById("tanbvpc051903"));
        Assert.assertEquals("Sai định dạng mail",qlnv.getLblMail1().getText());
        
	}
//	
	// -- thêm nhân viên với thành công với các trường hợp lệ --PASS
	@Test 
	public void testCase12() {
		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		qlnv.getMyButton1().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertNotNull(new NhanVienDao().selectById("tanbvpc051903"));
        Assert.assertEquals("Thêm nhân viên mới thành công!",dl);
        
	}
	
	
//
//	// ******* update nhân viên  *******
//	
//	// -- update nhân viên thất bại với tên nhân viên trống --PASS
	@Test  
	public void testCase13() {
//		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),"",n.getMatKhau(),n.getSDT(),n.getNGAYSINH(),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getTenNV();
        Assert.assertNotEquals("",fullName);
        Assert.assertEquals("Chưa nhập tên nhân viên",qlnv.getLblTenNhanVien().getText());
        
	}
//	
	// -- update nhân viên thất bại với số điện thoại trống--PASS
	@Test  
	public void testCase14() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","",n.getNGAYSINH(),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getSDT();
        Assert.assertNotEquals("",fullName);
		Assert.assertEquals("Chưa nhập SDT",qlnv.getLblSoDienThoai().getText());
		
	}
//	
//	// -- update nhân viên thất bại với ngày sinh trống--ERROL
	@Test
	public void testCase15() {
//		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
        try {
    		setTextFileNgaySinh(n.getMaNV(),n.getTenNV(),"1234@Spdf",n.getSDT(),n.getEMAIL(),n.getGHICHU());
    		qlnv.getMyButton3().doClick();
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			fail();
		}
        Date fullName=new NhanVienDao().selectById("baoTT").getNGAYSINH();
        Assert.assertNotEquals("",fullName.toString());
        Assert.assertEquals("Chưa nhập tên nhân viên",qlnv.getLblTenNhanVien().getText());
	}
//	
//	// -- update nhân viên thất bại với email trống --PASS
	@Test 
	public void testCase16() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf",n.getSDT(),n.getNGAYSINH(),"",n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getEMAIL();
        Assert.assertNotEquals("",fullName);
		Assert.assertEquals("Chưa nhập mail",qlnv.getLblMail1().getText());
	}
//	
//	// -- update nhân viên thất bại với tên nhân viên sai định dạng--PASS
	@Test 
	public void testCase17() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),"454545454t545454545","1234@Spdf",n.getSDT(),n.getNGAYSINH(),"",n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getTenNV();
        Assert.assertNotEquals("454545454t545454545",fullName);
		Assert.assertEquals("Sai định dạng",qlnv.getLblTenNhanVien().getText());
	}
//
//	// -- update nhân viên thất bại với số điện thoại sai định dạng--PASS
	@Test 
	public void testCase18() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","07874747",n.getNGAYSINH(),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getSDT();
        Assert.assertNotEquals("07874747",fullName);
		Assert.assertEquals("Sai định dạng SDT",qlnv.getLblSoDienThoai().getText());
	}
//
//	// -- update nhân viên thất bại với số điện thoại không bắt đâu bằng số 0--PASS
	@Test 
	public void testCase19() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","9474847474",n.getNGAYSINH(),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getSDT();
        Assert.assertNotEquals("9474847474",fullName);
		Assert.assertEquals("Sai định dạng SDT",qlnv.getLblSoDienThoai().getText());
	}
//	
//	//-- update nhân viên thất bại với ngày sinh ở tương lai--PASS
	@Test 
	public void testCase20() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","0769554637",new Date("2028/02/02"),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Date fullName=new NhanVienDao().selectById("BaoTT").getNGAYSINH();
//        int p=fullName.compareTo(new Date());
        boolean d=(Euq(fullName, new Date("2028/02/02")));
        Assert.assertFalse(d);
	}
//	
//	
	public boolean testNgay(Date date) {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -18);
        Date eighteenYearsAgo = calendar.getTime();
        boolean isOver18YearsApart = date.before(eighteenYearsAgo);
        return isOver18YearsApart;
	}
	
	public boolean Euq(Date date,Date dt) {
        Date currentDate = dt;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -18);
        Date eighteenYearsAgo = calendar.getTime();
        boolean isOver18YearsApart = date.equals(eighteenYearsAgo);
        return isOver18YearsApart;
	}
//	
//	// -- update nhân viên thất bại không đủ 18 tuổi --PASS
	@Test 
	public void testCase21() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","0769554637",new Date("2009/02/02"),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		dl=qlnv.announce;
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
//        
        Assert.assertFalse(Euq(new NhanVienDao().selectById("BaoTT").getNGAYSINH(),new Date("2009/02/02")));
        System.out.println(dl);
      Assert.assertEquals("Nhân viên phải đủ 18 tuổi!",dl);
	}
//	
//	
//	// -- update nhân viên thất bại với mail Không hợp lệ--PASS
	@Test 
	public void testCase22() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoTT().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("tanbvpc051903");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","0769554637",new Date("1999/02/02"),"hello woerdl",n.getGHICHU());
		qlnv.getMyButton3().doClick();
		dl=qlnv.announce;
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("tanbvpc051903").getEMAIL();
        Assert.assertNotEquals("hello woerdl",fullName);
      Assert.assertEquals("Sai định dạng mail",qlnv.getLblMail1().getText());
	}
////	
////	
////	
////	
////	// -- update nhân viên thất bại với số điện thoại trống--PASS
	@Test 
	public void testCase23() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoTT().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("tanbvpc051903");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","",new Date("1999/02/02"),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("tanbvpc051903").getSDT();
        Assert.assertNotEquals("",fullName);
      Assert.assertEquals("Chưa nhập SDT",qlnv.getLblSoDienThoai().getText());
	}
//
//	// -- update nhân viên thất bại với email đã được đăng ký--FAIL
	@Test 
	public void testCase24() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoTT().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("tanbvpc051903");
		String a=new NhanVienDao().selectById("BaoTT").getEMAIL();
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","0769663425",new Date("1999/02/02"),a,n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("tanbvpc051903").getEMAIL();
        Assert.assertNotEquals(a,fullName);
        Assert.assertEquals("Mail này đã có nhân viên sở hữu",qlnv.getLblMail1().getText());
	}
//	
//	
//	// -- update nhân viên thất bại với sdt đã được đăng ký--FAIL
	@Test 
	public void testCase25() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoTT().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("tanbvpc051903");
		String a=new NhanVienDao().selectById("BaoTT").getSDT();
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf",a,new Date("1999/02/02"),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("tanbvpc051903").getSDT();
        Assert.assertNotEquals(a,fullName);
      Assert.assertEquals("SDT đã có nhân viên sở hữu",qlnv.getLblSoDienThoai().getText());
	}
//	
//	
//	// -- update nhân viên thành công với mật khaaur sai định dạng--PASS
	@Test 
	public void testCase26() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoTT().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),"Nguyễn thị Hồng Hạnh","2222","0769554637",new Date("1999/02/02"),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getMatKhau();
        Assert.assertNotEquals("2222",fullName);
      Assert.assertEquals("Sai định dạng",qlnv.getLblMatKhau().getText());
	}
	
//	// -- update nhân viên thành công với các thông tin hợp lệ--PASS
	@Test 
	public void testCase27() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoTT().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("BaoTT");
		setTextFile(n.getMaNV(),"Nguyễn thị Hồng Hạnh","1234@Spdf","0769554637",new Date("1999/02/02"),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton3().doClick();
		dl=qlnv.announce;
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        String fullName=new NhanVienDao().selectById("BaoTT").getTenNV();
        Assert.assertEquals("Nguyễn thị Hồng Hạnh",fullName);
      Assert.assertEquals("Cập nhật nhân viên thành công!",dl);
	}
//	

//	// xóa nhân viên nhưng không xác nhận xóa nhân viên PASS
	@Test
	public void testCase28() {
		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		int leng=new NhanVienDao().selectAll().size();
		qlnv.getMyButton2().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertNotNull(new NhanVienDao().selectById("tanbvpc051903"));
	}
	
	
//	Xóa nhân viên thành công khi xác nhận xóa PASS
	@Test
	public void testCase29() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("tanbvpc051903");
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","0769554637",n.getNGAYSINH(),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton2().doClick();
		dl=qlnv.announce;
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
      Assert.assertEquals("Xóa nhân viên thành công!",dl);
	}
//	
//	
//	
	// xóa nhân viên với mã nhân viên với nhân viên đang có rrangf buộc  ???????
	@Test
	public void testCase31() {
	//setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		NhanVien n=new NhanVienDao().selectById("HieuHT");// ?? đổi mã này nha ô,đừng có đổi thanh BaoTT
		setTextFile(n.getMaNV(),n.getTenNV(),"1234@Spdf","0769554637",n.getNGAYSINH(),n.getEMAIL(),n.getGHICHU());
		qlnv.getMyButton2().doClick();
		dl=qlnv.announce;
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
		Assert.assertNotNull(new NhanVienDao().selectById("HieuHT"));
      Assert.assertNotEquals("Không thể xóa nhân viên này!",dl);
	}
//	
//	
//		// xóa nhân viên với mã nhân viên không tồn tại:  FAIL
	@Test
	public void testCase32() {
		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		int leng=new NhanVienDao().selectAll().size();
		qlnv.getMyButton2().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals(leng-1, new NhanVienDao().selectAll().size());
        Assert.assertEquals("Mã nhân viên này không tồn tại!",dl);
	}

	
//	//test Nút clearform:
	@Test
	public void testCase33() {
		setTextFile("tanbvpc051903","Nguyễn thành nam","1234@Spdf", "0768223342", new Date("2003/02/02"),"tanbvpc@gmail.com", "Hello bạn");
		qlnv.getRdoNV().setSelected(true);
		qlnv.getRdoNam().setSelected(true);
		qlnv.getMyButton4().doClick();
        dl=qlnv.announce;
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        Assert.assertEquals(-1,qlnv.getRow());
        Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        Assert.assertEquals("",qlnv.getTxtTenNV().getText());
        Assert.assertEquals("",qlnv.getTxtMatKhau().getText());
        Assert.assertEquals("",qlnv.getTxtSDT().getText());
        Assert.assertEquals("",qlnv.getTxtMail().getText());
        Assert.assertEquals("",qlnv.getTxtGhiChu().getText());
        
	}
//	
	
	
	// ****** test các nut duy chuyển ******
	
	// fisrt ,nút c=di chuyển đầu tiên: PASS
	@Test
	public void testCase34() {
		qlnv.getMyButton7().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>0) {
            Assert.assertEquals(list.get(0).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }

	}
	
	
	// nút last PASS
	@Test
	public void testCase35() {
		qlnv.getMyButton5().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>0) {
            Assert.assertEquals(list.get(list.size()-1).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }
	}
//	
//	// kiểm tra trường hợp nhấn nút next từ phần tử đầu tiên: PASS
	@Test
	public void testCase36() {
		qlnv.getMyButton7().doClick();
		qlnv.getMyButton6().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
		if(list.size()>0) {
            Assert.assertEquals(list.get(list.size()>1?1:0).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }
	}
	
	
	// kiểm tra trường hợp nhấn nút next khi chưa có gì FAIL
	@Test
	public void testCase37() {
		qlnv.getMyButton6().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
		if(list.size()>0) {
            Assert.assertEquals(list.get(0).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }
	}
	
//	
	// kiểm tra trường hợp next với vị trí cuối cùng PASS
	@Test
	public void testCase38() {
		qlnv.getMyButton5().doClick();
		qlnv.getMyButton6().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>0) {
            Assert.assertEquals(list.get(list.size()-1).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }
	}
	
//	 test với trường hợp pre với vị trí cuối cùng PASS
	@Test
	public void testCase39() {
		qlnv.getMyButton5().doClick();
		qlnv.getMyButton8().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>2) {
            Assert.assertEquals(list.get(list.size()-2).getMaNV(),qlnv.getTxtMaNV().getText());
        }else if(list.size()>0) {
        	Assert.assertEquals(list.get(0).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }
	}
//	
//	// test với trường hợp pre với vị trí đầu tiên PASS
	@Test
	public void testCase40() {
		qlnv.getMyButton7().doClick();
		qlnv.getMyButton8().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>0) {
            Assert.assertEquals(list.get(0).getMaNV(),qlnv.getTxtMaNV().getText());
        }else {
        	Assert.assertEquals("",qlnv.getTxtMaNV().getText());
        }
	}
	
	
//	// test trường hợp cập nhật nhân viên thành công với các trường hợp lệ khi bấm nút first PASS
	@Test
	public void testCase41() {
		qlnv.getMyButton7().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>0) {
            String a=list.get(0).getTenNV()+" Nhàn";
            String manv=list.get(0).getMaNV();
            qlnv.getTxtTenNV().setText(a);
            qlnv.getMyButton3().doClick();
        Assert.assertEquals("Cập nhật nhân viên thành công!", qlnv.announce);
        Assert.assertEquals(a,new NhanVienDao().selectById(manv).getTenNV());
        }
	}
	
//	// test trường hợp cập nhật nhân viên thành công với các trường hợp lệ khi bấm nút last : PASS
	@Test
	public void testCase42() {
		qlnv.getMyButton5().doClick();
        try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			fail();
		}
        List<NhanVien> list=new NhanVienDao().selectAll();
        if(list.size()>0) {
            String a=list.get(list.size()-1).getTenNV()+" Nhàn";
            String manv=list.get(list.size()-1).getMaNV();
            qlnv.getTxtTenNV().setText(a);
            qlnv.getMyButton3().doClick();
        Assert.assertEquals("Cập nhật nhân viên thành công!", qlnv.announce);
        Assert.assertEquals(a,new NhanVienDao().selectById(manv).getTenNV());
        }
	}
}
