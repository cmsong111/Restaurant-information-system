package Pages;

import Components.StoreComponent;
import DTO.StoreDTO;
import HTTP.StoreHTTP;
import Setting.SingleTon;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AdminPage extends JFrame implements ActionListener, ListSelectionListener {
JScrollPane scrollPane;
StoreComponent renderer;
StoreModel listvalues;
StoreHTTP httpStore=new StoreHTTP();
StoreDTO selectedStore;
int index;//선택 리스트 인덱스
public static ArrayList<StoreDTO> myStores=new ArrayList<>(); //내 가게들
JList list;
    public class StoreModel extends DefaultListModel{ //리스트에 객체추가 , renderer는 StoreComponent
        public StoreModel(){
            for(StoreDTO store:MainPage.storeList){
                addElement(store);
            }
        }
    }
    public AdminPage(){
        try{
            AdminPage();
        } catch (Exception e){
        }
    }

    public void AdminPage(){
        set_storeList(); //가게 목록 불러오기
        setTitle("TestMain Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("Consolas",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("Consolas",Font.BOLD,30);
        Font mainFont26 = new Font("Consolas",Font.PLAIN,26);
        Font mainFont22 = new Font("Consolas",Font.PLAIN,22);
        Font mainFont18 = new Font("Consolas",Font.PLAIN,18);

        Color mint = new Color(62,185,180); //색상 정하기
        Color gray1 = new Color(192,192,192);
        Color darkMode = new Color(43,43,43);
        Color darkModeBack = new Color(60,63,65);
        Color darkModeText = new Color(135,147,154);

        JLabel mainLabel = new JLabel("Restaurant Information System");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(282,30,700,70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);
        mainLabel.setForeground(Color.white);

        JLabel labelAdmin = new JLabel("-Admin Page-");
        labelAdmin.setHorizontalAlignment(JLabel.CENTER);
        labelAdmin.setBounds(382,95,500,100);
        labelAdmin.setFont(mainFont30);
        labelAdmin.setForeground(darkModeText);

        listvalues=new StoreModel();
        renderer=new StoreComponent();
        list=new JList(listvalues);
        list.setCellRenderer(renderer);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        list.setVisibleRowCount(MainPage.storeList.size());
        list.setFixedCellWidth(500); //컴포넌트 너비
        list.setFixedCellHeight(100); //컴포넌트 높이
        list.addListSelectionListener(this);

        scrollPane=new JScrollPane(list); //리스트 패널
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(620,350));
        scrollPane.setBounds(352, 190, 570, 280);
        getContentPane().add(scrollPane);
        //panelMainWhite2.add(scrollPane);

        JButton createStoreButton = new JButton("Create Store");
        createStoreButton.setBounds(220, 500, 180, 40);
        createStoreButton.setFont(mainFont22);
        createStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //createStoreButton.setContentAreaFilled(false);
        createStoreButton.setFocusPainted(false);
        createStoreButton.setForeground(darkModeText);
        createStoreButton.setBackground(darkModeBack);
        createStoreButton.setActionCommand("CreateStore");
        createStoreButton.addActionListener(this);

        JButton updateStoreButton = new JButton("Update Store");
        updateStoreButton.setBounds(440, 500, 180, 40);
        updateStoreButton.setFont(mainFont22);
        updateStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateStoreButton.setContentAreaFilled(false);
        updateStoreButton.setFocusPainted(false);
        updateStoreButton.setForeground(darkModeText);
        updateStoreButton.setBackground(darkModeBack);
        updateStoreButton.setActionCommand("UpdateStore");
        updateStoreButton.addActionListener(this);

        JButton myStoreButton = new JButton("My StorePage");
        myStoreButton.setBounds(660, 500, 180, 40);
        myStoreButton.setFont(mainFont22);
        myStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //updateStoreButton.setContentAreaFilled(false);
        myStoreButton.setFocusPainted(false);
        myStoreButton.setForeground(darkModeText);
        myStoreButton.setBackground(darkModeBack);
        myStoreButton.setActionCommand("My StorePage");
        myStoreButton.addActionListener(this);

        JButton deleteStoreButton = new JButton("Delete Store");
        deleteStoreButton.setBounds(880, 500, 180, 40);
        deleteStoreButton.setFont(mainFont22);
        deleteStoreButton.setBorderPainted(false);      //버튼 테두리 없에기
        //deleteStoreButton.setContentAreaFilled(false);
        deleteStoreButton.setFocusPainted(false);
        deleteStoreButton.setForeground(darkModeText);
        deleteStoreButton.setBackground(darkModeBack);
        deleteStoreButton.setActionCommand("DeleteStore");
        deleteStoreButton.addActionListener(this);

        JButton buttonExit = new JButton("Exit AdminPage");
        buttonExit.setBounds(527,560,210,40);
        buttonExit.setFont(mainFont22);
        buttonExit.setBorderPainted(false);         //버튼 테두리 없에기
        //buttonExit.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonExit.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonExit.setForeground(darkModeText);
        buttonExit.setBackground(darkModeBack);
        buttonExit.setActionCommand("ExitAdminPage");
        buttonExit.addActionListener(this);

        getContentPane().add(labelAdmin);
        getContentPane().add(createStoreButton);
        getContentPane().add(updateStoreButton);
        getContentPane().add(myStoreButton);
        getContentPane().add(deleteStoreButton);
        getContentPane().add(buttonExit);
        getContentPane().add(mainLabel);
        getContentPane().setBackground(darkMode);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("CreateStore")) {
            dispose();
            AdminCreateStorePage ACSP = new AdminCreateStorePage();
        }
        else if (event.equals("UpdateStore")) {
            dispose();
            AdminUpdateStorePage AUSP = new AdminUpdateStorePage(selectedStore);
        }
        else if (event.equals("My StorePage")) {

            StoreDetail.currentStore=MainPage.storeList.get(index); //가게 정보 넘김
            dispose();
            StoreDetail SD = new StoreDetail();
        }
        else if (event.equals("DeleteStore")) {
            dispose();
            AdminDeleteStorePage ADSP = new AdminDeleteStorePage(selectedStore);
        }
        else if(event.equals("ExitAdminPage")){
            dispose();
            
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e){
        index = list.getSelectedIndex();
        selectedStore=MainPage.storeList.get(index);

    }
    public void set_storeList(){
        try {
            MainPage.storeList = (httpStore.readStoreByUPK(SingleTon.getUser().getUpk()));
            //반환값이 여러개임
        } catch (Exception t) {}
        if(MainPage.storeList.size()==0){
        JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");}
    }
}

