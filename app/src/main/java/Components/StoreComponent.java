package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import DTO.StoreDTO;
public class StoreComponent extends DefaultListCellRenderer {
    //@Override
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        StoreDTO item = (StoreDTO) value;
        ImageIcon image;
        ImageIcon changedImage; //크기 변환된 이미지
        Image temp;
        Image changedtemp;
        try {
            image = new ImageIcon(new URL(item.getImage()));

            temp=image.getImage();
            temp=temp.getScaledInstance(100,100,Image.SCALE_SMOOTH);
            changedImage=new ImageIcon(temp);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.setText(item.getName());
        this.setIcon(changedImage);

        return this;

    }

}
