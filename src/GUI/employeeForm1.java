package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import view.button.Button;


public class employeeForm1 extends JPanel{
	private myCombobox<String> cbbFilterPhongBan;
	private myCombobox<String> cbbFilterGioiTinh;
	private myCombobox<String> cbbFilterDoTuoi;
	private myCombobox<String> cbbFilterLoaiHinh;
	private myCombobox<String> cbbFilterMucLuong;
	private myCombobox<String> cbbSortBy;
	private myCombobox<String> cbbSortMode;
	private JTextField findField;
	private JButton btnExport;
	private JButton btnImport;
	private myTable table;
	private DefaultTableModel model;
	private ArrayList<JPanel> optionBtn;
	private JButton btnThem;
	private JPanel optionPanel;
	private Object[][] data;
	private JScrollPane scrollPane;
	private JButton btnFind;
	private static String[] columnName = {"STT","Ảnh","Nhân viên","Giới tính","Ngày sinh","Địa chỉ","Liên hệ","Phòng ban","Chức vụ","Mức lương"};
	
	public employeeForm1() {
		data = null;
		model = new DefaultTableModel(data,columnName) {
			public boolean isCellEditable(int row, int column) {
			       return false;
			   }
		};
		init();
	}
	public void init() {
		this.setLayout(null);
		
		
		JPanel panelFeature = new JPanel();
		panelFeature.setBounds(10,10,1080,90);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);
		
		JLabel titelLabel = new JLabel("Danh sách nhân viên");
		titelLabel.setForeground(new Color(0,0,0,140));
		titelLabel.setFont(new Font("arial", 1, 15));
		titelLabel.setBounds(10,5,166,24);
		panelFeature.add(titelLabel);
		
		
		
		findField = new JTextField();
		
		findField.setBounds(584,10,280,28); //584
		findField.setFont(new Font("Arial",0,14));
		panelFeature.add(findField);
//		findField.setText(" Tìm kiếm nhanh...");
		findField.setForeground(new Color(0,0,0,100));
		btnFind = new Button();
		btnFind.setFont(new Font("sansserif",1,13));
		btnFind.setIcon(new ImageIcon(getClass().getResource("/assets/img/findemployee.png")));
		btnFind.setBounds(858,8,42,38); // 858
		btnFind.setBackground(Color.decode("#3498db"));
		btnFind.setBorderPainted(false);
		btnFind.setFocusPainted(false);
		panelFeature.add(btnFind);
		
		
		
		cbbFilterPhongBan = new myCombobox<>();
		cbbFilterPhongBan.setFont(new Font("Arial",1,13));
		cbbFilterPhongBan.setForeground(new Color(0,0,0,160));
		cbbFilterPhongBan.setBounds(10,50,220,30);
		panelFeature.add(cbbFilterPhongBan);
		cbbFilterPhongBan.setModel(new DefaultComboBoxModel<>(new String[]{"Phòng ban","Phòng nhân sự","Phòng kĩ thuật công nghệ","Phòng nghiên cứu phát triển"}) );
		((myCombobox<String>)cbbFilterPhongBan).showArrow();
		
		cbbFilterGioiTinh = new myCombobox<>();
		cbbFilterGioiTinh.setFont(new Font("Arial",1,13));
		cbbFilterGioiTinh.setForeground(new Color(0,0,0,160));
		cbbFilterGioiTinh.setBounds(240,50,100,30);
		panelFeature.add(cbbFilterGioiTinh);
		cbbFilterGioiTinh.setModel(new DefaultComboBoxModel<>(new String[]{"Giới tính","Nam","Nữ"}) );
		((myCombobox<String>)cbbFilterGioiTinh).showArrow();
		
