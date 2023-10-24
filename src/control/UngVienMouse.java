package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import run.App;

public class UngVienMouse implements MouseListener{
	private App trangchinh;
	
	public UngVienMouse(App trangchinh) {
		this.trangchinh = trangchinh;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(trangchinh.getContent().getRecruitmentForm().getUngVienView().getUngVien_Find().getText().equals("Nhập thông tin tìm kiếm")) {
			trangchinh.getContent().getRecruitmentForm().getUngVienView().getUngVien_Find().setText(null);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
