package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminUpdateStorePage extends JFrame implements ActionListener{
    public AdminUpdateStorePage(){
        try{
            AdminUpdateStorePage();
        } catch (Exception e){
        }
    }

    public void AdminUpdateStorePage(){
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("Consolas",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("Consolas",Font.PLAIN,30);
        Font mainFont26 = new Font("Consolas",Font.PLAIN,26);
        Font mainFont22 = new Font("Consolas",Font.PLAIN,22);
        Font mainFont18 = new Font("Consolas",Font.PLAIN,18);
        Font AdminFont = new Font("Consolas",Font.PLAIN,18);

        Color mint = new Color(62,185,180); //색상 정하기
        Color gray1 = new Color(192,192,192);
        Color darkMode = new Color(43,43,43);
        Color darkModeBack = new Color(60,63,65);
        Color darkModeText = new Color(135,147,154);

        JLabel mainLabel = new JLabel("Restaurant Information System");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(282,30,700,70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);
        mainLabel.setForeground(Color.white);

        JLabel labelAdmin = new JLabel("-Admin Store Update Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,100,500,100);
        labelAdmin.setFont(mainFont26);
        labelAdmin.setForeground(darkModeText);

        JTextField textStoreName = new JTextField("Store Name");
        textStoreName.setBounds(392, 220, 500, 43);
        textStoreName.setFont(mainFont22);
        textStoreName.setForeground(gray1);
        textStoreName.setBackground(darkModeBack);
        textStoreName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JTextField textStoreLocation = new JTextField("Store Location");
        textStoreLocation.setBounds(392, 280, 500, 43);
        textStoreLocation.setFont(mainFont22);
        textStoreLocation.setForeground(gray1);
        textStoreLocation.setBackground(darkModeBack);
        textStoreLocation.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JTextField textStoreGDNumber = new JTextField("Store General Directory Number");
        textStoreGDNumber.setBounds(392, 340, 500, 43);
        textStoreGDNumber.setFont(mainFont22);
        textStoreGDNumber.setForeground(gray1);
        textStoreGDNumber.setBackground(darkModeBack);
        textStoreGDNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());


        JButton updateStoreButton = new JButton("Update Store");
        updateStoreButton.setBounds(542, 500, 180, 40);
        updateStoreButton.setFont(mainFont22);
        updateStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateStoreButton.setContentAreaFilled(false);
        updateStoreButton.setFocusPainted(false);
        updateStoreButton.setForeground(darkModeText);
        updateStoreButton.setBackground(darkModeBack);
        updateStoreButton.setActionCommand("StoreUpdate");
        updateStoreButton.addActionListener(this);

        JButton buttonBack = new JButton("Cancel");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont22);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setForeground(darkModeText);
        buttonBack.setBackground(darkModeBack);
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);


        JPanel panelName = new JPanel();
        panelName.setBounds(382, 220, 100, 43);
        panelName.setBackground(darkModeBack);

        JPanel panelLocation = new JPanel();
        panelLocation.setBounds(382, 280, 100, 43);
        panelLocation.setBackground(darkModeBack);

        JPanel panelGDNumber = new JPanel();
        panelGDNumber.setBounds(382, 340, 100, 43);
        panelGDNumber.setBackground(darkModeBack);

        getContentPane().add(textStoreGDNumber);
        getContentPane().add(textStoreName);
        getContentPane().add(textStoreLocation);

        getContentPane().add(labelAdmin);
        getContentPane().add(updateStoreButton);
        getContentPane().add(buttonBack);

        getContentPane().add(panelName);
        getContentPane().add(panelLocation);
        getContentPane().add(panelGDNumber);

        getContentPane().add(mainLabel);
        getContentPane().setBackground(darkMode);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("UpdateStore")) {

        }
        if (event.equals("BackPage")) {
            this.setVisible(false);
        }

    }
}
