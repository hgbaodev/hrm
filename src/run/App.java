package run;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BUS.DANHSACHBANGCHAMCONG;
import DAO.access_BANGCHAMCONG;
import DAO.access_BANGDANHGIA;
import DAO.access_CHUCVU;
import DAO.access_CHUCVUCONGTY;
import DAO.access_HOPDONGLAODONG;
import DAO.access_LUONG;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DAO.access_TAIKHOAN;
import DAO.access_THONGKE;
import DAO.access_TUYENDUNG;
import DTO.DATA;
import DTO.NHANVIEN;
import DTO.TAIKHOAN;
import GUI.AccountForm;
import GUI.BangDanhGiaForm1;
import GUI.ConTractForm1;
import GUI.ConTractForm3;
import GUI.DanhGiaView;
import GUI.EmployeeForm;
import GUI.SalaryForm1;
import GUI.SalaryForm2;
import GUI.SalaryForm3;
import GUI.SalaryForm4;
import GUI.TuyenDungView;
import GUI.UngVienView;
import GUI.departmentForm1;
import GUI.myContent;
import GUI.myHeader;
import GUI.myMenuBar2;
import control.*;


public class App extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DATA data;
	private JPanel contentPane;
	private myMenuBar2 menubar;
	private myHeader header;
	private myContent contentPage;
	private TAIKHOAN taiKhoanDangNhap;
	private boolean mangChucNang[];
	// tuyển dụng 
//	private TuyenDungView tdv;

	public void setTaiKhoanDangNhap(TAIKHOAN x) {
		this.taiKhoanDangNhap = x;
	}
	public void setMangChucNang(boolean mangChucNang[]) {
		this.mangChucNang = mangChucNang;
	}
	public App() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1320,760);
