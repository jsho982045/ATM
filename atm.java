import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class atm {
    private static double balance = 1000;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Welcome to the ATM!");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label);

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check balance");
        JButton exitButton = new JButton("Exit");

        withdrawButton.addActionListener(e -> {
            withdraw();
        });
        depositButton.addActionListener(e -> {
            deposit();
        });
        checkBalanceButton.addActionListener(e -> {
            checkBalance();
        });
        exitButton.addActionListener(e -> {
            exit();
        });

        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ATM");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void withdraw() {
        String amountString = JOptionPane.showInputDialog("Enter amount to withdraw:");
        if (amountString == null) {
            return;
        }
        double amount = Double.parseDouble(amountString);
        if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            balance -= amount;
            JOptionPane.showMessageDialog(null, String.format("Withdrawal of $%.2f successful. Current balance: $%.2f", amount, balance), "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void deposit() {
        String amountString = JOptionPane.showInputDialog("Enter amount to deposit:");
        if (amountString == null) {
            return;
        }
        double amount = Double.parseDouble(amountString);
        balance += amount;
        JOptionPane.showMessageDialog(null, String.format("Deposit of $%.2f successful. Current balance: $%.2f", amount, balance), "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void checkBalance() {
        JOptionPane.showMessageDialog(null, String.format("Current balance: $%.2f", balance), "Balance", JOptionPane.PLAIN_MESSAGE);
    }

    public static void exit() {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for using the ATM. Goodbye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
