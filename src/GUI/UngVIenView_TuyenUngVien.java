package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.access_PHONGBAN;
import dateChooser.DateChooser;
import view.button.Button;


public class UngVIenView_TuyenUngVien extends JFrame{
	private JButton button_dong;
	private JButton button_luu;
	private JTextField textField_MaNhanVien;
	private JTextField textField_NgayBatDauThuViec;
	private JTextField textField_NgayKetThucThuViec;
	private JComboBox<String> comboBox_PhongBan;
	private JLabel label_avt;
	private JComboBox<String> thuviec_chinhthuc;
	private JComboBox<String> comboBox_hopdong;
	private JTextField textField_NgayBatDauHopDong;
//	private JLabel label_alert_maNhanVien;
	private ArrayList<JLabel> listlabel;
	private String data[];
	private ArrayList<JComponent> listCombonentBoSung;
	private JComboBox<String> cbbPhongban;
	private static final String titleInfoUngVien[] = {"Họ tên","Giới tính","Ngày sinh","Số điện thoại","Trình độ học vấn","Chuyên môn","Chuyên ngành","Số nhà","Đường","Phường,xã","Quận,huyện","Tỉnh,TP","Dân tộc","Tôn giáo","Số CMND","Ngày cấp","Nơi cấp","Hôn nhân","Chức vụ ứng tuyển","Mức lương deal"};
	public UngVIenView_TuyenUngVien() {
		init();
	}
	
