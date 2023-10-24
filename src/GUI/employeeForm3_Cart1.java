package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ButtonUI;

import DTO.SUPPORT;
import view.button.Button;





public class employeeForm3_Cart1 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnReset;
	private JTextField tfMaSo;
	private JTextField tfHoTen;
	private JTextField tfSoDienThoai;
	private JTextField tfCmnd;
	private JTextField tfEmail;
	private JTextField tfMucLuong;
	private JTextField tfSoNha;
	private JTextField tfNgaySinh;
	private JTextField tfNgayCapCMND;
	private JTextField tfNgayBatDau;
	private JTextField tfNgayKetThuc;
	private JTextField tfNgayNhanChuc;
	private JTextField tfChuyenNganh;
	private myCombobox<String> cbbGioiTinh;
	private myCombobox<String> cbbNoiCapCMND;
	private myCombobox<String> cbbDanToc;
	private myCombobox<String> cbbTonGiao;
	private myCombobox<String> cbbTinhTrangHonNhan;
	private myCombobox<String> cbbDuong;
	private myCombobox<String> cbbPhuong;
	private myCombobox<String> cbbQuan;
	private myCombobox<String> cbbTinh;
	private myCombobox<String> cbbHocVan;
	private myCombobox<String> cbbChuyenMon;
	
	private myCombobox<String> cbbLoaiHinh;
	private myCombobox<String> cbbPhongBan;
	private myCombobox<String> cbbThoiHan;
	private myCombobox<String> cbbChucVu;
	private ArrayList<Component> componentList;
	private String[] danhSachTinhThanhPho;
	private String [] danhSachQuanHuyen ;
	private String[] danhSachPhuongXa;
	private String [] danhSachDuong ;
	private String[] danhSachPhongBan;
	private String[] danhSachChucVu;
	private String image_file;
	private File img_local;
	private JLabel img;
	private String maNhanVienSua;
	private static final String[] cbbDanTocString = {"Không","Kinh","Tày","Ê-Đê","Chăm","Hoa","Khmer","Thái","Mường","Nùng","H'Mông","Gia Rai","Khác"};
	private static final String[] cbbChuyenMonString = {"Không","Cử nhân","Kĩ sư","Thạc sĩ","Tiến sĩ"};
	private static final String[] cbbTonGiaoString = {"Không","Phật giáo","Ki-tô giáo","Công giáo","Tin lành","Hòa Hảo","Cao Đài","Khác"};
	private static final String[] cbbHocVanString = {"Không","9/12","12/12"};
	private static final String[] cbbThoiHanString = {"1 năm","2 năm","3 năm","5 năm"};
	private static final Font font = new Font("Arial",1,13);
	private static final Color textColor = new Color(0,0,0,180);
	public employeeForm3_Cart1() {
		image_file = "none_user.jpg";
		img_local = null;
		danhSachTinhThanhPho = new String[]{};
		danhSachQuanHuyen = new String[] {};
		danhSachPhuongXa = new String[]{};
		danhSachDuong = new String[] {};
		danhSachPhongBan = new String[] {};
		init();
	}
	public void init() {
		this.setLayout(null);
		this.setBackground(Color.white);
		
		JLabel lb1 = new JLabel("THÊM HỒ SƠ NHÂN VIÊN");
		lb1.setFont(new Font("Arial",1,13));
		lb1.setForeground(textColor);
		lb1.setBounds(20,10,220,30);
		this.add(lb1);
		
		img = new  JLabel();
		img.setBorder(new LineBorder(new Color(0,0,0,80),2));
		img.setBounds(40,70,130,150);
		renderImage();
		this.add(img);
		
		JButton btnEditImg = new Button();
		btnEditImg.setText("Thay ảnh");
		btnEditImg.setFont(new Font("Arial",1,13));
		btnEditImg.setFocusable(false);
		btnEditImg.setBounds(58,240,100,35);
		this.add(btnEditImg);
		
		btnEditImg.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				System.out.println("đổi ảnh");
				JFileChooser jfc = new JFileChooser() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("unused")
					public String getDescription() {
						return "Image(JPG, PNG)";
					}
					public boolean accept(File f) {
						String name = f.getName();
						return f.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
					}
				};
				int flag = jfc.showOpenDialog(null);
				if(flag==jfc.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					img_local = file;
					renderImage(img_local.getAbsolutePath());
				}
			}
		});
		
		Font font = new Font("Roboto",1,12);
		// render title 
		String[] t1 = {"Mã nhân viên","Họ tên","Giới tính","Ngày sinh","Số điện thoại","Email"};
		for(int i=0;i<6;i++) {
			JLabel test = new JLabel(t1[i]);
			test.setFont(font);
			test.setBounds(220,40+i*70,170,30);
			test.setForeground(textColor);
			this.add(test);
		}
		String[] t2 = {"Tỉnh, thành phố","Quận, huyện","Phường, xã","Đường, ấp","Số nhà","Dân tộc","Tôn giáo"};
		for(int i=0;i<7;i++) {
			JLabel test = new JLabel(t2[i]);
			test.setFont(font);
			test.setBounds(440,40+i*70,170,30);
			test.setForeground(textColor);
			this.add(test);
		}
		String[] t3 = {"Số CMND","Ngày cấp","Nơi cấp","Trình độ học vấn","Trình độ chuyên môn","Chuyên ngành","Tình trạng hôn nhân"};
		for(int i=0;i<7;i++) {
			JLabel test = new JLabel(t3[i]);
			test.setFont(font);
			test.setBounds(660,40+i*70,170,30);
			test.setForeground(textColor);
			this.add(test);
		}
		String[] t4 = {"Phòng ban","Chức vụ","Ngày nhận chức","Loại hình làm việc"};
		for(int i=0;i<4;i++) {
			JLabel test = new JLabel(t4[i]);
			test.setFont(font);
			test.setBounds(880,40+i*70,170,30);
			test.setForeground(textColor);
			this.add(test);
		}
		tfMaSo = new JTextField();
		tfMaSo.setFont(font);
		tfMaSo.setBounds(220,70,170,30);
		tfMaSo.setForeground(textColor);
		this.add(tfMaSo);
		tfHoTen = new JTextField();
		tfHoTen.setFont(font);
		tfHoTen.setBounds(220,140,170,30);
		tfHoTen.setForeground(textColor);
		this.add(tfHoTen);
		cbbGioiTinh = new myCombobox<>();
		cbbGioiTinh.setFont(font);
		String[] str0 = {"Nam","Nữ"};
		cbbGioiTinh.setModel(new DefaultComboBoxModel<String>(str0));
		cbbGioiTinh.setBounds(220,210,170,30);
		cbbGioiTinh.setForeground(textColor);
		this.add(cbbGioiTinh);
		tfNgaySinh = new JTextField();
		tfNgaySinh.setFont(font);
		tfNgaySinh.setBounds(220,280,170,30);
		tfNgaySinh.setForeground(textColor);
		this.add(tfNgaySinh);
		dateChooser.DateChooser dc = new dateChooser.DateChooser();
		dc.setTextRefernce(tfNgaySinh);
		tfSoDienThoai = new JTextField();
		tfSoDienThoai.setFont(font);
		tfSoDienThoai.setBounds(220,350,170,30);
		tfSoDienThoai.setForeground(textColor);
		this.add(tfSoDienThoai);
		tfEmail = new JTextField();
		tfEmail.setFont(font);
		tfEmail.setForeground(textColor);
		tfEmail.setBounds(220,420,170,30);
		this.add(tfEmail);
		tfCmnd = new JTextField();
		tfCmnd.setFont(font);
		tfCmnd.setForeground(textColor);
		tfCmnd.setBounds(660,70,170,30);
		this.add(tfCmnd);
		tfNgayCapCMND = new JTextField();
		tfNgayCapCMND.setFont(font);
		tfNgayCapCMND.setForeground(textColor);
		tfNgayCapCMND.setBounds(660,140,170,30);
		this.add(tfNgayCapCMND);
		dateChooser.DateChooser dc1 = new dateChooser.DateChooser();
		dc1.setTextRefernce(tfNgayCapCMND);
		cbbNoiCapCMND = new myCombobox<>();
		cbbNoiCapCMND.setFont(new Font("Arial",0,14));
		cbbNoiCapCMND.setModel(new DefaultComboBoxModel<String>(danhSachTinhThanhPho));
		cbbNoiCapCMND.setFont(font);
		cbbNoiCapCMND.setForeground(textColor);
		cbbNoiCapCMND.setBounds(660,210,170,30);
		this.add(cbbNoiCapCMND);
		cbbDanToc = new myCombobox<>();
		cbbDanToc.setFont(font);
		cbbDanToc.setForeground(textColor);
		cbbDanToc.setModel(new DefaultComboBoxModel<String>(cbbDanTocString));
		cbbDanToc.setBounds(440,420,170,30);
		this.add(cbbDanToc);
		cbbTonGiao= new myCombobox<>();
		cbbTonGiao.setFont(font);
		cbbTonGiao.setForeground(textColor);
		cbbTonGiao.setModel(new DefaultComboBoxModel<String>(cbbTonGiaoString));
		cbbTonGiao.setBounds(440,490,170,30);
		this.add(cbbTonGiao);
		
		cbbTinhTrangHonNhan = new myCombobox<>();
		cbbTinhTrangHonNhan.setFont(font);
		String[] str3 = {"Độc thân","Lập gia đình"};
		cbbTinhTrangHonNhan.setForeground(textColor);
		cbbTinhTrangHonNhan.setModel(new DefaultComboBoxModel<String>(str3));
		cbbTinhTrangHonNhan.setBounds(660,490,170,30);
		this.add(cbbTinhTrangHonNhan);
		tfSoNha = new JTextField();
		tfSoNha.setFont(font);
		tfSoNha.setBounds(440,350,170,30);
		this.add(tfSoNha);
		tfSoNha.setForeground(textColor);
		cbbDuong = new myCombobox<>();
		cbbDuong.setFont(font);
		cbbDuong.setForeground(textColor);
		cbbDuong.setModel(new DefaultComboBoxModel<String>(danhSachDuong));
		cbbDuong.setBounds(440,280,170,30);
		this.add(cbbDuong);
		
		
		cbbPhuong = new myCombobox<>();
		cbbPhuong.setFont(font);
		cbbPhuong.setForeground(textColor);
		cbbPhuong.setModel(new DefaultComboBoxModel<String>(danhSachPhuongXa));
		cbbPhuong.setBounds(440,210,170,30);
		this.add(cbbPhuong);
		cbbQuan = new myCombobox<>();
		cbbQuan.setFont(font);
		cbbQuan.setForeground(textColor);
		cbbQuan.setModel(new DefaultComboBoxModel<String>(danhSachQuanHuyen));
		cbbQuan.setBounds(440,140,180,30);
		
		this.add(cbbQuan);
		
		cbbTinh = new myCombobox<>();
		cbbTinh.setFont(font);
		cbbTinh.setModel(new DefaultComboBoxModel<String>(danhSachTinhThanhPho));
		cbbTinh.setBounds(440,70,170,30);
		cbbTinh.setForeground(textColor);
		this.add(cbbTinh);
		
		cbbHocVan = new myCombobox<>();
		cbbHocVan.setFont(font);
		cbbHocVan.setForeground(textColor);
		cbbHocVan.setModel(new DefaultComboBoxModel<String>(cbbHocVanString));
		cbbHocVan.setBounds(660,280,170,30);
		this.add(cbbHocVan);
		cbbChuyenMon = new myCombobox<>();
		cbbChuyenMon.setFont(font);
		cbbChuyenMon.setForeground(textColor);
		cbbChuyenMon.setModel(new DefaultComboBoxModel<String>(cbbChuyenMonString));
		cbbChuyenMon.setBounds(660,350,170,30);
		this.add(cbbChuyenMon);
		
		tfChuyenNganh = new JTextField();
		tfChuyenNganh.setFont(font);
		tfChuyenNganh.setBounds(660,420,170,30);
		tfChuyenNganh.setForeground(textColor);
		this.add(tfChuyenNganh);
		
		cbbPhongBan = new myCombobox<>();
		cbbPhongBan.setFont(font);
		cbbPhongBan.setForeground(textColor);
		cbbPhongBan.setModel(new DefaultComboBoxModel<String>(danhSachPhongBan));
		cbbPhongBan.setBounds(880,70,170,30);
		this.add(cbbPhongBan);
		
		cbbChucVu = new myCombobox<>();
		cbbChucVu.setFont(font);
		cbbChucVu.setMaximumRowCount(5);
		cbbChucVu.setBounds(880,140,170,30);
		cbbChucVu.setForeground(textColor);
		this.add(cbbChucVu);
		
		tfNgayNhanChuc = new JTextField();
		tfNgayNhanChuc.setBounds(880,210,170,30);
		tfNgayNhanChuc.setFont(font);
		tfNgayNhanChuc.setForeground(textColor);
		this.add(tfNgayNhanChuc);
		dateChooser.DateChooser dc222 = new dateChooser.DateChooser();
		dc222.setTextRefernce(tfNgayNhanChuc);
		
		cbbLoaiHinh = new myCombobox<>();
		cbbLoaiHinh.setFont(font);
		String[] str11 = {"Nhân viên chính thức","Nhân viên thử việc"};
		cbbLoaiHinh.setModel(new DefaultComboBoxModel<String>(str11));
		cbbLoaiHinh.setForeground(textColor);
		cbbLoaiHinh.setBounds(880,280,170,30);
		this.add(cbbLoaiHinh);
		JLabel lbngaybatdau= new JLabel("Ngày bắt đầu làm việc");
		lbngaybatdau.setFont(font);
		lbngaybatdau.setBounds(880,320,170,30);
		lbngaybatdau.setForeground(textColor);
		this.add(lbngaybatdau);
		tfNgayBatDau = new JTextField();
		tfNgayBatDau.setBounds(880,350,170,30);
		tfNgayBatDau.setForeground(textColor);
		tfNgayBatDau.setFont(font);
		this.add(tfNgayBatDau);
		dateChooser.DateChooser dc2 = new dateChooser.DateChooser();
		dc2.setTextRefernce(tfNgayBatDau);
		// 
		JLabel lbngayketthuc= new JLabel("Thời hạn hợp đồng");
		lbngayketthuc.setForeground(textColor);
		lbngayketthuc.setFont(font);
		lbngayketthuc.setBounds(880,390,170,30);
		this.add(lbngayketthuc);
		tfNgayKetThuc = new JTextField();
		tfNgayKetThuc.setBounds(880,420,170,30);
		tfNgayKetThuc.setForeground(textColor);
		tfNgayKetThuc.setFont(font);
		this.add(tfNgayKetThuc);
		dateChooser.DateChooser dc22 = new dateChooser.DateChooser();
		dc22.setTextRefernce(tfNgayKetThuc);
		tfNgayKetThuc.setFont(font);
		tfNgayKetThuc.setVisible(false);
		
		cbbThoiHan = new myCombobox<>();
		cbbThoiHan.setFont(new Font("Arial",0,14));
		cbbThoiHan.setForeground(textColor);
		cbbThoiHan.setModel(new DefaultComboBoxModel<String>(cbbThoiHanString));
		cbbThoiHan.setBounds(880,420,170,30);
		cbbThoiHan.setFont(font);
		this.add(cbbThoiHan);
		
		JLabel lbmucluong= new JLabel("Mức lương");
		lbmucluong.setForeground(textColor);
		lbmucluong.setFont(font);
		lbmucluong.setBounds(880,460,170,30);
		this.add(lbmucluong);
		tfMucLuong = new JTextField();
		tfMucLuong.setFont(new Font("Arial",0,14));
		tfMucLuong.setBounds(880,490,170,30);
		tfMucLuong.setFont(font);
		tfMucLuong.setForeground(textColor);
		this.add(tfMucLuong);
		
		
		cbbLoaiHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbbLoaiHinh.getSelectedIndex()==1) {
					lbngaybatdau.setText("Ngày bắt đầu thử việc");
					lbngayketthuc.setText("Ngày kết thúc thử việc");
					lbmucluong.setText("Lương thử việc:");
					tfNgayKetThuc.setVisible(true);
					
				}else {
					lbngaybatdau.setText("Ngày bắt đầu làm việc");
					lbngayketthuc.setText("Thời hạn hợp đồng");
					lbmucluong.setText("Mức lương");
					tfNgayKetThuc.setVisible(false);
				}
			}
		});
		cbbHocVan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbbHocVan.getSelectedIndex()!=2) {
					cbbChuyenMon.setEnabled(false);
					cbbChuyenMon.setSelectedIndex(0);
					tfChuyenNganh.setEnabled(false);
					
				}else {
					cbbChuyenMon.setEnabled(true);
				}
			}
		});
		cbbChuyenMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbbChuyenMon.getSelectedIndex()==0) {
					tfChuyenNganh.setEnabled(false);
					tfChuyenNganh.setText("Không");
				}else {
					tfChuyenNganh.setEnabled(true);
				}
			}
		});
		cbbChuyenMon.setEnabled(false);
		tfChuyenNganh.setEnabled(false);
		tfChuyenNganh.setText("Không");
		// Button reset
		btnReset = new Button();
		btnReset.setText("Reset");
		btnReset.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/reset.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		btnReset.setFont(new Font("Arial",1,13));
		btnReset.setBounds(840,550,100,40);
		btnReset.setForeground(Color.white);
		btnReset.setFocusable(false);
		btnReset.setBackground(Color.decode("#95a5a6"));
		this.add(btnReset);
		// Button huy
		btnHuy = new Button();
		btnHuy.setText("Hủy");
		btnHuy.setFont(new Font("Arial",1,13));
		btnHuy.setBounds(840,550,100,40);
		btnHuy.setForeground(Color.white);
		btnHuy.setBackground(Color.decode("#95a5a6"));
		btnHuy.setFocusable(false);
		this.add(btnHuy);
		btnHuy.setVisible(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnThem = new Button();
		btnThem.setIcon(new ImageIcon(getClass().getResource("/assets/img/addemployee2.png")));
		btnThem.setFont(new Font("Arial",1,13));
		btnThem.setForeground(Color.white);
		btnThem.setBackground(Color.decode("#4cd137"));
		btnThem.setFocusable(false);
		btnThem.setBounds(950,550,100,40);
		btnThem.setText("Thêm");
		this.add(btnThem);
		// Button Lưu
		btnLuu = new Button();
		btnLuu.setText("Lưu");
		btnLuu.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		btnLuu.setFont(new Font("Arial",1,13));
		btnLuu.setForeground(Color.white);
		btnLuu.setBackground(Color.decode("#44bd32"));
		btnLuu.setFocusable(false);
		btnLuu.setBounds(950,550,100,40);
		
		this.add(btnLuu);
		btnLuu.setVisible(false);
		//
		
		
		
		
		componentList = new ArrayList<>();
		componentList.add(tfMaSo);
		componentList.add(tfHoTen);
		componentList.add(cbbGioiTinh);
		componentList.add(tfNgaySinh);
		componentList.add(tfSoDienThoai);
		componentList.add(tfEmail);
		
		componentList.add(tfSoNha);
		componentList.add(cbbDuong);
		componentList.add(cbbPhuong);
		componentList.add(cbbQuan);
		componentList.add(cbbTinh);
		componentList.add(cbbHocVan);
		componentList.add(cbbChuyenMon);
		componentList.add(tfChuyenNganh);
		
		componentList.add(tfCmnd);
		componentList.add(tfNgayCapCMND);
		componentList.add(cbbNoiCapCMND);
		componentList.add(cbbDanToc);
		componentList.add(cbbTonGiao);
		componentList.add(cbbTinhTrangHonNhan);
		componentList.add(cbbPhongBan);
		componentList.add(cbbChucVu);
		componentList.add(tfNgayNhanChuc);
		componentList.add(cbbLoaiHinh);
		componentList.add(tfNgayBatDau);
		componentList.add(cbbThoiHan);
		componentList.add(tfNgayKetThuc);
		componentList.add(tfMucLuong);
		
		
		
	}
	public ArrayList<Component> getComponentList(){
		return this.componentList;
	}
	public void renderImage() {
		img.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+image_file)).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)));
	}
	public void renderImage(String path) {
		img.setIcon(new ImageIcon(new ImageIcon(new File(path).getAbsolutePath()).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)));
	}
	public JButton getBtnThem() {
		return this.btnThem;
	}
	public JButton getBtnLuu() {
		return this.btnLuu;
	}
	public JButton getBtnHuy() {
		return this.btnHuy;
	}
	public JButton getBtnReset() {
		return this.btnReset;
	}
	public myCombobox<String> getCbbTinhThanhPho(){
		return this.cbbTinh;
	}
	public myCombobox<String> getCbbQuanHuyen(){
		return this.cbbQuan;
	}
	public myCombobox<String> getCbbPhuongXa(){
		return this.cbbPhuong;
	}
	public void setDanhSachPhongBan(String []ds) {
		this.danhSachPhongBan = ds;
		cbbPhongBan.setModel(new DefaultComboBoxModel<String>(danhSachPhongBan));
	}
	public void setDanhSachChucVu(String []ds) {
		this.danhSachChucVu =ds;
		cbbChucVu.setModel(new DefaultComboBoxModel<>(danhSachChucVu));
	}
	public void setDanhSachTinhThanhPho(String []ds) {
		this.danhSachTinhThanhPho = ds;
		cbbNoiCapCMND.setModel(new DefaultComboBoxModel<String>(danhSachTinhThanhPho));
		cbbTinh.setModel(new DefaultComboBoxModel<String>(danhSachTinhThanhPho));
	}
	public void setDanhSachQuanHuyen(String[] ds) {
		this.danhSachQuanHuyen = ds;
		cbbQuan.setModel(new DefaultComboBoxModel<String>(danhSachQuanHuyen));
	}
	public void setDanhSachPhuongXa(String[] ds) {
		this.danhSachPhuongXa = ds;
		cbbPhuong.setModel(new DefaultComboBoxModel<String>(danhSachPhuongXa));
	}
	public void setDanhSachDuong(String[] ds) {
		this.danhSachDuong = ds;
		cbbDuong.setModel(new DefaultComboBoxModel<String>(danhSachDuong));
	}
	@SuppressWarnings("unchecked")
	public String[] getDataFromForm() {
		String str[] = new String[29];
		for(int i=0;i<28;i++) {
			if(componentList.get(i) instanceof JTextField) {
				str[i] = ((JTextField)componentList.get(i)).getText().trim();
			}else {
				str[i] = ((myCombobox<String>)componentList.get(i)).getSelectedItem().toString().trim();
			}
		}
		str[28] = image_file;
		
		return str;
	}
	public void reset() {
		image_file = "none_user.jpg";
		tfMaSo.setText("");
		tfHoTen.setText("");
		tfSoDienThoai.setText("");
		tfSoNha.setText("");
		tfCmnd.setText("");
		tfMucLuong.setText("");
		tfEmail.setText("");
		tfChuyenNganh.setText("");
		cbbGioiTinh.setSelectedIndex(0);
		cbbTinhTrangHonNhan.setSelectedIndex(0);
		cbbPhongBan.setSelectedIndex(0);
		cbbChucVu.setSelectedIndex(0);
		cbbDanToc.setSelectedIndex(0);
		cbbTonGiao.setSelectedIndex(0);
		cbbThoiHan.setSelectedIndex(0);
		cbbHocVan.setSelectedIndex(0);
		cbbChuyenMon.setSelectedIndex(0);
		cbbNoiCapCMND.setSelectedIndex(0);
		cbbTinh.setSelectedIndex(0);
		cbbQuan.setSelectedIndex(0);
		cbbPhuong.setSelectedIndex(0);
		renderImage();
	}
	public void loadImageIntoProject() {
		if(img_local!=null) {
			URL temp = getClass().getResource("/assets/");
			String rutgon = temp.toString().substring(5,temp.toString().length()-11); // /QLNS/
			String path_of = rutgon+"src/assets/img/user_img/";
			int file_length = img_local.getAbsolutePath().toString().length();
			String file_tail = img_local.getAbsolutePath().toString().substring(file_length-4);
			try {
				String rd = SUPPORT.ranDomString(20);
				
				Files.copy(img_local.toPath(), new File(path_of+rd+file_tail).toPath(),StandardCopyOption.REPLACE_EXISTING);
				Files.copy(img_local.toPath(), new File(rutgon+"bin/assets/img/user_img/"+rd+file_tail).toPath(),StandardCopyOption.REPLACE_EXISTING);
				image_file = rd+file_tail;
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	public void setEnableModeFix(boolean mode) {
		componentList.get(20).setEnabled(mode);
		componentList.get(21).setEnabled(mode);
		componentList.get(23).setEnabled(mode);
		componentList.get(24).setEnabled(mode);
		componentList.get(25).setEnabled(mode);
		componentList.get(26).setEnabled(mode);
		componentList.get(27).setEnabled(mode);
	}
	@SuppressWarnings("unchecked")
	public void setDataToFix(String str[]) {
		setEnableModeFix(false);
		btnHuy.setVisible(true);
		btnLuu.setVisible(true);
		btnReset.setVisible(false);
		btnThem.setVisible(false);
		((JTextField)componentList.get(0)).setText(str[0]);
		((JTextField)componentList.get(1)).setText(str[1]);
		((JTextField)componentList.get(3)).setText(str[3]);
		((JTextField)componentList.get(4)).setText(str[4]);
		((JTextField)componentList.get(5)).setText(str[5]);
		((JTextField)componentList.get(6)).setText(str[6]);
		((JTextField)componentList.get(13)).setText(str[13]);
		((JTextField)componentList.get(14)).setText(str[14]);
		((JTextField)componentList.get(15)).setText(str[15]);
		((JTextField)componentList.get(22)).setText(str[22]);
		((JTextField)componentList.get(27)).setText(str[26]);
		((JTextField)componentList.get(24)).setText(str[24]);

		if(str[2].equals("Nam")) {
			((myCombobox<String>)componentList.get(2)).setSelectedIndex(0);
		}else {
			((myCombobox<String>)componentList.get(2)).setSelectedIndex(1);
		}
		
		if(str[23].equals("Nhân viên chính thức")) {
			((myCombobox<String>)componentList.get(23)).setSelectedIndex(0);
			for(int i=0;i<cbbThoiHanString.length;i++) {
				if(str[25].equals(cbbThoiHanString[i])) {
					((myCombobox<String>)componentList.get(25)).setSelectedIndex(i);
					break;
				}
			}
		}else {
			((myCombobox<String>)componentList.get(23)).setSelectedIndex(1);
			((JTextField)componentList.get(26)).setText(str[25]);
		}
		
		if(str[19].equals("Độc thân")) {
			((myCombobox<String>)componentList.get(19)).setSelectedIndex(0);
		}else {
			((myCombobox<String>)componentList.get(19)).setSelectedIndex(1);
		}
		
		for(int i=0;i<cbbHocVanString.length;i++) {
			if(str[11].equals(cbbHocVanString[i])) {
				((myCombobox<String>)componentList.get(11)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<cbbChuyenMonString.length;i++) {
			if(str[12].equals(cbbChuyenMonString[i])) {
				((myCombobox<String>)componentList.get(12)).setSelectedIndex(i);
				break;
			}
		}
		
		for(int i=0;i<cbbDanTocString.length;i++) {
			if(str[17].equals(cbbDanTocString[i])) {
				((myCombobox<String>)componentList.get(17)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<cbbTonGiaoString.length;i++) {
			if(str[18].equals(cbbTonGiaoString[i])) {
				((myCombobox<String>)componentList.get(18)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachPhongBan.length;i++) {
			if(str[20].equals(danhSachPhongBan[i])) {
				((myCombobox<String>)componentList.get(20)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachChucVu.length;i++) {
			if(str[21].equals(danhSachChucVu[i])) {
				((myCombobox<String>)componentList.get(21)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachDuong.length;i++) {
			if(str[7].equals(danhSachDuong[i])) {
				((myCombobox<String>)componentList.get(7)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachPhuongXa.length;i++) {
			if(str[8].equals(danhSachPhuongXa[i])) {
				((myCombobox<String>)componentList.get(8)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachQuanHuyen.length;i++) {
			if(str[9].equals(danhSachQuanHuyen[i])) {
				((myCombobox<String>)componentList.get(9)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachTinhThanhPho.length;i++) {
			if(str[10].equals(danhSachTinhThanhPho[i])) {
				((myCombobox<String>)componentList.get(10)).setSelectedIndex(i);
				break;
			}
		}
		for(int i=0;i<danhSachTinhThanhPho.length;i++) {
			if(str[16].equals(danhSachTinhThanhPho[i])) {
				((myCombobox<String>)componentList.get(16)).setSelectedIndex(i);
				break;
			}
		}
		
		image_file = str[27];
		renderImage();



	}
	public void setMaNhanVienSua(String maNhanVienSua) {
		this.maNhanVienSua = maNhanVienSua;
	}
	public String getMaNhanVienSua() {
		return this.maNhanVienSua;
	}
}
