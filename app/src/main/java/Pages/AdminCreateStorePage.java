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
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AdminCreateStorePage extends JFrame implements ActionListener, ItemListener {
    JTextField textStoreLocation1;
    JTextField textStoreName;
    JTextField textStoreLocation2;
    JTextField textStoreGDNumber;
    JButton createStoreButton;
    JButton buttonBack;
    StoreDTO myStore;
    JComboBox<String> setCategory;
    String[] cate={"--카테고리 설정--","한식", "중식", "일식", "제과점", "패스트푸드", "일반대중음식"};

    JCheckBox resonable_Price; // 착한가격
    JCheckBox forChild; // 아동급식카드
    JCheckBox roleModel; // 모범음식점
    public static boolean resonable = false;
    public static boolean child = false;
    public static boolean model = false;
    StoreHTTP createMine=new StoreHTTP();

    public AdminCreateStorePage(){
        try{
            AdminCreateStorePage();
        } catch (Exception e){
        }
    }

    public void AdminCreateStorePage(){

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

        JLabel labelAdmin = new JLabel("-Admin Store Create Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,100,500,100);
        labelAdmin.setFont(mainFont26);
        labelAdmin.setForeground(darkModeText);

        setCategory=new JComboBox<String>(cate);
        setCategory.setBounds(382,190,200,20);
        setCategory.addActionListener(this);
        setCategory.setActionCommand("location");

        resonable_Price = new JCheckBox("착한가격");
        resonable_Price.setBounds(600, 185, 100, 30);
        resonable_Price.setFont(mainFont14);
        resonable_Price.setForeground(Color.WHITE);
        resonable_Price.setBorderPainted(false);      //버튼 테두리 없에기
        resonable_Price.setContentAreaFilled(false);
        resonable_Price.addItemListener(this);

        forChild = new JCheckBox("아동급식카드");
        forChild.setBounds(685, 185, 120, 30);
        forChild.setFont(mainFont14);
        forChild.setForeground(Color.WHITE);
        forChild.setBorderPainted(false);      //버튼 테두리 없에기
        forChild.setContentAreaFilled(false);
        forChild.addItemListener(this);

        roleModel = new JCheckBox("모범음식점");
        roleModel.setBounds(800, 185, 100, 30);
        roleModel.setFont(mainFont14);
        roleModel.setForeground(Color.WHITE);
        roleModel.setBorderPainted(false);      //버튼 테두리 없에기
        roleModel.setContentAreaFilled(false);
        roleModel.addItemListener(this);

        textStoreName = new JTextField("Store Name");
        textStoreName.setBounds(392, 220, 490, 43);
        textStoreName.setFont(textFont22);
        textStoreName.setForeground(gray1);
        textStoreName.setBackground(darkModeBack);
        textStoreName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textStoreLocation1 = new JTextField("Store Location1");
        textStoreLocation1.setBounds(392, 280, 490, 43);
        textStoreLocation1.setFont(textFont22);
        textStoreLocation1.setForeground(gray1);
        textStoreLocation1.setBackground(darkModeBack);
        textStoreLocation1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textStoreLocation2 = new JTextField("Store Location2");
        textStoreLocation2.setBounds(392, 340, 490, 43);
        textStoreLocation2.setFont(textFont22);
        textStoreLocation2.setForeground(gray1);
        textStoreLocation2.setBackground(darkModeBack);
        textStoreLocation2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textStoreGDNumber = new JTextField("General Directory Number");
        textStoreGDNumber.setBounds(392, 400, 490, 43);
        textStoreGDNumber.setFont(textFont22);
        textStoreGDNumber.setForeground(gray1);
        textStoreGDNumber.setBackground(darkModeBack);
        textStoreGDNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        createStoreButton = new JButton("Create Store");
        createStoreButton.setBounds(542, 500, 180, 40);
        createStoreButton.setFont(mainFont22);
        createStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //createStoreButton.setContentAreaFilled(false);
        createStoreButton.setFocusPainted(false);
        createStoreButton.setForeground(darkModeText);
        createStoreButton.setBackground(darkModeBack);
        createStoreButton.setActionCommand("CreateStore");
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

        getContentPane().add(resonable_Price);
        getContentPane().add(forChild);
        getContentPane().add(roleModel);
        getContentPane().add(textStoreGDNumber);
        getContentPane().add(textStoreName);
        getContentPane().add(textStoreLocation1);
        getContentPane().add(textStoreLocation2);
        getContentPane().add(labelAdmin);
        getContentPane().add(createStoreButton);
        getContentPane().add(buttonBack);
        getContentPane().add(setCategory);
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

        if (event.equals("CreateStore")) {
            StoreDTO mine = StoreDTO.builder()
                    .name(textStoreName.getText())
                    .location1(textStoreLocation1.getText())
                    .location2(textStoreLocation2.getText())
                    .price(resonable)
                    .kids(child)
                    .roleModel(model)
                    .category(setCategory.getSelectedItem().toString())
                    .call(textStoreGDNumber.getText())
                    .upk(SingleTon.getUser().getUpk())
                    .spk(null)
                    .build();
            //System.out.println("유저가 입력한 값: " + UserInput.toString());
            try {
                myStore=createMine.createStore(mine);
            } catch (IOException t) {}

            if (myStore!=null) {
                JOptionPane.showMessageDialog(null, "Store "+textStoreName.getText()+" 생성 성공!");
                SingleTon.getUser().getSpk().add(0,myStore.getSpk());
                AdminPage AP = new AdminPage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "생성 실패");
            }
        }
        else if (event.equals("BackPage")) {
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //적용할 필터링 선택
        if (e.getSource() == resonable_Price) resonable = (e.getStateChange() == 1) ? true : false;
        else if (e.getSource() == forChild) child = (e.getStateChange() == 1) ? true : false;
        else if (e.getSource() == roleModel) model = (e.getStateChange() == 1) ? true : false;

    }
}
