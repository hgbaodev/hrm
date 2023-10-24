package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import view.chart.PieChart;

public class ConTractForm1 extends JPanel {

	private JTextField findField;
	private myCombobox<String> cbbSort;
	private myCombobox<String> cbbSort_Asc_Desc;
	private myCombobox<String> cbbFilter;
	private myCombobox<String> cbbFilter2;
	private boolean enable_sort;
	private boolean enable_filter;
	private boolean enable_find;
	private JButton btnFind;
	private JButton btnFilter;
	private JButton btnSort;
	private JButton btnExport;
	private JTextField minSalary;
	private JTextField maxSalary;
	private JPanel panelSort;
	private JPanel panelFilter;
	private myTable table;
	private DefaultTableModel model;
	private ArrayList<JPanel> optionBtn;
//	private JButton btnThem;
	private JPanel optionPanel;
	private Object[][] data;
	private static String[] columnName = { "STT", "Mã - Tên nhân viên", "Phòng ban", "Từ ngày",
			"Đến ngày", "Loại hợp đồng", "Lương cơ bản" };

	public ConTractForm1() {
		enable_find = false;
		enable_filter = false;
		enable_sort = false;
		data = null;
		model = new DefaultTableModel(data, columnName) {
			public boolean isCellEditable(int row, int column) {
			       return false;
			   }
		};
		init();

	}  

	public void init() {

		this.setLayout(null);

		JPanel panelFeature = new JPanel();
		panelFeature.setBounds(0, 0, 1080, 40);
		panelFeature.setBackground(Color.white);
		this.add(panelFeature);
		panelFeature.setLayout(null);

		findField = new JTextField(" Tìm kiếm nhanh...");
//		findField.setBorder(new EmptyBorder(0, 0, 0, 0));
		findField.setFont(new Font("Arial", 0, 15));
		findField.setForeground(new Color(0, 0, 0, 100));
		findField.setBounds(540, 7, 380, 26);

		findField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("hahah");
				if (findField.getText().equals(" Tìm kiếm nhanh...")) {
					findField.setText(" ");
				}
			}
		});
		panelSort = new JPanel();
		panelSort.setLayout(null);
		panelSort.setBounds(545, 5, 370, 30);
		panelSort.setBackground(Color.white);
		panelFeature.add(panelSort);
		

		cbbSort = new myCombobox<>();
		String strSort[] = { "Sắp xếp theo: Mã số", "Sắp xếp theo: Họ tên", "Sắp xếp theo: Loại hợp đồng","Sắp xếp theo: Ngày bắt đầu","Sắp xếp theo: Ngày hết hạn", "Sắp xếp theo: Lương cơ bản" };
		cbbSort.setModel(new DefaultComboBoxModel<>(strSort));
		cbbSort.setFont(new Font("Arial", 1, 13));
		cbbSort.setForeground(new Color(0, 0, 0, 160));
		cbbSort.setBounds(10, 2, 220, 26);
		cbbSort.setFocusable(false);
		panelSort.add(cbbSort);
		
		cbbSort_Asc_Desc = new myCombobox<>();
		String strSort2[] = { "Tăng dần", "Giảm dần" };
		cbbSort_Asc_Desc.setModel(new DefaultComboBoxModel<>(strSort2));
		cbbSort_Asc_Desc.setFont(new Font("Arial", 1, 13));
		cbbSort_Asc_Desc.setForeground(new Color(0, 0, 0, 160));
		cbbSort_Asc_Desc.setBounds(240, 2, 120, 26);
		cbbSort_Asc_Desc.setFocusable(false);
		panelSort.add(cbbSort_Asc_Desc);

		// panel filter
		panelFilter = new JPanel();
		panelFilter.setLayout(null);
		panelFilter.setBounds(25, 5, 880, 30);
		panelFilter.setBackground(Color.white);
		panelFeature.add(panelFilter);
		

		cbbFilter = new myCombobox<>();

		cbbFilter.setFont(new Font("Arial", 1, 13));
		cbbFilter.setForeground(new Color(0, 0, 0, 160));
		cbbFilter.setBounds(0, 2, 260, 26);
		cbbFilter.setFocusable(false);
		panelFilter.add(cbbFilter);
		((myCombobox<String>)cbbFilter).showArrow();

		cbbFilter2 = new myCombobox<>();
		String strFilter2[] = { "Loại hợp đồng", "1 năm", "2 năm", "3 năm", "4 năm", "5 năm", "6 năm", "7 năm", "8 năm",
				"9 năm", "10 năm", "trên 10 năm" };
		cbbFilter2.setModel(new DefaultComboBoxModel<>(strFilter2));
		cbbFilter2.setFont(new Font("Arial", 1, 13));
		cbbFilter2.setForeground(new Color(0, 0, 0, 160));
		cbbFilter2.setBounds(270, 2, 180, 26);
		cbbFilter2.setFocusable(false);
		panelFilter.add(cbbFilter2);
		((myCombobox<String>)cbbFilter2).showArrow();
		

		

		

		JLabel blFilter3 = new JLabel("Lương từ");
		blFilter3.setFont(new Font("Arial", 1, 13));
		blFilter3.setForeground(new Color(0, 0, 0, 160));
		blFilter3.setBounds(480, 0, 120, 32);
		panelFilter.add(blFilter3);
		
		JLabel blFilter4 = new JLabel("đến");
		blFilter4.setFont(new Font("Arial", 1, 13));
		blFilter4.setForeground(new Color(0, 0, 0, 160));
		blFilter4.setBounds(705, 0, 120, 32);
		panelFilter.add(blFilter4);
		
		minSalary = new JTextField();
		minSalary.setFont(new Font("Arial", 0, 15));
		minSalary.setForeground(new Color(10, 0, 0, 100));
		minSalary.setBounds(555, 2, 140, 26);

		maxSalary = new JTextField();
		maxSalary.setFont(new Font("Arial", 0, 15));
		maxSalary.setForeground(new Color(10, 0, 0, 100));
		maxSalary.setBounds(740, 2, 140, 26);
		

		panelFeature.add(findField);
		panelFilter.add(minSalary);
		panelFilter.add(maxSalary);

