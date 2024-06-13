package Pages.auth;

import DTO.UserInfoDto;
import DTO.UserRequestDto;
import Setting.Fonts;
import Setting.RetrofitProvider;
import api.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpPage extends JFrame implements ActionListener {


    JTextField textID;
    JTextField textPassWord;
    JTextField tx_Age;
    JButton RegisterButton;
    JTextField textName;

    private final UserRepository userRepository = RetrofitProvider.INSTANCE.getUserRetrofit();
    private final Logger logger = LoggerFactory.getLogger(SignUpPage.class);


    public SignUpPage() {


        setTitle("SignUpPage");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = Fonts.INSTANCE.getMainFont40();   //폰트 설정
        Font mainFont30 = Fonts.INSTANCE.getMainFont30();
        Font mainFont26 = Fonts.INSTANCE.getMainFont26();
        Font mainFont22 = Fonts.INSTANCE.getMainFont22();
        Font mainFont18 = Fonts.INSTANCE.getMainFont18();

        Color mint = new Color(62, 185, 180); //색상 정하기
        Color gray1 = new Color(192, 192, 192);

        JPanel panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30, 30, 1204, 614);
        panelMainWhite.setBackground(Color.white);

        JPanel panelMainMint = new JPanel();
        panelMainMint.setBounds(322, 30, 620, 80);
        panelMainMint.setBackground(mint);

        JLabel mainLabel = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(382, 30, 500, 70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);

        JLabel pageLabel = new JLabel("-회원가입-");
        pageLabel.setHorizontalAlignment(JLabel.CENTER);
        pageLabel.setBounds(382, 120, 500, 70);         //나머지 페이지들도 적용
        pageLabel.setFont(mainFont30);

        textName = new JTextField("이름");
        textName.setBounds(482, 220, 300, 43);
        textName.setFont(mainFont22);
        textName.setForeground(gray1);
        textName.setBorder(BorderFactory.createEmptyBorder());

        textID = new JTextField("아이디");
        textID.setBounds(482, 280, 300, 43);
        textID.setFont(mainFont22);
        textID.setForeground(gray1);
        textID.setBorder(BorderFactory.createEmptyBorder());

        textPassWord = new JTextField("비밀번호");
        textPassWord.setBounds(482, 340, 300, 43);
        textPassWord.setFont(mainFont22);
        textPassWord.setForeground(gray1);
        textPassWord.setBorder(BorderFactory.createEmptyBorder());

        tx_Age = new JTextField("나이");
        tx_Age.setBounds(482, 400, 300, 43);
        tx_Age.setFont(mainFont22);
        tx_Age.setForeground(gray1);
        tx_Age.setBorder(BorderFactory.createEmptyBorder());

        RegisterButton = new JButton("회원가입");
        RegisterButton.setBounds(563, 503, 138, 43);
        RegisterButton.setFont(mainFont22);
        RegisterButton.setBorderPainted(false);      //버튼 테두리 없에기
        //RegisterButton.setContentAreaFilled(false);
        //RegisterButton.setFocusPainted(false);
        RegisterButton.setForeground(Color.white);
        RegisterButton.setBackground(mint);
        RegisterButton.setActionCommand("Register");
        RegisterButton.addActionListener(this);

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572, 560, 120, 30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);


        JPanel lineName = new JPanel();
        lineName.setBounds(482, 265, 300, 2);
        JPanel lineID = new JPanel();
        lineID.setBounds(482, 325, 300, 2);
        JPanel linePW = new JPanel();
        linePW.setBounds(482, 385, 300, 2);
        JPanel lineAge = new JPanel();
        lineAge.setBounds(482, 445, 300, 2);


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

        try {
            switch (event) {
                // 회원가입 요청
                case "Register":
                    UserRequestDto userRequestDto = new UserRequestDto(
                            textName.getText(),
                            textID.getText(),
                            textPassWord.getText()
                    );
                    logger.info("회원가입 요청: {}", userRequestDto.toString());
                    Response<UserInfoDto> response = userRepository.register(userRequestDto).execute();
                    if (response.code() == 200) {
                        JOptionPane.showMessageDialog(null, "SIGNUP Successes.\nhello\n" + response.body().getName());
                        this.setVisible(false);
                        new LoginPage();
                    } else {
                        JOptionPane.showMessageDialog(null, "SIGNUP fail.");
                    }
                    break;
                // 뒤로가기
                case "BackPage":
                    dispose();
                    new LoginPage();
                    break;
                // 예외처리
                default:
                    logger.error("actionPerformed: {}", event);
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }
}
