package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Table;

import DAO.access_BANGCHAMCONG;
import DTO.BANGCHAMCONG;
import view.button.Button;

/**
 *
 * @author Jhin
 */
@SuppressWarnings("FieldMayBeFinal")
public class BangChamCongForm2_1 extends JPanel {

    private JLabel lb;
    private JTextField tMaNV, tLam, tNghi, tTre, tLamThem, tNgayChamCong, tGetNgayThangNam;
    private JButton btnThem, btnReset;

    private Font font, fontB;
    

    private Object[][] data;
    private String[] title= {"STT","Nhân viên","Trạng thái"};
	private myTable table;
	private JLabel label_MNV;
	private JLabel label_Thang;
	private JLabel label_SoNgayLam;
	private JLabel label_SoNgayNghi;
	private JLabel label_SoNgayTre;
	private JLabel label_LamThem;
	private JButton btnBack;
	private Color color= Color.decode("#FF6A6A");
	private Color colorsunday = new Color(0,0,0,100);
	private JLabel ma_Ten;
	private JComboBox<String> thang;
	private JComboBox<String> nam;
	private ArrayList<JLabel> arr_1;
	private ArrayList<JLabel> label_dayOfWeek_list;
	
	public Color color_Nghi = Color.decode("#FF6A6A");
	public Color color_TangCa = Color.decode("#4cd137");
	public Color color_Tre = Color.orange;
	
