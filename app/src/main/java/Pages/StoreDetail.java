package Pages;

import Components.ReviewComponent;
import Components.MenuComponent;
import DTO.MenuDTO;
import DTO.ReviewDTO;
import DTO.StoreDTO;
import HTTP.*;
import Setting.SingleTon;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class StoreDetail extends JFrame implements ActionListener{
    JPanel panelMainWhite;
    JPanel panelMainMint;
    JLabel mainLabel;
    JLabel textStoreName;
    JPanel panelLineTap;
    JPanel listPanel1;
    JPanel listPanel2;
    MenuHTTP httpMenu=new MenuHTTP();
    ReviewHTTP httpReview=new ReviewHTTP();
    ArrayList<MenuDTO> allMenus=new ArrayList<>();  //가게 메뉴 저장
    ArrayList<ReviewDTO> allReviews=new ArrayList<>(); //가게 리뷰 저장
    JButton buttonMenu;
    JButton buttonReview;
    JButton buttonBack;
    static StoreDTO currentStore; //현재 선택된 가게 받아오기
    public static ImageIcon storeLogo= new ImageIcon(); //스토어 대표이미지
    JList menuList, reviewList; //리스트
    JScrollPane Mscroll;
    JScrollPane Rscroll;
    StoreInfo storeInfo;
    ReviewInfo reviewInfo;
    MenuComponent menuRenderer; //메뉴 렌더링
    ReviewComponent reviewRenderer; //리뷰 렌더링
    boolean isMaster=false;
    boolean isSpecial=false;
    public class StoreInfo extends DefaultListModel{ //리스트에 객체추가 , renderer는 StoreComponent
        public StoreInfo(){
            for (MenuDTO menu : allMenus) {
                addElement(menu);
            }
        }
    }
    public class ReviewInfo extends DefaultListModel{ //리스트에 객체추가 , renderer는 StoreComponent
        public ReviewInfo(){
            for (ReviewDTO review : allReviews) {
                addElement(review);
            }
        }
    }
    public StoreDetail(){
        try{
            StoreDetailview();
        } catch (Exception e){
        }
    }
    public StoreDetail(StoreDTO store){
        try{
            currentStore=store;
            isSpecial=true;
            StoreDetailview();
        } catch (Exception e){
        }
    }
    public void StoreDetailview(){
        if(currentStore.getUpk().equals(SingleTon.getUser().getUpk())){
            isMaster=true;
        }
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


        panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30,30,1204,614);
        panelMainWhite.setBackground(Color.white);

        listPanel1 = new JPanel();
        listPanel1.setBounds(322, 330, 620, 220);
        listPanel1.setBackground(Color.white);

        listPanel2 = new JPanel();
        listPanel2.setBounds(322, 330, 620, 220);
        listPanel2.setBackground(Color.white);

        panelMainMint = new JPanel();
        panelMainMint.setBounds(322,30,620,80);
        panelMainMint.setBackground(mint);

        mainLabel = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(382,30,500,70);
        mainLabel.setFont(mainFont40);

        textStoreName = new JLabel(currentStore.getName());
        textStoreName.setBounds(482,120,350,43);
        textStoreName.setHorizontalAlignment(JLabel.CENTER);
        textStoreName.setFont(mainFont22);


       /* ImageIcon iconStore =storeLogo;  //이미지 불러오기
        Image imgS1 = iconStore.getImage();
        Image changeImgS1 = imgS1.getScaledInstance(120,120,Image.SCALE_SMOOTH);
        ImageIcon changeIconS1 = new ImageIcon(changeImgS1);
        JLabel labelImageS1 = new JLabel(changeIconS1);
        labelImageS1.setBounds(322, 150, 120, 120);*/

        JLabel textAddress = new JLabel(currentStore.getLocation2()+" "+currentStore.getLocation3());
        textAddress.setBounds(470,160,400,43);
        textAddress.setHorizontalAlignment(JLabel.LEFT);
        textAddress.setFont(mainFont18);

        JButton view_map = new JButton("지도보기");
        view_map.setBounds(850,160,110,30);
        view_map.setFont(mainFont18);
        view_map.setBackground(mint);
        view_map.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonMenu.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        view_map.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        view_map.setActionCommand("Map");
        view_map.addActionListener(this);

        JLabel textGen = new JLabel("전화번호");
        textGen.setBounds(470,190,120,43);
        textGen.setHorizontalAlignment(JLabel.LEFT);
        textGen.setFont(mainFont18);

        JLabel textGenNumber = new JLabel(currentStore.getCall());
        textGenNumber.setBounds(600,190,300,43);
        textGenNumber.setHorizontalAlignment(JLabel.LEFT);
        textGenNumber.setFont(mainFont18);


        panelLineTap = new JPanel();
        panelLineTap.setBounds(322,290,620,1);
        panelLineTap.setBackground(gray1);
        getContentPane().add(panelLineTap);

        if(isMaster) {
            JButton addMenu = new JButton("메뉴 추가");
            addMenu.setBounds(572,550,120,30);
            addMenu.setFont(mainFont18);
            addMenu.setBackground(mint);
            addMenu.setBorderPainted(false);         //버튼 테두리 없에기
            //writeReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
            //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
            addMenu.setActionCommand("AddMenu");
            addMenu.addActionListener(this);
            getContentPane().add(addMenu);
        }
        else {
            JButton writeReview = new JButton("리뷰 작성");
            writeReview.setBounds(572,550,120,30);
            writeReview.setFont(mainFont18);
            writeReview.setBackground(mint);
            writeReview.setBorderPainted(false);         //버튼 테두리 없에기
            //writeReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
            //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
            writeReview.setActionCommand("WriteReview");
            writeReview.addActionListener(this);
            getContentPane().add(writeReview);
        }

        buttonMenu = new JButton("메뉴");
        buttonMenu.setBounds(432, 300, 70, 30);
        buttonMenu.setFont(mainFont18);
        buttonMenu.setBackground(mint);
        buttonMenu.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonMenu.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonMenu.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonMenu.setActionCommand("MenuPage");
        buttonMenu.addActionListener(this);


        buttonReview = new JButton("리뷰");
        buttonReview.setBounds(762, 300, 70, 30);
        buttonReview.setFont(mainFont18);
        buttonReview.setBackground(mint);
        buttonReview.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonReview.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonReview.setActionCommand("ReviewPage");
        buttonReview.addActionListener(this);


        buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,600,120,30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        arraySet();
        createList();
        Mscroll=new JScrollPane(menuList);//리스트 패널
        Mscroll.setPreferredSize(new Dimension(620,200));
        getContentPane().add(listPanel1);
        listPanel1.add(Mscroll);
        listPanel1.setVisible(true);


        Rscroll=new JScrollPane(reviewList);//리스트 패널
        Rscroll.setPreferredSize(new Dimension(620,200));
        getContentPane().add(listPanel2);
        listPanel2.add(Rscroll);
        listPanel2.setVisible(false);


        getContentPane().add(buttonMenu);
        getContentPane().add(buttonReview);
        getContentPane().add(textGenNumber);
        getContentPane().add(textGen);
        getContentPane().add(textAddress);
        getContentPane().add(textStoreName);
        getContentPane().add(buttonBack);
        getContentPane().add(mainLabel);
        //getContentPane().add(labelImageS1);
        getContentPane().add(view_map);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }
    public void arraySet(){
        try {
            System.out.println(currentStore);
            allMenus = httpMenu.readMenu(currentStore);
            allReviews=httpReview.readReviewbyStore(currentStore);
        }catch (Exception e){}
    }
    public void createList(){ //리스트 생성 메서드
        storeInfo=new StoreInfo();
        reviewInfo=new ReviewInfo();
        menuRenderer=new MenuComponent(isMaster);
        reviewRenderer=new ReviewComponent(isMaster);

        menuList=new JList(storeInfo);
        menuList.setCellRenderer(menuRenderer);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        menuList.setVisibleRowCount(allMenus.size());
        menuList.setFixedCellWidth(500); //컴포넌트 너비
        menuList.setFixedCellHeight(100); //컴포넌트 높이
        menuList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int index=menuList.getSelectedIndex();
                    if(isMaster){
                        dispose();
                        if(e.getValueIsAdjusting()){
                            MenuEditPage ME=new MenuEditPage(allMenus.get(index));
                            }
                    }
                }
            });
        reviewList=new JList(reviewInfo);
        reviewList.setCellRenderer(reviewRenderer);
        reviewList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reviewList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        reviewList.setVisibleRowCount(allReviews.size());
        reviewList.setFixedCellWidth(500); //컴포넌트 너비
        reviewList.setFixedCellHeight(100); //컴포넌트 높이
        reviewList.addListSelectionListener(new ListSelectionListener() {
             @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = reviewList.getSelectedIndex();
                long userUpk=SingleTon.getUser().getUpk();
                if(allReviews.get(index).getUpk().equals(userUpk)||isMaster){
                    dispose();
                    if(e.getValueIsAdjusting()){
                        ReviewEditPage RP=new ReviewEditPage(allReviews.get(index));}
                }
        }});

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if (event.equals("MenuPage")) {
            listPanel2.setVisible(false);
            listPanel1.setVisible(true);
            this.repaint();
        }
        else if (event.equals("ReviewPage")) {
            listPanel1.setVisible(false);
            listPanel2.setVisible(true);
            this.repaint();
        }
        else if (event.equals("BackPage")) {
            if(isMaster){
                dispose();
                AdminPage AP=new AdminPage();}
            else if(isSpecial){
                dispose();
                MainPage AP=new MainPage();}

            else{
            dispose();
            StoreList SL=new StoreList();
            SL.setVisible(true);}
        }
        else if(event.equals(("WriteReview"))){
            ReviewPage RP=new ReviewPage();
            this.setVisible(false);
        }
        else if(event.equals(("AddMenu"))){
           dispose();
           MenuAddPage MA=new MenuAddPage(currentStore);
        }
        else if(event.equals("Map")){
            ViewMap VM = new ViewMap();

        }
    }

    }

