package Pages;

import HTTP.ReviewHTTP;
import HTTP.ServerHTTP;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class SuperAdminPage extends JFrame implements ActionListener{
    ServerHTTP server=new ServerHTTP();
    String result;
    public SuperAdminPage(){
        try{
            SuperAdminPage();
        } catch (Exception e){
        }
    }

    public void SuperAdminPage(){
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JLabel labelAdmin = new JLabel("-Admin Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,100,500,100);
        labelAdmin.setFont(mainFont26);
        labelAdmin.setBounds(382,95,500,100);
        labelAdmin.setFont(mainFont30);
        labelAdmin.setForeground(darkModeText);

        JButton updateKidsButton = new JButton("Update Kids");      //아동급식카드 정보
        updateKidsButton.setBounds(542, 200, 180, 40);
        updateKidsButton.setFont(mainFont22);
        updateKidsButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateKidsButton.setContentAreaFilled(false);
        updateKidsButton.setFocusPainted(false);
        updateKidsButton.setForeground(darkModeText);
        updateKidsButton.setBackground(darkModeBack);
        updateKidsButton.setActionCommand("UpdateKids");
        updateKidsButton.addActionListener(this);

        JButton updatePriceButton = new JButton("Update Price");    //착한가격 정보
        updatePriceButton.setBounds(542, 300, 180, 40);
        updatePriceButton.setFont(mainFont22);
        updatePriceButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updatePriceButton.setContentAreaFilled(false);
        updatePriceButton.setFocusPainted(false);
        updatePriceButton.setForeground(darkModeText);
        updatePriceButton.setBackground(darkModeBack);
        updatePriceButton.setActionCommand("UpdatePrice");
        updatePriceButton.addActionListener(this);

        JButton updateTastyButton = new JButton("Update Tasty");    //맛집 정보
        updateTastyButton.setBounds(542, 400, 180, 40);
        updateTastyButton.setFont(mainFont22);
        updateTastyButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateTastyButton.setContentAreaFilled(false);
        updateTastyButton.setFocusPainted(false);
        updateTastyButton.setForeground(darkModeText);
        updateTastyButton.setBackground(darkModeBack);
        updateTastyButton.setActionCommand("UpdateTasty");
        updateTastyButton.addActionListener(this);

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
        getContentPane().add(updateKidsButton);
        getContentPane().add(updatePriceButton);
        getContentPane().add(updateTastyButton);
        getContentPane().add(buttonExit);

        getContentPane().add(mainLabel);
        getContentPane().setBackground(darkMode);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("UpdateKids")) {
            try{
            result=server.updateKids();}
            catch (IOException t){}
            if(!result.equals(null)){
                JOptionPane.showMessageDialog(null, "아동급식 가맹점 갱신 완료");
            }
            else{
                JOptionPane.showMessageDialog(null, "아동급식 가맹점 갱신 실패");
            }

        }
        if (event.equals("UpdatePrice")) {
            try{
                result=server.updatePrice();}
            catch (IOException t){}
            if(!result.equals(null)){
                JOptionPane.showMessageDialog(null, "착한가격 대상 지점 갱신 완료");
            }
            else{
                JOptionPane.showMessageDialog(null, "착한가격 대상 지점 갱신 실패");
            }
        }
        if (event.equals("UpdateTasty")) {
            try{
                result=server.updateTasty();}
            catch (IOException t){}
            if(!result.equals(null)){
                JOptionPane.showMessageDialog(null, "지역맛집 리스트 갱신 완료");
            }
            else{
                JOptionPane.showMessageDialog(null, "지역맛집 리스트 갱신 실패");
            }
        }
        if(event.equals("ExitAdminPage")){
            dispose();
            MainPage MP=new MainPage();
        }
    }
}