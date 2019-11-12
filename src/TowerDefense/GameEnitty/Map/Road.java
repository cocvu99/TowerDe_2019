package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {

    private Image road1, road2, road3,road4,road5,road6;

    public Road() {
        ImageIcon imageIcon1 = new ImageIcon("image/duong1.png");
        road1 = imageIcon1.getImage();
        ImageIcon imageIcon2 = new ImageIcon("image/duong2.png");
        road2 = imageIcon2.getImage();
        ImageIcon imageIcon3 = new ImageIcon("image/duong3.png");
        road3 = imageIcon3.getImage();
        ImageIcon imageIcon4 = new ImageIcon("image/duong4.png");
        road4 = imageIcon4.getImage();
        ImageIcon imageIcon5 = new ImageIcon("image/duong5.png");
        road5 = imageIcon5.getImage();
        ImageIcon imageIcon6 = new ImageIcon("image/duong6.png");
        road6 = imageIcon6.getImage();
    }

    public void paint(Graphics g) {
        g.drawImage(road1, 0, 70, this);
        g.drawImage(road2,840,130,this);
        g.drawImage(road3, 340, 220, this);
        g.drawImage(road4,280,220,this);
        g.drawImage(road5,100,320,this);
        g.drawImage(road6,100,380,this);
        g.drawImage(road1,100,480,this);
    }
}