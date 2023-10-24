package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DataTruncation;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.access_CHUCVUCONGTY;
import DTO.BAOCAOTUYENDUNG;
import dateChooser.DateChooser;

public class TuyenDungView_Them extends JFrame{
	private JButton button_dong;
	private JButton button_luu;
	private JTextField textField_MaTuyenDung;
	private JTextField textField_HocVan;
	private JTextField textField_GioiTinh;
	private JTextField textField_DoTuoi;
	private JTextField textField_SoLuongTuyen;
	private JTextField textField_HanNop;
	private JTextField textField_MucLuongToiThieu;
	private JTextField textField_MucLuongToiDa;
	private JTextField textField_ChucVu;
	private JLabel label_HocVan;
	private JComboBox<String> comboBox_HocVan;
//	private JComboBox<String> comboBox_GioiTinh;

	private JLabel dong;
	private JPanel panel_title;
	private JComboBox<String> comboBox_DoTuoi;
	private JComboBox<String> comboBox_ChucVuCongTy;
	private JCheckBox maleCheckBox;
	private JCheckBox femaleCheckBox;

	private JLabel label_MaTuyenDung;
	private JLabel label_SoLuongTuyen;
	private JLabel label_DoTuoi;
	private JLabel label_GioiTinh;
	private JLabel label_MucLuongToiThieu;
	private JLabel label_MucLuongToiDa;
	private JLabel label_ChucVu;
	private Component label_HanNop;
	private JCheckBox nullCheckBox;	
	
	
	public TuyenDungView_Them() {
		init();
	}
	public void init() {
		// Khởi tạo màn hình 
		this.setSize(490,530);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);// JFrame không có thanh tiêu đề
		this.setLayout(null);
		JPanel panelContent = new JPanel();
		panelContent.setBounds(0,0,490,530);
		panelContent.setBackground(Color.white);
		panelContent.setBorder(new LineBorder(Color.decode("#2980b9"),2));
		this.add(panelContent);
		panelContent.setLayout(null);
		

		JLabel label_img= new JLabel();
		label_img.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/addtd.png")).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		panelContent.add(label_img);
		label_img.setBounds(40,42,40,40);
		
		JLabel label_Title= new JLabel("Thêm đợt tuyển dụng");
		label_Title.setForeground(new Color(0,128,255));
		label_Title.setFont(new Font("Arial",0,20));
		panelContent.add(label_Title);
		label_Title.setBounds(82,40,230,30);

		button_dong= new JButton("Đóng");
		button_dong.setForeground(new Color(0,128,255));
		button_dong.setHorizontalAlignment(SwingConstants.LEFT);
		panelContent.add(button_dong);
		button_dong.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/3.png")).getImage().getScaledInstance(23, 20, Image.SCALE_DEFAULT)));
		button_dong.setBounds(250,480,90,30);

		button_luu=new JButton("Lưu");
		button_luu.setForeground(new Color(0,128,255));
		button_luu.setHorizontalAlignment(SwingConstants.LEFT);
		panelContent.add(button_luu);
		button_luu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/2.png")).getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT)));
		button_luu.setBounds(360,480,80,30);
		Font font = new Font("Arial",0,14);
		 label_MaTuyenDung = new JLabel("Mã tuyển dụng");
		label_MaTuyenDung.setFont(new Font("Arial",0,15));
		panelContent.add(label_MaTuyenDung);
		label_MaTuyenDung.setBounds(50,100,230,30);

		textField_MaTuyenDung= new JTextField();
		panelContent.add(textField_MaTuyenDung);
		textField_MaTuyenDung.setBounds(50,130,170,30);
		textField_MaTuyenDung.setFont(font);

		

		label_HocVan= new JLabel("Học vấn tối thiểu");
		label_HocVan.setFont(new Font("Arial",0,15));
		panelContent.add(label_HocVan);
		label_HocVan.setBounds(50,310,230,30);
		
