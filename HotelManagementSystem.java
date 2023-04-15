import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    private JLabel titleLabel, idLabel, nameLabel, addressLabel, phoneLabel, emailLabel, roomTypeLabel, checkinLabel, checkoutLabel;
    private JTextField idField, nameField, addressField, phoneField, emailField, roomTypeField, checkinField, checkoutField;
    private JButton addButton, editButton, deleteButton, clearButton, exitButton,saveButton;
    private JTable dataTable;
    private DefaultTableModel model;
    private JScrollPane scrollPane;



    public HotelManagementSystem() {
        // Set the title of the JFrame
        setTitle("Hotel Booking System");
        
        // Initialize the components
        titleLabel = new JLabel("Hotel Booking System");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(100, 10, 250, 50);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 70, 100, 20);
        idField = new JTextField();
        idField.setBounds(130, 70, 200, 20);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 100, 100, 20);
        nameField = new JTextField();
        nameField.setBounds(130, 100, 200, 20);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(20, 130, 100, 20);
        addressField = new JTextField();
        addressField.setBounds(130, 130, 200, 20);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(20, 160, 100, 20);
        phoneField = new JTextField();
        phoneField.setBounds(130, 160, 200, 20);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 190, 100, 20);
        emailField = new JTextField();
        emailField.setBounds(130, 190, 200, 20);

        roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setBounds(20, 220, 100, 20);
        roomTypeField = new JTextField();
        roomTypeField.setBounds(130, 220, 200, 20);

        checkinLabel = new JLabel("Check In:");
        checkinLabel.setBounds(20, 250, 100, 20);
        checkinField = new JTextField();
        checkinField.setBounds(130, 250, 200, 20);

        checkoutLabel = new JLabel("Check Out:");
        checkoutLabel.setBounds(20, 280, 100, 20);
        checkoutField = new JTextField();
        checkoutField.setBounds(130, 280, 200, 20);

        addButton = new JButton("Add");
        addButton.setBounds(20, 330, 80, 30);
        addButton.addActionListener(this);

        editButton = new JButton("Edit");
        editButton.setBounds(110, 330, 80, 30);
        editButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(200, 330, 80, 30);
        deleteButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 330, 80, 30);
        clearButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(380, 330, 80, 30);
        exitButton.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.setBounds(650, 300, 80, 25);
        saveButton.addActionListener(this);
        
        dataTable = new JTable();
        model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Name", "Address", "Phone", "Email", "Room Type", "Check In", "Check Out"}
        );
        dataTable.setModel(model);
        dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        dataTable.setFillsViewportHeight(true);
    
        scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(350, 70, 500, 200);
    
        // Add the components to the JFrame
        add(titleLabel);
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(addressLabel);
        add(addressField);
        add(phoneLabel);
        add(phoneField);
        add(emailLabel);
        add(emailField);
        add(roomTypeLabel);
        add(roomTypeField);
        add(checkinLabel);
        add(checkinField);
        add(checkoutLabel);
        add(checkoutField);
        add(addButton);
        add(editButton);
        add(deleteButton);
        add(clearButton);
        add(exitButton);
        add(scrollPane);

        add(saveButton);

        
    
        // Set the properties of the JFrame
        setLayout(null);
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Handle the button clicks
        if (e.getSource() == addButton) {
            String[] data = {
                idField.getText(),
                nameField.getText(),
                addressField.getText(),
                phoneField.getText(),
                emailField.getText(),
                roomTypeField.getText(),
                checkinField.getText(),
                checkoutField.getText()
            };
            model.addRow(data);
            clearFields();
        } else if (e.getSource() == editButton) {
            int i = dataTable.getSelectedRow();
            if (i >= 0) {
                model.setValueAt(idField.getText(), i, 0);
                model.setValueAt(nameField.getText(), i, 1);
                model.setValueAt(addressField.getText(), i, 2);
                model.setValueAt(phoneField.getText(), i, 3);
                model.setValueAt(emailField.getText(), i, 4);
                model.setValueAt(roomTypeField.getText(), i, 5);
                model.setValueAt(checkinField.getText(), i, 6);
                model.setValueAt(checkoutField.getText(), i, 7);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to edit.");
            }
        } else if (e.getSource() == deleteButton) {
            int i = dataTable.getSelectedRow();
            if (i >= 0) {
                model.removeRow(i);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            }
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
        else if (e.getSource() == saveButton) {
            saveData();
        }
    }
    
    public void clearFields() {
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
        phoneField.setText("");
        emailField.setText("");
        roomTypeField.setText("");
        checkinField.setText("");
        checkoutField.setText("");
    }

    // public void actionPerformed(ActionEvent e) {
    //     // Handle the button clicks
    //     if (e.getSource() == addButton) {
    //         // ...
    //     } else if (e.getSource() == editButton) {
    //         // ...
    //     } else if (e.getSource() == deleteButton) {
    //         // ...
    //     } else if (e.getSource() == clearButton) {
    //         // ...
    //     } else if (e.getSource() == saveButton) {
    //         saveData();
    //     } else if (e.getSource() == exitButton) {
    //         // ...
    //     }
    // }
    


    public void saveData() {
        try {
            String id = idField.getText();
            // String name = nameField.getText();
            // String address = addressField.getText();
            // String phone = phoneField.getText();
            // String email = emailField.getText();
            // String roomType = roomTypeField.getText();
            // String checkin = checkinField.getText();
            // String checkout = checkoutField.getText();
            
            boolean flag=false;
            // if(id.equals("") || name.equals("")|| address.equals("") || phone.equals("")){
            //     JOptionPane.showMessageDialog(null, "Please Insert the user Data.");
            //     flag=true;
            // }

            FileWriter writer = new FileWriter("customer_data.txt");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString() + ",");
                }
                writer.write(id.toString());
            }
            writer.close();
            if(!flag)
                JOptionPane.showMessageDialog(null, "Data saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
        }
    }
    

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}    