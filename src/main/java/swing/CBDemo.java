package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CBDemo implements ItemListener{
    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;
    CBDemo() {
        JFrame jfrm = new JFrame("Демонстрація прапорців");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(300, 150);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");

        jcbAlpha = new JCheckBox("Альфа");
        jcbBeta = new JCheckBox("Бета");
        jcbGamma = new JCheckBox("Гамма");

        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);

        jfrm.add(jcbAlpha);
        jfrm.add(jcbBeta);
        jfrm.add(jcbGamma);
        jfrm.add(jlabChanged);
        jfrm.add(jlabSelected);

        jfrm.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        String str = "";
        JCheckBox cb = (JCheckBox) ie.getItem();
        if (cb.isSelected())
            jlabChanged.setText(cb.getText() + " був обраний.");
        else
            jlabChanged.setText(cb.getText() + " був скинутий.");

        if (jcbAlpha.isSelected()){
            str += "Альфа ";
        }
        if (jcbBeta.isSelected()){
            str += "Бета ";
        }
        if (jcbGamma.isSelected()){
            str += "Гамма ";
        }
        jlabSelected.setText("Вибрані прапорці: " + str);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CBDemo();
            }
        });
    }
}
