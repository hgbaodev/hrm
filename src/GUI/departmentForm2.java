package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.access_PHONGBAN;
import DTO.SUPPORT;
import GUI.Department_Add.ACTION_TYPE;
import control.huyThemPhongBan;
import view.button.Button;



public class departmentForm2 extends JPanel{
	private DefaultTableModel  model;
	private DefaultTableModel  modelEmployee;
	private myTable table;
	private myTable tableEmployee;
	private String []str = new String[] {"STT","Phòng ban","Ngày thành lập","Trưởng phòng","Ngày nhận chức","Nhân viên","Lương trung bình"};
	private String [] c1 = {"STT","Nhân viên","Loại hình","Chức vụ"};
	private Object[][] departmentData;
	private Object[][] employeeData;
	private JLabel titleEmployee;
	private JLabel lbimgEmployee;
	private ArrayList<JButton> btnActionList;
	private ArrayList<JLabel> infoEmployeeList;
	private Department_Add department_add;
	private myCombobox<String> cbbPhongBan;
	private myCombobox<String> cbbChucVu;
	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnIfo;
	private String listPhongBan[];
	private String listChucVu[];
	
	public departmentForm2() {
		department_add = new Department_Add();
		huyThemPhongBan htpb = new huyThemPhongBan(department_add);
		department_add.getBtnHuy().addActionListener(htpb);
		department_add.setVisible(false);
		init();
	}
	public void init() {
		setBackground(Color.white);
		this.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.white);
		panelTop.setBounds(10,10,1055,300);
		panelTop.setBorder(new LineBorder(Color.gray,1));
		this.add(panelTop);
		panelTop.setLayout(null);
		
		JPanel panelTopTitle = new JPanel();
		panelTopTitle.setBounds(1,1,1043,40);
		panelTopTitle.setBackground(Color.white);
		panelTop.add(panelTopTitle);
		panelTopTitle.setLayout(null);
	
		JLabel lbtt = new JLabel("Quản lý phòng ban");
		lbtt.setFont(new Font("Arial",1,14));
		lbtt.setForeground(new Color(0,0,0,140));
		lbtt.setBounds(10,4,280,30);
		panelTopTitle.add(lbtt);
		
		
		String btnName[] = {"Xuất","Xóa","Sửa","Tạo"};
		
		Color btnColor[] = {Color.decode("#0fb9b1"),Color.decode("#ff4d4d"),Color.decode("#1e90ff"),Color.decode("#4cd137")};
		Color btnColor2[] = {Color.decode("#3498db"),Color.decode("#3498db"),Color.decode("#3498db"),Color.decode("#3498db")};
		String btnIcon[] = {"file2.png","deldepartment.png","editdepartment.png","add3.png"};
		btnActionList = new ArrayList<>();
		for(int i=0;i<4;i++) {
			// xóa
			JButton btn = new Button();
			((Button)btn).setShadowColor(new Color(0,0,0,120));
			btn.setFocusable(false);
			btn.setBounds(732+i*78,6,80,33);
			btn.setFont(new Font("Arial",1,12));
			btn.setBackground(btnColor2[i]);
			btn.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/"+btnIcon[i])));
			btn.setText(btnName[i]);
			btn.setForeground(Color.white);
			panelTopTitle.add(btn);
			btnActionList.add(btn);
		}
		
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.setVerticalScrollBar(new myScrollBar());
		jsp.setBorder(new EmptyBorder(0,0,0,0));
		jsp.setBounds(1,40,1043,250);
		table = new myTable();
		renderDepartmentData();
		
		jsp.setViewportView(table);
		panelTop.add(jsp);
		
		
		
		
		
		
		
		JPanel panelB1 = new JPanel();
		panelB1.setLayout(null);
		panelB1.setBounds(10,320,680,330);
		panelB1.setBackground(Color.white);
		panelB1.setBorder(new LineBorder(new Color(0,0,0,100),1));
		this.add(panelB1);
		
		titleEmployee = new JLabel("Nhân viên  -  Phòng nhân sự");
		titleEmployee.setFont(new Font("Arial",1,14));
		titleEmployee.setForeground(new Color(0,0,0,140));
		titleEmployee.setBounds(10,10,400,30);
		panelB1.add(titleEmployee);
		
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setVerticalScrollBar(new myScrollBar());
		jsp1.setBackground(Color.white);
		jsp1.setBounds(1,40,678,280);
		panelB1.add(jsp1);
		
		tableEmployee = new myTable();
		
		
		renderEmployeeData();
		jsp1.setViewportView(tableEmployee);
		jsp1.setBorder(new EmptyBorder(0,0,0,0));
		formatColumnEmployee();
		
		
		// 2
		
		
		
