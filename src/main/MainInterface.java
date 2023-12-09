package main;

import javax.swing.*;
import java.awt.*;

public class MainInterface extends JFrame {
    public static MainInterface mainInterface=new MainInterface();
    private JPanel contentPane;

    public MainInterface(){
        setContentPane(contentPane);
        mainInterface=this;
        setSize(
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*2/3),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*2/3)
        );
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        mainInterface.setVisible(
                true
        );
    }
}
