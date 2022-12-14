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
    private boolean isMaster;
    public ReviewComponent(boolean isMaster){this.isMaster=isMaster;}
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

        if(item.getUpk().equals(SingleTon.getUser().getUpk())) {
            JButton updateReview = new JButton("리뷰 수정/삭제");
            updateReview.setBounds(400, 10, 50, 30);
            //updateReview.setFont(mainFont18);
            updateReview.setBackground(Color.CYAN);
            itemPanel.add(updateReview);
        }

        else if(isMaster||SingleTon.getUser().getUpk()==1L){
            JButton updateMenu = new JButton("리뷰 삭제");
            updateMenu.setBounds(400, 10, 50, 30);
            updateMenu.setBackground(Color.CYAN);
            itemPanel.add(updateMenu);
        }

      /* this.setText(item.getTitle());
        this.setIcon(image);*/

        return itemPanel;
    }
}
