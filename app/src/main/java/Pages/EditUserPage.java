package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class EditUserPage extends JFrame implements ActionListener{

        public EditUserPage() {
        setTitle("EditUser Screen");
        setSize(1280, 720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color mint = new Color(62,185,180);

        JPanel panelMainWhite = new JPanel();            //배경 만들기
        panelMainWhite.setBounds(30,30,1204,614);
        panelMainWhite.setBackground(Color.white);

        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);
        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
    }
}
