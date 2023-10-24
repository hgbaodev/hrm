package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import view.chart.ModelPieChart;
import view.chart.PieChart;
import view.chart.PieChart.PeiChartType;

public class departmentForm1 extends JPanel{
	private Color[] color = {Color.decode("#0984e3"),Color.decode("#4cd137"),Color.decode("#f1c40f"),Color.decode("#FF8000"),Color.decode("#e74c3c") };
	private String title;
	private JLabel lblTenPhongBan;
	private departmentColumnChart panelChart;
	private JPanel detailPositionPieChart;
	private JPanel detailAgePieChart;
	private JPanel detailGenderPieChart;
	private JComboBox< String > cbbPieChart;
	
	private PieChart pieChart;
	private DefaultTableModel  model;
	
	private myTable table;
	private String []str = new String[] {"STT","Phòng ban","Ngày thành lập","Trưởng phòng","Ngày nhận chức","Nhân viên","Lương trung bình"};
	private Object[][] departmentData;
	private ArrayList<Object[]> positionData;
	private int[] ageData;
	private int[] genderData;
	public departmentForm1() {
		init();
	}
	public void init() {
		this.setBackground(Color.white);
		this.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBounds(10,10,1045,320);
//		panelTop.setBackground(Color.decode("#bdc3c7"));
		panelTop.setBorder(new LineBorder(new Color(0,0,0,50),2));
		this.add(panelTop);
		panelTop.setLayout(null);
		
		lblTenPhongBan= new JLabel(title);
		lblTenPhongBan.setFont(new Font("Arial",1,19));
		lblTenPhongBan.setForeground(new Color(0,0,0,200));
		lblTenPhongBan.setBounds(15,5,400,30);
		panelTop.add(lblTenPhongBan);
		
		JLabel lbTenPhongBan2= new JLabel("Nhân sự trong năm ");
		lbTenPhongBan2.setFont(new Font("Arial",1,15));
		lbTenPhongBan2.setForeground(new Color(0,0,0,140));
		lbTenPhongBan2.setBounds(15,30,350,30);
		panelTop.add(lbTenPhongBan2);
		
		JPanel detailColumn1 =new JPanel();
		detailColumn1.setBounds(320,52,15,10);
		detailColumn1.setBackground(color[0]);
		panelTop.add(detailColumn1);
		
		JLabel detailLabel1 =new JLabel("Nhân viên");
		detailLabel1.setFont(new Font("Arial",0,14));
		detailLabel1.setBounds(240,46,100,20);
		panelTop.add(detailLabel1);
		
		JPanel detailColumn2 =new JPanel();
		detailColumn2.setBounds(420,52,15,10);
		detailColumn2.setBackground(color[1]);
		panelTop.add(detailColumn2);
		
		JLabel detailLabel2 =new JLabel("Lương");
		detailLabel2.setFont(new Font("Arial",0,14));
		detailLabel2.setBounds(360,46,100,20);
		panelTop.add(detailLabel2);
		
		panelChart = new departmentColumnChart() ;
		panelChart.setOpaque(false);
		panelChart.setBounds(50,90,400,190);
		panelTop.add(panelChart);
		
		// init line
		for(int i=0;i<6;i++) {
			JPanel line = new JPanel();
			line.setBounds(50,100+i*30,400,1);
			line.setBackground(new Color(0,0,0,90));
			panelTop.add(line);
			
		}
		for(int i=0;i<6;i++) {
			JLabel lb2 = new JLabel(10+i*10+"");
			lb2.setFont(new Font("Arial",Font.PLAIN,12));
			lb2.setBounds(13,240-i*30,100,20);
			panelTop.add(lb2);
		}
		 // luong
		for(int i=0;i<6;i++) {
			JLabel lb2 = new JLabel(5+i*5+"");
			lb2.setFont(new Font("Arial",Font.PLAIN,12));
			lb2.setBounds(460,240-i*30,100,20);
			panelTop.add(lb2);
		}
		
		JLabel lb1 = new JLabel("0");
		lb1.setFont(new Font("Arial",Font.PLAIN,12));
		lb1.setBounds(26,270,100,20);
		panelTop.add(lb1);
		JLabel lb11 = new JLabel("0");
		lb11.setFont(new Font("Arial",Font.PLAIN,12));
		lb11.setBounds(463,270,100,20);
		panelTop.add(lb11);
		// line
		JPanel sprh = new JPanel();
		sprh.setBounds(50,280,400,1);
		sprh.setBackground(new Color(0,0,0,220));
		panelTop.add(sprh);
		
		for(int i=0;i<4;i++) {
			JLabel lb10 = new JLabel(LocalDate.now().getYear()-3+i+"");
			lb10.setFont(new Font("Arial",Font.PLAIN,12));
			lb10.setBounds(85+i*100,285,100,20);
			panelTop.add(lb10);
		}
		
		
		
		
		
		
		
		
		
		
		JLabel lbTenPhongBan3= new JLabel("Thống kê chung ");
		lbTenPhongBan3.setFont(new Font("Arial",1,15));
		lbTenPhongBan3.setForeground(new Color(0,0,0,140));
		lbTenPhongBan3.setBounds(550,30,350,30);
		panelTop.add(lbTenPhongBan3);
		
		
		
		cbbPieChart = new myCombobox<>();
		cbbPieChart.setModel(new DefaultComboBoxModel<>(new String[] {"Chức vụ","Độ tuổi","Giới tính"}));
		cbbPieChart.setFont(new Font("sansserif",1,13));
		cbbPieChart.setForeground(new Color(0,0,0,200));
		cbbPieChart.setBounds(700,33,140,25);
		panelTop.add(cbbPieChart);
		((myCombobox<String>)cbbPieChart).showArrow();
		
		
		
		pieChart = new PieChart();
		pieChart.setChartType(PeiChartType.DONUT_CHART);
		pieChart.setBounds(790,70,210,210);
		panelTop.add(pieChart);
		
		JPanel detailPc = new JPanel();
		// 16 - 25 25-40 40 - 55 55- 65
		detailPc.setBounds(550,90,200,200);
		panelTop.add(detailPc);
		detailPc.setLayout(new CardLayout());
		detailPositionPieChart = new JPanel();
		detailPc.add(detailPositionPieChart);
		detailPositionPieChart.setLayout(null);
//		detailPc1.setBackground(Color.red);
		
		


		
		
		
		detailAgePieChart = new JPanel();
		detailPc.add(detailAgePieChart);
		detailAgePieChart.setLayout(null);

		JPanel a11 = new JPanel();
		a11.setBackground(Color.decode("#0984e3"));
		a11.setBounds(20,30,18,12);
		detailAgePieChart.add(a11);
		JLabel l11 = new JLabel("16 - 25");
		l11.setFont(new Font("sansserif",0,14));
		l11.setBounds(60,25,100,18);
		detailAgePieChart.add(l11);
		JPanel a21 = new JPanel();
		a21.setBackground(Color.decode("#4cd137"));
		a21.setBounds(20,60,18,12);
		detailAgePieChart.add(a21);
		JLabel l21 = new JLabel("26 - 40");
		l21.setFont(new Font("sansserif",0,14));
		l21.setBounds(60,55,140,18);
		detailAgePieChart.add(l21);
		JPanel a31 = new JPanel();
		a31.setBackground(Color.decode("#f1c40f"));
		a31.setBounds(20,90,18,12);
		detailAgePieChart.add(a31);
		JLabel l31 = new JLabel("41 - 55");
		l31.setFont(new Font("sansserif",0,14));
		l31.setBounds(60,85,140,18);
		detailAgePieChart.add(l31);
		JPanel a41 = new JPanel();
		a41.setBackground(Color.decode("#FF8000"));
		a41.setBounds(20,120,18,12);
		detailAgePieChart.add(a41);
		JLabel l41 = new JLabel("56 - 65");
		l41.setFont(new Font("sansserif",0,14));
		l41.setBounds(60,115,100,18);
		detailAgePieChart.add(l41);
		
		
		detailGenderPieChart = new JPanel();
		detailPc.add(detailGenderPieChart);
		detailGenderPieChart.setLayout(null);

		JPanel a111 = new JPanel();
		a111.setBackground(Color.decode("#0984e3"));
		a111.setBounds(20,30,18,12);
		detailGenderPieChart.add(a111);
		JLabel l111 = new JLabel("Nam");
		l111.setFont(new Font("sansserif",0,14));
		l111.setBounds(60,25,100,18);
		detailGenderPieChart.add(l111);
		JPanel a211 = new JPanel();
		a211.setBackground(Color.decode("#4cd137"));
		a211.setBounds(20,60,18,12);
		detailGenderPieChart.add(a211);
		JLabel l211 = new JLabel("Nữ");
		l211.setFont(new Font("sansserif",0,14));
		l211.setBounds(60,55,140,18);
		detailGenderPieChart.add(l211);
	
		
		
		showDetailPieChart(0);
		
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBackground(Color.white);
		jsp.setBounds(10,340,1045,302);
		jsp.setVerticalScrollBar(new myScrollBar());
		table = new myTable();
		table.setBackground(Color.white);
		jsp.setViewportView(table);
		
		jsp.setBorder(new EmptyBorder(0,0,0,0));
		this.add(jsp);
		this.setBackground(Color.white);
		cbbPieChart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbbPieChart.setFocusable(false);
				int temp = cbbPieChart.getSelectedIndex();
				if(temp==0) {
					showDetailPieChart(0);
					renderData(positionData);
				}else if(temp==1) {
					showDetailPieChart(1);
					renderData(ageData);
				}else {
					showDetailPieChart(2);
					renderData(genderData);
				}
				repaint();
			}
		});
	}
	public void renderData(ArrayList<Object[]> data) {
		ArrayList<ModelPieChart> arr = new ArrayList<>();
		for(int i=0;i<data.size();i++) {
			ModelPieChart mpc1 = new ModelPieChart("a", (int)data.get(i)[1], color[i]);
			arr.add(mpc1);
		}
		pieChart.setData(arr);
	}
	public void renderData(int[] data) {
		ArrayList<ModelPieChart> arr = new ArrayList<>();
		for(int i=0;i<data.length;i++) {
			ModelPieChart mpc1 = new ModelPieChart("a", data[i], color[i]);
			arr.add(mpc1);
		}
		pieChart.setData(arr);
	}
	public void setPositionData(ArrayList<Object[]> data) {
		this.positionData = data;
	}
	public void setAgeData(int[] data) {
		this.ageData = data;
	}
	public void setGenderData(int[] data) {
		this.genderData = data;
	}
	public void setDepartmentData(Object[][] data) {
		departmentData  = data;
		renderDepartmentData();
	}
	public void renderDepartmentData() {
		model = new DefaultTableModel(departmentData,str) {
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
		table.getColumnModel().getColumn(0).setPreferredWidth(80);  // stt
		table.getColumnModel().getColumn(1).setPreferredWidth(240);  // stt
		table.getColumnModel().getColumn(2).setPreferredWidth(150);  // stt
		table.getColumnModel().getColumn(3).setPreferredWidth(190);  // stt
		table.getColumnModel().getColumn(4).setPreferredWidth(144);  // stt
		table.getColumnModel().getColumn(5).setPreferredWidth(120);  // stt
		table.getColumnModel().getColumn(6).setPreferredWidth(115);  // stt
	}
	public departmentColumnChart getDepartmentColumnChart() {
		return this.panelChart;
	}
	public myTable getTable() {
		return this.table;
	}
	public void setTitle(String title) {
		this.title = title;
		lblTenPhongBan.setText(title);
	}
	public void showDetailPieChart(int index) {
		if(index==0) {
			detailPositionPieChart.setVisible(true);
			detailAgePieChart.setVisible(false);
			detailGenderPieChart.setVisible(false);
		}else if(index==1) {
			detailPositionPieChart.setVisible(false);
			detailAgePieChart.setVisible(true);
			detailGenderPieChart.setVisible(false);
		}else {
			detailPositionPieChart.setVisible(false);
			detailAgePieChart.setVisible(false);
			detailGenderPieChart.setVisible(true);
		}
	}
	public JComboBox<String> getCbbPieChart(){
		return this.cbbPieChart;
	}
	
	public void renderPostionNamePieChart() {
		detailPositionPieChart.removeAll();
		for(int i=0;i<positionData.size();i++) {
			JPanel a1 = new JPanel();
			a1.setBackground(color[i]);
			a1.setBounds(20,20+i*30,18,12);
			detailPositionPieChart.add(a1);
			JLabel l1 = new JLabel((String)positionData.get(i)[0]);
			l1.setFont(new Font("sansserif",0,13));
			l1.setBounds(60,16+i*30,200,18);
			detailPositionPieChart.add(l1);
		}
	}
	
}
