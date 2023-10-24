package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import DTO.SUPPORT;
import dateChooser.DateChooser;
import view.button.Button;

@SuppressWarnings("FieldMayBeFinal")
public class BangDanhGiaForm1 extends JPanel {

    private JTextField findField;
    private myCombobox<String> cbbSort;
    private myCombobox<String> cbbSort_Asc_Desc;
    private myCombobox<String> cbbFilterPhong;
    private myCombobox<String> cbbFilterMonth;
    private myCombobox<String> cbbFilterYear;
    private myCombobox<String> cbbLoaiDanhGia;
    private boolean enable_sort;
    private boolean enable_filter;
    private boolean enable_find;
    private JButton btnFind;
    private JButton btnChiTiet;
    private JButton btnXoa;
    private JPanel panelFilter;
    private myTable table;
    private DefaultTableModel model;
    private ArrayList<JPanel> optionBtn;
    private JButton btnThem;
    private JButton btnExport;
    private JPanel optionPanel;
    private Object[][] data;
    private JTextField tfBatDau;
    private JTextField tfKetThuc;
    
    private static final String[] columnName = {"STT", "Mã đánh giá", "Nhân viên", "Thời gian", "Người đánh giá", "Điểm đánh giá","Xếp loại","Loại đánh giá"};

    public ArrayList<JLabel> getArr() {
		return arr;
	}
    public JTextField getTfBatDau() {
    	return this.tfBatDau;
    }
    public JTextField getTfKetThuc() {
    	return this.tfKetThuc;
    }
    public JButton getBtnXoa() {
    	return this.btnXoa;
    }
    public JButton getBtnChiTiet() {
    	return this.btnChiTiet;
    }
	public void setArr(ArrayList<JLabel> arr) {
		this.arr = arr;
	}
	public JComboBox<String> getCbbLoaiDanhGia(){
		return this.cbbLoaiDanhGia;
	}

	private ActionListener control;
	private JLabel label_Find;
	private JScrollPane jsp1;
	private ArrayList<JLabel>  arr;

    public JScrollPane getJsp1() {
		return jsp1;
	}

	public void setJsp1(JScrollPane jsp1) {
		this.jsp1 = jsp1;
	}

