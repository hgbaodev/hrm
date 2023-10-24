package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EmployeeForm extends JPanel{
	private employeeForm1 frame1;
	private employeeForm2 frame2;
	private employeeForm3 frame3;
	public EmployeeForm() {
		
		init();
	}
	public void init() {
		this.setLayout(new CardLayout());
		frame1 = new employeeForm1();
		this.add(frame1);
		
		
		
		frame2 = new employeeForm2();
		this.add(frame2);
		
		frame3 = new employeeForm3();
		this.add(frame3);
		
		showFrame(0);
		
	}
	public void showFrame(int index) {
		if(index==0) {
			frame1.setVisible(true);
			frame2.setVisible(false);
			frame3.setVisible(false);
		}else if(index==1){
			frame1.setVisible(false);
			frame2.setVisible(true);
			frame3.setVisible(false);
		}else {
			frame1.setVisible(false);
			frame2.setVisible(false);
			frame3.setVisible(true);
		}
	}
	
	
	
	
	public employeeForm1 getEmployeeForm1() {
		return this.frame1;
	}
	public employeeForm2 getEmployeeForm2() {
		return this.frame2;
	}
	public employeeForm3 getEmployeeForm3() {
		return this.frame3;
	}
}
