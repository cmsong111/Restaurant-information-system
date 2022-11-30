package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class EditUserPage extends JFrame implements ActionListener {
    public EditUserPage(){
        try{
            EditUserPage();
        } catch (Exception e){
        }
    }

    public void EditUserPage() {
        setTitle("EditUser Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("배달의민족 도현", Font.PLAIN, 40);   //폰트 설정
        Font mainFont30 = new Font("배달의민족 도현", Font.PLAIN, 30);
        Font mainFont26 = new Font("배달의민족 도현", Font.PLAIN, 26);
        Font mainFont22 = new Font("배달의민족 도현", Font.PLAIN, 22);
        Font mainFont18 = new Font("배달의민족 도현", Font.PLAIN, 18);

        Color mint = new Color(62, 185, 180);   //색상 정하기
        Color gray1 = new Color(192, 192, 192);

        JPanel panelMainWhite = new JPanel();           //배경 만들기
        panelMainWhite.setBounds(30, 30, 1204, 614);
        panelMainWhite.setBackground(Color.white);

        JPanel panelMainMint = new JPanel();
        panelMainMint.setBounds(322,30,620,80);
        panelMainMint.setBackground(mint);

        JLabel labelMain = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setBounds(382,30,500,70);         //나머지 페이지들도 적용
        labelMain.setFont(mainFont40);

        JLabel labelUnderMain = new JLabel("-유저 정보 수정-");
        labelUnderMain.setHorizontalAlignment(JLabel.CENTER);
        labelUnderMain.setBounds(382,100,500,100);
        labelUnderMain.setFont(mainFont26);

        JTextField textName = new JTextField("이름");
        textName.setBounds(482, 220, 300, 43);
        textName.setFont(mainFont22);
        textName.setForeground(gray1);
        textName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JTextField textPassWord = new JTextField("비밀번호");
        textPassWord.setBounds(482, 280, 300, 43);
        textPassWord.setFont(mainFont22);
        textPassWord.setForeground(gray1);
        textPassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JPanel lineName = new JPanel();
        lineName.setBounds(482, 265, 300, 2);
        JPanel linePassWord = new JPanel();
        linePassWord.setBounds(482, 325, 300, 2);

        JCheckBox checkBoxAdmin = new JCheckBox("관리자 지정");
        checkBoxAdmin.setBounds(557, 450, 170, 34);
        checkBoxAdmin.setFont(mainFont22);
        checkBoxAdmin.setBorderPainted(false);      //버튼 테두리 없에기
        //checkBoxAdmin.setFocusPainted(false);
        checkBoxAdmin.setContentAreaFilled(false);
        checkBoxAdmin.setActionCommand("setAdmin");
        checkBoxAdmin.addActionListener(this);

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont22);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        getContentPane().add(labelMain);
        getContentPane().add(labelUnderMain);

        getContentPane().add(textName);
        getContentPane().add(textPassWord);
        getContentPane().add(lineName);
        getContentPane().add(linePassWord);

        getContentPane().add(checkBoxAdmin);
        getContentPane().add(buttonBack);

        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if(event.equals("setAdmin")){

        }
        if(event.equals("BackPage")){
            dispose();
        }
    }
}
