package OOP.OOP;

import javax.swing.*;
import java.awt.*;

public class HospitalGUI
{
    JFrame frame;

    HospitalGUI()
    {
        frame = new JFrame("Hospital Analysis System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("HOSPITAL ANALYSIS SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(title, gbc);

        JLabel label = new JLabel("Select Department:");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        panel.add(label, gbc);

        String[] departments =
        {
            "Orthopedics",
            "Neurology",
            "Gynecology"
        };

        JComboBox<String> departmentBox =
            new JComboBox<>(departments);

        departmentBox.setPreferredSize(
            new Dimension(200, 30)
        );

        gbc.gridx = 1;
        gbc.gridy = 1;

        panel.add(departmentBox, gbc);

        JButton openButton = new JButton("OPEN");

        openButton.setPreferredSize(
            new Dimension(100, 30)
        );
        openButton.addActionListener(e -> { String selectedDepartment=(String) departmentBox.getSelectedItem();
            if(selectedDepartment.equals("Orthopedics"))
            {
                showDepartment("Orthopedics");
            }
            else if(selectedDepartment.equals("Gynecology"))
            {
                showDepartment("Gynecology");
            }
            else
            {
                showDepartment("Neurology");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        panel.add(openButton, gbc);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    void showDepartment(String departmentName)
    {
         frame.getContentPane().removeAll();

         
         JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        JPanel titlePanel = new JPanel();

        JLabel label = new JLabel(departmentName + " Department");
        label.setFont(new Font("Arial", Font.BOLD, 22));

        titlePanel.add(label);

        mainPanel.add(titlePanel, BorderLayout.NORTH);


        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel fieldName=new JLabel("Enter Details Regarding Doctor Workload");
        gbc.gridx=0;
        gbc.gridy=0;
        panel1.add(fieldName,gbc);

        JLabel doctorNameLabel = new JLabel("Doctor Name:");

         gbc.gridx = 0;
         gbc.gridy = 1;

        panel1.add(doctorNameLabel, gbc);


        JTextField doctorName = new JTextField();
        doctorName.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 1;

        panel1.add(doctorName, gbc);



        JLabel doctoridLabel = new JLabel("Doctor ID:");

        gbc.gridx = 0;
        gbc.gridy = 2;

        panel1.add(doctoridLabel, gbc);


        JTextField doctorID = new JTextField();
        doctorID.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 2;

        panel1.add(doctorID, gbc);


        JLabel specializationLabel = new JLabel("Specialization:");

        gbc.gridx = 0;
        gbc.gridy = 3;

        panel1.add(specializationLabel, gbc);


        JTextField specializationField = new JTextField();
        specializationField.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 3;

        panel1.add(specializationField, gbc);

        JLabel dateLabel = new JLabel("Date:");

        gbc.gridx = 0;
        gbc.gridy = 4;

        panel1.add(dateLabel, gbc);


        JTextField date = new JTextField();
        date.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 4;

        panel1.add(date, gbc);



        JLabel startTimLabel = new JLabel("Slot Start Time:");

        gbc.gridx = 0;
        gbc.gridy = 5;

        panel1.add(startTimLabel, gbc);


        JTextField startTime = new JTextField();
        startTime.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 5;

        panel1.add(startTime, gbc);

        JLabel endTimLabel = new JLabel("Slot End Time:");

        gbc.gridx = 0;
        gbc.gridy = 6;

        panel1.add(endTimLabel, gbc);


        JTextField endTime = new JTextField();
        endTime.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 6;

        panel1.add(endTime, gbc);



        JLabel patientCountLabel =new JLabel("Patients attended in slot:");

        gbc.gridx = 0;
        gbc.gridy = 7;

        panel1.add(patientCountLabel, gbc);


        JTextField patientCount = new JTextField();
        patientCount.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 1;
        gbc.gridy = 7;

        panel1.add(patientCount, gbc);
        JButton nexButton=new JButton("NEXT");
        nexButton.addActionListener(e->{beds();});
        mainPanel.add(nexButton,BorderLayout.SOUTH);

        mainPanel.add(panel1, BorderLayout.CENTER);


        frame.add(mainPanel);

        


        frame.revalidate();
        frame.repaint();
    }
    void beds()
    {
        frame.getContentPane().removeAll();

        JPanel bedJPanel=new JPanel();
        JLabel bedJLabel=new JLabel("Enter Bed Details");
        bedJLabel.setFont(new Font("Arial", Font.BOLD, 22));


        JPanel bedDetailSPanel=new JPanel();
        bedDetailSPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,10,5,10);
        gbc.anchor=GridBagConstraints.CENTER;

        JLabel bedOccLabel=new JLabel("Enter number of beds occupied");
        gbc.gridx=0;
        gbc.gridy=0;
        bedDetailSPanel.add(bedOccLabel,gbc);


        bedJPanel.add(bedJLabel,BorderLayout.NORTH);
    
        frame.add(bedJPanel);

        


        frame.revalidate();
        frame.repaint();

    }
}