		cbbFilterDoTuoi = new myCombobox<>();
		cbbFilterDoTuoi.setFont(new Font("Arial",1,13));
		cbbFilterDoTuoi.setForeground(new Color(0,0,0,160));
		cbbFilterDoTuoi.setBounds(350,50,100,30);
		panelFeature.add(cbbFilterDoTuoi);
		cbbFilterDoTuoi.setModel(new DefaultComboBoxModel<>(new String[]{"Độ tuổi","16 - 25","26 - 40","41 - 55","56 - 65"}) );
		((myCombobox<String>)cbbFilterDoTuoi).showArrow();
		
		
		
		
		cbbFilterLoaiHinh = new myCombobox<>();
		cbbFilterLoaiHinh.setFont(new Font("Arial",1,13));
		cbbFilterLoaiHinh.setForeground(new Color(0,0,0,160));
		cbbFilterLoaiHinh.setBounds(460,50,110,30);
		panelFeature.add(cbbFilterLoaiHinh);
		cbbFilterLoaiHinh.setModel(new DefaultComboBoxModel<>(new String[]{"Loại hình","Chính thức","Thử việc"}) );
		((myCombobox<String>)cbbFilterLoaiHinh).showArrow();
		
		cbbFilterMucLuong = new myCombobox<>();
		cbbFilterMucLuong.setFont(new Font("Arial",1,13));
		cbbFilterMucLuong.setForeground(new Color(0,0,0,160));
		cbbFilterMucLuong.setBounds(580,50,110,30);
		panelFeature.add(cbbFilterMucLuong);
		cbbFilterMucLuong.setModel(new DefaultComboBoxModel<>(new String[]{"Mức lương","10M - 20M","20M - 30M","30M - 40M"}) );
		((myCombobox<String>)cbbFilterMucLuong).showArrow();
		
		cbbSortBy = new myCombobox<>();
		cbbSortBy.setFont(new Font("Arial",1,13));
		cbbSortBy.setForeground(new Color(0,0,0,160));
		cbbSortBy.setBounds(700,50,210,30);
		panelFeature.add(cbbSortBy);
		cbbSortBy.setModel(new DefaultComboBoxModel<>(new String[]{"Sắp xếp theo: Mã nhân viên","Sắp xếp theo: Tên nhân viên","Sắp xếp theo: Độ tuổi","Sắp xếp theo: Mức lương"}) );
		((myCombobox<String>)cbbSortBy).showArrow();
		
		cbbSortMode = new myCombobox<>();
		cbbSortMode.setFont(new Font("Arial",1,13));
		cbbSortMode.setForeground(new Color(0,0,0,160));
		cbbSortMode.setBounds(920,50,107,30);
		panelFeature.add(cbbSortMode);
		cbbSortMode.setModel(new DefaultComboBoxModel<>(new String[]{"Tăng dần","Giảm dần"}) );
		((myCombobox<String>)cbbSortMode).showArrow();
		
