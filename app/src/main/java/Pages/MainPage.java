package Pages;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame{

    MainPage() {
        try{
           init();
        }catch (Exception e){}
    }
    void init(){
    setTitle("TestMain Screen");
    setSize(1280, 720);

    setLocationRelativeTo(null);
    getContentPane().setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panelMain = new JPanel();            //배경 만들기
    JPanel panelMain2 = new JPanel();
    JPanel panelSearch = new JPanel();

        panelMain.setBounds(30,30,1204,614);        //배경 만들기
        panelMain2.setBounds(281, 30, 593,170);
        panelSearch.setBounds(315,125,524,43);

    Font mainFont40 = new Font("배달의민족 도현",Font.PLAIN,40);   //폰트 설정
    Font mainFont20 = new Font("배달의민족 도현",Font.PLAIN,22);
    Font mainFont30 = new Font("배달의민족 도현",Font.PLAIN,30);


    JLabel mainlabel1 = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
    JTextField tx_mainSerach = new JTextField("상호명 검색");
    JButton quickSearch=new JButton(">");

    JButton mainButton_kr = new JButton("한식", new ImageIcon("app/res/bibimbap.png"));
    mainButton_kr.setVerticalTextPosition(JButton.BOTTOM);
    mainButton_kr.setHorizontalTextPosition(JButton.CENTER);

    JButton mainButton_ch = new JButton("중식",new ImageIcon("app/res/dimsum.png"));
    mainButton_ch.setVerticalTextPosition(JButton.BOTTOM);
    mainButton_ch.setHorizontalTextPosition(JButton.CENTER);

    JButton mainButton_jp = new JButton("일식",new ImageIcon("app/res/sushi.png"));
    mainButton_jp.setVerticalTextPosition(JButton.BOTTOM);
    mainButton_jp.setHorizontalTextPosition(JButton.CENTER);

    JButton mainButton_DS = new JButton("디저트",new ImageIcon("app/res/cake.png"));
    mainButton_DS.setVerticalTextPosition(JButton.BOTTOM);
    mainButton_DS.setHorizontalTextPosition(JButton.CENTER);

    JButton mainButton_FD = new JButton("패스트푸드",new ImageIcon("app/res/fastfood.png"));
    mainButton_FD.setVerticalTextPosition(JButton.BOTTOM);
    mainButton_FD.setHorizontalTextPosition(JButton.CENTER);

    JButton mainButton_SB = new JButton("분식",new ImageIcon("app/res/ramen.png"));
    mainButton_SB.setVerticalTextPosition(JButton.BOTTOM);
    mainButton_SB.setHorizontalTextPosition(JButton.CENTER);


    JButton mainButton_DC = new JButton("동백전");
    JButton mainButton_CC = new JButton("아동급식카드");
    JButton mainButton_ZC = new JButton("제로페이");

    JButton mainButton_Search = new JButton("식당 찾기");
    JButton mainButton_Random = new JButton("오늘의 추천 메뉴");

        tx_mainSerach.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        mainlabel1.setBounds(344,34,500,100);
        tx_mainSerach.setBounds(327,125,420,43);
        quickSearch.setBounds(780,130,50,34);
        mainButton_kr.setBounds(360,210,107,100);
        mainButton_ch.setBounds(524,210,107,100);
        mainButton_jp.setBounds(670,210,107,100);
        mainButton_DS.setBounds(355,307,115,100);
        mainButton_FD.setBounds(507,307,140,100);
        mainButton_SB.setBounds(670,307,107,100);
        mainButton_DC.setBounds(355,450,107,34);
        mainButton_CC.setBounds(492,450,170,34);
        mainButton_ZC.setBounds(658,450,130,34);

        mainButton_Search.setBounds(508,503,138,43);
        mainButton_Random.setBounds(457,570,241,53);


        mainlabel1.setFont(mainFont40);         //폰트 설정
        tx_mainSerach.setFont(mainFont20);
        mainButton_kr.setFont(mainFont20);
        mainButton_ch.setFont(mainFont20);
        mainButton_jp.setFont(mainFont20);
        mainButton_DS.setFont(mainFont20);
        mainButton_FD.setFont(mainFont20);
        mainButton_SB.setFont(mainFont20);
        mainButton_DC.setFont(mainFont20);
        mainButton_CC.setFont(mainFont20);
        mainButton_ZC.setFont(mainFont20);
        mainButton_Search.setFont(mainFont20);
        mainButton_Random.setFont(mainFont30);


        mainButton_kr.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_kr.setContentAreaFilled(false);
    //mainButton_kr.setFocusPainted(false);

        mainButton_ch.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_ch.setContentAreaFilled(false);
    // mainButton_ch.setFocusPainted(false);

        mainButton_jp.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_jp.setContentAreaFilled(false);
    //mainButton_jp.setFocusPainted(false);

        mainButton_DS.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_DS.setContentAreaFilled(false);
    //mainButton_DS.setFocusPainted(false);

        mainButton_FD.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_FD.setContentAreaFilled(false);
    //mainButton_FD.setFocusPainted(false);

        mainButton_SB.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_SB.setContentAreaFilled(false);
    //mainButton_SB.setFocusPainted(false);

        mainButton_DC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_DC.setContentAreaFilled(false);
    //mainButton_DC.setFocusPainted(false);

        mainButton_CC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_CC.setContentAreaFilled(false);
    //mainButton_CC.setFocusPainted(false);

        mainButton_ZC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_ZC.setContentAreaFilled(false);
    //mainButton_ZC.setFocusPainted(false);

        quickSearch.setBorderPainted(false);      //버튼 테두리 없에기
        quickSearch.setContentAreaFilled(false);
        //quickSearch.setFocusPainted(false);

        mainButton_Search.setBorderPainted(false);
        mainButton_Random.setBorderPainted(false);


    Color mint = new Color(62,185,180); //색상 정하기
    Color gray1 = new Color(192,192,192);

        panelMain.setBackground(Color.white);
        panelMain2.setBackground(mint);
        panelSearch.setBackground(Color.white);
        tx_mainSerach.setForeground(gray1);
        mainButton_Search.setBackground(mint);
        mainButton_Random.setForeground(Color.YELLOW);
        mainButton_Random.setBackground(mint);



    getContentPane().setBackground(mint);

    getContentPane().add(mainlabel1);              //pane에 추가
    getContentPane().add(tx_mainSerach);
    getContentPane().add(quickSearch);
    getContentPane().add(mainButton_kr);
    getContentPane().add(mainButton_ch);
    getContentPane().add(mainButton_jp);
    getContentPane().add(mainButton_DS);
    getContentPane().add(mainButton_FD);
    getContentPane().add(mainButton_SB);
    getContentPane().add(mainButton_DC);
    getContentPane().add(mainButton_CC);
    getContentPane().add(mainButton_ZC);
    getContentPane().add(mainButton_Search);
    getContentPane().add(mainButton_Random);
    getContentPane().add(panelSearch);
    getContentPane().add(panelMain2);
    getContentPane().add(panelMain);


    setResizable(false);
    setVisible(true);

}
}
