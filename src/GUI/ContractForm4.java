package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.access_LUONG;
import DAO.access_NHANVIEN;
import DAO.access_PHONGBAN;
import DTO.SUPPORT;
import dateChooser.DateChooser;
import view.button.Button;


public class ContractForm4 extends JPanel{
	private myCombobox<String> cbbPhong;
	private myCombobox<String> cbbSort;
	private myCombobox<String> cbbSort2;
	private ArrayList<JLabel> listlabel;
	private JTextField tfBatDauHopDong;
	private JTextField tfKetThucHopDong;
	private JComboBox<String> cbbThoiHanHopDong;
	private JButton btnKiHopDong;
	private myTable table;
	private DefaultTableModel model;
	private Object[][] data;
	private static String[] columnName = {"STT","Nhân viên","Phòng ban","Thử việc từ"};
	
	public ContractForm4() {
		listlabel = new ArrayList<>();
		data = access_NHANVIEN.getDanhSachNhanVienThuViecToRender();
		model = new DefaultTableModel(data,columnName);
		init();
	}
	
	public void init() {
		this.setLayout(null);
		
		
		JPanel panelFeature = new JPanel();
		panelFeature.setBounds(0,0,640,80);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);
		
		JLabel titelLabel = new JLabel("DANH SÁCH NHÂN VIÊN THỬ VIỆC");
		titelLabel.setForeground(new Color(0,0,0,140));
		titelLabel.setFont(new Font("arial", 1, 13));
		titelLabel.setBounds(10,10,250,25);
		panelFeature.add(titelLabel);

		
		cbbPhong = new myCombobox<>();
		
		
		cbbPhong.setFont(new Font("Arial",1,12));
		cbbPhong.setForeground(new Color(0,0,0,200));
		cbbPhong.setBounds(10,45,220,26);
		panelFeature.add(cbbPhong);
		((myCombobox<String>)cbbPhong).showArrow();
		
		
		cbbSort = new myCombobox<>();
		String[] cbbSortString = {"Sắp xếp theo: Mã nhân viên","Sắp xếp theo: Ngày thử việc"};
		cbbSort.setModel(new DefaultComboBoxModel<>(cbbSortString));
		cbbSort.setFont(new Font("Arial",1,12));
		cbbSort.setForeground(new Color(0,0,0,200));
		cbbSort.setBounds(240,45,200,26);
		panelFeature.add(cbbSort);
		((myCombobox<String>)cbbSort).showArrow();
		cbbSort2 = new myCombobox<>();
		String[] cbbSortString2 = {"Tăng dần","Giảm dần"};
		cbbSort2.setModel(new DefaultComboBoxModel<>(cbbSortString2));
		cbbSort2.setFont(new Font("Arial",1,12));
		cbbSort2.setForeground(new Color(0,0,0,200));
		cbbSort2.setBounds(450,45,100,26);
		panelFeature.add(cbbSort2);
		((myCombobox<String>)cbbSort2).showArrow();
		JTextField tfFind = new JTextField();
		tfFind.setFont(new Font("Arial",0,14));
		tfFind.setText(" Tìm kiếm nhanh...");
		tfFind.setForeground(new Color(0,0,0,100));
		tfFind.setBorder(new LineBorder(Color.decode("#3498db"),2));
		tfFind.setBounds(810,45,230,26);
		panelFeature.add(tfFind);
		JButton btnFind = new JButton("");
		btnFind.setFont(new Font("sansserif",1,13));
		btnFind.setIcon(new ImageIcon(getClass().getResource("/assets/img/findemployee.png")));
		btnFind.setBounds(1040,45,30,26);
		btnFind.setBackground(Color.decode("#3498db"));
		btnFind.setBorderPainted(false);
		btnFind.setFocusPainted(false);
		panelFeature.add(btnFind);
		
		
		JPanel panelThuong = new JPanel();
		panelThuong.setBackground(Color.white);
		panelThuong.setBounds(650,0,440,665);
		panelThuong.setLayout(null);
		this.add(panelThuong);
		JLabel titelLabel2 = new JLabel("KÍ HỢP ĐỒNG LAO ĐỘNG");
		titelLabel2.setForeground(new Color(0,0,0,140));
		titelLabel2.setFont(new Font("arial", 1, 13));
		titelLabel2.setBounds(10,10,250,25);
		panelThuong.add(titelLabel2);
		
		JLabel lbt1 = new JLabel("Nhân viên:");
		lbt1.setForeground(new Color(0,0,0,140));
		lbt1.setFont(new Font("arial", 1, 13));
		lbt1.setBounds(10,50,250,25);
		panelThuong.add(lbt1);
		