		JPanel panelResetFilter = new JPanel();
		panelResetFilter.setBounds(1037,50,33,30);
		panelResetFilter.setBackground(Color.decode("#3498db"));
		panelResetFilter.setLayout(null);
		panelFeature.add(panelResetFilter);
		JLabel lbResetIcon = new JLabel();
		lbResetIcon.setIcon(new ImageIcon(getClass().getResource("/assets/img/reset.png")));
		lbResetIcon.setBounds(8,0,panelResetFilter.getWidth(),panelResetFilter.getHeight());
		panelResetFilter.add(lbResetIcon);
		panelResetFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelResetFilter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 new Thread(new Runnable() {
					public void run() {
						reset();
					}
				}).start();
				
			}
			public void mouseEntered(MouseEvent e) {
				panelResetFilter.setBackground(Color.decode("#2980b9"));
			}
			public void mouseExited(MouseEvent e) {
				panelResetFilter.setBackground(Color.decode("#3498db"));
			}
		});

		
		
		
		
		
		
		btnThem = new Button();
		btnThem.setText("Thêm");
		btnThem.setFont(new Font("Arial",1,13));
		btnThem.setForeground(Color.white);
		btnThem.setIcon(new ImageIcon(getClass().getResource("/assets/img/addadd.png")));
		btnThem.setBounds(984,8,90,38);
		btnThem.setBorderPainted(false);
		btnThem.setBackground(Color.decode("#3498db"));
		btnThem.setFocusPainted(false);
		btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFeature.add(btnThem);
		btnImport = new Button();
		btnImport.setFont(new Font("sansserif",1,13));
		btnImport.setIcon(new ImageIcon(getClass().getResource("/assets/img/downfile.png")));
		btnImport.setBounds(942,8,42,38);
		btnImport.setBackground(Color.decode("#3498db"));
		btnImport.setBorderPainted(false);
		btnImport.setFocusPainted(false);
		btnImport.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFeature.add(btnImport);
		btnExport = new Button();
		btnExport.setFont(new Font("sansserif",1,13));
		btnExport.setIcon(new ImageIcon(getClass().getResource("/assets/img/exportfile.png")));
		btnExport.setBounds(900,8,42,38);
		btnExport.setBackground(Color.decode("#3498db"));
		btnExport.setBorderPainted(false);
		btnExport.setFocusPainted(false);
		btnExport.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelFeature.add(btnExport);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.white);
		scrollPane.setVerticalScrollBar(new myScrollBar());
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane.setBounds(10,110,1080,595);
		this.add(scrollPane);
		
		
		
		
		table = new myTable();
		table.setRowHeight(60);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Color selectedColor = Color.decode("#2980b9");
                Color backgroundSelected = new Color(245,245,245);
				if (i1==1) {
                	JPanel p = new JPanel();
                	p.setLayout(null);
                	myImageAvatar img = new myImageAvatar();
                	String str = (String)o;
                	img.setIcon(new ImageIcon(getClass().getResource("/assets/img/user_img/"+str)));
                	img.setBounds(0,10,38,38);
                	p.add(img);
                	if (selected) {
                    	p.setBackground(backgroundSelected);
                    } else {
                    	p.setBackground(Color.WHITE);
                    }
                    return p;
                }else if (i1==2) {
                	String str = (String)o;
                	String[] arr = str.split(",");
                    JPanel p = new JPanel();
                    p.setLayout(null);
                    JLabel lbname = new JLabel(arr[0]+" - "+arr[1]);
                    lbname.setFont(new Font("sansserif",1,13));
                    lbname.setBounds(0,10,220,20);
                    p.add(lbname);
                    JLabel lbname2 = new JLabel(arr[2]);
                    lbname2.setFont(new Font("sansserif",0,13));
                    lbname2.setBounds(0,28,140,20);
                    p.add(lbname2);
                    if (selected) {
                    	lbname.setForeground(selectedColor);
                    	lbname2.setForeground(selectedColor);
                        p.setBackground(backgroundSelected);
                    }else{
                    	lbname2.setForeground(new Color(102, 102, 102));
                        p.setBackground(Color.WHITE);
                    }
                    return p;
                }else {
                	if(i1==0) {
                		String str = (String)o;
                		str = "   "+str;
                		o = (Object)str;
                	}
                	Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    setBorder(noFocusBorder);
                    if (selected) {
                    	com.setBackground(backgroundSelected);
                    	com.setFont(new Font("Arial",Font.PLAIN,13));
                        com.setForeground(selectedColor);
                    } else {
                    	com.setBackground(Color.WHITE);
                    	com.setFont(new Font("Arial",Font.PLAIN,13));
                        com.setForeground(new Color(102, 102, 102));
                    }
                   return com;
                }
            }
		});
		scrollPane.setViewportView(table);

		table.setModel(model);
		
		
		optionPanel = new JPanelOval();
