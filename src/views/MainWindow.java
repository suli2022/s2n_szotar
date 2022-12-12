package views;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
    public JButton aboutButton;
    public MainWindow() {
        this.aboutButton = new JButton("Névjegy");

        this.add(this.aboutButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
    
}
