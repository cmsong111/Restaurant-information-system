package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMap extends JFrame implements ActionListener {

    public ViewMap(){
        try {
            setTitle("MAP");
            setSize(600,600);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }catch (Exception e){}
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();


    }
}