//		optionPanel.setBorder(new LineBorder(Color.gray,1));

		((JPanelOval)optionPanel).setColor(new Color(0,0,0,60));
		optionPanel.setLayout(null);
		table.add(optionPanel);
		JPanelOval panelTemp = new JPanelOval();
		panelTemp.setBounds(1,1,138,98);
		panelTemp.setLayout(null);
		panelTemp.setColor(Color.white);
		optionPanel.add(panelTemp);
		
		String infoNameBtn[] = {"Xóa","Sửa","Chi tiết"};
		String infoIconBtn[] = {"delete.png","edit.png","info.png"};
		optionBtn = new ArrayList<>();
		
		
		for(int i=0;i<3;i++) {
			JPanel btnDel = new JPanel();
			btnDel.setBackground(Color.white);
			btnDel.setFont(new Font("sansserif", 0, 14));
			btnDel.setBounds(6,5+i*30,126,30);
			panelTemp.add(btnDel);
			btnDel.setLayout(null);
			JLabel lbicondel = new JLabel();
			lbicondel.setBounds(10,0,30,30);
			lbicondel.setIcon(new ImageIcon(getClass().getResource("/assets/img/"+infoIconBtn[i])));
			btnDel.add(lbicondel);
			JLabel lbicondel2 = new JLabel(infoNameBtn[i]);
			lbicondel2.setFont(new Font("sansserif", 0, 14));
			lbicondel2.setBounds(50,0,70,30);
			btnDel.add(lbicondel2);
			optionBtn.add(btnDel);
		}
		for(JPanel i : optionBtn) {
			i.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					i.setBackground(Color.white);
					repaint();
				}
				public void mouseEntered(MouseEvent e) {
					i.setBackground(new Color(235,235,235));
					repaint();
				}
			});
		}

		
		optionPanel.setVisible(false);
	}
	public void setData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		formatSizeColumn();
		if(data.length>=10) {
			table.setPreferredSize(null);			
		}else {
			table.setPreferredSize(new Dimension(1075,600));
		}
	}
	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(60);  // anh
		table.getColumnModel().getColumn(2).setPreferredWidth(195);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(70);   // gioitinh
		table.getColumnModel().getColumn(4).setPreferredWidth(80);  // ngaysinh
		table.getColumnModel().getColumn(5).setPreferredWidth(150);  // diachi
		table.getColumnModel().getColumn(6).setPreferredWidth(90);  // lienhe
		table.getColumnModel().getColumn(7).setPreferredWidth(150);   // phongban
		table.getColumnModel().getColumn(8).setPreferredWidth(120);  // chucvu
		table.getColumnModel().getColumn(9).setPreferredWidth(100);  // luong
	}
	public JButton getBtnThem() {
		return this.btnThem;
	}
	public ArrayList<JPanel> getOptionBtn(){
		return this.optionBtn;
	}
	public myTable getTable() {
		return this.table;
	}
	public JPanel getOptionPanel() {
		return this.optionPanel;
	}
	public DefaultTableModel getModel() {
		return this.model;
	}
	public JButton getBtnExport() {
		return btnExport;
	}
	public String[] getIDEmployeeToDelete() {
		int n = table.getSelectedRowCount();
		String str[] = new String[n];
		if( n>1) {
			int arr[] = table.getSelectedRows();
			for(int i=0;i<arr.length;i++) {
				str[i] = (model.getValueAt(arr[i], 2)+"").split(",")[0];
			}
			return str;
		}
		return new String[] { (model.getValueAt(table.getSelectedRow(),2)+"").split(",")[0]};
		
		
	}
	public myCombobox<String> getCbbFilterPhongBan() {
		return cbbFilterPhongBan;
	}
	public myCombobox<String> getCbbFilterGioiTinh() {
		return cbbFilterGioiTinh;
	}
	public myCombobox<String> getCbbFilterDoTuoi() {
		return cbbFilterDoTuoi;
	}
	public myCombobox<String> getCbbFilterLoaiHinh() {
		return cbbFilterLoaiHinh;
	}
	public myCombobox<String> getCbbFilterMucLuong() {
		return cbbFilterMucLuong;
	}
	public myCombobox<String> getCbbSortBy() {
		return cbbSortBy;
	}
	public myCombobox<String> getCbbSortMode() {
		return cbbSortMode;
	}
	public static String[] getColumnName() {
		return columnName;
	}
	public JTextField getFindField() {
		return this.findField;
	}
	public JButton getBtnImport() {
		return this.btnImport;
	}
	public void setCbbFilterPhongBanData(String data[]) {
		this.cbbFilterPhongBan.setModel(new DefaultComboBoxModel<>(data));
	}
	public String getFindText() {
		String find= findField.getText().trim();
		if(find.equals("Tìm kiếm nhanh...")) {
			return "";
		}else {
			return find;
		}
	}
	public void reset() {
		cbbFilterPhongBan.setSelectedIndex(0);
		cbbFilterGioiTinh.setSelectedIndex(0);
		cbbFilterDoTuoi.setSelectedIndex(0);
		cbbFilterLoaiHinh.setSelectedIndex(0);
		cbbFilterMucLuong.setSelectedIndex(0);
		cbbSortBy.setSelectedIndex(0);
		cbbSortMode.setSelectedIndex(0);
	}
	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}
	public JButton getBtnFind() {
		return this.btnFind;
	}
}
