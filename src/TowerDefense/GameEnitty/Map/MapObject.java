package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class MapObject extends JPanel {
    protected Image im;
    protected Point pos;

    public MapObject() {}
    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(), this);
    }
}