    /**
     * 
     */
    // Nghỉ 
    private void init() {
    	
    	this.setLayout(null);
//        this.setBackground(Color.white);
        
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
		
		
		JPanel panelFrame = new JPanel();
		panelFrame.setBackground(Color.white);
		panelFrame.setBounds(10,60,1080,640);
		this.add(panelFrame);
		panelFrame.setLayout(null);
		
    	arr_1= new ArrayList<>();
    	label_dayOfWeek_list = new ArrayList<>();
    	table= new myTable();
    	table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Color selectedColor = Color.decode("#2980b9");
                	
                	Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                	com.setFont(new Font("Arial",Font.PLAIN,13));
                    setBorder(noFocusBorder);
                    if(i1==2) {
                		String str = (String)o;
                		if(str.equalsIgnoreCase("Đã chấm công")) {
                			 com.setForeground(Color.decode("#4cd137"));
                		}else {
                			 com.setForeground(Color.decode("#e84118"));
                		}
                		if (selected) {
	                    	com.setBackground(new Color(0,0,0,20));
	                    } else {
	                    	com.setBackground(Color.WHITE);
	                    }
                		return com;
                    }
                    if(i1==1 || i1==0) {
                    	com.setForeground(new Color(0,0,0,150));
                    	com.setFont(new Font("Arial",1,13));
                		if (selected) {
	                    	com.setBackground(new Color(0,0,0,20));
	                    } else {
	                    	com.setBackground(Color.WHITE);
	                    }
                		return com;
                    }
                    if (selected) {
                    	com.setBackground(new Color(0,0,0,20));
                        com.setForeground(selectedColor);
                    } else {
                    	com.setBackground(Color.WHITE);
                        com.setForeground(new Color(102, 102, 102));
                    }
                   return com;
                }
		});
    	table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				for(JLabel i: arr_1) {
					if(i.getBackground() != colorsunday) {
						i.setBackground(Color.white);
					}
					
					i.setText("");
				}
				
				int row= table.rowAtPoint(e.getPoint());
				ma_Ten.setText(table.getValueAt(row, 1)+"");
			}
		});
    	gender();
    	String[] thang_title= {"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5","Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};
    	thang= new myCombobox<String>();
    	thang.setFont(new Font("Arial",1,14));
    	thang.setModel(new DefaultComboBoxModel<>(thang_title));
    	thang.setBounds(410,20,100,30);
    	((myCombobox<String>)thang).showArrow();
    	thang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CapNhatTrangThai();
	            int row_num= table.getRowCount();
	            for(int i=0;i< row_num;i++) {
	            	if(table.getValueAt(i, 2).equals("Chưa chấm công")) {
	            		table.setRowSelectionInterval(i, i);
	            		getMa_Ten().setText(table.getValueAt(i, 1).toString());
	            		break;
	            	}
	            }
				//Tháng 2
				int temp_thang= thang.getSelectedIndex()+1;
				int temp_year = Integer.valueOf(nam.getSelectedItem().toString());
				
				
				LocalDate tempdate = LocalDate.of(temp_year, temp_thang, 1);
				
				System.out.println(tempdate.getDayOfWeek());
				System.out.println(temp_thang+"/"+temp_year);
				for(JLabel i: arr_1) {
					i.setBackground(Color.white);
					i.setText("");
				}
				updateDayOfWeek(temp_thang, temp_year);
				switch (temp_thang) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						arr_1.get(28).setVisible(true);
						arr_1.get(29).setVisible(true);
						arr_1.get(30).setVisible(true);
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						arr_1.get(28).setVisible(true);
						arr_1.get(29).setVisible(true);
						arr_1.get(30).setVisible(false);
						break;
					case 2:
						if ((temp_year%4==0 && temp_year%1001!=0) || temp_year%400==0) {
							arr_1.get(28).setVisible(true);
							
						}else {
							arr_1.get(28).setVisible(false);
						}
						
						arr_1.get(29).setVisible(false);
						arr_1.get(30).setVisible(false);
						break;
					default:
						break;
				}

			}
		});
    	
    	panelFrame.add(thang);
    	
    	
    	LocalDate current = LocalDate.now();
    	String[] nam_title= new String[5];
    	for(int i=0;i<nam_title.length;i++) {
    		nam_title[i] = current.getYear()-2+i+"";
    	}
    	nam= new myCombobox<String>();
    	nam.setFont(new Font("Arial",1,14));
    	nam.setModel(new DefaultComboBoxModel<>(nam_title));
    	nam.setBounds(515,20,100,30);
    	((myCombobox<String>)nam).showArrow();
    	// sự kiện cbb năm
    	nam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CapNhatTrangThai();
	            int row_num= table.getRowCount();
	            for(int i=0;i< row_num;i++) {
	            	if(table.getValueAt(i, 2).equals("Chưa chấm công")) {
	            		table.setRowSelectionInterval(i, i);
	            		getMa_Ten().setText(table.getValueAt(i, 1).toString());
	            		break;
	            	}
	            }
				//Tháng 2
				int temp_thang= thang.getSelectedIndex()+1;
				int temp_year = Integer.valueOf(nam.getSelectedItem().toString());
				
				System.out.println(temp_thang+"/"+temp_year);
				for(JLabel i: arr_1) {
					
					i.setBackground(Color.white);
					i.setText("");
				}
				updateDayOfWeek(temp_thang, temp_year);
				switch (temp_thang) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						arr_1.get(28).setVisible(true);
						arr_1.get(29).setVisible(true);
						arr_1.get(30).setVisible(true);
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						arr_1.get(28).setVisible(true);
						arr_1.get(29).setVisible(true);
						arr_1.get(30).setVisible(false);
						break;
					case 2:
						if ((temp_year%4==0 && temp_year%1001!=0) || temp_year%400==0) {
							arr_1.get(28).setVisible(true);
							
						}else {
							arr_1.get(28).setVisible(false);
						}
						
						arr_1.get(29).setVisible(false);
						arr_1.get(30).setVisible(false);
						break;
					default:
						break;
				}

			}
		});
    	
    	panelFrame.add(nam);
    	
    	
    	
       	JPanel panel= new JPanel();
    	panel.setBounds(470,80,600,550);
    	panel.setLayout(null);
    	panel.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
    	panelFrame.add(panel);
    	
    	ma_Ten= new JLabel("");
    	ma_Ten.setFont(new Font("Arial",2,15));
    	ma_Ten.setBounds(10, 10 , 300, 30);
    	panel.add(ma_Ten);
    	
    	JPanel panel_1= new JPanel();
    	panel_1.setBounds(0,40,600,280);
    	panel_1.setLayout(null);
    	panel_1.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
    	panel.add(panel_1);
    	GridLayout layout= new GridLayout(4, 8);  
    	layout.setHgap(2);
    	layout.setVgap(2);
    	panel_1.setLayout(layout);
    	for(int i=1; i<32; i++) {
    		JLabel a= new JLabel();
    		
    		a.setOpaque(true);
    		a.setFont(new Font("Arial",1,11));
    		a.setBackground(Color.white);
    		a.setHorizontalAlignment(JLabel.CENTER);
    		a.setLayout(null);
    		
    		
    		///
    		JLabel day= new JLabel("Mon 1");
    		day.setHorizontalAlignment(JLabel.CENTER);
    		day.setFont(new Font("Arial",0,13));
    		day.setBounds(0,5,75,15);
    		day.setOpaque(true);
    		day.setBackground(new Color(0,0,0,0));
    		a.add(day);
    		
    		

    		
//    		JLabel chiTiet= new JLabel();
//    		
//    		chiTiet.setHorizontalAlignment(JLabel.CENTER);
//    		chiTiet.setBounds(0,40,75,30);
//    		chiTiet.setOpaque(true);
//    		chiTiet.setBackground(new Color(0,0,0,0));
//    		a.add(chiTiet);
    		
    		arr_1.add(a);
    		label_dayOfWeek_list.add(day);
    		panel_1.add(a);
    	}

    	JPanel thongTinChamCong= new JPanel();
    	thongTinChamCong.setBounds(110,340,450,40);
    	panel.add(thongTinChamCong);
    	thongTinChamCong.setLayout(null);
    	ArrayList<JLabel> arr= new ArrayList<>();
    	
    	
    	int x=0;
    	String[] ab= {"Nghỉ","Đi Trễ","Tăng Ca","Xóa"};
    	for(int i=0; i<4;i++) {
    		JLabel b= new JLabel(ab[i]);
       		b.setBackground(Color.white);
    		b.setHorizontalAlignment(JLabel.CENTER);
    		if(i==0) {
    			b.setBackground(color_Nghi);
    		}
    		b.setBounds(x,0,80,40);
    		x+=90;
       		b.setOpaque(true);
       		arr.add(b);
    		thongTinChamCong.add(b);
    	}
    	JPanel tangCa= new JPanel();
    	tangCa.setLayout(null);
    	tangCa.setBounds(100, 390, 400, 30);
    	panel.add(tangCa);
    	tangCa.setVisible(false);
    	
		JLabel title_tangCa= new JLabel("Giờ tăng ca: ");
		title_tangCa.setFont(new Font("Arial",0,13));
		title_tangCa.setBounds(0,5,150,30);
		tangCa.add(title_tangCa);
    	
    	int x_1=100;
    	ButtonGroup g= new ButtonGroup();
    	String[] abc= {"1 Giờ","2 Giờ","3 Giờ","4 Giờ"};
    	ArrayList<JRadioButton> arr_radio= new ArrayList<>();
    	for(int i=0;i<4;i++) {
        	JRadioButton r1= new JRadioButton(abc[i]);
    		if(i==0) {
    			r1.setSelected(true);
    		}
    		r1.setFocusable(false);
    		r1.setFont(new Font("Arial",0,13));
        	r1.setBounds(x_1,5,70,30);
        	g.add(r1);
        	arr_radio.add(r1);
        	x_1+=70;
        	tangCa.add(r1);
    	} 
    	
    	for(JLabel i: arr) {
    		i.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for(JLabel i: arr) {
						i.setBackground(Color.white);
					}
					// TODO Auto-generated method stub
					if(i.getText().equals("Nghỉ")) {
						i.setBackground(color_Nghi);
						setColor(color_Nghi);
						tangCa.setVisible(false);

					}
					if(i.getText().equals("Nghỉ Phép")) {
						i.setBackground(Color.magenta);
						setColor(Color.magenta);
						tangCa.setVisible(false);

					}
					if(i.getText().equals("Đi Trễ")) {
						i.setBackground(color_Tre);
						setColor(color_Tre);
						tangCa.setVisible(false);


					}
					if(i.getText().equals("Tăng Ca")) {
						i.setBackground(color_TangCa);
						setColor(color_TangCa);
						tangCa.setVisible(true);
					}
					if(i.getText().equals("Xóa")) {
						i.setBackground(Color.decode("#dfe6e9"));
						setColor(Color.white);
						tangCa.setVisible(false);

						
					}
				}
			});
    	}
    	for(JLabel i: arr_1) {
    		i.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(i.getBackground() == colorsunday) {
						return;
					}
					i.setBackground(getColor());
					System.out.println("You have clicked!");
					if(i.getBackground().equals(color_Nghi)) {
						i.setText("NGHỈ");
						
					}
					

					
					if(i.getBackground().equals(color_Tre)) {
						i.setText("TRỄ");
					}
					if(i.getBackground().equals(color_TangCa)) {
						for(JRadioButton j: arr_radio) {
							if(j.isSelected()==true) {
								i.setHorizontalAlignment(JLabel.CENTER);
								i.setText("<html> TĂNG CA <br> "+ j.getText()+ "</html>");
								break;
							}
							
						}
					}
					if(i.getBackground() == Color.white) {
						i.setText("");
					}
				}
			});
    	}
    	
    	
    	
    	
    	
