import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, regField;
    JRadioButton male, female, other;
    JComboBox<String> department;

    public StudentRegistration() {
        setTitle("Student Registration");
        setSize(450, 400);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField();

        JLabel regLabel = new JLabel("Register Number:");
        regField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        JLabel deptLabel = new JLabel("Department:");

        String[] departments = {
            "CSE",
            "CSE-AIML",
            "ECE",
            "EEE",
            "Mechanical",
            "Civil"
        };

        department = new JComboBox<>(departments);

        JButton submit = new JButton("Submit");

        add(nameLabel);
        add(nameField);

        add(regLabel);
        add(regField);

        add(genderLabel);
        add(genderPanel);

        add(deptLabel);
        add(department);

        add(new JLabel(""));
        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String register = regField.getText();

                String gender = "";

                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";
                else if (other.isSelected())
                    gender = "Other";

                String dept = department.getSelectedItem().toString();

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    "Student Name: " + name +
                    "\nRegister Number: " + register +
                    "\nGender: " + gender +
                    "\nDepartment: " + dept
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}