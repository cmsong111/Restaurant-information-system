package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import Pages.StoreDetail;
import DTO.StoreDTO;
public class StoreComponent extends DefaultListCellRenderer {
    //@Override
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        StoreDTO item = (StoreDTO) value;
        ImageIcon image;
        /*ImageIcon changedImage; //크기 변환된 이미지
        Image temp;
        Image changedtemp;*/
        try {
            if(item.getImage()!=null){
            image = new ImageIcon(new URL(item.getImage()));
            StoreDetail.storeLogo=image;}
            else{
                image=new ImageIcon("app/res/bibimbap.png");
                StoreDetail.storeLogo=image;
            }
           /* temp=image.getImage();
            temp=temp.getScaledInstance(100,100,Image.SCALE_SMOOTH);
            changedImage=new ImageIcon(temp);*/
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.setText(item.getName());
        this.setIcon(image);

        return this;
    }
}
