package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TFDemo implements ActionListener {
    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;
    TFDemo() {
        JFrame jfrm = new JFrame("Використання текстового поля");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");
        JButton jbtnRev = new JButton("Звернути");
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jlabPrompt = new JLabel("Введіть текст: ") ;
        jlabContents = new JLabel("") ;
        jfrm.add(jlabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);

        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Звернути")){
            String orgStr = jtf.getText();
            String resStr = "";
            for (int i = orgStr.length()-1; i >= 0; i--) {
                resStr += orgStr.charAt(i);
                jtf.setText(resStr);
            }
        } else {
            jlabContents.setText("Ви натиснули ENTER. Текст: " + jtf.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TFDemo();
            }
        });
    }
}
