package org.example.view.components;

import org.example.data.dto.store.StoreHeaderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StoreComponent extends DefaultListCellRenderer {
    private final Logger logger = LoggerFactory.getLogger(StoreComponent.class);

    //@Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        StoreHeaderDto item = (StoreHeaderDto) value;
        ImageIcon image;
        Image temp;

        try {
            item.getImage();
            image = new ImageIcon(new URL(item.getImage()));
            temp = image.getImage();
            temp = temp.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            image = new ImageIcon(temp);
            this.setIcon(image);
        } catch (Exception e) {
            logger.error("Failed to load image: {}", e.getMessage());
            image = new ImageIcon("app/res/bibimbap.png");
            temp = image.getImage();
            temp = temp.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            image = new ImageIcon(temp);
            this.setIcon(image);
        }


        this.setText("<html><div><h2>" + item.getName() + "</h2>" + item.getDescription() + "</div></html>");

        return this;
    }
}