		// 3
		JPanel panelB3 = new JPanel();
		panelB3.setLayout(null);
		panelB3.setBounds(700,320,365,330);
		panelB3.setBackground(Color.white);
		panelB3.setBorder(new LineBorder(new Color(0,0,0,100),1));
		this.add(panelB3);
		

		JLabel lt4 = new JLabel("Thông tin nhân viên");
		lt4.setFont(new Font("Arial",1,14));
		lt4.setForeground(new Color(0,0,0,140));
		lt4.setBounds(20,10,300,30);
		panelB3.add(lt4);
		
		lbimgEmployee = new JLabel();
		lbimgEmployee.setBounds(250,50,100,120);
		lbimgEmployee.setBorder(new LineBorder(Color.gray,2));
		lbimgEmployee.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/none_user.jpg")).getImage().getScaledInstance(lbimgEmployee.getWidth(), lbimgEmployee.getHeight(), Image.SCALE_DEFAULT)));
		panelB3.add(lbimgEmployee);
		
		String nifo[] = {"Mã số","Họ tên","Giới tính","Ngày sinh","Điện thoại","Địa chỉ","Phòng ban","Chức vụ","Ngày nhận chức"};
		
		
		infoEmployeeList = new ArrayList<>();
		for(int i=0;i<nifo.length;i++) {
			JLabel t1 = new JLabel(nifo[i]+":");
			t1.setBounds(20,45+i*26,100,25);
			t1.setFont(new Font("Arial", 1, 12));
			t1.setForeground(new Color(0,0,0,160));
			panelB3.add(t1);
			JLabel t11 = new JLabel("");
			t11.setBounds(100,45+i*26,200,25);
			t11.setFont(new Font("Arial", 1, 12));
			t11.setForeground(Color.decode("#2e86de"));
			panelB3.add(t11);
			infoEmployeeList.add(t11);
			
		}
		
		cbbPhongBan = new myCombobox<>();
		cbbPhongBan.setBounds(100,201,180,23);
		panelB3.add(cbbPhongBan);
		
		cbbPhongBan.setModel(new DefaultComboBoxModel<>(str));
		cbbPhongBan.setFont(new Font("Arial",1,12));
		cbbPhongBan.setForeground(Color.decode("#2e86de"));
		cbbPhongBan.setMaximumRowCount(5);
		cbbPhongBan.setVisible(false);
		
		cbbChucVu = new myCombobox<>();
		cbbChucVu.setBounds(100,228,180,23);
		panelB3.add(cbbChucVu);
		cbbChucVu.setFont(new Font("Arial",1,12));
		cbbChucVu.setForeground(Color.decode("#2e86de"));
		cbbChucVu.setVisible(false);
		cbbChucVu.setMaximumRowCount(4);
		
		
		
		btnHuy =new Button();
		btnHuy.setText("Hủy");
		
		btnHuy.setBounds(188,290,80,35);
		btnHuy.setFocusable(false);
		btnHuy.setFont(new Font("Arial",1,12));
		btnHuy.setForeground(new Color(0,0,0,180));
		btnHuy.setBackground(Color.decode("#7f8c8d"));
		panelB3.add(btnHuy);
		
		
		
		btnLuu =new Button();
		btnLuu.setText("Lưu");
		btnLuu.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		btnLuu.setBounds(274,290,80,35);
		btnLuu.setFocusable(false);
		btnLuu.setFont(new Font("Arial",1,12));
		btnLuu.setForeground(new Color(255,255,255,240));
		btnLuu.setBackground(Color.decode("#4cd137"));
		panelB3.add(btnLuu);
		
		
		