		JLabel lbt11 = new JLabel("......................................");
		lbt11.setForeground(new Color(0,0,0,140));
		lbt11.setFont(new Font("arial", 1, 13));
		lbt11.setBounds(120,50,250,25);
		panelThuong.add(lbt11);
		listlabel.add(lbt11);
		
		
		
		JLabel lbt2 = new JLabel("Ngày sinh:");
		lbt2.setForeground(new Color(0,0,0,140));
		lbt2.setFont(new Font("arial", 1, 13));
		lbt2.setBounds(10,80,250,25);
		panelThuong.add(lbt2);
		
		JLabel lbt22 = new JLabel("............................");
		lbt22.setForeground(new Color(0,0,0,140));
		lbt22.setFont(new Font("arial", 1, 13));
		lbt22.setBounds(120,80,250,25);
		panelThuong.add(lbt22);
		listlabel.add(lbt22);
		JLabel lbt3 = new JLabel("Giới tính:");
		lbt3.setForeground(new Color(0,0,0,140));
		lbt3.setFont(new Font("arial", 1, 13));
		lbt3.setBounds(260,80,250,25);
		panelThuong.add(lbt3);
		
		JLabel lbt33 = new JLabel("..................");
		lbt33.setForeground(new Color(0,0,0,140));
		lbt33.setFont(new Font("arial", 1, 13));
		lbt33.setBounds(350,80,250,25);
		panelThuong.add(lbt33);
		listlabel.add(lbt33);
		JLabel lbt4 = new JLabel("Địa chỉ:");
		lbt4.setForeground(new Color(0,0,0,140));
		lbt4.setFont(new Font("arial", 1, 13));
		lbt4.setBounds(10,110,250,25);
		panelThuong.add(lbt4);
		
		JLabel lbt44 = new JLabel("........................................................");
		lbt44.setForeground(new Color(0,0,0,140));
		lbt44.setFont(new Font("arial", 1, 13));
		lbt44.setBounds(120,110,300,25);
		panelThuong.add(lbt44);
		listlabel.add(lbt44);
		JLabel lbt5 = new JLabel("Số điện thoại:");
		lbt5.setForeground(new Color(0,0,0,140));
		lbt5.setFont(new Font("arial", 1, 13));
		lbt5.setBounds(10,140,250,25);
		panelThuong.add(lbt5);
		
		JLabel lbt55 = new JLabel("............................");
		lbt55.setForeground(new Color(0,0,0,140));
		lbt55.setFont(new Font("arial", 1, 13));
		lbt55.setBounds(120,140,300,25);
		panelThuong.add(lbt55);
		listlabel.add(lbt55);
		JLabel lbt6 = new JLabel("Email:");
		lbt6.setForeground(new Color(0,0,0,140));
		lbt6.setFont(new Font("arial", 1, 13));
		lbt6.setBounds(10,170,250,25);
		panelThuong.add(lbt6);
		
		JLabel lbt66 = new JLabel("............................");
		lbt66.setForeground(new Color(0,0,0,140));
		lbt66.setFont(new Font("arial", 1, 13));
		lbt66.setBounds(120,170,300,25);
		panelThuong.add(lbt66);
		listlabel.add(lbt66);
		JLabel lbt7 = new JLabel("CMND:");
		lbt7.setForeground(new Color(0,0,0,140));
		lbt7.setFont(new Font("arial", 1, 13));
		lbt7.setBounds(10,200,250,25);
		panelThuong.add(lbt7);
		
		JLabel lbt77 = new JLabel("............................................");
		lbt77.setForeground(new Color(0,0,0,140));
		lbt77.setFont(new Font("arial", 1, 13));
		lbt77.setBounds(120,200,300,25);
		panelThuong.add(lbt77);
		listlabel.add(lbt77);
		
		JLabel lbt8 = new JLabel("Học vấn:");
		lbt8.setForeground(new Color(0,0,0,140));
		lbt8.setFont(new Font("arial", 1, 13));
		lbt8.setBounds(10,230,250,25);
		panelThuong.add(lbt8);
		
		JLabel lbt88= new JLabel("............................");
		lbt88.setForeground(new Color(0,0,0,140));
		lbt88.setFont(new Font("arial", 1, 13));
		lbt88.setBounds(120,230,300,25);
		panelThuong.add(lbt88);
		listlabel.add(lbt88);
		JLabel lbt9 = new JLabel("Chuyên môn:");
		lbt9.setForeground(new Color(0,0,0,140));
		lbt9.setFont(new Font("arial", 1, 13));
		lbt9.setBounds(260,230,250,25);
		panelThuong.add(lbt9);
		
