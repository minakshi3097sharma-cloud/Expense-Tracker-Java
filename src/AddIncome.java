import javax.swing.*;
import java.sql.*;
public class AddIncome extends JFrame{
     JTextField amountField, sourceField, dateField;
    JButton saveButton;

    AddIncome() {
        setTitle("Add Income");
        setSize(350, 300);
        setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 40, 100, 30);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 40, 130, 30);
        add(amountField);

        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setBounds(50, 90, 100, 30);
        add(sourceLabel);

        sourceField = new JTextField();
        sourceField.setBounds(150, 90, 130, 30);
        add(sourceField);

        JLabel dateLabel = new JLabel("Date YYYY-MM-DD:");
        dateLabel.setBounds(30, 140, 120, 30);
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(150, 140, 130, 30);
        add(dateField);

        saveButton = new JButton("Save");
        saveButton.setBounds(120, 190, 100, 30);
        add(saveButton);

        saveButton.addActionListener(e -> saveIncome());

        setVisible(true);
    }

    void saveIncome() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO income(amount, source, date) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, Double.parseDouble(amountField.getText()));
            ps.setString(2, sourceField.getText());
            ps.setString(3, dateField.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Income Added Successfully");
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
}
