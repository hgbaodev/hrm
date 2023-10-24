package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;

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


public class SalaryForm3 extends JPanel{
	
	private myCombobox<String> cbbThang;
	private myCombobox<String> cbbNam;
	private myCombobox<String> cbbPhong;
	private myCombobox<String> cbbSort;
	private myCombobox<String> cbbSort2;
	private myCombobox<String> cbbNamPhuCap;
	private myCombobox<String> cbbThangPhuCap;
	private myCombobox<String> cbbNamTru;
	private myCombobox<String> cbbThangTru;
	private JTextField tfMaNhanVienPhuCap;
	private JTextField tfMucPhuCap;
	private myTable table;
	private DefaultTableModel model;
	private Object[][] data;
	private JButton btnPhuCap;
	private JButton btnKhoanTru;
	private JTextField tfMaNhanVienTru;
	private JTextField tfMucTru;
	private static String[] columnName = {"STT","Nhân viên","Thời gian","Phụ cấp chức vụ","Phụ cấp khác","Trừ BHXH,BHYT","Khoản trừ khác"};
	
	public SalaryForm3() {
		
		
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
		panelFeature.setBounds(0,0,780,80);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);
		
		JLabel titelLabel = new JLabel("PHỤ CẤP VÀ CÁC KHOẢN TRỪ");
		titelLabel.setForeground(new Color(0,0,0,140));
		titelLabel.setFont(new Font("arial", 1, 13));
		titelLabel.setBounds(10,10,250,25);
		panelFeature.add(titelLabel);

		cbbNam = new myCombobox<>();
		String[] cbbNamString = new String[5];
		LocalDate localDate = LocalDate.now();
		cbbNamString[0] = "Năm";
		for(int i=0;i<4;i++) {
			cbbNamString[i+1] = "Năm "+(localDate.getYear()-i);
		}
		
		cbbNam.setModel(new DefaultComboBoxModel<>(cbbNamString));
		cbbNam.setFont(new Font("Arial",1,12));
		cbbNam.setForeground(new Color(0,0,0,200));
		cbbNam.setBounds(10,45,100,26);
		panelFeature.add(cbbNam);
		((myCombobox<String>)cbbNam).showArrow();
		
		cbbThang = new myCombobox<>();
		String[] cbbThangString = {"Tháng","Tháng 01","Tháng 02","Tháng 03","Tháng 04","Tháng 05","Tháng 06","Tháng 07","Tháng 08","Tháng 09","Tháng 10","Tháng 11","Tháng 12"};
		cbbThang.setModel(new DefaultComboBoxModel<>(cbbThangString));
		cbbThang.setFont(new Font("Arial",1,12));
		cbbThang.setForeground(new Color(0,0,0,200));
		cbbThang.setBounds(120,45,100,26);
		cbbThang.setMaximumRowCount(5);
		
		
		panelFeature.add(cbbThang);
		((myCombobox<String>)cbbThang).showArrow();
		cbbPhong = new myCombobox<>();
		cbbPhong = new myCombobox<>();
		
		
		cbbPhong.setFont(new Font("Arial",1,12));
		cbbPhong.setForeground(new Color(0,0,0,200));
		cbbPhong.setBounds(230,45,220,26);
		panelFeature.add(cbbPhong);
		((myCombobox<String>)cbbPhong).showArrow();
		
		
		cbbSort = new myCombobox<>();
		String[] cbbSortString = {"Sắp xếp theo: Thời gian","Sắp xếp theo: Khoản phụ cấp","Sắp xếp theo: Khoản trừ"};
		cbbSort.setModel(new DefaultComboBoxModel<>(cbbSortString));
		cbbSort.setFont(new Font("Arial",1,12));
		cbbSort.setForeground(new Color(0,0,0,200));
		cbbSort.setBounds(460,45,200,26);
		panelFeature.add(cbbSort);
		((myCombobox<String>)cbbSort).showArrow();
		cbbSort2 = new myCombobox<>();
		String[] cbbSortString2 = {"Tăng dần","Giảm dần"};
		cbbSort2.setModel(new DefaultComboBoxModel<>(cbbSortString2));
		cbbSort2.setFont(new Font("Arial",1,12));
		cbbSort2.setForeground(new Color(0,0,0,200));
		cbbSort2.setBounds(670,45,100,26);
		panelFeature.add(cbbSort2);
		((myCombobox<String>)cbbSort2).showArrow();

		
		JPanel panelThuong = new JPanel();
		panelThuong.setBackground(Color.white);
		panelThuong.setBounds(790,0,290,320);
		panelThuong.setLayout(null);
		this.add(panelThuong);
		JLabel titelLabel2 = new JLabel("PHỤ CẤP NHÂN SỰ");
		titelLabel2.setForeground(new Color(0,0,0,140));
		titelLabel2.setFont(new Font("arial", 1, 13));
		titelLabel2.setBounds(10,10,250,25);
		panelThuong.add(titelLabel2);
		JLabel lbthoigian = new JLabel("Thời gian");
		lbthoigian.setFont(new Font("Arial",0,14));
		lbthoigian.setForeground(new Color(0,0,0,160));
		lbthoigian.setBounds(10,50,200,30);
		panelThuong.add(lbthoigian);
		cbbNamPhuCap = new myCombobox<>();
		cbbNamPhuCap.setModel(new DefaultComboBoxModel<>(cbbNamString));
		cbbNamPhuCap.setForeground(new Color(0,0,0,160));
		cbbNamPhuCap.setBounds(10,80,130,30);
		cbbNamPhuCap.setFont(new Font("Arial",1,12));
		cbbNamPhuCap.showArrow();
		panelThuong.add(cbbNamPhuCap);
		
