package org.example.view.store;

import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.store.StoreHeaderDto;
import org.example.data.repository.local_repository.UserLocalRepository;
import org.example.data.repository.remote_repository.RetrofitProvider;
import org.example.data.repository.remote_repository.StoreRemoteRepository;
import org.example.view.components.StoreComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

@Slf4j
public class StoreList extends JFrame implements ActionListener, ListSelectionListener {

    JList list;
    JPanel panelMainWhite;
    JPanel panelMainWhite2;
    JPanel panelMainMint;
    JLabel mainLabel;
    JLabel labelSearch;
    StoreModel listvalues;
    StoreComponent renderer;
    JScrollPane scrollPane;
    JButton buttonBack;

    List<StoreHeaderDto> storeList;
    StoreRemoteRepository storeRemoteRepository = RetrofitProvider.INSTANCE.getStoreRetrofit();


    public StoreList() {
        try {
            Response<List<StoreHeaderDto>> response = storeRemoteRepository.getStoreList(UserLocalRepository.INSTANCE.getLocation().getLatitude(), UserLocalRepository.INSTANCE.getLocation().getLongitude(), null, null).execute();
            if (response.isSuccessful()) {
                storeList = response.body();
            } else{
                log.error("Failed to get store list: {}", response.errorBody().string());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("StoreListPage");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Font mainFont40 = new Font("배달의민족 도현", Font.PLAIN, 40);   //폰트 설정
        Font mainFont30 = new Font("배달의민족 도현", Font.PLAIN, 30);
        Font mainFont26 = new Font("배달의민족 도현", Font.PLAIN, 26);
        Font mainFont22 = new Font("배달의민족 도현", Font.PLAIN, 22);
        Font mainFont18 = new Font("배달의민족 도현", Font.PLAIN, 18);

        Color mint = new Color(62, 185, 180); //색상 정하기
        Color gray1 = new Color(192, 192, 192);

        panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30, 30, 1204, 614);
        panelMainWhite.setBackground(Color.white);

        panelMainWhite2 = new JPanel();
        panelMainWhite2.setBounds(322, 190, 620, 350);
        panelMainWhite2.setBackground(Color.white);


        panelMainMint = new JPanel();
        panelMainMint.setBounds(322, 30, 620, 80);
        panelMainMint.setBackground(mint);

        mainLabel = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(382, 30, 500, 70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);

        labelSearch = new JLabel("-관련 검색 결과-");
        labelSearch.setHorizontalAlignment(JLabel.CENTER);
        labelSearch.setBounds(382, 100, 500, 100);
        labelSearch.setFont(mainFont26);

        //리스트 생성
        listvalues = new StoreModel();
        renderer = new StoreComponent();
        list = new JList(listvalues);
        list.setCellRenderer(renderer);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        // TODO: Fix
//        list.setVisibleRowCount(MainPage.storeList.size());

        list.setFixedCellWidth(500); //컴포넌트 너비
        list.setFixedCellHeight(100); //컴포넌트 높이
        list.addListSelectionListener(this);

        //스크롤패널 생성
        scrollPane = new JScrollPane(list); //리스트 패널
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(620, 350));
        scrollPane.setBounds(352, 190, 570, 100);
        getContentPane().add(panelMainWhite2);
        panelMainWhite2.add(scrollPane);

        buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572, 560, 120, 30);
        buttonBack.setFont(mainFont22);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);


        getContentPane().add(labelSearch);
        getContentPane().add(buttonBack);
        getContentPane().add(mainLabel);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if (event.equals("BackPage")) {
            dispose();
            new MainPage();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = list.getSelectedIndex();
        if (index != -1) {
            StoreHeaderDto store = (StoreHeaderDto) listvalues.getElementAt(index);
            dispose();
            new StoreDetail(store.getId());
        }
    }

    public class StoreModel extends DefaultListModel { //리스트에 객체추가 , renderer는 StoreComponent
        public StoreModel() {
            for (StoreHeaderDto store : storeList) {
                addElement(store);
            }
        }
    }
}
