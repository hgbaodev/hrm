package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import view.button.Button;

public class ConTractForm2 extends JPanel{
	private ArrayList<JTextField> textFieldList;
	private JButton btnBack;
	private Object[][] data;
	private JLabel img;
	private JButton btnGiaHan;
	private JButton btnHuy;
	private myCombobox<String> cbb;
	public ConTractForm2() {
		data = new Object[][] {
			{"001","Lê Quan Phát","Nhân sự","HD001","02/09/2003","02/09/2030","50 năm","30,000,000","",""},
		};
		init();
	}
	public void init() {
		this.setLayout(null);	
		
		JPanel panelFeature2 = new JPanel();
		panelFeature2.setBounds(0,0,1080,40);
		panelFeature2.setBackground(Color.white);
		this.add(panelFeature2);
		panelFeature2.setLayout(null);

		

		btnBack= new JButton("Quay lại");
		btnBack.setIcon(new ImageIcon(getClass().getResource("/assets/img/al.png")));
		btnBack.setBounds(5,5,120,30);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setFont(new Font("arial",0,14));
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFeature2.add(btnBack);

	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,50,1080,610);
		panel.setBackground(Color.white);
		this.add(panel);
		
		JLabel jlabel1 = new JLabel("Gia hạn hợp đồng");
		jlabel1.setFont(new Font("arial",1,15));
		jlabel1.setForeground(new Color(0,0,0,160));
		jlabel1.setBounds(10,5,200,30);
		panel.add(jlabel1);
		

		
		img = new  JLabel();
		img.setBounds(190,106,140,165);
		img.setBorder(new LineBorder(new Color(0,0,0,80),2));
		
		btnGiaHan = new Button();
		btnGiaHan.setText("Gia hạn");
		btnGiaHan.setBounds(665,420,100,35);
		btnGiaHan.setBackground(Color.decode("#3498db"));
		btnGiaHan.setForeground(Color.white);
		btnGiaHan.setFont(new Font("sansserif",1,13));
		btnGiaHan.setBorderPainted(false);
		btnGiaHan.setFocusPainted(false);
		
		btnHuy = new Button();
		btnHuy.setText("Hủy");
		btnHuy.setBounds(555,420,100,35);
		btnHuy.setBackground(Color.decode("#718093"));
		btnHuy.setForeground(Color.white);
		btnHuy.setFont(new Font("sansserif",1,13));
		btnHuy.setBorderPainted(false);
		btnHuy.setFocusPainted(false);
		
		panel.add(img);
		panel.add(btnGiaHan);
		panel.add(btnHuy);
		
		Font font = new Font("arial",0,14);
	
		textFieldList = new ArrayList<>();
		String a1[] = new String[] {"Mã nhân viên","Họ tên", "Phòng ban","Mã hợp đồng","Ngày bắt đầu","Ngày hết hạn","Loại hợp đồng","Mức lương","Thời gian gia hạn thêm"};
		
		for(int i=0;i<8;i++) {
			JLabel lbid = new JLabel(a1[i]+": ");
			lbid.setBounds(390,100+i*30,120,30);
			lbid.setFont(font);
			panel.add(lbid);	
			JTextField tf = new JTextField();
			tf.setBounds(620,104+i*30,220,24);
			tf.setEditable(false);
			tf.setFont(font);
			tf.setBorder(null);
			tf.setForeground(Color.decode("#3498db"));
			tf.setBackground(Color.white);
			panel.add(tf);
			textFieldList.add(tf);
		}
		
		JLabel lbid = new JLabel(a1[8]+": ");
		lbid.setBounds(390,100+8*30,190,30);
		lbid.setFont(font);
		panel.add(lbid);	
		
		
		cbb = new myCombobox<>();
		String strSort[] = {" 1 năm", " 2 năm", " 3 năm", " 4 năm", " 5 năm", " 6 năm", " 7 năm", " 8 năm", " 9 năm", " 10 năm"};
		cbb.setModel(new DefaultComboBoxModel<>(strSort));
		cbb.setFont(new Font("Arial", 1, 13));
		cbb.setForeground(new Color(0, 0, 0, 160));
		cbb.setBounds(620, 344, 140, 24);
		cbb.setFocusable(false);
		panel.add(cbb);

	
		JPanel separate2 = new JPanel();
		separate2.setBounds(10,550,1045,1);
		separate2.setBackground(new Color(0,0,0,60));
		panel.add(separate2);
		
		
		renderData();
	}
	
	public ArrayList<JTextField> getTextFieldList(){
		return this.textFieldList;
	}
	public JButton getBtnBack() {
		return this.btnBack;
	}
	
	public JButton getBtnGiaHan() {
		return this.btnGiaHan;
	}
	
	public JButton getBtnHuy() {
		return this.btnHuy;
	}

	public void setData(Object[][] data) {
		this.data = data;
		renderData();
	}
	
	public myCombobox<String> getCbbGiaHan(){
		return this.cbb;
	}
	
	public void renderData() {
		int a[] = {8};
		int count = 0;
		for(int i=0;i<1;i++) {
			for(int j=0;j<a[i];j++) {
				textFieldList.get(count).setText(data[i][j]+"");
				count++;
			}
		}
		
	}
	
	
	public Object[][] getDataFromTextField() {
		int a[] = {8};
		Object[][] ob = new Object[1][8];
		int count = 0;
		for(int i=0;i<1;i++) {
			ob[i] = new String[] {"","","","","","","",""};
			for(int j=0;j<a[i];j++) {
				ob[i][j] = textFieldList.get(count).getText();
				count++;
			}
		}
		
		return ob;
	}
	public void setImageEmployee(String path) {
		img.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+path)).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)));
	}
}
