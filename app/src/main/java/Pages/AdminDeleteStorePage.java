package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminDeleteStorePage extends JFrame implements ActionListener{

    public AdminDeleteStorePage(){
        try{
            AdminDeleteStorePage();
        } catch (Exception e){
        }
    }
    public void AdminDeleteStorePage(){
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

        JLabel labelAdmin = new JLabel("-Admin Store Delete Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,100,500,100);
        labelAdmin.setFont(mainFont26);
        labelAdmin.setForeground(darkModeText);


        JButton deleteStoreButton = new JButton("Delete Store");
        deleteStoreButton.setBounds(542, 500, 180, 40);
        deleteStoreButton.setFont(mainFont22);
        deleteStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //deleteStoreButton.setContentAreaFilled(false);
        deleteStoreButton.setFocusPainted(false);
        deleteStoreButton.setForeground(darkModeText);
        deleteStoreButton.setBackground(darkModeBack);
        deleteStoreButton.setActionCommand("DeleteStore");
        deleteStoreButton.addActionListener(this);

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

        getContentPane().add(labelAdmin);
        getContentPane().add(labelAdmin);
        getContentPane().add(deleteStoreButton);
        getContentPane().add(buttonBack);

        getContentPane().add(mainLabel);
        getContentPane().setBackground(darkMode);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("DeleteStore")) {

        }
        if (event.equals("BackPage")) {
            this.setVisible(false);
        }

    }
}