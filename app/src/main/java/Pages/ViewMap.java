package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

import HTTP.*;


public class ViewMap extends JFrame implements ActionListener {

    public ViewMap() {
        try {
            setTitle("MAP");
            setSize(1000, 600);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            NaverMapAPI ds = new NaverMapAPI();

            BufferedImage image = ds.getStaticMAP(StoreDetail.currentStore.getLocationX(), StoreDetail.currentStore.getLocationY());

            JLabel labelImageS1 = new JLabel(new ImageIcon(image));
            labelImageS1.setBounds(0, 0, 1000, 600);

            getContentPane().add(labelImageS1);

            setResizable(false);    //화면 크기 고정
            setVisible(true);

        } catch (Exception e) {
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();

    }
}
