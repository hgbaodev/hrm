package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.access_TAIKHOAN;
import view.button.Button;

public class AccountForm extends JPanel{
	private JScrollPane scrollPane;
	private myTable tableAccount;
	private myTable tableNhomQuyen;
	private DefaultTableModel modelAccount;
	private DefaultTableModel modelNhomQuyen;
	private JButton btnThem;
	private JButton btnXoa;
	private Object[][] dataAccount;
	private Object[][] dataNhomQuyen;
	private myCombobox<String> cbbPhongBan;
	private JTextField tftenNhomQuyen;
	private JTextField tfmaNhomQuyen;
	private JButton btnChinhSuaQuyen;
	private JButton btnLuuChinhSuaQuyen;
	private JButton btnThemNhomQuyen;
	private JLabel lbtenDangNhap;
	private static String[] columnName = {"STT","Nhân viên","Quyền"};
	private static String[] tt2 = {"STT","Nhóm quyền"};
	private String[] cbbPhongString= {};
	private JLabel titleUsernameAccount;
	private ArrayList<JCheckBox> listCheckBox;
	private JPanel panelChucNang;
	private JPanel panelThemNhomQuyen;
	private JLabel titleNhomQuyen;
	private JButton btnLuuNhomQuyen;
	private JLabel chiTietTaiKhoan;
	private JComboBox<String>  cbbQuyen;
	private String[] modelCbbQuyen;
	private JButton btnLuuQuyen;
	public AccountForm() {
		modelAccount = new DefaultTableModel(dataAccount,columnName) {
			 public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		init();
	}
	public void init() {
		this.setLayout(null);
		
		
		JPanel panelFeature = new JPanel();
		panelFeature.setBounds(10,10,1080,46);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);
		
		JLabel titelLabel = new JLabel("TÀI KHOẢN VÀ PHÂN QUYỀN");
		titelLabel.setForeground(new Color(0,0,0,140));
		titelLabel.setFont(new Font("arial", 0, 14));
		titelLabel.setBounds(10,10,250,25);
		panelFeature.add(titelLabel);

		
		
		
		
		
		
		
		
		JPanel panelTaiKhoan = new JPanel();
		panelTaiKhoan.setLayout(null);
		panelTaiKhoan.setBackground(Color.white);
		panelTaiKhoan.setBounds(10,66,430,634);
		this.add(panelTaiKhoan);
		JLabel titelLabelTaikhoan = new JLabel("Tài khoản người dùng");
		titelLabelTaikhoan.setForeground(new Color(0,0,0,140));
		titelLabelTaikhoan.setFont(new Font("arial", 0, 15));
		titelLabelTaikhoan.setBounds(10,10,166,25);
		panelTaiKhoan.add(titelLabelTaikhoan);
		
		cbbPhongBan = new myCombobox<String>();
		cbbPhongBan.setModel(new DefaultComboBoxModel<>(cbbPhongString));
		cbbPhongBan.setFont(new Font("Arial",1,12));
		cbbPhongBan.setForeground(new Color(0,0,0,200));
		cbbPhongBan.setBounds(190,10,220,26);
		panelTaiKhoan.add(cbbPhongBan);
		((myCombobox<String>)cbbPhongBan).showArrow();
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.white);
		scrollPane.setVerticalScrollBar(new myScrollBar());
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane.setBounds(10,50,400,420);
		panelTaiKhoan.add(scrollPane);
		
		tableAccount = new myTable();
		tableAccount.setRowHeight(40);
		tableAccount.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		scrollPane.setViewportView(tableAccount);
		tableAccount.setModel(modelAccount);
		JPanel panelChiTietTaiKhoan = new JPanel();
		panelChiTietTaiKhoan.setBounds(10,480,400,145);
		panelChiTietTaiKhoan.setBorder(new LineBorder(new Color(0,0,0,40),2));
		panelChiTietTaiKhoan.setLayout(null);
		panelChiTietTaiKhoan.setBackground(Color.white);
		panelTaiKhoan.add(panelChiTietTaiKhoan);
		JLabel titelLabelTaikhoan2 = new JLabel("Chi tiết tài khoản");
		titelLabelTaikhoan2.setForeground(new Color(0,0,0,140));
		titelLabelTaikhoan2.setFont(new Font("arial", 0, 15));
		titelLabelTaikhoan2.setBounds(10,10,166,25);
		panelChiTietTaiKhoan.add(titelLabelTaikhoan2);
		
