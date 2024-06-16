import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Water_Ordering_System extends JFrame {
    // Components
    
    JLabel title, name, address, contact, small, medium, large, deliveryDateLabel;
    JTextField nameField, addressField, contactField;
    JSpinner smallS, mediumS, largeS;
    JButton order, clear, exit;
    JSpinner deliveryDateSpinner;

    // Prices for each size
    private static final double SMALL_PRICE = 25;
    private static final double MEDIUM_PRICE = 35;
    private static final double LARGE_PRICE = 50;

    public Water_Ordering_System() {
        // Setting up the frame
        setTitle("H20 PURELY HYDRATED");
        setSize(465, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using null layout
        getContentPane().setBackground(Color.WHITE); // White background

        // Create and set up components
        title = new JLabel("  Welcome to H20 PURELY HYDRATED");
        title.setFont(new Font("Palotinotype", Font.BOLD, 24));
        title.setOpaque(true);
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 450, 50);
        add(title);

        name = new JLabel("Name:");
        name.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        name.setBounds(30, 70, 100, 30);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(140, 70, 200, 30);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(nameField);

        address = new JLabel("Address:");
        address.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        address.setBounds(30, 110, 100, 30);
        add(address);

        addressField = new JTextField();
        addressField.setBounds(140, 110, 200, 30);
        addressField.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(addressField);

        contact = new JLabel("Contact:");
        contact.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        contact.setBounds(30, 150, 100, 30);
        add(contact);

        contactField = new JTextField();
        contactField.setBounds(140, 150, 200, 30);
        contactField.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(contactField);

        small = new JLabel("Small - 25 pesos:");
        small.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        small.setBounds(30, 190, 170, 30);
        add(small);

        smallS = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        smallS.setBounds(250, 190, 140, 30);
        smallS.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(smallS);

        medium = new JLabel("Medium - 35 pesos:");
        medium.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        medium.setBounds(30, 230, 170, 30);
        add(medium);

        mediumS = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        mediumS.setBounds(250, 230, 140, 30);
        mediumS.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(mediumS);

        large = new JLabel("Large - 50 pesos:");
        large.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        large.setBounds(30, 270, 170, 30);
        add(large);

        largeS = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        largeS.setBounds(250, 270, 140, 30);
        largeS.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(largeS);

        deliveryDateLabel = new JLabel("Delivery Date:");
        deliveryDateLabel.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        deliveryDateLabel.setBounds(30, 310, 150, 30);
        add(deliveryDateLabel);

        deliveryDateSpinner = new JSpinner(new SpinnerDateModel());
        deliveryDateSpinner.setBounds(200, 310, 190, 30);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(deliveryDateSpinner, "dd/MM/yyyy");
        deliveryDateSpinner.setEditor(dateEditor);
        deliveryDateSpinner.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Blue border
        add(deliveryDateSpinner);

        order = new JButton("Order Now");
        order.setFont(new Font("Palotinotype", Font.BOLD, 18));
        order.setBackground(new Color(0, 123, 255)); // Blue background
        order.setForeground(Color.WHITE);
        order.setBorder(BorderFactory.createLineBorder(new Color(0, 105, 92), 2)); // Blue border
        order.setBounds(50, 360, 200, 40);
        add(order);

        clear = new JButton("Clear Form");
        clear.setFont(new Font("Palotinotype", Font.BOLD, 18));
        clear.setBackground(new Color(0, 123, 255)); // Blue background
        clear.setForeground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(new Color(0, 105, 92), 2)); // Blue border
        clear.setBounds(50, 420, 200, 40);
        add(clear);

        // Add action listeners
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Order Now")) {
                    // Handle order
                    String name = nameField.getText();
                    String address = addressField.getText();
                    String contact = contactField.getText();
                    int smallQuantity = (int) smallS.getValue();
                    int mediumQuantity = (int) mediumS.getValue();
                    int largeQuantity = (int) largeS.getValue();
                    Date deliveryDate = (Date) deliveryDateSpinner.getValue();

                    if (name.isEmpty() || address.isEmpty() || contact.isEmpty()) {
                        JOptionPane.showMessageDialog(Water_Ordering_System.this, "Please input your name, address, and contact.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (smallQuantity == 0 && mediumQuantity == 0 && largeQuantity == 0) {
                        JOptionPane.showMessageDialog(Water_Ordering_System.this, "Please select at least one size of bottled water.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double totalCost = (smallQuantity * SMALL_PRICE) + (mediumQuantity * MEDIUM_PRICE) + (largeQuantity * LARGE_PRICE);

                    StringBuilder summary = new StringBuilder();
                    summary.append(String.format("Order Summary:\n\nName: %s\nAddress: %s\nContact: %s\n\n", name, address, contact));

                    if (smallQuantity > 0) {
                        summary.append(String.format("Small Size Quantity: %d\n", smallQuantity));
                    }
                    if (mediumQuantity > 0) {
                        summary.append(String.format("Medium Size Quantity: %d\n", mediumQuantity));
                    }
                    if (largeQuantity > 0) {
                        summary.append(String.format("Large Size Quantity: %d\n", largeQuantity));
                    }
                    summary.append(String.format("\nTotal Cost: %.2f", totalCost));
                    summary.append(String.format("\nDelivery Date: %s", new SimpleDateFormat("dd/MM/yyyy").format(deliveryDate)));

                    showOrderSummary(summary.toString());
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Clear Form")) {
                    // Clear form
                    nameField.setText("");
                    addressField.setText("");
                    contactField.setText("");
                    smallS.setValue(0);
                    mediumS.setValue(0);
                    largeS.setValue(0);
                    deliveryDateSpinner.setValue(new Date());
                }
            }
        });

        // Add an icon at the bottom
        ImageIcon waterIcon = new ImageIcon("waterr.png");
        JLabel iconLabel = new JLabel(waterIcon);
        iconLabel.setBounds(0, 550, 500, 80);
        add(iconLabel);

        ImageIcon medium = new ImageIcon("water (2).png");
        JLabel mediumm = new JLabel(medium);
        mediumm.setBounds(300, 250, 200, 500);
        add(mediumm);

        ImageIcon logo = new ImageIcon("logo.jpg");
        setIconImage(logo.getImage());
    }

    private void showOrderSummary(String summary) {
        JFrame summaryF = new JFrame("Order Summary");
        summaryF.setSize(410, 500);
        summaryF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        summaryF.setLocationRelativeTo(this);
        summaryF.getContentPane().setBackground(new Color(224, 247, 250));
        summaryF.setLayout(null); // Using null layout

        JLabel summaryTitle = new JLabel("Order Summary", SwingConstants.CENTER);
        summaryTitle.setFont(new Font("Palotinotype", Font.BOLD, 24));
        summaryTitle.setOpaque(true);
        summaryTitle.setBackground(new Color(0, 123, 255)); // Blue background
        summaryTitle.setForeground(Color.WHITE);
        summaryTitle.setBounds(0, 0, 400, 50);
        summaryF.add(summaryTitle);

        JTextArea orderS = new JTextArea();
        orderS.setFont(new Font("Palotinotype", Font.PLAIN, 16));
        orderS.setEditable(false);
        orderS.setLineWrap(true);
        orderS.setWrapStyleWord(true);
        orderS.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0, 123, 255), 2),
                new EmptyBorder(10, 10, 10, 10)
        ));
        orderS.setBackground(new Color(255, 255, 255));
        orderS.setText(summary);
       
        JScrollPane scrollPane = new JScrollPane(orderS);
        scrollPane.setBounds(10, 60, 380, 240);
        summaryF.add(scrollPane);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 310, 380, 10);
        summaryF.add(separator);

        JButton close = new JButton("Close");
        close.setFont(new Font("Palotinotype", Font.BOLD, 18));
        close.setBackground(new Color(0, 123, 255)); // Blue background
        close.setForeground(Color.WHITE);
        close.setBounds(125, 320, 150, 40);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                summaryF.dispose();
                showFeedbackForm();
            }
        });
        summaryF.add(close);

        JLabel thank = new JLabel("Thanks for your order, Stay hydrated!", SwingConstants.CENTER);
        thank.setFont(new Font("Palotinotype", Font.BOLD, 18));
        thank.setForeground(new Color(0, 123, 255)); // Blue foreground
        thank.setBounds(0, 370, 400, 30);
        summaryF.add(thank);

        summaryF.setVisible(true);
    }

    private void showFeedbackForm() {
        JFrame feedbackF = new JFrame("Feedback Form");
        feedbackF.setSize(400, 300);
        feedbackF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        feedbackF.setLocationRelativeTo(this);
        feedbackF.getContentPane().setBackground(new Color(224, 247, 250));
        feedbackF.setLayout(null); // Using null layout

        JLabel feedback = new JLabel("Rate Our System", SwingConstants.CENTER);
        feedback.setFont(new Font("Palotinotype", Font.BOLD, 24));
        feedback.setOpaque(true);
        feedback.setBackground(new Color(0, 123, 255)); // Blue background
        feedback.setForeground(Color.WHITE);
        feedback.setBounds(0, 0, 400, 50);
        feedbackF.add(feedback);

        JLabel rate = new JLabel("Rate (1-5):");
        rate.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        rate.setBounds(50, 70, 100, 30);
        feedbackF.add(rate);

        JSpinner rateS = new JSpinner(new SpinnerNumberModel(3, 1, 5, 1));
        rateS.setBounds(160, 70, 50, 30);
        feedbackF.add(rateS);

        JLabel suggestion = new JLabel("Suggestions:");
        suggestion.setFont(new Font("Palotinotype", Font.PLAIN, 18));
        suggestion.setBounds(50, 110, 150, 30);
        feedbackF.add(suggestion);

        JTextArea suggestionArea = new JTextArea();
        suggestionArea.setFont(new Font("Palotinotype", Font.PLAIN, 16));
        suggestionArea.setLineWrap(true);
        suggestionArea.setWrapStyleWord(true);
        suggestionArea.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0, 123, 255), 2, true),
                new EmptyBorder(10, 10, 10, 10)
        ));
        suggestionArea.setBackground(new Color(255, 255, 255));
        JScrollPane suggestionScrollPane = new JScrollPane(suggestionArea);
        suggestionScrollPane.setBounds(50, 150, 300, 60);
        feedbackF.add(suggestionScrollPane);

        JButton submit= new JButton("Submit Feedback");
        submit.setFont(new Font("Palotinotype", Font.BOLD, 18));
        submit.setBackground(new Color(0, 123, 255)); // Blue background
        submit.setForeground(Color.WHITE);
        submit.setBounds(100, 220, 200, 40);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rating = (int) rateS.getValue();
                String suggestions = suggestionArea.getText();
                JOptionPane.showMessageDialog(feedbackF, "Thanks you for your feedback!", "Feedback Submitted", JOptionPane.INFORMATION_MESSAGE);
                feedbackF.dispose();
            }
        });
        feedbackF.add(submit);

        feedbackF.setVisible(true);
    }

    public static void main(String[] args) {
        new Water_Ordering_System().setVisible(true);
    }
}
