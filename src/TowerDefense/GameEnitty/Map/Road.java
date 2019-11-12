package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Road extends MapObject {
    Image im;
    Point pos;

    public Road(Point pos) {
        ImageIcon icon =  new ImageIcon("res/map/road.png");
        this.im = icon.getImage();
        this.pos    = pos;
    }

    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(), this);
    }
}