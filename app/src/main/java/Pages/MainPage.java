package Pages;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame{

    public MainPage() {
        try{
           init();
        }catch (Exception e){}
    }
    public void init(){
    setTitle("TestMain Screen");
    setSize(1280, 720);

    setLocationRelativeTo(null);
    getContentPane().setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panelMainWhite = new JPanel();            //배경 만들기
    JPanel panelMainMint = new JPanel();            //+51
    JPanel panelSearch = new JPanel();

        panelMainWhite.setBounds(30,30,1204,614);        //배경 만들기
        panelMainMint.setBounds(332, 30, 600,170);
        panelSearch.setBounds(370,125,524,43);

    Font mainFont40 = new Font("배달의민족 도현",Font.PLAIN,40);   //폰트 설정
    Font mainFont20 = new Font("배달의민족 도현",Font.PLAIN,22);
    Font mainFont30 = new Font("배달의민족 도현",Font.PLAIN,30);


    JLabel mainlabel1 = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
    mainlabel1.setHorizontalAlignment(JLabel.CENTER);

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

        mainlabel1.setBounds(382,34,500,100);
        tx_mainSerach.setBounds(378,125,420,43);
        quickSearch.setBounds(831,130,50,34);
        mainButton_kr.setBounds(411,210,107,100);
        mainButton_ch.setBounds(575,210,107,100);
        mainButton_jp.setBounds(721,210,107,100);
        mainButton_DS.setBounds(406,307,115,100);
        mainButton_FD.setBounds(558,307,140,100);
        mainButton_SB.setBounds(721,307,107,100);
        mainButton_DC.setBounds(406,450,107,34);
        mainButton_CC.setBounds(543,450,170,34);
        mainButton_ZC.setBounds(709,450,130,34);

        mainButton_Search.setBounds(563,503,138,43);
        mainButton_Random.setBounds(502,570,260,53);

        mainlabel1.setFont(mainFont40);         //폰트 설정
        tx_mainSerach.setFont(mainFont30);
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

        panelMainWhite.setBackground(Color.white);
        panelMainMint.setBackground(mint);
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
    getContentPane().add(panelMainMint);
    getContentPane().add(panelMainWhite);


    setResizable(false);    //화면 크기 고정
    setVisible(true);

}
}
