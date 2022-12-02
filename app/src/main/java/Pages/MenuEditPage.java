package Pages;

import DTO.MenuDTO;
import HTTP.MenuHTTP;
import Setting.SingleTon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class MenuEditPage extends JFrame implements ActionListener {
    JTextArea menuName;
    JTextArea menuPrice;
    MenuHTTP myMenu=new MenuHTTP();
    MenuDTO updatedMenu;
    MenuDTO selectedMenu;
    //static ReviewDTO originReview;
    public MenuEditPage(MenuDTO menu){
        try{
            MenuEditPage(menu);
        } catch (Exception e){
        }
    }
    public void MenuEditPage(MenuDTO menu){
        this.selectedMenu=menu;
        setTitle("MenuEditPage");
        setSize(1280,720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        mainLabel.setBounds(382,30,500,70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);

        JLabel labelStore = new JLabel("EDIT");
        labelStore.setHorizontalAlignment(JLabel.CENTER);
        labelStore.setBounds(382,100,500,100);
        labelStore.setFont(mainFont22);

        JPanel backPane=new JPanel();
        backPane.setBounds(480,230,400,120);
        backPane.setBackground(Color.LIGHT_GRAY);
        GridLayout layout=new GridLayout(2,2);
        backPane.setLayout(layout);
        menuName = new JTextArea(selectedMenu.getName());
        //menuName.setBounds(100,100,200,100);
        menuName.setFont(mainFont22);
        menuName.setForeground(gray1);
        backPane.add(menuName);


        menuPrice = new JTextArea(Integer.toString(selectedMenu.getPrice()));
        //menuPrice.setBounds(288,238,688,240);
        menuPrice.setFont(mainFont22);
        menuPrice.setForeground(gray1);
        backPane.add(menuPrice);

        JPanel imagePane=new JPanel();
        imagePane.setBounds(360,230,120,120);
        imagePane.setBackground(Color.LIGHT_GRAY);

        JButton updateReview=new JButton("수정");
        updateReview.setBounds(520,510,100,34);
        updateReview.setFont(mainFont22);
        updateReview.setBackground(mint);
        updateReview.setBorderPainted(false);         //버튼 테두리 없에기
        updateReview.setActionCommand("UpdateMenu");
        updateReview.addActionListener(this);

        JButton deleteReview=new JButton("삭제");
        deleteReview.setBounds(630,510,100,34);
        deleteReview.setFont(mainFont22);
        deleteReview.setBackground(mint);
        deleteReview.setBorderPainted(false);         //버튼 테두리 없에기
        deleteReview.setActionCommand("DeleteMenu");
        deleteReview.addActionListener(this);

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        getContentPane().add(buttonBack);
        getContentPane().add(labelStore);
        getContentPane().add(updateReview);
        getContentPane().add(deleteReview);
        getContentPane().add(mainLabel);
        getContentPane().add(backPane);
        getContentPane().add(imagePane);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();
        int updatedprice = Integer.parseInt(menuPrice.getText());

        if (event.equals("UpdateMenu")) {
            try {
                MenuDTO menu = MenuDTO.builder()
                        .name(menuName.getText())
                        .price(updatedprice)
                        .build();
                updatedMenu = myMenu.updateMenu(menu);
            } catch (IOException t) {}
            if (updatedMenu != null) {
                JOptionPane.showMessageDialog(null, "메뉴 정보가 수정되었습니다.");
                dispose();
                StoreDetail SD = new StoreDetail();
            } else {
                JOptionPane.showMessageDialog(null, "메뉴 업데이트 실패");
            }
        }

        else if (event.equals("BackPage")) {
            dispose();
            StoreDetail SD = new StoreDetail();
        }
    }
}
