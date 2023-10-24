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

import DAO.access_BANGDANHGIA;
import DAO.access_DIACHI;
import DAO.access_LUONG;
import DAO.access_PHONGBAN;


public class SalaryForm4 extends JPanel{
	private myCombobox<String> cbbXepLoai;
	private myCombobox<String> cbbPhong;
	private myCombobox<String> cbbSort;
	private myCombobox<String> cbbSort2;
	private myCombobox<String> cbbTangLuongGioi;
	private myCombobox<String> cbbTangLuongXuatSac;
	private myTable table;
	private DefaultTableModel model;
	private Object[][] data;
	private JButton btnDieuChinhLuong;
	private JButton btnTangLuongHangNam;
	private JTextField tfMaNhanVien;
	private JTextField tfMucTang;
	private static String[] columnName = {"STT","Nhân viên","Phòng ban","Mức lương","Đánh giá","Xếp loại"};
	
	public SalaryForm4() {
		
		
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
		panelFeature.setBounds(0,0,780,40);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);
		
		JLabel titelLabel = new JLabel("KẾT QUẢ ĐÁNH GIÁ NHÂN SỰ");
		titelLabel.setForeground(new Color(0,0,0,140));
		titelLabel.setFont(new Font("arial", 1, 13));
		titelLabel.setBounds(10,10,250,25);
		panelFeature.add(titelLabel);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panelThuong = new JPanel();
		panelThuong.setBackground(Color.white);
		panelThuong.setBounds(790,0,290,320);
		panelThuong.setLayout(null);
		this.add(panelThuong);
		JLabel titelLabel2 = new JLabel("ĐIỀU CHỈNH MỨC LƯƠNG");
		titelLabel2.setForeground(new Color(0,0,0,140));
		titelLabel2.setFont(new Font("arial", 1, 13));
		titelLabel2.setBounds(10,10,250,25);
		panelThuong.add(titelLabel2);
		JLabel lbthoigian = new JLabel("Mức tăng áp dụng cho nhân viên được");
		lbthoigian.setFont(new Font("Arial",0,14));
		lbthoigian.setForeground(new Color(0,0,0,160));
		lbthoigian.setBounds(10,40,300,30);
		panelThuong.add(lbthoigian);
		JLabel lbthoigian2 = new JLabel("đánh giá Giỏi");
		lbthoigian2.setFont(new Font("Arial",0,14));
		lbthoigian2.setForeground(new Color(0,0,0,160));
		lbthoigian2.setBounds(10,60,300,30);
		panelThuong.add(lbthoigian2);
		cbbTangLuongGioi = new myCombobox<>();
		cbbTangLuongGioi.setModel(new DefaultComboBoxModel<>(new String[] {"5%","6%","7%"}));
		cbbTangLuongGioi.setForeground(new Color(0,0,0,160));
		cbbTangLuongGioi.setBounds(10,90,270,30);
		cbbTangLuongGioi.setFont(new Font("Arial",1,12));
		panelThuong.add(cbbTangLuongGioi);
		
		
		JLabel lbdonvi = new JLabel("Mức lương áp dụng cho nhân viên được");
		lbdonvi.setFont(new Font("Arial",0,14));
		lbdonvi.setForeground(new Color(0,0,0,160));
		lbdonvi.setBounds(10,130,300,30);
		panelThuong.add(lbdonvi);
		JLabel lbdonvi22 = new JLabel("đánh giá Xuất sắc");
		lbdonvi22.setFont(new Font("Arial",0,14));
		lbdonvi22.setForeground(new Color(0,0,0,160));
		lbdonvi22.setBounds(10,150,300,30);
		panelThuong.add(lbdonvi22);
		cbbTangLuongXuatSac = new myCombobox<>();
		cbbTangLuongXuatSac.setModel(new DefaultComboBoxModel<>(new String[] {"7%","8%","9%"}));
		cbbTangLuongXuatSac.setForeground(new Color(0,0,0,160));
		cbbTangLuongXuatSac.setBounds(10,180,270,30);
		cbbTangLuongXuatSac.setFont(new Font("Arial",1,12));
		panelThuong.add(cbbTangLuongXuatSac);
		
		
		JLabel lbmucthuong2 = new JLabel("Mức lương được tăng dựa trên % lương cơ bản ");
		lbmucthuong2.setFont(new Font("Arial",0,13));
		lbmucthuong2.setForeground(new Color(0,0,0,160));
		lbmucthuong2.setBounds(10,220,300,30);
		panelThuong.add(lbmucthuong2);
		JLabel lbmucthuong3 = new JLabel("của từng nhân viên");
		lbmucthuong3.setFont(new Font("Arial",0,13));
		lbmucthuong3.setForeground(new Color(0,0,0,160));
		lbmucthuong3.setBounds(10,240,300,30);
		panelThuong.add(lbmucthuong3);
		