//		findField.setVisible(false);
		panelFilter.setVisible(false);
		panelSort.setVisible(false);

		btnFind = new JButton("");
		btnFind.setFont(new Font("sansserif", 1, 13));
		btnFind.setIcon(new ImageIcon(getClass().getResource("/assets/img/findemployee.png")));
		btnFind.setBounds(920, 7, 30, 26);
		btnFind.setBorderPainted(false);
		btnFind.setFocusPainted(false);
		btnFind.setBackground(Color.decode("#44bd32"));
		panelFeature.add(btnFind);

		btnFilter = new JButton("");
		btnFilter.setFont(new Font("sansserif", 1, 13));
		btnFilter.setIcon(new ImageIcon(getClass().getResource("/assets/img/filter.png")));
		btnFilter.setBounds(960, 7, 30, 26);
		btnFilter.setBorderPainted(false);
		btnFilter.setFocusPainted(false);
		btnFilter.setBackground(Color.decode("#3498db"));
		panelFeature.add(btnFilter);
		btnSort = new JButton("");
		btnSort.setFont(new Font("sansserif", 1, 13));
		btnSort.setIcon(new ImageIcon(getClass().getResource("/assets/img/sort.png")));
		btnSort.setBounds(1000, 7, 30, 26);
		btnSort.setBorderPainted(false);
		btnSort.setFocusPainted(false);
		btnSort.setBackground(Color.decode("#3498db"));
		panelFeature.add(btnSort);

		btnFind.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (btnFind.getBackground().equals(Color.decode("#3498db"))) {
					// tìm kiếm
					btnFind.setBackground(Color.decode("#44bd32"));
					showFindFilterShort(0);
					enable_find = true;
//				findField.setVisible(true);

////				reset sort
					btnSort.setBackground(Color.decode("#3498db"));
//				enable_sort = false;

					btnFilter.setBackground(Color.decode("#3498db"));

				} else {
					// hủy tìm kiếm
					findField.setText(" Tìm kiếm nhanh...");
					btnFind.setBackground(Color.decode("#3498db"));
					enable_find = false;
					findField.setVisible(false);
					if (enable_filter) {
						panelFilter.setVisible(true);
					} else if (enable_sort) {
						panelSort.setVisible(true);
					}
				}
			}
		});
		btnSort.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (btnSort.getBackground().equals(Color.decode("#3498db"))) {
					// sắp xếp
					btnSort.setBackground(Color.decode("#44bd32"));
					showFindFilterShort(2);
					enable_sort = true;

//					// reset find
					btnFind.setBackground(Color.decode("#3498db"));
//					enable_find = false;
//					findField.setText(" Tìm kiếm nhanh...");
//					
//					// lọc
					btnFilter.setBackground(Color.decode("#3498db"));
//					enable_filter = false;

				} else {
					// hủy sắp xếp
					btnSort.setBackground(Color.decode("#3498db"));
					cbbSort.setSelectedIndex(0);
					cbbSort_Asc_Desc.setSelectedIndex(0);
					enable_sort = false;
					panelSort.setVisible(false);

					//
//					panelSort.setVisible(false);
					if (enable_filter) {
						panelFilter.setVisible(true);
					} else if (enable_find) {
						findField.setVisible(true);
					}

					repaint();
				}
			}
		});

		btnFilter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (btnFilter.getBackground().equals(Color.decode("#3498db"))) {
					// lọc
					btnFilter.setBackground(Color.decode("#44bd32"));
					showFindFilterShort(1);
					enable_filter = true;
//					// reset sort
					btnSort.setBackground(Color.decode("#3498db"));
//					enable_sort = false;
//					
//					// reset find
					btnFind.setBackground(Color.decode("#3498db"));
//					enable_find = false;
//					findField.setText(" Tìm kiếm nhanh...");
				} else {
					// hủy lọc
					btnFilter.setBackground(Color.decode("#3498db"));
					cbbFilter.setSelectedIndex(0);
					cbbFilter2.setSelectedIndex(0);
					enable_filter = false;
					if (enable_find) {
						findField.setVisible(true);
					} else if (enable_sort) {
						panelSort.setVisible(true);
					}
					//
//					panelFilter.setVisible(false);			
				}
			}
		});


		btnExport = new JButton("");
		btnExport.setFont(new Font("sansserif", 1, 13));
		btnExport.setIcon(new ImageIcon(getClass().getResource("/assets/img/exportfile.png")));
		btnExport.setBounds(1040, 7, 30, 26);
		btnExport.setBackground(Color.decode("#3498db"));
		btnExport.setBorderPainted(false);
		btnExport.setFocusPainted(false);

		panelFeature.add(btnExport);

		JScrollPane jsp1 = new JScrollPane();
		jsp1.setBackground(Color.white);
		jsp1.setVerticalScrollBar(new myScrollBar());
		jsp1.setBorder(new EmptyBorder(0, 0, 0, 0));
		jsp1.setBounds(0, 50, 1080, 600);
		this.add(jsp1);

		table = new myTable();
		table.setRowHeight(40);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1,
					int i, int i1) {
				Color selectedColor = Color.decode("#2980b9");
				Color backgroundSelected = new Color(245, 245, 245);
				if (i1 == 1) {
					String str = (String) o;
//                	System.out.println(str);
					String[] arr = str.split(",");
//                	System.out.println(arr);
					JPanel p = new JPanel();
					p.setLayout(null);
					JLabel lbname = new JLabel(arr[0]);
					lbname.setFont(new Font("sansserif", 1, 13));
					lbname.setForeground(new Color(0,0,0,160));
					lbname.setBounds(0, 10, 220, 20);
					p.add(lbname);

					if (selected) {
						lbname.setForeground(selectedColor);
						p.setBackground(backgroundSelected);
					} else {
						p.setBackground(Color.WHITE);
					}
					return p;
				} else {
					if (i1 == 0) {
						String str = (String) o;
						str = "   " + str;
						o = (Object) str;
					}
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
			}
		});
		jsp1.setViewportView(table);

		table.setModel(model);

		optionPanel = new JPanelOval();