	public BangDanhGiaForm1() {
        enable_filter = false;
        enable_find = true;
        enable_sort = false;
        data = new Object[][]{
        	{"1","DG00001012023","000 - Nguyễn Văn A","01-01-2023","108","Giỏi"},
        	{"2","DG00011012023","001 - Hồ Đỗ Hoàng Khang","01-01-2023","108","Giỏi"},
        	{"3","DG00021012023","002 - Tăng Hồng Nguyên Đán","01-01-2023","108","Giỏi"},
        	{"4","DG00031012023","003 - Nguyễn Thị Mỹ Nương","01-01-2023","108","Giỏi"},
        	{"5","DG00041012023","004 - Hà Thị Kim Ngọc","01-01-2023","108","Giỏi"},
        	{"6","DG00051012023","005 - Đỗ Thị Cẩm Tiên","01-01-2023","108","Giỏi"},
        	{"7","DG00061012023","006 - Trần Ngọc Thảo Ngân","01-01-2023","108","Giỏi"},
        	{"8","DG00071012023","007 - Lâm Nguyễn Mỹ Hoàng","01-01-2023","108","Giỏi"},
        	{"9","DG00081012023","008 - Phan Thị Chúc Ly","01-01-2023","108","Giỏi"},
        	{"10","DG00901012023","009 - Trần Phúc Đình Lâm","01-01-2023","108","Giỏi"},
        };
        model = new DefaultTableModel(data, columnName) {
        	public boolean isCellEditable(int row, int column) {
			       return false;
			  }
        };
        init();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(null);

        JPanel panelFeature = new JPanel();
        panelFeature.setBounds(10, 10, 1080, 70);
        panelFeature.setBackground(Color.white);
        this.add(panelFeature);
        panelFeature.setLayout(null);

        // Label
        JLabel titelLabel = new JLabel("Bảng đánh giá");
        titelLabel.setForeground(new Color(0, 0, 0, 140));
        titelLabel.setFont(new Font("arial", 1, 15));
        titelLabel.setBounds(10, 5, 300, 24);
        panelFeature.add(titelLabel);



     // label find
        label_Find = new JLabel("");
        label_Find.setBounds(245, 38, 28, 26);
        label_Find.setFont(new Font("sansserif", 1, 13));
        label_Find.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/findemployee.png")).getImage().getScaledInstance(18, 18, Image.SCALE_AREA_AVERAGING)));
        label_Find.setOpaque(true);
        label_Find.setBackground(Color.decode("#44bd32"));
        panelFeature.add(label_Find);

        // Ô tìm kiếm
        findField = new JTextField(" Tìm kiếm nhanh...");
        findField.setFont(new Font("Arial", 0, 15));
        findField.setForeground(new Color(0, 0, 0, 100));
        findField.setBounds(10, 38, 235, 26);
        panelFeature.add(findField);
        // Click chuột vào ô tìm kiếm
        findField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (findField.getText().equals(" Tìm kiếm nhanh...")) {
                    findField.setText(" ");
                }
            }
        });


        // panel filter
        panelFilter = new JPanel();
        panelFilter.setLayout(null);
        panelFilter.setBounds(270, 35, 820, 32);
        panelFilter.setBackground(Color.white);
        panelFeature.add(panelFilter);


        // Sắp xếp theo
        String strloaiDanhGia[] = {"Loại đánh giá", "Tự đánh giá","Được đánh giá"};
        
        cbbLoaiDanhGia = new myCombobox<>();
        cbbLoaiDanhGia.setModel(new DefaultComboBoxModel<>(strloaiDanhGia));
        cbbLoaiDanhGia.setFont(new Font("Arial", 1, 13));
        cbbLoaiDanhGia.setForeground(new Color(0, 0, 0, 160));
        cbbLoaiDanhGia.setBounds(350,3,120,26);
        cbbLoaiDanhGia.setFocusable(false);
		panelFilter.add(cbbLoaiDanhGia);
		String strSort[] = {"Sắp xếp: Ngày đánh giá", "Sắp xếp: Điểm đánh giá"};
        cbbSort = new myCombobox<>();
        cbbSort.setModel(new DefaultComboBoxModel<>(strSort));
        cbbSort.setFont(new Font("Arial", 1, 13));
        cbbSort.setForeground(new Color(0, 0, 0, 160));
		cbbSort.setBounds(480,3,210,26);
		panelFilter.add(cbbSort);

        // Tăng dần, giảm dần
        String strSort2[] = {"Giảm dần", "Tăng dần"};
        cbbSort_Asc_Desc = new myCombobox<>();
        cbbSort_Asc_Desc.setModel(new DefaultComboBoxModel<>(strSort2));
        cbbSort_Asc_Desc.setFont(new Font("Arial", 1, 13));
        cbbSort_Asc_Desc.setForeground(new Color(0, 0, 0, 160));
        cbbSort_Asc_Desc.setBounds(700,3,100,26);
		panelFilter.add(cbbSort_Asc_Desc);


		
        /* ------------------------------------------------------------------------------ */


        // Combo box lọc phòng
        

        // combo box tháng
        
        
        
        tfKetThuc = new JTextField();
        tfKetThuc.setFont(new Font("Arial", 1, 13));
        tfKetThuc.setForeground(new Color(0, 0, 0, 160));
        tfKetThuc.setBounds(200,3,120,26);
        tfKetThuc.setBackground(Color.white);
        panelFilter.add(tfKetThuc);
        DateChooser dc = new DateChooser();
        dc.setTextRefernce(tfKetThuc);
        JLabel lb = new JLabel("Đến");
        lb.setBounds(160,3,100,26);
        lb.setFont(new Font("Arial",0,13));
        panelFilter.add(lb);
        // combo box năm
        tfBatDau = new JTextField();
        tfBatDau.setFont(new Font("Arial", 1, 13));
        tfBatDau.setForeground(new Color(0, 0, 0, 160));
        tfBatDau.setBounds(23,3,120,26);
        tfBatDau.setBackground(Color.white);
        panelFilter.add(tfBatDau);
        DateChooser dc2 = new DateChooser();
        dc2.setTextRefernce(tfBatDau);
		LocalDate nOW = LocalDate.now().minusYears(2);
		tfBatDau.setText(SUPPORT.LocalDateToString(nOW));
        /* ------------------------------------------------------------------------------ */


        
        btnXoa = new JButton();
        btnXoa.setText("Xóa");
        btnXoa.setFont(new Font("Arial", 1, 13));
        btnXoa.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/danhgiaxoa.png")).getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
        btnXoa.setBounds(770, 3, 90,30);
        btnXoa.setFocusable(false);
        panelFeature.add(btnXoa);

        btnChiTiet = new JButton();
        btnChiTiet.setText("Chi tiết");
        btnChiTiet.setFont(new Font("Arial", 1, 13));
        btnChiTiet.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/danhgiasua.png")).getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
        btnChiTiet.setBounds(870, 3, 100,30);
        btnChiTiet.setFocusable(false);
        panelFeature.add(btnChiTiet);
        // button thêm
        btnThem = new JButton();
        btnThem.setText("Thêm");
        btnThem.setFont(new Font("Arial", 1, 13));
        btnThem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/danhgiathem.png")).getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
        btnThem.setBounds(980, 3, 90,30);
        btnThem.setFocusable(false);
        panelFeature.add(btnThem);

