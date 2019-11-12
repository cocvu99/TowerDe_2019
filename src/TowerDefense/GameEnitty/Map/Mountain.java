package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Mountain extends MapObject {
    Image im;
    Point pos;

    public Mountain(Point pos) {
        ImageIcon icon =  new ImageIcon("res/map/mountain.png");
        this.im = icon.getImage();
        this.pos    = pos;
    }
    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(), this);
    }
}