//		pack();
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.gray,2));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		// HEADER
		header = new myHeader();
		diChuyenChuongTrinh mf = new diChuyenChuongTrinh(this);
		header.addMouseMotionListener(mf);
		header.setPreferredSize(new Dimension(1100,46));
		contentPane.add(header,BorderLayout.NORTH);

		// TODO MENU BAR
		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(new BorderLayout());
		panelBottom.setPreferredSize(new Dimension(1100,760));
		contentPane.add(panelBottom, BorderLayout.CENTER);
		menubar = new myMenuBar2(Color.decode("#1CB5E0"), Color.decode("#000046"));
		menubar.setPreferredSize(new Dimension(220,760));
		panelBottom.add(menubar,BorderLayout.WEST);  
		
		
		// TODO CONTENT
		contentPage = new myContent();
		contentPage.setPreferredSize(new Dimension(1100,714));
		panelBottom.add(contentPage,BorderLayout.CENTER);	
		
		
		// add action hover for menu
		menubar.addActionHover(this);
		
		
		
		// init data TODO
		data = new DATA();
		
		
		// home form
		
		
		
		
		getDataFromDatabase();
		
		// biểu đồ cột trang chủ
		contentPage.getHomePage().getHomeForm1().setData(access_THONGKE.thongKeTrangChuForm3_soLuongNhanVien(), access_THONGKE.thongKeTrangChuForm3_mucLuongTB());
		// hiển thị biểu đồ tròn trang chủ
		contentPage.getHomePage().getHomeForm2().setData(access_PHONGBAN.getDanhSachTenVaSoLuongNhanVienPhongBan());
		contentPage.getHomePage().getHomeForm2().ani();
		contentPage.getHomePage().getHomeForm1().runChart();
		
		
		// bảng trang chủ
		contentPage.getHomePage().getHomeForm3().setTableData(data.getDanhSachPhongBan().getObjectToRender());
		
		
		
		
		
		
		
		// TODO sự kiện
		suKienTrangNhanVien();
		suKienTrangTaiKhoan();
		suKienTrangTuyenDung();
		suKienTrangDanhGia();
		suKienTrangLuong();
		suKienTrangHopDong();
		suKienTrangBangChamCong();
		suKienPhongBan();
		
	}
	public void getDataFromDatabase() {
		
		data.getDanhSachDiaChi().getDataFromDataBase();
		data.getDanhSachNhanVien().getDataFromDatabase();
		data.getDanhSachPhongBan().getDataFromDatabase();
		data.getDanhSachBangChamCong().getDataFromDatabase();
		data.getDanhSachBangDanhGia().getDataFromDatabase();
		data.getDanhsachbaocaotuyendung().getDataFromDatabase();
		data.getDanhSachHopDong().getDataFromDatabase();
		data.getDanhsachungvien().getDataFromDatabase();
		
		data.getDanhSachNhomQuyen().getDataFormDatabase();
	}
	public void setDuLieuCbbDiaChi() {
		// lấy dữ liệu địa chỉ render ra combobox
		String dataTinhThanhPho[] = data.getDanhSachDiaChi().getDanhSachTinhThanhPhoString();
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachPhongBan(data.getDanhSachPhongBan().getDanhSachTenPhongBan());
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachChucVu(access_CHUCVUCONGTY.getDanhSachTenChucVuCongTy());
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachTinhThanhPho(dataTinhThanhPho);
		 // lấy dữ liệu địa chỉ ứng viên
 		contentPage.getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbTinhThanhPho(dataTinhThanhPho);
 		contentPage.getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbQuanHuyen(data.getDanhSachDiaChi().getList().get(0).getDanhSachQuanHuyenString());
 		contentPage.getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbPhuongXa(data.getDanhSachDiaChi().getList().get(0).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXaString());
 		contentPage.getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbDuong(data.getDanhSachDiaChi().getList().get(0).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXa().get(0).getDanhSachDuongString());
 		contentPage.getRecruitmentForm().getUngVienView().getUvv_t().setDataCbbNoiCap(dataTinhThanhPho);
	}
	public void suKienPhongBan() {
		// sự kiện bảng phòng ban
		showNhanVienCuaPhongBan snvpb = new showNhanVienCuaPhongBan(this);
		contentPage.getDepartmentForm().getDepartmentForm2().getTable().addMouseListener(snvpb);
		// sự kiện bảng phòng ban thống kê
		departmentShowAction dsa = new departmentShowAction(this);
		contentPage.getDepartmentForm().getDepartmentForm1().getTable().addMouseListener(dsa);
		
		showThongTinNhanVienPhongBan sttpb = new showThongTinNhanVienPhongBan(this); 
		contentPage.getDepartmentForm().getDepartmentForm2().getTableEmployee().addMouseListener(sttpb);
		// xuất dữ liệu ban đầu trang phòng ban 2
		contentPage.getDepartmentForm().getDepartmentForm2().setEmployeeData(access_PHONGBAN.getNhanVienCuaPhongBanData(data.getDanhSachPhongBan().getList().get(0).getMaPhong()));
		// xuất dữ liệu thông tin nhân viên phòng ban
		contentPage.getDepartmentForm().getDepartmentForm2().setInfoEmployeeData(data.getDanhSachNhanVien().getList().get(0).getDataToRenderDepartmentDetailInfoEmployee());
		contentPage.getDepartmentForm().getDepartmentForm2().setImgEmployee(data.getDanhSachNhanVien().getList().get(0).getTaiKhoan().getAvatarImg());
		contentPage.getDepartmentForm().getDepartmentForm2().setTitleEmployee("Nhân viên - "+data.getDanhSachPhongBan().getList().get(0).getTenPhong());
		
		// xóa phòng ban
		xoaPhongBan xpb = new xoaPhongBan(this);
		contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(1).addActionListener(xpb);
		
		// thêm phòng ban
		luuThemSuaPhongBan ltpb = new luuThemSuaPhongBan(this);
		contentPage.getDepartmentForm().getDepartmentForm2().getDepartmentAdd().getBtnLuu().addActionListener(ltpb);
		
		// sửa phòng ban
		suaPhongBan spb = new suaPhongBan(this);
		contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(2).addActionListener(spb);
		
		// render dữ liệu ra cbb phòng ban (điều chỉnh nhân viên)
		contentPage.getDepartmentForm().getDepartmentForm2().setListPhongBan(data.getDanhSachPhongBan().getDanhSachTenPhongBan());
		// xuất excel phòng ban
		xuatFilePhongBan xfpb = new xuatFilePhongBan(this);
		contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(0).addActionListener(xfpb);
		// điều chỉnh nhân sự phòng ban
		dieuChinhNhanSuPhongBan dcnspb = new dieuChinhNhanSuPhongBan(this);
		contentPage.getDepartmentForm().getDepartmentForm2().getBtnLuu().addMouseListener(dcnspb);
		// render danh sách chức vụ
		contentPage.getDepartmentForm().getDepartmentForm2().setListChucVu(access_CHUCVUCONGTY.getDanhSachTenChucVuCongTy());
		
		contentPage.getDepartmentForm().setDepartmentData(data.getDanhSachPhongBan().getObjectToRender());
		
	}
	public void suKienTrangNhanVien() {
		// SỰ KIỆN TRANG NHÂN VIÊN
		
		EmployeeForm employeeForm = contentPage.getEmployeeForm();
		// sự kiện xóa nhân viên
		xoaNhanVien eldm = new xoaNhanVien(this);
		employeeForm.getEmployeeForm1().getOptionBtn().get(0).addMouseListener(eldm);
		// sửa nhân viên
		showSuaNhanVien ssnv = new showSuaNhanVien(this);
		employeeForm.getEmployeeForm1().getOptionBtn().get(1).addMouseListener(ssnv);
		// hủy sửa nhân viên
		huySuaNhanVien hsnv = new huySuaNhanVien(this);
		employeeForm.getEmployeeForm3().getCart1().getBtnHuy().addMouseListener(hsnv);
		// lưu sửa nhân viên
		suaNhanVien snv = new suaNhanVien(this);
		employeeForm.getEmployeeForm3().getCart1().getBtnLuu().addMouseListener(snv);
		// sự kiện show trang thông tin chi tiết nhân viên
		xemChiTietNhanVien esd = new xemChiTietNhanVien(this);
		employeeForm.getEmployeeForm1().getOptionBtn().get(2).addMouseListener(esd);
		
		// sự kiện thêm nhân viên
		themNhanVien efc1 = new themNhanVien(this);
		employeeForm.getEmployeeForm3().getCart1().getBtnThem().addMouseListener(efc1);
		
		// sự kiện trên bảng nhân viên
		sukienBangNhanVienRightClick etm = new sukienBangNhanVienRightClick(this);
		employeeForm.getEmployeeForm1().getTable().addMouseListener(etm);
		
		// sự kiện show trang thêm nhân viên
		showThemNhanVien ef3s = new showThemNhanVien(this);
		employeeForm.getEmployeeForm1().getBtnThem().addMouseListener(ef3s);
		// sự kiện trở về nhân viên gốc
		troVeTrangNhanVien1 rea1 =new troVeTrangNhanVien1(this);
		employeeForm.getEmployeeForm2().getBtnBack().addActionListener(rea1);
		
		employeeForm.getEmployeeForm3().getBtnBack().addActionListener(rea1);
		
		// sự kiện tìm kiếm nhân viên
		timKiemNhanVien ae = new timKiemNhanVien(this);
		employeeForm.getEmployeeForm1().getFindField().addKeyListener(ae);
		// di chuyển option panel
		JPanel optionPanel = contentPage.getEmployeeForm().getEmployeeForm1().getOptionPanel();
		diChuyenOptionPanel dc = new diChuyenOptionPanel(optionPanel);
		optionPanel.addMouseMotionListener(dc);
		
		 // lọc nhân viên
		locSapXepNhanVien lnv = new locSapXepNhanVien(this);
		employeeForm.getEmployeeForm1().getCbbFilterPhongBan().addActionListener(lnv);
		employeeForm.getEmployeeForm1().getCbbFilterGioiTinh().addActionListener(lnv);
		employeeForm.getEmployeeForm1().getCbbFilterDoTuoi().addActionListener(lnv);
		employeeForm.getEmployeeForm1().getCbbFilterLoaiHinh().addActionListener(lnv);
		employeeForm.getEmployeeForm1().getCbbFilterMucLuong().addActionListener(lnv);
		// sắp xếp nhân viên
		employeeForm.getEmployeeForm1().getCbbSortBy().addActionListener(lnv);
		employeeForm.getEmployeeForm1().getCbbSortMode().addActionListener(lnv);
//						

		// xuất file nhân viên
		xuatFileNhanVien xfnv = new xuatFileNhanVien(this);
		employeeForm.getEmployeeForm1().getBtnExport().addMouseListener(xfnv);
		
		// show nhập file nhân viên
		employeeForm.getEmployeeForm1().getBtnImport().addMouseListener(new showNhapFileNhanVien(this));
				
		// xem chi tiết nhân viên import excel
		employeeForm.getEmployeeForm3().getCart2().getBtnXemChiTiet().addMouseListener(new xemChiTietNhanVienImportExcel(this));
		// xóa nhân viên import file
		employeeForm.getEmployeeForm3().getCart2().getBtnXoaNhanVien().addMouseListener(new xoaNhanVienImportExcel(this));
		// thêm nhân viên import file
		employeeForm.getEmployeeForm3().getCart2().getBtnThemNhanVien().addMouseListener(new themNhanVienImportExcel(this));
				
				
				
		
		// sự kiện cbb tỉnh thành phố
		cbbTinhThanhPhoNhanVien cbbttp = new cbbTinhThanhPhoNhanVien(this);
		employeeForm.getEmployeeForm3().getCart1().getCbbTinhThanhPho().addActionListener(cbbttp);
		// sự kiện cbb quận huyện
		cbbQuanHuyenNhanVien cbbqh = new cbbQuanHuyenNhanVien(this);
		employeeForm.getEmployeeForm3().getCart1().getCbbQuanHuyen().addActionListener(cbbqh);
		
		// sự kiện cbb phường xã
		cbbPhuongXaNhanVien cbbpx = new cbbPhuongXaNhanVien(this);
		employeeForm.getEmployeeForm3().getCart1().getCbbPhuongXa().addActionListener(cbbpx);
		
		
		
		// data cbb phòng ban
		employeeForm.getEmployeeForm1().setCbbFilterPhongBanData(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
		employeeForm.getEmployeeForm3().getCart1().setDanhSachPhongBan(data.getDanhSachPhongBan().getDanhSachTenPhongBan());
		// data cbb chức vụ
		employeeForm.getEmployeeForm3().getCart1().setDanhSachChucVu(access_CHUCVUCONGTY.getDanhSachTenChucVuCongTy());
		// data nơi cấp cmnd
		employeeForm.getEmployeeForm3().getCart1().setDanhSachTinhThanhPho(data.getDanhSachDiaChi().getDanhSachTinhThanhPhoString());
		renderEmployeeTable();
		renderDepartmentShow(0);
		showTinhThanhPho(0);
	}
	public void suKienTrangHopDong() {
//		HỢP ĐỒNG
		renderConTractTable();
//		renderConTractForm3();
		renderConTractTableForm3();
		ConTractForm1 form1 = contentPage.getContractForm().getConTractForm1();
		form1.setCbbFilterData(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
		// sự kiện show trang gia hạn hợp đồng
		showGiaHanHopDong ghhd = new showGiaHanHopDong(this);
		form1.getOptionBtn().get(0).addMouseListener(ghhd);

		// sự kiện chuột phải trên bảng hợp đồng
		suKienFormHopDong1 skhd = new suKienFormHopDong1(this);
		form1.getTable().addMouseListener(skhd);

		// sự kiện trở về trang hợp đồng
		troVeTrangHopDong backToConTract = new troVeTrangHopDong(this);
		contentPage.getContractForm().getConTractForm2().getBtnBack().addActionListener(backToConTract);
		contentPage.getContractForm().getConTractForm2().getBtnHuy().addActionListener(backToConTract);

		// thống kê hợp đồng

		// sự kiện gia hạn hợp đồng
		suKienGiaHanHopDong gh = new suKienGiaHanHopDong(this);
		contentPage.getContractForm().getConTractForm2().getBtnGiaHan().addMouseListener(gh);
		// hủy hợp đồng
		huyHopDong hhd = new huyHopDong(this);
		form1.getOptionBtn().get(1).addMouseListener(hhd);

		// Lọc hợp đồng
		locHopDong lhd = new locHopDong(this);
		form1.getCbbFilter().addActionListener(lhd);
		form1.getCbbFilter2().addActionListener(lhd);

		// Lọc hợp đồng bằng lương cơ bản
		form1.getMinSalary().addKeyListener(lhd);
		form1.getMaxSalary().addKeyListener(lhd);

		// tìm kiếm hợp đồng
		timKiemHopDong hd = new timKiemHopDong(this);
		form1.getFindField().addKeyListener(hd);
		
		// săp xếp hợp đồng
		sapXepHopDong sxhd = new sapXepHopDong(this);
		form1.getCbbSort().addActionListener(sxhd);
		form1.getCbbSort_Asc_Desc().addActionListener(sxhd);
		// xuất excel
		form1.getBtnExport().addMouseListener(new xuatFileHopDong(this));
		
		contentPage.getContractForm().getConTractForm3().getCbbPhanLoai().addActionListener(new thongKeHopDong(this));
		
		// trang kí hợp đồng
		contentPage.getContractForm().getConTractForm4().setDataForCbbPhong(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
		sapXepNhanVienKiHopDong sxnvkhd = new sapXepNhanVienKiHopDong(this);
		contentPage.getContractForm().getConTractForm4().getCbbPhong().addActionListener(sxnvkhd);
		contentPage.getContractForm().getConTractForm4().getCbbSort().addActionListener(sxnvkhd);
		contentPage.getContractForm().getConTractForm4().getCbbSort2().addActionListener(sxnvkhd);
		
		contentPage.getContractForm().getConTractForm4().getTable().addMouseListener(new showNhanVienKiHopDong(this));
		contentPage.getContractForm().getConTractForm4().getBtnKiHopDong().addMouseListener(new taoHopDong(this));
		
		
		
		contentPage.getContractForm().getConTractForm3().setDataPieChart1(access_HOPDONGLAODONG.getSoLuongHopDongHetHanVaKiTrongNam(2023));
		contentPage.getContractForm().getConTractForm3().setDataPieChart2(access_HOPDONGLAODONG.getThongKeTiLeLoaiHopDong());
		
		
		
	}

			
		
	
	public void renderBCCTable() {
		contentPage.getBangChamCongForm().getForm1().setData(data.getDanhSachBangChamCong().getObjectseToRender());
	}
	public void renderConTractTable() {
		contentPage.getContractForm().getConTractForm1().setData(data.getDanhSachHopDong().getObjectToRender());
	}

	public void renderConTractTableForm3() {
		if (contentPage.getContractForm().getConTractForm3().getLabelSoLuong().getText().equals("Số lượng: ")) {
			contentPage.getContractForm().getConTractForm3().getLabelSoLuong().setText("Số lượng: "+access_HOPDONGLAODONG.getSoLuongHopDong() );
		}
		contentPage.getContractForm().getConTractForm3().setConTractForm3Data(data.getDanhSachHopDong().getObjectToRender());
	}
	
	public void suKienTrangBangChamCong() {
		renderBCCTable();

		// Import cbbBangChamCong
        contentPage.getBangChamCongForm().getForm1().setCbbFilterData(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());

        // Điều khiển form bảng chấm công form 1
        BCCDenFormThem bccThemBtn = new BCCDenFormThem(this);
        contentPage.getBangChamCongForm().getForm1().getBtnThem().addActionListener(bccThemBtn);
        BCCQuayLai bccQuayLai = new BCCQuayLai(this);
        contentPage.getBangChamCongForm().getForm2().getBtnBack().addMouseListener(bccQuayLai);
        contentPage.getBangChamCongForm().getForm3().getBack().addMouseListener(bccQuayLai);

        // di chuyển option panel
        JPanel optionPanel = contentPage.getBangChamCongForm().getForm1().getOptionPanel();
		diChuyenOptionPanel dc = new diChuyenOptionPanel(optionPanel);
		optionPanel.addMouseMotionListener(dc);
        // sự kiện tìm kiếm bảng chấm công
        BCCTimKiem timBCC = new BCCTimKiem(this);
        contentPage.getBangChamCongForm().getForm1().getFindField().addKeyListener(timBCC);

        // sự kiện lọc bảng chấm công
        BCCLoc locBCC = new BCCLoc(this);
        contentPage.getBangChamCongForm().getForm1().getCbbFilterPhong().addActionListener(locBCC);
        contentPage.getBangChamCongForm().getForm1().getCbbFilterMonth().addActionListener(locBCC);
        contentPage.getBangChamCongForm().getForm1().getCbbFilterYear().addActionListener(locBCC);

        // sự kiện sắp xếp BCC
        BCCSapXep sapXepBCC = new BCCSapXep(this);
        contentPage.getBangChamCongForm().getForm1().getCbbSort().addActionListener(sapXepBCC);
        contentPage.getBangChamCongForm().getForm1().getCbbSort_Asc_Desc().addActionListener(sapXepBCC);

        // sự kiện thêm BCC
        BCCThem themBCC = new BCCThem(this);
        contentPage.getBangChamCongForm().getForm2().getBtnThem().addMouseListener(themBCC);

        // sự kiện form bảng chấm công (right)
        BCCRightClick rightClickBCC = new BCCRightClick(this);
        contentPage.getBangChamCongForm().getForm1().getTable().addMouseListener(rightClickBCC);
        
        // sự kiện xóa BCC
        BCCXoa xoaBCC = new BCCXoa(this);
        contentPage.getBangChamCongForm().getForm1().getOptionBtn().get(0).addMouseListener(xoaBCC);
        
        // sự kiện chọn sửa bảng chấm công
        BCCSua suaBCC = new BCCSua(this);
        contentPage.getBangChamCongForm().getForm1().getOptionBtn().get(1).addMouseListener(suaBCC);
        
        // sự kiện lưu sửa bảng chấm công
        BCCSave luuBCC = new BCCSave(this);
        contentPage.getBangChamCongForm().getForm3().getSave().addMouseListener(luuBCC);
        
        contentPage.getBangChamCongForm().getForm2().setData(data.getDanhSachNhanVien().getObjectseToRender_Them());
        BCC_ChiTietChamCong_Mouse bctcc= new BCC_ChiTietChamCong_Mouse(this);
        contentPage.getBangChamCongForm().getForm1().getTable().addMouseListener(bctcc);
        // xuất excel
        contentPage.getBangChamCongForm().getForm1().getBtnExport().addActionListener(new xuatFileBangChamCong(this));
	}
	public void suKienTrangLuong() {
		SalaryForm1 form1 = contentPage.getSalaryForm().getSalaryForm1();
		SalaryForm2 form2 = contentPage.getSalaryForm().getSalaryForm2();
		SalaryForm3 form3 = contentPage.getSalaryForm().getSalaryForm3();
		SalaryForm4 form4 = contentPage.getSalaryForm().getSalaryForm4();
		// LƯƠNG NHÂN VIÊN
		form1.setDataForCbbPhong(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
		form1.setSalaryData(access_LUONG.getObjectToRender());
			locLuong ll = new locLuong(this);
			form1.getCbbNam().addActionListener(ll);
			form1.getCbbThang().addActionListener(ll);
			form1.getCbbPhong().addActionListener(ll);
			form1.getCbbSort().addActionListener(ll);
			form1.getCbbSort2().addActionListener(ll);
			
			// tìm kím
			form1.getTfFind().addKeyListener(new timKiemLuong(this));
			
			form2.getObjectTable().addMouseListener(new clickTableLuongThuong(this));
			
			form2.setDataForCbbPhong(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
			form2.setDataCbbPhongBanLuongThuong(data.getDanhSachPhongBan().getDanhSachTenPhongBan());
			form3.setDataForCbbPhong(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
			// lọc
			locLuongThuong llt = new locLuongThuong(this);
			form2.getCbbNam().addActionListener(llt);
			form2.getCbbThang().addActionListener(llt);
			form2.getCbbPhong().addActionListener(llt);
			form2.getCbbSort().addActionListener(llt);
			form2.getCbbSort2().addActionListener(llt);
			
			
			form3.getTable().addMouseListener(new clickTablePhuCapKhoanTru(this));
			
			// lưu thưởng 
			form2.getBtnLuuThuong().addMouseListener(new themLuongThuong(this));
			
			
			form4.getTable().addMouseListener(new clickTableTangLuong(this));
			// lọc tăng lương
			// điều chỉnh lương hàng năm
			form4.getBtnTangLuongHangNam().addMouseListener(new dieuChinhMucLuongTuDong(this));
			// điều chỉnh lương
			form4.getBtnDieuChinhLuong().addMouseListener(new dieuChinhMucLuong(this));
			// set data điều chỉnh lương
//			form4.setDanhGiaData(access_BANGDANHGIA.getDanhSachDanhGiaTangLuong());
			// phụ cấp và khoản trừ
			form3.setData(access_LUONG.getDanhSachPhuCapKhoanTruToRender());
			// phụ cấp lương
			
			form3.getBtnPhuCap().addMouseListener(new phuCapNhanVien(this));
			// khoản trừ lương
			form3.getBtnKhoanTru().addMouseListener(new khoanTruNhanVien(this));
			// lọc phụ cấp khoản trừ
			locPhuCapKhoanTru lpckt = new locPhuCapKhoanTru(this);
			form3.getCbbNam().addActionListener(lpckt);
			form3.getCbbThang().addActionListener(lpckt);
			form3.getCbbPhong().addActionListener(lpckt);
			form3.getCbbSort().addActionListener(lpckt);
			form3.getCbbSort2().addActionListener(lpckt);
			// 
			// xuất excel
			form1.getBtnExportExcel().addMouseListener(new xuatFileLuong(this));
	}
	public void suKienTrangDanhGia() {
		
        BangDanhGiaForm1 danhgiatemp = contentPage.getDanhGiaForm();
        
        
        DanhGiaView dgview2 = contentPage.getDanhGiaForm2();
        dgview2.setData(access_BANGDANHGIA.getListNhanVien());
        
        
		this.contentPage.getDanhGiaForm().getBtnThem().addActionListener(new showDanhGiaForm2(this));
		this.contentPage.getDanhGiaForm2().getbtnBack().addActionListener(new showDanhGiaForm1(this));
        
        dgview2.getBtnNewButton().addActionListener(new DanhGia_Action(this));
        
        
        dgview2.getObjectTable().addMouseListener(new showDanhGia(this));
        
        danhgiatemp.getBtnXoa().addMouseListener(new xoaDanhGia(this));
        danhgiatemp.getBtnChiTiet().addMouseListener(new xemChiTietDanhGia(this));
        
        
        // lọc
        danhgiatemp.getCbbLoaiDanhGia().addActionListener(new locXapSepDanhGia(this));
        danhgiatemp.getCbbSort().addActionListener(new locXapSepDanhGia(this));
        danhgiatemp.getCbbSort_Asc_Desc().addActionListener(new locXapSepDanhGia(this));
        
        
        danhgiatemp.getTfBatDau().getDocument().addDocumentListener(new locDanhGiaNgayThang(this));
        danhgiatemp.getTfKetThuc().getDocument().addDocumentListener(new locDanhGiaNgayThang(this));
        // tìm kiếm
        danhgiatemp.getFindField().addKeyListener(new TimKimDG_Key(this));

		

		// TODO
	}
	public void suKienTrangTuyenDung() {
		// tuyển dụng
		// TuyenDungAction
		//di chuyển view thêm
		TuyenDungView tempTuyenDung = contentPage.getRecruitmentForm().getTuyenDungView();
		UngVienView tempUngVien = contentPage.getRecruitmentForm().getUngVienView();
		diChuyenChuongTrinh dccc = new diChuyenChuongTrinh((JFrame)contentPage.getRecruitmentForm().getTuyenDungView().getTuyenDungView_Them());
		tempTuyenDung.getTuyenDungView_Them().addMouseMotionListener(dccc);
		// set data for cbb
		tempUngVien.setMaTuyenDung_UngVienView_UngVienView_Them(access_TUYENDUNG.getMaTuyenDungToFilter());
		
		
		TuyenDungAction ac= new TuyenDungAction(this);
		tempTuyenDung.getButton_TuyenDung_Them().addActionListener(ac);
		tempTuyenDung.getButton_TuyenDung_Xoa().addActionListener(ac);

		
		tempTuyenDung.getTuyenDungView_Them().getButton_dong().addActionListener(ac);
		tempTuyenDung.getTuyenDungView_Them().getButton_luu().addActionListener(ac);

		TuyenDungMouse mo= new TuyenDungMouse(this);
		tempTuyenDung.getTuyenDung_Find().addMouseListener(mo);
		tempTuyenDung.setData(data.getDanhsachbaocaotuyendung().getObject());
        //Tìm kiếm báo cáo tuyển dụng
        TimKimBCTD_Key tkk= new TimKimBCTD_Key(this);
        tempTuyenDung.getTuyenDung_Find().addKeyListener(tkk);
			
        // set data chức vụ tuyển dụng
        tempTuyenDung.getTuyenDungView_Them().setCbbChucVu(access_CHUCVUCONGTY.getDanhSachTenChucVuCongTy());
				
		//UngVienAction
      //di chuyển view thêm
      		
      		
        diChuyenChuongTrinh dcccc = new diChuyenChuongTrinh((JFrame)contentPage.getRecruitmentForm().getUngVienView().getUvv_t());
        tempUngVien.getUvv_t().addMouseMotionListener(dcccc);
        diChuyenChuongTrinh dccccc = new diChuyenChuongTrinh((JFrame)contentPage.getRecruitmentForm().getUngVienView().getFormTuyenUngVien());
        tempUngVien.getFormTuyenUngVien().addMouseMotionListener(dccccc);
		UngVienAction ua= new UngVienAction(this);
		tempUngVien.getButton_UngVien_Them().addActionListener(ua);
		tempUngVien.getButton_UngVien_Xoa().addActionListener(ua);
		tempUngVien.getUvv_t().getButton_dong().addActionListener(ua);
		tempUngVien.getUvv_t().getButton_luu().addActionListener(ua);
		
		UngVienView_Tuyen_HienThi_Action uh= new UngVienView_Tuyen_HienThi_Action(this);
		tempUngVien.getButtonTuyenUngVien().addActionListener(uh);

		// cbb phòng ban tuyển nhân viên
		tempUngVien.getFormTuyenUngVien().setDataCbbPhongBanTuyenUngVien(data.getDanhSachPhongBan().getDanhSachTenPhongBan());

		UngVienView_TuyenUngVien_Action uc= new UngVienView_TuyenUngVien_Action(this);
		tempUngVien.getFormTuyenUngVien().getButton_dong().addActionListener(uc);
		tempUngVien.getFormTuyenUngVien().getButton_luu().addActionListener(uc);
		//Tìm kiếm ứng viên
		TimKiemUngVien_Key tku= new TimKiemUngVien_Key(this);
		tempUngVien.getUngVien_Find().addKeyListener(tku);
//		UngVienItem
		UngVienItem uvi= new UngVienItem(this);
		tempUngVien.getComboBox_MaTuyenDung().addActionListener(uvi);
		
		//UngVien_Table_Mouse
        UngVien_Table_Action uta= new UngVien_Table_Action(this);
        tempUngVien.getObjectTable().addMouseListener(uta); 
//		UngVienMouse
        UngVienMouse um= new UngVienMouse(this);
        tempUngVien.getUngVien_Find().addMouseListener(um);

        // lấy dữ liệu ứng viên
        tempUngVien.setData(data.getDanhsachungvien().getObject());
        
        // hủy tuyển ứng viên
        tempUngVien.getFormTuyenUngVien().getButton_dong().addMouseListener(new huyTuyenUngVien(this));
        
        // set data cbb địa chỉ
        tempUngVien.getUvv_t().setDataCbbNoiCap(data.getDanhSachDiaChi().getDanhSachTinhThanhPhoString());
        tempUngVien.getUvv_t().setDataCbbTinhThanhPho(data.getDanhSachDiaChi().getDanhSachTinhThanhPhoString());
        tempUngVien.getUvv_t().setDataCbbQuanHuyen(data.getDanhSachDiaChi().getList().get(0).getDanhSachQuanHuyenString());
        tempUngVien.getUvv_t().setDataCbbPhuongXa(data.getDanhSachDiaChi().getList().get(0).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXaString());
        tempUngVien.getUvv_t().setDataCbbDuong(data.getDanhSachDiaChi().getList().get(0).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXa().get(0).getDanhSachDuongString());
    
        // sự kiện cbb tỉnh thành phố
        tempUngVien.getUvv_t().getCbbTinhThanhPho().addActionListener(new cbbTinhThanhPhoUngVien(this));
        tempUngVien.getUvv_t().getCbbQuanHuyen().addActionListener(new cbbQuanHuyenUngVien(this));
        tempUngVien.getUvv_t().getCbbPhuongXa().addActionListener(new cbbPhuongXaUngVien(this));
        
 		
 		
	}
	public void suKienTrangTaiKhoan() {
		// TÀI KHOẢN 
		// lấy danh sách phòng ban lọc theo phòng ban
		AccountForm temp = contentPage.getAccountForm();
		temp.setCbbPhongBanString(data.getDanhSachPhongBan().getDanhSachTenPhongBanDeLoc());
		// lọc tài khoản
		locTaiKhoan ltk = new locTaiKhoan(this);
		
		temp.getCbbPhongBan().addActionListener(ltk);
		// show thông tin tài khoản
		temp.getTableAccount().addMouseListener(new showThongTinTaiKhoan(this));
		temp.setModelCbbQuyen(data.getDanhSachNhomQuyen().getMaNhomQuyenForCBB());
		
		
		temp.setAccountData(access_TAIKHOAN.getObjectToRender());
		// chỉnh sửa quyền tài khoản
		temp.getBtnChinhSuaQuyenTaiKhoan().addActionListener(new luuChinhSuaQuyen(this));
		
		// nhóm quyền
		temp.setDataNhomQuyen(data.getDanhSachNhomQuyen().getObjectToRender());
		// show thông tin quyền
		temp.getTableNhomQuyen().addMouseListener(new showThongTinNhomQuyen(this));
		// thêm nhóm quyền
		temp.getBtnThemNhomQuyen().addActionListener(new luuThemNhomQuyen(this));
		// xóa nhóm quyền
		temp.getBtnXoa().addMouseListener(new xoaNhomQuyen(this));
		// chỉnh sửa nhóm quyền
		temp.getBtnLuuNhomQuyen().addMouseListener(new chinhSuaNhomQuyen(this));
	}
	public int showOption(String str) {
		return JOptionPane.showConfirmDialog(this,str,"Tùy chọn" ,JOptionPane.YES_NO_OPTION);
		
	}
	public void showTinhThanhPho(int index) {
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachQuanHuyen(data.getDanhSachDiaChi().getList().get(index).getDanhSachQuanHuyenString());
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachPhuongXa(data.getDanhSachDiaChi().getList().get(index).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXaString());
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachDuong(data.getDanhSachDiaChi().getList().get(index).getDanhSachQuanHuyen().get(0).getDanhSachPhuongXa().get(0).getDanhSachDuongString());
	}
	public void showQuanHuyen(int index_tp, int index_qh) {
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachPhuongXa(data.getDanhSachDiaChi().getList().get(index_tp).getDanhSachQuanHuyen().get(index_qh).getDanhSachPhuongXaString());
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachDuong(data.getDanhSachDiaChi().getList().get(index_tp).getDanhSachQuanHuyen().get(index_qh).getDanhSachPhuongXa().get(0).getDanhSachDuongString());
	}
	public void showPhuongXa(int index_tp, int index_qh,int index_px ) {
		contentPage.getEmployeeForm().getEmployeeForm3().getCart1().setDanhSachDuong(data.getDanhSachDiaChi().getList().get(index_tp).getDanhSachQuanHuyen().get(index_qh).getDanhSachPhuongXa().get(index_px).getDanhSachDuongString());
	}
	// tuyển dụng
	
	public void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str,"Thông báo",JOptionPane.WARNING_MESSAGE);
		
	}
	public void renderEmployeeTable() {
		contentPage.getEmployeeForm().getEmployeeForm1().setData(data.getDanhSachNhanVien().getObjectToRender());
	}
	public void myRepaint() {
		repaint();
	}
	public myMenuBar2 getMenu() {
		return this.menubar;
	}
	public myContent getContent() {
		return this.contentPage;
	}
	public DATA getData() {
		return data;
	}
	public void renderDepartmentShow(int index) {
		departmentForm1 temp = contentPage.getDepartmentForm().getDepartmentForm1();
		String maPhong = data.getDanhSachPhongBan().getList().get(index).getMaPhong();
		temp.setTitle(maPhong+" - "+data.getDanhSachPhongBan().getList().get(index).getTenPhong());
		temp.getDepartmentColumnChart().setEmployeeData(access_THONGKE.thongKePhongBan_soLuongNhanVien(maPhong));
		temp.getDepartmentColumnChart().setSalaryData(access_THONGKE.thongKePhongBan_mucLuongTB(maPhong));
		temp.getDepartmentColumnChart().renderData();
		ArrayList<Object[]> list = access_PHONGBAN.getDuLieuChucVuThongKe(maPhong);
		temp.setPositionData(list);
		temp.setAgeData(access_PHONGBAN.getDuLieuDoTuoiThongKe(maPhong));
		temp.setGenderData(access_PHONGBAN.getDuLieuGioiTinhThongKe(maPhong));
		temp.renderPostionNamePieChart();
		temp.renderData(list);
	}
	public void tienXuLy() {
		// tiền xử lý giao diện 
		this.header.changeAvatar(this.taiKhoanDangNhap.getAvatarImg());
		this.menubar.changeAvatar(this.taiKhoanDangNhap.getAvatarImg());
		NHANVIEN nhanVien = access_NHANVIEN.getNhanVien(taiKhoanDangNhap.getUsername());
		this.menubar.getLbName().setText(nhanVien.getHoTen());
		this.menubar.getLbChucVu().setText(nhanVien.getChucVu().getTenChucVu());
		ArrayList<String> titleMenuUse = new ArrayList<>();
		ArrayList<String> iconMenu1Use = new ArrayList<>();
		ArrayList<String> iconMenu2Use = new ArrayList<>();
		titleMenuUse.add(this.menubar.titleMenu[0]);
		iconMenu1Use.add(this.menubar.iconMenu1[0]);
		iconMenu2Use.add(this.menubar.iconMenu2[0]);
		
		// xử lý giao diện tuyển dụng
		if(mangChucNang[5] || mangChucNang[8]) {
			titleMenuUse.add(this.menubar.titleMenu[1]);
			iconMenu1Use.add(this.menubar.iconMenu1[1]);
			iconMenu2Use.add(this.menubar.iconMenu2[1]);
			if(!mangChucNang[5]) {    
				// không tuyển dụng
				contentPage.getRecruitmentForm().getLb1().setText("ỨNG VIÊN");
				contentPage.getRecruitmentForm().getLb1().setBounds(20,5,80,30);
				contentPage.getRecruitmentForm().getLb2().setVisible(false);
				contentPage.getRecruitmentForm().getTuyenDungView().setVisible(false);
				contentPage.getRecruitmentForm().getUngVienView().setVisible(true);
				
				if(!mangChucNang[9]) {
					contentPage.getRecruitmentForm().getUngVienView().getButton_UngVien_Them().setEnabled(false);
				}
				if(!mangChucNang[10]) {
					contentPage.getRecruitmentForm().getUngVienView().getButton_UngVien_Xoa().setEnabled(false);
				}
				if(!mangChucNang[11]) {
					contentPage.getRecruitmentForm().getUngVienView().getButtonTuyenUngVien().setEnabled(false);
				}
			}
			if(!mangChucNang[8]) {
				// không ứng viên
				contentPage.getRecruitmentForm().getLb1().setVisible(false);
				contentPage.getRecruitmentForm().getLb2().setBounds(20,5,100,30);
				contentPage.getRecruitmentForm().getTuyenDungView().setVisible(true);
				contentPage.getRecruitmentForm().getUngVienView().setVisible(false);
				if(!mangChucNang[6]) {
					contentPage.getRecruitmentForm().getTuyenDungView().getButton_TuyenDung_Them().setEnabled(false);
				}
				if(!mangChucNang[7]) {
					contentPage.getRecruitmentForm().getTuyenDungView().getButton_TuyenDung_Xoa().setEnabled(false);
				}
				
				
				
				
			}
		}
		// xử lý giao diện nhân viên
		if(mangChucNang[0] || mangChucNang[1]) {
			titleMenuUse.add(this.menubar.titleMenu[2]);
			iconMenu1Use.add(this.menubar.iconMenu1[2]);
			iconMenu2Use.add(this.menubar.iconMenu2[2]);
			
			if(!mangChucNang[1]) {
				// chỉ xem thông tin cá nhân
				
				contentPage.getEmployeeForm().showFrame(1);
				contentPage.getEmployeeForm().getEmployeeForm2().getBtnBack().setVisible(false);
				
				contentPage.getEmployeeForm().getEmployeeForm2().setData(access_NHANVIEN.getNhanVien(this.taiKhoanDangNhap.getUsername()).getObjectToRender());
				contentPage.getEmployeeForm().getEmployeeForm2().setImageEmployee(this.taiKhoanDangNhap.getAvatarImg());
			}else {
				if(!mangChucNang[2]) {
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnThem().setEnabled(false);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnThem().setVisible(false);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnImport().setEnabled(false);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnImport().setVisible(false);
				}
				if(!mangChucNang[4]) {
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnExport().setEnabled(false);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnExport().setVisible(false);
					
				}
				if(!mangChucNang[3]) {
					contentPage.getEmployeeForm().getEmployeeForm1().getOptionBtn().get(0).setVisible(false);
					contentPage.getEmployeeForm().getEmployeeForm1().getOptionBtn().get(1).setVisible(false);
					contentPage.getEmployeeForm().getEmployeeForm1().getOptionBtn().get(2).setBounds(6,35,126,30);
					
				}
				
				

				if(!mangChucNang[2] && !mangChucNang[4]) {
					contentPage.getEmployeeForm().getEmployeeForm1().getFindField().setBounds(758,10,280,28);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnFind().setBounds(1032,8,42,38); // 858
				}else if(!mangChucNang[2] && mangChucNang[4]) {
					// không có  thêm, có xuất
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnExport().setBounds(1032,8,42,38); 
					contentPage.getEmployeeForm().getEmployeeForm1().getFindField().setBounds(715,10,280,28);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnFind().setBounds(989,8,42,38); // 858
				}else if(mangChucNang[2] && !mangChucNang[4]) {
					// không có  thêm, có xuất
					contentPage.getEmployeeForm().getEmployeeForm1().getFindField().setBounds(625,10,280,28);
					contentPage.getEmployeeForm().getEmployeeForm1().getBtnFind().setBounds(899,8,42,38); // 858
				}
			}
			
			
		}
		// xử lý giao diện hợp đồng
		if(mangChucNang[12]) {
			titleMenuUse.add(this.menubar.titleMenu[3]);
			iconMenu1Use.add(this.menubar.iconMenu1[3]);
			iconMenu2Use.add(this.menubar.iconMenu2[3]);
			
			if(!mangChucNang[16]) {
				contentPage.getContractForm().getConTractForm1().getBtnExport().setEnabled(false);
				contentPage.getContractForm().getConTractForm1().getBtnExport().setVisible(false);
			}
			if(!mangChucNang[13] && !mangChucNang[15]) {
				contentPage.getContractForm().getLb2().setVisible(false);
				contentPage.getContractForm().getLb3().setVisible(false);
			}else if(mangChucNang[13] && !mangChucNang[15]) {
				contentPage.getContractForm().getLb3().setVisible(false);
			}else if(!mangChucNang[13] && mangChucNang[15]) {
				contentPage.getContractForm().getLb2().setVisible(false);
				contentPage.getContractForm().getLb3().setBounds(100, 5, 80, 30);
			}else {
				
			}
		}
		// xử lý giao diện phòng ban
		if(mangChucNang[17] || mangChucNang[21]) {
			titleMenuUse.add(this.menubar.titleMenu[4]);
			iconMenu1Use.add(this.menubar.iconMenu1[4]);
			iconMenu2Use.add(this.menubar.iconMenu2[4]);
			
			if(!mangChucNang[18]) {
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(3).setEnabled(false);
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(3).setBackground(Color.decode("#b2bec3"));
				
			}
			if(!mangChucNang[19]) {
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(1).setEnabled(false);
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(1).setBackground(Color.decode("#b2bec3"));
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(2).setEnabled(false);
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(2).setBackground(Color.decode("#b2bec3"));
				
			}
			if(!mangChucNang[22]) {
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(0).setEnabled(false);
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnActionList().get(0).setBackground(Color.decode("#b2bec3"));
			}
			if(!mangChucNang[20]) {
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnInfo().setEnabled(false);
				contentPage.getDepartmentForm().getDepartmentForm2().getBtnInfo().setBackground(Color.decode("#b2bec3"));
			}
			
			
			if(!mangChucNang[17] && mangChucNang[21]) {
				
				contentPage.getDepartmentForm().getLb2().setVisible(false);
			}else if(mangChucNang[17] && !mangChucNang[21]) {
				contentPage.getDepartmentForm().getLb1().setVisible(false);
				contentPage.getDepartmentForm().getLb2().setBounds(20,5,80,30);
				contentPage.getDepartmentForm().showForm(1);
			}else {
				
			}
			
			
		}
		// xử lý giao diện chấm công
		if(mangChucNang[23] || mangChucNang[24]) {
			titleMenuUse.add(this.menubar.titleMenu[5]);
			iconMenu1Use.add(this.menubar.iconMenu1[5]);
			iconMenu2Use.add(this.menubar.iconMenu2[5]);
			
			if(!mangChucNang[27]) {
				contentPage.getBangChamCongForm().getForm1().getBtnExport().setEnabled(false);
				contentPage.getBangChamCongForm().getForm1().getBtnExport().setBackground(Color.decode("#b2bec3"));
			}
			if(mangChucNang[23] && !mangChucNang[24]) {
				contentPage.getBangChamCongForm().getForm1().getBtnThem().setEnabled(false);
				contentPage.getBangChamCongForm().getForm1().getBtnThem().setBackground(Color.decode("#b2bec3"));
				contentPage.getBangChamCongForm().getForm1().setData(new DANHSACHBANGCHAMCONG(access_BANGCHAMCONG.getBangChamCongTheoMaNhanVien(this.taiKhoanDangNhap.getUsername())).getObjectseToRender());
			}else if(mangChucNang[24]){
				if(!mangChucNang[25]) {
					contentPage.getBangChamCongForm().getForm1().getBtnThem().setEnabled(false);
					contentPage.getBangChamCongForm().getForm1().getBtnThem().setBackground(Color.decode("#b2bec3"));
				}
			}
			
		}
		// xử lý giao diện lương
		if(mangChucNang[28] || mangChucNang[29]) {
			titleMenuUse.add(this.menubar.titleMenu[6]);
			iconMenu1Use.add(this.menubar.iconMenu1[6]);
			iconMenu2Use.add(this.menubar.iconMenu2[6]);
			if(!mangChucNang[33]) {
				contentPage.getSalaryForm().getSalaryForm1().getBtnExportExcel().setVisible(false);
			}
			if(mangChucNang[28] && !mangChucNang[29]) {
				contentPage.getSalaryForm().getLb2().setVisible(false);
				contentPage.getSalaryForm().getLb3().setVisible(false);
				contentPage.getSalaryForm().getLb4().setVisible(false);
				contentPage.getSalaryForm().getSalaryForm1().setSalaryData(access_LUONG.getObjectToRender(this.taiKhoanDangNhap.getUsername()));
			}else {
				if(mangChucNang[30] && mangChucNang[31] && !mangChucNang[32]) {
					// 2 3
					contentPage.getSalaryForm().getLb4().setVisible(false);
				}else if(mangChucNang[30] && !mangChucNang[31] && !mangChucNang[32]) {
					// 2
					contentPage.getSalaryForm().getLb3().setVisible(false);
					contentPage.getSalaryForm().getLb4().setVisible(false);
				}else if(!mangChucNang[30] && !mangChucNang[31] && !mangChucNang[32]) {
					// _
					contentPage.getSalaryForm().getLb2().setVisible(false);
					contentPage.getSalaryForm().getLb3().setVisible(false);
					contentPage.getSalaryForm().getLb4().setVisible(false);
				}else if(mangChucNang[30] && !mangChucNang[31] && mangChucNang[32]) {
					// 2 4
					contentPage.getSalaryForm().getLb3().setVisible(false);
					contentPage.getSalaryForm().getLb4().setBounds(300,5,100,30);
					
				}else if(!mangChucNang[30] && mangChucNang[31] && mangChucNang[32]) {
					// 3 4
					contentPage.getSalaryForm().getLb2().setVisible(false);
					contentPage.getSalaryForm().getLb3().setBounds(170,5,150,30);
					contentPage.getSalaryForm().getLb4().setBounds(340,5,100,30);
				}else if(!mangChucNang[30] && mangChucNang[31] && !mangChucNang[32]) {
					// 3 
					contentPage.getSalaryForm().getLb2().setVisible(false);
					contentPage.getSalaryForm().getLb4().setVisible(false);
					contentPage.getSalaryForm().getLb3().setBounds(170,5,150,30);
				}else if(!mangChucNang[30] && !mangChucNang[31] && mangChucNang[32]) {
					// 4 
					contentPage.getSalaryForm().getLb3().setVisible(false);
					contentPage.getSalaryForm().getLb4().setVisible(false);
					contentPage.getSalaryForm().getLb4().setBounds(170,5,100,30);
				}
			}
			
			
		}
		// xử lý giao diện đánh giá
		if(mangChucNang[34] || mangChucNang[35]) {
			titleMenuUse.add(this.menubar.titleMenu[7]);
			iconMenu1Use.add(this.menubar.iconMenu1[7]);
			iconMenu2Use.add(this.menubar.iconMenu2[7]);
			// TODO 
			if(mangChucNang[34] && !mangChucNang[35]) {
				contentPage.getDanhGiaForm().getBtnThem().setEnabled(false);
				contentPage.getDanhGiaForm().getBtnXoa().setEnabled(false);
//				contentPage.getDanhGiaForm().getBtnChiTiet().setEnabled(false);
//				contentPage.getDanhGiaForm2().getBtnNewButton().setEnabled(false);
			}else {
				if(!mangChucNang[36]) {
					contentPage.getDanhGiaForm().getBtnThem().setEnabled(false);
					contentPage.getDanhGiaForm().getBtnXoa().setEnabled(false);
					contentPage.getDanhGiaForm().getBtnChiTiet().setEnabled(false);
				}
			}
			
		}
		// xử lý giao diện phân quyền
		if(mangChucNang[37]) {
			titleMenuUse.add(this.menubar.titleMenu[8]);
			iconMenu1Use.add(this.menubar.iconMenu1[8]);
			iconMenu2Use.add(this.menubar.iconMenu2[8]);
		}
		int numberOfMenu = titleMenuUse.size();
		String a1[] = new String[numberOfMenu];
		String a2[] = new String[numberOfMenu];
		String a3[] = new String[numberOfMenu];
		for(int i=0;i<numberOfMenu;i++) {
			a1[i] = titleMenuUse.get(i);
			a2[i] = iconMenu1Use.get(i);
			a3[i] = iconMenu2Use.get(i);
			
		}
		this.menubar.titleMenuUse = a1;
		this.menubar.iconMenu1Use = a2;
		this.menubar.iconMenu2Use = a3;
		this.menubar.RENDER_MENU();
		this.menubar.addActionHover(this);
	}
	public boolean[] getMangChucNang() {
		return this.mangChucNang;
	}
	public TAIKHOAN getTaiKhoanDangNhap(){
		return this.taiKhoanDangNhap;
	}
}
