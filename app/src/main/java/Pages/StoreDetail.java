package Pages;

import javax.swing.*;
import java.awt.*;

public class StoreDetail extends JFrame{
    public StoreDetail(){
        setTitle("StoreDetailPage");
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
        mainLabel.setBounds(382,30,500,70);
        mainLabel.setFont(mainFont40);

        JLabel textStoreName = new JLabel("STORE NAME");
        textStoreName.setBounds(482,120,300,43);
        textStoreName.setHorizontalAlignment(JLabel.CENTER);
        textStoreName.setFont(mainFont22);

        JPanel panelIMAGE = new JPanel();
        panelIMAGE.setBounds(322,150,120,120);      //사진 위치 저장
        panelIMAGE.setBackground(mint);
        getContentPane().add(panelIMAGE);

        JLabel textAddress = new JLabel("ADDRESS1234567890");
        textAddress.setBounds(470,160,400,43);
        textAddress.setHorizontalAlignment(JLabel.LEFT);
        textAddress.setFont(mainFont18);

        JLabel textGen = new JLabel("전화번호");
        textGen.setBounds(470,190,120,43);
        textGen.setHorizontalAlignment(JLabel.LEFT);
        textGen.setFont(mainFont18);

        JLabel textGenNumber = new JLabel("000-000-0000");
        textGenNumber.setBounds(600,190,300,43);
        textGenNumber.setHorizontalAlignment(JLabel.LEFT);
        textGenNumber.setFont(mainFont18);

        JPanel panelLineTap = new JPanel();
        panelLineTap.setBounds(322,290,620,1);      //사진 위치 저장
        panelLineTap.setBackground(gray1);
        getContentPane().add(panelLineTap);

        JButton buttonMenu = new JButton("메뉴");
        buttonMenu.setBounds(432,300,70,30);
        buttonMenu.setFont(mainFont18);
        buttonMenu.setBackground(mint);
        buttonMenu.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonMenu.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonMenu.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)

        JButton buttonReview = new JButton("리뷰");
        buttonReview.setBounds(762,300,70,30);
        buttonReview.setFont(mainFont18);
        buttonReview.setBackground(mint);
        buttonReview.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonReview.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)


        getContentPane().add(buttonReview);
        getContentPane().add(buttonMenu);

        getContentPane().add(textGenNumber);
        getContentPane().add(textGen);
        getContentPane().add(textAddress);
        getContentPane().add(textStoreName);
        getContentPane().add(buttonBack);
        getContentPane().add(mainLabel);

        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }
}
