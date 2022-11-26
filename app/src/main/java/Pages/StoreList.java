package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StoreList extends JFrame implements ActionListener{

    public StoreList(){
        try{
            StoreList();
        } catch (Exception e){
        }
    }

    public void StoreList(){
        setTitle("StoreListPage");
        setSize(1280,720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("배달의민족 도현",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("배달의민족 도현",Font.PLAIN,30);
        Font mainFont26 = new Font("배달의민족 도현",Font.PLAIN,26);
        Font mainFont22 = new Font("배달의민족 도현",Font.PLAIN,22);
        Font mainFont18 = new Font("배달의민족 도현",Font.PLAIN,18);

        Color mint = new Color(62,185,180); //색상 정하기
        Color gray1 = new Color(192,192,192);

        JPanel panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30,30,1204,614);
        panelMainWhite.setBackground(Color.white);

        JPanel panelMainMint = new JPanel();
        panelMainMint.setBounds(322,30,620,80);
        panelMainMint.setBackground(mint);

        JLabel mainLabel = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(382,30,500,70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);

        JLabel labelSearch = new JLabel("-관련 검색 결과-");
        labelSearch.setHorizontalAlignment(JLabel.CENTER);
        labelSearch.setBounds(382,100,500,100);
        labelSearch.setFont(mainFont26);


        JLabel labelStore1Name = new JLabel("STORE_STRING1");
        labelStore1Name.setHorizontalAlignment(JLabel.LEFT);
        labelStore1Name.setBounds(482,190,500,43);
        labelStore1Name.setFont(mainFont22);

        JLabel labelStore1Address = new JLabel("ADDRESS_STRING1");
        labelStore1Address.setHorizontalAlignment(JLabel.LEFT);
        labelStore1Address.setBounds(482,230,500,43);
        labelStore1Address.setFont(mainFont18);

        ImageIcon iconStore1 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img1 = iconStore1.getImage();
        Image changeImg1 = img1.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);
        JLabel labelImage1 = new JLabel(changeIcon1);
        labelImage1.setBounds(352, 190, 100, 100);

        JButton buttonStore1 = new JButton();
        buttonStore1.setBounds(352, 190, 570, 100);
        buttonStore1.setFont(mainFont18);
        //buttonStore1.setBorderPainted(false);         //버튼 테두리 없에기
        buttonStore1.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonStore1.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonStore1.setActionCommand("BackPage");
        buttonStore1.addActionListener(this);



        JLabel labelStore2Name = new JLabel("STORE_STRING2");
        labelStore2Name.setHorizontalAlignment(JLabel.LEFT);
        labelStore2Name.setBounds(482,310,500,43);
        labelStore2Name.setFont(mainFont22);

        JLabel labelStore2Address = new JLabel("STRING_ADDRESS2");
        labelStore2Address.setHorizontalAlignment(JLabel.LEFT);
        labelStore2Address.setBounds(482,350,500,43);
        labelStore2Address.setFont(mainFont18);

        ImageIcon iconStore2 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img2 = iconStore2.getImage();
        Image changeImg2 = img2.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);
        JLabel labelImage2 = new JLabel(changeIcon2);
        labelImage2.setBounds(352, 310, 100, 100);

        JButton buttonStore2 = new JButton();
        buttonStore2.setBounds(352, 310, 570, 100);
        buttonStore2.setFont(mainFont18);
        //buttonStore2.setBorderPainted(false);         //버튼 테두리 없에기
        buttonStore2.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonStore2.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonStore2.setActionCommand("Store3");
        buttonStore2.addActionListener(this);



        JLabel labelStore3Name= new JLabel("STORE_STRING3");
        labelStore3Name.setHorizontalAlignment(JLabel.LEFT);
        labelStore3Name.setBounds(482,430,500,43);
        labelStore3Name.setFont(mainFont22);

        JLabel labelStore3Address = new JLabel("ADDRESS_STRING3");
        labelStore3Address.setHorizontalAlignment(JLabel.LEFT);
        labelStore3Address.setBounds(482,470,500,43);
        labelStore3Address.setFont(mainFont18);

        ImageIcon iconStore3 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img3 = iconStore3.getImage();
        Image changeImg3 = img3.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImg3);
        JLabel labelImage3 = new JLabel(changeIcon3);
        labelImage3.setBounds(352, 430, 100, 100);

        JButton buttonStore3 = new JButton();
        buttonStore3.setBounds(352, 430, 570, 100);
        buttonStore3.setFont(mainFont18);
        //buttonStore3.setBorderPainted(false);         //버튼 테두리 없에기
        buttonStore3.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonStore3.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonStore3.setActionCommand("Store3");
        buttonStore3.addActionListener(this);



        JPanel line1 = new JPanel();
        line1.setBounds(352, 295, 570, 2);
        line1.setBackground(gray1);

        JPanel line2 = new JPanel();
        line2.setBounds(352, 415, 570, 2);
        line2.setBackground(gray1);

        JPanel line3 = new JPanel();
        line3.setBounds(352, 535, 570, 2);
        line3.setBackground(gray1);


        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont22);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        getContentPane().add(buttonStore1);
        getContentPane().add(buttonStore2);
        getContentPane().add(buttonStore3);

        getContentPane().add(labelStore1Name);
        getContentPane().add(labelStore1Address);
        getContentPane().add(labelImage1);

        getContentPane().add(labelStore2Name);
        getContentPane().add(labelStore2Address);
        getContentPane().add(labelImage2);

        getContentPane().add(labelStore3Name);
        getContentPane().add(labelStore3Address);
        getContentPane().add(labelImage3);

        getContentPane().add(labelSearch);
        getContentPane().add(buttonBack);
        getContentPane().add(mainLabel);

        getContentPane().add(line1);
        getContentPane().add(line2);
        getContentPane().add(line3);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("Store1")) {
            this.setVisible(false);
        }
        if (event.equals("Store2")) {
            this.setVisible(false);
        }
        if (event.equals("Store3")) {
            this.setVisible(false);
        }
        if (event.equals("BackPage")) {
            this.setVisible(false);
        }
    }
}
