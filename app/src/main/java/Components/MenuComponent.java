package Components;

import DTO.MenuDTO;
import DTO.StoreDTO;
import Pages.StoreDetail;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuComponent extends JLabel implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        MenuDTO item = (MenuDTO) value;
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

        this.setText(item.getName());
        this.setIcon(image);

        return this;
    }
}
