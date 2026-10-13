
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class HospitalDashboard extends JFrame {

    private final Color navy = new Color(24, 43, 73);
    private final Color blue = new Color(43, 119, 235);
    private final Color background = new Color(242, 246, 252);

    private final ArrayList<String> records = new ArrayList<>();
    private JTextArea output;

    public HospitalDashboard() {
        setTitle("Hospital Data Analysis System");
        setSize(1100, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(navy);
        sidebar.setPreferredSize(new Dimension(205, 0));
        sidebar.setLayout(new GridLayout(9, 1, 5, 5));
        sidebar.setBorder(new EmptyBorder(15, 12, 15, 12));

        JLabel logo = new JLabel("  ✚ Hospital Analytics");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 17));
        sidebar.add(logo);

        addNav(sidebar, "Dashboard", () -> showDashboard());
        addNav(sidebar, "Data Entry", () -> dataEntry());
        addNav(sidebar, "Analysis", () -> analysis());
        addNav(sidebar, "Reports", () -> reports());
        addNav(sidebar, "View Records", () -> viewRecords());
        addNav(sidebar, "About", () -> about());

        add(sidebar, BorderLayout.WEST);
        showDashboard();
    }

    private void addNav(JPanel sidebar, String text,
                        Runnable action) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(navy);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> action.run());
        sidebar.add(button);
    }

    private JPanel createContent(String heading) {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(background);
        panel.setBorder(new EmptyBorder(25, 25, 25, 25));

        JLabel title = new JLabel(heading);
        title.setFont(new Font("SansSerif", Font.BOLD, 25));
        title.setForeground(navy);
        panel.add(title, BorderLayout.NORTH);
        return panel;
    }

    private void showDashboard() {
        JPanel page = createContent("Hospital Dashboard");

        JPanel center = new JPanel(new GridLayout(2, 2, 15, 15));
        center.setBackground(background);

        center.add(card("Doctor Workload",
                "Enter and analyse doctor workload", blue));
        center.add(card("Bed Occupancy",
                "Monitor available and occupied beds",
                new Color(32, 166, 120)));
        center.add(card("Surgical Demand",
                "Track performed and unmet surgeries",
                new Color(133, 91, 210)));
        center.add(card("Reports",
                "Generate hospital analysis reports",
                new Color(235, 145, 45)));

        page.add(center, BorderLayout.CENTER);

        JLabel footer = new JLabel(
                "Hospital Data Analysis System | Dashboard");
        footer.setForeground(Color.GRAY);
        page.add(footer, BorderLayout.SOUTH);

        setPage(page);
    }

    private JPanel card(String title, String description,
                        Color accent) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(
                        0, 5, 0, 0, accent),
                new EmptyBorder(25, 20, 20, 20)));

        JLabel heading = new JLabel(title);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setForeground(navy);

        JLabel details = new JLabel(
                "<html>" + description + "</html>");
        details.setFont(new Font("SansSerif", Font.PLAIN, 14));

        panel.add(heading);
        panel.add(Box.createVerticalStrut(12));
        panel.add(details);
        return panel;
    }

    private void dataEntry() {
        JTextField department = new JTextField();
        JTextField doctors = new JTextField();
        JTextField patients = new JTextField();
        JTextField totalBeds = new JTextField();
        JTextField occupiedBeds = new JTextField();
        JTextField surgery = new JTextField();
        JTextField performed = new JTextField();
        JTextField unmet = new JTextField();
        JTextField equipment = new JTextField();

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("Department:"));
        form.add(department);
        form.add(new JLabel("Number of doctors:"));
        form.add(doctors);
        form.add(new JLabel("Patients attended:"));
        form.add(patients);
        form.add(new JLabel("Total beds:"));
        form.add(totalBeds);
        form.add(new JLabel("Occupied beds:"));
        form.add(occupiedBeds);
        form.add(new JLabel("Surgery name:"));
        form.add(surgery);
        form.add(new JLabel("Surgeries performed:"));
        form.add(performed);
        form.add(new JLabel("Unmet surgery requests:"));
        form.add(unmet);
        form.add(new JLabel("Relevant equipment available:"));
        form.add(equipment);

        int result = JOptionPane.showConfirmDialog(
                this, form, "Hospital Data Entry",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result != JOptionPane.OK_OPTION) return;

        try {
            String dept = department.getText().trim();
            String surg = surgery.getText().trim();

            int d = Integer.parseInt(doctors.getText().trim());
            int p = Integer.parseInt(patients.getText().trim());
            int beds = Integer.parseInt(totalBeds.getText().trim());
            int occupied = Integer.parseInt(
                    occupiedBeds.getText().trim());
            int done = Integer.parseInt(performed.getText().trim());
            int pending = Integer.parseInt(unmet.getText().trim());
            int equip = Integer.parseInt(equipment.getText().trim());

            if (dept.isEmpty() || surg.isEmpty()
                    || d < 0 || p < 0 || beds <= 0
                    || occupied < 0 || occupied > beds
                    || done < 0 || pending < 0 || equip < 0) {
                throw new IllegalArgumentException();
            }

            records.add("Department: " + dept
                    + " | Doctors: " + d
                    + " | Patients: " + p
                    + " | Beds: " + occupied + "/" + beds
                    + " | Surgery: " + surg
                    + " | Performed: " + done
                    + " | Unmet: " + pending
                    + " | Equipment: " + equip);

            JOptionPane.showMessageDialog(this,
                    "Hospital record saved successfully!");

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter valid data in every field.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void analysis() {
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter hospital data first.");
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append("HOSPITAL DATA ANALYSIS\n\n");

        for (String record : records) {
            result.append(record).append("\n\n");
        }

        JTextArea area = new JTextArea(result.toString());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));

        setPage(createTextPage("Analysis Results", area));
    }

    private void reports() {
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter hospital data first.");
            return;
        }

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));

        for (String record : records) {
            area.append(record + "\n\n");
        }

        output = area;

        JPanel page = createTextPage("Hospital Reports", area);
        JButton save = new JButton("Save Report to File");
        save.addActionListener(e -> saveReport());

        JPanel bottom = new JPanel();
        bottom.add(save);
        page.add(bottom, BorderLayout.SOUTH);

        setPage(page);
    }

    private void saveReport() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(
                new java.io.File("HospitalReport.txt"));

        if (chooser.showSaveDialog(this)
                != JFileChooser.APPROVE_OPTION) return;

        try (java.io.PrintWriter writer =
                new java.io.PrintWriter(chooser.getSelectedFile())) {
            writer.print(output.getText());
            JOptionPane.showMessageDialog(this,
                    "Report saved successfully!");
        } catch (java.io.IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Unable to save report: " + ex.getMessage());
        }
    }

    private void viewRecords() {
        JTextArea area = new JTextArea();
        area.setEditable(false);

        if (records.isEmpty()) {
            area.setText("No records available.");
        } else {
            for (String record : records) {
                area.append(record + "\n\n");
            }
        }

        setPage(createTextPage("Stored Hospital Records", area));
    }

    private void about() {
        JOptionPane.showMessageDialog(this,
                "Hospital Data Analysis System\n"
                + "Analyses doctor workload, bed occupancy,\n"
                + "and surgical demand.\n\n"
                + "This is a Java Swing starter GUI.");
    }

    private JPanel createTextPage(String title, JTextArea area) {
        JPanel page = createContent(title);
        page.add(new JScrollPane(area), BorderLayout.CENTER);
        return page;
    }

    private void setPage(JPanel page) {
        // Keep the sidebar and replace only the main content.
        Component sidebar = getContentPane().getComponent(0);
        getContentPane().removeAll();
        add(sidebar, BorderLayout.WEST);
        add(page, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) { }

            new HospitalDashboard().setVisible(true);
        });
    }
}
