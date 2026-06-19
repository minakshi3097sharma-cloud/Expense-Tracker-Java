import javax.swing.*;
import java.sql.*;
public class AddExpense extends JFrame{
    JTextField amountField, categoryField, descriptionField, dateField;
    JButton saveButton;

    AddExpense() {
        setTitle("Add Expense");
        setSize(400, 350);
        setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 40, 120, 30);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(180, 40, 140, 30);
        add(amountField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(50, 90, 120, 30);
        add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setBounds(180, 90, 140, 30);
        add(categoryField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(50, 140, 120, 30);
        add(descriptionLabel);

        descriptionField = new JTextField();
        descriptionField.setBounds(180, 140, 140, 30);
        add(descriptionField);

        JLabel dateLabel = new JLabel("Date YYYY-MM-DD:");
        dateLabel.setBounds(50, 190, 130, 30);
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(180, 190, 140, 30);
        add(dateField);

        saveButton = new JButton("Save");
        saveButton.setBounds(140, 240, 100, 30);
        add(saveButton);

        saveButton.addActionListener(e -> saveExpense());

        setVisible(true);
    }

    void saveExpense() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO expense(amount, category, description, date) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, Double.parseDouble(amountField.getText()));
            ps.setString(2, categoryField.getText());
            ps.setString(3, descriptionField.getText());
            ps.setString(4, dateField.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Expense Added Successfully");
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
}
