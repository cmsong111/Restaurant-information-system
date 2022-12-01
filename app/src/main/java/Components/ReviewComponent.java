package Components;

import DTO.MenuDTO;
import DTO.ReviewDTO;
import Pages.StoreDetail;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ReviewComponent extends JLabel implements ListCellRenderer {
    private JLabel icon=new JLabel();
    private JLabel content=new JLabel();

    //TODO:패널 생성하여 반환
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        ReviewDTO item = (ReviewDTO) value;
        Icon image;

        try {
            if(item.getImage()!=null){
            image = new ImageIcon(new URL(item.getImage()));}
            else{
                image=new ImageIcon("app/res/bibimbap.png");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
      JPanel itemPanel=new JPanel();
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBounds(0,0,500,100);
        icon.setBounds(10,10,50,50);
        content.setBounds(250,50,50,20);
        icon.setIcon(image);
        content.setText(item.getTitle());
        itemPanel.add(icon);
        itemPanel.add(content);

        if(item.getUpk().equals(SingleTon.getUser().getUpk())||item.getSpk().equals(SingleTon.getUser().getSpk())) {
            JButton updateReview = new JButton("리뷰 수정/삭제");
            updateReview.setBounds(400, 10, 50, 30);
            //updateReview.setFont(mainFont18);
            updateReview.setBackground(Color.CYAN);
            itemPanel.add(updateReview);
        }

      /* this.setText(item.getTitle());
        this.setIcon(image);*/

        return itemPanel;
    }
}
