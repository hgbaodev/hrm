package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import view.button.Button;

public class employeeForm2 extends JPanel{
	private ArrayList<JLabel> labelList;
	private ArrayList<JLabel> labelClassificationList;
	private JButton btnBack;
	private String data[];
	private JLabel img;
	public employeeForm2() {
		data = new String[] {
			"001","Lê Quan Phát","Phòng kĩ thuật công nghệ","Trưởng phòng","12-12-2020","Chính thức",
			"HD001","12-09-2020","12-09-2025","5 năm","30,000,000",
			"Nam","24-11-2003","157/89 Dương Bá Trạc, phường 01, quận 8, TP. Hồ Chí Minh","12121212","An Giang","12-09-2028","Kinh","Không","Độc thân",
			"Lê Quan Phát","TP.HCM","09222222","lequanphat.@.com"
		};
		init();
	}
	public void init() {
		this.setLayout(null);
		
		JPanel panelFeature2 = new JPanel();
		panelFeature2.setBounds(10,10,1080,40);
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
		panel.setBounds(10,60,1080,645);
		panel.setBackground(Color.white);
		this.add(panel);
		JLabel jlabel1 = new JLabel("Hồ sơ nhân viên");
		jlabel1.setFont(new Font("arial",1,15));
		jlabel1.setForeground(new Color(0,0,0,160));
		jlabel1.setBounds(10,5,200,30);
		panel.add(jlabel1);
		JLabel lbb = new JLabel("Ảnh nhân viên",JLabel.CENTER);
		lbb.setFont(new Font("Arial",1,13));
		lbb.setBounds(20,40,100,20);
		lbb.setForeground(new Color(0,0,0,160));
		lbb.setBackground(Color.white);
		lbb.setOpaque(true);
		panel.add(lbb);
		
		JPanel panelImg = new JPanel();
		panelImg.setLayout(null);
		panelImg.setBounds(10,50,180,205);
		panelImg.setBackground(Color.white);
		panelImg.setBorder(new LineBorder(new Color(200,200,200),3));
		panelImg.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panel.add(panelImg);
		
		img = new  JLabel();
		img.setBounds(20,20,140,165);
		img.setBorder(new LineBorder(new Color(0,0,0,80),2));
		
		panelImg.add(img);
		
		JLabel lbb2 = new JLabel("Thông tin cơ bản",JLabel.CENTER);
		lbb2.setFont(new Font("Arial",1,13));
		lbb2.setBounds(220,40,120,20);
		lbb2.setForeground(new Color(0,0,0,160));
		
		lbb2.setBackground(Color.white);
		lbb2.setOpaque(true);
		panel.add(lbb2);
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(210,50,480,205);
		panelInfo.setBackground(Color.white);
		panelInfo.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panel.add(panelInfo);
		
		Font font = new Font("Arial",1,13);
		String a1[] = new String[] {"Mã nhân viên","Tên nhân viên","Phòng ban","Chức vụ","Ngày nhận chức","Loại hình làm việc"};
		
		labelList = new ArrayList<>();
		for(int i=0;i<6;i++) {
			JLabel lbid = new JLabel(a1[i]+": ");
			lbid.setBounds(20,12+i*30,130,30);
			lbid.setFont(font);
			lbid.setForeground(new Color(0,0,0,160));
			panelInfo.add(lbid);	
			JLabel lb = new JLabel("null");
			lb.setBounds(180,12+i*30,240,30);
			lb.setFont(font);
			lb.setForeground(new Color(0,0,0,190));
			lb.setBackground(Color.white);
			panelInfo.add(lb);
			labelList.add(lb);
		}
		
		JLabel lbb4 = new JLabel("Hợp đồng lao động",JLabel.CENTER);
		lbb4.setFont(new Font("Arial",1,13));
		lbb4.setBounds(740,40,140,20);
		lbb4.setForeground(new Color(0,0,0,160));
		lbb4.setBackground(Color.white);
		lbb4.setOpaque(true);
		panel.add(lbb4);
		labelClassificationList = new ArrayList<>();
		labelClassificationList.add(lbb4);
		JPanel panelInfo3 = new JPanel();
		panelInfo3.setLayout(null);
		panelInfo3.setBounds(710,50,360,205);
		panelInfo3.setBackground(Color.white);
		panelInfo3.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panel.add(panelInfo3);
		
		String b1[] = new String[] {"Số hợp đồng","Ngày kí hợp đồng","Ngày hết hạn","Thời hạn hợp đồng","Lương cơ bản"};
		for(int i=0;i<5;i++) {
			JLabel lbid3 = new JLabel(b1[i]+": ");
			lbid3.setBounds(20,12+i*30,200,30);
			lbid3.setFont(font);
			lbid3.setForeground(new Color(0,0,0,160));
			panelInfo3.add(lbid3);
			labelClassificationList.add(lbid3);
			
			JLabel tf1 = new JLabel("null");
			tf1.setBounds(170,12+i*30,160,30);
			tf1.setFont(font);
			tf1.setForeground(new Color(0,0,0,190));
			tf1.setBackground(Color.white);
			panelInfo3.add(tf1);
			labelList.add(tf1);
			
		}
		
		
		
		
		
		JLabel lbb3 = new JLabel("Thông tin cá nhân",JLabel.CENTER);
		lbb3.setFont(new Font("Arial",1,13));
		lbb3.setBounds(20,270,120,20);
		lbb3.setForeground(new Color(0,0,0,160));
		lbb3.setBackground(Color.white);
		lbb3.setOpaque(true);
		panel.add(lbb3);
		JPanel panelInfo2 = new JPanel();
		panelInfo2.setLayout(null);
		panelInfo2.setBounds(10,280,680,310);
		panelInfo2.setBackground(Color.white);
		panelInfo2.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panel.add(panelInfo2);
		String []c1 = new String[] {"Giới tính","Ngày sinh","Địa chỉ","Số điện thoại","CMND","Trình độ","Dân tộc","Tôn giáo","Tình trạng hôn nhân"};
		
		for(int i=0;i<9;i++) {
			JLabel lbname6 = new JLabel(c1[i]+": ");
			lbname6.setBounds(20,20+i*30,140,30);
			lbname6.setFont(font);
			lbname6.setForeground(new Color(0,0,0,160));
			panelInfo2.add(lbname6);
			
			JLabel tf1 = new JLabel("null");
			tf1.setBounds(180,20+i*30,500,30);
			tf1.setFont(font);
			tf1.setForeground(new Color(0,0,0,190));
			tf1.setBackground(Color.white);
			panelInfo2.add(tf1);
			labelList.add(tf1);
			
			
		}
		
		JLabel lbb5 = new JLabel("Thông tin liên hệ",JLabel.CENTER);
		lbb5.setFont(new Font("Arial",1,13));
		lbb5.setBounds(740,270,140,20);
		lbb5.setForeground(new Color(0,0,0,160));

		lbb5.setBackground(Color.white);
		lbb5.setOpaque(true);
		panel.add(lbb5);
		JPanel panelInfo5 = new JPanel();
		panelInfo5.setLayout(null);
		panelInfo5.setBounds(710,280,360,310);
		panelInfo5.setBackground(Color.white);
		panelInfo5.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panel.add(panelInfo5);
		
		String d1[] = new String[] {"Tên thường gọi","Địa chỉ hiện tại","Số điện thoại","Email"};
		
		for(int i=0;i<4;i++) {
			JLabel lbname01 = new JLabel(d1[i]+": ");
			lbname01.setBounds(20,20+i*30,140,30);
			lbname01.setFont(font);
			lbname01.setForeground(new Color(0,0,0,160));
			panelInfo5.add(lbname01);
			
			JLabel tf1 = new JLabel("null");
			tf1.setBounds(155,20+i*30,200,30);
			tf1.setFont(font);
			tf1.setForeground(new Color(0,0,0,190));
			tf1.setBackground(Color.white);
			panelInfo5.add(tf1);
			labelList.add(tf1);
		}
	
		renderData();
	}
	
