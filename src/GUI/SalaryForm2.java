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
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.access_LUONG;
import DAO.access_PHONGBAN;


public class SalaryForm2 extends JPanel{
	private myCombobox<String> cbbNam;
	private myCombobox<String> cbbThang;
	private myCombobox<String> cbbPhong;
	private myCombobox<String> cbbSort;
	private myCombobox<String> cbbSort2;
	private myCombobox<String> cbbNamThuong;
	private myCombobox<String> cbbThangThuong;
	private myCombobox<String> cbbDonVi;
	private myCombobox<String> cbbDonViChiTiet;
	
	private JTextField tfMucThuong;
	private JTextField tfMaNhanVienThuong;
	
	private myTable table;
	private DefaultTableModel model;
	private Object[][] data;
	private JButton btnLuuThuong;
	private static String[] columnName = {"STT","Nhân viên","Thời gian","Lương cơ bản","% lương thưởng","Lương thưởng"};
	
	public SalaryForm2() {
		
		data = access_LUONG.getDanhSachLuongThuongToRender();
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
		
		JLabel titelLabel = new JLabel("TIỀN THƯỞNG THEO THÁNG");
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
		
		
		cbbPhong.setFont(new Font("Arial",1,12));
		cbbPhong.setForeground(new Color(0,0,0,200));
		cbbPhong.setBounds(230,45,220,26);
		panelFeature.add(cbbPhong);
		((myCombobox<String>)cbbPhong).showArrow();
		
		
		cbbSort = new myCombobox<>();
		String[] cbbSortString = {"Sắp xếp theo: Thời gian","Sắp xếp theo: Lương thưởng"};
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
		panelThuong.setBounds(790,0,290,665);
		panelThuong.setLayout(null);
		this.add(panelThuong);
		JLabel titelLabel2 = new JLabel("TẠO MỨC TIỀN THƯỞNG");
		titelLabel2.setForeground(new Color(0,0,0,140));
		titelLabel2.setFont(new Font("arial", 1, 13));
		titelLabel2.setBounds(10,10,250,25);
		panelThuong.add(titelLabel2);
		JLabel lbthoigian = new JLabel("Thời gian");
		lbthoigian.setFont(new Font("Arial",0,14));
		lbthoigian.setForeground(new Color(0,0,0,160));
		lbthoigian.setBounds(10,50,200,30);
		panelThuong.add(lbthoigian);
		cbbNamThuong = new myCombobox<>();
		cbbNamThuong.setModel(new DefaultComboBoxModel<>(cbbNamString));
		cbbNamThuong.setForeground(new Color(0,0,0,160));
		cbbNamThuong.setBounds(10,80,130,30);
		cbbNamThuong.setFont(new Font("Arial",1,12));
		cbbNamThuong.showArrow();
		panelThuong.add(cbbNamThuong);
		
		cbbThangThuong = new myCombobox<>();
		cbbThangThuong.setModel(new DefaultComboBoxModel<>(cbbThangString));
		cbbThangThuong.setForeground(new Color(0,0,0,160));
		cbbThangThuong.setBounds(150,80,130,30);
		cbbThangThuong.setFont(new Font("Arial",1,12));
		cbbThangThuong.showArrow();
		panelThuong.add(cbbThangThuong);
		
		JLabel lbdonvi = new JLabel("Đơn vị thụ hưởng");
		lbdonvi.setFont(new Font("Arial",0,14));
		lbdonvi.setForeground(new Color(0,0,0,160));
		lbdonvi.setBounds(10,120,200,30);
		panelThuong.add(lbdonvi);
		cbbDonVi = new myCombobox<>();
		cbbDonVi.setModel(new DefaultComboBoxModel<>(new String[] {"Tất cả nhân viên","Theo phòng ban","Theo nhân viên"}));
		cbbDonVi.setForeground(new Color(0,0,0,160));
		cbbDonVi.setBounds(10,150,270,30);
		cbbDonVi.setFont(new Font("Arial",1,12));
		cbbDonVi.showArrow();
		panelThuong.add(cbbDonVi);
		
		JLabel lbdonvi2 = new JLabel("Đơn vị chi tiết");
		lbdonvi2.setFont(new Font("Arial",0,14));
		lbdonvi2.setForeground(new Color(0,0,0,160));
		lbdonvi2.setBounds(10,190,200,30);
		panelThuong.add(lbdonvi2);
		cbbDonViChiTiet = new myCombobox<>();
		cbbDonViChiTiet.setModel(new DefaultComboBoxModel<>());
		cbbDonViChiTiet.setForeground(new Color(0,0,0,160));
		cbbDonViChiTiet.setBounds(10,220,270,30);
		cbbDonViChiTiet.setFont(new Font("Arial",1,12));
		cbbDonViChiTiet.showArrow();
		panelThuong.add(cbbDonViChiTiet);
		cbbDonViChiTiet.setVisible(false);
		
		tfMaNhanVienThuong = new JTextField("Không");
		tfMaNhanVienThuong.setForeground(new Color(0,0,0,160));
		tfMaNhanVienThuong.setBounds(10,220,270,30);
		tfMaNhanVienThuong.setFont(new Font("Arial",1,12));
		panelThuong.add(tfMaNhanVienThuong);
		tfMaNhanVienThuong.setEnabled(false);
		JLabel lbmucthuong = new JLabel("Mức thưởng (%)");
		lbmucthuong.setFont(new Font("Arial",0,14));
		lbmucthuong.setForeground(new Color(0,0,0,160));
		lbmucthuong.setBounds(10,260,200,30);
		panelThuong.add(lbmucthuong);
		tfMucThuong = new JTextField("");
		tfMucThuong.setForeground(new Color(0,0,0,160));
		tfMucThuong.setBounds(10,290,270,30);
		tfMucThuong.setFont(new Font("Arial",1,12));
		panelThuong.add(tfMucThuong);
		JLabel lbmucthuong2 = new JLabel("Mức thưởng dựa trên % lương cơ bản của từng");
		lbmucthuong2.setFont(new Font("Arial",0,13));
		lbmucthuong2.setForeground(new Color(0,0,0,160));
		lbmucthuong2.setBounds(10,320,300,30);
		panelThuong.add(lbmucthuong2);
		JLabel lbmucthuong3 = new JLabel("nhân viên");
		lbmucthuong3.setFont(new Font("Arial",0,13));
		lbmucthuong3.setForeground(new Color(0,0,0,160));
		lbmucthuong3.setBounds(10,340,300,30);
		panelThuong.add(lbmucthuong3);
		
		
		
		btnLuuThuong = new JButton("Xác nhận");
		btnLuuThuong.setBounds(180,380,100,28);
		btnLuuThuong.setFont(new Font("Arial",1,12));
		btnLuuThuong.setForeground(new Color(0,0,0,160));
		panelThuong.add(btnLuuThuong);
		
		
		
		cbbDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbbDonVi.getSelectedIndex()==0) {
					lbdonvi2.setText("Đơn vị chi tiết");
					cbbDonViChiTiet.setVisible(false);
					tfMaNhanVienThuong.setVisible(true);
					tfMaNhanVienThuong.setText("Không");
					tfMaNhanVienThuong.setEnabled(false);
				}else if(cbbDonVi.getSelectedIndex()==1) {
					lbdonvi2.setText("Mã phòng ban");
					cbbDonViChiTiet.setVisible(true);
					tfMaNhanVienThuong.setVisible(false);
					cbbDonViChiTiet.setEnabled(true);
				}else {
					lbdonvi2.setText("Mã nhân viên");
					cbbDonViChiTiet.setVisible(false);
					tfMaNhanVienThuong.setVisible(true);
					tfMaNhanVienThuong.setEnabled(true);
					tfMaNhanVienThuong.setText("");
				}
			}
		});
		
		
		
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

	public void setDataCbbPhongBanLuongThuong(String data[]) {
		cbbDonViChiTiet.setModel(new DefaultComboBoxModel<>(data));
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
		table.getColumnModel().getColumn(2).setPreferredWidth(90);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(140);   // gioitinh
		table.getColumnModel().getColumn(4).setPreferredWidth(120);  // ngaysinh
		table.getColumnModel().getColumn(5).setPreferredWidth(140);  // diachi
		
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
	public JButton getBtnLuuThuong() {
		return this.btnLuuThuong;
	}
	public String[] getDataThemLuongThuong() {
		String data[] = new String[] {
				cbbNamThuong.getSelectedItem().toString().trim(),
				cbbThangThuong.getSelectedItem().toString().trim(),
				cbbDonVi.getSelectedIndex()+"",
				cbbDonViChiTiet.getSelectedItem().toString().trim(),
				tfMaNhanVienThuong.getText().trim(),
				tfMucThuong.getText().trim()
		};
		return data;
	}
	public myTable getObjectTable() {
		return this.table;
	}
	public myCombobox<String> getCbbDonVi() {
		return cbbDonVi;
	}

	public void setCbbDonVi(myCombobox<String> cbbDonVi) {
		this.cbbDonVi = cbbDonVi;
	}

	public myCombobox<String> getCbbDonViChiTiet() {
		return cbbDonViChiTiet;
	}

	public void setCbbDonViChiTiet(myCombobox<String> cbbDonViChiTiet) {
		this.cbbDonViChiTiet = cbbDonViChiTiet;
	}
	public JTextField getTfMaNhanVienThuong() {
		return tfMaNhanVienThuong;
	}

	public void setTfMaNhanVienThuong(JTextField tfMaNhanVienThuong) {
		this.tfMaNhanVienThuong = tfMaNhanVienThuong;
	}
}
