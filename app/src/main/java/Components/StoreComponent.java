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
       // ImageIcon image2;
        //Image temp;
        try {
            image = new ImageIcon(new URL(item.getImage()));
            /////////////////////////////////
           /* temp=image.getImage();
            temp.getScaledInstance(80,80,Image.SCALE_SMOOTH);
            image2=new ImageIcon(temp);*/

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
       /* JLabel label=(JLabel)super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        label.setIcon(image);
        label.setText(item.getName());*/
        this.setText(item.getName());
        this.setIcon(image);

        return this;

    }

}
