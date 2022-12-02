package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SuperAdminUpdateKidsPage extends JFrame implements ActionListener{
    public SuperAdminUpdateKidsPage(){
        try{
            SuperAdminUpdateKidsPage();
        } catch (Exception e){
        }
    }

    public void SuperAdminUpdateKidsPage(){
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("Consolas",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("Consolas",Font.PLAIN,30);
        Font mainFont26 = new Font("Consolas",Font.PLAIN,26);
        Font textFont22 = new Font("맑은 고딕",Font.PLAIN,22);
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

        JLabel labelAdmin = new JLabel("-Super Admin Update Kids Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,100,500,100);
        labelAdmin.setFont(mainFont26);
        labelAdmin.setForeground(darkModeText);

        JTextField text1 = new JTextField("-----");
        text1.setBounds(392, 220, 500, 43);
        text1.setFont(mainFont22);
        text1.setFont(textFont22);
        text1.setForeground(gray1);
        text1.setBackground(darkModeBack);
        text1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JTextField text2 = new JTextField("-----");
        text2.setBounds(392, 280, 500, 43);
        text2.setFont(mainFont22);
        text2.setFont(textFont22);
        text2.setForeground(gray1);
        text2.setBackground(darkModeBack);
        text2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JTextField text3 = new JTextField("-----");
        text3.setBounds(392, 340, 500, 43);
        text3.setFont(mainFont22);
        text3.setFont(textFont22);
        text3.setForeground(gray1);
        text3.setBackground(darkModeBack);
        text3.setBorder(javax.swing.BorderFactory.createEmptyBorder());


        JButton updateKidsButton = new JButton("Update Kids");
        updateKidsButton.setBounds(542, 500, 180, 40);
        updateKidsButton.setFont(mainFont22);
        updateKidsButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateKidsButton.setContentAreaFilled(false);
        updateKidsButton.setFocusPainted(false);
        updateKidsButton.setForeground(darkModeText);
        updateKidsButton.setBackground(darkModeBack);
        updateKidsButton.setActionCommand("UpdateKids");
        updateKidsButton.addActionListener(this);

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


        JPanel panel1 = new JPanel();
        panel1.setBounds(382, 220, 100, 43);
        panel1.setBackground(darkModeBack);

        JPanel panel2 = new JPanel();
        panel2.setBounds(382, 280, 100, 43);
        panel2.setBackground(darkModeBack);

        JPanel panel3 = new JPanel();
        panel3.setBounds(382, 340, 100, 43);
        panel3.setBackground(darkModeBack);

        getContentPane().add(text1);
        getContentPane().add(text2);
        getContentPane().add(text3);

        getContentPane().add(labelAdmin);
        getContentPane().add(updateKidsButton);
        getContentPane().add(buttonBack);

        getContentPane().add(panel1);
        getContentPane().add(panel2);
        getContentPane().add(panel3);

        getContentPane().add(mainLabel);
        getContentPane().setBackground(darkMode);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("UpdateKids")) {

        }
        if (event.equals("BackPage")) {
            this.setVisible(false);
            dispose();
        }

    }
}
