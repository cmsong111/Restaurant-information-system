package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import HTTP.*;


public class ViewMap extends JFrame implements ActionListener {

    public ViewMap(){
        try {
            setTitle("MAP");
            setSize(750,450);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            NaverMapAPI ds=new NaverMapAPI();
            String s=ds.getStaticMAP(StoreDetail.currentStore.getLocationX(), StoreDetail.currentStore.getLocationY());


            JLabel labelImageS1 = new JLabel(new ImageIcon(".\\location_Image.jpg"));
            labelImageS1.setBounds(0, 0, 750, 450);

            getContentPane().add(labelImageS1);

            setResizable(false);    //화면 크기 고정
            setVisible(true);

        }catch (Exception e){}


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();

    }
}