		String[] hocvan= {"Không","9/12","12/12","Trung cấp","Cao đẳng","Đại học","Thạc sĩ","Tiến sĩ"};
		comboBox_HocVan = new myCombobox<>();
		comboBox_HocVan.setModel(new DefaultComboBoxModel<>(hocvan));
		panelContent.add(comboBox_HocVan);
		comboBox_HocVan.setBounds(50,340,170,30);
		comboBox_HocVan.setFont(font);

		
		 label_SoLuongTuyen = new JLabel("Số lượng tuyển");
		 panelContent.add(label_SoLuongTuyen);
		label_SoLuongTuyen.setFont(new Font("Arial",0,15));
		label_SoLuongTuyen.setBounds(50,240,120,30);

		textField_SoLuongTuyen= new JTextField("");
		panelContent.add(textField_SoLuongTuyen);
		textField_SoLuongTuyen.setBounds(50,270,170,30);
		textField_SoLuongTuyen.setFont(font);
		

		 label_DoTuoi = new JLabel("Độ tuổi");
		label_DoTuoi.setFont(new Font("Arial",0,15));
		panelContent.add(label_DoTuoi);
		label_DoTuoi.setBounds(270,100,230,30);

		String[] dotuoi= {"Không","18-35","20-35","18-20","20-24","24-35"};
		comboBox_DoTuoi= new myCombobox<String>();
		comboBox_DoTuoi.setModel(new DefaultComboBoxModel<>(dotuoi));
		panelContent.add(comboBox_DoTuoi);
		comboBox_DoTuoi.setBounds(270,130,170,30);
		comboBox_DoTuoi.setFont(font);

		
		 label_GioiTinh = new JLabel("Giới tính");
		label_GioiTinh.setFont(new Font("Arial",0,15));
		panelContent.add(label_GioiTinh);
		label_GioiTinh.setBounds(50,380,100,30);

		maleCheckBox = new JCheckBox("Nam");
		maleCheckBox.setBounds(50,410,70,30);
		maleCheckBox.setFont(font);
		femaleCheckBox  = new JCheckBox("Nữ");
		femaleCheckBox.setBounds(120,410,70,30);
		femaleCheckBox.setFont(font);
		nullCheckBox  = new JCheckBox("Không");
		nullCheckBox.setBounds(180,410,80,30);
		nullCheckBox.setFont(font);
		panelContent.add(maleCheckBox);
		panelContent.add(femaleCheckBox);
		panelContent.add(nullCheckBox);
		ButtonGroup genderButtonGroup = new ButtonGroup();
		genderButtonGroup.add(maleCheckBox);
		genderButtonGroup.add(femaleCheckBox);
		genderButtonGroup.add(nullCheckBox);
		maleCheckBox.setBackground(Color.white);
		femaleCheckBox.setBackground(Color.white);
		nullCheckBox.setBackground(Color.white);
		
		 label_MucLuongToiThieu = new JLabel("Mức lương tối thiểu");
		 panelContent.add(label_MucLuongToiThieu);
		label_MucLuongToiThieu.setFont(new Font("Arial",0,15));
		label_MucLuongToiThieu.setBounds(270,170,230,30);

		textField_MucLuongToiThieu= new JTextField();
		panelContent.add(textField_MucLuongToiThieu);
		textField_MucLuongToiThieu.setBounds(270,200,170,30);
		textField_MucLuongToiThieu.setFont(font);
		 label_MucLuongToiDa = new JLabel("Mức lương tối đa");
		 panelContent.add(label_MucLuongToiDa);
		label_MucLuongToiDa.setFont(new Font("Arial",0,15));
		label_MucLuongToiDa.setBounds(270,240,230,30);

		textField_MucLuongToiDa= new JTextField();
		panelContent.add(textField_MucLuongToiDa);
		textField_MucLuongToiDa.setBounds(270,270,170,30);
		textField_MucLuongToiDa.setFont(font);

		 label_ChucVu = new JLabel("Chức vụ");
		 panelContent.add(label_ChucVu);
		label_ChucVu.setFont(new Font("Arial",0,15));
		label_ChucVu.setBounds(50,170,230,30);

