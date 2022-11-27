package Components;

import javax.swing.*;
import java.awt.*;

public class StoreComponent extends DefaultListCellRenderer {
    //@Override
  /*  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        StoreDTO item = (StoreDTO) value;
        Icon image;
        try {
            image = new ImageIcon(new URL(item.getImage()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.setText(item.getName());
        this.setIcon(image);

        return this;
    }*/

    //Renderer
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        Font font=new Font("배달의민족 도현",Font.PLAIN,22);
       JLabel label= (JLabel)super.getListCellRendererComponent(list, value,index,isSelected, cellHasFocus);

       return label;
    }



}