	public void init() {
		this.setSize(1020,550);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		JPanel panelContent =new JPanel();
		panelContent.setBounds(0,0,this.getWidth(),this.getHeight());
		panelContent.setBackground(Color.white);
		panelContent.setBorder(new LineBorder(Color.decode("#0097e6"),3));
		panelContent.setLayout(null);
		this.add(panelContent);
		JLabel label_Title= new JLabel("Tuyển ứng viên");
		label_Title.setForeground(Color.decode("#3498db"));
		label_Title.setBounds(70,15,400,30);
		label_Title.setFont(new Font("Arial",1,17));
		panelContent.add(label_Title);
		
		
		
		
		JLabel label_img= new JLabel();
		label_img.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/adduv.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		panelContent.add(label_img);
		label_img.setBounds(30,10,40,40);
		
		//JPanel Thông tin Ứng viên
		JLabel label_UngVien= new JLabel("  Thông tin ứng viên");
		label_UngVien.setFont(new Font("Arial",1,14));
		
		label_UngVien.setBackground(Color.white);
		label_UngVien.setOpaque(true);
		label_UngVien.setBounds(20,60,150,20);
		panelContent.add(label_UngVien);
		
		JPanel info_UngVien= new JPanel();
		info_UngVien.setLayout(null);
		info_UngVien.setOpaque(true);
		info_UngVien.setBackground(Color.white);
		info_UngVien.setBounds(10, 70, 1000, 260);
		info_UngVien.setVisible(true);
		info_UngVien.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panelContent.add(info_UngVien);
		
		label_avt= new JLabel();
		label_avt.setBounds(20,30,120,150);
		label_avt.setOpaque(true);
		label_avt.setBackground(Color.green);
		label_avt.setFont(new Font("Arial",Font.BOLD,13));
		label_avt.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/none_user.jpg")).getImage().getScaledInstance(label_avt.getWidth(), label_avt.getHeight(), Image.SCALE_AREA_AVERAGING)));
		info_UngVien.add(label_avt);

		listlabel = new ArrayList<>();
		for(int i=0;i<7;i++) {
			JLabel temp= new JLabel(titleInfoUngVien[i]);
			temp.setBounds(180,20+i*32,200,30);
			temp.setForeground(new Color(0,0,0,160));
			temp.setFont(new Font("Arial",Font.BOLD,12));
			info_UngVien.add(temp);
			listlabel.add(temp);
		}
		
		for(int i=0;i<7;i++) {
			JLabel temp= new JLabel(titleInfoUngVien[i+7]);
			temp.setBounds(500,20+32*i,200,30);
			temp.setForeground(new Color(0,0,0,160));
			temp.setFont(new Font("Arial",Font.BOLD,12));
			info_UngVien.add(temp);
			listlabel.add(temp);
		}
		
		for(int i=0;i<6;i++) {
			JLabel temp= new JLabel(titleInfoUngVien[i+14]);
			temp.setBounds(750,20+32*i,250,30);
			temp.setForeground(new Color(0,0,0,160));
			temp.setFont(new Font("Arial",Font.BOLD,12));
			info_UngVien.add(temp);
			listlabel.add(temp);
		}
		// bổ sung thông tin
		
		JLabel label_BoSungThongTin= new JLabel("  Bổ sung thông tin");
		label_BoSungThongTin.setFont(new Font("Arial",1,14));
		label_BoSungThongTin.setBackground(Color.white);
		label_BoSungThongTin.setOpaque(true);
		label_BoSungThongTin.setBounds(20,340,150,20);
		panelContent.add(label_BoSungThongTin);
		JPanel info_BoSungThongTin= new JPanel();
		info_BoSungThongTin.setBackground(Color.white);
		info_BoSungThongTin.setBounds(10, 350, 1000, 120);
		info_BoSungThongTin.setVisible(true);
		info_BoSungThongTin.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panelContent.add(info_BoSungThongTin);
		info_BoSungThongTin.setLayout(null);
		listCombonentBoSung = new ArrayList<>();
		JLabel lbLoaiTuyen = new JLabel("Hình thức tuyển");
		
		lbLoaiTuyen.setBounds(20,20,120,30);
		lbLoaiTuyen.setFont(new Font("Arial",1,13));
		lbLoaiTuyen.setForeground(new Color(0,0,0,160));
		info_BoSungThongTin.add(lbLoaiTuyen);
		myCombobox<String> cbbLoaiTuyen  = new myCombobox<>();
		
		cbbLoaiTuyen.setModel(new DefaultComboBoxModel<>(new String[] {"Nhân viên chính thức","Nhân viên thử việc"}));
		cbbLoaiTuyen.setBounds(20,50,180,30);
		((myCombobox<String>)cbbLoaiTuyen).showArrow();
		cbbLoaiTuyen.setFont(new Font("Arial",1,13));
		info_BoSungThongTin.add(cbbLoaiTuyen);
		listCombonentBoSung.add(cbbLoaiTuyen);
		
		JLabel lbMaNhanVien = new JLabel("Mã nhân viên");
		lbMaNhanVien.setBounds(230,20,120,30);
		lbMaNhanVien.setFont(new Font("Arial",1,13));
		lbMaNhanVien.setForeground(new Color(0,0,0,160));
		info_BoSungThongTin.add(lbMaNhanVien);
		JTextField tfMaNhanVien  = new JTextField();
		tfMaNhanVien.setBounds(230,50,150,30);
		tfMaNhanVien.setFont(new Font("Arial",1,13));
		info_BoSungThongTin.add(tfMaNhanVien);
		listCombonentBoSung.add(tfMaNhanVien);
		
		JLabel lbPhongBan = new JLabel("Phòng ban");
		lbPhongBan.setBounds(410,20,120,30);
		lbPhongBan.setFont(new Font("Arial",1,13));
		lbPhongBan.setForeground(new Color(0,0,0,160));
		info_BoSungThongTin.add(lbPhongBan);
		cbbPhongban  = new myCombobox<>();
		
		cbbPhongban.setModel(new DefaultComboBoxModel<>(new String[] {"Phòng nhân sự","Phòng hành chính"}));
		cbbPhongban.setFont(new Font("Arial",1,13));
		cbbPhongban.setBounds(410,50,200,30);
		cbbPhongban.setMaximumRowCount(4);
		((myCombobox<String>)cbbPhongban).showArrow();
		info_BoSungThongTin.add(cbbPhongban);
		listCombonentBoSung.add(cbbPhongban);
		JPanel cart = new JPanel();
		cart.setBackground(Color.red);
		cart.setBounds(650,3,347,114);
		info_BoSungThongTin.add(cart);
		cart.setLayout(new CardLayout());
		// chính thức 
		JPanel cart1 = new JPanel();
		cart.add(cart1,0);
		cart1.setLayout(null);
		JLabel lbBatDau = new JLabel("Bắt đầu làm việc");
		lbBatDau.setBounds(0,20,200,30);
		lbBatDau.setFont(new Font("Arial",1,13));
		lbBatDau.setForeground(new Color(0,0,0,160));
		cart1.add(lbBatDau);
		JTextField tfBatDau  = new JTextField();
		tfBatDau.setBounds(0,50,150,30);
		tfBatDau.setFont(new Font("Arial",1,13));
		cart1.add(tfBatDau);
		listCombonentBoSung.add(tfBatDau);
		DateChooser dc = new DateChooser();
		dc.setTextRefernce(tfBatDau);
		
		JLabel lbLoaiHD = new JLabel("Thời hạn");
		lbLoaiHD.setBounds(180,20,120,30);
		lbLoaiHD.setFont(new Font("Arial",1,13));
		lbLoaiHD.setForeground(new Color(0,0,0,160));
		cart1.add(lbLoaiHD);
		myCombobox<String> cbbLoaiHD  = new myCombobox<>();
		cbbLoaiHD.setModel(new DefaultComboBoxModel<>(new String[] {"1 năm","2 năm","3 năm","4 năm"}));
		cbbLoaiHD.setBounds(180,50,150,30);
		cbbLoaiHD.setFont(new Font("Arial",1,13));
		cart1.add(cbbLoaiHD);
		listCombonentBoSung.add(cbbLoaiHD);
		
		
		
		// thử việc
		JPanel cart2 = new JPanel();
		cart.add(cart2,1);
		cart2.setLayout(null);
		JLabel lbBatDau2 = new JLabel("Bắt đầu thử việc");
		lbBatDau2.setBounds(0,20,200,30);
		lbBatDau2.setFont(new Font("Arial",1,13));
		lbBatDau2.setForeground(new Color(0,0,0,160));
		cart2.add(lbBatDau2);
		JTextField tfBatDau2  = new JTextField();
		tfBatDau2.setBounds(0,50,150,30);
		tfBatDau2.setFont(new Font("Arial",1,13));
		cart2.add(tfBatDau2);
		listCombonentBoSung.add(tfBatDau2);
		
		JLabel lbKetThuc = new JLabel("Kết thúc thử việc");
		lbKetThuc.setBounds(180,20,150,30);
		lbKetThuc.setFont(new Font("Arial",1,13));
		lbKetThuc.setForeground(new Color(0,0,0,160));
		cart2.add(lbKetThuc);
		JTextField tfKetThuc  = new JTextField();
		tfKetThuc.setBounds(180,50,150,30);
		tfKetThuc.setFont(new Font("Arial",1,13));
		listCombonentBoSung.add(tfKetThuc);
		DateChooser dc1 = new DateChooser();
		dc1.setTextRefernce(tfBatDau2);
		DateChooser dc2 = new DateChooser();
		dc2.setTextRefernce(tfKetThuc);
		
		cart2.add(tfKetThuc);
		cart1.setBackground(Color.white);
		cart2.setBackground(Color.white);
		cart1.setVisible(true);
		
		cart2.setVisible(false);
		cbbLoaiTuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbbLoaiTuyen.getSelectedIndex()==0) {
					cart1.setVisible(true);
					cart2.setVisible(false);
				}else {
					cart1.setVisible(false);
					cart2.setVisible(true);
				}
			}
		});
		

		button_dong= new Button();
		button_dong.setText("Hủy");
		panelContent.add(button_dong);
		button_dong.setFont(new Font("Arial",1,14));
		button_dong.setBounds(820,495,90,35);
		button_dong.setBackground(Color.decode("#7f8fa6"));
		button_dong.setBorderPainted(false);
		button_dong.setFocusPainted(false);
		button_dong.setForeground(Color.white);
		
		
		button_luu=new Button();
		button_luu.setText("Lưu");
		button_luu.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		panelContent.add(button_luu);
		button_luu.setFont(new Font("Arial",1,14));
		button_luu.setBounds(910,495,90,35);
		button_luu.setBackground(Color.decode("#44bd32"));
		button_luu.setForeground(Color.white);
		button_luu.setBorderPainted(false);
		button_luu.setFocusPainted(false);
		this.setUndecorated(true);
		this.setVisible(true);

	}
	public JComboBox<String> getComboBox_hopdong() {
		return comboBox_hopdong;
	}
	public void setComboBox_hopdong(JComboBox<String> comboBox_hopdong) {
		this.comboBox_hopdong = comboBox_hopdong;
	}
	public JTextField getTextField_NgayBatDauHopDong() {
		return textField_NgayBatDauHopDong;
	}
	public void setTextField_NgayBatDauHopDong(JTextField textField_NgayBatDauHopDong) {
		this.textField_NgayBatDauHopDong = textField_NgayBatDauHopDong;
	}
	public JComboBox<String> getComboBox_PhongBan() {
		return comboBox_PhongBan;
	}
	public void setComboBox_PhongBan(JComboBox<String> comboBox_PhongBan) {
		this.comboBox_PhongBan = comboBox_PhongBan;
	}
	public JLabel getLabel_avt() {
		return label_avt;
	}
	public void setLabel_avt(JLabel label_avt) {
		this.label_avt = label_avt;
	}
	
	
	
	public JButton getButton_dong() {
		return button_dong;
	}
	public void setButton_dong(JButton button_dong) {
		this.button_dong = button_dong;
	}
	public JButton getButton_luu() {
		return button_luu;
	}
	public void setButton_luu(JButton button_luu) {
		this.button_luu = button_luu;
	}
	public JTextField getTextField_MaNhanVien() {
		return textField_MaNhanVien;
	}
	public void setTextField_MaNhanVien(JTextField textField_MaNhanVien) {
		this.textField_MaNhanVien = textField_MaNhanVien;
	}
	public JTextField getTextField_NgayBatDauThuViec() {
		return textField_NgayBatDauThuViec;
	}
	public void setTextField_NgayBatDauThuViec(JTextField textField_NgayBatDauThuViec) {
		this.textField_NgayBatDauThuViec = textField_NgayBatDauThuViec;
	}
	public JTextField getTextField_NgayKetThucThuViec() {
		return textField_NgayKetThucThuViec;
	}
	public void setTextField_NgayKetThucThuViec(JTextField textField_NgayKetThucThuViec) {
		this.textField_NgayKetThucThuViec = textField_NgayKetThucThuViec;
	}
	
	
	public JComboBox<String> getThuviec_chinhthuc() {
		return thuviec_chinhthuc;
	}
	public void setThuviec_chinhthuc(JComboBox<String> thuviec_chinhthuc) {
		this.thuviec_chinhthuc = thuviec_chinhthuc;
	}
	
	public void setData(String data[]) {
		this.data =data;
		for(int i=0;i<20;i++) {
			listlabel.get(i).setText(titleInfoUngVien[i]+":   "+data[i]);
		}
	}
	public String[] getData() {
		return data;
	}
	public String[] getDataBoSung() {
		String str0 = ((myCombobox<String>)listCombonentBoSung.get(0)).getSelectedItem().toString();
		String str1 = ((JTextField)listCombonentBoSung.get(1)).getText().trim();
		String str2 = ((myCombobox<String>)listCombonentBoSung.get(2)).getSelectedItem().toString();
		String str3 = ((JTextField)listCombonentBoSung.get(3)).getText().trim();
		String str4 = ((myCombobox<String>)listCombonentBoSung.get(4)).getSelectedItem().toString();
		String str5 = ((JTextField)listCombonentBoSung.get(5)).getText().trim();
		String str6 = ((JTextField)listCombonentBoSung.get(6)).getText().trim();
		String data[] = {str0,str1,str2,str3,str4,str5,str6};
		return data;
	}
	public void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str,"Thông báo",JOptionPane.WARNING_MESSAGE);
		
	}
	public void setDataCbbPhongBanTuyenUngVien(String tuyenUngVien[]) {
		cbbPhongban.setModel(new DefaultComboBoxModel<>(tuyenUngVien));
	}
}
