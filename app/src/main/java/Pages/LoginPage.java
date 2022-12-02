package Pages;


import DTO.UserDTO;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import HTTP.UserHTTP;

public class LoginPage extends JFrame implements ActionListener {
    JLabel mainlabel1;
    JTextField tx_ID;
    JPasswordField tx_PassWord;
    UserDTO userSingIn;
    UserHTTP httpLogIn = new UserHTTP();
    JButton LoginButton;
    JButton RegisterButton;

    public LoginPage() {
        try {
            init();
        } catch (Exception e) {
        }

    }

    public void init() {
        setTitle("LoginTest Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelMainWhite = new JPanel();            //배경 만들기
        JPanel lineID = new JPanel();
        JPanel linePW = new JPanel();

        panelMainWhite.setBounds(26, 28, 684, 612);        //배경 만들기
        lineID.setBounds(200, 330, 300, 2);
        linePW.setBounds(200, 430, 300, 2);

        Font mainFont40 = new Font("배달의민족 도현", Font.PLAIN, 40);   //폰트 설정
        Font mainFont20 = new Font("배달의민족 도현", Font.PLAIN, 22);
        Font mainFont30 = new Font("배달의민족 도현", Font.PLAIN, 30);
        Font passWordFont = new Font("맑은 고딕",Font.BOLD,22);

        Color mint = new Color(62, 185, 180); //색상 정하기
        Color gray1 = new Color(192, 192, 192);


        mainlabel1 = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainlabel1.setBounds(140, 56, 619, 61);
        mainlabel1.setFont(mainFont40);

        tx_ID = new JTextField("아이디");
        tx_ID.setBounds(200, 280, 300, 43);
        tx_ID.setFont(mainFont20);
        tx_ID.setForeground(gray1);

        tx_PassWord = new JPasswordField("비밀번호");
        tx_PassWord.setBounds(200, 380, 300, 43);
        tx_PassWord.setFont(passWordFont);
        tx_PassWord.setForeground(gray1);

        tx_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tx_PassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        LoginButton = new JButton("로그인");
        LoginButton.setBounds(290, 490, 115, 34);
        LoginButton.setFont(mainFont20);

        LoginButton.setBorderPainted(false);      //버튼 테두리 없에기
        LoginButton.setContentAreaFilled(false);
        //LoginButton.setFocusPainted(false);
        LoginButton.setActionCommand("signIn");
        LoginButton.addActionListener(this);

        RegisterButton = new JButton("회원가입");
        RegisterButton.setBounds(285, 540, 130, 34);
        RegisterButton.setFont(mainFont20);

        RegisterButton.setBorderPainted(false);      //버튼 테두리 없에기
        RegisterButton.setActionCommand("signUp");
        RegisterButton.addActionListener(this);
        //RegisterButton.setContentAreaFilled(false);
        //RegisterButton.setFocusPainted(false);

        panelMainWhite.setBackground(Color.white);
        //linePW.setBackground(gray1);
        //lineID.setBackground(gray1);
        RegisterButton.setForeground(Color.white);
        RegisterButton.setBackground(mint);

        getContentPane().setBackground(mint);

        getContentPane().add(mainlabel1);
        getContentPane().add(tx_ID);
        getContentPane().add(tx_PassWord);
        getContentPane().add(lineID);
        getContentPane().add(linePW);
        getContentPane().add(LoginButton);
        getContentPane().add(RegisterButton);

        getContentPane().add(panelMainWhite);


        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }

    ;

    @Override
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();


        if (event.equals("signIn")) {
            try {
                userSingIn = UserDTO.builder()
                        .id(tx_ID.getText())
                        .password(tx_PassWord.getText())
                        .build();
                SingleTon.setUser(httpLogIn.login(userSingIn));
                System.out.println(SingleTon.getUser().toString());

            }catch (IOException t){}
            catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
            if (SingleTon.getUser().getUpk()!=0L) {

                JOptionPane.showMessageDialog(null, "Welcome. " + SingleTon.getUser().getName());
                this.setVisible(false);
                MainPage LP = new MainPage();

            } else {
                JOptionPane.showMessageDialog(null, "아이디/비밀번호가 일치하지 않습니다");
            }
        } else if (event.equals("signUp")) {
            dispose();
            SignUpPage SP = new SignUpPage();
        }

    }
}

