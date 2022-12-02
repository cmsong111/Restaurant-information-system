package Pages;

import DTO.StoreDTO;
import HTTP.SearchHTTP;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

enum HowSearch {
    SEARCH_BY_NAME,
    SEARCH_KOREAN,
    SEARCH_CHINESE,
    SEARCH_JAPANESE,
    SEARCH_DESSERT,
    SEARCH_SNACKFOOD,
    SEARCH_FASTFOOD,
    SEARCH_TODAYSPECIAL
}

public class MainPage extends JFrame implements ActionListener, ItemListener {

    Font mainFont40;
    Font mainFont30;
    Font mainFont20;
    Font searchFont;
    JComboBox<String> selectLocation;
    JTextField textMainSearch; //search_bar
    JButton quickSearch; // bar_button
    JButton mainButton_kr; //한식버튼
    JButton mainButton_ch; //중식버튼
    JButton mainButton_jp; //일식버튼
    JButton mainButton_DS; //디저트버튼
    JButton mainButton_FD; //패스트푸드 버튼
    JButton mainButton_SB; //분식 버튼
    JCheckBox mainButton_DC; // 지역화폐
    JCheckBox mainButton_CC; // 아동급식카드
    JCheckBox mainButton_ZC; // 모범음식점
    HowSearch search_State; // 검색 조건
    StoreDTO store;
    StoreDTO today;
    String selectedlocation="부산진구";
    SearchHTTP httpStore = new SearchHTTP();
    static public ArrayList<StoreDTO> storeList = new ArrayList<>(); //스토어 목록
    //체크박스
    public static boolean local_Currency = false;
    public static boolean forChild = false;
    public static boolean roleModel = false;

    public MainPage() {
        try {
            init();
        } catch (Exception e) {
        }
    }

    public void init() {
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFont40 = new Font("배달의민족 도현", Font.PLAIN, 40);   //폰트 설정
        mainFont30 = new Font("배달의민족 도현", Font.PLAIN, 30);
        mainFont20 = new Font("배달의민족 도현", Font.PLAIN, 22);
        searchFont = new Font("맑은 고딕", Font.BOLD, 22);

        Color mint = new Color(62, 185, 180);
        Color gray1 = new Color(192, 192, 192);


        JPanel panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30, 30, 1204, 614);
        panelMainWhite.setBackground(Color.white);

        JPanel panelMainMint = new JPanel();
        panelMainMint.setBounds(332, 30, 600, 170);
        panelMainMint.setBackground(mint);

        JPanel panelSearch = new JPanel();
        panelSearch.setBounds(370, 125, 524, 43);
        panelSearch.setBackground(Color.white);


