package Pages;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import  java.awt.event.*;
import java.io.*;


public class MainPage extends Frame implements ActionListener {

    // Title, Search_bar
    private JLabel title=new JLabel();
    private TextField search_bar;
    private String input;

    //MenuButtons & RadioGroup
    private ButtonGroup foodSelect=new ButtonGroup();
    private JRadioButton korean=new JRadioButton("한식");
    private JRadioButton chinese=new JRadioButton("중식");
    private JRadioButton japanese=new JRadioButton("일식");
    private JRadioButton dessert=new JRadioButton("디저트");
    private JRadioButton fastFood=new JRadioButton("패스트푸드");
    private JRadioButton snackFood=new JRadioButton("분식");

    // additional search options
    private JCheckBox dongBaek=new JCheckBox("동백전");
    private JCheckBox forChild=new JCheckBox("아동급식카드");
    private JCheckBox zeroPay=new JCheckBox("제로페이");

    // SearchButton and Menu_recommendation
    private Button search=new Button();
    private Button todayMenu= new Button();

    private Font f=new Font("맑은 고딕", Font.BOLD, 50);
    /*private  Font f;*/
    private InputStream fontSet;

    public MainPage(){
        try{
            Init();
           /* fontSet = new BufferedInputStream(
                    new FileInputStream("BMJUA.ttf"));*/
        }catch (Exception e){e.printStackTrace();}


    }
    public void Init() throws Exception{

        /*f=Font.createFont(Font.TRUETYPE_FONT,fontSet);*/
        this.setResizable(false);
        this.setTitle("오늘점심뭐먹지?");
        this.setBackground(Color.white);
        this.setBounds(0,0,1300,700);
        this.setVisible(true); // 창을 보여줄떄 true, 숨길때 false

        Container pane=new Container();
        pane.setLayout(null);

        title.setText("오늘 점심 뭐먹지?");
        title.setFont(f);
        title.setSize(500,50);
        title.setLocation(1300/2-250,50);


        search_bar=new TextField();
        search_bar.setSize(500,30);
        search_bar.setLocation(1300/2-300,150);
        pane.add(search_bar);

        korean.setActionCommand("kFood");
        korean.addActionListener(this);
        korean.setBackground(Color.cyan);
        korean.setSize(100,60);
        korean.setLocation(1300/2-250,250);
        foodSelect.add(korean);
        pane.add(korean);

        chinese.setActionCommand("cFood");
        chinese.addActionListener(this);
        chinese.setBackground(Color.cyan);
        chinese.setSize(100,60);
        chinese.setLocation(1300/2-100,250);
        foodSelect.add(chinese);
        pane.add(chinese);

        japanese.setActionCommand("jFood");
        japanese.addActionListener(this);
        japanese.setBackground(Color.cyan);
        japanese.setSize(100,60);
        japanese.setLocation(1300/2+50,250);
        foodSelect.add(japanese);
        pane.add(japanese);

        dessert.setActionCommand("dessert");
        dessert.addActionListener(this);
        dessert.setBackground(Color.cyan);
        dessert.setSize(100,60);
        dessert.setLocation(1300/2-250,350);
        foodSelect.add(dessert);
        pane.add(dessert);

        fastFood.setActionCommand("fastFood");
        fastFood.addActionListener(this);
        fastFood.setBackground(Color.cyan);
        fastFood.setSize(100,60);
        fastFood.setLocation(1300/2-100,350);
        foodSelect.add(fastFood);
        pane.add(fastFood);

        snackFood.setActionCommand("snackFood");
        snackFood.addActionListener(this);
        snackFood.setBackground(Color.cyan);
        snackFood.setSize(100,60);
        snackFood.setLocation(1300/2+50,350);
        foodSelect.add(snackFood);
        pane.add(snackFood);

        dongBaek.setActionCommand("dongBaek");
        dongBaek.addActionListener(this);
        dongBaek.setSize(100,50);
        dongBaek.setLocation(1300/2-250, 450);
        pane.add(dongBaek);

        forChild.setActionCommand("forChild");
        forChild.addActionListener(this);
        forChild.setSize(100,50);
        forChild.setLocation(1300/2-100, 450);
        pane.add(forChild);

        zeroPay.setActionCommand("zeroPay");
        zeroPay.addActionListener(this);
        zeroPay.setSize(100,50);
        zeroPay.setLocation(1300/2+50, 450);
        pane.add(zeroPay);

        search.setLabel("LET'S FINDING!");
        search.setActionCommand("search");
        search.addActionListener(this);
        search.setBackground(Color.cyan);
        search.setSize(150,50);
        search.setLocation(1300/2-120, 520);

        todayMenu.setLabel("TODAY'S SPECIAL");
        todayMenu.setActionCommand("todayMenu");
        todayMenu.addActionListener(this);
        todayMenu.setBackground(Color.yellow);
        todayMenu.setSize(300,50);
        todayMenu.setLocation(1300/2-200, 600);

        pane.add(title);  pane.add(search_bar);
        pane.add(search);  pane.add(todayMenu);
        this.add(pane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
