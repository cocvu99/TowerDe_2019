package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;

public class Target extends MapObject {


    public Target(Point pos) {
        ImageIcon icon =  new ImageIcon("res/map/target.png");
        this.im = icon.getImage();
        this.pos    = pos;
    }
    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(), this);
    }
}
