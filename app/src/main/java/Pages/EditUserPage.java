package Pages;

import DTO.UserDTO;
import HTTP.UserHTTP;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class EditUserPage extends JFrame implements ActionListener {
    JTextField textName;
    JPasswordField textPassWord;
    JPasswordField textPassWord2;
    JTextField textAge;
    JCheckBox checkBoxAdmin;
    UserDTO myInfo;
    UserHTTP user=new UserHTTP();
    boolean result;
    public EditUserPage() {
        try {
            EditUserPage();
        } catch (Exception e) {
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
        panelMainMint.setBounds(322, 30, 620, 80);
        panelMainMint.setBackground(mint);

        JLabel labelMain = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setBounds(382, 30, 500, 70);         //나머지 페이지들도 적용
        labelMain.setFont(mainFont40);

        JLabel labelUnderMain = new JLabel("-유저 정보 수정-");
        labelUnderMain.setHorizontalAlignment(JLabel.CENTER);
        labelUnderMain.setBounds(382, 100, 500, 100);
        labelUnderMain.setFont(mainFont26);

        textName = new JTextField(SingleTon.getUser().getName());
        textName.setBounds(482, 220, 300, 43);
        textName.setFont(mainFont22);
        textName.setBackground(Color.white);
        textName.setForeground(gray1);
        textName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textPassWord = new JPasswordField("비밀번호");
        textPassWord.setBounds(482, 280, 300, 43);
        textPassWord.setFont(mainFont22);
        textPassWord.setForeground(gray1);
        textPassWord.setBackground(Color.white);
        textPassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textPassWord2 = new JPasswordField("비밀번호 재입력");
        textPassWord2.setBounds(482, 340, 300, 43);
        textPassWord2.setFont(mainFont22);
        textPassWord2.setForeground(gray1);
        textPassWord2.setBackground(Color.white);
        textPassWord2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        textAge = new JTextField(String.valueOf(SingleTon.getUser().getAge()));
        textAge.setBounds(482, 400, 300, 43);
        textAge.setFont(mainFont22);
        textAge.setForeground(gray1);
        textAge.setBackground(Color.white);
        textAge.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JPanel lineName = new JPanel();
        lineName.setBounds(482, 265, 300, 2);
        JPanel linePassWord = new JPanel();
        linePassWord.setBounds(482, 325, 300, 2);

        checkBoxAdmin = new JCheckBox("관리자 지정");
        checkBoxAdmin.setSelected(SingleTon.getUser().isAdmin());
        checkBoxAdmin.setBounds(482, 450, 170, 34);
        checkBoxAdmin.setFont(mainFont18);
        checkBoxAdmin.setBorderPainted(false);      //버튼 테두리 없에기
        //checkBoxAdmin.setFocusPainted(false);
        checkBoxAdmin.setContentAreaFilled(false);
        checkBoxAdmin.setActionCommand("setAdmin");
        checkBoxAdmin.addActionListener(this);

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572, 600, 120, 30);
        buttonBack.setFont(mainFont22);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        JButton buttonSave = new JButton("저장하기");
        buttonSave.setBounds(500, 540, 120, 30);
        buttonSave.setFont(mainFont22);
        buttonSave.setBackground(mint);
        buttonSave.setBorderPainted(false);         //버튼 테두리 없에기
        buttonSave.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonSave.setBackground(mint);
        buttonSave.setActionCommand("Save");
        buttonSave.addActionListener(this);

        JButton buttonWithdraw = new JButton("탈퇴하기");
        buttonWithdraw.setBounds(630, 540, 120, 30);
        buttonWithdraw.setFont(mainFont22);
        buttonWithdraw.setBackground(mint);
        buttonWithdraw.setBorderPainted(false);         //버튼 테두리 없에기
        buttonWithdraw.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        buttonWithdraw.setBackground(mint);
        buttonWithdraw.setActionCommand("Withdraw");
        buttonWithdraw.addActionListener(this);


        getContentPane().add(labelMain);
        getContentPane().add(labelUnderMain);
        getContentPane().add(textName);
        getContentPane().add(textPassWord);
        getContentPane().add(textPassWord2);
        getContentPane().add(textAge);
        getContentPane().add(checkBoxAdmin);
        getContentPane().add(buttonBack);
        getContentPane().add(buttonSave);
        getContentPane().add(buttonWithdraw);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        UserHTTP userHTTP = new UserHTTP();
        if (event.equals("setAdmin")) {

        }
        if (event.equals("BackPage")) {
            dispose();
            MainPage MP=new MainPage();
        }
        if (event.equals("Save")) {
            if (textPassWord.getText().equals(textPassWord2.getText())) {
                try {
                    UserDTO newUserDTO = SingleTon.getUser();
                    newUserDTO.setName(textName.getText());
                    newUserDTO.setPassword(textPassWord2.getText());
                    newUserDTO.setAge(Integer.parseInt(textAge.getText()));
                    newUserDTO.setAdmin(checkBoxAdmin.isSelected());

                    newUserDTO = userHTTP.editUser(newUserDTO);
                    if(newUserDTO.getUpk()!=0L){
                        SingleTon.setUser(newUserDTO);
                        JOptionPane.showMessageDialog(null, "저장 되었습니다.");
                        this.setVisible(false);
                        MainPage mp = new MainPage();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "저장에 실패하였습니다..");

                    }


                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            } else {
                JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.");
            }
        }
        if(event.equals("Withdraw")){
            try {
                myInfo = UserDTO.builder()
                        .name(SingleTon.getUser().getName())
                        .id(SingleTon.getUser().getId())
                        .upk(SingleTon.getUser().getUpk())
                        .build();
                result=user.withdrawal(myInfo);
            }catch (IOException t){}
            if(result) {
                JOptionPane.showMessageDialog(null, "계정이 성공적으로 삭제되었습니다");
                dispose();
                LoginPage LP = new LoginPage();
            }
            else{
                JOptionPane.showMessageDialog(null, "삭제 실패");
            }
        }
    }
}
