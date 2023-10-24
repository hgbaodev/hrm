package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAO.access_CHUCVUCONGTY;
import DTO.SUPPORT;
import dateChooser.DateChooser;



public class UngVienView_Them extends JFrame {
	private JButton button_dong;
	private JButton button_luu;
	private JTextField textField_NgaySinh;
	private JTextField textField_MaUngVien;
	private JTextField textField_HoTen;
	private JTextField textField_CMND;
	private JTextField textField_SDT;
	private JTextField textField_Email;
	private JTextField textField_MucLuongDeal;
	private JComboBox<String> cbbNoiCap;
	private JTextField textField_NgayCap;
	private JComboBox<String> cbbTinhThanhPho;
	private JComboBox<String> cbbQuanHuyen;
	private JComboBox<String> cbbPhuongXa;
	private JComboBox<String> cbbDuong;
	private JTextField textField_DiaChi;
	private JComboBox<String> comboBox_MaTuyenDung;
	private JComboBox<String> comboBox_GioiTinh;
	private JComboBox<String> comboBox_TinhTrangHonNhan;
	private JComboBox<String> comboBox_TonGiao;
	private JComboBox<String> comboBox_HocVan;
	private JComboBox<String> comboBox_DanToc;
	private JComboBox<String> comboBox_TrinhDoChuyenMon;
	private JTextField tfChuyenNganh;
	private JLabel label_alert_MaUngVien;
	private JLabel label_HoTen;
	private JLabel label_NgaySinh;
	private JLabel label_GioiTinh;
	private JLabel label_Email;
	
