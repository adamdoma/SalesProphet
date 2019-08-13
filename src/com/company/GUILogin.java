package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUILogin extends JFrame {
    private JButton btnLogIn, btnBack;
    private JLabel lblUserName, lblPassword;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JPanel panel = new JPanel();
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();

    public GUILogin(){
        btnLogIn = new JButton("LOGIN");
        btnBack = new JButton("BACK");
        lblUserName = new JLabel("USER NAME");
        lblPassword = new JLabel("PASSWORD");
        tfUsername = new JTextField(20);
        pfPassword = new JPasswordField(20);

        setSize(500,500);
        setLayout(layout);
        panel.setLayout(layout);
        gbc.insets= new Insets(5,5,5,5);

        gbc.gridx=0;
        gbc.gridy=0;
        panel.add(lblUserName,gbc);

        gbc.gridx=1;
        gbc.gridy =0;
        panel.add(tfUsername,gbc);

        gbc.gridx=0;
        gbc.gridy =1;
        panel.add(lblPassword,gbc);

        gbc.gridx=1;
        gbc.gridy =1;
        panel.add(pfPassword,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        panel.add(btnLogIn,gbc);

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.gridx=1;
        gbc.gridy=2;
        panel.add(btnBack,gbc);


        add(panel);

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = tfUsername.getText();
                String passWord = pfPassword.getText();
                HealperClass.Connect();
                HealperClass.Login login;
                String line;
                try{
                    login = new HealperClass.Login(userName,passWord);
                    Gson gson = new Gson();
                    String loginGson = gson.toJson(login);
                    HealperClass.dos.println(loginGson);
                    line = HealperClass.dis.readLine();
                    //System.out.println(line);
                    if(line.equals("true")) {
                        dispose();
                        new GUIHomeScreen();
                    }
                    else {
                        if(line.equals("false"))
                            JOptionPane.showMessageDialog(null, "Invalid Email");
                        else if(line.equals("password"))
                            JOptionPane.showMessageDialog(null, "Invalid Email/Password");
                    }
                }catch (Exception ee){
                    System.out.println("not Good!!!!!!!!!! "+ee.getMessage());
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}
