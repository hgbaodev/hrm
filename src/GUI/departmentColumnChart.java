package GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class departmentColumnChart extends JPanel{
	private int[] eData;
	private int[] sData;
	private ArrayList<JPanel> listColumn;
	public departmentColumnChart() {
		eData = new int[] {0,0,0,0};
		sData = new int[] {0,0,0,0};
		init();
	}
	public void init() {
		this.setLayout(null);
		listColumn = new ArrayList<>();
		for(int i=0;i<4;i++) {
			JPanel cl1 = new JPanel();
			cl1.setBackground(Color.decode("#0984e3"));
			this.add(cl1);
			listColumn.add(cl1);
		}
		for(int i=0;i<4;i++) {
			JPanel cl2 = new JPanel();
			cl2.setBackground(Color.decode("#4cd137"));
			this.add(cl2);
			listColumn.add(cl2);
		}
	}
	public void setEmployeeData(int data[]) {
		this.eData = data;
	}
	public void setSalaryData(int data[]) {
		this.sData = data;
	}
	public void renderData() {
		for(int i=0;i<4;i++) {
			listColumn.get(i).setBounds(25+i*100,190-eData[i],20,eData[i]);
		}
		for(int i=0;i<4;i++) {
			listColumn.get(i+4).setBounds(55+i*100,190-sData[i],20,sData[i]);
		}
	}

}