		cbbThangPhuCap = new myCombobox<>();
		cbbThangPhuCap.setModel(new DefaultComboBoxModel<>(cbbThangString));
		cbbThangPhuCap.setForeground(new Color(0,0,0,160));
		cbbThangPhuCap.setBounds(150,80,130,30);
		cbbThangPhuCap.setFont(new Font("Arial",1,12));
		cbbThangPhuCap.showArrow();
		panelThuong.add(cbbThangPhuCap);
		JLabel lbmaNhanVienPhuCap = new JLabel("Mã nhân viên");
		lbmaNhanVienPhuCap.setFont(new Font("Arial",0,14));
		lbmaNhanVienPhuCap.setForeground(new Color(0,0,0,160));
		lbmaNhanVienPhuCap.setBounds(10,120,300,30);
		panelThuong.add(lbmaNhanVienPhuCap);
		tfMaNhanVienPhuCap = new JTextField();
		tfMaNhanVienPhuCap.setForeground(new Color(0,0,0,160));
		tfMaNhanVienPhuCap.setBounds(10,150,270,30);
		tfMaNhanVienPhuCap.setFont(new Font("Arial",1,12));
		panelThuong.add(tfMaNhanVienPhuCap);
		
		JLabel lbdonvi22 = new JLabel("Phụ cấp khác");
		lbdonvi22.setFont(new Font("Arial",0,14));
		lbdonvi22.setForeground(new Color(0,0,0,160));
		lbdonvi22.setBounds(10,190,300,30);
		panelThuong.add(lbdonvi22);
		tfMucPhuCap = new JTextField();
		tfMucPhuCap.setForeground(new Color(0,0,0,160));
		tfMucPhuCap.setBounds(10,220,270,30);
		tfMucPhuCap.setFont(new Font("Arial",1,12));
		panelThuong.add(tfMucPhuCap);
		

		
		btnPhuCap = new JButton("Xác nhận");
		btnPhuCap.setBounds(190,280,90,28);
		btnPhuCap.setFont(new Font("Arial",1,12));
		btnPhuCap.setForeground(new Color(0,0,0,160));
		panelThuong.add(btnPhuCap);
		
		

		JPanel panelTangLuong = new JPanel();
		panelTangLuong.setBackground(Color.white);
		panelTangLuong.setBounds(790,330,290,320);
		panelTangLuong.setLayout(null);
		this.add(panelTangLuong);
		JLabel titelTangLuong = new JLabel("KHOẢN TRỪ");
		titelTangLuong.setForeground(new Color(0,0,0,140));
		titelTangLuong.setFont(new Font("arial", 1, 13));
		titelTangLuong.setBounds(10,10,250,25);
		panelTangLuong.add(titelTangLuong);
		JLabel lbthoigian2 = new JLabel("Thời gian");
		lbthoigian2.setFont(new Font("Arial",0,14));
		lbthoigian2.setForeground(new Color(0,0,0,160));
		lbthoigian2.setBounds(10,50,200,30);
		panelTangLuong.add(lbthoigian2);
		cbbNamTru = new myCombobox<>();
		cbbNamTru.setModel(new DefaultComboBoxModel<>(cbbNamString));
		cbbNamTru.setForeground(new Color(0,0,0,160));
		cbbNamTru.setBounds(10,80,130,30);
		cbbNamTru.setFont(new Font("Arial",1,12));
		cbbNamTru.showArrow();
		panelTangLuong.add(cbbNamTru);
		
