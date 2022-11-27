package Components;

import DTO.StoreDTO;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class StoreComponent extends JLabel implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
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
    }
}
