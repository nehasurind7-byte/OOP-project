package CS_playground;
import java.awt.Dimension;

import javax.swing.*;
public class swingpracticce {
    public static void main(String args[])
    {
        JFrame frame=new JFrame("My Window");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField doctor=new JTextField();
        doctor.setPreferredSize(new Dimension(200,400));
        doctor.getText();
        frame.setVisible(true);
    }
}
