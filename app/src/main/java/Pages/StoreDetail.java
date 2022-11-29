package Pages;

import Components.ReviewComponent;
import Components.StoreComponent;
import DTO.MenuDTO;
import DTO.ReviewDTO;
import DTO.StoreDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreDetail extends JFrame implements ActionListener{
    JPanel panelMainWhite;
    JPanel panelMainMint;
    JLabel mainLabel;
    JLabel textStoreName;
    JPanel panelLineTap;
    ArrayList<MenuDTO> allMenus=new ArrayList<>();  //가게 메뉴 저장
    ArrayList<ReviewDTO> allRevies=new ArrayList<>(); //가게 리뷰 저장
    JButton buttonMenu;
    JButton buttonReview;
    JButton buttonBack;
    btnSelect btnState=btnSelect.MENUS; //버튼선택
    static StoreDTO currentStore; //현재 선택된 가게 받아오기
    JList cpnList; //리스트
    StoreInfo storeInfo;
    MenuComponent menuRenderer; //메뉴 렌더링
    ReviewComponent reviewRenderer; //리뷰 렌더링
    public StoreDetail(){
        try{
            StoreDetail();
        } catch (Exception e){
        }
    }
    enum btnSelect{
        MENUS,
        REVIEWS
    }
    public class StoreInfo extends DefaultListModel{ //리스트에 객체추가 , renderer는 StoreComponent
        public StoreInfo(){
            if(btnState.equals(btnSelect.MENUS)) {
                for (MenuDTO menu : allMenus) {
                    addElement(menu);
                }
            }
            else if(btnState.equals(btnSelect.REVIEWS)){
                for (ReviewDTO review : allRevies) {
                    addElement(review);
                }
            }
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


        panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30,30,1204,614);
        panelMainWhite.setBackground(Color.white);

        panelMainMint = new JPanel();
        panelMainMint.setBounds(322,30,620,80);
        panelMainMint.setBackground(mint);

        mainLabel = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(382,30,500,70);
        mainLabel.setFont(mainFont40);

        textStoreName = new JLabel("STORE NAME");
        textStoreName.setBounds(482,120,300,43);
        textStoreName.setHorizontalAlignment(JLabel.CENTER);
        textStoreName.setFont(mainFont22);

        // TODO:선택 store의 이미지, 이름, 전화번호, 주소
        ///////////////////////////////////////////////////
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
        ///////////////////////////////////////////////////

        panelLineTap = new JPanel();
        panelLineTap.setBounds(322,290,620,1);
        panelLineTap.setBackground(gray1);
        getContentPane().add(panelLineTap);

        buttonMenu = new JButton("메뉴");
        buttonMenu.setBounds(432,300,70,30);
        buttonMenu.setFont(mainFont18);
        buttonMenu.setBackground(mint);
        buttonMenu.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonMenu.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonMenu.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonMenu.setActionCommand("MenuPage");
        buttonMenu.addActionListener(this);

        buttonReview = new JButton("리뷰");
        buttonReview.setBounds(762,300,70,30);
        buttonReview.setFont(mainFont18);
        buttonReview.setBackground(mint);
        buttonReview.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonReview.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonReview.setActionCommand("ReviewPage");
        buttonReview.addActionListener(this);

        buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);


        //리스트 생성
       /* storeInfo=new StoreInfo();
        menuRenderer=new MenuComponent();
        list=new JList(listvalues);
        list.setCellRenderer(renderer);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        list.setVisibleRowCount(MainPage.storeList.size());

        list.setFixedCellWidth(700); //컴포넌트 너비
        list.setFixedCellHeight(100); //컴포넌트 높이

        //스크롤패널 생성
        scrollPane=new JScrollPane(list); //리스트 패널
        scrollPane.setPreferredSize(new Dimension(620,350));
        scrollPane.setBounds(352, 190, 570, 100);*/


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
            btnState=btnSelect.MENUS;
            //TODO:메뉴 DTO작성하여 HTTP요청
        }
        else if (event.equals("ReviewPage")) {
            btnState=btnSelect.REVIEWS;
            //TODO:리뷰 DTO작성하여 HTTP요청
        }
        else if (event.equals("BackPage")) {
            this.setVisible(false);
        }

    }
}
