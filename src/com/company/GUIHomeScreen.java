package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class GUIHomeScreen extends JFrame {
    private JButton btnLogIn, btnBack;
    private JLabel lblUserName, lblPassword;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JPanel panel = new JPanel();
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Constructor
     */
    public GUIHomeScreen(){
        setTitle("Home Screen");
        btnLogIn = new JButton("");
        btnBack = new JButton("BACK");
        lblUserName = new JLabel("USER NAME");
        lblPassword = new JLabel("PASSWORD");
        tfUsername = new JTextField(20);
        pfPassword = new JPasswordField(20);

        setSize(500,500);
        setLayout(layout);
        panel.setLayout(layout);
        gbc.insets= new Insets(5,5,5,5);




        add(panel);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


}
