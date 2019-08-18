package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIRegisterForm extends JFrame implements MouseListener,ActionListener {
    private JButton btnRegister,btnBack;
    private JLabel header = new JLabel("Register");
    private JLabel date = new JLabel("Date");
    private JTextField tfId,tfEmail,tfFirstName,tfLastName,tfYear,tfMonth,tfDay;
    private JPanel pnlHeader =new JPanel();
    private JPanel pnlBody = new JPanel();
    private JPanel pnlbuttons = new JPanel();
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();




    public GUIRegisterForm(){
        setLayout(new BorderLayout());

        btnBack = new JButton("BACK");
        btnRegister = new JButton("Register");

        tfEmail = new JTextField("Email",20);
        tfEmail.setFont(new Font("David",Font.BOLD,18));
        tfEmail.setText("");

        tfId = new JTextField("Id",20);
        tfId.setFont(new Font("David",Font.BOLD,18));

        tfFirstName = new JTextField("First Name",20);
        tfFirstName.setFont(new Font("David",Font.BOLD,18));

        tfLastName = new JTextField("Last Name",20);
        tfLastName.setFont(new Font("David",Font.BOLD,18));

        tfYear = new JTextField("Year",4);


        tfMonth = new JTextField("Month",2);
        tfDay = new JTextField("Day",2);
        gbc.insets = new Insets(5,5,5,5);

        //------------Header panel-------------------------
        pnlHeader.setLayout(layout);
        gbc.gridx=0;
        gbc.gridy=0;

        pnlHeader.add(header,gbc);

        pnlHeader.setBackground(Color.cyan);
        pnlHeader.setSize(500,100);

        //--------------body panel-------------------------
        pnlBody.setLayout(layout);
        gbc.gridx = 0;
        gbc.gridy=0;
        pnlBody.add(tfId,gbc);

        gbc.gridx = 0;
        gbc.gridy=1;
        pnlBody.add(tfEmail,gbc);

        gbc.gridx = 0;
        gbc.gridy=2;
        pnlBody.add(tfFirstName,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlBody.add(tfLastName,gbc);



        gbc.ipadx = 40;
        gbc.gridx =0;
        gbc.gridy =4;
        pnlBody.add(tfDay,gbc);

        gbc.ipadx = 40;
        gbc.gridx =0;
        gbc.gridy =5;
        pnlBody.add(tfMonth,gbc);

        gbc.ipadx = 20;
        gbc.gridx =0;
        gbc.gridy =6;
        pnlBody.add(tfYear,gbc);

        pnlBody.setBackground(Color.BLACK);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.ipadx=0;
        gbc.ipady=0;

        //----------Buttons panel-------------------

        gbc.gridx =0;
        gbc.gridy =0;
        pnlbuttons.add(btnRegister,gbc);

        gbc.gridx =1;
        gbc.gridy =0;
        pnlbuttons.add(btnBack);

        pnlbuttons.setBackground(Color.GRAY);


        //------ frame-------------------------------------
        add(pnlHeader,BorderLayout.NORTH);
        add(pnlBody,BorderLayout.CENTER);
        add(pnlbuttons,BorderLayout.SOUTH);

        tfId.addMouseListener(this);
        tfEmail.addMouseListener(this);
        tfFirstName.addMouseListener(this);
        tfLastName.addMouseListener(this);
        tfDay.addMouseListener(this);
        tfMonth.addMouseListener(this);
        tfYear.addMouseListener(this);

        btnRegister.addActionListener(this);
        btnBack.addActionListener(this);

        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTextField [] tf = {tfId,tfEmail,tfFirstName,tfLastName};
        for(int i=0;i<tf.length;i++){
            if(e.getSource()==tf[i]){
                tf[i].setText("");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            dispose();
            new GUILogin();
        }
        if(e.getSource()==btnRegister) {
            JTextField[] tf = {tfId, tfEmail, tfFirstName, tfLastName};
            for (int i = 0; i < tf.length; i++) {
                if (tf[i].getText().equals("")) {
                    JOptionPane.showMessageDialog(tf[i],"Fill all fields");
                    return;
                }
            }
            User user = new User(tfEmail.getText(),tfId.getText(),tfFirstName.getText()
                                ,tfLastName.getText(),Integer.parseInt(tfYear.getText())
                                ,Integer.parseInt(tfMonth.getText())
                                ,Integer.parseInt(tfDay.getText()));
            Gson gson = new Gson();
            String strUser = gson.toJson(user);
        }
    }
}
