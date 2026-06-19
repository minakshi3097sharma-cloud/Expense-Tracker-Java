import javax.swing.*;
import java.sql.*;
public class Report extends JFrame {
  JLabel incomeLabel, expenseLabel, balanceLabel;

    Report() {
        setTitle("Expense Report");
        setSize(350, 250);
        setLayout(null);

        incomeLabel = new JLabel();
        incomeLabel.setBounds(70, 50, 250, 30);
        add(incomeLabel);

        expenseLabel = new JLabel();
        expenseLabel.setBounds(70, 90, 250, 30);
        add(expenseLabel);

        balanceLabel = new JLabel();
        balanceLabel.setBounds(70, 130, 250, 30);
        add(balanceLabel);

        showReport();

        setVisible(true);
    }

    void showReport() {
        double totalIncome = 0;
        double totalExpense = 0;

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs1 = st.executeQuery("SELECT SUM(amount) FROM income");
            if (rs1.next()) {
                totalIncome = rs1.getDouble(1);
            }

            ResultSet rs2 = st.executeQuery("SELECT SUM(amount) FROM expense");
            if (rs2.next()) {
                totalExpense = rs2.getDouble(1);
            }

            double balance = totalIncome - totalExpense;

            incomeLabel.setText("Total Income: ₹" + totalIncome);
            expenseLabel.setText("Total Expense: ₹" + totalExpense);
            balanceLabel.setText("Balance: ₹" + balance);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }  
}
