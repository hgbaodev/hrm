package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import view.chart.ModelPieChart;
import view.chart.PieChart;

public class HomeForm extends JPanel{
	private homeForm1 home1;
	private homeForm2 home2;
	private homeForm3 home3;
	public HomeForm(){
		init();
	}
	public void init() {
		setLayout(null);
		// form thống kê biểu đồ cột
		home1 = new homeForm1();
		home1.setBounds(10,10,535,320);
		this.add(home1);
		// form thống kê biểu đồ tròn                  																		
		home2 = new homeForm2();
		home2.setBounds(555,10,535,320);
		this.add(home2);
		
		home3 = new homeForm3();
		home3.setBounds(10,340,1080,363);
		this.add(home3);
		
	}
	public homeForm2 getHomeForm2() {
		return this.home2;
	}
	public homeForm1 getHomeForm1() {
		return this.home1;
	}
	public homeForm3 getHomeForm3() {
		return this.home3;
	}
	
}

