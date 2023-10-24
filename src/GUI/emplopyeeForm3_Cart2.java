package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.DANHSACHNHANVIEN;
import DAO.access_NHANVIEN;

import DTO.EXCEL;

public class emplopyeeForm3_Cart2 extends JPanel{
	private static String[] columnName = {"STT","Ảnh","Nhân viên","Giới tính","Ngày sinh","Địa chỉ","Liên hệ","Phòng ban","Chức vụ","Mức lương"};
	private DefaultTableModel model;
	private myTable table;
	private Object[][] data;
	private JButton btnXemChiTiet;
	private DANHSACHNHANVIEN danhSachNhanVienImport;
	private JButton btnXoaNhanVien;
	private JButton btnThemNhanVien;
	private boolean flag; // làm cờ cho btn trở về ở trang xem thông tin nhân viên
	public emplopyeeForm3_Cart2() {
		danhSachNhanVienImport = new DANHSACHNHANVIEN();
		model = new DefaultTableModel(null,columnName);
		init();
	}
	public void init() {
		this.setLayout(null);
		this.setBackground(Color.white);
		JLabel lb = new JLabel("THÊM HỒ SƠ NHÂN VIÊN");
		lb.setFont(new Font("Arial",1,13));
		lb.setForeground(new Color(0,0,0,140));
		lb.setBounds(20,10,200,30);
		this.add(lb);
		
		// xem chi tiết nhân viên
		btnXemChiTiet = new JButton("Xem");
		btnXemChiTiet.setBounds(750,10,100,30);
		btnXemChiTiet.setFont(new Font("Arial",1,12));
		btnXemChiTiet.setForeground(new Color(0,0,0,170));
		this.add(btnXemChiTiet);
		//xóa nhân viên
		btnXoaNhanVien = new JButton("Xóa");
		btnXoaNhanVien.setBounds(860,10,100,30);
		btnXoaNhanVien.setForeground(new Color(0,0,0,170));
		btnXoaNhanVien.setFont(new Font("Arial",1,12));
		this.add(btnXoaNhanVien);
		// thêm nhân viên
		btnThemNhanVien = new JButton("Thêm");
		btnThemNhanVien.setFont(new Font("Arial",1,12));
		btnThemNhanVien.setForeground(new Color(0,0,0,170));
		btnThemNhanVien.setBounds(970,10,100,30);
		this.add(btnThemNhanVien);
		
		
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setBackground(Color.white);
		jsp1.setVerticalScrollBar(new myScrollBar());
//		jsp1.setBorder(new EmptyBorder(0,0,0,0));
		jsp1.setBounds(10,50,1060,380);
		jsp1.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		this.add(jsp1);
		
		
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
                    lbname.setBounds(0,10,180,20);
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
		jsp1.setViewportView(table);
		model = new DefaultTableModel(null,columnName);
		table.setModel(model);
		
		JPanel panelAdd = new JPanel();
		panelAdd.setBounds(10,450,1060,145);
		panelAdd.setBackground(Color.white);
		panelAdd.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
		panelAdd.setLayout(null);
		JLabel labeldetail = new JLabel("Kéo thả file vào đây !");
		labeldetail.setBounds(460,90,300,30);
		labeldetail.setForeground(new Color(0,0,0,150));
		labeldetail.setFont(new Font("Arial",0,15));
		panelAdd.add(labeldetail);
		
		
		JLabel labeldetail2 = new JLabel();
		labeldetail2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/clound2.png")).getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		labeldetail2.setBounds(500,40,300,50);
		panelAdd.add(labeldetail2);
		panelAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(panelAdd);
		panelAdd.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				panelAdd.setBorder(new LineBorder(Color.decode("#ced6e0"),3));
			}
			public void mouseExited(MouseEvent e) {
				panelAdd.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
			}
		});
		panelAdd.setDropTarget(new DropTarget() {
		    public synchronized void drop(DropTargetDropEvent evt) {
		        try {
		            evt.acceptDrop(DnDConstants.ACTION_COPY);
		            @SuppressWarnings("unchecked")
					List<File> droppedFiles = (List<File>)evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
		            for (File file : droppedFiles) {
		                System.out.println(file.getAbsolutePath());
		                danhSachNhanVienImport = EXCEL.importEmployeeData(file.getAbsolutePath());
		                setData(danhSachNhanVienImport.getObjectToRender());
		                
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		formatSizeColumn();
	}
	public void setData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		formatSizeColumn();
	}
	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(54);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(60);  // anh
		table.getColumnModel().getColumn(2).setPreferredWidth(195);  // ten
		table.getColumnModel().getColumn(3).setPreferredWidth(70);   // gioitinh
		table.getColumnModel().getColumn(4).setPreferredWidth(80);  // ngaysinh
		table.getColumnModel().getColumn(5).setPreferredWidth(150);  // diachi
		table.getColumnModel().getColumn(6).setPreferredWidth(90);  // lienhe
		table.getColumnModel().getColumn(7).setPreferredWidth(150);   // phongban
		table.getColumnModel().getColumn(8).setPreferredWidth(110);  // chucvu
		table.getColumnModel().getColumn(9).setPreferredWidth(90);  // luong
	}
	public JButton getBtnXemChiTiet() {
		return this.btnXemChiTiet;
	}
	public myTable getTable() {
		return this.table;
	}
	public DANHSACHNHANVIEN getDanhSachNhanVienImport() {
		return danhSachNhanVienImport;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public void setFlag(boolean flag) {
		this.flag =flag;
	}
	public JButton getBtnXoaNhanVien() {
		return this.btnXoaNhanVien;
	}
	public JButton getBtnThemNhanVien() {
		return this.btnThemNhanVien;
	}
}
