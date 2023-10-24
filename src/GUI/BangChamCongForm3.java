 package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import view.button.Button;

/**
 *
 * @author Jhin
 */
@SuppressWarnings("FieldMayBeFinal")
public class BangChamCongForm3 extends JPanel {

    private JButton back;
    private JPanel backBar;

    private JLabel lb;
	private Color color= Color.decode("#FF6A6A");
    private JLabel lbMaBCC, lbMaNV;
    private JTextField tfMaBCC, tfMaNV;
    private JLabel[] infLb;
    private JTextField[] infTf;
    private JButton[] infBtn, saveBtn;
    private JButton save;
	private ArrayList<JLabel> arr_1;
	private ArrayList<JLabel> arr_lb;

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color color_Nghi = Color.decode("#FF6A6A");
	public Color color_TangCa = Color.decode("#4cd137");
	public Color color_Tre = Color.orange;
    private JPanel form;

    private final String[] label;
    private String[] data;

    private Font font, fontB;

    private ActionListener ctl;

    public BangChamCongForm3() {
        this.back = new JButton("Quay lại");
        this.backBar = new JPanel();

        

        this.lbMaBCC = new JLabel("Mã bảng chấm công");
        this.lbMaNV = new JLabel("Mã nhân viên");
        this.tfMaBCC = new JTextField();
        this.tfMaNV = new JTextField();
        this.infLb = new JLabel[6];
        this.infTf = new JTextField[6];
        this.infBtn = new JButton[6];
        this.saveBtn = new JButton[6];
       

        this.form = new JPanel();

        this.label = new String[]{"Tháng chấm công", "Năm chấm công", "Số ngày làm việc", "Số ngày nghỉ", "Số ngày trễ", "Số giờ làm thêm"};
        this.data = new String[8];

        this.font = new Font("Arial", 0, 14);
        this.fontB = new Font("Arial", 1, 14);
        this.init();
    }

