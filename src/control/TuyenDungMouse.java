package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import run.App;

public class TuyenDungMouse implements MouseListener{
	private App trangchinh;

	public TuyenDungMouse(App trangchinh) {
		this.trangchinh = trangchinh;
	}

	public App getTrangchinh() {
		return trangchinh;
	}

	public void setTrangchinh(App trangchinh) {
		this.trangchinh = trangchinh;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(trangchinh.getContent().getRecruitmentForm().getTuyenDungView().getTuyenDung_Find().getText().equals("Nhập thông tin tìm kiếm")) {
			trangchinh.getContent().getRecruitmentForm().getTuyenDungView().getTuyenDung_Find().setText(null);
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
