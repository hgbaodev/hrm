package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

import control.Login_Key;
import control.Login_OTP_XacThuc_mouse;
import control.Login_OTP_close_mouse;
import control.Login_QMK_XacThuc_Mouse;
import control.Login_QMK_back_Mouse;
import control.Login_login_Mouse;
import control.diChuyenChuongTrinh;
import control.diChuyenOptionPanel;
import control.xacNhanDoiMatKhau;
import run.App;

public class login extends JFrame{
	private JLabel lb1;
	private static String[] text = {"HRM","the best HR management software"};
	private Timer timer1;
	

	private Login_OTP_Panel otpForm;
	private Login_QMK_Panel quenMatKhauForm;
	private Login_login_Panel loginForm;
	private Login_DMK_Panel doimatkhauForm;
	
	


	public Login_QMK_Panel getQmk() {
		return quenMatKhauForm;
	}

	public void setQmk(Login_QMK_Panel quenMatKhauForm) {
		this.quenMatKhauForm = quenMatKhauForm;
	}

	public Login_login_Panel getLlp() {
		return loginForm;
	}

	public void setLlp(Login_login_Panel llp) {
		this.loginForm = llp;
	}

	public Login_OTP_Panel getLop() {
		return otpForm;
	}

	public void setLop(Login_OTP_Panel lop) {
		this.otpForm = lop;
	}

	public static void setText(String[] text) {
    	login.text = text;
    	
	}
    
	public JLabel getLb1() {
		return lb1;
	}

	public void setLb1(JLabel lb1) {
		this.lb1 = lb1;
	}

	public login() {
		quenMatKhauForm= new Login_QMK_Panel();
		otpForm= new Login_OTP_Panel();
		loginForm= new Login_login_Panel();
		doimatkhauForm = new Login_DMK_Panel();
		init();
	}
	public Timer getTimer() {
		return this.timer1;
	}
	public void init() {
		
		this.setTitle("Login");
		this.setSize(1000,550);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBounds(2,2,1096,596);
		contentPane.setLayout(null);
		this.add(contentPane);
		
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(600,0,400,550);
		contentPane.add(panelRight);
		panelRight.setLayout(new CardLayout());
        
		panelRight.add(loginForm);
		panelRight.add(quenMatKhauForm);
		panelRight.add(otpForm);
		panelRight.add(doimatkhauForm);

		
		//BACKGROUND
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(0,0,600,550);
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.decode("#00a8ff"));
		contentPane.add(panelLogo);
		
        JLabel wellCome= new JLabel("WELCOME");
        wellCome.setForeground(Color.white);
        wellCome.setBackground(Color.BLUE);
        wellCome.setFont(new Font("Arial",1,50));
        wellCome.setBounds(40,105,300,70);
        panelLogo.add(wellCome);

		JPanel panel_logo_1= new JPanel();
		panel_logo_1.setLayout(null);
		panel_logo_1.setBounds(40,175,550,50);
        panelLogo.add(panel_logo_1);
        
        JLabel label_1 = new JLabel("To");
        label_1.setForeground(Color.white);
        label_1.setFont(new Font("Arial",0,30));
        label_1.setBounds(0, 0, 50, 50);
        label_1.setOpaque(true);
        label_1.setBackground(Color.decode("#00a8ff"));
        panel_logo_1.add(label_1);

        JLabel label_2 = new JLabel();
        label_2.setFont(new Font("Arial",0,30));
        label_2.setForeground(Color.white);
        label_2.setOpaque(true);
        label_2.setBackground(Color.decode("#00a8ff"));
        label_2.setBounds(50, 0, 550, 50);
        panel_logo_1.add(label_2);
        label_2.setBorder(null);
//        
       timer1 = new Timer(100, new ActionListener() {
            int index = 0;
            int i=0;
            boolean isDeleting = false;
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isDeleting) {
                	label_2.setText(text[i].substring(0, index));
                    index++;
                    if (index > text[i].length()) {
                    	isDeleting = true;
                        index = text[i].length();

                    }
                } else {
                	if(index == text[i].length()) {
                		try {
        					Thread.sleep(1000);
        				} catch (InterruptedException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
                	}
                	label_2.setText(text[i].substring(0, index));
                    index--;
                    if (index < 0) {
                        isDeleting = false;
                        index = 0;
                        if(i==1) 
                        	i--;
                        else 
							i++;
                    }
                }
            }
        });
        timer1.start();
//	

		//FORGOT
		
	
		
		
 
		suKienDangNhap();
		showView(0);
	}
	public void showView(int index) {
		if(index==0) {
			
			loginForm.setVisible(true);
			quenMatKhauForm.setVisible(false);
			otpForm.setVisible(false);
			doimatkhauForm.setVisible(false);
		}else if(index==1) {
			loginForm.setVisible(false);
			quenMatKhauForm.setVisible(true);
			otpForm.setVisible(false);
			doimatkhauForm.setVisible(false);
		}else if(index==2){
			loginForm.setVisible(false);
			quenMatKhauForm.setVisible(false);
			otpForm.setVisible(true);
			doimatkhauForm.setVisible(false);
		}else {
			loginForm.setVisible(false);
			quenMatKhauForm.setVisible(false);
			otpForm.setVisible(false);
			doimatkhauForm.setVisible(true);
		}
	}
	
	public JButton getBtnDangNhap() {
		return this.getLlp().getBtn();
	}
	public String[] getData() {
		String a = this.getLlp().getUsername().getText().trim();
		String b = this.getLlp().getPass().getText().trim();
		return new String[] {a,b};
	}
	public Login_DMK_Panel getPanelDoiMatKhau() {
		return this.doimatkhauForm;
	}
	public void suKienDangNhap() {
		diChuyenChuongTrinh dc = new diChuyenChuongTrinh(this);
		this.addMouseMotionListener(dc);

//		Login_login_Mouse lq= new Login_login_Mouse(this);
//		getLlp().getLb1().addMouseListener(lq);


		Login_QMK_back_Mouse lqpm= new Login_QMK_back_Mouse(this);
		getQmk().getBack().addMouseListener(lqpm);
		
		
		 Login_QMK_XacThuc_Mouse lqxm= new Login_QMK_XacThuc_Mouse(this);
		getQmk().getLb2().addMouseListener(lqxm);
		
		
		Login_Key lk= new Login_Key(this);
		this.addKeyListener(lk);
		this.setFocusable(true);
		
		Login_OTP_close_mouse locm= new Login_OTP_close_mouse(this);
		otpForm.getBtnClose().addMouseListener(locm);
		
		Login_OTP_XacThuc_mouse loxm= new Login_OTP_XacThuc_mouse(this);
		otpForm.getLb2().addMouseListener(loxm);
		
		doimatkhauForm.getLb2().addMouseListener(new xacNhanDoiMatKhau(this));
	}
	
}