		String[] chucvu= {};
		comboBox_ChucVuCongTy= new myCombobox<String>();
		comboBox_ChucVuCongTy.setModel(new DefaultComboBoxModel<>(chucvu));
		panelContent.add(comboBox_ChucVuCongTy);
		comboBox_ChucVuCongTy.setBounds(50,200,170,30);
		comboBox_ChucVuCongTy.setFont(font);
		
		 label_HanNop = new JLabel("Hạn nộp hồ sơ");
		 panelContent.add(label_HanNop);
		label_HanNop.setFont(new Font("Arial",0,15));
		label_HanNop.setBounds(270,310,230,30);

		textField_HanNop = new JTextField();
		textField_HanNop.setBounds(270,340,170,30);
		panelContent.add(textField_HanNop);
		DateChooser dc = new DateChooser();
		dc.setTextRefernce(textField_HanNop);
		textField_HanNop.setFont(font);
	}
	public void setCbbChucVu(String data[]) {
		String str[] = new String[data.length-2];
		for(int i=2;i<data.length;i++) {
			str[i-2] = data[i];
		}
		comboBox_ChucVuCongTy.setModel(new DefaultComboBoxModel<>(str));
	}
	public String getGioiTinh() {
		if(maleCheckBox.isSelected()) {
			return "Nam";
		}else if(femaleCheckBox.isSelected()) {
			return "Nữ";
		}else if(nullCheckBox.isSelected()) {
			return "Không";
		}
		return "";
	}
	public String[] getDataToAdd() {
		String data[] = new String[]{
			textField_MaTuyenDung.getText().trim(),
			comboBox_ChucVuCongTy.getSelectedItem().toString(),
			textField_SoLuongTuyen.getText(),
			comboBox_HocVan.getSelectedItem().toString(),
			getGioiTinh(),
			comboBox_DoTuoi.getSelectedItem().toString(),
			
			textField_MucLuongToiThieu.getText(),
			textField_MucLuongToiDa.getText(),
			textField_HanNop.getText(),
		};
		return data;
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
	public JTextField getTextField_MaTuyenDung() {
		return textField_MaTuyenDung;
	}
	public void setTextField_MaTuyenDung(JTextField textField_MaTuyenDung) {
		this.textField_MaTuyenDung = textField_MaTuyenDung;
	}
	public JTextField getTextField_HocVan() {
		return textField_HocVan;
	}
	public void setTextField_HocVan(JTextField textField_HocVan) {
		this.textField_HocVan = textField_HocVan;
	}
	public JTextField getTextField_GioiTinh() {
		return textField_GioiTinh;
	}
	public void setTextField_GioiTinh(JTextField textField_GioiTinh) {
		this.textField_GioiTinh = textField_GioiTinh;
	}
	public JTextField getTextField_DoTuoi() {
		return textField_DoTuoi;
	}
	public void setTextField_DoTuoi(JTextField textField_DoTuoi) {
		this.textField_DoTuoi = textField_DoTuoi;
	}
	public JTextField getTextField_SoLuongTuyen() {
		return textField_SoLuongTuyen;
	}
	public void setTextField_SoLuongTuyen(JTextField textField_SoLuongTuyen) {
		this.textField_SoLuongTuyen = textField_SoLuongTuyen;
	}
	public JTextField getTextField_HanNop() {
		return textField_HanNop;
	}
	public void setTextField_HanNop(JTextField textField_HanNop) {
		this.textField_HanNop = textField_HanNop;
	}
	public JTextField getTextField_MucLuongToiThieu() {
		return textField_MucLuongToiThieu;
	}
	public void setTextField_MucLuongToiThieu(JTextField textField_MucLuongToiThieu) {
		this.textField_MucLuongToiThieu = textField_MucLuongToiThieu;
	}
	public JTextField getTextField_MucLuongToiDa() {
		return textField_MucLuongToiDa;
	}
	public void setTextField_MucLuongToiDa(JTextField textField_MucLuongToiDa) {
		this.textField_MucLuongToiDa = textField_MucLuongToiDa;
	}
	public JTextField getTextField_ChucVu() {
		return textField_ChucVu;
	}
	public void setTextField_ChucVu(JTextField textField_ChucVu) {
		this.textField_ChucVu = textField_ChucVu;
	}
	
	public JLabel getLabel_HocVan() {
		return label_HocVan;
	}
	public void setLabel_HocVan(JLabel label_HocVan) {
		this.label_HocVan = label_HocVan;
	}
	public JComboBox<String> getComboBox_HocVan() {
		return comboBox_HocVan;
	}
	public void setComboBox_HocVan(JComboBox<String> comboBox_HocVan) {
		this.comboBox_HocVan = comboBox_HocVan;
	}

	public JLabel getDong() {
		return dong;
	}
	public void setDong(JLabel dong) {
		this.dong = dong;
	}
	public JPanel getPanel_title() {
		return panel_title;
	}
	public void setPanel_title(JPanel panel_title) {
		this.panel_title = panel_title;
	}
	public JComboBox<String> getComboBox_DoTuoi() {
		return comboBox_DoTuoi;
	}
	public void setComboBox_DoTuoi(JComboBox<String> comboBox_DoTuoi) {
		this.comboBox_DoTuoi = comboBox_DoTuoi;
	}
	public JComboBox<String> getComboBox_ChucVuCongTy() {
		return comboBox_ChucVuCongTy;
	}
	public void setComboBox_ChucVuCongTy(JComboBox<String> comboBox_ChucVuCongTy) {
		this.comboBox_ChucVuCongTy = comboBox_ChucVuCongTy;
	}
	public JCheckBox getMaleCheckBox() {
		return maleCheckBox;
	}
	public void setMaleCheckBox(JCheckBox maleCheckBox) {
		this.maleCheckBox = maleCheckBox;
	}
	public JCheckBox getFemaleCheckBox() {
		return femaleCheckBox;
	}
	public void setFemaleCheckBox(JCheckBox femaleCheckBox) {
		this.femaleCheckBox = femaleCheckBox;
	}
	public JLabel getLabel_MaTuyenDung() {
		return label_MaTuyenDung;
	}
	public void setLabel_MaTuyenDung(JLabel label_MaTuyenDung) {
		this.label_MaTuyenDung = label_MaTuyenDung;
	}
	public JLabel getLabel_SoLuongTuyen() {
		return label_SoLuongTuyen;
	}
	public void setLabel_SoLuongTuyen(JLabel label_SoLuongTuyen) {
		this.label_SoLuongTuyen = label_SoLuongTuyen;
	}
	public JLabel getLabel_DoTuoi() {
		return label_DoTuoi;
	}
	public void setLabel_DoTuoi(JLabel label_DoTuoi) {
		this.label_DoTuoi = label_DoTuoi;
	}
	public JLabel getLabel_GioiTinh() {
		return label_GioiTinh;
	}
	public void setLabel_GioiTinh(JLabel label_GioiTinh) {
		this.label_GioiTinh = label_GioiTinh;
	}
	public JLabel getLabel_MucLuongToiThieu() {
		return label_MucLuongToiThieu;
	}
	public void setLabel_MucLuongToiThieu(JLabel label_MucLuongToiThieu) {
		this.label_MucLuongToiThieu = label_MucLuongToiThieu;
	}
	public JLabel getLabel_MucLuongToiDa() {
		return label_MucLuongToiDa;
	}
	public void setLabel_MucLuongToiDa(JLabel label_MucLuongToiDa) {
		this.label_MucLuongToiDa = label_MucLuongToiDa;
	}
	public JLabel getLabel_ChucVu() {
		return label_ChucVu;
	}
	public void setLabel_ChucVu(JLabel label_ChucVu) {
		this.label_ChucVu = label_ChucVu;
	}
	public Component getLabel_HanNop() {
		return label_HanNop;
	}
	public void setLabel_HanNop(Component label_HanNop) {
		this.label_HanNop = label_HanNop;
	}
	public JCheckBox getNullCheckBox() {
		return nullCheckBox;
	}
	public void setNullCheckBox(JCheckBox nullCheckBox) {
		this.nullCheckBox = nullCheckBox;
	}
}
