package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private static int random_num;
    private static JTextField inputField;
    private static JLabel messageLabel;

    public static void main(String[] args) {
        // Generate a random number between 1 and 200
        Random random = new Random();
        random_num = random.nextInt(200) + 1; // Number from 1 to 200

        // Create the frame for the game
        JFrame frame = new JFrame("Random Number Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create the panel to hold the game components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Create and add components to the panel
        JLabel titleLabel = new JLabel("Welcome to the Random Number Game!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLUE);

        JLabel promptLabel = new JLabel("Enter a number between 1 and 200:");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // Make input field stretch

        JButton guessButton = new JButton("Guess");
        JButton resetButton = new JButton("Reset");
        guessButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));

        messageLabel = new JLabel("Good luck!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        messageLabel.setForeground(Color.RED);

        // Add action listener to the buttons
        guessButton.addActionListener(new GuessButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        // Add components to the panel
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10)); // Add space
        panel.add(promptLabel);
        panel.add(inputField);
        panel.add(Box.createVerticalStrut(10)); // Add space
        panel.add(guessButton);
        panel.add(resetButton);
        panel.add(Box.createVerticalStrut(20)); // Add space
        panel.add(messageLabel);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Define the action listener for the guess button
    static class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int num = Integer.parseInt(inputField.getText());

                // Input validation
                if (num < 1 || num > 200) {
                    messageLabel.setText("Please enter a number between 1 and 200.");
                    return;
                }

                // Check the guess
                if (num == random_num) {
                    messageLabel.setText("Wow!! You Win!");
                } else if (num > random_num) {
                    messageLabel.setText("OPPS!! Your number is larger.");
                } else {
                    messageLabel.setText("OPPS!! Your number is smaller.");
                }

            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number.");
            }
        }
    }

    // Define the action listener for the reset button
    static class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            random_num = random.nextInt(200) + 1; // Reset the random number
            inputField.setText(""); // Clear input field
            messageLabel.setText("Good luck!"); // Reset message
        }
    }
}