//		optionPanel.setBorder(new LineBorder(Color.gray,1));

		((JPanelOval) optionPanel).setColor(new Color(0, 0, 0, 60));
		optionPanel.setLayout(null);
		table.add(optionPanel);
		JPanelOval panelTemp = new JPanelOval();
		panelTemp.setBounds(1, 1, 187, 68);
		panelTemp.setLayout(null);
		panelTemp.setColor(Color.white);
		optionPanel.add(panelTemp);

		String infoNameBtn[] = { "Gia hạn hợp đồng", "Hủy hợp đồng" };
		String infoIconBtn[] = { "edit.png", "delete.png" };
		optionBtn = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			JPanel btnDel = new JPanel();
			btnDel.setBackground(Color.white);
			btnDel.setFont(new Font("sansserif", 0, 14));
			btnDel.setBounds(6, 5 + i * 30, 180, 30);
			panelTemp.add(btnDel);
			btnDel.setLayout(null);
			JLabel lbicondel = new JLabel();
			lbicondel.setBounds(10, 0, 30, 30);
			lbicondel.setIcon(new ImageIcon(getClass().getResource("/assets/img/" + infoIconBtn[i])));
			btnDel.add(lbicondel);
			JLabel lbicondel2 = new JLabel(infoNameBtn[i]);
			lbicondel2.setFont(new Font("sansserif", 0, 14));
			lbicondel2.setBounds(50, 0, 130, 30);
			btnDel.add(lbicondel2);
			optionBtn.add(btnDel);
		}
		
		for (JPanel i : optionBtn) {
			i.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					i.setBackground(Color.white);
					repaint();
				}

				public void mouseEntered(MouseEvent e) {
					i.setBackground(new Color(235, 235, 235));
					repaint();
				}
			});
		}

		optionPanel.setVisible(false);
	}

	public JButton getBtnFind() {
		return btnFind;
	}

	public JButton getBtnFilter() {
		return btnFilter;
	}

	public JButton getBtnSort() {
		return btnSort;
	}

	public boolean getEnable_find() {
		return enable_find;
	}

	public boolean getEnable_sort() {
		return enable_sort;
	}

	public void setEnable_sort(boolean enable_sort) {
		this.enable_sort = enable_sort;
	}

	public void setEnable_find(boolean enable_find) {
		this.enable_find = enable_find;
	}

	public boolean getEnable_filter() {
		return enable_filter;
	}

	public void setEnable_filter(boolean enable_filter) {
		this.enable_filter = enable_filter;
	}

	public myCombobox<String> getCbbSort() {
		return cbbSort;
	}

	public myCombobox<String> getCbbSort_Asc_Desc() {
		return cbbSort_Asc_Desc;
	}

	public myCombobox<String> getCbbFilter() {
		return cbbFilter;
	}

	public myCombobox<String> getCbbFilter2() {
		return cbbFilter2;
	}

	public void showFindFilterShort(int type) {
		if (type == 0) {
			findField.setVisible(true);
			panelSort.setVisible(false);
			panelFilter.setVisible(false);
		} else if (type == 1) {
			findField.setVisible(false);
			panelSort.setVisible(false);
			panelFilter.setVisible(true);
		} else {
			findField.setVisible(false);
			panelSort.setVisible(true);
			panelFilter.setVisible(false);
		}
	}

	public void setData(Object[][] data) {
		this.data = data;
		model.setDataVector(this.data, columnName);
		formatSizeColumn();
	}

	public void formatSizeColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(70); // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(250); // tên nhân viên
		table.getColumnModel().getColumn(2).setPreferredWidth(240); // phòng ban
		table.getColumnModel().getColumn(3).setPreferredWidth(130); // từ ngày
		table.getColumnModel().getColumn(4).setPreferredWidth(130); // đến ngày
		table.getColumnModel().getColumn(5).setPreferredWidth(115); // loại hợp đồng
		table.getColumnModel().getColumn(6).setPreferredWidth(140); // lương co ban
	}

	public JTextField getFindField() {
		return this.findField;
	}

	public JTextField getMinSalary() {
		return this.minSalary;
	}

	public JTextField getMaxSalary() {
		return this.maxSalary;
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
		return new String[] { (model.getValueAt(table.getSelectedRow(), 2) + "").split(",")[0] };

	}

	public String getTextFromFindField() {
		String s = findField.getText();
		s = s.trim();
		if (s.equals("Tìm kiếm nhanh...")) {
			return "";
		}
		return s;
	}

	public String getTextFromMinSalary() {
		String s = minSalary.getText();
		s = s.trim();
		if (s.equals(" Từ...")) {
			return "";
		}
		return s;
	}

	public String getTextFromMaxSalary() {
		String s = maxSalary.getText();
		s = s.trim();
		if (s.equals(" Đến...")) {
			return "";
		}
		return s;
	}

	public void setCbbFilterData(String[] str) {
		cbbFilter.setModel(new DefaultComboBoxModel<>(str));
	}
	public JButton getBtnExport() {
		return this.btnExport;
	}
	public Object[][] getData(){
		return this.data;
	}
}