		JLabel lbt99= new JLabel("..................");
		lbt99.setForeground(new Color(0,0,0,140));
		lbt99.setFont(new Font("arial", 1, 13));
		lbt99.setBounds(350,230,300,25);
		panelThuong.add(lbt99);
		listlabel.add(lbt99);
		JLabel lbt10 = new JLabel("Chuyên ngành:");
		lbt10.setForeground(new Color(0,0,0,140));
		lbt10.setFont(new Font("arial", 1, 13));
		lbt10.setBounds(10,260,250,25);
		panelThuong.add(lbt10);
		
		JLabel lbt101= new JLabel("............................");
		lbt101.setForeground(new Color(0,0,0,140));
		lbt101.setFont(new Font("arial", 1, 13));
		lbt101.setBounds(120,260,300,25);
		panelThuong.add(lbt101);
		listlabel.add(lbt101);
		JLabel lbt111 = new JLabel("Phòng ban:");
		lbt111.setForeground(new Color(0,0,0,140));
		lbt111.setFont(new Font("arial", 1, 13));
		lbt111.setBounds(10,290,250,25);
		panelThuong.add(lbt111);
		
		JLabel lbt1111= new JLabel("........................................");
		lbt1111.setForeground(new Color(0,0,0,140));
		lbt1111.setFont(new Font("arial", 1, 13));
		lbt1111.setBounds(120,290,300,25);
		panelThuong.add(lbt1111);
		listlabel.add(lbt1111);
		JLabel lbt222 = new JLabel("Chức vụ:");
		lbt222.setForeground(new Color(0,0,0,140));
		lbt222.setFont(new Font("arial", 1, 13));
		lbt222.setBounds(10,320,250,25);
		panelThuong.add(lbt222);
		
		JLabel lbt2222= new JLabel(".................................");
		lbt2222.setForeground(new Color(0,0,0,140));
		lbt2222.setFont(new Font("arial", 1, 13));
		lbt2222.setBounds(120,320,300,25);
		panelThuong.add(lbt2222);
		listlabel.add(lbt2222);
		JLabel lbt333 = new JLabel("Mức lương:");
		lbt333.setForeground(new Color(0,0,0,140));
		lbt333.setFont(new Font("arial", 1, 13));
		lbt333.setBounds(10,350,250,25);
		panelThuong.add(lbt333);
		
		JLabel lbt3333= new JLabel("............................");
		lbt3333.setForeground(new Color(0,0,0,140));
		lbt3333.setFont(new Font("arial", 1, 13));
		lbt3333.setBounds(120,350,300,25);
		panelThuong.add(lbt3333);
		listlabel.add(lbt3333);
		
		JLabel titelLabel3 = new JLabel("BỔ SUNG THÔNG TIN");
		titelLabel3.setForeground(new Color(0,0,0,140));
		titelLabel3.setFont(new Font("arial", 1, 13));
		titelLabel3.setBounds(10,420,250,25);
		panelThuong.add(titelLabel3);
		
		JLabel lbt444= new JLabel("Bắt đầu hợp đồng");
		lbt444.setForeground(new Color(0,0,0,140));
		lbt444.setFont(new Font("arial", 1, 13));
		lbt444.setBounds(10,450,300,25);
		panelThuong.add(lbt444);
		
		tfBatDauHopDong = new JTextField();
		tfBatDauHopDong.setBounds(10,480,150,28);
		tfBatDauHopDong.setForeground(new Color(0,0,0,140));
		tfBatDauHopDong.setFont(new Font("arial", 1, 13));
		panelThuong.add(tfBatDauHopDong);
		DateChooser dc = new DateChooser();
		dc.setTextRefernce(tfBatDauHopDong);
		
		JLabel lbt555= new JLabel("Kết thúc hợp đồng");
		lbt555.setForeground(new Color(0,0,0,140));
		lbt555.setFont(new Font("arial", 1, 13));
		lbt555.setBounds(200,450,300,25);
		panelThuong.add(lbt555);
		
		tfKetThucHopDong = new JTextField();
		tfKetThucHopDong.setBounds(200,480,150,28);
		tfKetThucHopDong.setForeground(new Color(0,0,0,140));
		tfKetThucHopDong.setFont(new Font("arial", 1, 13));
		panelThuong.add(tfKetThucHopDong);
		tfKetThucHopDong.setEnabled(false);
		
