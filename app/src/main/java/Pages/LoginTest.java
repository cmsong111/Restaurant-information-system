package Pages;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTest extends JFrame implements ActionListener {
    JLabel mainlabel1;
    JTextField tx_ID;
    JTextField tx_PassWord;
    JButton LoginButton;
    JButton RegisterButton;
    public LoginTest(){
        try{
            init();
        }catch (Exception e){}

    }
    public void init(){
        setTitle("LoginTest Screen");
        setSize(1280,720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelMainWhite = new JPanel();            //배경 만들기
        JPanel lineID = new JPanel();
        JPanel linePW = new JPanel();

        panelMainWhite.setBounds(26,28,684,612);        //배경 만들기
        lineID.setBounds(200,330,300,2);
        linePW.setBounds(200,430,300,2);



        Font mainFont40 = new Font("배달의민족 도현",Font.PLAIN,40);   //폰트 설정
        Font mainFont20 = new Font("배달의민족 도현",Font.PLAIN,22);
        Font mainFont30 = new Font("배달의민족 도현",Font.PLAIN,30);

        Color mint = new Color(62,185,180); //색상 정하기
        Color gray1 = new Color(192,192,192);


        mainlabel1 = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainlabel1.setBounds(140,56,619,61);
        mainlabel1.setFont(mainFont40);

        tx_ID = new JTextField("아이디");
        tx_ID.setBounds(200,280,300,43);
        tx_ID.setFont(mainFont20);
        tx_ID.setForeground(gray1);

        tx_PassWord = new JTextField("비밀번호");
        tx_PassWord.setBounds(200,380,300,43);
        tx_PassWord.setFont(mainFont20);
        tx_PassWord.setForeground(gray1);

        tx_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tx_PassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        LoginButton = new JButton("로그인");
        LoginButton.setBounds(290,490,115,34);
        LoginButton.setFont(mainFont20);

        LoginButton.setBorderPainted(false);      //버튼 테두리 없에기
        LoginButton.setContentAreaFilled(false);
        //LoginButton.setFocusPainted(false);
        LoginButton.addActionListener(this);

        RegisterButton = new JButton("회원가입");
        RegisterButton.setBounds(285,540,130,34);
        RegisterButton.setFont(mainFont20);

        RegisterButton.setBorderPainted(false);      //버튼 테두리 없에기
        //RegisterButton.setContentAreaFilled(false);
        //RegisterButton.setFocusPainted(false);

        panelMainWhite.setBackground(Color.white);
        lineID.setBackground(gray1);
        linePW.setBackground(gray1);
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
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        MainPage MT=new MainPage();
    }
}

