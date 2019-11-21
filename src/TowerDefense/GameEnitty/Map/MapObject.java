package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;

public abstract class MapObject extends JPanel {
    protected Image im;
    protected Point pos;

    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(),64,64, this);
        //something
    }

    public Point getPos() {
        return this.pos;
    }
}
