import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MainMenu extends JFrame {
    private final Color baseColor = new Color(255, 182, 193); // Light pinkish purple
    private final Color textColor = new Color(0, 0, 0); // Bold black
    private final Color accentColor = new Color(33, 150, 243); // Bold blue

    public MainMenu() {
        setTitle("Student Assistant - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(baseColor);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create header panel
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(baseColor);
        
        JLabel titleLabel = new JLabel("Student Assistant");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(textColor);
        headerPanel.add(titleLabel);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 20, 20));
        buttonsPanel.setBackground(baseColor);
        buttonsPanel.setBorder(new EmptyBorder(50, 100, 50, 100));

        // GPA Predictor button
        JButton gpaButton = createMenuButton("GPA Predictor", "📊");
        gpaButton.addActionListener(e -> {
            dispose();
            new GPACalculator(baseColor, textColor, accentColor).show();
        });

        // Mental Health Support button
        JButton mentalHealthButton = createMenuButton("Mental Health Support", "💆");
        mentalHealthButton.addActionListener(e -> {
            dispose();
            new MentalHealthSupport(baseColor, textColor, accentColor).show();
        });

        // Timetable Notifier button
        JButton timetableButton = createMenuButton("Timetable Notifier", "⏰");
        timetableButton.addActionListener(e -> {
            dispose();
            new TimetableManager(baseColor, textColor, accentColor).show();
        });

        buttonsPanel.add(gpaButton);
        buttonsPanel.add(mentalHealthButton);
        buttonsPanel.add(timetableButton);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JButton createMenuButton(String text, String emoji) {
        JButton button = new JButton(emoji + "  " + text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(new Color(147, 112, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(20, 20, 20, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public void show() {
        setVisible(true);
    }
}