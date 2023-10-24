package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;




public class myScrollBar extends JScrollBar{
	 public myScrollBar() {
	        setUI(new myDesignScrollBar());
	        setPreferredSize(new Dimension(5, 0));     // thanh truot doc
	        setBackground(new Color(242, 242, 242));
	        setUnitIncrement(16);                     // tốc độ trượt của bảng
	    }
}