        JLabel labelMain = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        labelMain.setBounds(382, 34, 500, 100);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont40);

        String locations[]={"부산진구", "사상구","해운대구","북구", "사하구","남구", "서구","동구","연제구", "중구","기장군","수영구", "금정구","영도구", "강서구"};
        selectLocation=new JComboBox<String>(locations);
        selectLocation.setBounds(370,105,100,20);
        selectLocation.addActionListener(this);
        selectLocation.setActionCommand("location");

        textMainSearch = new JTextField("상호명 검색");
        textMainSearch.setBounds(378, 125, 420, 43);
        textMainSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textMainSearch.setFont(mainFont30);
        textMainSearch.setForeground(gray1);

        quickSearch = new JButton(">");
        quickSearch.setBounds(831, 128, 50, 34);
        quickSearch.setFont(searchFont);
        quickSearch.setBorderPainted(false);      //버튼 테두리 없에기
        quickSearch.setContentAreaFilled(false);
        quickSearch.setActionCommand("bSearch");
        quickSearch.addActionListener(this);
        quickSearch.setFocusPainted(false);

        JButton buttonEditUser = new JButton("개인정보수정");
        buttonEditUser.setBounds(1000, 50, 180, 40);
        buttonEditUser.setVerticalTextPosition(JButton.BOTTOM);
        buttonEditUser.setHorizontalTextPosition(JButton.CENTER);
        buttonEditUser.setFont(mainFont20);
        buttonEditUser.setBorderPainted(false);      //버튼 테두리 없에기
        //buttonEditUser.setContentAreaFilled(false);
        buttonEditUser.setBackground(mint);
        buttonEditUser.setActionCommand("editUser");
        buttonEditUser.addActionListener(this);
        buttonEditUser.setFocusPainted(false);


        mainButton_kr = new JButton("한식", new ImageIcon("app/res/bibimbap.png"));
        mainButton_kr.setBounds(411, 210, 107, 100);
        mainButton_kr.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_kr.setHorizontalTextPosition(JButton.CENTER);
        mainButton_kr.setFont(mainFont20);
        mainButton_kr.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_kr.setContentAreaFilled(false);
        mainButton_kr.setActionCommand("bKorean");
        mainButton_kr.addActionListener(this);
        //mainButton_kr.setFocusPainted(false);

        mainButton_ch = new JButton("중식", new ImageIcon("app/res/dimsum.png"));
        mainButton_ch.setBounds(575, 210, 107, 100);
        mainButton_ch.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_ch.setHorizontalTextPosition(JButton.CENTER);
        mainButton_ch.setFont(mainFont20);
        mainButton_ch.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_ch.setContentAreaFilled(false);
        mainButton_ch.setActionCommand("bChinese");
        mainButton_ch.addActionListener(this);
        //mainButton_ch.setFocusPainted(false);

        mainButton_jp = new JButton("일식", new ImageIcon("app/res/sushi.png"));
        mainButton_jp.setBounds(721, 210, 107, 100);
        mainButton_jp.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_jp.setHorizontalTextPosition(JButton.CENTER);
        mainButton_jp.setFont(mainFont20);
        mainButton_jp.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_jp.setContentAreaFilled(false);
        mainButton_jp.setActionCommand("bJapanese");
        mainButton_jp.addActionListener(this);
        //mainButton_jp.setFocusPainted(false);

        mainButton_DS = new JButton("제과점", new ImageIcon("app/res/cake.png"));
        mainButton_DS.setBounds(406, 307, 115, 100);
        mainButton_DS.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_DS.setHorizontalTextPosition(JButton.CENTER);
        mainButton_DS.setFont(mainFont20);
        mainButton_DS.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_DS.setContentAreaFilled(false);
        mainButton_DS.setActionCommand("bDessert");
        mainButton_DS.addActionListener(this);
        //mainButton_DS.setFocusPainted(false);

        mainButton_FD = new JButton("패스트푸드", new ImageIcon("app/res/fastfood.png"));
        mainButton_FD.setBounds(558, 307, 140, 100);
        mainButton_FD.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_FD.setHorizontalTextPosition(JButton.CENTER);
        mainButton_FD.setFont(mainFont20);
        mainButton_FD.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_FD.setContentAreaFilled(false);
        mainButton_FD.setActionCommand("bFastfood");
        mainButton_FD.addActionListener(this);
        //mainButton_FD.setFocusPainted(false);

        mainButton_SB = new JButton("분식", new ImageIcon("app/res/ramen.png"));
        mainButton_SB.setBounds(721, 307, 107, 100);
        mainButton_SB.setVerticalTextPosition(JButton.BOTTOM);
        mainButton_SB.setHorizontalTextPosition(JButton.CENTER);
        mainButton_SB.setFont(mainFont20);
        mainButton_SB.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_SB.setContentAreaFilled(false);
        mainButton_SB.setActionCommand("bSnackfood");
        mainButton_SB.addActionListener(this);
        //mainButton_SB.setFocusPainted(false);

        mainButton_DC = new JCheckBox("착한가격");
        mainButton_DC.setBounds(406, 450, 110, 34);
        mainButton_DC.setFont(mainFont20);
        mainButton_DC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_DC.setContentAreaFilled(false);
        mainButton_DC.addItemListener(this);
        //mainButton_DC.setFocusPainted(false);

        mainButton_CC = new JCheckBox("아동급식카드");
        mainButton_CC.setBounds(543, 450, 170, 34);
        mainButton_CC.setFont(mainFont20);
        mainButton_CC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_CC.setContentAreaFilled(false);
        mainButton_CC.addItemListener(this);
        //mainButton_CC.setFocusPainted(false);

        mainButton_ZC = new JCheckBox("모범음식점");
        mainButton_ZC.setBounds(709, 450, 130, 34);
        mainButton_ZC.setFont(mainFont20);
        mainButton_ZC.setBorderPainted(false);      //버튼 테두리 없에기
        mainButton_ZC.setContentAreaFilled(false);
        mainButton_ZC.addItemListener(this);
        //mainButton_ZC.setFocusPainted(false);

        JButton mainButton_Search = new JButton("식당 찾기");
        mainButton_Search.setBounds(563, 503, 138, 43);
        mainButton_Search.setFont(mainFont20);
        mainButton_Search.setBackground(mint);
        mainButton_Search.setBorderPainted(false);
        mainButton_Search.setActionCommand("VIEW_LIST");
        mainButton_Search.addActionListener(this);

        JButton mainButton_Random = new JButton("오늘의 추천 메뉴");
        mainButton_Random.setBounds(502, 570, 260, 53);
        mainButton_Random.setFont(mainFont30);
        mainButton_Random.setForeground(Color.YELLOW);
        mainButton_Random.setBackground(mint);
        mainButton_Random.setBorderPainted(false);
        mainButton_Random.setActionCommand("TODAY'S MENU");
        mainButton_Random.addActionListener(this);

        JButton buttonAdminPage = new JButton("관리자 페이지");
        buttonAdminPage.setBounds(1000, 150, 180, 40);
        buttonAdminPage.setFont(mainFont20);
        buttonAdminPage.setForeground(Color.darkGray);
        buttonAdminPage.setBackground(mint);

        buttonAdminPage.setBorderPainted(false);
        buttonAdminPage.setActionCommand("ViewAdminPage");
        buttonAdminPage.addActionListener(this);
        buttonAdminPage.setVisible(false);      //관리자 페이지 버튼 기본 비활성

        if (SingleTon.getUser().isAdmin() == true) {   //어드민 계정일 경우, 관리자 페이지 버튼 표시
            buttonAdminPage.setVisible(true);
        }

        JButton buttonSuperAdminPage = new JButton("슈퍼 관리자 페이지");
        buttonSuperAdminPage.setBounds(1000, 200, 180, 40);
        buttonSuperAdminPage.setFont(mainFont20);
        buttonSuperAdminPage.setForeground(Color.darkGray);
        buttonSuperAdminPage.setBackground(mint);

        buttonSuperAdminPage.setBorderPainted(false);
        buttonSuperAdminPage.setActionCommand("ViewSuperAdminPage");
        buttonSuperAdminPage.addActionListener(this);
        buttonSuperAdminPage.setVisible(false);      //관리자 페이지 버튼 기본 비활성

        if (SingleTon.getUser().getUpk()==1L) {   //어드민 계정일 경우, 관리자 페이지 버튼 표시
            buttonSuperAdminPage.setVisible(true);
        }

        JButton buttonLogout = new JButton("로그아웃");
        buttonLogout.setBounds(1000, 250, 180, 40);
        buttonLogout.setFont(mainFont20);
        buttonLogout.setForeground(Color.darkGray);
        buttonLogout.setBackground(mint);

        buttonLogout.setBorderPainted(false);
        buttonLogout.setActionCommand("Logout");
        buttonLogout.addActionListener(this);
        buttonLogout.setVisible(true);      //관리자 페이지 버튼 기본 비활성



        getContentPane().setBackground(mint);

        getContentPane().add(labelMain);
        getContentPane().add(textMainSearch);
        getContentPane().add(quickSearch);
        getContentPane().add(selectLocation);
        getContentPane().add(buttonEditUser);

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
        getContentPane().add(buttonAdminPage);
        getContentPane().add(buttonSuperAdminPage);
        getContentPane().add(buttonLogout);

        getContentPane().add(panelSearch);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);


        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        //검색버튼 및 음식 카테고리(라디오버튼)
        switch (event) {
            case "editUser":
                dispose();
                EditUserPage EU = new EditUserPage();
                break;
            case "ViewAdminPage":
                dispose();
                AdminPage AP = new AdminPage();
                break;
            case "ViewSuperAdminPage":
                dispose();
                SuperAdminPage SAP = new SuperAdminPage();
                break;
            case "location":
                selectedlocation=selectLocation.getSelectedItem().toString();
                break;
            case "Logout":
                dispose();
                LoginPage NP = new LoginPage();
                break;
            case "bSearch":
                search_State = HowSearch.SEARCH_BY_NAME;
                Set_Storelist();
                if (this.storeList.size() == 0)
                    JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                else {
                    this.setVisible(false);
                    StoreList SN = new StoreList();
                }
                break;
            case "bKorean":
                search_State = HowSearch.SEARCH_KOREAN;
                break;
            case "bChinese":
                search_State = HowSearch.SEARCH_CHINESE;
                break;
            case "bJapanese":
                search_State = HowSearch.SEARCH_JAPANESE;
                break;
            case "bFastfood":
                search_State = HowSearch.SEARCH_FASTFOOD;
                break;
            case "bDessert":
                search_State = HowSearch.SEARCH_DESSERT;
                break;
            case "bSnackfood":
                search_State = HowSearch.SEARCH_SNACKFOOD;
                break;
            case "VIEW_LIST":
                Set_Storelist();
                if (this.storeList.size() == 0)
                    JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                else {
                    this.setVisible(false);
                    StoreList SN = new StoreList();
                }
                break;

            case "TODAY'S MENU":
                search_State=HowSearch.SEARCH_TODAYSPECIAL;
                Set_Storelist();
                if (today.equals(null))
                    JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                else {
                    StoreDetail.currentStore=today;
                    //this.setVisible(false);
                    StoreDetail SD = new StoreDetail(true);
                }
                break;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //적용할 필터링 선택
        if (e.getSource() == mainButton_ZC) roleModel = (e.getStateChange() == 1) ? true : false;
        else if (e.getSource() == mainButton_CC) forChild = (e.getStateChange() == 1) ? true : false;
        else if (e.getSource() == mainButton_DC) local_Currency = (e.getStateChange() == 1) ? true : false;

    }

    public void Set_Storelist() {
        if (search_State.equals(HowSearch.SEARCH_BY_NAME)) { //이름으로 검색
            try {
                store = StoreDTO.builder()
                        .name(textMainSearch.getText())
                        .location1("부산광역시")
                        .location2(selectedlocation)
                        .build();
                storeList = (httpStore.searchStoreByNameWithLocation(store));
                //반환값이 여러개임
            } catch (IOException t) {
            }
        }
        else if(search_State.equals(HowSearch.SEARCH_TODAYSPECIAL)){
            try {
                 today= (httpStore.searchStoreByLocation("부산광역시",selectedlocation));
                //반환값이 여러개임
            } catch (IOException t) {
            }
        }
        else if(!search_State.equals(HowSearch.SEARCH_BY_NAME)&&!search_State.equals(HowSearch.SEARCH_TODAYSPECIAL)&&roleModel==false&&forChild==false&&local_Currency==false){
            try {
                String temp = "한식";
                if (search_State.equals(HowSearch.SEARCH_KOREAN)) temp = "한식";
                else if (search_State.equals(HowSearch.SEARCH_CHINESE)) temp = "중식";
                else if (search_State.equals(HowSearch.SEARCH_JAPANESE)) temp = "일식";
                else if (search_State.equals(HowSearch.SEARCH_DESSERT)) temp = "제과점";
                else if (search_State.equals(HowSearch.SEARCH_FASTFOOD)) temp = "패스트푸드";
                else if (search_State.equals(HowSearch.SEARCH_SNACKFOOD)) temp = "일반대중음식";
                store = StoreDTO.builder()
                        .location1("부산광역시")
                        .location2(selectedlocation)
                        .category(temp)
                        .build();
                storeList = (httpStore.searchStoreByCategory(store));
                //반환값이 여러개임
            } catch (IOException t) {
            }
        }
        else { //카테고리별 검색
            try {
                String temp = "한식";
                if (search_State.equals(HowSearch.SEARCH_KOREAN)) temp = "한식";
                else if (search_State.equals(HowSearch.SEARCH_CHINESE)) temp = "중식";
                else if (search_State.equals(HowSearch.SEARCH_JAPANESE)) temp = "일식";
                else if (search_State.equals(HowSearch.SEARCH_DESSERT)) temp = "제과점";
                else if (search_State.equals(HowSearch.SEARCH_FASTFOOD)) temp = "패스트푸드";
                else if (search_State.equals(HowSearch.SEARCH_SNACKFOOD)) temp = "일반대중음식";
                store = StoreDTO.builder()
                        .location1("부산광역시")
                        .location2(selectedlocation)
                        .category(temp)
                        .kids(forChild)
                        .roleModel(roleModel)
                        .price(local_Currency)
                        .build();
                storeList = (httpStore.searchStoreByOverall(store));
                //반환값이 여러개임
            } catch (Exception t) {
            }
        }
    }
}