		btnIfo = new Button();
		btnIfo.setFocusable(false);
		btnIfo.setBounds(240,295,120,34);
		btnIfo.setBackground(Color.decode("#4cd137"));
		btnIfo.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/editdepartment.png")));
		btnIfo.setForeground(Color.white);
		btnIfo.setFont(new Font("Arial",1,12));
		btnIfo.setText("Điều chỉnh");
		panelB3.add(btnIfo);
		
		
		btnActionList.get(3).addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				department_add.setType(ACTION_TYPE.ADD);                                   
				department_add.setDataToEdit(new String[] {"","",SUPPORT.LocalDateToString(LocalDate.now())});
				department_add.showOn();
				
			}
		});
		
		// action 
		btnIfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = getIndexPhongBan(infoEmployeeList.get(6).getText());
				cbbPhongBan.setSelectedIndex(index);
				int indexChucVu = getIndexChucVu(infoEmployeeList.get(7).getText());
				cbbChucVu.setSelectedIndex(indexChucVu);
				changeEditType(1);
			}
		});
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeEditType(0);
			}
		} );
		
		changeEditType(0);
	}
	public void setListChucVu(String data[]) {
		this.listChucVu = data;
		cbbChucVu.setModel(new DefaultComboBoxModel<>(listChucVu));
		
	}
	public int getIndexPhongBan(String tenPhong) {
		for(int i=0;i<listPhongBan.length;i++) {
			if(tenPhong.equalsIgnoreCase(listPhongBan[i])) {
				return i;
			}
		}
		return -1;
	}
	public int getIndexChucVu(String chucVu) {
		for(int i=0;i<listChucVu.length;i++) {
			if(chucVu.equalsIgnoreCase(listChucVu[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public void setListPhongBan(String str[]) {
		this.listPhongBan = str;
		cbbPhongBan.setModel(new DefaultComboBoxModel<>(str));
	}
	public void changeEditType(int type) {
		if(type==0) {
			infoEmployeeList.get(6).setVisible(true);
			infoEmployeeList.get(7).setVisible(true);
			cbbPhongBan.setVisible(false);
			cbbChucVu.setVisible(false);
			btnLuu.setVisible(false);
			btnHuy.setVisible(false);
			btnIfo.setVisible(true);
		}else {
			infoEmployeeList.get(6).setVisible(false);
			infoEmployeeList.get(7).setVisible(false);
			cbbPhongBan.setVisible(true);
			cbbChucVu.setVisible(true);
			btnLuu.setVisible(true);
			btnHuy.setVisible(true);
			btnIfo.setVisible(false);
		}
	}
	public myCombobox<String> getCbbPhongBan(){
		return this.cbbPhongBan;
	}
	public myCombobox<String> getCbbChucVu(){
		return this.cbbChucVu;
	}
	public ArrayList<JLabel> getInfoEmployeeList() {
		return this.infoEmployeeList;
	}
	public JButton getBtnLuu() {
		return this.btnLuu;
	}
	public JButton getBtnInfo() {
		return this.btnIfo;
	}
	public Department_Add getDepartmentAdd() {
		return this.department_add;
	}
	public ArrayList<JButton> getBtnActionList(){
		return this.btnActionList;
	}
	public void setImgEmployee(String img) {
		lbimgEmployee.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+img)).getImage().getScaledInstance(lbimgEmployee.getWidth(), lbimgEmployee.getHeight(), Image.SCALE_DEFAULT)));
	}
	public void setInfoEmployeeData(String str[]) {
		
		for(int i=0;i<str.length;i++) {
			infoEmployeeList.get(i).setText(str[i]);
		}
	}
	public void setTitleEmployee(String str) {
		this.titleEmployee.setText(str);
	}
	public DefaultTableModel getModel() {
		return this.model;
	}
	public DefaultTableModel getModelEmployee() {
		return this.modelEmployee;
	}
	public myTable getTable() {
		return this.table;
	}
	public myTable getTableEmployee() {
		return this.tableEmployee;
	}
	
	public void formatColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(240);  // stt
		table.getColumnModel().getColumn(2).setPreferredWidth(150);  // stt
		table.getColumnModel().getColumn(3).setPreferredWidth(190);  // stt
		table.getColumnModel().getColumn(4).setPreferredWidth(144);  // stt
		table.getColumnModel().getColumn(5).setPreferredWidth(120);  // stt
		table.getColumnModel().getColumn(6).setPreferredWidth(113);  // stt
	}
	public void formatColumnEmployee() {
		tableEmployee.getColumnModel().getColumn(0).setPreferredWidth(80);  // stt
		tableEmployee.getColumnModel().getColumn(1).setPreferredWidth(220);  // stt
		tableEmployee.getColumnModel().getColumn(2).setPreferredWidth(160);  // stt
		tableEmployee.getColumnModel().getColumn(3).setPreferredWidth(200);  // stt
	}
	public void setDepartmentData(Object[][] data) {
		departmentData  = data;
		renderDepartmentData();
	}
	public Object[][] getDepartmentData(){
		return this.departmentData;
	}
	public void setEmployeeData(Object[][] data) {
		employeeData  = data;
		renderEmployeeData();
	}
	public void renderDepartmentData() {
		model = new DefaultTableModel(departmentData,str) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table.setModel(model);
		formatColumn();
	}
	public void renderEmployeeData() {
		modelEmployee = new DefaultTableModel(employeeData,c1) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		tableEmployee.setModel(modelEmployee);
		formatColumnEmployee();
	}
}