	public void init() {
		this.setSize(930,600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);// JFrame không có thanh tiêu đề
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(Color.white);
		panelContent.setBorder(new LineBorder(Color.decode("#2980b9"),3));
		panelContent.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(panelContent);
		panelContent.setLayout(null);
        
		JLabel label_Title= new JLabel("Thêm ứng viên");
		label_Title.setFont(new Font("Arial",1,18));
		label_Title.setForeground(Color.decode("#3498db"));
		panelContent.add(label_Title);
		label_Title.setBounds(82,41,230,30);


		JLabel label_img= new JLabel();
		label_img.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/adduv.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		panelContent.add(label_img);
		label_img.setBounds(40,35,40,40);
		
		button_dong= new JButton("Đóng");
		panelContent.add(button_dong);
		button_dong.setBounds(700,530,90,30);
		button_dong.setForeground(new Color(0,128,255));
		button_dong.setHorizontalAlignment(SwingConstants.LEFT);
		button_dong.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/3.png")).getImage().getScaledInstance(23, 20, Image.SCALE_DEFAULT)));

		

		button_luu=new JButton("Lưu");
		panelContent.add(button_luu);
		button_luu.setBounds(810,530,80,30);
		button_luu.setForeground(new Color(0,128,255));
		button_luu.setHorizontalAlignment(SwingConstants.LEFT);
		button_luu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/2.png")).getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT)));
		
		JLabel label_MaTuyenDung = new JLabel("Mã tuyển dụng");
		label_MaTuyenDung.setFont(new Font("Arial", 0, 15));
		panelContent.add(label_MaTuyenDung);
		label_MaTuyenDung.setBounds(50,100,230,30);

		comboBox_MaTuyenDung= new myCombobox<String>();
		panelContent.add(comboBox_MaTuyenDung);
		comboBox_MaTuyenDung.setBounds(50,130,170,30);
		comboBox_MaTuyenDung.setFont(new Font("Arial",1,12));

		JLabel label_MaUngVien = new JLabel("Mã ứng viên");
		panelContent.add(label_MaUngVien);
		label_MaUngVien.setFont(new Font("Arial",0,15));
		label_MaUngVien.setBounds(50,170,230,30);
		
		
		textField_MaUngVien= new JTextField();
		panelContent.add(textField_MaUngVien);
		textField_MaUngVien.setBounds(50,200,170,30);
		textField_MaUngVien.setFont(new Font("Arial",1,12));
		
		label_alert_MaUngVien= new JLabel(" ");	
		label_alert_MaUngVien.setForeground(Color.red);
		label_alert_MaUngVien.setBounds(50,230,170,30);
		panelContent.add(label_alert_MaUngVien);
	
		 label_HoTen = new JLabel("Họ tên");
		 panelContent.add(label_HoTen);
		label_HoTen.setFont(new Font("Arial",0,15));
		label_HoTen.setBounds(50,240,220,20);

		textField_HoTen= new JTextField();
		panelContent.add(textField_HoTen);
		textField_HoTen.setBounds(50,270,170,30);
		textField_HoTen.setFont(new Font("Arial",1,12));
		 label_NgaySinh = new JLabel("Ngày sinh");
		 panelContent.add(label_NgaySinh);
		label_NgaySinh.setFont(new Font("Arial",0,15));
		label_NgaySinh.setBounds(50,380,170,30);
		

		textField_NgaySinh= new JTextField();
		panelContent.add(textField_NgaySinh);
		textField_NgaySinh.setBounds(50,410,170,30);
		textField_NgaySinh.setFont(new Font("Arial",1,12));
		
		DateChooser dccc = new DateChooser();
		dccc.setTextRefernce(textField_NgaySinh);
		
		 label_GioiTinh = new JLabel("Giới tính");
		 panelContent.add(label_GioiTinh);
		label_GioiTinh.setFont(new Font("Arial",0,15));
		label_GioiTinh.setBounds(50,310,230,30);

		comboBox_GioiTinh= new myCombobox<String>();
		String[] gioitinh= {"Nam","Nữ"};
		comboBox_GioiTinh.setModel(new DefaultComboBoxModel<>(gioitinh));
		panelContent.add(comboBox_GioiTinh);
		comboBox_GioiTinh.setBounds(50,340,170,30);
		comboBox_GioiTinh.setFont(new Font("Arial",1,12));
		
		
		
		 label_Email = new JLabel("Email");
		 panelContent.add(label_Email);
		label_Email.setFont(new Font("Arial",1,12));
		label_Email.setBounds(270,100,230,30);

		textField_Email= new JTextField();
		panelContent.add(textField_Email);
		textField_Email.setBounds(270,130,170,30);
		textField_Email.setFont(new Font("Arial",1,12));
		
		JLabel label_SDT = new JLabel("Số điện thoại");
		label_SDT.setFont(new Font("Arial",1,15));
		panelContent.add(label_SDT);
		label_SDT.setBounds(50,450,230,30);
		

		textField_SDT= new JTextField();
		panelContent.add(textField_SDT);
		textField_SDT.setBounds(50,480,170,30);
		textField_SDT.setFont(new Font("Arial",1,12));

		JLabel label_CMND = new JLabel("CMND/CCCD");
		panelContent.add(label_CMND);
		label_CMND.setFont(new Font("Arial",0,15));
		label_CMND.setBounds(270,170,230,30);
		
		textField_CMND= new JTextField();
		panelContent.add(textField_CMND);
		textField_CMND.setBounds(270,200,170,30);
		textField_CMND.setFont(new Font("Arial",1,12));
		
		JLabel label_TinhTrangHonNhan = new JLabel("Tình trạng hôn nhân");
		panelContent.add(label_TinhTrangHonNhan);
		label_TinhTrangHonNhan.setFont(new Font("Arial",0,15));
		label_TinhTrangHonNhan.setBounds(490,450,230,30);

		
		comboBox_TinhTrangHonNhan= new myCombobox<String>();
		String[] tinhtrang= {"Độc thân","Đã kết hôn"};
		comboBox_TinhTrangHonNhan.setModel(new DefaultComboBoxModel<>(tinhtrang));
		panelContent.add(comboBox_TinhTrangHonNhan);
		comboBox_TinhTrangHonNhan.setBounds(490,480,170,30);
		comboBox_TinhTrangHonNhan.setFont(new Font("Arial",1,12));


		JLabel label_NoiCap = new JLabel("Nơi cấp");
		panelContent.add(label_NoiCap);
		label_NoiCap.setFont(new Font("Arial",0,15));
		label_NoiCap.setBounds(270,310,230,30);

		cbbNoiCap= new myCombobox<String>();
		panelContent.add(cbbNoiCap);
		cbbNoiCap.setBounds(270,340,170,30);
		cbbNoiCap.setFont(new Font("Arial",1,12));
		
		JLabel label_NgayCap = new JLabel("Ngày cấp");
		panelContent.add(label_NgayCap);
		label_NgayCap.setFont(new Font("Arial",0,15));
		label_NgayCap.setBounds(270,240,200,30);

		textField_NgayCap= new JTextField();
		panelContent.add(textField_NgayCap);
		textField_NgayCap.setBounds(270,270,170,30);
		DateChooser dc = new DateChooser();
		dc.setTextRefernce(textField_NgayCap);
		textField_NgayCap.setFont(new Font("Arial",1,12));
		
		JLabel label_DanToc= new JLabel("Dân tộc");
		panelContent.add(label_DanToc);
		label_DanToc.setFont(new Font("Arial",0,15));
		label_DanToc.setBounds(270,380,230,30);

		comboBox_DanToc= new myCombobox<String>();
		String[] dantoc = {"Không","Kinh","Tày","Ê-Đê","Chăm","Hoa","Khmer","Thái","Mường","Nùng","H'Mông","Gia Rai","Khác"};
		comboBox_DanToc.setModel(new DefaultComboBoxModel<String>(dantoc));
		panelContent.add(comboBox_DanToc);
		comboBox_DanToc.setBounds(270,410,170,30);
		comboBox_DanToc.setFont(new Font("Arial",1,12));
		
		JLabel label_Tinh = new JLabel("Tỉnh");
		panelContent.add(label_Tinh);
		label_Tinh.setFont(new Font("Arial",0,15));
		label_Tinh.setBounds(490,100,230,30);

		cbbTinhThanhPho= new myCombobox<String>();
		panelContent.add(cbbTinhThanhPho);
		cbbTinhThanhPho.setBounds(490,130,170,30);
		cbbTinhThanhPho.setFont(new Font("Arial",1,12));
		
		JLabel label_Huyen = new JLabel("Huyện");
		panelContent.add(label_Huyen);
		label_Huyen.setFont(new Font("Arial",0,15));
		label_Huyen.setBounds(490,170,170,30);

		cbbQuanHuyen= new myCombobox<String>();
		panelContent.add(cbbQuanHuyen);
		cbbQuanHuyen.setBounds(490,200,170,30);
		cbbQuanHuyen.setFont(new Font("Arial",1,12));
		
		JLabel label_Xa = new JLabel("Xã");
		panelContent.add(label_Xa);
		label_Xa.setFont(new Font("Arial",0,15));
		label_Xa.setBounds(490,240,170,30);

		cbbPhuongXa= new myCombobox<String>();
		panelContent.add(cbbPhuongXa);
		cbbPhuongXa.setBounds(490,270,170,30);
		cbbPhuongXa.setFont(new Font("Arial",1,12));
		
		JLabel label_Duong = new JLabel("Đường");
		panelContent.add(label_Duong);
		label_Duong.setFont(new Font("Arial",0,15));
		label_Duong.setBounds(490,310,230,30);

		cbbDuong= new myCombobox<String>();
		panelContent.add(cbbDuong);
		cbbDuong.setBounds(490,340,170,30);
		cbbDuong.setFont(new Font("Arial",1,12));
		
		JLabel label_DiaChi = new JLabel("Số nhà");
		panelContent.add(label_DiaChi);
		label_DiaChi.setFont(new Font("Arial",0,15));
		label_DiaChi.setBounds(490,380,230,30);

		textField_DiaChi= new JTextField();
		panelContent.add(textField_DiaChi);
		textField_DiaChi.setBounds(490,410,170,30);
		textField_DiaChi.setFont(new Font("Arial",1,12));

		JLabel label_TonGiao = new JLabel("Tôn Giáo");
		panelContent.add(label_TonGiao);
		label_TonGiao.setFont(new Font("Arial",0,15));
		label_TonGiao.setBounds(270,450,230,30);

		String[] tongiao= {"Không","Phật giáo","Ki-tô giáo","Công giáo","Tin lành","Hòa Hảo","Cao Đài","Khác"};
		comboBox_TonGiao= new myCombobox<String>();
		comboBox_TonGiao.setModel(new DefaultComboBoxModel<>(tongiao));
		panelContent.add(comboBox_TonGiao);
		comboBox_TonGiao.setBounds(270,480,170,30);
		comboBox_TonGiao.setFont(new Font("Arial",1,12));

		JLabel label_TrinhDoHocVan = new JLabel("Trình độ học vấn");
		panelContent.add(label_TrinhDoHocVan);
		label_TrinhDoHocVan.setFont(new Font("Arial",0,15));
		label_TrinhDoHocVan.setBounds(710,100,230,30);

		String[] hocvan= {"Không","9/12","12/12"};
		comboBox_HocVan= new myCombobox<String>();
		comboBox_HocVan.setModel(new DefaultComboBoxModel<>(hocvan));
		panelContent.add(comboBox_HocVan);
		comboBox_HocVan.setBounds(710,130,170,30);
		comboBox_HocVan.setFont(new Font("Arial",1,12));
		
		JLabel label_TrinhDoChuyenMon= new JLabel("Trình độ chuyên môn");
		panelContent.add(label_TrinhDoChuyenMon);
		label_TrinhDoChuyenMon.setFont(new Font("Arial",0,15));
		label_TrinhDoChuyenMon.setBounds(710,170,170,30);

		String[] chuyenmon= {"Không","Cử nhân","Kĩ sư","Thạc sĩ","Tiến Sĩ"};
		comboBox_TrinhDoChuyenMon= new myCombobox<String>();
		comboBox_TrinhDoChuyenMon.setModel(new DefaultComboBoxModel<>(chuyenmon));
		panelContent.add(comboBox_TrinhDoChuyenMon);
		comboBox_TrinhDoChuyenMon.setBounds(710,200,170,30);
		comboBox_TrinhDoChuyenMon.setFont(new Font("Arial",1,12));
		
		JLabel label_ChuyenNganh = new JLabel("Chuyên ngành");
		panelContent.add(label_ChuyenNganh);
		label_ChuyenNganh.setFont(new Font("Arial",0,15));
		label_ChuyenNganh.setBounds(710,240,230,30);

		tfChuyenNganh= new JTextField();
		tfChuyenNganh.setBounds(710,270,170,30);
		panelContent.add(tfChuyenNganh);
		tfChuyenNganh.setFont(new Font("Arial",1,12));
		tfChuyenNganh.setText("Không");
		

		
		JLabel label_MucLuongDeal = new JLabel("Mức lương Deal");
		panelContent.add(label_MucLuongDeal);
		label_MucLuongDeal.setFont(new Font("Arial",0,15));
		label_MucLuongDeal.setBounds(710,310,230,30);

		textField_MucLuongDeal= new JTextField();
		panelContent.add(textField_MucLuongDeal);
		textField_MucLuongDeal.setBounds(710,340,170,30);
		textField_MucLuongDeal.setFont(new Font("Arial",1,12));
		// ràng buộc về trình độ ứng viên
		rangBuocTrinhDo();
	}
	
