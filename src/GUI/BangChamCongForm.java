package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 *
 * @author Jhin
 */
@SuppressWarnings("FieldMayBeFinal")
public class BangChamCongForm extends JPanel {

    private BangChamCongForm1 form1;
    private BangChamCongForm2_1 form2;
    private BangChamCongForm3 form3;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BangChamCongForm() {
        this.form1 = new BangChamCongForm1();
        this.form2 = new BangChamCongForm2_1();
        this.form3 = new BangChamCongForm3();
        this.init();
    }

    private void init() {
        this.setLayout(new CardLayout());

        this.add(form1);
        this.add(form2);
        this.add(form3);

        this.show(0);
    }

    public void show(int x) {
        switch (x) {
            case 0 -> 
            {
                this.form1.setVisible(true);
                this.form2.setVisible(false);
                this.form3.setVisible(false);
            }
            case 1 -> {
                this.form1.setVisible(false);
                this.form2.setVisible(true);
                this.form3.setVisible(false);
            }
            default -> {
                this.form1.setVisible(false);
                this.form2.setVisible(false);
                this.form3.setVisible(true);
            }
        }
    }

    public BangChamCongForm1 getForm1() {
        return form1;
    }

    public BangChamCongForm2_1 getForm2() {
        return form2;
    }

    public BangChamCongForm3 getForm3() {
        return form3;
    }

}