		chiTietTaiKhoan = new JLabel("001 - Nguyễn Văn A");
		chiTietTaiKhoan.setForeground(new Color(0,0,0,140));
		chiTietTaiKhoan.setFont(new Font("arial", 0, 14));
		chiTietTaiKhoan.setBounds(10,50,240,25);
		panelChiTietTaiKhoan.add(chiTietTaiKhoan);
		
		JLabel titelLabelTaikhoan4 = new JLabel("Quyền tài khoản");
		titelLabelTaikhoan4.setForeground(new Color(0,0,0,140));
		titelLabelTaikhoan4.setFont(new Font("arial", 0, 14));
		titelLabelTaikhoan4.setBounds(10,90,166,25);
		panelChiTietTaiKhoan.add(titelLabelTaikhoan4);
		
		cbbQuyen = new myCombobox<String>();
		cbbQuyen.setForeground(new Color(0,0,0,140));
		cbbQuyen.setFont(new Font("arial", 1, 13));
		cbbQuyen.setBounds(150,90,140,25);
		cbbQuyen.setFocusable(false);
		cbbQuyen.setMaximumRowCount(2);
		panelChiTietTaiKhoan.add(cbbQuyen);
		
		btnLuuQuyen = new Button();
		btnLuuQuyen.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		btnLuuQuyen.setText("Lưu");
		btnLuuQuyen.setFont(new Font("Arial",1,12));
		btnLuuQuyen.setForeground(Color.white);
		btnLuuQuyen.setBackground(Color.decode("#44bd32"));
		btnLuuQuyen.setBounds(295,88,90,35);
		panelChiTietTaiKhoan.add(btnLuuQuyen);
		btnLuuQuyen.setFocusable(false);
		
		// panel nhóm quyền
		JPanel panelNhomQuyen = new JPanel();
		panelNhomQuyen.setBackground(Color.white);
		panelNhomQuyen.setLayout(null);
		panelNhomQuyen.setBounds(440,66,650,634);
		this.add(panelNhomQuyen);
		JLabel titelNhomQuyen = new JLabel("Nhóm quyền");
		titelNhomQuyen.setForeground(new Color(0,0,0,140));
		titelNhomQuyen.setFont(new Font("arial", 0, 15));
		titelNhomQuyen.setBounds(10,10,166,25);
		panelNhomQuyen.add(titelNhomQuyen);
		
		btnXoa = new Button();
		btnXoa.setText("Xóa");
		btnXoa.setFont(new Font("Arial",1,13));
		btnXoa.setForeground(Color.white);
		btnXoa.setIcon(new ImageIcon(getClass().getResource("/assets/img/addadd.png")));
		btnXoa.setBounds(470,8,90,34);
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(Color.decode("#3498db"));
		btnXoa.setFocusPainted(false);
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelNhomQuyen.add(btnXoa);
		btnThem = new Button();
		btnThem.setText("Thêm");
		btnThem.setFont(new Font("Arial",1,13));
		btnThem.setForeground(Color.white);
		btnThem.setIcon(new ImageIcon(getClass().getResource("/assets/img/addadd.png")));
		btnThem.setBounds(560,8,90,34);
		btnThem.setBorderPainted(false);
		btnThem.setBackground(Color.decode("#3498db"));
		btnThem.setFocusPainted(false);
		btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelNhomQuyen.add(btnThem);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showFrame(1);
				tfmaNhomQuyen.setText("");
				tftenNhomQuyen.setText("");
			}
		});
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBackground(Color.white);
		scrollPane2.setVerticalScrollBar(new myScrollBar());
		scrollPane2.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane2.setBounds(10,50,250,560);
		panelNhomQuyen.add(scrollPane2);
		
		tableNhomQuyen = new myTable();
		tableNhomQuyen.setRowHeight(40);
		tableNhomQuyen.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		
		
		
		scrollPane2.setViewportView(tableNhomQuyen);
		tableNhomQuyen.setModel(new DefaultTableModel(null,tt2));
		tableNhomQuyen.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tableNhomQuyen.getColumnModel().getColumn(0).setPreferredWidth(50);  // stt
		tableNhomQuyen.getColumnModel().getColumn(1).setPreferredWidth(195);  // anh
		
		
		// chi tiet
		JPanel panelRightNhomQuyen = new JPanel();
