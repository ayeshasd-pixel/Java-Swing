import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CourseManagement extends JFrame {

    JTextField studentName;
    JList<String> courseList;
    JTable table;
    DefaultTableModel model;

    public CourseManagement() {
        setTitle("Student Course Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Student Name:"));

        studentName = new JTextField(15);
        topPanel.add(studentName);

        add(topPanel, BorderLayout.NORTH);

        String[] courses = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Operating Systems",
            "Computer Networks"
        };

        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane courseScroll = new JScrollPane(courseList);
        courseScroll.setBorder(
            BorderFactory.createTitledBorder("Available Courses")
        );

        add(courseScroll, BorderLayout.WEST);

        String[] columns = {
            "Student Name",
            "Selected Course",
            "Enrollment Status"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane tableScroll = new JScrollPane(table);

        add(tableScroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Course");
        JButton removeButton = new JButton("Remove Course");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = studentName.getText();
                String course = courseList.getSelectedValue();

                if (name.isEmpty() || course == null) {
                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Enter student name and select a course."
                    );
                } else {
                    model.addRow(
                        new Object[]{name, course, "Enrolled"}
                    );

                    studentName.setText("");
                    courseList.clearSelection();
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row != -1) {
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Select a registration to remove."
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CourseManagement();
    }
}