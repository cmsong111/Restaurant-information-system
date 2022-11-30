package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminPage extends JFrame implements ActionListener{

    public AdminPage(){
        try{
            AdminPage();
        } catch (Exception e){
        }
    }

    public void AdminPage(){
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("Consolas",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("Consolas",Font.BOLD,30);
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

        JLabel labelAdmin = new JLabel("-Admin Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,95,500,100);
        labelAdmin.setFont(mainFont30);
        labelAdmin.setForeground(darkModeText);

        JButton createStoreButton = new JButton("Create Store");
        createStoreButton.setBounds(542, 200, 180, 40);
        createStoreButton.setFont(mainFont22);
        createStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //createStoreButton.setContentAreaFilled(false);
        createStoreButton.setFocusPainted(false);
        createStoreButton.setForeground(darkModeText);
        createStoreButton.setBackground(darkModeBack);
        createStoreButton.setActionCommand("CreateStore");
        createStoreButton.addActionListener(this);

        JButton updateStoreButton = new JButton("Update Store");
        updateStoreButton.setBounds(542, 300, 180, 40);
        updateStoreButton.setFont(mainFont22);
        updateStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateStoreButton.setContentAreaFilled(false);
        updateStoreButton.setFocusPainted(false);
        updateStoreButton.setForeground(darkModeText);
        updateStoreButton.setBackground(darkModeBack);
        updateStoreButton.setActionCommand("UpdateStore");
        updateStoreButton.addActionListener(this);

        JButton deleteStoreButton = new JButton("Delete Store");
        deleteStoreButton.setBounds(542, 400, 180, 40);
        deleteStoreButton.setFont(mainFont22);
        deleteStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //deleteStoreButton.setContentAreaFilled(false);
        deleteStoreButton.setFocusPainted(false);
        deleteStoreButton.setForeground(darkModeText);
        deleteStoreButton.setBackground(darkModeBack);
        deleteStoreButton.setActionCommand("DeleteStore");
        deleteStoreButton.addActionListener(this);

        JButton buttonExit = new JButton("Exit AdminPage");
        buttonExit.setBounds(527,560,210,40);
        buttonExit.setFont(mainFont22);
        buttonExit.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonExit.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonExit.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonExit.setForeground(darkModeText);
        buttonExit.setBackground(darkModeBack);
        buttonExit.setActionCommand("ExitAdminPage");
        buttonExit.addActionListener(this);

        getContentPane().add(labelAdmin);
        getContentPane().add(createStoreButton);
        getContentPane().add(updateStoreButton);
        getContentPane().add(deleteStoreButton);
        getContentPane().add(buttonExit);

        getContentPane().add(mainLabel);
        getContentPane().setBackground(darkMode);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("CreateStore")) {

            AdminCreateStorePage ACSP = new AdminCreateStorePage();
        }
        if (event.equals("UpdateStore")) {

            AdminUpdateStorePage AUSP = new AdminUpdateStorePage();
        }
        if (event.equals("DeleteStore")) {

            AdminDeleteStorePage ADSP = new AdminDeleteStorePage();
        }
        if(event.equals("ExitAdminPage")){
            dispose();
        }
    }
}
