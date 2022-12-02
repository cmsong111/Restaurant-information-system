package Components;

import DTO.MenuDTO;
import DTO.StoreDTO;
import Pages.StoreDetail;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuComponent extends JLabel implements ListCellRenderer {
    private JLabel icon=new JLabel();
    private JLabel content=new JLabel();
    private boolean isMaster;
    public MenuComponent(boolean isMater){this.isMaster=isMater;}
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
        JPanel itemPanel=new JPanel();
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBounds(0,0,500,100);
        icon.setBounds(10,10,50,50);
        content.setBounds(250,50,50,20);
        icon.setIcon(image);
        content.setText(item.getName());
        itemPanel.add(icon);
        itemPanel.add(content);

        if(isMaster) {
            JButton updateMenu = new JButton("메뉴 수정/삭제");
            updateMenu.setBounds(400, 10, 50, 30);
            updateMenu.setBackground(Color.CYAN);
            itemPanel.add(updateMenu);
        }

        return itemPanel;
    }
}
