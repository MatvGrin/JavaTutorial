package swing;
import javax.swing.*;

public class SwingDemo {
    SwingDemo() {
        JFrame jfr = new JFrame("Легка програма Swing");
        jfr.setSize(400,200);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlab = new JLabel("Програмування задопоиогою интерфейса Swing");
        jfr.add(jlab);
        jfr.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo();
            }
        });

    }
}
