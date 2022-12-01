package Pages;

import DTO.StoreDTO;
import DTO.UserDTO;
import HTTP.StoreHTTP;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public class AdminDeleteStorePage extends JFrame implements ActionListener{
    JTextField textStoreLocation1;
    JTextField textStoreName;
    JTextField textStoreLocation2;
    JTextField textStoreGDNumber;
    JButton createStoreButton;
    JButton buttonBack;
    StoreDTO myStore;

    StoreHTTP updateMine=new StoreHTTP();
    StoreDTO getMyStore;

    public AdminDeleteStorePage(){
        try{
            AdminCreateStorePage();
        } catch (Exception e){
        }
    }

    public void AdminCreateStorePage(){
        setMyStore();
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("Consolas",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("Consolas",Font.PLAIN,30);
        Font mainFont26 = new Font("Consolas",Font.PLAIN,26);
        Font textFont22 = new Font("배달의민족 도현",Font.PLAIN,22);
        Font mainFont22 = new Font("Consolas",Font.PLAIN,22);
        Font mainFont18 = new Font("맑은 고딕",Font.PLAIN,18);
        Font mainFont14 = new Font("맑은 고딕",Font.PLAIN,14);

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

        JLabel labelAdmin = new JLabel("My Store");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,100,500,100);
        labelAdmin.setFont(mainFont26);
        labelAdmin.setForeground(darkModeText);

        textStoreName = new JTextField(getMyStore.getName());
        textStoreName.setBounds(392, 220, 490, 43);
        textStoreName.setFont(textFont22);
        textStoreName.setForeground(gray1);
        textStoreName.setBackground(darkModeBack);
        textStoreName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textStoreLocation1 = new JTextField(getMyStore.getLocation1());
        textStoreLocation1.setBounds(392, 280, 490, 43);
        textStoreLocation1.setFont(textFont22);
        textStoreLocation1.setForeground(gray1);
        textStoreLocation1.setBackground(darkModeBack);
        textStoreLocation1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textStoreLocation2 = new JTextField(getMyStore.getLocation2());
        textStoreLocation2.setBounds(392, 340, 490, 43);
        textStoreLocation2.setFont(textFont22);
        textStoreLocation2.setForeground(gray1);
        textStoreLocation2.setBackground(darkModeBack);
        textStoreLocation2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textStoreGDNumber = new JTextField(getMyStore.getCall());
        textStoreGDNumber.setBounds(392, 400, 490, 43);
        textStoreGDNumber.setFont(textFont22);
        textStoreGDNumber.setForeground(gray1);
        textStoreGDNumber.setBackground(darkModeBack);
        textStoreGDNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        createStoreButton = new JButton("Delete Store");
        createStoreButton.setBounds(542, 500, 180, 40);
        createStoreButton.setFont(mainFont22);
        createStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //createStoreButton.setContentAreaFilled(false);
        createStoreButton.setFocusPainted(false);
        createStoreButton.setForeground(darkModeText);
        createStoreButton.setBackground(darkModeBack);
        createStoreButton.setActionCommand("DeleteStore");
        createStoreButton.addActionListener(this);

        buttonBack = new JButton("Cancel");
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

        JPanel panelLocation1 = new JPanel();
        panelLocation1.setBounds(382, 280, 100, 43);
        panelLocation1.setBackground(darkModeBack);

        JPanel panelLocation2 = new JPanel();
        panelLocation2.setBounds(382, 340, 100, 43);
        panelLocation2.setBackground(darkModeBack);

        JPanel panelGDNumber = new JPanel();
        panelGDNumber.setBounds(382, 400, 100, 43);
        panelGDNumber.setBackground(darkModeBack);
        getContentPane().setBackground(darkMode);

        getContentPane().add(textStoreGDNumber);
        getContentPane().add(textStoreName);
        getContentPane().add(textStoreLocation1);
        getContentPane().add(textStoreLocation2);
        getContentPane().add(labelAdmin);
        getContentPane().add(createStoreButton);
        getContentPane().add(buttonBack);
        getContentPane().add(panelName);
        getContentPane().add(panelLocation1);
        getContentPane().add(panelLocation2);
        getContentPane().add(panelGDNumber);
        getContentPane().add(mainLabel);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("DeleteStore")) {
            StoreDTO erase = StoreDTO.builder()
                    .upk(SingleTon.getUser().getUpk())
                    .spk(getMyStore.getSpk())
                    .build();
            try {
                updateMine.deleteStore(erase);
                JOptionPane.showMessageDialog(null, "Store "+textStoreName.getText()+" 삭제되었습니다");
                dispose();
            } catch (IOException t) {}


        }
        else if (event.equals("BackPage")) {
            dispose();
        }
    }

    public void setMyStore(){
        try {
            getMyStore = updateMine.readStoreBySPK(SingleTon.getUser().getSpk().get(0));
            if(getMyStore==null){
                JOptionPane.showMessageDialog(null, "가게 정보가 없습니다");
                dispose();
            }
        }catch (Exception e){}
    }
}