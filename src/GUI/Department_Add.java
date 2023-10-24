package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.SUPPORT;
import control.diChuyenDepartmentAdd;
import dateChooser.DateChooser;

public class Department_Add extends JFrame{
	private JLabel lbtitle;
	private JTextField tfMaPhong;
	private JTextField tfTenPhong;
	private JTextField tfNgayThanhLap;

	private JButton btnHuy;
	private JButton btnLuu;
	private ACTION_TYPE type;
	public Department_Add() {
		this.setSize(400,260);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setUndecorated(true);
		this.setVisible(true);
	}
	public void init() {
		this.setLayout(null);
		JPanel p1 = new JPanel();
		diChuyenDepartmentAdd move = new diChuyenDepartmentAdd(this);
		p1.addMouseMotionListener(move);
		p1.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(p1);
		p1.setBackground(Color.decode("#3498db"));
		p1.setLayout(null);
		lbtitle = new JLabel("THÊM PHÒNG BAN");
		lbtitle.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add.png")));
		lbtitle.setFont(new Font("Arial",1,14));
		lbtitle.setForeground(Color.white);
		lbtitle.setBounds(10,0,200,30);
		p1.add(lbtitle);
		
		JPanel p2 = new JPanel();
		p2.setBounds(5,30,p1.getWidth()-10,p1.getHeight()-35);
		p2.setBackground(Color.white);
		p1.add(p2);
		p2.setLayout(null);
		
		
		
		JLabel lbt = new JLabel("Mã phòng: ");
		lbt.setBounds(20,25,100,28);
		lbt.setForeground(new Color(0,0,0,160));
		lbt.setFont(new Font("Arial",1,13));
		p2.add(lbt);
		
		tfMaPhong = new JTextField();
		tfMaPhong.setBounds(150,25,220,28);
		tfMaPhong.setFont(new Font("Arial",1,13));
		tfMaPhong.setForeground(new Color(0,0,0,160));
		p2.add(tfMaPhong);
		
		JLabel lbt2 = new JLabel("Tên phòng: ");
		lbt2.setBounds(20,65,100,28);
		lbt2.setForeground(new Color(0,0,0,160));
		lbt2.setFont(new Font("Arial",1,13));
		p2.add(lbt2);
		
		tfTenPhong = new JTextField();
		tfTenPhong.setBounds(150,65,220,28);
		tfTenPhong.setFont(new Font("Arial",1,13));
		tfTenPhong.setForeground(new Color(0,0,0,160));
		p2.add(tfTenPhong);
		
		
		JLabel lbt3 = new JLabel("Ngày thành lập: ");
		lbt3.setBounds(20,105,120,28);
		lbt3.setForeground(new Color(0,0,0,160));
		lbt3.setFont(new Font("Arial",1,13));
		p2.add(lbt3);
		
		
		tfNgayThanhLap = new JTextField();
		tfNgayThanhLap.setBounds(150,105,220,28);
		tfNgayThanhLap.setFont(new Font("Arial",1,13));
		tfNgayThanhLap.setForeground(new Color(0,0,0,160));
		p2.add(tfNgayThanhLap);
		DateChooser dc = new DateChooser();
		dc.setTextRefernce(tfNgayThanhLap);
		
		

		btnHuy =new JButton("Hủy");
		btnHuy.setBounds(210,184,75,26);
		btnHuy.setBorderPainted(false);
		btnHuy.setFocusPainted(false);
		btnHuy.setFont(new Font("Arial",1,12));
		btnHuy.setForeground(new Color(0,0,0,180));
		btnHuy.setBackground(Color.decode("#bdc3c7"));
		p2.add(btnHuy);
		
		
		btnLuu =new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		btnLuu.setBounds(294,184,75,26);
		btnLuu.setBorderPainted(false);
		btnLuu.setFocusPainted(false);
		btnLuu.setFont(new Font("Arial",1,12));
		btnLuu.setForeground(new Color(255,255,255,240));
		btnLuu.setBackground(Color.decode("#4cd137"));
		p2.add(btnLuu);
	}
	public void setDataToEdit(String[] data) {
		tfMaPhong.setText(data[0]);
		tfTenPhong.setText(data[1]);
		tfNgayThanhLap.setText(data[2]);
	}
	public JTextField getTfMaPhong() {
		return tfMaPhong;
	}
	public JTextField getTfTenPhong() {
		return tfTenPhong;
	}
	public JTextField getTfNgayThanhLap() {
		return tfNgayThanhLap;
	}
	public JButton getBtnHuy() {
		return btnHuy;
	}
	public JButton getBtnLuu() {
		return btnLuu;
	}
	public String[] getDataThemPhongBan() {
		String data[] = {tfMaPhong.getText().trim(),tfTenPhong.getText().trim(),tfNgayThanhLap.getText().trim()};
		return data;
	}
	public void showOn() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void setType(ACTION_TYPE type) {
		this.type = type;
		if(type==ACTION_TYPE.ADD) {
			lbtitle.setText("THÊM PHÒNG BAN");
		}else {
			lbtitle.setText("SỬA PHÒNG BAN");
		}
	}
	public ACTION_TYPE getActionType() {
		return type;
	}
	public enum ACTION_TYPE{
		ADD,EDIT
	}
}