//    	JPanel panel= new JPanel();
//    	panel.setBounds(420,50,600,550);
//    	panel.setLayout(null);
//    	panel.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
//    	this.add(panel);
    	
    	JScrollPane scrollPanne= new JScrollPane(table);
    	scrollPanne.setVerticalScrollBar(new myScrollBar());
    	scrollPanne.setBounds(10, 80, 450, 550);
    	scrollPanne.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
    	panelFrame.add(scrollPanne);
    	

        
        dateChooser.DateChooser dc = new dateChooser.DateChooser();
        dc.setTextRefernce(tGetNgayThangNam);

        btnThem = new Button();
        btnThem.setText("Thêm");
        btnThem.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
        btnThem.setFont(new Font("Arial", 1, 13));
        btnThem.setForeground(Color.white);
        btnThem.setBackground(Color.decode("#44bd32"));
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setBounds(470, 500, 100, 40);
        btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnThem);
        
        
        // set up end
        LocalDate temp_date = LocalDate.now();
    	nam.setSelectedIndex(2);
    	thang.setSelectedIndex(temp_date.getMonthValue()-1);
    	updateDayOfWeek(temp_date.getMonthValue(), temp_date.getYear());
       
    }
    public void updateDayOfWeek(int month, int year) {
    	int daysOfMonth = getDayOfMonth(month, year);
    	for (int i=1;i<=daysOfMonth;i++) {
    		LocalDate tempdate = LocalDate.of(year, month, i);
    		String temp = "";
    		switch (tempdate.getDayOfWeek().toString()){
    			case "MONDAY":
    				temp = "Hai";
    				break;
    			case "TUESDAY":
    				temp = "Ba";
    				break;
    			case "WEDNESDAY":
    				temp = "Tư";
    				break;
    			case "THURSDAY":
    				temp = "Năm";
    				break;
    			case "FRIDAY":
    				temp = "Sáu";
    				break;
    			case "SATURDAY":
    				temp = "Bảy";
    				
    				break;
    			case "SUNDAY":
    				temp = "CN";
    				arr_1.get(i-1).setBackground(colorsunday);
    				break;
			
			default:
				temp = "Hi";
				break;
			}
    		 label_dayOfWeek_list.get(i-1).setText(i + "  "+temp);
    	}
    }
    public int getDayOfMonth(int month, int year) {
    	switch (month) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if( (year%4==0 && year%100!=0) || year%400==0) {
				return 29;
			}
			return 28;
		default:
			return 0;
		}
    }
    public void CapNhatTrangThai() {
    	//Set lại chưa chấm công
        int row_num= table.getRowCount();
        for(int i=0;i<row_num;i++) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int column = 2; // cột thứ 3
			model.setValueAt("Chưa chấm công", i, column); // Gán giá trị mới cho ô
        }

    	//Set lại nhân viên đã được chấm công
        for(int i=0;i<row_num;i++) {
        	String a= table.getValueAt(i, 1).toString().split(" ")[0];
        	String b= thang.getSelectedItem().toString().split(" ")[1];
        	String c="BCC"+b+nam.getSelectedItem().toString() + a;
        	for(BANGCHAMCONG j: access_BANGCHAMCONG.getList()) {
        		if(j.getMaBangChamCong().equals(c)) {
        			DefaultTableModel model = (DefaultTableModel) table.getModel();
        			int column = 2; // cột thứ 3
        			model.setValueAt("Đã chấm công", i, column); // Gán giá trị mới cho ô
        		}
        	}

        }
    }
    /* Get, set */
    public JButton getBtnThem() {
        return btnThem;
    }

    public JTextField gettMaNV() {
        return tMaNV;
    }

    public JTextField gettLam() {
        return tLam;
    }

    public JTextField gettNghi() {
        return tNghi;
    }

    public JTextField gettTre() {
        return tTre;
    }

    public JTextField gettLamThem() {
        return tLamThem;
    }

    public JTextField gettNgayChamCong() {
        return tNgayChamCong;
    }

    public JTextField gettGetNgayThangNam() {
        return tGetNgayThangNam;
    }
    /*  */
    public void reset() {
        this.tMaNV.setText("");
        this.tLam.setText("");
        this.tNghi.setText("");
        this.tTre.setText("");
        this.tLamThem.setText("");
    }
    public ArrayList<JLabel> getArr_1() {
		return arr_1;
	}
	public void setArr_1(ArrayList<JLabel> arr_1) {
		this.arr_1 = arr_1;
	}
	public void setThang(JComboBox<String> thang) {
		this.thang = thang;
	}
	public JLabel getMa_Ten() {
		return ma_Ten;
	}
	public void setMa_Ten(JLabel ma_Ten) {
		this.ma_Ten = ma_Ten;
	}
	public JComboBox<String> getThang() {
		return thang;
	}
	public JComboBox<String> getNam() {
		return nam;
	}
	public void setNam(JComboBox<String> nam) {
		this.nam = nam;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Object[][] getData() {
		return data;
	}
	public void setData(Object[][] data) {
		this.data = data;
		gender();
		formatSizeColumn();
	}
	public void formatSizeColumn() {
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(235);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
  
    }
	public myTable getObjectTable() {
		return table;
	}
	public void setTable(myTable table) {
		this.table = table;
	}
	public void gender() {
    	DefaultTableModel dftable= new DefaultTableModel(data, title) {
    		public boolean isCellEditable(int row, int column) {
			       return false;
			   }
    	};
    	table.setModel(dftable);
	}
    public BangChamCongForm2_1() {
    	this.lb = new JLabel("Nhập thông tin bảng chấm công");

        this.tMaNV = new JTextField();
        this.tLam = new JTextField();
        this.tNghi = new JTextField();
        this.tTre = new JTextField();
        this.tLamThem = new JTextField();
        this.tNgayChamCong = new JTextField();
        this.tGetNgayThangNam = new JTextField();

       
        this.btnReset = new JButton("Reset");

        this.font = new Font("Arial", 0, 14);
        this.fontB = new Font("Arial", 1, 14);
        this.init();
    }
    public JButton getBtnBack() {
    	return this.btnBack;
    }

}