		cbbThangTru = new myCombobox<>();
		cbbThangTru.setModel(new DefaultComboBoxModel<>(cbbThangString));
		cbbThangTru.setForeground(new Color(0,0,0,160));
		cbbThangTru.setBounds(150,80,130,30);
		cbbThangTru.setFont(new Font("Arial",1,12));
		cbbThangTru.showArrow();
		panelTangLuong.add(cbbThangTru);
		JLabel lbtangluong = new JLabel("Mã nhân viên");
		lbtangluong.setFont(new Font("Arial",0,14));
		lbtangluong.setForeground(new Color(0,0,0,160));
		lbtangluong.setBounds(10,120,300,30);
		panelTangLuong.add(lbtangluong);
		tfMaNhanVienTru = new JTextField();
		tfMaNhanVienTru.setForeground(new Color(0,0,0,160));
		tfMaNhanVienTru.setBounds(10,150,270,30);
		tfMaNhanVienTru.setFont(new Font("Arial",1,12));
		panelTangLuong.add(tfMaNhanVienTru);
		
		
		JLabel lbtangluong2 = new JLabel("Khoản trừ khác");
		lbtangluong2.setFont(new Font("Arial",0,14));
		lbtangluong2.setForeground(new Color(0,0,0,160));
		lbtangluong2.setBounds(10,190,300,30);
		panelTangLuong.add(lbtangluong2);
		tfMucTru = new JTextField();
		tfMucTru.setForeground(new Color(0,0,0,160));
		tfMucTru.setBounds(10,220,270,30);
		tfMucTru.setFont(new Font("Arial",1,12));
		panelTangLuong.add(tfMucTru);
		
		
		btnKhoanTru = new JButton("Xác nhận");
		btnKhoanTru.setBounds(190,280,90,28);
		btnKhoanTru.setFont(new Font("Arial",1,12));
		btnKhoanTru.setForeground(new Color(0,0,0,160));
		panelTangLuong.add(btnKhoanTru);
		
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

		
		
		
	}


	public void setData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		formatSizeColumn();
	}
	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(180);  // anh
		table.getColumnModel().getColumn(2).setPreferredWidth(100);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(120);   // gioitinh
		table.getColumnModel().getColumn(4).setPreferredWidth(110);  // ngaysinh
		table.getColumnModel().getColumn(5).setPreferredWidth(110);  // diachi
		table.getColumnModel().getColumn(6).setPreferredWidth(100);  // diachi
		
	}
	public myCombobox<String> getCbbNam() {
		return cbbNam;
	}
	public myCombobox<String> getCbbThang() {
		return cbbThang;
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
	public JButton getBtnPhuCap() {
		return this.btnPhuCap;
	}

	public JButton getBtnKhoanTru() {
		return this.btnKhoanTru;
	}
	public JTextField getTfMaNhanVienTru() {
		return this.tfMaNhanVienTru;
	}
	public JTextField getTfMucTru() {
		return this.tfMucTru;
	}
	public JTextField getTfMaNhanVienPhuCap() {
		return this.tfMaNhanVienPhuCap;
	}
	public JTextField getTfMucPhuCap() {
		return this.tfMucPhuCap;
	}
	public myCombobox<String> getCbbNamPhuCap() {
		return cbbNamPhuCap;
	}
	public myCombobox<String> getCbbThangPhuCap() {
		return cbbThangPhuCap;
	}
	public myCombobox<String> getCbbNamTru() {
		return cbbNamTru;
	}
	public myCombobox<String> getCbbThangTru() {
		return cbbThangTru;
	}
	public String[] getDataPhuCap() {
		return new String[] {
			cbbNamPhuCap.getSelectedItem().toString(),
			cbbThangPhuCap.getSelectedItem().toString(),
			tfMaNhanVienPhuCap.getText().trim(),
			tfMucPhuCap.getText().trim(),
		};
	}
	public String[] getDataKhoanTru() {
		return new String[] {
			cbbNamTru.getSelectedItem().toString(),
			cbbThangTru.getSelectedItem().toString(),
			tfMaNhanVienTru.getText().trim(),
			tfMucTru.getText().trim(),
		};
	}
	public myTable getTable() {
		return table;
	}

	public void setTable(myTable table) {
		this.table = table;
	}

	public void setTfMaNhanVienPhuCap(JTextField tfMaNhanVienPhuCap) {
		this.tfMaNhanVienPhuCap = tfMaNhanVienPhuCap;
	}

	public void setTfMaNhanVienTru(JTextField tfMaNhanVienTru) {
		this.tfMaNhanVienTru = tfMaNhanVienTru;
	}

	public void setCbbThang(myCombobox<String> cbbThang) {
		this.cbbThang = cbbThang;
	}

	public void setCbbNam(myCombobox<String> cbbNam) {
		this.cbbNam = cbbNam;
	}

	public void setCbbNamPhuCap(myCombobox<String> cbbNamPhuCap) {
		this.cbbNamPhuCap = cbbNamPhuCap;
	}

	public void setCbbThangPhuCap(myCombobox<String> cbbThangPhuCap) {
		this.cbbThangPhuCap = cbbThangPhuCap;
	}

	public void setCbbNamTru(myCombobox<String> cbbNamTru) {
		this.cbbNamTru = cbbNamTru;
	}

	public void setCbbThangTru(myCombobox<String> cbbThangTru) {
		this.cbbThangTru = cbbThangTru;
	}
}
