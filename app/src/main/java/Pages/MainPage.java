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

        Font mainFont40 = new Font("배달의민족 도현",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("배달의민족 도현",Font.PLAIN,30);
        Font mainFont20 = new Font("배달의민족 도현",Font.PLAIN,22);
        Font searchFont = new Font("맑은 고딕",Font.BOLD,22);

        Color mint = new Color(62,185,180);
        Color gray1 = new Color(192,192,192);


        JPanel panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30,30,1204,614);
        panelMainWhite.setBackground(Color.white);

        JPanel panelMainMint = new JPanel();
        panelMainMint.setBounds(332, 30, 600,170);
        panelMainMint.setBackground(mint);

        JPanel panelSearch = new JPanel();
        panelSearch.setBounds(370,125,524,43);
        panelSearch.setBackground(Color.white);




        JLabel labelMain = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        labelMain.setBounds(382,34,500,100);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont40);

        JTextField textMainSearch = new JTextField("상호명 검색");
        textMainSearch.setBounds(378,125,420,43);
        textMainSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textMainSearch.setFont(mainFont30);
        textMainSearch.setForeground(gray1);

        JButton quickSearch=new JButton(">");
        quickSearch.setBounds(831,128,50,34);
        quickSearch.setFont(searchFont);
        quickSearch.setBorderPainted(false);      //버튼 테두리 없에기
        quickSearch.setContentAreaFilled(false);
        //quickSearch.setFocusPainted(false);

        JButton mainButton_kr = new JButton("한식", new ImageIcon("app/res/bibimbap.png"));
        mainButton_kr.setBounds(411,210,107,100);
        mainButton_kr.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_kr.setHorizontalTextPosition(JButton.CENTER);
        mainButton_kr.setFont(mainFont20);
        mainButton_kr.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_kr.setContentAreaFilled(false);
        //mainButton_kr.setFocusPainted(false);

        JButton mainButton_ch = new JButton("중식",new ImageIcon("app/res/dimsum.png"));
        mainButton_ch.setBounds(575,210,107,100);
        mainButton_ch.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_ch.setHorizontalTextPosition(JButton.CENTER);
        mainButton_ch.setFont(mainFont20);
        mainButton_ch.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_ch.setContentAreaFilled(false);
        //mainButton_ch.setFocusPainted(false);

        JButton mainButton_jp = new JButton("일식",new ImageIcon("app/res/sushi.png"));
        mainButton_jp.setBounds(721,210,107,100);
        mainButton_jp.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_jp.setHorizontalTextPosition(JButton.CENTER);
        mainButton_jp.setFont(mainFont20);
        mainButton_jp.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_jp.setContentAreaFilled(false);
        //mainButton_jp.setFocusPainted(false);

        JButton mainButton_DS = new JButton("디저트",new ImageIcon("app/res/cake.png"));
        mainButton_DS.setBounds(406,307,115,100);
        mainButton_DS.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_DS.setHorizontalTextPosition(JButton.CENTER);
        mainButton_DS.setFont(mainFont20);
        mainButton_DS.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_DS.setContentAreaFilled(false);
        //mainButton_DS.setFocusPainted(false);

        JButton mainButton_FD = new JButton("패스트푸드",new ImageIcon("app/res/fastfood.png"));
        mainButton_FD.setBounds(558,307,140,100);
        mainButton_FD.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_FD.setHorizontalTextPosition(JButton.CENTER);
        mainButton_FD.setFont(mainFont20);
        mainButton_FD.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_FD.setContentAreaFilled(false);
        //mainButton_FD.setFocusPainted(false);

        JButton mainButton_SB = new JButton("분식",new ImageIcon("app/res/ramen.png"));
        mainButton_SB.setBounds(721,307,107,100);
        mainButton_SB.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_SB.setHorizontalTextPosition(JButton.CENTER);
        mainButton_SB.setFont(mainFont20);
        mainButton_SB.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_SB.setContentAreaFilled(false);
        //mainButton_SB.setFocusPainted(false);

        JButton mainButton_DC = new JButton("동백전");
        mainButton_DC.setBounds(406,450,107,34);
        mainButton_DC.setFont(mainFont20);
        mainButton_DC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_DC.setContentAreaFilled(false);
        //mainButton_DC.setFocusPainted(false);

        JButton mainButton_CC = new JButton("아동급식카드");
        mainButton_CC.setBounds(543,450,170,34);
        mainButton_CC.setFont(mainFont20);
        mainButton_CC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_CC.setContentAreaFilled(false);
        //mainButton_CC.setFocusPainted(false);

        JButton mainButton_ZC = new JButton("제로페이");
        mainButton_ZC.setBounds(709,450,130,34);
        mainButton_ZC.setFont(mainFont20);
        mainButton_ZC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_ZC.setContentAreaFilled(false);
        //mainButton_ZC.setFocusPainted(false);

        JButton mainButton_Search = new JButton("식당 찾기");
        mainButton_Search.setBounds(563,503,138,43);
        mainButton_Search.setFont(mainFont20);
        mainButton_Search.setBackground(mint);
        mainButton_Search.setBorderPainted(false);

        JButton mainButton_Random = new JButton("오늘의 추천 메뉴");
        mainButton_Random.setBounds(502,570,260,53);
        mainButton_Random.setFont(mainFont30);
        mainButton_Random.setForeground(Color.YELLOW);
        mainButton_Random.setBackground(mint);
        mainButton_Random.setBorderPainted(false);



        getContentPane().setBackground(mint);

        getContentPane().add(labelMain);
        getContentPane().add(textMainSearch);
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