	public UngVienView_Them() {
		init();
	}
	public void setDataCbbMaTuyenDung(String str[]) {
		comboBox_MaTuyenDung.setModel(new DefaultComboBoxModel<>(str));
	}
	public void setDataCbbTinhThanhPho(String data[]) {
		cbbTinhThanhPho.setModel(new DefaultComboBoxModel<>(data));
	}
	public void setDataCbbQuanHuyen(String data[]) {
		cbbQuanHuyen.setModel(new DefaultComboBoxModel<>(data));
	}
	public void setDataCbbPhuongXa(String data[]) {
		cbbPhuongXa.setModel(new DefaultComboBoxModel<>(data));
	}
	public void setDataCbbDuong(String data[]) {
		cbbDuong.setModel(new DefaultComboBoxModel<>(data));
	}
	public void setDataCbbNoiCap(String str[]) {
		cbbNoiCap.setModel(new DefaultComboBoxModel<>(str));
	}
	public JButton getButton_dong() {
		return button_dong;
	}
	public JButton getButton_luu() {
		return button_luu;
	}
	public String[] getDataToAdd() {
		String[] data = {
			comboBox_MaTuyenDung.getSelectedItem().toString(),
			textField_MaUngVien.getText(),
			textField_HoTen.getText(),
			comboBox_GioiTinh.getSelectedItem().toString(),
			textField_NgaySinh.getText(),
			textField_SDT.getText(),
			textField_Email.getText(),
			textField_CMND.getText(),
			textField_NgayCap.getText(),
			cbbNoiCap.getSelectedItem().toString(),
			comboBox_DanToc.getSelectedItem().toString(),
			comboBox_TonGiao.getSelectedItem().toString(),
			cbbTinhThanhPho.getSelectedItem().toString(),
			cbbQuanHuyen.getSelectedItem().toString(),
			cbbPhuongXa.getSelectedItem().toString(),
			cbbDuong.getSelectedItem().toString(),
			textField_DiaChi.getText(),
			comboBox_TinhTrangHonNhan.getSelectedItem().toString(),
			comboBox_HocVan.getSelectedItem().toString(),
			comboBox_TrinhDoChuyenMon.getSelectedItem().toString(),
			tfChuyenNganh.getText(),
			textField_MucLuongDeal.getText(),
		};
		return data;
	}
	public void reset() {
		comboBox_MaTuyenDung.setSelectedIndex(0);
		textField_MaUngVien.setText("");
		textField_HoTen.setText("");
		comboBox_GioiTinh.setSelectedIndex(0);
		textField_NgaySinh.setText(SUPPORT.LocalDateToString(LocalDate.now()));
		textField_SDT.setText("");
		textField_Email.setText("");
		textField_CMND.setText("");
		textField_NgayCap.setText(SUPPORT.LocalDateToString(LocalDate.now()));
		cbbNoiCap.setSelectedIndex(0);
		comboBox_DanToc.setSelectedIndex(0);
		comboBox_TonGiao.setSelectedIndex(0);
		cbbTinhThanhPho.setSelectedIndex(0);
		cbbQuanHuyen.setSelectedIndex(0);
		cbbPhuongXa.setSelectedIndex(0);
		cbbDuong.setSelectedIndex(0);
		textField_DiaChi.setText("");
		comboBox_TinhTrangHonNhan.setSelectedIndex(0);
		comboBox_HocVan.setSelectedIndex(0);
		comboBox_TrinhDoChuyenMon.setSelectedIndex(0);
		tfChuyenNganh.setText("Không");
		textField_MucLuongDeal.setText("");
	}
	public void rangBuocTrinhDo() {
		comboBox_HocVan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_HocVan.getSelectedIndex()!=2) {
					comboBox_TrinhDoChuyenMon.setEnabled(false);
					comboBox_TrinhDoChuyenMon.setSelectedIndex(0);
					tfChuyenNganh.setEnabled(false);
					tfChuyenNganh.setText("Không");
				}else {
					comboBox_TrinhDoChuyenMon.setEnabled(true);
				}
			}
		});
		comboBox_TrinhDoChuyenMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_TrinhDoChuyenMon.getSelectedIndex()==0) {
					tfChuyenNganh.setEnabled(false);
					tfChuyenNganh.setText("Không");
				}else {
					tfChuyenNganh.setEnabled(true);
					tfChuyenNganh.setText("");
				}
			}
		});
		comboBox_TrinhDoChuyenMon.setEnabled(false);
		tfChuyenNganh.setEnabled(false);
	}
	public JComboBox<String> getCbbTinhThanhPho(){
		return this.cbbTinhThanhPho;
	}
	public JComboBox<String> getCbbQuanHuyen(){
		return this.cbbQuanHuyen;
	}
	public JComboBox<String> getCbbPhuongXa(){
		return this.cbbPhuongXa;
	}
	public JComboBox<String> getCbbDuong(){
		return this.cbbDuong;
	}
	
}
