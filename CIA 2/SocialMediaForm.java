import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SocialMediaForm extends JFrame {

    public SocialMediaForm() {
        setTitle("Social Media Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Personal Information Panel
        JPanel personalInfoPanel = new JPanel(new GridLayout(7, 2));
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));

        // Labels
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email ID:");
        JLabel religionLabel = new JLabel("Religion:");
        JLabel dobLabel = new JLabel("Date of Birth:");

        // Text Fields
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField religionField = new JTextField();
        JTextField dobField = new JTextField();

        // Add components to Personal Information Panel
        personalInfoPanel.add(firstNameLabel);
        personalInfoPanel.add(firstNameField);
        personalInfoPanel.add(lastNameLabel);
        personalInfoPanel.add(lastNameField);
        personalInfoPanel.add(phoneLabel);
        personalInfoPanel.add(phoneField);
        personalInfoPanel.add(emailLabel);
        personalInfoPanel.add(emailField);
        personalInfoPanel.add(religionLabel);
        personalInfoPanel.add(religionField);
        personalInfoPanel.add(dobLabel);
        personalInfoPanel.add(dobField);

        // Persons Interested Panel
        JPanel interestsPanel = new JPanel(new GridLayout(1, 1));
        interestsPanel.setBorder(BorderFactory.createTitledBorder("Persons Interested"));

        // TODO: Add components for persons interested categories

        // Add Personal Information Panel and Persons Interested Panel to the main panel
        mainPanel.add(personalInfoPanel);
        mainPanel.add(interestsPanel);

        // Add main panel to the frame
        add(mainPanel);

        // Implementing validations and events

        // Validation for mandatory fields
        addValidation(firstNameLabel, firstNameField);
        addValidation(lastNameLabel, lastNameField);
        addValidation(phoneLabel, phoneField);
        addValidation(emailLabel, emailField);
        addValidation(religionLabel, religionField);
        addValidation(dobLabel, dobField);

        // Age validation
        dobField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Do nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Do nothing
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Validate age when Date of Birth is entered
                if (!dobField.getText().isEmpty()) {
                    int age = calculateAge(dobField.getText());
                    if (age < 20) {
                        JOptionPane.showMessageDialog(SocialMediaForm.this, "Age must be at least 20 years.",
                                "Age Validation", JOptionPane.ERROR_MESSAGE);
                        dobField.setText("");
                    }
                }
            }
        });
    }

    private void addValidation(JLabel label, JTextField textField) {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Do nothing
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Do nothing
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Display message if the field is empty
                if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SocialMediaForm.this,
                            label.getText() + " is a mandatory field.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private int calculateAge(String dob) {
        // TODO: Implement logic to calculate age from Date of Birth
        // For simplicity, you can use a library or a custom function to calculate age from the provided Date of Birth.
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SocialMediaForm().setVisible(true));
    }
}