//        btnThem.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//            }
//        });

        



        // click chuột button filter


        /* ---------------------------------- TABLE ----------------------------------- */


        this.table = new myTable();
        table.setRowHeight(40);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Color selectedColor = Color.decode("#2980b9");
                Color backgroundSelected = new Color(245, 245, 245);

                String str = o + "";
                str = "  " + str;
                o = (Object) str;
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                setBorder(noFocusBorder);
                if (selected) {
                    com.setBackground(backgroundSelected);
                    com.setFont(new Font("Arial", Font.PLAIN, 13));
                    com.setForeground(selectedColor);
                } else {
                    com.setBackground(Color.WHITE);
                    com.setFont(new Font("Arial", Font.PLAIN, 13));
                    com.setForeground(new Color(102, 102, 102));
                }
                return com;
            }
        });
        table.setModel(model);
        formatSizeColumn();
        
        jsp1 = new JScrollPane(table);
        jsp1.setVerticalScrollBar(new myScrollBar());
        jsp1.setBorder(new LineBorder(Color.gray,2));
        jsp1.setBounds(10, 90, 1080, 610);
        this.add(jsp1);
        
       
        
        //Chi tiết ngày nghỉ
       

        
        
        
        //
        /* Right click */
        optionPanel = new JPanelOval();
//        optionPanel.setBorder(new LineBorder(Color.gray, 1));

        ((JPanelOval) optionPanel).setColor(new Color(0, 0, 0, 60));
        optionPanel.setLayout(null);
        table.add(optionPanel);
        
        JPanelOval panelTemp = new JPanelOval();
        panelTemp.setBounds(1, 1, 187, 68);
        panelTemp.setLayout(null);
        panelTemp.setColor(Color.white);
        optionPanel.add(panelTemp);

        String infoNameBtn[] = {"Xóa", "Chi tiết"};
        String infoIconBtn[] = {"delete.png", "info.png"};
        optionBtn = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            JPanel btnDel = new JPanel();
            btnDel.setBackground(Color.white);
            btnDel.setFont(new Font("sansserif", 0, 14));
            btnDel.setBounds(6, 5 + i * 30, 177, 30);
            panelTemp.add(btnDel);
            btnDel.setLayout(null);
            JLabel lbicondel = new JLabel();
            lbicondel.setBounds(10, 0, 30, 30);
            lbicondel.setIcon(new ImageIcon(getClass().getResource("/assets/img/" + infoIconBtn[i])));
            btnDel.add(lbicondel);
            JLabel lbicondel2 = new JLabel(infoNameBtn[i]);
            lbicondel2.setFont(new Font("sansserif", 0, 14));
            lbicondel2.setBounds(50, 0, 140, 30);
            btnDel.add(lbicondel2);
            optionBtn.add(btnDel);
        }
        for (JPanel i : optionBtn) {
            i.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    i.setBackground(Color.white);
                    repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    i.setBackground(new Color(235, 235, 235));
                    repaint();
                }
            });
        }

        optionPanel.setVisible(false);
    }
    
    /* -------------------------------------------------------------- */
    // Get Set

    public JButton getBtnFind() {
        return btnFind;
    }


    public boolean getEnable_find() {
        return enable_find;
    }

    public boolean getEnable_sort() {
        return enable_sort;
    }

    public boolean getEnable_filter() {
        return enable_filter;
    }

    public myCombobox<String> getCbbSort() {
        return cbbSort;
    }

    public myCombobox<String> getCbbSort_Asc_Desc() {
        return cbbSort_Asc_Desc;
    }

    public myCombobox<String> getCbbFilterPhong() {
        return cbbFilterPhong;
    }

    public myCombobox<String> getCbbFilterMonth() {
        return cbbFilterMonth;
    }

    public myCombobox<String> getCbbFilterYear() {
        return cbbFilterYear;
    }

    public void setEnable_sort(boolean enable_sort) {
        this.enable_sort = enable_sort;
    }

    public void setEnable_find(boolean enable_find) {
        this.enable_find = enable_find;
    }

    public void setEnable_filter(boolean enable_filter) {
        this.enable_filter = enable_filter;
    }

    public JTextField getFindField() {
        return this.findField;
    }

    public JButton getBtnThem() {
        return this.btnThem;
    }

    public ArrayList<JPanel> getOptionBtn() {
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
    
    /* -------------------------------------------------------------- */

    // An hien find, filter, sort

    // Set data cho bang
    public void setData(Object[][] data) {
        this.data = data;
        model.setDataVector(this.data, columnName);
        formatSizeColumn();
    }

    // kích thước cột
    public void formatSizeColumn() {
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(210);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(210);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(6).setPreferredWidth(110);
        table.getColumnModel().getColumn(7).setPreferredWidth(110);
    }

    public String[] getIDEmployeeToDelete() {
        int n = table.getSelectedRowCount();
        String str[] = new String[n];
        if (n > 1) {
            int arr[] = table.getSelectedRows();
            for (int i = 0; i < arr.length; i++) {
                str[i] = (model.getValueAt(i, 2) + "").split(",")[0];
            }
            return str;
        }
        return new String[]{(model.getValueAt(table.getSelectedRow(), 2) + "").split(",")[0]};

    }

    public String getTextFromFindField() {
        String s = findField.getText();
        s = s.trim();
        if (s.equals("Tìm kiếm nhanh...")) {
            return "";
        }
        return s;
    }

    public void setCbbFilterData(String[] str) {
        cbbFilterPhong.setModel(new DefaultComboBoxModel<>(str));
    }
    public Object[][] getData(){
    	return this.data;
    }
    public JButton getBtnExport() {
    	return this.btnExport;
    }
}
