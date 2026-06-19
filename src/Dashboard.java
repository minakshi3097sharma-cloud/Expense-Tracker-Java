import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame {
 JButton addIncome, addExpense, viewReport, exit;

    Dashboard() {
        setTitle("Expense Tracker Dashboard");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addIncome = new JButton("Add Income");
        addIncome.setBounds(120, 40, 150, 30);
        add(addIncome);

        addExpense = new JButton("Add Expense");
        addExpense.setBounds(120, 90, 150, 30);
        add(addExpense);

        viewReport = new JButton("View Report");
        viewReport.setBounds(120, 140, 150, 30);
        add(viewReport);

        exit = new JButton("Logout");
        exit.setBounds(120, 190, 150, 30);
        add(exit);

        addIncome.addActionListener(e -> new AddIncome());
        addExpense.addActionListener(e -> new AddExpense());
        viewReport.addActionListener(e -> new Report());

        exit.addActionListener(e -> {
            new Login();
            dispose();
        });

        setVisible(true);
    }    
}
