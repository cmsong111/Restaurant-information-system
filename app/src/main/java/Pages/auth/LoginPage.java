package Pages.auth;


import DTO.TokenDto;
import DTO.UserInfoDto;
import Pages.MainPage;
import Setting.Auth;
import Setting.Fonts;
import Setting.RetrofitProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 로그인 페이지
 */
public class LoginPage extends JFrame implements ActionListener {
    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    JLabel mainlabel1;
    JTextField tx_ID;
    JPasswordField tx_PassWord;
    JButton LoginButton;
    JButton RegisterButton;

    /**
     * 생성자
     */
    public LoginPage() {
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


        Color mint = new Color(62, 185, 180); //색상 정하기
        Color gray1 = new Color(192, 192, 192);


        mainlabel1 = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainlabel1.setBounds(140, 56, 619, 61);
        mainlabel1.setFont(Fonts.INSTANCE.getMainFont40());

        tx_ID = new JTextField("email");
        tx_ID.setBounds(200, 280, 300, 43);
        tx_ID.setFont(Fonts.INSTANCE.getMainFont20());
        tx_ID.setForeground(gray1);

        tx_PassWord = new JPasswordField("password");
        tx_PassWord.setBounds(200, 380, 300, 43);
        tx_PassWord.setFont(Fonts.INSTANCE.getPassWordFont());
        tx_PassWord.setForeground(gray1);

        tx_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tx_PassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        LoginButton = new JButton("로그인");
        LoginButton.setBounds(290, 490, 115, 34);
        LoginButton.setFont(Fonts.INSTANCE.getMainFont20());

        LoginButton.setBorderPainted(false);      //버튼 테두리 없에기
        LoginButton.setContentAreaFilled(false);
        //LoginButton.setFocusPainted(false);
        LoginButton.setActionCommand("signIn");
        LoginButton.addActionListener(this);

        RegisterButton = new JButton("회원가입");
        RegisterButton.setBounds(285, 540, 130, 34);
        RegisterButton.setFont(Fonts.INSTANCE.getMainFont20());

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


    /**
     * 이벤트 처리
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        try {
            switch (event) {
                case "signIn":
                    Response<TokenDto> response = RetrofitProvider.INSTANCE.getUserRetrofit().login(tx_ID.getText(), tx_PassWord.getText()).execute();

                    //  로그인 실패
                    if (response.code() != 200) {
                        JOptionPane.showMessageDialog(null, "로그인 실패");
                        return;
                    }

                    // Auth 싱글턴 객체에 아이디, 비밀번호, 토큰 저장
                    Auth.INSTANCE.setEmail(tx_ID.getText());
                    Auth.INSTANCE.setPassword(tx_PassWord.getText());
                    Auth.INSTANCE.setToken("Bearer " + response.body().getToken());

                    // 사용자 정보 요청
                    Response<UserInfoDto> response2 = RetrofitProvider.INSTANCE.getUserRetrofit().getUser("Bearer " + response.body().getToken()).execute();

                    //  사용자 정보 저장
                    if (response2.code() != 200) {
                        JOptionPane.showMessageDialog(null, "사용자 정보 요청 실패");
                        return;
                    }
                    // 사용자 정보 저장
                    Auth.INSTANCE.setUser(response2.body());

                    // 메인 페이지로 이동
                    new MainPage();
                    this.dispose();
                    break;
                case "signUp":
                    dispose();
                    new SignUpPage();
                    break;
                default:
                    logger.error("알 수 없는 이벤트 발생");
                    break;
            }
        } catch (Exception t) {
            logger.error(t.getMessage());
        }
    }
}


