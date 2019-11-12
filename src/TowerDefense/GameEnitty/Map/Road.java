package TowerDefense.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;

public class Road extends GameMap {

    public Road() {
        this.im = new ImageIcon("/map/road.png").getImage();
    }


    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(), this);
    }
}