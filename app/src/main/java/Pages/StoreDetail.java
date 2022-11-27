package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreDetail extends JFrame implements ActionListener{
    public StoreDetail(){
        try{
            StoreDetail();
        } catch (Exception e){
        }
    }
    public void StoreDetail(){
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


        ImageIcon iconStore = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image imgS1 = iconStore.getImage();
        Image changeImgS1 = imgS1.getScaledInstance(120,120,Image.SCALE_SMOOTH);
        ImageIcon changeIconS1 = new ImageIcon(changeImgS1);
        JLabel labelImageS1 = new JLabel(changeIconS1);
        labelImageS1.setBounds(322, 150, 120, 120);

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
        panelLineTap.setBounds(322,290,620,1);
        panelLineTap.setBackground(gray1);
        getContentPane().add(panelLineTap);

        JButton buttonMenu = new JButton("메뉴");
        buttonMenu.setBounds(432,300,70,30);
        buttonMenu.setFont(mainFont18);
        buttonMenu.setBackground(mint);
        buttonMenu.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonMenu.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonMenu.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonMenu.setActionCommand("MenuPage");
        buttonMenu.addActionListener(this);

        JButton buttonReview = new JButton("리뷰");
        buttonReview.setBounds(762,300,70,30);
        buttonReview.setFont(mainFont18);
        buttonReview.setBackground(mint);
        buttonReview.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonReview.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonReview.setActionCommand("ReviewPage");
        buttonReview.addActionListener(this);

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        ImageIcon iconMenu1 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img1 = iconMenu1.getImage();
        Image changeImg1 = img1.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);
        JLabel labelImage1 = new JLabel(changeIcon1);
        labelImage1.setBounds(322, 350, 80, 80);

        JLabel labelMenu1 = new JLabel("싸이버거 세트");
        labelMenu1.setBounds(422,350,300,43);
        labelMenu1.setHorizontalAlignment(JLabel.LEFT);
        labelMenu1.setFont(mainFont18);

        JLabel labelMenuCost1 = new JLabel("6,000원");
        labelMenuCost1.setBounds(422,385,300,43);
        labelMenuCost1.setHorizontalAlignment(JLabel.LEFT);
        labelMenuCost1.setFont(mainFont18);


        ImageIcon iconMenu2 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img2 = iconMenu2.getImage();
        Image changeImg2 = img2.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);
        JLabel labelImage2 = new JLabel(changeIcon2);
        labelImage2.setBounds(632, 350, 80, 80);

        JLabel labelMenu2 = new JLabel("MENU2");
        labelMenu2.setBounds(732,350,300,43);
        labelMenu2.setHorizontalAlignment(JLabel.LEFT);
        labelMenu2.setFont(mainFont18);

        JLabel labelMenuCost2 = new JLabel("MENU COST2");
        labelMenuCost2.setBounds(732,385,300,43);
        labelMenuCost2.setHorizontalAlignment(JLabel.LEFT);
        labelMenuCost2.setFont(mainFont18);


        ImageIcon iconMenu3 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img3 = iconMenu3.getImage();
        Image changeImg3 = img3.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImg3);
        JLabel labelImage3 = new JLabel(changeIcon3);
        labelImage3.setBounds(322, 450, 80, 80);

        JLabel labelMenu3 = new JLabel("MENU3");
        labelMenu3.setBounds(422,450,300,43);
        labelMenu3.setHorizontalAlignment(JLabel.LEFT);
        labelMenu3.setFont(mainFont18);

        JLabel labelMenuCost3 = new JLabel("MENU COST3");
        labelMenuCost3.setBounds(422,485,300,43);
        labelMenuCost3.setHorizontalAlignment(JLabel.LEFT);
        labelMenuCost3.setFont(mainFont18);


        ImageIcon iconMenu4 = new ImageIcon("app/res/fastfood.png");  //이미지 불러오기
        Image img4 = iconMenu4.getImage();
        Image changeImg4 = img4.getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon changeIcon4 = new ImageIcon(changeImg4);
        JLabel labelImage4 = new JLabel(changeIcon4);
        labelImage4.setBounds(632, 450, 80, 80);

        JLabel labelMenu4 = new JLabel("MENU4");
        labelMenu4.setBounds(732,450,300,43);
        labelMenu4.setHorizontalAlignment(JLabel.LEFT);
        labelMenu4.setFont(mainFont18);

        JLabel labelMenuCost4 = new JLabel("MENU COST4");
        labelMenuCost4.setBounds(732,485,300,43);
        labelMenuCost4.setHorizontalAlignment(JLabel.LEFT);
        labelMenuCost4.setFont(mainFont18);


        getContentPane().add(labelImage1);
        getContentPane().add(labelImage2);
        getContentPane().add(labelImage3);
        getContentPane().add(labelImage4);

        getContentPane().add(labelMenu1);
        getContentPane().add(labelMenu2);
        getContentPane().add(labelMenu3);
        getContentPane().add(labelMenu4);

        getContentPane().add(labelMenuCost1);
        getContentPane().add(labelMenuCost2);
        getContentPane().add(labelMenuCost3);
        getContentPane().add(labelMenuCost4);

        getContentPane().add(buttonReview);
        getContentPane().add(buttonMenu);

        getContentPane().add(textGenNumber);
        getContentPane().add(textGen);
        getContentPane().add(textAddress);
        getContentPane().add(textStoreName);
        getContentPane().add(buttonBack);
        getContentPane().add(mainLabel);

        getContentPane().add(labelImageS1);

        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("MenuPage")) {

        }
        if (event.equals("ReviewPage")) {

        }
        if (event.equals("BackPage")) {
            this.setVisible(false);
        }

    }
}
