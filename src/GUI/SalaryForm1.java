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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import view.button.Button;


public class SalaryForm1 extends JPanel{
	private myCombobox<String> cbbNam;
	private myCombobox<String> cbbThang;
	private myCombobox<String> cbbPhong;
	private myCombobox<String> cbbSort;
	private myCombobox<String> cbbSort2;

	

	private JButton btnExportExcel;
	private myTable table;
	private DefaultTableModel model;
	private Object[][] data;
	private JTextField tfFind;
	private static String[] columnName = {"STT","Nhân viên","Thời gian","Lương cơ bản","Lương thực tế","Phụ cấp","Lương thưởng","Các khoản trừ","Thuế","Thực lãnh"};
	
	public SalaryForm1() {
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
		panelFeature.setBounds(0,0,1080,80);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);
		
		JLabel titelLabel = new JLabel("BẢNG LƯƠNG NHÂN VIÊN");
		titelLabel.setForeground(new Color(0,0,0,140));
		titelLabel.setFont(new Font("arial", 1, 13));
		titelLabel.setBounds(10,10,166,25);
		panelFeature.add(titelLabel);

		btnExportExcel = new Button();
		btnExportExcel.setText("EXCEL");
		btnExportExcel.setForeground(Color.white);
		btnExportExcel.setFont(new Font("sansserif",1,12));
		btnExportExcel.setIcon(new ImageIcon(getClass().getResource("/assets/img/excel_file.png")));
		btnExportExcel.setBounds(980,8,94,36);
		btnExportExcel.setBorderPainted(false);
		btnExportExcel.setFocusPainted(false);
		btnExportExcel.setBackground(Color.decode("#3498db"));
		panelFeature.add(btnExportExcel);

		

		
		
		
		
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
		
		
		cbbPhong.setFont(new Font("Arial",1,12));
		cbbPhong.setForeground(new Color(0,0,0,200));
		cbbPhong.setBounds(230,45,240,26);
		panelFeature.add(cbbPhong);
		((myCombobox<String>)cbbPhong).showArrow();
		
		
		cbbSort = new myCombobox<>();
		String[] cbbSortString = {"Sắp xếp theo: Thời gian","Sắp xếp theo: Lương thưởng","Sắp xếp theo: Phụ cấp","Sắp xếp theo: Thuế","Sắp xếp theo: Thực lãnh"};
		cbbSort.setModel(new DefaultComboBoxModel<>(cbbSortString));
		cbbSort.setFont(new Font("Arial",1,12));
		cbbSort.setForeground(new Color(0,0,0,200));
		cbbSort.setBounds(480,45,210,26);
		panelFeature.add(cbbSort);
		((myCombobox<String>)cbbSort).showArrow();
		cbbSort2 = new myCombobox<>();
		String[] cbbSortString2 = {"Tăng dần","Giảm dần"};
		cbbSort2.setModel(new DefaultComboBoxModel<>(cbbSortString2));
		cbbSort2.setFont(new Font("Arial",1,12));
		cbbSort2.setForeground(new Color(0,0,0,200));
		cbbSort2.setBounds(700,45,100,26);
		panelFeature.add(cbbSort2);
		((myCombobox<String>)cbbSort2).showArrow();
		tfFind = new JTextField();
		tfFind.setFont(new Font("Arial",0,14));
		tfFind.setForeground(new Color(0,0,0,100));
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
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setBackground(Color.white);
		jsp1.setVerticalScrollBar(new myScrollBar());
		jsp1.setBorder(new EmptyBorder(0,0,0,0));
		jsp1.setBounds(0,100,1080,550);
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
	public void setSalaryData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		formatSizeColumn();
	}
	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(200);  // anh
		table.getColumnModel().getColumn(2).setPreferredWidth(90);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(105);   // gioitinh
		table.getColumnModel().getColumn(4).setPreferredWidth(105);  // ngaysinh
		table.getColumnModel().getColumn(5).setPreferredWidth(105);  // diachi
		table.getColumnModel().getColumn(6).setPreferredWidth(105);  // lienhe
		table.getColumnModel().getColumn(7).setPreferredWidth(105);   // phongban
		table.getColumnModel().getColumn(8).setPreferredWidth(100);  // chucvu
		table.getColumnModel().getColumn(9).setPreferredWidth(100);  // luong
//		table.getColumnModel().getColumn(10).setPreferredWidth(85);  // luong
//		table.getColumnModel().getColumn(11).setPreferredWidth(100);  // luong
	}
	public myCombobox<String> getCbbNam() {
		return cbbNam;
	}
	public void setCbbNam(myCombobox<String> cbbNam) {
		this.cbbNam = cbbNam;
	}
	public myCombobox<String> getCbbThang() {
		return cbbThang;
	}
	public void setCbbThang(myCombobox<String> cbbThang) {
		this.cbbThang = cbbThang;
	}
	public myCombobox<String> getCbbPhong() {
		return cbbPhong;
	}
	public void setCbbPhong(myCombobox<String> cbbPhong) {
		this.cbbPhong = cbbPhong;
	}
	public void setTable(myTable table) {
		this.table = table;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public myCombobox<String> getCbbSort() {
		return cbbSort;
	}

	public void setCbbSort(myCombobox<String> cbbSort) {
		this.cbbSort = cbbSort;
	}

	public myCombobox<String> getCbbSort2() {
		return cbbSort2;
	}

	public void setCbbSort2(myCombobox<String> cbbSort2) {
		this.cbbSort2 = cbbSort2;
	}
	public void setDataForCbbPhong(String data[]) {
		cbbPhong.setModel(new DefaultComboBoxModel<>(data));
	}
	public Object[][] getData(){
		return this.data;
	}
	public JButton getBtnExportExcel() {
		return this.btnExportExcel;
	}
	public JTextField getTfFind() {
		return this.tfFind;
	}
}
