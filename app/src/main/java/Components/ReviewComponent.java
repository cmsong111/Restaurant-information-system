package Components;

import DTO.MenuDTO;
import DTO.ReviewDTO;

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
            image = new ImageIcon(new URL(item.getImage()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.setText(item.getTitle());
        this.setIcon(image);

        return this;
    }
}