		JLabel lbt4444= new JLabel("Thời hạn hợp đồng");
		lbt4444.setForeground(new Color(0,0,0,140));
		lbt4444.setFont(new Font("arial", 1, 13));
		lbt4444.setBounds(10,520,300,25);
		panelThuong.add(lbt4444);
		
		cbbThoiHanHopDong = new myCombobox<>();
		cbbThoiHanHopDong.setModel(new DefaultComboBoxModel<>(new String[] {"1 năm","2 năm","3 năm","4 năm","5 năm"}));
		cbbThoiHanHopDong.setBounds(10,550,150,30);
		cbbThoiHanHopDong.setForeground(new Color(0,0,0,140));
		cbbThoiHanHopDong.setFont(new Font("arial", 1, 13));
		panelThuong.add(cbbThoiHanHopDong);
		
		
		btnKiHopDong = new Button();
		btnKiHopDong.setText("Tạo hợp đồng");
		btnKiHopDong.setBounds(300,610,120,35);
		btnKiHopDong.setForeground(Color.white);
		btnKiHopDong.setFont(new Font("arial", 1, 13));
		btnKiHopDong.setBackground(Color.decode("#0097e6"));
		panelThuong.add(btnKiHopDong);
		btnKiHopDong.setFocusable(false);
		
		
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setBackground(Color.white);
		jsp1.setVerticalScrollBar(new myScrollBar());
		jsp1.setBorder(new EmptyBorder(0,0,0,0));
		jsp1.setBounds(0,90,780,604);
		this.add(jsp1);
		
		
		
		table = new myTable();
		table.setRowHeight(40);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Color selectedColor = Color.decode("#2980b9");
                Color backgroundSelected = new Color(245,245,245);
				
                
                String str = (String)o;
        		str = "  "+str;
        		o = (Object)str;
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
		});
		jsp1.setViewportView(table);

		table.setModel(model);
		
		formatSizeColumn();

		tfBatDauHopDong.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		    	int thoiHan = Integer.valueOf(cbbThoiHanHopDong.getSelectedItem().toString().split(" ")[0]);
				LocalDate ngayKetThuc = SUPPORT.toLocalDate(tfBatDauHopDong.getText()).plusYears(thoiHan);
				tfKetThucHopDong.setText(SUPPORT.LocalDateToString(ngayKetThuc));
		    }
		    public void removeUpdate(DocumentEvent e) {
		    }
		    public void changedUpdate(DocumentEvent e) {
		    }
		});
		cbbThoiHanHopDong.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int thoiHan = Integer.valueOf(cbbThoiHanHopDong.getSelectedItem().toString().split(" ")[0]);
				LocalDate ngayKetThuc = SUPPORT.toLocalDate(tfBatDauHopDong.getText()).plusYears(thoiHan);
				tfKetThucHopDong.setText(SUPPORT.LocalDateToString(ngayKetThuc));
			}
		});
		
		
	}
	public JButton getBtnKiHopDong() {
		return this.btnKiHopDong;
	}
	public void setSalaryData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		formatSizeColumn();
	}
	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(220);  // anh
		table.getColumnModel().getColumn(2).setPreferredWidth(240);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(120);  // ten
		
		
	}
	public myCombobox<String> getCbbPhong() {
		return cbbPhong;
	}
	public myCombobox<String> getCbbSort() {
		return cbbSort;
	}
	public myCombobox<String> getCbbSort2() {
		return cbbSort2;
	}
	public void setDataForCbbPhong(String data[]) {
		cbbPhong.setModel(new DefaultComboBoxModel<>(data));
	}
	public JTable getTable() {
		return this.table;
	}
	public DefaultTableModel getModel() {
		return this.model;
	}
	public void setDataNhanVienKiHopDong(String [] data) {
		for(int i=0;i<data.length;i++) {
			listlabel.get(i).setText(data[i]);
		}
		LocalDate d = LocalDate.now();
		tfBatDauHopDong.setText(SUPPORT.LocalDateToString(d));
		tfKetThucHopDong.setText(SUPPORT.LocalDateToString(d.plusYears(1)));
		cbbThoiHanHopDong.setSelectedIndex(0);
	}
	public JTextField getTfNgayBatDau() {
		return this.tfBatDauHopDong;
	}
	public JTextField getTfNgayKetThuc() {
		return this.tfKetThucHopDong;
	}
	public JComboBox<String> getCbbThoiHanHopDong(){
		return this.cbbThoiHanHopDong;
	}
	public ArrayList<JLabel> getListLabel(){
		return this.listlabel;
	}
}
