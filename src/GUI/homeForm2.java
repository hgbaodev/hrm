package GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.chart.ModelPieChart;
import view.chart.PieChart;

public class homeForm2 extends JPanel{
	private ArrayList<Object[]> dataPieChart;
	private JPanel panelDetail;
	private ArrayList<ModelPieChart> arr1;
	private PieChart pieChart1;
	private static Color[] colorList = {Color.decode("#0984e3"),Color.decode("#4cd137"), Color.decode("#f1c40f"),Color.decode("#FF8000"),Color.decode("#e74c3c") ,Color.decode("#9b59b6")};
	
	public homeForm2() {
		this.dataPieChart = new ArrayList<>();
		init();
	}
	public void init() {
		
		this.setBounds(555,10,520,320);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		JLabel titelLabel2 = new JLabel("Nhân viên phòng ban");
		titelLabel2.setForeground(new Color(0,0,0,140));
		titelLabel2.setFont(new Font("sansserif", 1, 16));
		titelLabel2.setBounds(15,15,200,24);
		this.add(titelLabel2);
		
		pieChart1 = new PieChart();
		pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart1.setBounds(280,60,220,220);
        this.add(pieChart1);
        panelDetail = new JPanel();
        panelDetail.setBounds(0,50,260,300);
        panelDetail.setLayout(null);
        panelDetail.setBackground(Color.white);
        this.add(panelDetail);
	}
	public void setData(ArrayList<Object[]> data) {
		this.dataPieChart = data;
		panelDetail.removeAll();
        for(int i=0;i<dataPieChart.size();i++) {
        	JPanel pn = new JPanel();
        	pn.setBackground(colorList[i]);
        	pn.setBounds(30,40+i*32,12,12);
        	panelDetail.add(pn);
        	JLabel lbpie1 = new JLabel((String)dataPieChart.get(i)[0]);
            lbpie1.setFont(new Font("sansserif",1,12));
            lbpie1.setForeground(new Color(0,0,0,200));
            lbpie1.setBounds(50,35+i*32,200,20);
            panelDetail.add(lbpie1);
        }
	}
	public void ani() {
		ModelPieChart md = new ModelPieChart("P1",0, Color.white);
		arr1 = new ArrayList<>();
		for(int i=0;i<dataPieChart.size();i++) {
			ModelPieChart md1 = new ModelPieChart("P2", 0, colorList[i]);
			arr1.add(md1);
		}
		arr1.add(md);	

		
		pieChart1.setData(arr1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				int sizeList = arr1.size()-1;
				int total = 0;
				for(int i=0;i<dataPieChart.size();i++) {
					total += (int)dataPieChart.get(i)[1];
				}
				for(int i = 0;i<dataPieChart.size();i++) {
					for(int j=1;j<=(int)dataPieChart.get(i)[1];j++) {
						arr1.get(i).setValues(j);
						total--;
						arr1.get(sizeList).setValues(total);
						repaint();
						try {
							Thread.sleep(4);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				pieChart1.delDate(md);
				repaint();
			}
		}).start();
		
	}
}
