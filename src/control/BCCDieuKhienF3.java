package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import run.App;

/**
 *
 * @author Jhin
 */
public class BCCDieuKhienF3 implements ActionListener {

    private App app;

    public BCCDieuKhienF3(App app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton obj = (JButton) e.getSource();
        JButton[] edit = this.app.getContent().getBangChamCongForm().getForm3().getInfBtn();
        JButton[] save = this.app.getContent().getBangChamCongForm().getForm3().getSaveBtn();

        if (obj == edit[0]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfEnable(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[0]);
        } else if (obj == edit[1]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfEnable(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[1]);
        } else if (obj == edit[2]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfEnable(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[2]);
        } else if (obj == edit[3]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfEnable(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[3]);
        } else if (obj == edit[4]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfEnable(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[4]);
        } else if (obj == edit[5]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfEnable(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[5]);
        }

        if (obj == save[0]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfSave(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[0]);
        } else if (obj == save[1]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfSave(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[1]);
        } else if (obj == save[2]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfSave(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[2]);
            System.out.println("(BCCDieuKhienF3)index2");
        } else if (obj == save[3]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfSave(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[3]);
            System.out.println("(BCCDieuKhienF3)index3");
        } else if (obj == save[4]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfSave(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[4]);
            System.out.println("(BCCDieuKhienF3)index4");
        } else if (obj == save[5]) {
            this.app.getContent().getBangChamCongForm().getForm3().tfSave(this.app.getContent().getBangChamCongForm().getForm3().getInfTf()[5]);
            System.out.println("(BCCDieuKhienF3)index5");
        }
    }

}