    private void init() {
    	arr_1= new ArrayList<>();
    	arr_lb= new ArrayList<>();

    	// Quay lại
        this.back.setIcon(new ImageIcon(getClass().getResource("/assets/img/al.png")));
        this.back.setBounds(5, 5, 120, 30);
        this.back.setBorderPainted(false);
        this.back.setFocusPainted(false);
        this.back.setFont(new Font("arial", 0, 14));
        this.back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.backBar.setLayout(null);
        this.backBar.setBounds(10, 10, 1080, 40);
        this.backBar.setBackground(Color.white);
        this.backBar.add(back);

        this.add(backBar);

        // Label
        this.lb = new JLabel("CHỈNH SỬA BẢNG CHẤM CÔNG");
        lb.setBounds(420, 30, 300, 50);
        lb.setFont(new Font("Arial", Font.BOLD, 15));
        lb.setForeground(new Color(0,0,0,160));
        this.form.add(lb);

        //INFO nhân viên
        int x_0=240;
        for(int i=0;i<3;i++) {
        	JLabel a= new JLabel();
        	if(i==0) {
            	a.setBounds(x_0,105,130,40);
            	
        		x_0+=150;	
        	}
        	else {
            	a.setBounds(x_0,105,200,40);
        		x_0+=210;	
        	}
        	a.setFont(new Font("Arial",1,13));
        	a.setForeground(new Color(0,0,0,160));
        	form.add(a);
        	arr_lb.add(a);
        }
        
        
        //PANEL chấm công
     	JPanel panel= new JPanel();
    	panel.setBounds(240,150,600,400);
    	panel.setLayout(null);
    	panel.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
    	form.add(panel);
    	
    	
    	JPanel panel_1= new JPanel();
    	panel_1.setBounds(0,0,600,280);
    	panel_1.setLayout(null);
    	panel_1.setBorder(new LineBorder(Color.decode("#dfe4ea"),3));
    	panel.add(panel_1);
    	GridLayout layout= new GridLayout(4, 8);  
    	layout.setHgap(2);
    	layout.setVgap(2);
    	panel_1.setLayout(layout);
    	for(int i=1; i<32; i++) {
    		JLabel a= new JLabel();
    		a.setOpaque(true);
    		a.setFont(new Font("Arial",1,13));
    		a.setBackground(Color.white);
    		a.setHorizontalAlignment(JLabel.CENTER);
    		a.setLayout(null);
    		
    		///
    		JLabel day= new JLabel(i+"");
    		day.setBounds(55,3,15,15);
    		day.setOpaque(true);
    		day.setBackground(new Color(0,0,0,0));
    		a.add(day);

    		
    		JLabel chiTiet= new JLabel();
    		chiTiet.setHorizontalAlignment(JLabel.CENTER);
    		chiTiet.setBounds(0,40,75,30);
    		chiTiet.setOpaque(true);
    		chiTiet.setBackground(new Color(0,0,0,0));
    		a.add(chiTiet);
    		
    		arr_1.add(a);
    		panel_1.add(a);
    	}

    	JPanel thongTinChamCong= new JPanel();
    	thongTinChamCong.setBounds(110,300,450,40);
    	panel.add(thongTinChamCong);
    	thongTinChamCong.setLayout(null);
    	ArrayList<JLabel> arr= new ArrayList<>();
    	
    	
    	int x=0;
    	String[] ab= {"Nghỉ","Đi Trễ","Tăng Ca","Xóa"};
    	for(int i=0; i<4;i++) {
    		JLabel b= new JLabel(ab[i]);
       		b.setBackground(Color.white);
    		b.setHorizontalAlignment(JLabel.CENTER);
    		if(i==0) {
    			b.setBackground(color_Nghi);
    		}
    		b.setBounds(x,0,80,40);
    		x+=90;
       		b.setOpaque(true);
       		arr.add(b);
    		thongTinChamCong.add(b);
    	}
    	JPanel tangCa= new JPanel();
    	tangCa.setLayout(null);
    	tangCa.setBounds(100, 350, 400, 30);
    	panel.add(tangCa);
    	tangCa.setVisible(false);
    	
		JLabel title_tangCa= new JLabel("Giờ tăng ca: ");
		title_tangCa.setBounds(0,0,150,30);
		tangCa.add(title_tangCa);
    	
    	int x_1=100;
    	ButtonGroup g= new ButtonGroup();
    	String[] abc= {"1 Giờ","2 Giờ","3 Giờ","4 Giờ"};
    	ArrayList<JRadioButton> arr_radio= new ArrayList<>();
    	for(int i=0;i<4;i++) {
        	JRadioButton r1= new JRadioButton(abc[i]);
    		if(i==0) {
    			r1.setSelected(true);
    		}
        	r1.setBounds(x_1,0,70,30);
        	r1.setFont(new Font("Arial",0,13));
        	g.add(r1);
        	arr_radio.add(r1);
        	x_1+=70;
        	tangCa.add(r1);
    	} 
    	
    	for(JLabel i: arr) {
    		i.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for(JLabel i: arr) {
						i.setBackground(Color.white);
					}
					// TODO Auto-generated method stub
					if(i.getText().equals("Nghỉ")) {
						i.setBackground(color_Nghi);
						setColor(color_Nghi);
						tangCa.setVisible(false);

					}
					if(i.getText().equals("Nghỉ Phép")) {
						i.setBackground(Color.magenta);
						setColor(Color.magenta);
						tangCa.setVisible(false);

					}
					if(i.getText().equals("Đi Trễ")) {
						i.setBackground(color_Tre);
						setColor(color_Tre);
						tangCa.setVisible(false);


					}
					if(i.getText().equals("Tăng Ca")) {
						i.setBackground(color_TangCa);
						setColor(color_TangCa);
						tangCa.setVisible(true);
					}
					if(i.getText().equals("Xóa")) {
						i.setBackground(Color.white);
						setColor(Color.white);
						tangCa.setVisible(false);

						
					}
				}
			});
    	}
    	for(JLabel i: arr_1) {
    		i.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					i.setBackground(getColor());
					System.out.println("Dô chưa");
					if(i.getBackground().equals(color_Nghi)) {
						i.setText("NGHỈ");
						
					}
					System.out.println("chưa");

					if(i.getBackground() == Color.magenta) {
						i.setText("PHÉP");
					}
					if(i.getBackground().equals(color_Tre)) {
						i.setText("TRỄ");
					}
					if(i.getBackground().equals(color_TangCa)) {
						for(JRadioButton j: arr_radio) {
							if(j.isSelected()==true) {
								i.setHorizontalAlignment(JLabel.CENTER);
								i.setText("<html> TĂNG CA <br> "+ j.getText()+ " </html>");
								break;
							}
							
						}
					}
					if(i.getBackground() == Color.white) {
						i.setText("");
					}
				}
			});
    	}
    	

        // Save button
    	 this.save = new Button();
    	save.setText("Lưu");
        this.save.setIcon(new ImageIcon(getClass().getResource("/assets/img/department_img/department_add_save.png")));
        this.save.setBounds(895, 600, 90, 35);
        this.save.setFont(new Font("Arial", 1, 13));
        this.save.setForeground(Color.white);
        this.save.setBackground(Color.decode("#44bd32"));
        this.save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.save.setFocusable(false);
        this.form.add(save);

        // form
        this.form.setLayout(null);
        this.form.setBackground(Color.white);
        this.form.setBounds(10, 55, 1080, 650);

        this.setLayout(null);
        this.add(form);


        //        this.renderData();
    }
    
    public ArrayList<JLabel> getArr_1() {
		return arr_1;
	}

	public void setArr_1(ArrayList<JLabel> arr_1) {
		this.arr_1 = arr_1;
	}

	public ArrayList<JLabel> getArr_lb() {
		return arr_lb;
	}

	public void setArr_lb(ArrayList<JLabel> arr_lb) {
		this.arr_lb = arr_lb;
	}

	// Get, set
    public JButton getBack() {
        return back;
    }

    public JButton[] getInfBtn() {
        return infBtn;
    }

    public JTextField[] getInfTf() {
        return infTf;
    }

    public JButton[] getSaveBtn() {
        return saveBtn;
    }

    public JButton getSave() {
        return save;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public void tfEnable(JTextField infTf) {
        infTf.setEditable(true);
    }

    public void tfSave(JTextField infTf) {
        infTf.setEditable(false);
        // save
    }

    /* Something */
}
