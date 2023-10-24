package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class TuyenDungView extends JPanel {
	private TuyenDungView_Them tuyenDungView_Them;
	private JButton button_TuyenDung_SapXep;
	private JButton button_TuyenDung_Them;
	private JButton button_TuyenDung_NhapFile;
	private JButton button_TuyenDung_XuatFile;
	private JButton button_Timkiem;
	private JTextField TuyenDung_Find;
	private myTable Table;
	private DefaultTableModel tableModel;
	private Object[][] data;
	private String [] title_table={"Đợt", "Mã tuyển dụng","Chức vụ","Học vấn","Giới tính","Độ tuổi","SL cần tuyển","SL nộp hồ sơ","SL đã tuyển","Hạn nộp","Mức lương tối thiểu","Mức lương tối đa"};
	private JButton button_TuyenDung_Xoa;
	private JButton button_TuyenDung_TuyenThem;
	public JButton getButton_Timkiem() {
		return button_Timkiem;
	}
	public void setButton_Timkiem(JButton button_Timkiem) {
		this.button_Timkiem = button_Timkiem;
	}
	public TuyenDungView() {
		init();
		tuyenDungView_Them= new TuyenDungView_Them();
		tuyenDungView_Them.setVisible(false);
	}
	
	public void init() {
		this.setLayout(null);
		

		
		
		button_TuyenDung_Them= new JButton("Thêm");
		button_TuyenDung_Them.setHorizontalAlignment(SwingConstants.LEFT);
		button_TuyenDung_Them.setFont(new Font("Arial",0,13));
		this.add(button_TuyenDung_Them);
		button_TuyenDung_Them.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/Td_Add.png")).getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT)));
		button_TuyenDung_Them.setBounds(980,20,90,30);
		
		
		
		
		
		button_TuyenDung_Xoa= new JButton("Xóa");
		button_TuyenDung_Xoa.setFont(new Font("Arial",0,13));
		this.add(button_TuyenDung_Xoa);
		button_TuyenDung_Xoa.setHorizontalAlignment(SwingConstants.LEFT);
		button_TuyenDung_Xoa.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/Td_Del.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		button_TuyenDung_Xoa.setForeground(new Color(128,128,128,100));
		button_TuyenDung_Xoa.setBounds(880,20,90,30);

		TuyenDung_Find= new JTextField("Nhập thông tin tìm kiếm",JTextField.CENTER);
		this.add(TuyenDung_Find);
		TuyenDung_Find.setBounds(10,20,300,30);
		TuyenDung_Find.setFont(new Font("Arial",0,13));
		
		JLabel find= new JLabel();
		find.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/find.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		find.setBounds(310,20,30,30);
		find.setOpaque(true);
		find.setBackground(new Color(204,229,255));
		this.add(find);

		//Table
        tableModel = new DefaultTableModel(data, title_table) {
        	public boolean isCellEditable(int row, int column) {
			       return false;
			  }
        };
        Table = new myTable();
        Table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	
            	//đổi màu chữ "Xóa"
				button_TuyenDung_Xoa.setForeground(Color.black);
            }
			@Override
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
        });
        Table.setModel(tableModel);
        
        renderData();


        JScrollPane scrollPane = new JScrollPane(Table);
        scrollPane.setBounds(10,70,1060,570);
        scrollPane.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
        this.add(scrollPane);
        
		this.setBounds(220,46,1065,615);
		this.setBackground(new Color(70,130,180));
		this.setVisible(true);
	}
	public void setData(Object[][] data) {
		this.data = data;
		renderData();
	}
	public void renderData() {
        tableModel = new DefaultTableModel(data, title_table);
        Table.setModel(tableModel);
	}
	public JButton getButton_TuyenDung_Xoa() {
		return button_TuyenDung_Xoa;
	}
	public JButton getButton_TuyenDung_Them() {
		return button_TuyenDung_Them;
	}
	public myTable getObjectTable() {
		return Table;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public JButton getButton_TuyenDung_SapXep() {
		return button_TuyenDung_SapXep;
	}
	public JButton getButton_TuyenDung_NhapFile() {
		return button_TuyenDung_NhapFile;
	}
	public JButton getButton_TuyenDung_XuatFile() {
		return button_TuyenDung_XuatFile;
	}
	public TuyenDungView_Them getTuyenDungView_Them() {
		return tuyenDungView_Them;
	}

	public JTextField getTuyenDung_Find() {
		return TuyenDung_Find;
	}
	public Object[][] getData() {
		return data;
	}
	
	public String[] getTitle_table() {
		return title_table;
	}
	
	public JButton getButton_TuyenDung_TuyenThem() {
		return button_TuyenDung_TuyenThem;
	}
	

}


