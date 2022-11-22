package Pages;

import DTO.UserDTO;
import Setting.SingleTone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import HTTP.LogInHTTP;



public class SignUpPage extends JFrame  {

    UserDTO userDTO;
    LogInHTTP http = new LogInHTTP();

    JTextField textID;
    JTextField textPassWord;
    JTextField tx_Age;
    JButton RegisterButton;
    JTextField textName;


    public SignUpPage(){


        setTitle("SignUpPage");
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

        JLabel pageLabel = new JLabel("-회원가입-");
        pageLabel.setHorizontalAlignment(JLabel.CENTER);
        pageLabel.setBounds(382,120,500,70);         //나머지 페이지들도 적용
        pageLabel.setFont(mainFont30);

        textName = new JTextField("이름");
        textName.setBounds(482,220,300,43);
        textName.setFont(mainFont22);
        textName.setForeground(gray1);
        textName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textID = new JTextField("아이디");
        textID.setBounds(482,280,300,43);
        textID.setFont(mainFont22);
        textID.setForeground(gray1);
        textID.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textPassWord = new JTextField("비밀번호");
        textPassWord.setBounds(482,340,300,43);
        textPassWord.setFont(mainFont22);
        textPassWord.setForeground(gray1);
        textPassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        tx_Age = new JTextField("나이");
        tx_Age.setBounds(482,400,300,43);
        tx_Age.setFont(mainFont22);
        tx_Age.setForeground(gray1);
        tx_Age.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        RegisterButton = new JButton("회원가입");
        RegisterButton.setBounds(563,503,138,43);
        RegisterButton.setFont(mainFont22);
        RegisterButton.setBorderPainted(false);      //버튼 테두리 없에기
        //RegisterButton.setContentAreaFilled(false);
        //RegisterButton.setFocusPainted(false);
        RegisterButton.setForeground(Color.white);
        RegisterButton.setBackground(mint);
        RegisterButton.addActionListener();

        JPanel lineName = new JPanel();
        lineName.setBounds(482,270,300,2);
        JPanel lineID = new JPanel();
        lineID.setBounds(482,330,300,2);
        JPanel linePW = new JPanel();
        linePW.setBounds(482,390,300,2);
        JPanel lineAge = new JPanel();
        linePW.setBounds(482,450,300,2);


        getContentPane().add(pageLabel);
        getContentPane().add(lineName);
        getContentPane().add(lineID);
        getContentPane().add(linePW);
        getContentPane().add(lineAge);

        getContentPane().add(textName);
        getContentPane().add(textPassWord);
        getContentPane().add(textID);
        getContentPane().add(tx_Age);
        getContentPane().add(RegisterButton);
        getContentPane().add(mainLabel);

        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);


        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }


    public void actionPerformed(ActionEvent e) throws IOException {

        userDTO = UserDTO.builder()
                .ID(textID.getText())
                .password(textPassWord.getText())
                .name(textName.getText())
                .age(Integer.parseInt(tx_Age.getText()))
                .build();
        http.create(userDTO);

        if (userDTO != null) {
            System.out.print("d");
            JOptionPane.showMessageDialog(null, "Longin Sucesses.\nhello"+userDTO.getName());
            SingleTone.getInstance().setUser(userDTO);
            this.setVisible(false);
            LoginPage LP=new LoginPage();
        } else {
            JOptionPane.showMessageDialog(null, "fail.");
        }

    }

}
