
package OOP.OOP;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class HospitalGUI {

    JFrame frame;
    String selectedDepartment;

    // DATABASE CONNECTION
    Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String username = "root";
        String password = ""; // Enter your MySQL password if required

        return DriverManager.getConnection(url, username, password);
    }

    // FIRST SCREEN: SELECT DEPARTMENT
    HospitalGUI() {
        frame = new JFrame("Hospital Analysis System");
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);

        JLabel title = new JLabel("HOSPITAL ANALYSIS SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Select Department:"), gbc);

        String[] departments = {
                "Orthopedics",
                "Neurology",
                "Gynecology"
        };

        JComboBox<String> departmentBox =
                new JComboBox<>(departments);
        departmentBox.setPreferredSize(new Dimension(220, 30));

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(departmentBox, gbc);

        JButton openButton = new JButton("OPEN");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(openButton, gbc);

        openButton.addActionListener(e -> {
            selectedDepartment =
                    (String) departmentBox.getSelectedItem();
            showDepartment();
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // DOCTOR DETAILS SCREEN
    void showDepartment() {
        frame.getContentPane().removeAll();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel(
                selectedDepartment + " Department - Doctor Details",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 21));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField doctorName = new JTextField(18);
        JTextField doctorID = new JTextField(18);
        JTextField specialization = new JTextField(18);
        JTextField date = new JTextField(18);
        JTextField startTime = new JTextField(18);
        JTextField endTime = new JTextField(18);
        JTextField patientCount = new JTextField(18);

        addField(form, gbc, 0, "Doctor Name:", doctorName);
        addField(form, gbc, 1, "Doctor ID:", doctorID);
        addField(form, gbc, 2, "Specialization:", specialization);
        addField(form, gbc, 3, "Date (yyyy-MM-dd):", date);
        addField(form, gbc, 4, "Start Time (HH:mm):", startTime);
        addField(form, gbc, 5, "End Time (HH:mm):", endTime);
        addField(form, gbc, 6, "Patients Attended:", patientCount);

        mainPanel.add(form, BorderLayout.CENTER);

        JButton backButton = new JButton("BACK");
        JButton nextButton = new JButton("NEXT");

        JPanel buttons = new JPanel();
        buttons.add(backButton);
        buttons.add(nextButton);
        mainPanel.add(buttons, BorderLayout.SOUTH);

        backButton.addActionListener(e -> showHome());

        nextButton.addActionListener(e -> {
            try {
                String name = doctorName.getText().trim();
                String id = doctorID.getText().trim();
                String spec = specialization.getText().trim();

                if (name.isEmpty() || id.isEmpty() ||
                        spec.isEmpty() || date.getText().trim().isEmpty() ||
                        startTime.getText().trim().isEmpty() ||
                        endTime.getText().trim().isEmpty() ||
                        patientCount.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame, "Please fill in all doctor details."
                    );
                    return;
                }

                LocalDate doctorDate =
                        LocalDate.parse(date.getText().trim());
                LocalTime start =
                        LocalTime.parse(startTime.getText().trim());
                LocalTime end =
                        LocalTime.parse(endTime.getText().trim());
                int patients =
                        Integer.parseInt(patientCount.getText().trim());

                if (patients < 0 || !end.isAfter(start)) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Enter a non-negative patient count and " +
                                    "a valid time slot."
                    );
                    return;
                }

                String sql = "INSERT INTO doctor " +
                        "(name, id, specialization, date, start_time, " +
                        "end_time, patient_count, department) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                try (Connection con = getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)) {

                    ps.setString(1, name);
                    ps.setString(2, id);
                    ps.setString(3, spec);
                    ps.setDate(4, java.sql.Date.valueOf(doctorDate));
                    ps.setTime(5, java.sql.Time.valueOf(start));
                    ps.setTime(6, java.sql.Time.valueOf(end));
                    ps.setInt(7, patients);
                    ps.setString(8, selectedDepartment);

                    ps.executeUpdate();
                }

                JOptionPane.showMessageDialog(
                        frame, "Doctor details saved successfully!"
                );

                beds();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        frame, "Patient count must be a whole number."
                );
            } catch (java.time.format.DateTimeParseException ex) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Use date yyyy-MM-dd and time HH:mm."
                );
            } catch (SQLException ex) {
                showDatabaseError(ex);
            }
        });

        frame.add(mainPanel);
        frame.revalidate();
        frame.repaint();
    }

    // REUSABLE FORM FIELD
    void addField(JPanel panel, GridBagConstraints gbc,
                  int row, String label, JTextField field) {

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    // BED DETAILS SCREEN
    void beds() {
        frame.getContentPane().removeAll();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel(
                "Enter Bed Details - " + selectedDepartment,
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 21));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField month = new JTextField(18);
        JTextField occupied = new JTextField(18);
        JTextField total = new JTextField(18);

        addField(form, gbc, 0, "Month:", month);
        addField(form, gbc, 1, "Beds Occupied:", occupied);
        addField(form, gbc, 2, "Total Beds:", total);

        mainPanel.add(form, BorderLayout.CENTER);

        JButton backButton = new JButton("BACK");
        JButton saveButton = new JButton("SAVE BED DETAILS");

        JPanel buttons = new JPanel();
        buttons.add(backButton);
        buttons.add(saveButton);
        mainPanel.add(buttons, BorderLayout.SOUTH);

        backButton.addActionListener(e -> showDepartment());

        saveButton.addActionListener(e -> {
            try {
                String monthValue = month.getText().trim();

                if (monthValue.isEmpty() ||
                        occupied.getText().trim().isEmpty() ||
                        total.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame, "Please fill in all bed details."
                    );
                    return;
                }

                int bedsOccupied =
                        Integer.parseInt(occupied.getText().trim());
                int bedsTotal =
                        Integer.parseInt(total.getText().trim());

                if (bedsOccupied < 0 || bedsTotal <= 0 ||
                        bedsOccupied > bedsTotal) {

                    JOptionPane.showMessageDialog(
                            frame, "Enter valid bed counts."
                    );
                    return;
                }

                String sql = "INSERT INTO bed " +
                        "(month, bed_occupied, bed_total, department) " +
                        "VALUES (?, ?, ?, ?)";

                try (Connection con = getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)) {

                    ps.setString(1, monthValue);
                    ps.setInt(2, bedsOccupied);
                    ps.setInt(3, bedsTotal);
                    ps.setString(4, selectedDepartment);

                    ps.executeUpdate();
                }

                JOptionPane.showMessageDialog(
                        frame, "Bed details saved successfully!"
                );

                demand();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        frame, "Bed counts must be whole numbers."
                );
            } catch (SQLException ex) {
                showDatabaseError(ex);
            }
        });

        frame.add(mainPanel);
        frame.revalidate();
        frame.repaint();
    }

    // DEMAND DETAILS SCREEN
    void demand()
     {
        frame.getContentPane().removeAll();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel(
                "Enter Demand Details - " + selectedDepartment,
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 21));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField surgeryName = new JTextField(18);
        JTextField performedCount = new JTextField(18);
        JTextField unmetCount = new JTextField(18);
        JTextField equipmentCount = new JTextField(18);

        addField(form, gbc, 0, "Surgery Name:", surgeryName);
        addField(form, gbc, 1, "Performed Count:", performedCount);
        addField(form, gbc, 2, "Unmet Count:", unmetCount);
        addField(form, gbc, 3, "Equipment Count:", equipmentCount);

        mainPanel.add(form, BorderLayout.CENTER);

        JButton backButton = new JButton("BACK");
        JButton saveButton = new JButton("SAVE DEMAND");
        JButton analysisButton = new JButton("ANALYSIS");

        JPanel buttons = new JPanel();
        buttons.add(backButton);
        buttons.add(saveButton);
        buttons.add(analysisButton);

        mainPanel.add(buttons, BorderLayout.SOUTH);

        backButton.addActionListener(e -> beds());

        saveButton.addActionListener(e -> {
            try {
                String surgery = surgeryName.getText().trim();

                if (surgery.isEmpty() ||
                        performedCount.getText().trim().isEmpty() ||
                        unmetCount.getText().trim().isEmpty() ||
                        equipmentCount.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame, "Please fill in all demand details."
                    );
                    return;
                }

                int performed =
                        Integer.parseInt(performedCount.getText().trim());
                int unmet =
                        Integer.parseInt(unmetCount.getText().trim());
                int equipment =
                        Integer.parseInt(equipmentCount.getText().trim());

                if (performed < 0 || unmet < 0 || equipment < 0) {
                    JOptionPane.showMessageDialog(
                            frame, "Counts cannot be negative."
                    );
                    return;
                }

                String sql = "INSERT INTO demand " +
                        "(surgery_name, performed_count, unmet_count, " +
                        "equipment_count, department) VALUES (?, ?, ?, ?, ?)";

                try (Connection con = getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)) {

                    ps.setString(1, surgery);
                    ps.setInt(2, performed);
                    ps.setInt(3, unmet);
                    ps.setInt(4, equipment);
                    ps.setString(5, selectedDepartment);

                    ps.executeUpdate();
                }

                JOptionPane.showMessageDialog(
                        frame, "Demand details saved successfully!"
                );

                surgeryName.setText("");
                performedCount.setText("");
                unmetCount.setText("");
                equipmentCount.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        frame, "Counts must be whole numbers."
                );
            } catch (SQLException ex) {
                showDatabaseError(ex);
            }
        });

        analysisButton.addActionListener(e -> analysis(selectedDepartment));

        frame.add(mainPanel);
        frame.revalidate();
        frame.repaint();
    }

    // ANALYSIS REPORT: READS ACTUAL DATABASE RECORDS
        void analysis(String deptName )
        {
                frame.getContentPane().removeAll();

                JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
                mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
                );
                mainPanel.setBackground(new Color(242, 246, 252));

                JLabel title = new JLabel(
                        selectedDepartment + " - Analysis Report",
                        SwingConstants.CENTER
                );
                title.setFont(new Font("Arial", Font.BOLD, 24));
                title.setForeground(new Color(24, 43, 73));

                mainPanel.add(title, BorderLayout.NORTH);

                JTextArea report = new JTextArea();
                report.setEditable(false);
                report.setFont(new Font("Monospaced", Font.PLAIN, 14));
                report.setMargin(new Insets(15, 15, 15, 15));

                StringBuilder result = new StringBuilder();

                result.append("HOSPITAL DATA ANALYSIS REPORT\n");
                result.append("Department: ")
                .append(selectedDepartment).append("\n");
                result.append("========================================\n\n");

                try (Connection con = getConnection()) 
                {

                        ArrayList<Doctor> doctors = new ArrayList<>();
                        ArrayList<Bedrecords> bedRecords = new ArrayList<>();
                        ArrayList<Demand> demands = new ArrayList<>();
                        String doctorSql ="SELECT * FROM doctor WHERE department = ?";
                        try (PreparedStatement ps1 = con.prepareStatement(doctorSql)) 
                        {

                                ps1.setString(1, deptName);

                                try (ResultSet rs1 = ps1.executeQuery())
                                {
                                        while (rs1.next()) 
                                        {

                                                Doctor doctor = new Doctor(
                                                rs1.getString("name"),
                                                rs1.getString("id"),
                                                rs1.getString("specialization"),
                                                rs1.getObject("date",LocalDate.class),
                                                rs1.getObject("start_Time",LocalTime.class),
                                                rs1.getObject("end_Time",LocalTime.class),
                                                rs1.getInt("patient_count")
                                                );

                                        doctors.add(doctor);
                                        }
                                }
                        }
                        
                        String bedSql ="SELECT * FROM bed WHERE department = ?";

                        try (PreparedStatement ps2 =con.prepareStatement(bedSql)) 
                        {
                                ps2.setString(1, deptName);

                                try (ResultSet rs2 = ps2.executeQuery()) 
                                {
                                        while (rs2.next())
                                        {
                                                Bedrecords bed = new Bedrecords(
                                                rs2.getInt("bed_Occupied"),
                                                rs2.getInt("bed_Total"),
                                                rs2.getString("month")
                                                );

                                                bedRecords.add(bed);
                                        }
                                }
                        }

                        String demandSql ="SELECT * FROM demand WHERE department = ?";

                       try (PreparedStatement ps3 = con.prepareStatement(demandSql)) 
                        {

                                ps3.setString(1, deptName);

                                try (ResultSet rs3 = ps3.executeQuery()) 
                                {
                                while (rs3.next()) 
                                {
                                        Demand demand = new Demand(
                                        rs3.getString("surgery_Name"),
                                        rs3.getInt("performed_Count"),
                                        rs3.getInt("unmet_Count"),
                                        rs3.getInt("equipment_Count")
                                        );

                                        demands.add(demand);
                                }
                        }
                }
                }catch (SQLException ex) {
                        showDatabaseError(ex);
                return;
        }
        Department dept=new Department(deptName,doctors,bedRecords,demands);
        Analysis analysis1=new Analysis();
        analysis1.analyseDepartment(dept);
        ArrayList<Workload> workloads=analysis1.getWorkloads();

        ArrayList<Bedpercentage> bedPercentages=analysis1.getBedPercentages();

        ArrayList<Demandpercentages> demandPercentages=analysis1.getDemandPercentages();



        WorkloadReport workloadReport=new WorkloadReport(workloads);

        Bedreport bedReport=new Bedreport(bedPercentages);

        DemandReport demandReport=new DemandReport(demandPercentages);

    
            
        result.append("\n== WORKLOAD REPORT ==\n");
        result.append(workloadReport.generateReport());
        result.append(workloadReport.showInference());

        result.append("\n== BED REPORT ==\n");
        result.append(bedReport.generateReport());
        result.append(bedReport.showInference());

        result.append("\n== DEMAND REPORT ==\n");
        result.append(demandReport.generateReport());
        result.append(demandReport.showInference());
        report.setText(result.toString());
        report.setCaretPosition(0);

        mainPanel.add(new JScrollPane(report), BorderLayout.CENTER);

        JButton backButton = new JButton("BACK");
        JButton refreshButton = new JButton("REFRESH ANALYSIS");
        JButton saveButton = new JButton("SAVE REPORT");

        JPanel buttons = new JPanel();
        buttons.add(backButton);
        buttons.add(refreshButton);
        buttons.add(saveButton);

        mainPanel.add(buttons, BorderLayout.SOUTH);

        backButton.addActionListener(e -> demand());

        refreshButton.addActionListener(e -> analysis(selectedDepartment));

        saveButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(
                    new java.io.File("HospitalReport.txt")
            );

            if (chooser.showSaveDialog(frame)
                    != JFileChooser.APPROVE_OPTION) {
                return;
            }

            try (java.io.PrintWriter writer =
                         new java.io.PrintWriter(
                                 chooser.getSelectedFile())) {

                writer.print(report.getText());

                JOptionPane.showMessageDialog(
                        frame, "Report saved successfully!"
                );

            } catch (java.io.IOException ex) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Unable to save report: " + ex.getMessage()
                );
            }
        });

        frame.add(mainPanel);
        frame.revalidate();
        frame.repaint();
    }

    // RETURN TO DEPARTMENT SELECTION
    void showHome() {
        frame.getContentPane().removeAll();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);

        JLabel title = new JLabel("HOSPITAL ANALYSIS SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Select Department:"), gbc);

        String[] departments = {
                "Orthopedics", "Neurology", "Gynecology"
        };

        JComboBox<String> departmentBox =
                new JComboBox<>(departments);
        departmentBox.setPreferredSize(new Dimension(220, 30));

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(departmentBox, gbc);

        JButton openButton = new JButton("OPEN");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(openButton, gbc);

        openButton.addActionListener(e -> {
            selectedDepartment =
                    (String) departmentBox.getSelectedItem();
            showDepartment();
        });

        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    // DATABASE ERROR MESSAGE
    void showDatabaseError(SQLException ex) {
        ex.printStackTrace();

        JOptionPane.showMessageDialog(
                frame,
                "Database error:\n" + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    // MAIN METHOD
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception ignored) {
            }

            new HospitalGUI();
        });
    }
}