	public ArrayList<JLabel> getTextFieldList(){
		return this.labelList;
	}
	public JButton getBtnBack() {
		return this.btnBack;
	}
	public void renderData() {
		for(int i=0;i<labelList.size();i++) {
			labelList.get(i).setText(data[i]);
		}
		if(data[5].equalsIgnoreCase("Thử việc")) {
			labelClassificationList.get(0).setText("Thông tin thử việc");
			labelClassificationList.get(1).setText("Ngày bắt đầu thử việc:");
			labelClassificationList.get(2).setText("Ngày kết thúc thử việc:");
			labelClassificationList.get(3).setText("Lương thử việc:");
			labelClassificationList.get(4).setVisible(false);
			labelClassificationList.get(5).setVisible(false);
			labelList.get(9).setVisible(false);
			labelList.get(10).setVisible(false);
			// set data
			labelList.get(6).setText(data[7]);
			labelList.get(7).setText(data[8]);
			labelList.get(8).setText(data[10]);
		}else {
			labelClassificationList.get(0).setText("Hợp đồng lao động");
			labelClassificationList.get(1).setText("Mã số hợp đồng:");
			labelClassificationList.get(2).setText("Ngày kí hợp đồng:");
			labelClassificationList.get(3).setText("Ngày hết hạn:");
			labelClassificationList.get(4).setVisible(true);
			labelClassificationList.get(5).setVisible(true);
			labelList.get(9).setVisible(true);
			labelList.get(10).setVisible(true);
		}
	}
	public void setData(String[] data) {
		this.data = data;
		
		renderData();
	}
	
	public void setImageEmployee(String path) {
		img.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+path)).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)));
	}
}