		btnTangLuongHangNam = new JButton("Xác nhận");
		btnTangLuongHangNam.setBounds(190,280,90,28);
		btnTangLuongHangNam.setFont(new Font("Arial",1,12));
		btnTangLuongHangNam.setForeground(new Color(0,0,0,160));
		panelThuong.add(btnTangLuongHangNam);
		
		

		JPanel panelTangLuong = new JPanel();
		panelTangLuong.setBackground(Color.white);
		panelTangLuong.setBounds(790,330,290,320);
		panelTangLuong.setLayout(null);
		this.add(panelTangLuong);
		JLabel titelTangLuong = new JLabel("ĐIỀU CHỈNH LƯƠNG CÁ NHÂN");
		titelTangLuong.setForeground(new Color(0,0,0,140));
		titelTangLuong.setFont(new Font("arial", 1, 13));
		titelTangLuong.setBounds(10,10,250,25);
		panelTangLuong.add(titelTangLuong);
		
		JLabel lbtangluong = new JLabel("Mã nhân viên");
		lbtangluong.setFont(new Font("Arial",0,14));
		lbtangluong.setForeground(new Color(0,0,0,160));
		lbtangluong.setBounds(10,40,300,30);
		panelTangLuong.add(lbtangluong);
		tfMaNhanVien = new JTextField();
		tfMaNhanVien.setForeground(new Color(0,0,0,160));
		tfMaNhanVien.setBounds(10,70,270,30);
		tfMaNhanVien.setFont(new Font("Arial",1,12));
		panelTangLuong.add(tfMaNhanVien);
		
		
		JLabel lbtangluong2 = new JLabel("Mức lương điều chỉnh");
		lbtangluong2.setFont(new Font("Arial",0,14));
		lbtangluong2.setForeground(new Color(0,0,0,160));
		lbtangluong2.setBounds(10,110,300,30);
		panelTangLuong.add(lbtangluong2);
		tfMucTang = new JTextField();
		tfMucTang.setForeground(new Color(0,0,0,160));
		tfMucTang.setBounds(10,140,270,30);
		tfMucTang.setFont(new Font("Arial",1,12));
		panelTangLuong.add(tfMucTang);
		JLabel lbmucthangchitiet = new JLabel("Mức lương điều chỉnh chính là mức lương cơ bản ");
		lbmucthangchitiet.setFont(new Font("Arial",0,13));
		lbmucthangchitiet.setForeground(new Color(0,0,0,160));
		lbmucthangchitiet.setBounds(10,180,300,30);
		panelTangLuong.add(lbmucthangchitiet);
		JLabel lbmucthangchitiet2 = new JLabel("của từng nhân viên");
		lbmucthangchitiet2.setFont(new Font("Arial",0,13));
		lbmucthangchitiet2.setForeground(new Color(0,0,0,160));
		lbmucthangchitiet2.setBounds(10,200,300,30);
		panelTangLuong.add(lbmucthangchitiet2);
		
		btnDieuChinhLuong = new JButton("Xác nhận");
		btnDieuChinhLuong.setBounds(190,230,90,28);
		btnDieuChinhLuong.setFont(new Font("Arial",1,12));
		btnDieuChinhLuong.setForeground(new Color(0,0,0,160));
		panelTangLuong.add(btnDieuChinhLuong);
		
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setBackground(Color.white);
		jsp1.setVerticalScrollBar(new myScrollBar());
		jsp1.setBorder(new EmptyBorder(0,0,0,0));
		jsp1.setBounds(0,40,780,625);
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


	public myTable getTable() {
		return table;
	}

	public void setTable(myTable table) {
		this.table = table;
	}

	public void setTfMaNhanVien(JTextField tfMaNhanVien) {
		this.tfMaNhanVien = tfMaNhanVien;
	}

	public void setDanhGiaData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		table.setModel(model);
		formatSizeColumn();
	}
	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(210);  // anh
		table.getColumnModel().getColumn(2).setPreferredWidth(190);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(120);   // gioitinh
		table.getColumnModel().getColumn(4).setPreferredWidth(100);  // ngaysinh
		table.getColumnModel().getColumn(5).setPreferredWidth(100);  // diachi
		
	}

	public myCombobox<String> getCbbXepLoai() {
		return cbbXepLoai;
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
	public JButton getBtnDieuChinhLuong() {
		return this.btnDieuChinhLuong;
	}
	public JComboBox<String> getCbbTangLuongGioi(){
		return this.cbbTangLuongGioi;
	}
	public JComboBox<String> getCbbTangLuongXuatSac(){
		return this.cbbTangLuongXuatSac;
	}
	public JButton getBtnTangLuongHangNam() {
		return this.btnTangLuongHangNam;
	}
	public JTextField getTfMaNhanVien() {
		return this.tfMaNhanVien;
	}
	public JTextField getTfMucTang() {
		return this.tfMucTang;
	}
	public Object[][] getData(){
		return this.data;
	}
}
