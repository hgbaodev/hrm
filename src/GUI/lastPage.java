package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class lastPage extends JPanel{
	private myImageAvatar imgavatar;
	public lastPage() {
		init();
	}
	public void init() {
		this.setLayout(null);
		this.setBackground(new Color(240,240,240));
		JLabel lblusersetting = new JLabel("USERSETTING");
		lblusersetting.setFont(new Font("Arial", Font.PLAIN, 18));
		this.add(lblusersetting);
		
		imgavatar = new myImageAvatar();
		imgavatar.setIcon(new ImageIcon(getClass().getResource("/assets/img/avatar.png")));
		imgavatar.setBounds(100,40,150,150);
		imgavatar.setBorderSize(2);
		this.add(imgavatar);
		URL rl = getClass().getResource("/assets/img/avatar.png");
		System.out.println(rl);
		
		JButton btnedit = new JButton("Đổi ảnh");
		btnedit.setBounds(122,210,100,30);
		this.add(btnedit);
		
		btnedit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jf = new JFileChooser();
				jf.setFileFilter(new FileFilter() {
					public String getDescription() {
						// TODO Auto-generated method stub
						return "image file";
					}
					public boolean accept(File f) {
						// TODO Auto-generated method stub
						String name = f.getName();
						return f.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
					}
				});
				int flag = jf.showOpenDialog(null);
				if(flag==jf.APPROVE_OPTION) {
					File file = jf.getSelectedFile();
					URL temp = getClass().getResource("/assets/img/avatar.png");
					try {
						Files.copy(file.toPath(), new File(temp.toString().substring(6)).toPath(),StandardCopyOption.REPLACE_EXISTING);
						
//						changeAvatar(file.getAbsolutePath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		
	}
}
