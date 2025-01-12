package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
        JLabel jlab;
        ButtonDemo() {
            JFrame jfr = new JFrame("Приклад кнопки");
            jfr.setLayout(new FlowLayout());
            jfr.setSize(300,150);
            jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton jbtnUp = new JButton("Відпущена");
            JButton jbtnDown = new JButton("Натиснена");
            jbtnUp.addActionListener(this);
            jbtnDown.addActionListener(this);
            jfr.add(jbtnUp);
            jfr.add(jbtnDown);

            jlab = new JLabel("Натиснути кнопку");
            jfr.add(jlab);
            jfr.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Відпущена"))
            jlab.setText("Кнопка відпущена!");
        else
            jlab.setText("Кнопка натиснута!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