//		panelChucNang
		panelRightNhomQuyen.setBounds(270,50,370,570);
		panelRightNhomQuyen.setLayout(new CardLayout());
		panelNhomQuyen.add(panelRightNhomQuyen);
		panelChucNang = new JPanel();
		panelRightNhomQuyen.add(panelChucNang);
		panelChucNang.setLayout(null);
		// top
		JPanel panelTopChucNang = new JPanel();
		panelTopChucNang.setBounds(0,00,370,80);
		panelTopChucNang.setBackground(Color.white);
		panelTopChucNang.setLayout(null);
		panelChucNang.add(panelTopChucNang);
		
		
		
		titleNhomQuyen = new JLabel("",JLabel.CENTER);
		titleNhomQuyen.setForeground(new Color(0,0,0,180));
		titleNhomQuyen.setFont(new Font("arial", 1, 14));
		titleNhomQuyen.setBounds(10,25,350,25);
		panelTopChucNang.add(titleNhomQuyen);
		
		
		
		// bottom
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBackground(Color.white);
		scrollPane3.setVerticalScrollBar(new myScrollBar());
		scrollPane3.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane3.setBounds(0,80,370,490);
		panelChucNang.add(scrollPane3);
		JPanel panelTable = new JPanel();
		scrollPane3.setViewportView(panelTable);
		panelTable.setLayout(null);
		panelTable.setBackground(Color.white);
		
		
		JLabel ct1 = new JLabel("Quản lý hồ sơ nhân viên");
		ct1.setForeground(new Color(0,0,0,160));
		ct1.setFont(new Font("arial", 1, 14));
		ct1.setBounds(10,5,200,25);
		panelTable.add(ct1);
		listCheckBox = new ArrayList<>();
		String qlnv[] = {"Xem thông tin cá nhân","Xem danh sách nhân viên","Thêm nhân viên","Sửa, xóa nhân viên","Xuất file Excel"};
		for(int i=0;i<qlnv.length;i++) {
			JLabel ct2 = new JLabel(qlnv[i]);
			ct2.setForeground(new Color(0,0,0,140));
			ct2.setFont(new Font("arial", 1, 13));
			ct2.setBounds(10,35+i*30,166,25);
			panelTable.add(ct2);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,35+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		
		JLabel ct2 = new JLabel("Quản lý tuyển dụng");
		ct2.setForeground(new Color(0,0,0,160));
		ct2.setFont(new Font("arial", 1, 14));
		ct2.setBounds(10,185,200,25);
		panelTable.add(ct2);
		String qltd[] = {"Xem đợt tuyển dụng","Thêm đợt tuyển dụng","Sửa, xóa đợt tuyển dụng","Xem danh sách ứng viên","Thêm ứng viên","Sửa, xóa ứng viên","Tuyển ứng viên"};
		for(int i=0;i<qltd.length;i++) {
			JLabel temp = new JLabel(qltd[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,215+i*30,166,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,215+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		JLabel ct3 = new JLabel("Quản lý hợp đồng");
		ct3.setForeground(new Color(0,0,0,160));
		ct3.setFont(new Font("arial", 1, 14));
		ct3.setBounds(10,425,200,25);
		panelTable.add(ct3);
		String qlhd[] = {"Xem danh sách hợp đồng","Kí hợp đồng","Gia hạn, hủy hợp đồng","Thống kê hợp đồng","Xuất file Excel"};
		for(int i=0;i<qlhd.length;i++) {
			JLabel temp = new JLabel(qlhd[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,455+i*30,166,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,455+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		JLabel ct4 = new JLabel("Quản lý phòng ban");
		ct4.setForeground(new Color(0,0,0,160));
		ct4.setFont(new Font("arial", 1, 14));
		ct4.setBounds(10,605,200,25);
		panelTable.add(ct4);
		String qlpb[] = {"Xem thông tin phòng ban","Thêm phòng ban","Sửa, xóa phòng ban","Điều chỉnh nhân sự","Thống kê phòng ban","Xuất file Excel"};
		for(int i=0;i<qlpb.length;i++) {
			JLabel temp = new JLabel(qlpb[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,635+i*30,166,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,635+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		
		JLabel ct5 = new JLabel("Quản lý chấm công");
		ct5.setForeground(new Color(0,0,0,160));
		ct5.setFont(new Font("arial", 1, 14));
		ct5.setBounds(10,815,200,25);
		panelTable.add(ct5);
		String qlcc[] = {"Xem chấm công cá nhân","Xem danh sách chấm công","Chấm công nhân viên","Sửa, xóa bảng chấm công","Xuất file Excel"};
		for(int i=0;i<qlcc.length;i++) {
			JLabel temp = new JLabel(qlcc[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,845+i*30,166,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,845+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		JLabel ct6 = new JLabel("Quản lý lương");
		ct6.setForeground(new Color(0,0,0,160));
		ct6.setFont(new Font("arial", 1, 14));
		ct6.setBounds(10,995,200,25);
		panelTable.add(ct6);
		String qll[] = {"Xem lương cá nhân","Xem danh sách lương","Cập nhật lương thưởng","Cập nhật phụ cấp, khoản trừ","Điều chỉnh lương","Xuất file Excel"};
		for(int i=0;i<qll.length;i++) {
			JLabel temp = new JLabel(qll[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,1025+i*30,200,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,1025+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		
		JLabel ct7 = new JLabel("Quản lý đánh giá");
		ct7.setForeground(new Color(0,0,0,160));
		ct7.setFont(new Font("arial", 1, 14));
		ct7.setBounds(10,1205,200,25);
		panelTable.add(ct7);
		String qldg[] = {"Xem đánh giá cá nhân","Xem danh sách đánh giá","Đánh giá nhân viên"};
		for(int i=0;i<qldg.length;i++) {
			JLabel temp = new JLabel(qldg[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,1235+i*30,166,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,1235+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		JLabel ct8 = new JLabel("Quản lý tài khoản");
		ct8.setForeground(new Color(0,0,0,160));
		ct8.setFont(new Font("arial", 1, 14));
		ct8.setBounds(10,1325,200,25);
		panelTable.add(ct8);
		String qltk[] = {"Phân quyền người dùng"};
		for(int i=0;i<qltk.length;i++) {
			JLabel temp = new JLabel(qltk[i]);
			temp.setForeground(new Color(0,0,0,140));
			temp.setFont(new Font("arial", 1, 13));
			temp.setBounds(10,1355+i*30,166,25);
			panelTable.add(temp);
			
			JCheckBox cb = new JCheckBox();
			cb.setBounds(335,1355+i*30,30,30);
			cb.setBackground(Color.white);
			panelTable.add(cb);
			listCheckBox.add(cb);
		}
		btnLuuNhomQuyen = new Button();
		btnLuuNhomQuyen.setText("Lưu");
		btnLuuNhomQuyen.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		btnLuuNhomQuyen.setFont(new Font("Arial", 1, 13));
		btnLuuNhomQuyen.setForeground(Color.white);
		btnLuuNhomQuyen.setBackground(Color.decode("#44bd32"));
		btnLuuNhomQuyen.setBorderPainted(false);
		btnLuuNhomQuyen.setFocusPainted(false);
		btnLuuNhomQuyen.setBounds(255, 1450, 100, 36);
		btnLuuNhomQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelTable.add(btnLuuNhomQuyen);
		panelTable.setPreferredSize(new Dimension(365,1500));
		
		
		
		// thêm quyền
		panelThemNhomQuyen = new JPanel();
		panelThemNhomQuyen.setLayout(null);
		panelThemNhomQuyen.setBackground(Color.white);
		panelRightNhomQuyen.add(panelThemNhomQuyen);
		
		
		
		JLabel ty2 = new JLabel("Thêm nhóm quyền mới");
		ty2.setForeground(new Color(0,0,0,140));
		ty2.setFont(new Font("arial", 0, 14));
		ty2.setBounds(10,10,166,25);
		panelThemNhomQuyen.add(ty2);
		
		JLabel ll1 = new JLabel("Mã nhóm quyền");
		ll1.setForeground(new Color(0,0,0,140));
		ll1.setFont(new Font("arial", 0, 14));
		ll1.setBounds(80,80,166,25);
		panelThemNhomQuyen.add(ll1);
		
		tfmaNhomQuyen = new JTextField();
		tfmaNhomQuyen.setBounds(80,110,210,28);
		tfmaNhomQuyen.setFont(new Font("Arial", 0, 14));
		panelThemNhomQuyen.add(tfmaNhomQuyen);
		
		
		JLabel ll2 = new JLabel("Tên nhóm quyền");
		ll2.setForeground(new Color(0,0,0,140));
		ll2.setFont(new Font("arial", 0, 14));
		ll2.setBounds(80,150,166,25);
		panelThemNhomQuyen.add(ll2);
		
		tftenNhomQuyen = new JTextField();
		tftenNhomQuyen.setBounds(80,190,210,28);
		tftenNhomQuyen.setFont(new Font("Arial", 0, 14));
		panelThemNhomQuyen.add(tftenNhomQuyen);
		
		
		JButton btnHuyThemNhomQuyen = new Button();
		btnHuyThemNhomQuyen.setText("Hủy");
		btnHuyThemNhomQuyen.setFont(new Font("Arial", 1, 13));
		btnHuyThemNhomQuyen.setForeground(Color.white);
		btnHuyThemNhomQuyen.setBackground(Color.decode("#b2bec3"));
		btnHuyThemNhomQuyen.setBorderPainted(false);
		btnHuyThemNhomQuyen.setFocusPainted(false);
		btnHuyThemNhomQuyen.setBounds(110, 250, 90, 36);
		btnHuyThemNhomQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelThemNhomQuyen.add(btnHuyThemNhomQuyen);
		btnHuyThemNhomQuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showFrame(0);
			}
		});
		
		btnThemNhomQuyen = new Button();
		btnThemNhomQuyen.setText("Thêm");
		btnThemNhomQuyen.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
		btnThemNhomQuyen.setFont(new Font("Arial", 1, 13));
		btnThemNhomQuyen.setForeground(Color.white);
		btnThemNhomQuyen.setBackground(Color.decode("#44bd32"));
		btnThemNhomQuyen.setBorderPainted(false);
		btnThemNhomQuyen.setFocusPainted(false);
		btnThemNhomQuyen.setBounds(205, 250, 90, 36);
		btnThemNhomQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelThemNhomQuyen.add(btnThemNhomQuyen);
		
		
		showFrame(0);
	}
	public void showFrame(int index) {
		if(index==0) {
			panelChucNang.setVisible(true);
			panelThemNhomQuyen.setVisible(false);
		}else {
			panelChucNang.setVisible(false);
			panelThemNhomQuyen.setVisible(true);
		}
	}
	public JButton getBtnChinhSuaQuyen() {
		return this.btnChinhSuaQuyen;
	}
	public JButton getBtnLuuChinhSuaQuyen() {
		return this.btnLuuChinhSuaQuyen;
	}
	public void setAccountData(Object[][] data) {
		this.dataAccount = data;
		modelAccount.setDataVector(this.dataAccount, columnName);
		formatSizeColumn();
	}
	public void formatSizeColumn() {
		tableAccount.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAccount.getColumnModel().getColumn(0).setPreferredWidth(60);  // stt
		tableAccount.getColumnModel().getColumn(1).setPreferredWidth(225);  // anh
		tableAccount.getColumnModel().getColumn(2).setPreferredWidth(110);  // ten
		
	}
	
	public JButton getBtnThem() {
		return this.btnThem;
	}
	public myTable getTableAccount() {
		return this.tableAccount;
	}
	public DefaultTableModel getModelAccount() {
		return this.modelAccount;
	}
	public myCombobox<String> getCbbPhongBan() {
		return cbbPhongBan;
	}
	public void setCbbPhongBan(myCombobox<String> cbbPhongBan) {
		this.cbbPhongBan = cbbPhongBan;
	}
	public Object[][] getAccountData() {
		return this.dataAccount;
	}
	public void setCbbPhongBanString(String[] cbbPhongBanString) {
		this.cbbPhongString = cbbPhongBanString;
		cbbPhongBan.setModel(new DefaultComboBoxModel<>(cbbPhongBanString));
	}
	public void setTitleStatusAccount(String username) {
		titleUsernameAccount.setText(username);
	}
	public String getTitleStatusAccount() {
		return this.titleUsernameAccount.getText();
	}
	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}
	public JLabel getLbTenDangNhap() {
		return lbtenDangNhap;
	}
	public void setDataNhomQuyen(Object [][] data) {
		this.dataNhomQuyen = data;
		modelNhomQuyen = new DefaultTableModel(data,tt2);
		tableNhomQuyen.setModel(modelNhomQuyen);
		tableNhomQuyen.getColumnModel().getColumn(0).setPreferredWidth(50);  // stt
		tableNhomQuyen.getColumnModel().getColumn(1).setPreferredWidth(195);  // anh
	}
	public void showThongTinNhomQuyen(boolean[] mangChucNang) {
		for(int i=0;i<mangChucNang.length;i++) {
			if(mangChucNang[i]) {
				listCheckBox.get(i).setSelected(true);
			}else {
				listCheckBox.get(i).setSelected(false);
			}
		}
	}
	public boolean [] getMangChucNang() {
		boolean mang[] = new boolean[listCheckBox.size()];
		for(int i=0;i<listCheckBox.size();i++) {
			if(listCheckBox.get(i).isSelected()) {
				mang[i] = true;
			}else {
				mang[i] = false;
			}
		}
		return mang;
	}
	public JTable getTableNhomQuyen() {
		return this.tableNhomQuyen;
	}
	public JButton getBtnThemNhomQuyen() {
		return this.btnThemNhomQuyen;
	}
	public JTextField getTfMaNhomQuyen() {
		return this.tfmaNhomQuyen;
	}
	public JTextField getTfTenNhomQuyen() {
		return this.tftenNhomQuyen;
	}
	public JButton getBtnXoa() {
		return this.btnXoa;
	}
	public DefaultTableModel getModelNhomQuyen() {
		return this.modelNhomQuyen;
	}
	public JLabel getTitleNhomQuyen() {
		return this.titleNhomQuyen;
	}
	public JButton getBtnLuuNhomQuyen() {
		return this.btnLuuNhomQuyen;
	}
	public JLabel getLabelChiTietTaiKhoan() {
		return this.chiTietTaiKhoan;
	}
	public JComboBox<String>  getCbbQuyen(){
		return this.cbbQuyen;
	}
	public void setModelCbbQuyen(String[] model) {
		modelCbbQuyen = model;
		cbbQuyen.setModel(new DefaultComboBoxModel<>(model));
	}
	public String[] getModelCbbQuyen() {
		return this.modelCbbQuyen;
	}
	public JButton getBtnChinhSuaQuyenTaiKhoan() {
		return this.btnLuuQuyen;
	}
}
