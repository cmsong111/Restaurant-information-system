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
        JButton updateReview;
        JButton deleteReview;

       /* if(item.getUpk().equals(SingleTon.getUser().getUpk())){
            updateReview=new JButton("수정");
            deleteReview=new JButton("삭제");

            updateReview.setBounds(400,10,50,30);
            //updateReview.setFont(mainFont18);
            updateReview.setBackground(Color.CYAN);
            updateReview.setBorderPainted(false);         //버튼 테두리 없에기
            //buttonReview.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
            updateReview.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
            //updateReview.setActionCommand("ReviewPage");
            //updateReview.addActionListener(StoreDetail.);
            this.add(updateReview);
        }*/
        this.setText(item.getTitle());
        this.setIcon(image);

        return this;
    }
}
