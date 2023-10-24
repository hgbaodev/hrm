package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.access_HOPDONGLAODONG;
import view.chart.ModelPieChart;
import view.chart.PieChart;
import view.chart.PieChart.PeiChartType;

public class ConTractForm3 extends JPanel{
	private Color[] color = {Color.decode("#0984e3"),Color.decode("#4cd137"),Color.decode("#f1c40f"),Color.decode("#FF8000"),Color.decode("#e74c3c") };
	private JLabel jLabelSoLuong;
	private DefaultTableModel  model;
	private JComboBox< String> cbbPhanLoai;
	private PieChart pieChart1;
	private PieChart pieChart2;
	private myTable table;
	private String []str = new String[] { "STT", "Mã - Tên nhân viên", "Phòng ban", "Từ ngày",
			"Đến ngày", "Loại hợp đồng", "Lương cơ bản" };
	private Object[][] conTractForm3Data;
	public ConTractForm3() {
		init();
	}
	public void init() {
		this.setBackground(Color.white);
		this.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBounds(10,10,1060,270);
//		panelTop.setBackground(Color.decode("#bdc3c7"));
		panelTop.setBorder(new LineBorder(Color.gray,1));
		this.add(panelTop);
		panelTop.setLayout(null);
		// TODO biểu đồ 1
		JLabel lbt1 = new JLabel("Tỉ lệ chênh lệch");
		lbt1.setBounds(30,20,300,30);
		lbt1.setFont(new Font("Arial",1,14));
		lbt1.setForeground(new Color(0,0,0,160));
		panelTop.add(lbt1);
		String lb0[] = {"Hợp đồng đã kí trong năm","Hợp đồng hết hạn trong năm"};
		
 		for(int i=0;i<2;i++) {
			JPanel pdt = new JPanel();
			pdt.setBounds(30,70+i*30,12,12);
			pdt.setBackground(color[i]);
			panelTop.add(pdt);
			JLabel lb = new JLabel(lb0[i]);
			lb.setBounds(60,61+i*30,300,30);
			lb.setFont(new Font("Arial",1,12));
			lb.setForeground(new Color(0,0,0,160));
			panelTop.add(lb);
		}
		
		pieChart1 = new PieChart();
		pieChart1.setChartType(PeiChartType.DEFAULT);
		ArrayList<ModelPieChart> modelPieChart1 = new ArrayList<>();
		modelPieChart1.add(new ModelPieChart("1",12,Color.red));
		modelPieChart1.add(new ModelPieChart("1",12,Color.blue));
	
		pieChart1.setData(modelPieChart1);
		pieChart1.setBounds(300,35,200,200);
		panelTop.add(pieChart1);
		
		// TODO biểu đồ 2
		JLabel lbt2 = new JLabel("Tỉ lệ các loại hợp đồng");
		lbt2.setBounds(630,20,300,30);
		lbt2.setFont(new Font("Arial",1,14));
		lbt2.setForeground(new Color(0,0,0,160));
		panelTop.add(lbt2);
		
		pieChart2 = new PieChart();
		
		pieChart2.setBounds(820,35,200,200);
		panelTop.add(pieChart2);
		String lbl[] = {"1 - 2 năm","3 - 5 năm","6 - 8 năm","9 - 10 năm","trên 10 năm"};
		
 		for(int i=0;i<5;i++) {
			JPanel pdt = new JPanel();
			pdt.setBounds(630,70+i*30,12,12);
			pdt.setBackground(color[i]);
			panelTop.add(pdt);
			JLabel lb = new JLabel(lbl[i]);
			lb.setBounds(660,61+i*30,200,30);
			lb.setFont(new Font("Arial",1,12));
			lb.setForeground(new Color(0,0,0,160));
			panelTop.add(lb);
		}
		
		
		
		
		
		
		
		
		// TODO
		cbbPhanLoai = new myCombobox<>();
		cbbPhanLoai.setBounds(10,300,180,30);
		cbbPhanLoai.setFont(new Font("Arial",1,13));
		cbbPhanLoai.setForeground(new Color(0,0,0,160));
		cbbPhanLoai.setModel(new DefaultComboBoxModel<>(new String[] {"Tất cả hợp đồng","Hợp đồng mới kí","Hợp đồng sắp hết hạn","Hợp đồng đã hết hạn"}));
		this.add(cbbPhanLoai);
		((myCombobox<String>)cbbPhanLoai).showArrow();
		    
		jLabelSoLuong = new JLabel("Số lượng: ");
		jLabelSoLuong.setFont(new Font("Arial",1,13));
		jLabelSoLuong.setForeground(new Color(0,0,0,160));
		jLabelSoLuong.setBounds(250,300,100,30);
		this.add(jLabelSoLuong);
		
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBackground(Color.white);
		jsp.setBounds(10,340,1060,302);
		jsp.setVerticalScrollBar(new myScrollBar());
		table = new myTable();
		table.setBackground(Color.white);
		jsp.setViewportView(table);
		
		jsp.setBorder(new EmptyBorder(0,0,0,0));
		this.add(jsp);
		this.setBackground(Color.white);
	}
	public void setConTractForm3Data(Object[][] data) {
		conTractForm3Data  = data;
		renderConTractForm3Data();
	}
	public void renderConTractForm3Data() {
		model = new DefaultTableModel(conTractForm3Data,str) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table.setModel(model);
		formatColumn();
	}
	public void formatColumn() {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(220);  // mã - tên nhân viên
		table.getColumnModel().getColumn(2).setPreferredWidth(230);  // phòng ban
		table.getColumnModel().getColumn(3).setPreferredWidth(140);  // mã hợp đồng
		table.getColumnModel().getColumn(4).setPreferredWidth(140);  // từ ngày
		table.getColumnModel().getColumn(5).setPreferredWidth(130);  // đến ngày
		table.getColumnModel().getColumn(6).setPreferredWidth(145);  // loại hợp đồng 
	}
	
	public myTable getTable() {
		return this.table;
	}
	
	public JComboBox<String> getCbbPhanLoai(){
		return this.cbbPhanLoai;
	}
	public JLabel getLabelSoLuong() {
		return this.jLabelSoLuong;
	}
	public void setDataPieChart1(int []data) {
		ArrayList<ModelPieChart> modelPieChart1 = new ArrayList<>();
		for(int i=0;i<data.length;i++) {
			modelPieChart1.add(new ModelPieChart("",data[i],color[i]));
		}
		pieChart1.setData(modelPieChart1);
	}
	public void setDataPieChart2(int []data) {
		ArrayList<ModelPieChart> modelPieChart2 = new ArrayList<>();
		for(int i=0;i<data.length;i++) {
			modelPieChart2.add(new ModelPieChart("",data[i],color[i]));
		}
		pieChart2.setData(modelPieChart2);
	}

	
}
